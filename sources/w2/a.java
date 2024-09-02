package w2;

import java.util.concurrent.atomic.AtomicReference;
import m2.c;

public final class a extends m2.a {

    /* renamed from: e  reason: collision with root package name */
    final c f7552e;

    /* renamed from: f  reason: collision with root package name */
    final c f7553f;

    /* renamed from: w2.a$a  reason: collision with other inner class name */
    static final class C0121a implements m2.b {

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<p2.c> f7554e;

        /* renamed from: f  reason: collision with root package name */
        final m2.b f7555f;

        C0121a(AtomicReference<p2.c> atomicReference, m2.b bVar) {
            this.f7554e = atomicReference;
            this.f7555f = bVar;
        }

        public void a() {
            this.f7555f.a();
        }

        public void c(p2.c cVar) {
            s2.c.l(this.f7554e, cVar);
        }

        public void onError(Throwable th) {
            this.f7555f.onError(th);
        }
    }

    static final class b extends AtomicReference<p2.c> implements m2.b, p2.c {

        /* renamed from: e  reason: collision with root package name */
        final m2.b f7556e;

        /* renamed from: f  reason: collision with root package name */
        final c f7557f;

        b(m2.b bVar, c cVar) {
            this.f7556e = bVar;
            this.f7557f = cVar;
        }

        public void a() {
            this.f7557f.b(new C0121a(this, this.f7556e));
        }

        public void c(p2.c cVar) {
            if (s2.c.o(this, cVar)) {
                this.f7556e.c(this);
            }
        }

        public void dispose() {
            s2.c.c(this);
        }

        public boolean f() {
            return s2.c.i((p2.c) get());
        }

        public void onError(Throwable th) {
            this.f7556e.onError(th);
        }
    }

    public a(c cVar, c cVar2) {
        this.f7552e = cVar;
        this.f7553f = cVar2;
    }

    /* access modifiers changed from: protected */
    public void m(m2.b bVar) {
        this.f7552e.b(new b(bVar, this.f7553f));
    }
}
