package x2;

import java.util.NoSuchElementException;
import m2.f;
import m2.g;
import m2.r;
import m2.t;
import p2.c;
import u2.b;

public final class l<T> extends r<T> implements b<T> {

    /* renamed from: e  reason: collision with root package name */
    final f<T> f7696e;

    /* renamed from: f  reason: collision with root package name */
    final T f7697f;

    static final class a<T> implements g<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final t<? super T> f7698e;

        /* renamed from: f  reason: collision with root package name */
        final T f7699f;

        /* renamed from: g  reason: collision with root package name */
        u4.c f7700g;

        /* renamed from: h  reason: collision with root package name */
        boolean f7701h;

        /* renamed from: i  reason: collision with root package name */
        T f7702i;

        a(t<? super T> tVar, T t5) {
            this.f7698e = tVar;
            this.f7699f = t5;
        }

        public void a() {
            if (!this.f7701h) {
                this.f7701h = true;
                this.f7700g = f3.g.CANCELLED;
                T t5 = this.f7702i;
                this.f7702i = null;
                if (t5 == null) {
                    t5 = this.f7699f;
                }
                if (t5 != null) {
                    this.f7698e.b(t5);
                } else {
                    this.f7698e.onError(new NoSuchElementException());
                }
            }
        }

        public void d(T t5) {
            if (!this.f7701h) {
                if (this.f7702i != null) {
                    this.f7701h = true;
                    this.f7700g.cancel();
                    this.f7700g = f3.g.CANCELLED;
                    this.f7698e.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f7702i = t5;
            }
        }

        public void dispose() {
            this.f7700g.cancel();
            this.f7700g = f3.g.CANCELLED;
        }

        public void e(u4.c cVar) {
            if (f3.g.q(this.f7700g, cVar)) {
                this.f7700g = cVar;
                this.f7698e.c(this);
                cVar.f(Long.MAX_VALUE);
            }
        }

        public boolean f() {
            return this.f7700g == f3.g.CANCELLED;
        }

        public void onError(Throwable th) {
            if (this.f7701h) {
                j3.a.r(th);
                return;
            }
            this.f7701h = true;
            this.f7700g = f3.g.CANCELLED;
            this.f7698e.onError(th);
        }
    }

    public l(f<T> fVar, T t5) {
        this.f7696e = fVar;
        this.f7697f = t5;
    }

    /* access modifiers changed from: protected */
    public void D(t<? super T> tVar) {
        this.f7696e.i(new a(tVar, this.f7697f));
    }

    public f<T> e() {
        return j3.a.m(new k(this.f7696e, this.f7697f, true));
    }
}
