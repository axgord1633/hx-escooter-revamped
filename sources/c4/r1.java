package c4;

import kotlin.jvm.internal.k;

public abstract class r1 extends x implements u0, g1 {

    /* renamed from: h  reason: collision with root package name */
    public s1 f3155h;

    public boolean b() {
        return true;
    }

    public void dispose() {
        x().n0(this);
    }

    public w1 e() {
        return null;
    }

    public String toString() {
        return k0.a(this) + '@' + k0.b(this) + "[job@" + k0.b(x()) + ']';
    }

    public final s1 x() {
        s1 s1Var = this.f3155h;
        if (s1Var != null) {
            return s1Var;
        }
        k.o("job");
        return null;
    }

    public final void y(s1 s1Var) {
        this.f3155h = s1Var;
    }
}
