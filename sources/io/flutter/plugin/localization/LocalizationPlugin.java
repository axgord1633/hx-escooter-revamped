package io.flutter.plugin.localization;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import com.yalantis.ucrop.BuildConfig;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LocalizationPlugin {
    /* access modifiers changed from: private */
    public final Context context;
    private final LocalizationChannel localizationChannel;
    final LocalizationChannel.LocalizationMessageHandler localizationMessageHandler;

    public LocalizationPlugin(Context context2, LocalizationChannel localizationChannel2) {
        AnonymousClass1 r02 = new LocalizationChannel.LocalizationMessageHandler() {
            public String getStringResource(String str, String str2) {
                Context access$000 = LocalizationPlugin.this.context;
                if (str2 != null) {
                    Locale localeFromString = LocalizationPlugin.localeFromString(str2);
                    Configuration configuration = new Configuration(LocalizationPlugin.this.context.getResources().getConfiguration());
                    configuration.setLocale(localeFromString);
                    access$000 = LocalizationPlugin.this.context.createConfigurationContext(configuration);
                }
                int identifier = access$000.getResources().getIdentifier(str, "string", LocalizationPlugin.this.context.getPackageName());
                if (identifier != 0) {
                    return access$000.getResources().getString(identifier);
                }
                return null;
            }
        };
        this.localizationMessageHandler = r02;
        this.context = context2;
        this.localizationChannel = localizationChannel2;
        localizationChannel2.setLocalizationMessageHandler(r02);
    }

    public static Locale localeFromString(String str) {
        String str2;
        String[] split = str.replace('_', '-').split("-", -1);
        String str3 = split[0];
        int length = split.length;
        String str4 = BuildConfig.FLAVOR;
        int i5 = 1;
        if (length <= 1 || split[1].length() != 4) {
            str2 = str4;
        } else {
            str2 = split[1];
            i5 = 2;
        }
        if (split.length > i5 && split[i5].length() >= 2 && split[i5].length() <= 3) {
            str4 = split[i5];
        }
        return new Locale(str3, str4, str2);
    }

    public Locale resolveNativeLocale(List<Locale> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 26) {
            ArrayList arrayList = new ArrayList();
            LocaleList a5 = this.context.getResources().getConfiguration().getLocales();
            int size = a5.size();
            for (int i6 = 0; i6 < size; i6++) {
                Locale locale = a5.get(i6);
                String language = locale.getLanguage();
                if (!locale.getScript().isEmpty()) {
                    language = language + "-" + locale.getScript();
                }
                if (!locale.getCountry().isEmpty()) {
                    language = language + "-" + locale.getCountry();
                }
                arrayList.add(new Locale.LanguageRange(language));
                arrayList.add(new Locale.LanguageRange(locale.getLanguage()));
                arrayList.add(new Locale.LanguageRange(locale.getLanguage() + "-*"));
            }
            Locale a6 = Locale.lookup(arrayList, list);
            if (a6 != null) {
                return a6;
            }
        } else if (i5 >= 24) {
            LocaleList a7 = this.context.getResources().getConfiguration().getLocales();
            for (int i7 = 0; i7 < a7.size(); i7++) {
                Locale locale2 = a7.get(i7);
                for (Locale next : list) {
                    if (locale2.equals(next)) {
                        return next;
                    }
                }
                for (Locale next2 : list) {
                    if (locale2.getLanguage().equals(next2.toLanguageTag())) {
                        return next2;
                    }
                }
                for (Locale next3 : list) {
                    if (locale2.getLanguage().equals(next3.getLanguage())) {
                        return next3;
                    }
                }
            }
        } else {
            Locale locale3 = this.context.getResources().getConfiguration().locale;
            if (locale3 != null) {
                for (Locale next4 : list) {
                    if (locale3.equals(next4)) {
                        return next4;
                    }
                }
                for (Locale next5 : list) {
                    if (locale3.getLanguage().equals(next5.toString())) {
                        return next5;
                    }
                }
            }
        }
        return list.get(0);
    }

    public void sendLocalesToFlutter(Configuration configuration) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList a5 = configuration.getLocales();
            int size = a5.size();
            for (int i5 = 0; i5 < size; i5++) {
                arrayList.add(a5.get(i5));
            }
        } else {
            arrayList.add(configuration.locale);
        }
        this.localizationChannel.sendLocales(arrayList);
    }
}
