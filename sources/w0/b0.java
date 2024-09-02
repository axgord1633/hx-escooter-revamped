package w0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.os.f;
import c1.d;
import java.util.Locale;
import m.g;
import s0.b;
import t0.i;

public final class b0 {

    /* renamed from: a  reason: collision with root package name */
    private static final g f7290a = new g();

    /* renamed from: b  reason: collision with root package name */
    private static Locale f7291b;

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            return d.a(context).b(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String b(Context context) {
        return context.getResources().getString(b.common_google_play_services_notification_channel_name);
    }

    public static String c(Context context, int i5) {
        return context.getResources().getString(i5 != 1 ? i5 != 2 ? i5 != 3 ? 17039370 : b.common_google_play_services_enable_button : b.common_google_play_services_update_button : b.common_google_play_services_install_button);
    }

    public static String d(Context context, int i5) {
        Resources resources = context.getResources();
        String a5 = a(context);
        if (i5 == 1) {
            return resources.getString(b.common_google_play_services_install_text, new Object[]{a5});
        } else if (i5 != 2) {
            if (i5 == 3) {
                return resources.getString(b.common_google_play_services_enable_text, new Object[]{a5});
            } else if (i5 == 5) {
                return h(context, "common_google_play_services_invalid_account_text", a5);
            } else {
                if (i5 == 7) {
                    return h(context, "common_google_play_services_network_error_text", a5);
                }
                if (i5 == 9) {
                    return resources.getString(b.common_google_play_services_unsupported_text, new Object[]{a5});
                } else if (i5 == 20) {
                    return h(context, "common_google_play_services_restricted_profile_text", a5);
                } else {
                    switch (i5) {
                        case 16:
                            return h(context, "common_google_play_services_api_unavailable_text", a5);
                        case 17:
                            return h(context, "common_google_play_services_sign_in_failed_text", a5);
                        case 18:
                            return resources.getString(b.common_google_play_services_updating_text, new Object[]{a5});
                        default:
                            return resources.getString(i.common_google_play_services_unknown_issue, new Object[]{a5});
                    }
                }
            }
        } else if (a1.d.c(context)) {
            return resources.getString(b.common_google_play_services_wear_update_text);
        } else {
            return resources.getString(b.common_google_play_services_update_text, new Object[]{a5});
        }
    }

    public static String e(Context context, int i5) {
        return (i5 == 6 || i5 == 19) ? h(context, "common_google_play_services_resolution_required_text", a(context)) : d(context, i5);
    }

    public static String f(Context context, int i5) {
        String i6 = i5 == 6 ? i(context, "common_google_play_services_resolution_required_title") : g(context, i5);
        return i6 == null ? context.getResources().getString(b.common_google_play_services_notification_ticker) : i6;
    }

    public static String g(Context context, int i5) {
        String str;
        Resources resources = context.getResources();
        switch (i5) {
            case 1:
                return resources.getString(b.common_google_play_services_install_title);
            case 2:
                return resources.getString(b.common_google_play_services_update_title);
            case 3:
                return resources.getString(b.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return i(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return i(context, "common_google_play_services_network_error_title");
            case 8:
                str = "Internal error occurred. Please see logs for detailed information";
                break;
            case 9:
                str = "Google Play services is invalid. Cannot recover.";
                break;
            case 10:
                str = "Developer error occurred. Please see logs for detailed information";
                break;
            case 11:
                str = "The application is not licensed to the user.";
                break;
            case 16:
                str = "One of the API components you attempted to connect to is not available.";
                break;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return i(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return i(context, "common_google_play_services_restricted_profile_title");
            default:
                str = "Unexpected error code " + i5;
                break;
        }
        Log.e("GoogleApiAvailability", str);
        return null;
    }

    private static String h(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String i5 = i(context, str);
        if (i5 == null) {
            i5 = resources.getString(i.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, i5, new Object[]{str2});
    }

    private static String i(Context context, String str) {
        g gVar = f7290a;
        synchronized (gVar) {
            Locale c5 = f.a(context.getResources().getConfiguration()).c(0);
            if (!c5.equals(f7291b)) {
                gVar.clear();
                f7291b = c5;
            }
            String str2 = (String) gVar.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources b5 = t0.f.b(context);
            if (b5 == null) {
                return null;
            }
            int identifier = b5.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                Log.w("GoogleApiAvailability", "Missing resource: " + str);
                return null;
            }
            String string = b5.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                Log.w("GoogleApiAvailability", "Got empty resource: " + str);
                return null;
            }
            gVar.put(str, string);
            return string;
        }
    }
}
