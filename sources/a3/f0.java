package a3;

import m2.n;
import m2.p;
import r2.f;
import t2.b;

public final class f0<T, U> extends a<T, U> {

    /* renamed from: f  reason: collision with root package name */
    final f<? super T, ? extends U> f135f;

    static final class a<T, U> extends v2.a<T, U> {

        /* renamed from: j  reason: collision with root package name */
        final f<? super T, ? extends U> f136j;

        a(p<? super U> pVar, f<? super T, ? extends U> fVar) {
            super(pVar);
            this.f136j = fVar;
        }

        public void d(T t5) {
            if (!this.f7258h) {
                if (this.f7259i != 0) {
                    this.f7255e.d(null);
                    return;
                }
                try {
                    this.f7255e.d(b.e(this.f136j.apply(t5), "The mapper function returned a null value."));
                } catch (Throwable th) {
                    g(th);
                }
            }
        }

        public int i(int i5) {
            return h(i5);
        }

        public U poll() {
            T poll = this.f7257g.poll();
            if (poll != null) {
                return b.e(this.f136j.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    public f0(n<T> nVar, f<? super T, ? extends U> fVar) {
        super(nVar);
        this.f135f = fVar;
    }

    public void v0(p<? super U> pVar) {
        this.f24e.g(new a(pVar, this.f135f));
    }
}
