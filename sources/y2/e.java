package y2;

import m2.i;
import m2.j;
import p2.c;
import r2.f;
import t2.b;

public final class e<T, R> extends a<T, R> {

    /* renamed from: f  reason: collision with root package name */
    final f<? super T, ? extends R> f7812f;

    static final class a<T, R> implements i<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final i<? super R> f7813e;

        /* renamed from: f  reason: collision with root package name */
        final f<? super T, ? extends R> f7814f;

        /* renamed from: g  reason: collision with root package name */
        c f7815g;

        a(i<? super R> iVar, f<? super T, ? extends R> fVar) {
            this.f7813e = iVar;
            this.f7814f = fVar;
        }

        public void a() {
            this.f7813e.a();
        }

        public void b(T t5) {
            try {
                this.f7813e.b(b.e(this.f7814f.apply(t5), "The mapper returned a null item"));
            } catch (Throwable th) {
                q2.b.b(th);
                this.f7813e.onError(th);
            }
        }

        public void c(c cVar) {
            if (s2.c.q(this.f7815g, cVar)) {
                this.f7815g = cVar;
                this.f7813e.c(this);
            }
        }

        public void dispose() {
            c cVar = this.f7815g;
            this.f7815g = s2.c.DISPOSED;
            cVar.dispose();
        }

        public boolean f() {
            return this.f7815g.f();
        }

        public void onError(Throwable th) {
            this.f7813e.onError(th);
        }
    }

    public e(j<T> jVar, f<? super T, ? extends R> fVar) {
        super(jVar);
        this.f7812f = fVar;
    }

    /* access modifiers changed from: protected */
    public void f(i<? super R> iVar) {
        this.f7800e.b(new a(iVar, this.f7812f));
    }
}
