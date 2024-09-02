package c4;

import c4.x0;
import java.util.concurrent.locks.LockSupport;

public abstract class y0 extends w0 {
    /* access modifiers changed from: protected */
    public abstract Thread Y();

    /* access modifiers changed from: protected */
    public void Z(long j5, x0.a aVar) {
        l0.f3140l.l0(j5, aVar);
    }

    /* access modifiers changed from: protected */
    public final void a0() {
        Thread Y = Y();
        if (Thread.currentThread() != Y) {
            c.a();
            LockSupport.unpark(Y);
        }
    }
}
