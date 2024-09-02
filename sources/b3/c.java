package b3;

import java.util.concurrent.Callable;
import m2.r;
import m2.t;
import m2.v;
import s2.d;
import t2.b;

public final class c<T> extends r<T> {

    /* renamed from: e  reason: collision with root package name */
    final Callable<? extends v<? extends T>> f2983e;

    public c(Callable<? extends v<? extends T>> callable) {
        this.f2983e = callable;
    }

    /* access modifiers changed from: protected */
    public void D(t<? super T> tVar) {
        try {
            ((v) b.e(this.f2983e.call(), "The singleSupplier returned a null SingleSource")).d(tVar);
        } catch (Throwable th) {
            q2.b.b(th);
            d.n(th, tVar);
        }
    }
}
