package w2;

import m2.b;
import m2.c;
import r2.h;

public final class f extends m2.a {

    /* renamed from: e  reason: collision with root package name */
    final c f7566e;

    /* renamed from: f  reason: collision with root package name */
    final h<? super Throwable> f7567f;

    final class a implements b {

        /* renamed from: e  reason: collision with root package name */
        private final b f7568e;

        a(b bVar) {
            this.f7568e = bVar;
        }

        public void a() {
            this.f7568e.a();
        }

        public void c(p2.c cVar) {
            this.f7568e.c(cVar);
        }

        public void onError(Throwable th) {
            try {
                if (f.this.f7567f.test(th)) {
                    this.f7568e.a();
                } else {
                    this.f7568e.onError(th);
                }
            } catch (Throwable th2) {
                q2.b.b(th2);
                this.f7568e.onError(new q2.a(th, th2));
            }
        }
    }

    public f(c cVar, h<? super Throwable> hVar) {
        this.f7566e = cVar;
        this.f7567f = hVar;
    }

    /* access modifiers changed from: protected */
    public void m(b bVar) {
        this.f7566e.b(new a(bVar));
    }
}
