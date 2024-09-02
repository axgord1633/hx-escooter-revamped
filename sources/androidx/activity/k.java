package androidx.activity;

import android.window.OnBackInvokedCallback;
import androidx.activity.OnBackPressedDispatcher;
import v3.a;

public final /* synthetic */ class k implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f511a;

    public /* synthetic */ k(a aVar) {
        this.f511a = aVar;
    }

    public final void onBackInvoked() {
        OnBackPressedDispatcher.c.c(this.f511a);
    }
}
