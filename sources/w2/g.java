package w2;

import java.util.concurrent.atomic.AtomicReference;
import m2.b;
import m2.c;
import r2.f;

public final class g extends m2.a {

    /* renamed from: e  reason: collision with root package name */
    final c f7570e;

    /* renamed from: f  reason: collision with root package name */
    final f<? super Throwable, ? extends c> f7571f;

    static final class a extends AtomicReference<p2.c> implements b, p2.c {

        /* renamed from: e  reason: collision with root package name */
        final b f7572e;

        /* renamed from: f  reason: collision with root package name */
        final f<? super Throwable, ? extends c> f7573f;

        /* renamed from: g  reason: collision with root package name */
        boolean f7574g;

        a(b bVar, f<? super Throwable, ? extends c> fVar) {
            this.f7572e = bVar;
            this.f7573f = fVar;
        }

        public void a() {
            this.f7572e.a();
        }

        public void c(p2.c cVar) {
            s2.c.l(this, cVar);
        }

        public void dispose() {
            s2.c.c(this);
        }

        public boolean f() {
            return s2.c.i((p2.c) get());
        }

        public void onError(Throwable th) {
            if (this.f7574g) {
                this.f7572e.onError(th);
                return;
            }
            this.f7574g = true;
            try {
                ((c) t2.b.e(this.f7573f.apply(th), "The errorMapper returned a null CompletableSource")).b(this);
            } catch (Throwable th2) {
                q2.b.b(th2);
                this.f7572e.onError(new q2.a(th, th2));
            }
        }
    }

    public g(c cVar, f<? super Throwable, ? extends c> fVar) {
        this.f7570e = cVar;
        this.f7571f = fVar;
    }

    /* access modifiers changed from: protected */
    public void m(b bVar) {
        a aVar = new a(bVar, this.f7571f);
        bVar.c(aVar);
        this.f7570e.b(aVar);
    }
}
