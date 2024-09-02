package b3;

import m2.r;
import m2.t;
import m2.v;
import p2.c;
import q2.b;
import r2.e;

public final class f<T> extends r<T> {

    /* renamed from: e  reason: collision with root package name */
    final v<T> f2994e;

    /* renamed from: f  reason: collision with root package name */
    final e<? super Throwable> f2995f;

    final class a implements t<T> {

        /* renamed from: e  reason: collision with root package name */
        private final t<? super T> f2996e;

        a(t<? super T> tVar) {
            this.f2996e = tVar;
        }

        public void b(T t5) {
            this.f2996e.b(t5);
        }

        public void c(c cVar) {
            this.f2996e.c(cVar);
        }

        public void onError(Throwable th) {
            try {
                f.this.f2995f.accept(th);
            } catch (Throwable th2) {
                b.b(th2);
                th = new q2.a(th, th2);
            }
            this.f2996e.onError(th);
        }
    }

    public f(v<T> vVar, e<? super Throwable> eVar) {
        this.f2994e = vVar;
        this.f2995f = eVar;
    }

    /* access modifiers changed from: protected */
    public void D(t<? super T> tVar) {
        this.f2994e.d(new a(tVar));
    }
}
