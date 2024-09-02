package a3;

import i3.c;
import java.util.concurrent.TimeUnit;
import m2.n;
import m2.p;
import m2.q;

public final class j<T> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final long f193f;

    /* renamed from: g  reason: collision with root package name */
    final TimeUnit f194g;

    /* renamed from: h  reason: collision with root package name */
    final q f195h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f196i;

    static final class a<T> implements p<T>, p2.c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f197e;

        /* renamed from: f  reason: collision with root package name */
        final long f198f;

        /* renamed from: g  reason: collision with root package name */
        final TimeUnit f199g;

        /* renamed from: h  reason: collision with root package name */
        final q.c f200h;

        /* renamed from: i  reason: collision with root package name */
        final boolean f201i;

        /* renamed from: j  reason: collision with root package name */
        p2.c f202j;

        /* renamed from: a3.j$a$a  reason: collision with other inner class name */
        final class C0006a implements Runnable {
            C0006a() {
            }

            public void run() {
                try {
                    a.this.f197e.a();
                } finally {
                    a.this.f200h.dispose();
                }
            }
        }

        final class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            private final Throwable f204e;

            b(Throwable th) {
                this.f204e = th;
            }

            public void run() {
                try {
                    a.this.f197e.onError(this.f204e);
                } finally {
                    a.this.f200h.dispose();
                }
            }
        }

        final class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            private final T f206e;

            c(T t5) {
                this.f206e = t5;
            }

            public void run() {
                a.this.f197e.d(this.f206e);
            }
        }

        a(p<? super T> pVar, long j5, TimeUnit timeUnit, q.c cVar, boolean z4) {
            this.f197e = pVar;
            this.f198f = j5;
            this.f199g = timeUnit;
            this.f200h = cVar;
            this.f201i = z4;
        }

        public void a() {
            this.f200h.c(new C0006a(), this.f198f, this.f199g);
        }

        public void c(p2.c cVar) {
            if (s2.c.q(this.f202j, cVar)) {
                this.f202j = cVar;
                this.f197e.c(this);
            }
        }

        public void d(T t5) {
            this.f200h.c(new c(t5), this.f198f, this.f199g);
        }

        public void dispose() {
            this.f202j.dispose();
            this.f200h.dispose();
        }

        public boolean f() {
            return this.f200h.f();
        }

        public void onError(Throwable th) {
            this.f200h.c(new b(th), this.f201i ? this.f198f : 0, this.f199g);
        }
    }

    public j(n<T> nVar, long j5, TimeUnit timeUnit, q qVar, boolean z4) {
        super(nVar);
        this.f193f = j5;
        this.f194g = timeUnit;
        this.f195h = qVar;
        this.f196i = z4;
    }

    public void v0(p<? super T> pVar) {
        this.f24e.g(new a(this.f196i ? pVar : new c(pVar), this.f193f, this.f194g, this.f195h.a(), this.f196i));
    }
}
