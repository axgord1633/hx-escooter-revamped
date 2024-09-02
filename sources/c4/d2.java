package c4;

import o3.g;

public final class d2 extends c0 {

    /* renamed from: g  reason: collision with root package name */
    public static final d2 f3116g = new d2();

    private d2() {
    }

    public void M(g gVar, Runnable runnable) {
        g2 g2Var = (g2) gVar.d(g2.f3122g);
        if (g2Var != null) {
            g2Var.f3123f = true;
            return;
        }
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    public boolean N(g gVar) {
        return false;
    }

    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
