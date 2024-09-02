package x2;

import f3.c;
import java.util.NoSuchElementException;
import m2.f;
import m2.g;

public final class b<T> extends a<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final long f7624g;

    /* renamed from: h  reason: collision with root package name */
    final T f7625h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f7626i;

    static final class a<T> extends c<T> implements g<T> {

        /* renamed from: g  reason: collision with root package name */
        final long f7627g;

        /* renamed from: h  reason: collision with root package name */
        final T f7628h;

        /* renamed from: i  reason: collision with root package name */
        final boolean f7629i;

        /* renamed from: j  reason: collision with root package name */
        u4.c f7630j;

        /* renamed from: k  reason: collision with root package name */
        long f7631k;

        /* renamed from: l  reason: collision with root package name */
        boolean f7632l;

        a(u4.b<? super T> bVar, long j5, T t5, boolean z4) {
            super(bVar);
            this.f7627g = j5;
            this.f7628h = t5;
            this.f7629i = z4;
        }

        public void a() {
            if (!this.f7632l) {
                this.f7632l = true;
                T t5 = this.f7628h;
                if (t5 != null) {
                    h(t5);
                } else if (this.f7629i) {
                    this.f4615e.onError(new NoSuchElementException());
                } else {
                    this.f4615e.a();
                }
            }
        }

        public void cancel() {
            super.cancel();
            this.f7630j.cancel();
        }

        public void d(T t5) {
            if (!this.f7632l) {
                long j5 = this.f7631k;
                if (j5 == this.f7627g) {
                    this.f7632l = true;
                    this.f7630j.cancel();
                    h(t5);
                    return;
                }
                this.f7631k = j5 + 1;
            }
        }

        public void e(u4.c cVar) {
            if (f3.g.q(this.f7630j, cVar)) {
                this.f7630j = cVar;
                this.f4615e.e(this);
                cVar.f(Long.MAX_VALUE);
            }
        }

        public void onError(Throwable th) {
            if (this.f7632l) {
                j3.a.r(th);
                return;
            }
            this.f7632l = true;
            this.f4615e.onError(th);
        }
    }

    public b(f<T> fVar, long j5, T t5, boolean z4) {
        super(fVar);
        this.f7624g = j5;
        this.f7625h = t5;
        this.f7626i = z4;
    }

    /* access modifiers changed from: protected */
    public void j(u4.b<? super T> bVar) {
        this.f7623f.i(new a(bVar, this.f7624g, this.f7625h, this.f7626i));
    }
}
