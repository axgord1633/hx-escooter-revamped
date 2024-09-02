package a3;

import j3.a;
import java.util.concurrent.Callable;
import m2.k;
import m2.p;
import t2.b;
import v2.f;

public final class y<T> extends k<T> implements Callable<T> {

    /* renamed from: e  reason: collision with root package name */
    final Callable<? extends T> f442e;

    public y(Callable<? extends T> callable) {
        this.f442e = callable;
    }

    public T call() {
        return b.e(this.f442e.call(), "The callable returned a null value");
    }

    public void v0(p<? super T> pVar) {
        f fVar = new f(pVar);
        pVar.c(fVar);
        if (!fVar.f()) {
            try {
                fVar.g(b.e(this.f442e.call(), "Callable returned null"));
            } catch (Throwable th) {
                q2.b.b(th);
                if (!fVar.f()) {
                    pVar.onError(th);
                } else {
                    a.r(th);
                }
            }
        }
    }
}
