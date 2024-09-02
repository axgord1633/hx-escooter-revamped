package a3;

import java.util.NoSuchElementException;
import m2.n;
import p2.c;

public final class p<T> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final long f284f;

    /* renamed from: g  reason: collision with root package name */
    final T f285g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f286h;

    static final class a<T> implements m2.p<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final m2.p<? super T> f287e;

        /* renamed from: f  reason: collision with root package name */
        final long f288f;

        /* renamed from: g  reason: collision with root package name */
        final T f289g;

        /* renamed from: h  reason: collision with root package name */
        final boolean f290h;

        /* renamed from: i  reason: collision with root package name */
        c f291i;

        /* renamed from: j  reason: collision with root package name */
        long f292j;

        /* renamed from: k  reason: collision with root package name */
        boolean f293k;

        a(m2.p<? super T> pVar, long j5, T t5, boolean z4) {
            this.f287e = pVar;
            this.f288f = j5;
            this.f289g = t5;
            this.f290h = z4;
        }

        public void a() {
            if (!this.f293k) {
                this.f293k = true;
                T t5 = this.f289g;
                if (t5 != null || !this.f290h) {
                    if (t5 != null) {
                        this.f287e.d(t5);
                    }
                    this.f287e.a();
                    return;
                }
                this.f287e.onError(new NoSuchElementException());
            }
        }

        public void c(c cVar) {
            if (s2.c.q(this.f291i, cVar)) {
                this.f291i = cVar;
                this.f287e.c(this);
            }
        }

        public void d(T t5) {
            if (!this.f293k) {
                long j5 = this.f292j;
                if (j5 == this.f288f) {
                    this.f293k = true;
                    this.f291i.dispose();
                    this.f287e.d(t5);
                    this.f287e.a();
                    return;
                }
                this.f292j = j5 + 1;
            }
        }

        public void dispose() {
            this.f291i.dispose();
        }

        public boolean f() {
            return this.f291i.f();
        }

        public void onError(Throwable th) {
            if (this.f293k) {
                j3.a.r(th);
                return;
            }
            this.f293k = true;
            this.f287e.onError(th);
        }
    }

    public p(n<T> nVar, long j5, T t5, boolean z4) {
        super(nVar);
        this.f284f = j5;
        this.f285g = t5;
        this.f286h = z4;
    }

    public void v0(m2.p<? super T> pVar) {
        this.f24e.g(new a(pVar, this.f284f, this.f285g, this.f286h));
    }
}
