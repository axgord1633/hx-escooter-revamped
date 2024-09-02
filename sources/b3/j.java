package b3;

import java.util.concurrent.atomic.AtomicReference;
import m2.r;
import m2.t;
import m2.v;
import p2.c;
import r2.f;
import t2.b;

public final class j<T, R> extends r<R> {

    /* renamed from: e  reason: collision with root package name */
    final v<? extends T> f3008e;

    /* renamed from: f  reason: collision with root package name */
    final f<? super T, ? extends v<? extends R>> f3009f;

    static final class a<T, R> extends AtomicReference<c> implements t<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final t<? super R> f3010e;

        /* renamed from: f  reason: collision with root package name */
        final f<? super T, ? extends v<? extends R>> f3011f;

        /* renamed from: b3.j$a$a  reason: collision with other inner class name */
        static final class C0054a<R> implements t<R> {

            /* renamed from: e  reason: collision with root package name */
            final AtomicReference<c> f3012e;

            /* renamed from: f  reason: collision with root package name */
            final t<? super R> f3013f;

            C0054a(AtomicReference<c> atomicReference, t<? super R> tVar) {
                this.f3012e = atomicReference;
                this.f3013f = tVar;
            }

            public void b(R r5) {
                this.f3013f.b(r5);
            }

            public void c(c cVar) {
                s2.c.l(this.f3012e, cVar);
            }

            public void onError(Throwable th) {
                this.f3013f.onError(th);
            }
        }

        a(t<? super R> tVar, f<? super T, ? extends v<? extends R>> fVar) {
            this.f3010e = tVar;
            this.f3011f = fVar;
        }

        public void b(T t5) {
            try {
                v vVar = (v) b.e(this.f3011f.apply(t5), "The single returned by the mapper is null");
                if (!f()) {
                    vVar.d(new C0054a(this, this.f3010e));
                }
            } catch (Throwable th) {
                q2.b.b(th);
                this.f3010e.onError(th);
            }
        }

        public void c(c cVar) {
            if (s2.c.o(this, cVar)) {
                this.f3010e.c(this);
            }
        }

        public void dispose() {
            s2.c.c(this);
        }

        public boolean f() {
            return s2.c.i((c) get());
        }

        public void onError(Throwable th) {
            this.f3010e.onError(th);
        }
    }

    public j(v<? extends T> vVar, f<? super T, ? extends v<? extends R>> fVar) {
        this.f3009f = fVar;
        this.f3008e = vVar;
    }

    /* access modifiers changed from: protected */
    public void D(t<? super R> tVar) {
        this.f3008e.d(new a(tVar, this.f3009f));
    }
}
