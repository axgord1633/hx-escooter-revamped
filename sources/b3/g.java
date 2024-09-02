package b3;

import m2.r;
import m2.t;
import m2.v;
import p2.c;
import q2.b;
import r2.e;
import s2.d;

public final class g<T> extends r<T> {

    /* renamed from: e  reason: collision with root package name */
    final v<T> f2998e;

    /* renamed from: f  reason: collision with root package name */
    final e<? super c> f2999f;

    static final class a<T> implements t<T> {

        /* renamed from: e  reason: collision with root package name */
        final t<? super T> f3000e;

        /* renamed from: f  reason: collision with root package name */
        final e<? super c> f3001f;

        /* renamed from: g  reason: collision with root package name */
        boolean f3002g;

        a(t<? super T> tVar, e<? super c> eVar) {
            this.f3000e = tVar;
            this.f3001f = eVar;
        }

        public void b(T t5) {
            if (!this.f3002g) {
                this.f3000e.b(t5);
            }
        }

        public void c(c cVar) {
            try {
                this.f3001f.accept(cVar);
                this.f3000e.c(cVar);
            } catch (Throwable th) {
                b.b(th);
                this.f3002g = true;
                cVar.dispose();
                d.n(th, this.f3000e);
            }
        }

        public void onError(Throwable th) {
            if (this.f3002g) {
                j3.a.r(th);
            } else {
                this.f3000e.onError(th);
            }
        }
    }

    public g(v<T> vVar, e<? super c> eVar) {
        this.f2998e = vVar;
        this.f2999f = eVar;
    }

    /* access modifiers changed from: protected */
    public void D(t<? super T> tVar) {
        this.f2998e.d(new a(tVar, this.f2999f));
    }
}
