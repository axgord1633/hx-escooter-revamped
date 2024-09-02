package l1;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import w0.p;

final class v<TResult> extends g<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f5723a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final s f5724b = new s();

    /* renamed from: c  reason: collision with root package name */
    private boolean f5725c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f5726d;

    /* renamed from: e  reason: collision with root package name */
    private Object f5727e;

    /* renamed from: f  reason: collision with root package name */
    private Exception f5728f;

    v() {
    }

    private final void r() {
        p.j(this.f5725c, "Task is not yet complete");
    }

    private final void s() {
        if (this.f5726d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void t() {
        if (this.f5725c) {
            throw b.a(this);
        }
    }

    private final void u() {
        synchronized (this.f5723a) {
            if (this.f5725c) {
                this.f5724b.b(this);
            }
        }
    }

    public final g<TResult> a(Executor executor, c<TResult> cVar) {
        this.f5724b.a(new m(executor, cVar));
        u();
        return this;
    }

    public final g<TResult> b(c<TResult> cVar) {
        this.f5724b.a(new m(i.f5697a, cVar));
        u();
        return this;
    }

    public final g<TResult> c(d dVar) {
        k(i.f5697a, dVar);
        return this;
    }

    public final g<TResult> d(e<? super TResult> eVar) {
        l(i.f5697a, eVar);
        return this;
    }

    public final <TContinuationResult> g<TContinuationResult> e(Executor executor, a<TResult, TContinuationResult> aVar) {
        v vVar = new v();
        this.f5724b.a(new k(executor, aVar, vVar));
        u();
        return vVar;
    }

    public final Exception f() {
        Exception exc;
        synchronized (this.f5723a) {
            exc = this.f5728f;
        }
        return exc;
    }

    public final TResult g() {
        TResult tresult;
        synchronized (this.f5723a) {
            r();
            s();
            Exception exc = this.f5728f;
            if (exc == null) {
                tresult = this.f5727e;
            } else {
                throw new f(exc);
            }
        }
        return tresult;
    }

    public final boolean h() {
        return this.f5726d;
    }

    public final boolean i() {
        boolean z4;
        synchronized (this.f5723a) {
            z4 = this.f5725c;
        }
        return z4;
    }

    public final boolean j() {
        boolean z4;
        synchronized (this.f5723a) {
            z4 = false;
            if (this.f5725c && !this.f5726d && this.f5728f == null) {
                z4 = true;
            }
        }
        return z4;
    }

    public final g<TResult> k(Executor executor, d dVar) {
        this.f5724b.a(new o(executor, dVar));
        u();
        return this;
    }

    public final g<TResult> l(Executor executor, e<? super TResult> eVar) {
        this.f5724b.a(new q(executor, eVar));
        u();
        return this;
    }

    public final void m(Exception exc) {
        p.h(exc, "Exception must not be null");
        synchronized (this.f5723a) {
            t();
            this.f5725c = true;
            this.f5728f = exc;
        }
        this.f5724b.b(this);
    }

    public final void n(Object obj) {
        synchronized (this.f5723a) {
            t();
            this.f5725c = true;
            this.f5727e = obj;
        }
        this.f5724b.b(this);
    }

    public final boolean o() {
        synchronized (this.f5723a) {
            if (this.f5725c) {
                return false;
            }
            this.f5725c = true;
            this.f5726d = true;
            this.f5724b.b(this);
            return true;
        }
    }

    public final boolean p(Exception exc) {
        p.h(exc, "Exception must not be null");
        synchronized (this.f5723a) {
            if (this.f5725c) {
                return false;
            }
            this.f5725c = true;
            this.f5728f = exc;
            this.f5724b.b(this);
            return true;
        }
    }

    public final boolean q(Object obj) {
        synchronized (this.f5723a) {
            if (this.f5725c) {
                return false;
            }
            this.f5725c = true;
            this.f5727e = obj;
            this.f5724b.b(this);
            return true;
        }
    }
}
