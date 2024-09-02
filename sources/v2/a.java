package v2;

import m2.p;
import p2.c;
import q2.b;
import u2.d;

public abstract class a<T, R> implements p<T>, d<R> {

    /* renamed from: e  reason: collision with root package name */
    protected final p<? super R> f7255e;

    /* renamed from: f  reason: collision with root package name */
    protected c f7256f;

    /* renamed from: g  reason: collision with root package name */
    protected d<T> f7257g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f7258h;

    /* renamed from: i  reason: collision with root package name */
    protected int f7259i;

    public a(p<? super R> pVar) {
        this.f7255e = pVar;
    }

    public void a() {
        if (!this.f7258h) {
            this.f7258h = true;
            this.f7255e.a();
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    public final void c(c cVar) {
        if (s2.c.q(this.f7256f, cVar)) {
            this.f7256f = cVar;
            if (cVar instanceof d) {
                this.f7257g = (d) cVar;
            }
            if (e()) {
                this.f7255e.c(this);
                b();
            }
        }
    }

    public void clear() {
        this.f7257g.clear();
    }

    public void dispose() {
        this.f7256f.dispose();
    }

    /* access modifiers changed from: protected */
    public boolean e() {
        return true;
    }

    public boolean f() {
        return this.f7256f.f();
    }

    /* access modifiers changed from: protected */
    public final void g(Throwable th) {
        b.b(th);
        this.f7256f.dispose();
        onError(th);
    }

    /* access modifiers changed from: protected */
    public final int h(int i5) {
        d<T> dVar = this.f7257g;
        if (dVar == null || (i5 & 4) != 0) {
            return 0;
        }
        int i6 = dVar.i(i5);
        if (i6 != 0) {
            this.f7259i = i6;
        }
        return i6;
    }

    public boolean isEmpty() {
        return this.f7257g.isEmpty();
    }

    public final boolean offer(R r5) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void onError(Throwable th) {
        if (this.f7258h) {
            j3.a.r(th);
            return;
        }
        this.f7258h = true;
        this.f7255e.onError(th);
    }
}
