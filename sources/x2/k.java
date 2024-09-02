package x2;

import f3.c;
import java.util.NoSuchElementException;
import m2.f;
import m2.g;
import u4.b;

public final class k<T> extends a<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final T f7690g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f7691h;

    static final class a<T> extends c<T> implements g<T> {

        /* renamed from: g  reason: collision with root package name */
        final T f7692g;

        /* renamed from: h  reason: collision with root package name */
        final boolean f7693h;

        /* renamed from: i  reason: collision with root package name */
        u4.c f7694i;

        /* renamed from: j  reason: collision with root package name */
        boolean f7695j;

        a(b<? super T> bVar, T t5, boolean z4) {
            super(bVar);
            this.f7692g = t5;
            this.f7693h = z4;
        }

        public void a() {
            if (!this.f7695j) {
                this.f7695j = true;
                T t5 = this.f4616f;
                this.f4616f = null;
                if (t5 == null) {
                    t5 = this.f7692g;
                }
                if (t5 != null) {
                    h(t5);
                } else if (this.f7693h) {
                    this.f4615e.onError(new NoSuchElementException());
                } else {
                    this.f4615e.a();
                }
            }
        }

        public void cancel() {
            super.cancel();
            this.f7694i.cancel();
        }

        public void d(T t5) {
            if (!this.f7695j) {
                if (this.f4616f != null) {
                    this.f7695j = true;
                    this.f7694i.cancel();
                    this.f4615e.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f4616f = t5;
            }
        }

        public void e(u4.c cVar) {
            if (f3.g.q(this.f7694i, cVar)) {
                this.f7694i = cVar;
                this.f4615e.e(this);
                cVar.f(Long.MAX_VALUE);
            }
        }

        public void onError(Throwable th) {
            if (this.f7695j) {
                j3.a.r(th);
                return;
            }
            this.f7695j = true;
            this.f4615e.onError(th);
        }
    }

    public k(f<T> fVar, T t5, boolean z4) {
        super(fVar);
        this.f7690g = t5;
        this.f7691h = z4;
    }

    /* access modifiers changed from: protected */
    public void j(b<? super T> bVar) {
        this.f7623f.i(new a(bVar, this.f7690g, this.f7691h));
    }
}
