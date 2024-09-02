package io.flutter.plugin.editing;

import android.os.Bundle;
import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import android.view.textservice.TextServicesManager;
import com.yalantis.ucrop.BuildConfig;
import io.flutter.embedding.engine.systemchannels.SpellCheckChannel;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.localization.LocalizationPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class SpellCheckPlugin implements SpellCheckChannel.SpellCheckMethodHandler, SpellCheckerSession.SpellCheckerSessionListener {
    public static final String END_INDEX_KEY = "endIndex";
    private static final int MAX_SPELL_CHECK_SUGGESTIONS = 5;
    public static final String START_INDEX_KEY = "startIndex";
    public static final String SUGGESTIONS_KEY = "suggestions";
    private final SpellCheckChannel mSpellCheckChannel;
    private SpellCheckerSession mSpellCheckerSession;
    private final TextServicesManager mTextServicesManager;
    MethodChannel.Result pendingResult;

    public SpellCheckPlugin(TextServicesManager textServicesManager, SpellCheckChannel spellCheckChannel) {
        this.mTextServicesManager = textServicesManager;
        this.mSpellCheckChannel = spellCheckChannel;
        spellCheckChannel.setSpellCheckMethodHandler(this);
    }

    public void destroy() {
        this.mSpellCheckChannel.setSpellCheckMethodHandler((SpellCheckChannel.SpellCheckMethodHandler) null);
        SpellCheckerSession spellCheckerSession = this.mSpellCheckerSession;
        if (spellCheckerSession != null) {
            spellCheckerSession.close();
        }
    }

    public void initiateSpellCheck(String str, String str2, MethodChannel.Result result) {
        if (this.pendingResult != null) {
            result.error("error", "Previous spell check request still pending.", (Object) null);
            return;
        }
        this.pendingResult = result;
        performSpellCheck(str, str2);
    }

    public void onGetSentenceSuggestions(SentenceSuggestionsInfo[] sentenceSuggestionsInfoArr) {
        ArrayList arrayList;
        MethodChannel.Result result;
        if (sentenceSuggestionsInfoArr.length == 0) {
            result = this.pendingResult;
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList();
            SentenceSuggestionsInfo sentenceSuggestionsInfo = sentenceSuggestionsInfoArr[0];
            if (sentenceSuggestionsInfo == null) {
                result = this.pendingResult;
                arrayList = new ArrayList();
            } else {
                for (int i5 = 0; i5 < sentenceSuggestionsInfo.getSuggestionsCount(); i5++) {
                    SuggestionsInfo suggestionsInfoAt = sentenceSuggestionsInfo.getSuggestionsInfoAt(i5);
                    int suggestionsCount = suggestionsInfoAt.getSuggestionsCount();
                    if (suggestionsCount > 0) {
                        HashMap hashMap = new HashMap();
                        int offsetAt = sentenceSuggestionsInfo.getOffsetAt(i5);
                        int lengthAt = sentenceSuggestionsInfo.getLengthAt(i5) + offsetAt;
                        hashMap.put(START_INDEX_KEY, Integer.valueOf(offsetAt));
                        hashMap.put(END_INDEX_KEY, Integer.valueOf(lengthAt));
                        ArrayList arrayList2 = new ArrayList();
                        boolean z4 = false;
                        for (int i6 = 0; i6 < suggestionsCount; i6++) {
                            String suggestionAt = suggestionsInfoAt.getSuggestionAt(i6);
                            if (!suggestionAt.equals(BuildConfig.FLAVOR)) {
                                arrayList2.add(suggestionAt);
                                z4 = true;
                            }
                        }
                        if (z4) {
                            hashMap.put(SUGGESTIONS_KEY, arrayList2);
                            arrayList.add(hashMap);
                        }
                    }
                }
                result = this.pendingResult;
            }
        }
        result.success(arrayList);
        this.pendingResult = null;
    }

    public void onGetSuggestions(SuggestionsInfo[] suggestionsInfoArr) {
    }

    public void performSpellCheck(String str, String str2) {
        Locale localeFromString = LocalizationPlugin.localeFromString(str);
        if (this.mSpellCheckerSession == null) {
            this.mSpellCheckerSession = this.mTextServicesManager.newSpellCheckerSession((Bundle) null, localeFromString, this, true);
        }
        this.mSpellCheckerSession.getSentenceSuggestions(new TextInfo[]{new TextInfo(str2)}, 5);
    }
}
