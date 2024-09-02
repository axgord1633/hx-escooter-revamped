package a3;

import m2.n;
import m2.p;
import p2.c;
import s2.d;

public final class w0<T> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final long f425f;

    static final class a<T> implements p<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f426e;

        /* renamed from: f  reason: collision with root package name */
        boolean f427f;

        /* renamed from: g  reason: collision with root package name */
        c f428g;

        /* renamed from: h  reason: collision with root package name */
        long f429h;

        a(p<? super T> pVar, long j5) {
            this.f426e = pVar;
            this.f429h = j5;
        }

        public void a() {
            if (!this.f427f) {
                this.f427f = true;
                this.f428g.dispose();
                this.f426e.a();
            }
        }

        public void c(c cVar) {
            if (s2.c.q(this.f428g, cVar)) {
                this.f428g = cVar;
                if (this.f429h == 0) {
                    this.f427f = true;
                    cVar.dispose();
                    d.c(this.f426e);
                    return;
                }
                this.f426e.c(this);
            }
        }

        public void d(T t5) {
            if (!this.f427f) {
                long j5 = this.f429h;
                long j6 = j5 - 1;
                this.f429h = j6;
                if (j5 > 0) {
                    boolean z4 = j6 == 0;
                    this.f426e.d(t5);
                    if (z4) {
                        a();
                    }
                }
            }
        }

        public void dispose() {
            this.f428g.dispose();
        }

        public boolean f() {
            return this.f428g.f();
        }

        public void onError(Throwable th) {
            if (this.f427f) {
                j3.a.r(th);
                return;
            }
            this.f427f = true;
            this.f428g.dispose();
            this.f426e.onError(th);
        }
    }

    public w0(n<T> nVar, long j5) {
        super(nVar);
        this.f425f = j5;
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super T> pVar) {
        this.f24e.g(new a(pVar, this.f425f));
    }
}
