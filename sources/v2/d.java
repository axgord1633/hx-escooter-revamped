package v2;

import java.util.concurrent.atomic.AtomicReference;
import m2.b;
import p2.c;
import r2.a;
import r2.e;

public final class d extends AtomicReference<c> implements b, c, e<Throwable> {

    /* renamed from: e  reason: collision with root package name */
    final e<? super Throwable> f7260e;

    /* renamed from: f  reason: collision with root package name */
    final a f7261f;

    public d(e<? super Throwable> eVar, a aVar) {
        this.f7260e = eVar;
        this.f7261f = aVar;
    }

    public void a() {
        try {
            this.f7261f.run();
        } catch (Throwable th) {
            q2.b.b(th);
            j3.a.r(th);
        }
        lazySet(s2.c.DISPOSED);
    }

    /* renamed from: b */
    public void accept(Throwable th) {
        j3.a.r(new q2.d(th));
    }

    public void c(c cVar) {
        s2.c.o(this, cVar);
    }

    public void dispose() {
        s2.c.c(this);
    }

    public boolean f() {
        return get() == s2.c.DISPOSED;
    }

    public void onError(Throwable th) {
        try {
            this.f7260e.accept(th);
        } catch (Throwable th2) {
            q2.b.b(th2);
            j3.a.r(th2);
        }
        lazySet(s2.c.DISPOSED);
    }
}
