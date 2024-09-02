package a3;

import java.util.NoSuchElementException;
import m2.k;
import m2.n;
import m2.p;
import m2.t;
import u2.c;

public final class r<T> extends m2.r<T> implements c<T> {

    /* renamed from: e  reason: collision with root package name */
    final n<T> f334e;

    /* renamed from: f  reason: collision with root package name */
    final long f335f;

    /* renamed from: g  reason: collision with root package name */
    final T f336g;

    static final class a<T> implements p<T>, p2.c {

        /* renamed from: e  reason: collision with root package name */
        final t<? super T> f337e;

        /* renamed from: f  reason: collision with root package name */
        final long f338f;

        /* renamed from: g  reason: collision with root package name */
        final T f339g;

        /* renamed from: h  reason: collision with root package name */
        p2.c f340h;

        /* renamed from: i  reason: collision with root package name */
        long f341i;

        /* renamed from: j  reason: collision with root package name */
        boolean f342j;

        a(t<? super T> tVar, long j5, T t5) {
            this.f337e = tVar;
            this.f338f = j5;
            this.f339g = t5;
        }

        public void a() {
            if (!this.f342j) {
                this.f342j = true;
                T t5 = this.f339g;
                if (t5 != null) {
                    this.f337e.b(t5);
                } else {
                    this.f337e.onError(new NoSuchElementException());
                }
            }
        }

        public void c(p2.c cVar) {
            if (s2.c.q(this.f340h, cVar)) {
                this.f340h = cVar;
                this.f337e.c(this);
            }
        }

        public void d(T t5) {
            if (!this.f342j) {
                long j5 = this.f341i;
                if (j5 == this.f338f) {
                    this.f342j = true;
                    this.f340h.dispose();
                    this.f337e.b(t5);
                    return;
                }
                this.f341i = j5 + 1;
            }
        }

        public void dispose() {
            this.f340h.dispose();
        }

        public boolean f() {
            return this.f340h.f();
        }

        public void onError(Throwable th) {
            if (this.f342j) {
                j3.a.r(th);
                return;
            }
            this.f342j = true;
            this.f337e.onError(th);
        }
    }

    public r(n<T> nVar, long j5, T t5) {
        this.f334e = nVar;
        this.f335f = j5;
        this.f336g = t5;
    }

    public void D(t<? super T> tVar) {
        this.f334e.g(new a(tVar, this.f335f, this.f336g));
    }

    public k<T> a() {
        return j3.a.o(new p(this.f334e, this.f335f, this.f336g, true));
    }
}
