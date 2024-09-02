package w2;

import java.util.concurrent.atomic.AtomicReference;
import m2.b;
import m2.c;
import m2.q;

public final class e extends m2.a {

    /* renamed from: e  reason: collision with root package name */
    final c f7561e;

    /* renamed from: f  reason: collision with root package name */
    final q f7562f;

    static final class a extends AtomicReference<p2.c> implements b, p2.c, Runnable {

        /* renamed from: e  reason: collision with root package name */
        final b f7563e;

        /* renamed from: f  reason: collision with root package name */
        final q f7564f;

        /* renamed from: g  reason: collision with root package name */
        Throwable f7565g;

        a(b bVar, q qVar) {
            this.f7563e = bVar;
            this.f7564f = qVar;
        }

        public void a() {
            s2.c.l(this, this.f7564f.c(this));
        }

        public void c(p2.c cVar) {
            if (s2.c.o(this, cVar)) {
                this.f7563e.c(this);
            }
        }

        public void dispose() {
            s2.c.c(this);
        }

        public boolean f() {
            return s2.c.i((p2.c) get());
        }

        public void onError(Throwable th) {
            this.f7565g = th;
            s2.c.l(this, this.f7564f.c(this));
        }

        public void run() {
            Throwable th = this.f7565g;
            if (th != null) {
                this.f7565g = null;
                this.f7563e.onError(th);
                return;
            }
            this.f7563e.a();
        }
    }

    public e(c cVar, q qVar) {
        this.f7561e = cVar;
        this.f7562f = qVar;
    }

    /* access modifiers changed from: protected */
    public void m(b bVar) {
        this.f7561e.b(new a(bVar, this.f7562f));
    }
}
