package a3;

import h3.a;
import java.util.concurrent.atomic.AtomicInteger;
import m2.k;
import m2.p;
import r2.e;

public final class c<T> extends k<T> {

    /* renamed from: e  reason: collision with root package name */
    final a<? extends T> f76e;

    /* renamed from: f  reason: collision with root package name */
    final int f77f;

    /* renamed from: g  reason: collision with root package name */
    final e<? super p2.c> f78g;

    /* renamed from: h  reason: collision with root package name */
    final AtomicInteger f79h = new AtomicInteger();

    public c(a<? extends T> aVar, int i5, e<? super p2.c> eVar) {
        this.f76e = aVar;
        this.f77f = i5;
        this.f78g = eVar;
    }

    public void v0(p<? super T> pVar) {
        this.f76e.g(pVar);
        if (this.f79h.incrementAndGet() == this.f77f) {
            this.f76e.Q0(this.f78g);
        }
    }
}
