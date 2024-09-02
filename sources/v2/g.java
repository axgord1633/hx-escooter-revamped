package v2;

import m2.p;
import p2.c;
import q2.b;
import r2.a;
import r2.e;
import s2.d;

public final class g<T> implements p<T>, c {

    /* renamed from: e  reason: collision with root package name */
    final p<? super T> f7266e;

    /* renamed from: f  reason: collision with root package name */
    final e<? super c> f7267f;

    /* renamed from: g  reason: collision with root package name */
    final a f7268g;

    /* renamed from: h  reason: collision with root package name */
    c f7269h;

    public g(p<? super T> pVar, e<? super c> eVar, a aVar) {
        this.f7266e = pVar;
        this.f7267f = eVar;
        this.f7268g = aVar;
    }

    public void a() {
        c cVar = this.f7269h;
        s2.c cVar2 = s2.c.DISPOSED;
        if (cVar != cVar2) {
            this.f7269h = cVar2;
            this.f7266e.a();
        }
    }

    public void c(c cVar) {
        try {
            this.f7267f.accept(cVar);
            if (s2.c.q(this.f7269h, cVar)) {
                this.f7269h = cVar;
                this.f7266e.c(this);
            }
        } catch (Throwable th) {
            b.b(th);
            cVar.dispose();
            this.f7269h = s2.c.DISPOSED;
            d.m(th, this.f7266e);
        }
    }

    public void d(T t5) {
        this.f7266e.d(t5);
    }

    public void dispose() {
        c cVar = this.f7269h;
        s2.c cVar2 = s2.c.DISPOSED;
        if (cVar != cVar2) {
            this.f7269h = cVar2;
            try {
                this.f7268g.run();
            } catch (Throwable th) {
                b.b(th);
                j3.a.r(th);
            }
            cVar.dispose();
        }
    }

    public boolean f() {
        return this.f7269h.f();
    }

    public void onError(Throwable th) {
        c cVar = this.f7269h;
        s2.c cVar2 = s2.c.DISPOSED;
        if (cVar != cVar2) {
            this.f7269h = cVar2;
            this.f7266e.onError(th);
            return;
        }
        j3.a.r(th);
    }
}
