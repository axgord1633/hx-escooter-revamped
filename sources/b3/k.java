package b3;

import j3.a;
import java.util.concurrent.Callable;
import m2.r;
import m2.t;
import p2.c;
import p2.d;
import t2.b;

public final class k<T> extends r<T> {

    /* renamed from: e  reason: collision with root package name */
    final Callable<? extends T> f3014e;

    public k(Callable<? extends T> callable) {
        this.f3014e = callable;
    }

    /* access modifiers changed from: protected */
    public void D(t<? super T> tVar) {
        c b5 = d.b();
        tVar.c(b5);
        if (!b5.f()) {
            try {
                Object e5 = b.e(this.f3014e.call(), "The callable returned a null value");
                if (!b5.f()) {
                    tVar.b(e5);
                }
            } catch (Throwable th) {
                q2.b.b(th);
                if (!b5.f()) {
                    tVar.onError(th);
                } else {
                    a.r(th);
                }
            }
        }
    }
}
