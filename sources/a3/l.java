package a3;

import m2.n;
import m2.p;
import r2.c;
import r2.f;

public final class l<T, K> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final f<? super T, K> f230f;

    /* renamed from: g  reason: collision with root package name */
    final c<? super K, ? super K> f231g;

    static final class a<T, K> extends v2.a<T, T> {

        /* renamed from: j  reason: collision with root package name */
        final f<? super T, K> f232j;

        /* renamed from: k  reason: collision with root package name */
        final c<? super K, ? super K> f233k;

        /* renamed from: l  reason: collision with root package name */
        K f234l;

        /* renamed from: m  reason: collision with root package name */
        boolean f235m;

        a(p<? super T> pVar, f<? super T, K> fVar, c<? super K, ? super K> cVar) {
            super(pVar);
            this.f232j = fVar;
            this.f233k = cVar;
        }

        public void d(T t5) {
            if (!this.f7258h) {
                if (this.f7259i == 0) {
                    try {
                        K apply = this.f232j.apply(t5);
                        if (this.f235m) {
                            boolean a5 = this.f233k.a(this.f234l, apply);
                            this.f234l = apply;
                            if (a5) {
                                return;
                            }
                        } else {
                            this.f235m = true;
                            this.f234l = apply;
                        }
                    } catch (Throwable th) {
                        g(th);
                        return;
                    }
                }
                this.f7255e.d(t5);
            }
        }

        public int i(int i5) {
            return h(i5);
        }

        public T poll() {
            T poll;
            boolean a5;
            do {
                poll = this.f7257g.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f232j.apply(poll);
                if (!this.f235m) {
                    this.f235m = true;
                    this.f234l = apply;
                    return poll;
                }
                a5 = this.f233k.a(this.f234l, apply);
                this.f234l = apply;
            } while (a5);
            return poll;
        }
    }

    public l(n<T> nVar, f<? super T, K> fVar, c<? super K, ? super K> cVar) {
        super(nVar);
        this.f230f = fVar;
        this.f231g = cVar;
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super T> pVar) {
        this.f24e.g(new a(pVar, this.f230f, this.f231g));
    }
}
