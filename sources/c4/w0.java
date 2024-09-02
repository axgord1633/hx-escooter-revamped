package c4;

import kotlinx.coroutines.internal.a;

public abstract class w0 extends c0 {

    /* renamed from: g  reason: collision with root package name */
    private long f3187g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3188h;

    /* renamed from: i  reason: collision with root package name */
    private a<q0<?>> f3189i;

    private final long Q(boolean z4) {
        return z4 ? 4294967296L : 1;
    }

    public static /* synthetic */ void U(w0 w0Var, boolean z4, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 1) != 0) {
                z4 = false;
            }
            w0Var.T(z4);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public final void P(boolean z4) {
        long Q = this.f3187g - Q(z4);
        this.f3187g = Q;
        if (Q <= 0 && this.f3188h) {
            shutdown();
        }
    }

    public final void R(q0<?> q0Var) {
        a<q0<?>> aVar = this.f3189i;
        if (aVar == null) {
            aVar = new a<>();
            this.f3189i = aVar;
        }
        aVar.a(q0Var);
    }

    /* access modifiers changed from: protected */
    public long S() {
        a<q0<?>> aVar = this.f3189i;
        return (aVar != null && !aVar.c()) ? 0 : Long.MAX_VALUE;
    }

    public final void T(boolean z4) {
        this.f3187g += Q(z4);
        if (!z4) {
            this.f3188h = true;
        }
    }

    public final boolean V() {
        return this.f3187g >= Q(true);
    }

    public final boolean W() {
        a<q0<?>> aVar = this.f3189i;
        if (aVar != null) {
            return aVar.c();
        }
        return true;
    }

    public final boolean X() {
        q0 d5;
        a<q0<?>> aVar = this.f3189i;
        if (aVar == null || (d5 = aVar.d()) == null) {
            return false;
        }
        d5.run();
        return true;
    }

    public void shutdown() {
    }
}
