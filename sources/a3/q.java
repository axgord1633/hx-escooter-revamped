package a3;

import m2.h;
import m2.i;
import m2.k;
import m2.n;
import m2.p;
import u2.c;

public final class q<T> extends h<T> implements c<T> {

    /* renamed from: e  reason: collision with root package name */
    final n<T> f304e;

    /* renamed from: f  reason: collision with root package name */
    final long f305f;

    static final class a<T> implements p<T>, p2.c {

        /* renamed from: e  reason: collision with root package name */
        final i<? super T> f306e;

        /* renamed from: f  reason: collision with root package name */
        final long f307f;

        /* renamed from: g  reason: collision with root package name */
        p2.c f308g;

        /* renamed from: h  reason: collision with root package name */
        long f309h;

        /* renamed from: i  reason: collision with root package name */
        boolean f310i;

        a(i<? super T> iVar, long j5) {
            this.f306e = iVar;
            this.f307f = j5;
        }

        public void a() {
            if (!this.f310i) {
                this.f310i = true;
                this.f306e.a();
            }
        }

        public void c(p2.c cVar) {
            if (s2.c.q(this.f308g, cVar)) {
                this.f308g = cVar;
                this.f306e.c(this);
            }
        }

        public void d(T t5) {
            if (!this.f310i) {
                long j5 = this.f309h;
                if (j5 == this.f307f) {
                    this.f310i = true;
                    this.f308g.dispose();
                    this.f306e.b(t5);
                    return;
                }
                this.f309h = j5 + 1;
            }
        }

        public void dispose() {
            this.f308g.dispose();
        }

        public boolean f() {
            return this.f308g.f();
        }

        public void onError(Throwable th) {
            if (this.f310i) {
                j3.a.r(th);
                return;
            }
            this.f310i = true;
            this.f306e.onError(th);
        }
    }

    public q(n<T> nVar, long j5) {
        this.f304e = nVar;
        this.f305f = j5;
    }

    public k<T> a() {
        return j3.a.o(new p(this.f304e, this.f305f, null, false));
    }

    public void f(i<? super T> iVar) {
        this.f304e.g(new a(iVar, this.f305f));
    }
}
