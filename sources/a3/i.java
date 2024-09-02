package a3;

import java.util.concurrent.Callable;
import m2.k;
import m2.n;
import m2.p;
import s2.d;
import t2.b;

public final class i<T> extends k<T> {

    /* renamed from: e  reason: collision with root package name */
    final Callable<? extends n<? extends T>> f178e;

    public i(Callable<? extends n<? extends T>> callable) {
        this.f178e = callable;
    }

    public void v0(p<? super T> pVar) {
        try {
            ((n) b.e(this.f178e.call(), "null ObservableSource supplied")).g(pVar);
        } catch (Throwable th) {
            q2.b.b(th);
            d.m(th, pVar);
        }
    }
}
