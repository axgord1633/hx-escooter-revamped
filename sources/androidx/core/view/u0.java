package androidx.core.view;

import android.view.KeyEvent;
import android.view.View;
import android.view.View$OnUnhandledKeyEventListener;
import androidx.core.view.k0;

public final /* synthetic */ class u0 implements View$OnUnhandledKeyEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k0.t f1992a;

    public /* synthetic */ u0(k0.t tVar) {
        this.f1992a = tVar;
    }

    public final boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
        return this.f1992a.onUnhandledKeyEvent(view, keyEvent);
    }
}
