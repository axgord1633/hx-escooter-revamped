package v2;

import j3.a;
import m2.p;

public class f<T> extends b<T> {

    /* renamed from: e  reason: collision with root package name */
    protected final p<? super T> f7264e;

    /* renamed from: f  reason: collision with root package name */
    protected T f7265f;

    public f(p<? super T> pVar) {
        this.f7264e = pVar;
    }

    public final void clear() {
        lazySet(32);
        this.f7265f = null;
    }

    public void dispose() {
        set(4);
        this.f7265f = null;
    }

    public final void e() {
        if ((get() & 54) == 0) {
            lazySet(2);
            this.f7264e.a();
        }
    }

    public final boolean f() {
        return get() == 4;
    }

    public final void g(T t5) {
        int i5 = get();
        if ((i5 & 54) == 0) {
            p<? super T> pVar = this.f7264e;
            if (i5 == 8) {
                this.f7265f = t5;
                lazySet(16);
                t5 = null;
            } else {
                lazySet(2);
            }
            pVar.d(t5);
            if (get() != 4) {
                pVar.a();
            }
        }
    }

    public final void h(Throwable th) {
        if ((get() & 54) != 0) {
            a.r(th);
            return;
        }
        lazySet(2);
        this.f7264e.onError(th);
    }

    public final int i(int i5) {
        if ((i5 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final boolean isEmpty() {
        return get() != 16;
    }

    public final T poll() {
        if (get() != 16) {
            return null;
        }
        T t5 = this.f7265f;
        this.f7265f = null;
        lazySet(32);
        return t5;
    }
}
