package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.g;

public final class q<E> {

    /* renamed from: e  reason: collision with root package name */
    public static final a f5621e = new a((g) null);

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f5622f;

    /* renamed from: g  reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f5623g;

    /* renamed from: h  reason: collision with root package name */
    public static final b0 f5624h = new b0("REMOVE_FROZEN");
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ long _state = 0;

    /* renamed from: a  reason: collision with root package name */
    private final int f5625a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f5626b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5627c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ AtomicReferenceArray f5628d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final int a(long j5) {
            return (j5 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j5, int i5) {
            return d(j5, 1073741823) | (((long) i5) << 0);
        }

        public final long c(long j5, int i5) {
            return d(j5, 1152921503533105152L) | (((long) i5) << 30);
        }

        public final long d(long j5, long j6) {
            return j5 & (~j6);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f5629a;

        public b(int i5) {
            this.f5629a = i5;
        }
    }

    static {
        Class<q> cls = q.class;
        f5622f = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_next");
        f5623g = AtomicLongFieldUpdater.newUpdater(cls, "_state");
    }

    public q(int i5, boolean z4) {
        this.f5625a = i5;
        this.f5626b = z4;
        int i6 = i5 - 1;
        this.f5627c = i6;
        this.f5628d = new AtomicReferenceArray(i5);
        boolean z5 = false;
        if (i6 <= 1073741823) {
            if (!((i5 & i6) == 0 ? true : z5)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final q<E> b(long j5) {
        q<E> qVar = new q<>(this.f5625a * 2, this.f5626b);
        int i5 = (int) ((1073741823 & j5) >> 0);
        int i6 = (int) ((1152921503533105152L & j5) >> 30);
        while (true) {
            int i7 = this.f5627c;
            if ((i5 & i7) != (i6 & i7)) {
                Object obj = this.f5628d.get(i7 & i5);
                if (obj == null) {
                    obj = new b(i5);
                }
                qVar.f5628d.set(qVar.f5627c & i5, obj);
                i5++;
            } else {
                qVar._state = f5621e.d(j5, 1152921504606846976L);
                return qVar;
            }
        }
    }

    private final q<E> c(long j5) {
        while (true) {
            q<E> qVar = (q) this._next;
            if (qVar != null) {
                return qVar;
            }
            androidx.concurrent.futures.b.a(f5622f, this, (Object) null, b(j5));
        }
    }

    private final q<E> e(int i5, E e5) {
        Object obj = this.f5628d.get(this.f5627c & i5);
        if (!(obj instanceof b) || ((b) obj).f5629a != i5) {
            return null;
        }
        this.f5628d.set(i5 & this.f5627c, e5);
        return this;
    }

    private final long h() {
        long j5;
        long j6;
        do {
            j5 = this._state;
            if ((j5 & 1152921504606846976L) != 0) {
                return j5;
            }
            j6 = j5 | 1152921504606846976L;
        } while (!f5623g.compareAndSet(this, j5, j6));
        return j6;
    }

    private final q<E> k(int i5, int i6) {
        long j5;
        int i7;
        do {
            j5 = this._state;
            i7 = (int) ((1073741823 & j5) >> 0);
            if ((1152921504606846976L & j5) != 0) {
                return i();
            }
        } while (!f5623g.compareAndSet(this, j5, f5621e.b(j5, i6)));
        this.f5628d.set(i7 & this.f5627c, (Object) null);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068 A[LOOP:1: B:19:0x0068->B:22:0x0079, LOOP_START, PHI: r0 
      PHI: (r0v13 kotlinx.coroutines.internal.q) = (r0v12 kotlinx.coroutines.internal.q), (r0v15 kotlinx.coroutines.internal.q) binds: [B:18:0x0060, B:22:0x0079] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(E r13) {
        /*
            r12 = this;
        L_0x0000:
            long r2 = r12._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0012
            kotlinx.coroutines.internal.q$a r13 = f5621e
            int r13 = r13.a(r2)
            return r13
        L_0x0012:
            r0 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r0 = r0 & r2
            r8 = 0
            long r0 = r0 >> r8
            int r0 = (int) r0
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r1 = 30
            long r4 = r4 >> r1
            int r9 = (int) r4
            int r10 = r12.f5627c
            int r1 = r9 + 2
            r1 = r1 & r10
            r4 = r0 & r10
            r5 = 1
            if (r1 != r4) goto L_0x002e
            return r5
        L_0x002e:
            boolean r1 = r12.f5626b
            r4 = 1073741823(0x3fffffff, float:1.9999999)
            if (r1 != 0) goto L_0x004d
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r12.f5628d
            r11 = r9 & r10
            java.lang.Object r1 = r1.get(r11)
            if (r1 == 0) goto L_0x004d
            int r1 = r12.f5625a
            r2 = 1024(0x400, float:1.435E-42)
            if (r1 < r2) goto L_0x004c
            int r9 = r9 - r0
            r0 = r9 & r4
            int r1 = r1 >> 1
            if (r0 <= r1) goto L_0x0000
        L_0x004c:
            return r5
        L_0x004d:
            int r0 = r9 + 1
            r0 = r0 & r4
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = f5623g
            kotlinx.coroutines.internal.q$a r4 = f5621e
            long r4 = r4.c(r2, r0)
            r0 = r1
            r1 = r12
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L_0x0000
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f5628d
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r12
        L_0x0068:
            long r1 = r0._state
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x007b
            kotlinx.coroutines.internal.q r0 = r0.i()
            kotlinx.coroutines.internal.q r0 = r0.e(r9, r13)
            if (r0 != 0) goto L_0x0068
        L_0x007b:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.q.a(java.lang.Object):int");
    }

    public final boolean d() {
        long j5;
        do {
            j5 = this._state;
            if ((j5 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j5) != 0) {
                return false;
            }
        } while (!f5623g.compareAndSet(this, j5, j5 | 2305843009213693952L));
        return true;
    }

    public final int f() {
        long j5 = this._state;
        return (((int) ((j5 & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j5) >> 0))) & 1073741823;
    }

    public final boolean g() {
        long j5 = this._state;
        return ((int) ((1073741823 & j5) >> 0)) == ((int) ((j5 & 1152921503533105152L) >> 30));
    }

    public final q<E> i() {
        return c(h());
    }

    public final Object j() {
        while (true) {
            long j5 = this._state;
            if ((1152921504606846976L & j5) != 0) {
                return f5624h;
            }
            int i5 = (int) ((1073741823 & j5) >> 0);
            int i6 = this.f5627c;
            if ((((int) ((1152921503533105152L & j5) >> 30)) & i6) == (i5 & i6)) {
                return null;
            }
            Object obj = this.f5628d.get(i6 & i5);
            if (obj == null) {
                if (this.f5626b) {
                    return null;
                }
            } else if (obj instanceof b) {
                return null;
            } else {
                int i7 = (i5 + 1) & 1073741823;
                if (f5623g.compareAndSet(this, j5, f5621e.b(j5, i7))) {
                    this.f5628d.set(this.f5627c & i5, (Object) null);
                    return obj;
                } else if (this.f5626b) {
                    q qVar = this;
                    do {
                        qVar = qVar.k(i5, i7);
                    } while (qVar != null);
                    return obj;
                }
            }
        }
    }
}
