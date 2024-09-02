package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.b;
import androidx.core.content.a;
import androidx.core.util.d;

public abstract class k<E> extends g {

    /* renamed from: e  reason: collision with root package name */
    private final Activity f2318e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f2319f;

    /* renamed from: g  reason: collision with root package name */
    private final Handler f2320g;

    /* renamed from: h  reason: collision with root package name */
    private final int f2321h;

    /* renamed from: i  reason: collision with root package name */
    final n f2322i;

    k(Activity activity, Context context, Handler handler, int i5) {
        this.f2322i = new o();
        this.f2318e = activity;
        this.f2319f = (Context) d.i(context, "context == null");
        this.f2320g = (Handler) d.i(handler, "handler == null");
        this.f2321h = i5;
    }

    k(e eVar) {
        this(eVar, eVar, new Handler(), 0);
    }

    public View c(int i5) {
        return null;
    }

    public boolean d() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public Activity e() {
        return this.f2318e;
    }

    /* access modifiers changed from: package-private */
    public Context f() {
        return this.f2319f;
    }

    /* access modifiers changed from: package-private */
    public Handler g() {
        return this.f2320g;
    }

    public abstract E h();

    public LayoutInflater i() {
        return LayoutInflater.from(this.f2319f);
    }

    @Deprecated
    public void j(Fragment fragment, String[] strArr, int i5) {
    }

    public boolean k(Fragment fragment) {
        return true;
    }

    public boolean l(String str) {
        return false;
    }

    public void m(Fragment fragment, Intent intent, int i5, Bundle bundle) {
        if (i5 == -1) {
            a.h(this.f2319f, intent, bundle);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    @Deprecated
    public void n(Fragment fragment, IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8, Bundle bundle) {
        if (i5 == -1) {
            b.t(this.f2318e, intentSender, i5, intent, i6, i7, i8, bundle);
        } else {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
    }

    public void o() {
    }
}
