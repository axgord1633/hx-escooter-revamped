package f3;

import u4.b;

public class c<T> extends a<T> {

    /* renamed from: e  reason: collision with root package name */
    protected final b<? super T> f4615e;

    /* renamed from: f  reason: collision with root package name */
    protected T f4616f;

    public c(b<? super T> bVar) {
        this.f4615e = bVar;
    }

    public void cancel() {
        set(4);
        this.f4616f = null;
    }

    public final void clear() {
        lazySet(32);
        this.f4616f = null;
    }

    public final void f(long j5) {
        T t5;
        if (g.p(j5)) {
            do {
                int i5 = get();
                if ((i5 & -2) == 0) {
                    if (i5 == 1) {
                        if (compareAndSet(1, 3) && (t5 = this.f4616f) != null) {
                            this.f4616f = null;
                            b<? super T> bVar = this.f4615e;
                            bVar.d(t5);
                            if (get() != 4) {
                                bVar.a();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    public final void h(T t5) {
        int i5 = get();
        while (i5 != 8) {
            if ((i5 & -3) == 0) {
                if (i5 == 2) {
                    lazySet(3);
                    b<? super T> bVar = this.f4615e;
                    bVar.d(t5);
                    if (get() != 4) {
                        bVar.a();
                        return;
                    }
                    return;
                }
                this.f4616f = t5;
                if (!compareAndSet(0, 1)) {
                    i5 = get();
                    if (i5 == 4) {
                        this.f4616f = null;
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        this.f4616f = t5;
        lazySet(16);
        b<? super T> bVar2 = this.f4615e;
        bVar2.d(t5);
        if (get() != 4) {
            bVar2.a();
        }
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
        lazySet(32);
        T t5 = this.f4616f;
        this.f4616f = null;
        return t5;
    }
}
