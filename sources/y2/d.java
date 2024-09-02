package y2;

import java.util.concurrent.atomic.AtomicReference;
import m2.i;
import m2.j;
import p2.c;
import r2.f;
import t2.b;

public final class d<T, R> extends a<T, R> {

    /* renamed from: f  reason: collision with root package name */
    final f<? super T, ? extends j<? extends R>> f7807f;

    static final class a<T, R> extends AtomicReference<c> implements i<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final i<? super R> f7808e;

        /* renamed from: f  reason: collision with root package name */
        final f<? super T, ? extends j<? extends R>> f7809f;

        /* renamed from: g  reason: collision with root package name */
        c f7810g;

        /* renamed from: y2.d$a$a  reason: collision with other inner class name */
        final class C0125a implements i<R> {
            C0125a() {
            }

            public void a() {
                a.this.f7808e.a();
            }

            public void b(R r5) {
                a.this.f7808e.b(r5);
            }

            public void c(c cVar) {
                s2.c.o(a.this, cVar);
            }

            public void onError(Throwable th) {
                a.this.f7808e.onError(th);
            }
        }

        a(i<? super R> iVar, f<? super T, ? extends j<? extends R>> fVar) {
            this.f7808e = iVar;
            this.f7809f = fVar;
        }

        public void a() {
            this.f7808e.a();
        }

        public void b(T t5) {
            try {
                j jVar = (j) b.e(this.f7809f.apply(t5), "The mapper returned a null MaybeSource");
                if (!f()) {
                    jVar.b(new C0125a());
                }
            } catch (Exception e5) {
                q2.b.b(e5);
                this.f7808e.onError(e5);
            }
        }

        public void c(c cVar) {
            if (s2.c.q(this.f7810g, cVar)) {
                this.f7810g = cVar;
                this.f7808e.c(this);
            }
        }

        public void dispose() {
            s2.c.c(this);
            this.f7810g.dispose();
        }

        public boolean f() {
            return s2.c.i((c) get());
        }

        public void onError(Throwable th) {
            this.f7808e.onError(th);
        }
    }

    public d(j<T> jVar, f<? super T, ? extends j<? extends R>> fVar) {
        super(jVar);
        this.f7807f = fVar;
    }

    /* access modifiers changed from: protected */
    public void f(i<? super R> iVar) {
        this.f7800e.b(new a(iVar, this.f7807f));
    }
}
