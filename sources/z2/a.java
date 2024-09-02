package z2;

import java.util.concurrent.atomic.AtomicReference;
import m2.b;
import m2.c;
import m2.k;
import m2.n;
import m2.p;

public final class a<R> extends k<R> {

    /* renamed from: e  reason: collision with root package name */
    final c f7893e;

    /* renamed from: f  reason: collision with root package name */
    final n<? extends R> f7894f;

    /* renamed from: z2.a$a  reason: collision with other inner class name */
    static final class C0128a<R> extends AtomicReference<p2.c> implements p<R>, b, p2.c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super R> f7895e;

        /* renamed from: f  reason: collision with root package name */
        n<? extends R> f7896f;

        C0128a(p<? super R> pVar, n<? extends R> nVar) {
            this.f7896f = nVar;
            this.f7895e = pVar;
        }

        public void a() {
            n<? extends R> nVar = this.f7896f;
            if (nVar == null) {
                this.f7895e.a();
                return;
            }
            this.f7896f = null;
            nVar.g(this);
        }

        public void c(p2.c cVar) {
            s2.c.l(this, cVar);
        }

        public void d(R r5) {
            this.f7895e.d(r5);
        }

        public void dispose() {
            s2.c.c(this);
        }

        public boolean f() {
            return s2.c.i((p2.c) get());
        }

        public void onError(Throwable th) {
            this.f7895e.onError(th);
        }
    }

    public a(c cVar, n<? extends R> nVar) {
        this.f7893e = cVar;
        this.f7894f = nVar;
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super R> pVar) {
        C0128a aVar = new C0128a(pVar, this.f7894f);
        pVar.c(aVar);
        this.f7893e.b(aVar);
    }
}
