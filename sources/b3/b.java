package b3;

import java.util.concurrent.atomic.AtomicReference;
import m2.r;
import m2.s;
import m2.t;
import m2.u;
import p2.c;

public final class b<T> extends r<T> {

    /* renamed from: e  reason: collision with root package name */
    final u<T> f2981e;

    static final class a<T> extends AtomicReference<c> implements s<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final t<? super T> f2982e;

        a(t<? super T> tVar) {
            this.f2982e = tVar;
        }

        public void a(Throwable th) {
            if (!e(th)) {
                j3.a.r(th);
            }
        }

        public void b(T t5) {
            c cVar;
            Object obj = get();
            s2.c cVar2 = s2.c.DISPOSED;
            if (obj != cVar2 && (cVar = (c) getAndSet(cVar2)) != cVar2) {
                if (t5 == null) {
                    try {
                        this.f2982e.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                    } catch (Throwable th) {
                        if (cVar != null) {
                            cVar.dispose();
                        }
                        throw th;
                    }
                } else {
                    this.f2982e.b(t5);
                }
                if (cVar != null) {
                    cVar.dispose();
                }
            }
        }

        public void c(c cVar) {
            s2.c.n(this, cVar);
        }

        public void dispose() {
            s2.c.c(this);
        }

        public boolean e(Throwable th) {
            c cVar;
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            Object obj = get();
            s2.c cVar2 = s2.c.DISPOSED;
            if (obj == cVar2 || (cVar = (c) getAndSet(cVar2)) == cVar2) {
                return false;
            }
            try {
                this.f2982e.onError(th);
            } finally {
                if (cVar != null) {
                    cVar.dispose();
                }
            }
        }

        public boolean f() {
            return s2.c.i((c) get());
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{a.class.getSimpleName(), super.toString()});
        }
    }

    public b(u<T> uVar) {
        this.f2981e = uVar;
    }

    /* access modifiers changed from: protected */
    public void D(t<? super T> tVar) {
        a aVar = new a(tVar);
        tVar.c(aVar);
        try {
            this.f2981e.a(aVar);
        } catch (Throwable th) {
            q2.b.b(th);
            aVar.a(th);
        }
    }
}
