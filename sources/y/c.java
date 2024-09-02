package y;

import android.os.Bundle;
import androidx.lifecycle.f;
import androidx.savedstate.Recreator;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public final class c {

    /* renamed from: d  reason: collision with root package name */
    public static final a f7705d = new a((g) null);

    /* renamed from: a  reason: collision with root package name */
    private final d f7706a;

    /* renamed from: b  reason: collision with root package name */
    private final androidx.savedstate.a f7707b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7708c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final c a(d dVar) {
            k.e(dVar, "owner");
            return new c(dVar, (g) null);
        }
    }

    private c(d dVar) {
        this.f7706a = dVar;
        this.f7707b = new androidx.savedstate.a();
    }

    public /* synthetic */ c(d dVar, g gVar) {
        this(dVar);
    }

    public static final c a(d dVar) {
        return f7705d.a(dVar);
    }

    public final androidx.savedstate.a b() {
        return this.f7707b;
    }

    public final void c() {
        f lifecycle = this.f7706a.getLifecycle();
        if (lifecycle.b() == f.b.INITIALIZED) {
            lifecycle.a(new Recreator(this.f7706a));
            this.f7707b.e(lifecycle);
            this.f7708c = true;
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
    }

    public final void d(Bundle bundle) {
        if (!this.f7708c) {
            c();
        }
        f lifecycle = this.f7706a.getLifecycle();
        if (!lifecycle.b().f(f.b.STARTED)) {
            this.f7707b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
    }

    public final void e(Bundle bundle) {
        k.e(bundle, "outBundle");
        this.f7707b.g(bundle);
    }
}
