package io.flutter.embedding.android;

import android.view.textservice.SpellCheckerInfo;
import java.util.function.Predicate;

public final /* synthetic */ class j implements Predicate {
    public final boolean test(Object obj) {
        return ((SpellCheckerInfo) obj).getPackageName().equals("com.google.android.inputmethod.latin");
    }
}
