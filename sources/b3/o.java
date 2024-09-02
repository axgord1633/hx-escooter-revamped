package b3;

import m2.r;
import m2.t;
import m2.v;
import p2.c;
import r2.f;
import t2.b;

public final class o<T, R> extends r<R> {

    /* renamed from: e  reason: collision with root package name */
    final v<? extends T> f3019e;

    /* renamed from: f  reason: collision with root package name */
    final f<? super T, ? extends R> f3020f;

    static final class a<T, R> implements t<T> {

        /* renamed from: e  reason: collision with root package name */
        final t<? super R> f3021e;

        /* renamed from: f  reason: collision with root package name */
        final f<? super T, ? extends R> f3022f;

        a(t<? super R> tVar, f<? super T, ? extends R> fVar) {
            this.f3021e = tVar;
            this.f3022f = fVar;
        }

        public void b(T t5) {
            try {
                this.f3021e.b(b.e(this.f3022f.apply(t5), "The mapper function returned a null value."));
            } catch (Throwable th) {
                q2.b.b(th);
                onError(th);
            }
        }

        public void c(c cVar) {
            this.f3021e.c(cVar);
        }

        public void onError(Throwable th) {
            this.f3021e.onError(th);
        }
    }

    public o(v<? extends T> vVar, f<? super T, ? extends R> fVar) {
        this.f3019e = vVar;
        this.f3020f = fVar;
    }

    /* access modifiers changed from: protected */
    public void D(t<? super R> tVar) {
        this.f3019e.d(new a(tVar, this.f3020f));
    }
}
