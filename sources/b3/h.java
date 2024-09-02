package b3;

import m2.r;
import m2.t;
import m2.v;
import p2.c;
import q2.b;
import r2.e;

public final class h<T> extends r<T> {

    /* renamed from: e  reason: collision with root package name */
    final v<T> f3003e;

    /* renamed from: f  reason: collision with root package name */
    final e<? super T> f3004f;

    final class a implements t<T> {

        /* renamed from: e  reason: collision with root package name */
        final t<? super T> f3005e;

        a(t<? super T> tVar) {
            this.f3005e = tVar;
        }

        public void b(T t5) {
            try {
                h.this.f3004f.accept(t5);
                this.f3005e.b(t5);
            } catch (Throwable th) {
                b.b(th);
                this.f3005e.onError(th);
            }
        }

        public void c(c cVar) {
            this.f3005e.c(cVar);
        }

        public void onError(Throwable th) {
            this.f3005e.onError(th);
        }
    }

    public h(v<T> vVar, e<? super T> eVar) {
        this.f3003e = vVar;
        this.f3004f = eVar;
    }

    /* access modifiers changed from: protected */
    public void D(t<? super T> tVar) {
        this.f3003e.d(new a(tVar));
    }
}
