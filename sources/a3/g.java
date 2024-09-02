package a3;

import java.util.concurrent.atomic.AtomicReference;
import m2.k;
import m2.l;
import m2.m;
import m2.p;
import p2.c;
import q2.b;
import r2.d;

public final class g<T> extends k<T> {

    /* renamed from: e  reason: collision with root package name */
    final m<T> f152e;

    static final class a<T> extends AtomicReference<c> implements l<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f153e;

        a(p<? super T> pVar) {
            this.f153e = pVar;
        }

        public void a() {
            if (!f()) {
                try {
                    this.f153e.a();
                } finally {
                    dispose();
                }
            }
        }

        public void b(Throwable th) {
            if (!e(th)) {
                j3.a.r(th);
            }
        }

        public void c(c cVar) {
            s2.c.n(this, cVar);
        }

        public void d(T t5) {
            if (t5 == null) {
                b(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (!f()) {
                this.f153e.d(t5);
            }
        }

        public void dispose() {
            s2.c.c(this);
        }

        /* JADX INFO: finally extract failed */
        public boolean e(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (f()) {
                return false;
            }
            try {
                this.f153e.onError(th);
                dispose();
                return true;
            } catch (Throwable th2) {
                dispose();
                throw th2;
            }
        }

        public boolean f() {
            return s2.c.i((c) get());
        }

        public void g(d dVar) {
            c(new s2.a(dVar));
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{a.class.getSimpleName(), super.toString()});
        }
    }

    public g(m<T> mVar) {
        this.f152e = mVar;
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super T> pVar) {
        a aVar = new a(pVar);
        pVar.c(aVar);
        try {
            this.f152e.a(aVar);
        } catch (Throwable th) {
            b.b(th);
            aVar.b(th);
        }
    }
}
