package a3;

import java.util.concurrent.atomic.AtomicReference;
import m2.p;
import p2.c;

final class b1<T> implements p<T> {

    /* renamed from: e  reason: collision with root package name */
    final p<? super T> f74e;

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<c> f75f;

    b1(p<? super T> pVar, AtomicReference<c> atomicReference) {
        this.f74e = pVar;
        this.f75f = atomicReference;
    }

    public void a() {
        this.f74e.a();
    }

    public void c(c cVar) {
        s2.c.l(this.f75f, cVar);
    }

    public void d(T t5) {
        this.f74e.d(t5);
    }

    public void onError(Throwable th) {
        this.f74e.onError(th);
    }
}
