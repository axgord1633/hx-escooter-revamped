package c4;

public abstract class v1 extends c0 {
    public abstract v1 P();

    /* access modifiers changed from: protected */
    public final String Q() {
        v1 v1Var;
        v1 c5 = t0.c();
        if (this == c5) {
            return "Dispatchers.Main";
        }
        try {
            v1Var = c5.P();
        } catch (UnsupportedOperationException unused) {
            v1Var = null;
        }
        if (this == v1Var) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    public String toString() {
        String Q = Q();
        if (Q != null) {
            return Q;
        }
        return k0.a(this) + '@' + k0.b(this);
    }
}
