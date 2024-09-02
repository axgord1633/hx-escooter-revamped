package v2;

import java.util.concurrent.atomic.AtomicReference;
import m2.t;
import p2.c;

public final class i<T> implements t<T> {

    /* renamed from: e  reason: collision with root package name */
    final AtomicReference<c> f7274e;

    /* renamed from: f  reason: collision with root package name */
    final t<? super T> f7275f;

    public i(AtomicReference<c> atomicReference, t<? super T> tVar) {
        this.f7274e = atomicReference;
        this.f7275f = tVar;
    }

    public void b(T t5) {
        this.f7275f.b(t5);
    }

    public void c(c cVar) {
        s2.c.l(this.f7274e, cVar);
    }

    public void onError(Throwable th) {
        this.f7275f.onError(th);
    }
}
