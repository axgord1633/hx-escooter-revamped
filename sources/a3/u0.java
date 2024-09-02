package a3;

import java.util.concurrent.atomic.AtomicReference;
import m2.n;
import m2.p;
import m2.q;
import p2.c;

public final class u0<T> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final q f362f;

    static final class a<T> extends AtomicReference<c> implements p<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f363e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<c> f364f = new AtomicReference<>();

        a(p<? super T> pVar) {
            this.f363e = pVar;
        }

        public void a() {
            this.f363e.a();
        }

        /* access modifiers changed from: package-private */
        public void b(c cVar) {
            s2.c.o(this, cVar);
        }

        public void c(c cVar) {
            s2.c.o(this.f364f, cVar);
        }

        public void d(T t5) {
            this.f363e.d(t5);
        }

        public void dispose() {
            s2.c.c(this.f364f);
            s2.c.c(this);
        }

        public boolean f() {
            return s2.c.i((c) get());
        }

        public void onError(Throwable th) {
            this.f363e.onError(th);
        }
    }

    final class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        private final a<T> f365e;

        b(a<T> aVar) {
            this.f365e = aVar;
        }

        public void run() {
            u0.this.f24e.g(this.f365e);
        }
    }

    public u0(n<T> nVar, q qVar) {
        super(nVar);
        this.f362f = qVar;
    }

    public void v0(p<? super T> pVar) {
        a aVar = new a(pVar);
        pVar.c(aVar);
        aVar.b(this.f362f.c(new b(aVar)));
    }
}
