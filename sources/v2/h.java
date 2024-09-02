package v2;

import java.util.concurrent.atomic.AtomicReference;
import m2.p;
import p2.c;
import q2.b;
import r2.a;
import r2.e;

public final class h<T> extends AtomicReference<c> implements p<T>, c {

    /* renamed from: e  reason: collision with root package name */
    final e<? super T> f7270e;

    /* renamed from: f  reason: collision with root package name */
    final e<? super Throwable> f7271f;

    /* renamed from: g  reason: collision with root package name */
    final a f7272g;

    /* renamed from: h  reason: collision with root package name */
    final e<? super c> f7273h;

    public h(e<? super T> eVar, e<? super Throwable> eVar2, a aVar, e<? super c> eVar3) {
        this.f7270e = eVar;
        this.f7271f = eVar2;
        this.f7272g = aVar;
        this.f7273h = eVar3;
    }

    public void a() {
        if (!f()) {
            lazySet(s2.c.DISPOSED);
            try {
                this.f7272g.run();
            } catch (Throwable th) {
                b.b(th);
                j3.a.r(th);
            }
        }
    }

    public void c(c cVar) {
        if (s2.c.o(this, cVar)) {
            try {
                this.f7273h.accept(this);
            } catch (Throwable th) {
                b.b(th);
                cVar.dispose();
                onError(th);
            }
        }
    }

    public void d(T t5) {
        if (!f()) {
            try {
                this.f7270e.accept(t5);
            } catch (Throwable th) {
                b.b(th);
                ((c) get()).dispose();
                onError(th);
            }
        }
    }

    public void dispose() {
        s2.c.c(this);
    }

    public boolean f() {
        return get() == s2.c.DISPOSED;
    }

    public void onError(Throwable th) {
        if (!f()) {
            lazySet(s2.c.DISPOSED);
            try {
                this.f7271f.accept(th);
            } catch (Throwable th2) {
                b.b(th2);
                j3.a.r(new q2.a(th, th2));
            }
        } else {
            j3.a.r(th);
        }
    }
}
