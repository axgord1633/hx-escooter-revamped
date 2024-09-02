package c3;

import g3.j;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import u2.h;

public final class b<E> extends AtomicReferenceArray<E> implements h<E> {

    /* renamed from: j  reason: collision with root package name */
    private static final Integer f3083j = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* renamed from: e  reason: collision with root package name */
    final int f3084e = (length() - 1);

    /* renamed from: f  reason: collision with root package name */
    final AtomicLong f3085f = new AtomicLong();

    /* renamed from: g  reason: collision with root package name */
    long f3086g;

    /* renamed from: h  reason: collision with root package name */
    final AtomicLong f3087h = new AtomicLong();

    /* renamed from: i  reason: collision with root package name */
    final int f3088i;

    public b(int i5) {
        super(j.a(i5));
        this.f3088i = Math.min(i5 / 4, f3083j.intValue());
    }

    /* access modifiers changed from: package-private */
    public int a(long j5) {
        return ((int) j5) & this.f3084e;
    }

    /* access modifiers changed from: package-private */
    public int b(long j5, int i5) {
        return ((int) j5) & i5;
    }

    /* access modifiers changed from: package-private */
    public E c(int i5) {
        return get(i5);
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(long j5) {
        this.f3087h.lazySet(j5);
    }

    /* access modifiers changed from: package-private */
    public void e(int i5, E e5) {
        lazySet(i5, e5);
    }

    /* access modifiers changed from: package-private */
    public void f(long j5) {
        this.f3085f.lazySet(j5);
    }

    public boolean isEmpty() {
        return this.f3085f.get() == this.f3087h.get();
    }

    public boolean offer(E e5) {
        if (e5 != null) {
            int i5 = this.f3084e;
            long j5 = this.f3085f.get();
            int b5 = b(j5, i5);
            if (j5 >= this.f3086g) {
                long j6 = ((long) this.f3088i) + j5;
                if (c(b(j6, i5)) == null) {
                    this.f3086g = j6;
                } else if (c(b5) != null) {
                    return false;
                }
            }
            e(b5, e5);
            f(j5 + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public E poll() {
        long j5 = this.f3087h.get();
        int a5 = a(j5);
        E c5 = c(a5);
        if (c5 == null) {
            return null;
        }
        d(j5 + 1);
        e(a5, (Object) null);
        return c5;
    }
}
