package a3;

import java.util.concurrent.atomic.AtomicReference;
import m2.k;
import m2.n;
import m2.p;
import p2.c;
import r2.f;
import s2.d;

public final class n0<T, R> extends a<T, R> {

    /* renamed from: f  reason: collision with root package name */
    final f<? super k<T>, ? extends n<R>> f262f;

    static final class a<T, R> implements p<T> {

        /* renamed from: e  reason: collision with root package name */
        final l3.b<T> f263e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<c> f264f;

        a(l3.b<T> bVar, AtomicReference<c> atomicReference) {
            this.f263e = bVar;
            this.f264f = atomicReference;
        }

        public void a() {
            this.f263e.a();
        }

        public void c(c cVar) {
            s2.c.o(this.f264f, cVar);
        }

        public void d(T t5) {
            this.f263e.d(t5);
        }

        public void onError(Throwable th) {
            this.f263e.onError(th);
        }
    }

    static final class b<T, R> extends AtomicReference<c> implements p<R>, c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super R> f265e;

        /* renamed from: f  reason: collision with root package name */
        c f266f;

        b(p<? super R> pVar) {
            this.f265e = pVar;
        }

        public void a() {
            s2.c.c(this);
            this.f265e.a();
        }

        public void c(c cVar) {
            if (s2.c.q(this.f266f, cVar)) {
                this.f266f = cVar;
                this.f265e.c(this);
            }
        }

        public void d(R r5) {
            this.f265e.d(r5);
        }

        public void dispose() {
            this.f266f.dispose();
            s2.c.c(this);
        }

        public boolean f() {
            return this.f266f.f();
        }

        public void onError(Throwable th) {
            s2.c.c(this);
            this.f265e.onError(th);
        }
    }

    public n0(n<T> nVar, f<? super k<T>, ? extends n<R>> fVar) {
        super(nVar);
        this.f262f = fVar;
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super R> pVar) {
        l3.b Q0 = l3.b.Q0();
        try {
            n nVar = (n) t2.b.e(this.f262f.apply(Q0), "The selector returned a null ObservableSource");
            b bVar = new b(pVar);
            nVar.g(bVar);
            this.f24e.g(new a(Q0, bVar));
        } catch (Throwable th) {
            q2.b.b(th);
            d.m(th, pVar);
        }
    }
}
