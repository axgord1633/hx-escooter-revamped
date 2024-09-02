package w2;

import java.util.concurrent.Callable;
import m2.b;
import m2.c;
import m2.r;
import m2.t;

public final class i<T> extends r<T> {

    /* renamed from: e  reason: collision with root package name */
    final c f7578e;

    /* renamed from: f  reason: collision with root package name */
    final Callable<? extends T> f7579f;

    /* renamed from: g  reason: collision with root package name */
    final T f7580g;

    final class a implements b {

        /* renamed from: e  reason: collision with root package name */
        private final t<? super T> f7581e;

        a(t<? super T> tVar) {
            this.f7581e = tVar;
        }

        public void a() {
            T t5;
            i iVar = i.this;
            Callable<? extends T> callable = iVar.f7579f;
            if (callable != null) {
                try {
                    t5 = callable.call();
                } catch (Throwable th) {
                    q2.b.b(th);
                    this.f7581e.onError(th);
                    return;
                }
            } else {
                t5 = iVar.f7580g;
            }
            if (t5 == null) {
                this.f7581e.onError(new NullPointerException("The value supplied is null"));
            } else {
                this.f7581e.b(t5);
            }
        }

        public void c(p2.c cVar) {
            this.f7581e.c(cVar);
        }

        public void onError(Throwable th) {
            this.f7581e.onError(th);
        }
    }

    public i(c cVar, Callable<? extends T> callable, T t5) {
        this.f7578e = cVar;
        this.f7580g = t5;
        this.f7579f = callable;
    }

    /* access modifiers changed from: protected */
    public void D(t<? super T> tVar) {
        this.f7578e.b(new a(tVar));
    }
}
