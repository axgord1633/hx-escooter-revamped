package a3;

import m2.n;
import m2.p;
import p2.c;
import u2.d;
import v2.b;

public final class m<T> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final r2.a f245f;

    static final class a<T> extends b<T> implements p<T> {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f246e;

        /* renamed from: f  reason: collision with root package name */
        final r2.a f247f;

        /* renamed from: g  reason: collision with root package name */
        c f248g;

        /* renamed from: h  reason: collision with root package name */
        d<T> f249h;

        /* renamed from: i  reason: collision with root package name */
        boolean f250i;

        a(p<? super T> pVar, r2.a aVar) {
            this.f246e = pVar;
            this.f247f = aVar;
        }

        public void a() {
            this.f246e.a();
            e();
        }

        public void c(c cVar) {
            if (s2.c.q(this.f248g, cVar)) {
                this.f248g = cVar;
                if (cVar instanceof d) {
                    this.f249h = (d) cVar;
                }
                this.f246e.c(this);
            }
        }

        public void clear() {
            this.f249h.clear();
        }

        public void d(T t5) {
            this.f246e.d(t5);
        }

        public void dispose() {
            this.f248g.dispose();
            e();
        }

        /* access modifiers changed from: package-private */
        public void e() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f247f.run();
                } catch (Throwable th) {
                    q2.b.b(th);
                    j3.a.r(th);
                }
            }
        }

        public boolean f() {
            return this.f248g.f();
        }

        public int i(int i5) {
            d<T> dVar = this.f249h;
            boolean z4 = false;
            if (dVar == null || (i5 & 4) != 0) {
                return 0;
            }
            int i6 = dVar.i(i5);
            if (i6 != 0) {
                if (i6 == 1) {
                    z4 = true;
                }
                this.f250i = z4;
            }
            return i6;
        }

        public boolean isEmpty() {
            return this.f249h.isEmpty();
        }

        public void onError(Throwable th) {
            this.f246e.onError(th);
            e();
        }

        public T poll() {
            T poll = this.f249h.poll();
            if (poll == null && this.f250i) {
                e();
            }
            return poll;
        }
    }

    public m(n<T> nVar, r2.a aVar) {
        super(nVar);
        this.f245f = aVar;
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super T> pVar) {
        this.f24e.g(new a(pVar, this.f245f));
    }
}
