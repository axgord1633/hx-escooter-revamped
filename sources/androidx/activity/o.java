package androidx.activity;

import android.view.View;
import kotlin.jvm.internal.k;

public final class o {
    public static final void a(View view, l lVar) {
        k.e(view, "<this>");
        k.e(lVar, "onBackPressedDispatcherOwner");
        view.setTag(m.f513b, lVar);
    }
}
