package y2;

import java.util.concurrent.atomic.AtomicReference;
import m2.i;
import m2.j;
import m2.r;
import m2.t;
import m2.v;
import p2.c;

public final class f<T> extends r<T> {

    /* renamed from: e  reason: collision with root package name */
    final j<T> f7816e;

    /* renamed from: f  reason: collision with root package name */
    final v<? extends T> f7817f;

    static final class a<T> extends AtomicReference<c> implements i<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final t<? super T> f7818e;

        /* renamed from: f  reason: collision with root package name */
        final v<? extends T> f7819f;

        /* renamed from: y2.f$a$a  reason: collision with other inner class name */
        static final class C0126a<T> implements t<T> {

            /* renamed from: e  reason: collision with root package name */
            final t<? super T> f7820e;

            /* renamed from: f  reason: collision with root package name */
            final AtomicReference<c> f7821f;

            C0126a(t<? super T> tVar, AtomicReference<c> atomicReference) {
                this.f7820e = tVar;
                this.f7821f = atomicReference;
            }

            public void b(T t5) {
                this.f7820e.b(t5);
            }

            public void c(c cVar) {
                s2.c.o(this.f7821f, cVar);
            }

            public void onError(Throwable th) {
                this.f7820e.onError(th);
            }
        }

        a(t<? super T> tVar, v<? extends T> vVar) {
            this.f7818e = tVar;
            this.f7819f = vVar;
        }

        public void a() {
            c cVar = (c) get();
            if (cVar != s2.c.DISPOSED && compareAndSet(cVar, (Object) null)) {
                this.f7819f.d(new C0126a(this.f7818e, this));
            }
        }

        public void b(T t5) {
            this.f7818e.b(t5);
        }

        public void c(c cVar) {
            if (s2.c.o(this, cVar)) {
                this.f7818e.c(this);
            }
        }

        public void dispose() {
            s2.c.c(this);
        }

        public boolean f() {
            return s2.c.i((c) get());
        }

        public void onError(Throwable th) {
            this.f7818e.onError(th);
        }
    }

    public f(j<T> jVar, v<? extends T> vVar) {
        this.f7816e = jVar;
        this.f7817f = vVar;
    }

    /* access modifiers changed from: protected */
    public void D(t<? super T> tVar) {
        this.f7816e.b(new a(tVar, this.f7817f));
    }
}
