package z2;

import java.util.concurrent.atomic.AtomicReference;
import m2.k;
import m2.n;
import m2.p;
import m2.t;
import m2.v;
import p2.c;
import r2.f;
import t2.b;

public final class d<T, R> extends k<R> {

    /* renamed from: e  reason: collision with root package name */
    final v<T> f7911e;

    /* renamed from: f  reason: collision with root package name */
    final f<? super T, ? extends n<? extends R>> f7912f;

    static final class a<T, R> extends AtomicReference<c> implements p<R>, t<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super R> f7913e;

        /* renamed from: f  reason: collision with root package name */
        final f<? super T, ? extends n<? extends R>> f7914f;

        a(p<? super R> pVar, f<? super T, ? extends n<? extends R>> fVar) {
            this.f7913e = pVar;
            this.f7914f = fVar;
        }

        public void a() {
            this.f7913e.a();
        }

        public void b(T t5) {
            try {
                ((n) b.e(this.f7914f.apply(t5), "The mapper returned a null Publisher")).g(this);
            } catch (Throwable th) {
                q2.b.b(th);
                this.f7913e.onError(th);
            }
        }

        public void c(c cVar) {
            s2.c.l(this, cVar);
        }

        public void d(R r5) {
            this.f7913e.d(r5);
        }

        public void dispose() {
            s2.c.c(this);
        }

        public boolean f() {
            return s2.c.i((c) get());
        }

        public void onError(Throwable th) {
            this.f7913e.onError(th);
        }
    }

    public d(v<T> vVar, f<? super T, ? extends n<? extends R>> fVar) {
        this.f7911e = vVar;
        this.f7912f = fVar;
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super R> pVar) {
        a aVar = new a(pVar, this.f7912f);
        pVar.c(aVar);
        this.f7911e.d(aVar);
    }
}
