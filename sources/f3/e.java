package f3;

import java.util.concurrent.atomic.AtomicInteger;
import u2.f;
import u4.b;

public final class e<T> extends AtomicInteger implements f<T> {

    /* renamed from: e  reason: collision with root package name */
    final T f4619e;

    /* renamed from: f  reason: collision with root package name */
    final b<? super T> f4620f;

    public e(b<? super T> bVar, T t5) {
        this.f4620f = bVar;
        this.f4619e = t5;
    }

    public void cancel() {
        lazySet(2);
    }

    public void clear() {
        lazySet(1);
    }

    public void f(long j5) {
        if (g.p(j5) && compareAndSet(0, 1)) {
            b<? super T> bVar = this.f4620f;
            bVar.d(this.f4619e);
            if (get() != 2) {
                bVar.a();
            }
        }
    }

    public int i(int i5) {
        return i5 & 1;
    }

    public boolean isEmpty() {
        return get() != 0;
    }

    public boolean offer(T t5) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public T poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.f4619e;
    }
}
