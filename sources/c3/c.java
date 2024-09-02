package c3;

import g3.j;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import u2.h;

public final class c<T> implements h<T> {

    /* renamed from: m  reason: collision with root package name */
    static final int f3089m = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: n  reason: collision with root package name */
    private static final Object f3090n = new Object();

    /* renamed from: e  reason: collision with root package name */
    final AtomicLong f3091e = new AtomicLong();

    /* renamed from: f  reason: collision with root package name */
    int f3092f;

    /* renamed from: g  reason: collision with root package name */
    long f3093g;

    /* renamed from: h  reason: collision with root package name */
    final int f3094h;

    /* renamed from: i  reason: collision with root package name */
    AtomicReferenceArray<Object> f3095i;

    /* renamed from: j  reason: collision with root package name */
    final int f3096j;

    /* renamed from: k  reason: collision with root package name */
    AtomicReferenceArray<Object> f3097k;

    /* renamed from: l  reason: collision with root package name */
    final AtomicLong f3098l = new AtomicLong();

    public c(int i5) {
        int a5 = j.a(Math.max(8, i5));
        int i6 = a5 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(a5 + 1);
        this.f3095i = atomicReferenceArray;
        this.f3094h = i6;
        a(a5);
        this.f3097k = atomicReferenceArray;
        this.f3096j = i6;
        this.f3093g = (long) (i6 - 1);
        p(0);
    }

    private void a(int i5) {
        this.f3092f = Math.min(i5 / 4, f3089m);
    }

    private static int b(int i5) {
        return i5;
    }

    private static int c(long j5, int i5) {
        return b(((int) j5) & i5);
    }

    private long d() {
        return this.f3098l.get();
    }

    private long e() {
        return this.f3091e.get();
    }

    private long f() {
        return this.f3098l.get();
    }

    private static <E> Object g(AtomicReferenceArray<Object> atomicReferenceArray, int i5) {
        return atomicReferenceArray.get(i5);
    }

    private AtomicReferenceArray<Object> h(AtomicReferenceArray<Object> atomicReferenceArray, int i5) {
        int b5 = b(i5);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) g(atomicReferenceArray, b5);
        n(atomicReferenceArray, b5, (Object) null);
        return atomicReferenceArray2;
    }

    private long j() {
        return this.f3091e.get();
    }

    private T k(AtomicReferenceArray<Object> atomicReferenceArray, long j5, int i5) {
        this.f3097k = atomicReferenceArray;
        int c5 = c(j5, i5);
        T g5 = g(atomicReferenceArray, c5);
        if (g5 != null) {
            n(atomicReferenceArray, c5, (Object) null);
            m(j5 + 1);
        }
        return g5;
    }

    private void l(AtomicReferenceArray<Object> atomicReferenceArray, long j5, int i5, T t5, long j6) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f3095i = atomicReferenceArray2;
        this.f3093g = (j6 + j5) - 1;
        n(atomicReferenceArray2, i5, t5);
        o(atomicReferenceArray, atomicReferenceArray2);
        n(atomicReferenceArray, i5, f3090n);
        p(j5 + 1);
    }

    private void m(long j5) {
        this.f3098l.lazySet(j5);
    }

    private static void n(AtomicReferenceArray<Object> atomicReferenceArray, int i5, Object obj) {
        atomicReferenceArray.lazySet(i5, obj);
    }

    private void o(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        n(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void p(long j5) {
        this.f3091e.lazySet(j5);
    }

    private boolean q(AtomicReferenceArray<Object> atomicReferenceArray, T t5, long j5, int i5) {
        n(atomicReferenceArray, i5, t5);
        p(j5 + 1);
        return true;
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public boolean isEmpty() {
        return j() == f();
    }

    public boolean offer(T t5) {
        if (t5 != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.f3095i;
            long e5 = e();
            int i5 = this.f3094h;
            int c5 = c(e5, i5);
            if (e5 < this.f3093g) {
                return q(atomicReferenceArray, t5, e5, c5);
            }
            long j5 = ((long) this.f3092f) + e5;
            if (g(atomicReferenceArray, c(j5, i5)) == null) {
                this.f3093g = j5 - 1;
                return q(atomicReferenceArray, t5, e5, c5);
            } else if (g(atomicReferenceArray, c(1 + e5, i5)) == null) {
                return q(atomicReferenceArray, t5, e5, c5);
            } else {
                l(atomicReferenceArray, e5, c5, t5, (long) i5);
                return true;
            }
        } else {
            throw new NullPointerException("Null is not a valid element");
        }
    }

    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f3097k;
        long d5 = d();
        int i5 = this.f3096j;
        int c5 = c(d5, i5);
        T g5 = g(atomicReferenceArray, c5);
        boolean z4 = g5 == f3090n;
        if (g5 != null && !z4) {
            n(atomicReferenceArray, c5, (Object) null);
            m(d5 + 1);
            return g5;
        } else if (z4) {
            return k(h(atomicReferenceArray, i5 + 1), d5, i5);
        } else {
            return null;
        }
    }
}
