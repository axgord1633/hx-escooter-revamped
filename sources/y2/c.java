package y2;

import m2.h;
import m2.i;
import m2.t;
import m2.v;
import q2.b;

public final class c<T> extends h<T> {

    /* renamed from: e  reason: collision with root package name */
    final v<T> f7802e;

    /* renamed from: f  reason: collision with root package name */
    final r2.h<? super T> f7803f;

    static final class a<T> implements t<T>, p2.c {

        /* renamed from: e  reason: collision with root package name */
        final i<? super T> f7804e;

        /* renamed from: f  reason: collision with root package name */
        final r2.h<? super T> f7805f;

        /* renamed from: g  reason: collision with root package name */
        p2.c f7806g;

        a(i<? super T> iVar, r2.h<? super T> hVar) {
            this.f7804e = iVar;
            this.f7805f = hVar;
        }

        public void b(T t5) {
            try {
                if (this.f7805f.test(t5)) {
                    this.f7804e.b(t5);
                } else {
                    this.f7804e.a();
                }
            } catch (Throwable th) {
                b.b(th);
                this.f7804e.onError(th);
            }
        }

        public void c(p2.c cVar) {
            if (s2.c.q(this.f7806g, cVar)) {
                this.f7806g = cVar;
                this.f7804e.c(this);
            }
        }

        public void dispose() {
            p2.c cVar = this.f7806g;
            this.f7806g = s2.c.DISPOSED;
            cVar.dispose();
        }

        public boolean f() {
            return this.f7806g.f();
        }

        public void onError(Throwable th) {
            this.f7804e.onError(th);
        }
    }

    public c(v<T> vVar, r2.h<? super T> hVar) {
        this.f7802e = vVar;
        this.f7803f = hVar;
    }

    /* access modifiers changed from: protected */
    public void f(i<? super T> iVar) {
        this.f7802e.d(new a(iVar, this.f7803f));
    }
}
