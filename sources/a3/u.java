package a3;

import m2.n;
import m2.p;
import r2.h;

public final class u<T> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final h<? super T> f360f;

    static final class a<T> extends v2.a<T, T> {

        /* renamed from: j  reason: collision with root package name */
        final h<? super T> f361j;

        a(p<? super T> pVar, h<? super T> hVar) {
            super(pVar);
            this.f361j = hVar;
        }

        public void d(T t5) {
            if (this.f7259i == 0) {
                try {
                    if (this.f361j.test(t5)) {
                        this.f7255e.d(t5);
                    }
                } catch (Throwable th) {
                    g(th);
                }
            } else {
                this.f7255e.d(null);
            }
        }

        public int i(int i5) {
            return h(i5);
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public T poll() {
            /*
                r2 = this;
            L_0x0000:
                u2.d<T> r0 = r2.f7257g
                java.lang.Object r0 = r0.poll()
                if (r0 == 0) goto L_0x0010
                r2.h<? super T> r1 = r2.f361j
                boolean r1 = r1.test(r0)
                if (r1 == 0) goto L_0x0000
            L_0x0010:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: a3.u.a.poll():java.lang.Object");
        }
    }

    public u(n<T> nVar, h<? super T> hVar) {
        super(nVar);
        this.f360f = hVar;
    }

    public void v0(p<? super T> pVar) {
        this.f24e.g(new a(pVar, this.f360f));
    }
}
