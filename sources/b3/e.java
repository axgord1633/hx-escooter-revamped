package b3;

import java.util.concurrent.atomic.AtomicInteger;
import m2.r;
import m2.t;
import m2.v;
import p2.c;
import q2.b;

public final class e<T> extends r<T> {

    /* renamed from: e  reason: collision with root package name */
    final v<T> f2989e;

    /* renamed from: f  reason: collision with root package name */
    final r2.a f2990f;

    static final class a<T> extends AtomicInteger implements t<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final t<? super T> f2991e;

        /* renamed from: f  reason: collision with root package name */
        final r2.a f2992f;

        /* renamed from: g  reason: collision with root package name */
        c f2993g;

        a(t<? super T> tVar, r2.a aVar) {
            this.f2991e = tVar;
            this.f2992f = aVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f2992f.run();
                } catch (Throwable th) {
                    b.b(th);
                    j3.a.r(th);
                }
            }
        }

        public void b(T t5) {
            this.f2991e.b(t5);
            a();
        }

        public void c(c cVar) {
            if (s2.c.q(this.f2993g, cVar)) {
                this.f2993g = cVar;
                this.f2991e.c(this);
            }
        }

        public void dispose() {
            this.f2993g.dispose();
            a();
        }

        public boolean f() {
            return this.f2993g.f();
        }

        public void onError(Throwable th) {
            this.f2991e.onError(th);
            a();
        }
    }

    public e(v<T> vVar, r2.a aVar) {
        this.f2989e = vVar;
        this.f2990f = aVar;
    }

    /* access modifiers changed from: protected */
    public void D(t<? super T> tVar) {
        this.f2989e.d(new a(tVar, this.f2990f));
    }
}
