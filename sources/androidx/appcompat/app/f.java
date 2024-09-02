package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.q1;
import h.b;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import m.b;

public abstract class f {

    /* renamed from: e  reason: collision with root package name */
    private static int f623e = -100;

    /* renamed from: f  reason: collision with root package name */
    private static final b<WeakReference<f>> f624f = new b<>();

    /* renamed from: g  reason: collision with root package name */
    private static final Object f625g = new Object();

    f() {
    }

    public static void B(boolean z4) {
        q1.b(z4);
    }

    static void c(f fVar) {
        synchronized (f625g) {
            z(fVar);
            f624f.add(new WeakReference(fVar));
        }
    }

    public static f g(Activity activity, e eVar) {
        return new g(activity, eVar);
    }

    public static f h(Dialog dialog, e eVar) {
        return new g(dialog, eVar);
    }

    public static int j() {
        return f623e;
    }

    static void y(f fVar) {
        synchronized (f625g) {
            z(fVar);
        }
    }

    private static void z(f fVar) {
        synchronized (f625g) {
            Iterator<WeakReference<f>> it = f624f.iterator();
            while (it.hasNext()) {
                f fVar2 = (f) it.next().get();
                if (fVar2 == fVar || fVar2 == null) {
                    it.remove();
                }
            }
        }
    }

    public abstract boolean A(int i5);

    public abstract void C(int i5);

    public abstract void D(View view);

    public abstract void E(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void F(Toolbar toolbar);

    public void G(int i5) {
    }

    public abstract void H(CharSequence charSequence);

    public abstract h.b I(b.a aVar);

    public abstract void d(View view, ViewGroup.LayoutParams layoutParams);

    @Deprecated
    public void e(Context context) {
    }

    public Context f(Context context) {
        e(context);
        return context;
    }

    public abstract <T extends View> T i(int i5);

    public abstract b k();

    public int l() {
        return -100;
    }

    public abstract MenuInflater m();

    public abstract a n();

    public abstract void o();

    public abstract void p();

    public abstract void q(Configuration configuration);

    public abstract void r(Bundle bundle);

    public abstract void s();

    public abstract void t(Bundle bundle);

    public abstract void u();

    public abstract void v(Bundle bundle);

    public abstract void w();

    public abstract void x();
}
