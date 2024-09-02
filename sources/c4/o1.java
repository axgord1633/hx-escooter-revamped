package c4;

public class o1 extends s1 implements t {

    /* renamed from: f  reason: collision with root package name */
    private final boolean f3150f = z0();

    public o1(l1 l1Var) {
        super(true);
        Y(l1Var);
    }

    private final boolean z0() {
        s1 x4;
        q U = U();
        r rVar = U instanceof r ? (r) U : null;
        if (!(rVar == null || (x4 = rVar.x()) == null)) {
            while (!x4.R()) {
                q U2 = x4.U();
                r rVar2 = U2 instanceof r ? (r) U2 : null;
                if (rVar2 != null) {
                    x4 = rVar2.x();
                    if (x4 == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean R() {
        return this.f3150f;
    }

    public boolean S() {
        return true;
    }
}
