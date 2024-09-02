package v2;

import j3.a;
import java.util.concurrent.atomic.AtomicReference;
import m2.t;
import p2.c;
import q2.b;

public final class e<T> extends AtomicReference<c> implements t<T>, c {

    /* renamed from: e  reason: collision with root package name */
    final r2.e<? super T> f7262e;

    /* renamed from: f  reason: collision with root package name */
    final r2.e<? super Throwable> f7263f;

    public e(r2.e<? super T> eVar, r2.e<? super Throwable> eVar2) {
        this.f7262e = eVar;
        this.f7263f = eVar2;
    }

    public void b(T t5) {
        lazySet(s2.c.DISPOSED);
        try {
            this.f7262e.accept(t5);
        } catch (Throwable th) {
            b.b(th);
            a.r(th);
        }
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
        lazySet(s2.c.DISPOSED);
        try {
            this.f7263f.accept(th);
        } catch (Throwable th2) {
            b.b(th2);
            a.r(new q2.a(th, th2));
        }
    }
}
