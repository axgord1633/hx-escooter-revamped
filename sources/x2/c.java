package x2;

import java.util.NoSuchElementException;
import m2.f;
import m2.g;
import m2.r;
import m2.t;
import u2.b;

public final class c<T> extends r<T> implements b<T> {

    /* renamed from: e  reason: collision with root package name */
    final f<T> f7633e;

    /* renamed from: f  reason: collision with root package name */
    final long f7634f;

    /* renamed from: g  reason: collision with root package name */
    final T f7635g;

    static final class a<T> implements g<T>, p2.c {

        /* renamed from: e  reason: collision with root package name */
        final t<? super T> f7636e;

        /* renamed from: f  reason: collision with root package name */
        final long f7637f;

        /* renamed from: g  reason: collision with root package name */
        final T f7638g;

        /* renamed from: h  reason: collision with root package name */
        u4.c f7639h;

        /* renamed from: i  reason: collision with root package name */
        long f7640i;

        /* renamed from: j  reason: collision with root package name */
        boolean f7641j;

        a(t<? super T> tVar, long j5, T t5) {
            this.f7636e = tVar;
            this.f7637f = j5;
            this.f7638g = t5;
        }

        public void a() {
            this.f7639h = f3.g.CANCELLED;
            if (!this.f7641j) {
                this.f7641j = true;
                T t5 = this.f7638g;
                if (t5 != null) {
                    this.f7636e.b(t5);
                } else {
                    this.f7636e.onError(new NoSuchElementException());
                }
            }
        }

        public void d(T t5) {
            if (!this.f7641j) {
                long j5 = this.f7640i;
                if (j5 == this.f7637f) {
                    this.f7641j = true;
                    this.f7639h.cancel();
                    this.f7639h = f3.g.CANCELLED;
                    this.f7636e.b(t5);
                    return;
                }
                this.f7640i = j5 + 1;
            }
        }

        public void dispose() {
            this.f7639h.cancel();
            this.f7639h = f3.g.CANCELLED;
        }

        public void e(u4.c cVar) {
            if (f3.g.q(this.f7639h, cVar)) {
                this.f7639h = cVar;
                this.f7636e.c(this);
                cVar.f(Long.MAX_VALUE);
            }
        }

        public boolean f() {
            return this.f7639h == f3.g.CANCELLED;
        }

        public void onError(Throwable th) {
            if (this.f7641j) {
                j3.a.r(th);
                return;
            }
            this.f7641j = true;
            this.f7639h = f3.g.CANCELLED;
            this.f7636e.onError(th);
        }
    }

    public c(f<T> fVar, long j5, T t5) {
        this.f7633e = fVar;
        this.f7634f = j5;
        this.f7635g = t5;
    }

    /* access modifiers changed from: protected */
    public void D(t<? super T> tVar) {
        this.f7633e.i(new a(tVar, this.f7634f, this.f7635g));
    }

    public f<T> e() {
        return j3.a.m(new b(this.f7633e, this.f7634f, this.f7635g, true));
    }
}
