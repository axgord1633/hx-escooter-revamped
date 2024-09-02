package androidx.activity;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.f;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import java.util.Collection;
import java.util.ListIterator;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import m3.q;
import n3.e;

public final class OnBackPressedDispatcher {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f482a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final e<j> f483b = new e<>();

    /* renamed from: c  reason: collision with root package name */
    private v3.a<q> f484c;

    /* renamed from: d  reason: collision with root package name */
    private OnBackInvokedCallback f485d;

    /* renamed from: e  reason: collision with root package name */
    private OnBackInvokedDispatcher f486e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f487f;

    private final class LifecycleOnBackPressedCancellable implements h, a {

        /* renamed from: e  reason: collision with root package name */
        private final f f488e;

        /* renamed from: f  reason: collision with root package name */
        private final j f489f;

        /* renamed from: g  reason: collision with root package name */
        private a f490g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f491h;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, f fVar, j jVar) {
            k.e(fVar, "lifecycle");
            k.e(jVar, "onBackPressedCallback");
            this.f491h = onBackPressedDispatcher;
            this.f488e = fVar;
            this.f489f = jVar;
            fVar.a(this);
        }

        public void a(j jVar, f.a aVar) {
            k.e(jVar, "source");
            k.e(aVar, "event");
            if (aVar == f.a.ON_START) {
                this.f490g = this.f491h.c(this.f489f);
            } else if (aVar == f.a.ON_STOP) {
                a aVar2 = this.f490g;
                if (aVar2 != null) {
                    aVar2.cancel();
                }
            } else if (aVar == f.a.ON_DESTROY) {
                cancel();
            }
        }

        public void cancel() {
            this.f488e.c(this);
            this.f489f.removeCancellable(this);
            a aVar = this.f490g;
            if (aVar != null) {
                aVar.cancel();
            }
            this.f490g = null;
        }
    }

    static final class a extends l implements v3.a<q> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f492e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(OnBackPressedDispatcher onBackPressedDispatcher) {
            super(0);
            this.f492e = onBackPressedDispatcher;
        }

        public final void a() {
            this.f492e.g();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return q.f5904a;
        }
    }

    static final class b extends l implements v3.a<q> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f493e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(OnBackPressedDispatcher onBackPressedDispatcher) {
            super(0);
            this.f493e = onBackPressedDispatcher;
        }

        public final void a() {
            this.f493e.e();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return q.f5904a;
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public static final c f494a = new c();

        private c() {
        }

        /* access modifiers changed from: private */
        public static final void c(v3.a aVar) {
            k.e(aVar, "$onBackInvoked");
            aVar.invoke();
        }

        public final OnBackInvokedCallback b(v3.a<q> aVar) {
            k.e(aVar, "onBackInvoked");
            return new k(aVar);
        }

        public final void d(Object obj, int i5, Object obj2) {
            k.e(obj, "dispatcher");
            k.e(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i5, (OnBackInvokedCallback) obj2);
        }

        public final void e(Object obj, Object obj2) {
            k.e(obj, "dispatcher");
            k.e(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    private final class d implements a {

        /* renamed from: e  reason: collision with root package name */
        private final j f495e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f496f;

        public d(OnBackPressedDispatcher onBackPressedDispatcher, j jVar) {
            k.e(jVar, "onBackPressedCallback");
            this.f496f = onBackPressedDispatcher;
            this.f495e = jVar;
        }

        public void cancel() {
            this.f496f.f483b.remove(this.f495e);
            this.f495e.removeCancellable(this);
            if (Build.VERSION.SDK_INT >= 33) {
                this.f495e.setEnabledChangedCallback$activity_release((v3.a<q>) null);
                this.f496f.g();
            }
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f482a = runnable;
        if (Build.VERSION.SDK_INT >= 33) {
            this.f484c = new a(this);
            this.f485d = c.f494a.b(new b(this));
        }
    }

    public final void b(j jVar, j jVar2) {
        k.e(jVar, "owner");
        k.e(jVar2, "onBackPressedCallback");
        f lifecycle = jVar.getLifecycle();
        if (lifecycle.b() != f.b.DESTROYED) {
            jVar2.addCancellable(new LifecycleOnBackPressedCancellable(this, lifecycle, jVar2));
            if (Build.VERSION.SDK_INT >= 33) {
                g();
                jVar2.setEnabledChangedCallback$activity_release(this.f484c);
            }
        }
    }

    public final a c(j jVar) {
        k.e(jVar, "onBackPressedCallback");
        this.f483b.add(jVar);
        d dVar = new d(this, jVar);
        jVar.addCancellable(dVar);
        if (Build.VERSION.SDK_INT >= 33) {
            g();
            jVar.setEnabledChangedCallback$activity_release(this.f484c);
        }
        return dVar;
    }

    public final boolean d() {
        e<j> eVar = this.f483b;
        if ((eVar instanceof Collection) && eVar.isEmpty()) {
            return false;
        }
        for (j isEnabled : eVar) {
            if (isEnabled.isEnabled()) {
                return true;
            }
        }
        return false;
    }

    public final void e() {
        j jVar;
        e<j> eVar = this.f483b;
        ListIterator<j> listIterator = eVar.listIterator(eVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                jVar = null;
                break;
            }
            jVar = listIterator.previous();
            if (jVar.isEnabled()) {
                break;
            }
        }
        j jVar2 = jVar;
        if (jVar2 != null) {
            jVar2.handleOnBackPressed();
            return;
        }
        Runnable runnable = this.f482a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void f(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        k.e(onBackInvokedDispatcher, "invoker");
        this.f486e = onBackInvokedDispatcher;
        g();
    }

    public final void g() {
        boolean d5 = d();
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f486e;
        OnBackInvokedCallback onBackInvokedCallback = this.f485d;
        if (onBackInvokedDispatcher != null && onBackInvokedCallback != null) {
            if (d5 && !this.f487f) {
                c.f494a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
                this.f487f = true;
            } else if (!d5 && this.f487f) {
                c.f494a.e(onBackInvokedDispatcher, onBackInvokedCallback);
                this.f487f = false;
            }
        }
    }
}
