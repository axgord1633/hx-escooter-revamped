package b3;

import java.util.concurrent.Callable;
import m2.r;
import m2.t;
import s2.d;
import t2.b;

public final class i<T> extends r<T> {

    /* renamed from: e  reason: collision with root package name */
    final Callable<? extends Throwable> f3007e;

    public i(Callable<? extends Throwable> callable) {
        this.f3007e = callable;
    }

    /* access modifiers changed from: protected */
    public void D(t<? super T> tVar) {
        try {
            th = (Throwable) b.e(this.f3007e.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            q2.b.b(th);
        }
        d.n(th, tVar);
    }
}
