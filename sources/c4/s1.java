package c4;

import c4.l1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.internal.n;
import kotlinx.coroutines.internal.o;
import kotlinx.coroutines.internal.w;
import m3.q;
import o3.g;
import v3.l;
import v3.p;

public class s1 implements l1, s, z1 {

    /* renamed from: e  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f3157e = AtomicReferenceFieldUpdater.newUpdater(s1.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    private static final class a extends r1 {

        /* renamed from: i  reason: collision with root package name */
        private final s1 f3158i;

        /* renamed from: j  reason: collision with root package name */
        private final b f3159j;

        /* renamed from: k  reason: collision with root package name */
        private final r f3160k;

        /* renamed from: l  reason: collision with root package name */
        private final Object f3161l;

        public a(s1 s1Var, b bVar, r rVar, Object obj) {
            this.f3158i = s1Var;
            this.f3159j = bVar;
            this.f3160k = rVar;
            this.f3161l = obj;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            w((Throwable) obj);
            return q.f5904a;
        }

        public void w(Throwable th) {
            this.f3158i.L(this.f3159j, this.f3160k, this.f3161l);
        }
    }

    private static final class b implements g1 {
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;

        /* renamed from: e  reason: collision with root package name */
        private final w1 f3162e;

        public b(w1 w1Var, boolean z4, Throwable th) {
            this.f3162e = w1Var;
            this._isCompleting = z4 ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList<Throwable> c() {
            return new ArrayList<>(4);
        }

        private final Object d() {
            return this._exceptionsHolder;
        }

        private final void l(Object obj) {
            this._exceptionsHolder = obj;
        }

        public final void a(Throwable th) {
            Throwable f5 = f();
            if (f5 == null) {
                m(th);
            } else if (th != f5) {
                Object d5 = d();
                if (d5 == null) {
                    l(th);
                } else if (d5 instanceof Throwable) {
                    if (th != d5) {
                        ArrayList<Throwable> c5 = c();
                        c5.add(d5);
                        c5.add(th);
                        l(c5);
                    }
                } else if (d5 instanceof ArrayList) {
                    ((ArrayList) d5).add(th);
                } else {
                    throw new IllegalStateException(("State is " + d5).toString());
                }
            }
        }

        public boolean b() {
            return f() == null;
        }

        public w1 e() {
            return this.f3162e;
        }

        public final Throwable f() {
            return (Throwable) this._rootCause;
        }

        public final boolean g() {
            return f() != null;
        }

        /* JADX WARNING: type inference failed for: r0v0, types: [int, boolean] */
        public final boolean h() {
            return this._isCompleting;
        }

        public final boolean i() {
            return d() == t1.f3173e;
        }

        public final List<Throwable> j(Throwable th) {
            ArrayList<Throwable> arrayList;
            Object d5 = d();
            if (d5 == null) {
                arrayList = c();
            } else if (d5 instanceof Throwable) {
                ArrayList<Throwable> c5 = c();
                c5.add(d5);
                arrayList = c5;
            } else if (d5 instanceof ArrayList) {
                arrayList = (ArrayList) d5;
            } else {
                throw new IllegalStateException(("State is " + d5).toString());
            }
            Throwable f5 = f();
            if (f5 != null) {
                arrayList.add(0, f5);
            }
            if (th != null && !k.a(th, f5)) {
                arrayList.add(th);
            }
            l(t1.f3173e);
            return arrayList;
        }

        public final void k(boolean z4) {
            this._isCompleting = z4 ? 1 : 0;
        }

        public final void m(Throwable th) {
            this._rootCause = th;
        }

        public String toString() {
            return "Finishing[cancelling=" + g() + ", completing=" + h() + ", rootCause=" + f() + ", exceptions=" + d() + ", list=" + e() + ']';
        }
    }

    public static final class c extends o.a {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ s1 f3163d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f3164e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(o oVar, s1 s1Var, Object obj) {
            super(oVar);
            this.f3163d = s1Var;
            this.f3164e = obj;
        }

        /* renamed from: i */
        public Object g(o oVar) {
            if (this.f3163d.V() == this.f3164e) {
                return null;
            }
            return n.a();
        }
    }

    public s1(boolean z4) {
        this._state = z4 ? t1.f3175g : t1.f3174f;
        this._parentHandle = null;
    }

    private final Object G(Object obj) {
        Object w02;
        do {
            Object V = V();
            if (!(V instanceof g1) || ((V instanceof b) && ((b) V).h())) {
                return t1.f3169a;
            }
            w02 = w0(V, new v(M(obj), false, 2, (g) null));
        } while (w02 == t1.f3171c);
        return w02;
    }

    private final boolean H(Throwable th) {
        if (a0()) {
            return true;
        }
        boolean z4 = th instanceof CancellationException;
        q U = U();
        return (U == null || U == x1.f3195e) ? z4 : U.f(th) || z4;
    }

    private final void K(g1 g1Var, Object obj) {
        q U = U();
        if (U != null) {
            U.dispose();
            o0(x1.f3195e);
        }
        Throwable th = null;
        v vVar = obj instanceof v ? (v) obj : null;
        if (vVar != null) {
            th = vVar.f3183a;
        }
        if (g1Var instanceof r1) {
            try {
                ((r1) g1Var).w(th);
            } catch (Throwable th2) {
                X(new y("Exception in completion handler " + g1Var + " for " + this, th2));
            }
        } else {
            w1 e5 = g1Var.e();
            if (e5 != null) {
                h0(e5, th);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void L(b bVar, r rVar, Object obj) {
        r f02 = f0(rVar);
        if (f02 == null || !y0(bVar, f02, obj)) {
            x(N(bVar, obj));
        }
    }

    private final Throwable M(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new m1(I(), (Throwable) null, this) : th;
        } else if (obj != null) {
            return ((z1) obj).w();
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        }
    }

    private final Object N(b bVar, Object obj) {
        boolean g5;
        Throwable Q;
        v vVar = obj instanceof v ? (v) obj : null;
        Throwable th = vVar != null ? vVar.f3183a : null;
        synchronized (bVar) {
            g5 = bVar.g();
            List<Throwable> j5 = bVar.j(th);
            Q = Q(bVar, j5);
            if (Q != null) {
                u(Q, j5);
            }
        }
        boolean z4 = false;
        if (!(Q == null || Q == th)) {
            obj = new v(Q, false, 2, (g) null);
        }
        if (Q != null) {
            if (H(Q) || W(Q)) {
                z4 = true;
            }
            if (z4) {
                if (obj != null) {
                    ((v) obj).b();
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                }
            }
        }
        if (!g5) {
            i0(Q);
        }
        j0(obj);
        androidx.concurrent.futures.b.a(f3157e, this, bVar, t1.g(obj));
        K(bVar, obj);
        return obj;
    }

    private final r O(g1 g1Var) {
        r rVar = g1Var instanceof r ? (r) g1Var : null;
        if (rVar != null) {
            return rVar;
        }
        w1 e5 = g1Var.e();
        if (e5 != null) {
            return f0(e5);
        }
        return null;
    }

    private final Throwable P(Object obj) {
        v vVar = obj instanceof v ? (v) obj : null;
        if (vVar != null) {
            return vVar.f3183a;
        }
        return null;
    }

    private final Throwable Q(b bVar, List<? extends Throwable> list) {
        T t5 = null;
        if (!list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (!(((Throwable) next) instanceof CancellationException)) {
                    t5 = next;
                    break;
                }
            }
            Throwable th = (Throwable) t5;
            return th != null ? th : (Throwable) list.get(0);
        } else if (bVar.g()) {
            return new m1(I(), (Throwable) null, this);
        } else {
            return null;
        }
    }

    private final w1 T(g1 g1Var) {
        w1 e5 = g1Var.e();
        if (e5 != null) {
            return e5;
        }
        if (g1Var instanceof v0) {
            return new w1();
        }
        if (g1Var instanceof r1) {
            m0((r1) g1Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + g1Var).toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
        if (r0 == null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        g0(((c4.s1.b) r2).e(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004d, code lost:
        return c4.t1.f3169a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object b0(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            java.lang.Object r2 = r6.V()
            boolean r3 = r2 instanceof c4.s1.b
            if (r3 == 0) goto L_0x0051
            monitor-enter(r2)
            r3 = r2
            c4.s1$b r3 = (c4.s1.b) r3     // Catch:{ all -> 0x004e }
            boolean r3 = r3.i()     // Catch:{ all -> 0x004e }
            if (r3 == 0) goto L_0x001a
            kotlinx.coroutines.internal.b0 r7 = c4.t1.f3172d     // Catch:{ all -> 0x004e }
            monitor-exit(r2)
            return r7
        L_0x001a:
            r3 = r2
            c4.s1$b r3 = (c4.s1.b) r3     // Catch:{ all -> 0x004e }
            boolean r3 = r3.g()     // Catch:{ all -> 0x004e }
            if (r7 != 0) goto L_0x0025
            if (r3 != 0) goto L_0x0031
        L_0x0025:
            if (r1 != 0) goto L_0x002b
            java.lang.Throwable r1 = r6.M(r7)     // Catch:{ all -> 0x004e }
        L_0x002b:
            r7 = r2
            c4.s1$b r7 = (c4.s1.b) r7     // Catch:{ all -> 0x004e }
            r7.a(r1)     // Catch:{ all -> 0x004e }
        L_0x0031:
            r7 = r2
            c4.s1$b r7 = (c4.s1.b) r7     // Catch:{ all -> 0x004e }
            java.lang.Throwable r7 = r7.f()     // Catch:{ all -> 0x004e }
            r1 = r3 ^ 1
            if (r1 == 0) goto L_0x003d
            r0 = r7
        L_0x003d:
            monitor-exit(r2)
            if (r0 == 0) goto L_0x0049
            c4.s1$b r2 = (c4.s1.b) r2
            c4.w1 r7 = r2.e()
            r6.g0(r7, r0)
        L_0x0049:
            kotlinx.coroutines.internal.b0 r7 = c4.t1.f3169a
            return r7
        L_0x004e:
            r7 = move-exception
            monitor-exit(r2)
            throw r7
        L_0x0051:
            boolean r3 = r2 instanceof c4.g1
            if (r3 == 0) goto L_0x00a2
            if (r1 != 0) goto L_0x005b
            java.lang.Throwable r1 = r6.M(r7)
        L_0x005b:
            r3 = r2
            c4.g1 r3 = (c4.g1) r3
            boolean r4 = r3.b()
            if (r4 == 0) goto L_0x006f
            boolean r2 = r6.v0(r3, r1)
            if (r2 == 0) goto L_0x0002
            kotlinx.coroutines.internal.b0 r7 = c4.t1.f3169a
            return r7
        L_0x006f:
            c4.v r3 = new c4.v
            r4 = 0
            r5 = 2
            r3.<init>(r1, r4, r5, r0)
            java.lang.Object r3 = r6.w0(r2, r3)
            kotlinx.coroutines.internal.b0 r4 = c4.t1.f3169a
            if (r3 == r4) goto L_0x0087
            kotlinx.coroutines.internal.b0 r2 = c4.t1.f3171c
            if (r3 == r2) goto L_0x0002
            return r3
        L_0x0087:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot happen in "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x00a2:
            kotlinx.coroutines.internal.b0 r7 = c4.t1.f3172d
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.s1.b0(java.lang.Object):java.lang.Object");
    }

    private final r1 d0(l<? super Throwable, q> lVar, boolean z4) {
        r1 r1Var = null;
        if (z4) {
            if (lVar instanceof n1) {
                r1Var = (n1) lVar;
            }
            if (r1Var == null) {
                r1Var = new j1(lVar);
            }
        } else {
            if (lVar instanceof r1) {
                r1Var = (r1) lVar;
            }
            if (r1Var == null) {
                r1Var = new k1(lVar);
            }
        }
        r1Var.y(this);
        return r1Var;
    }

    private final r f0(o oVar) {
        while (oVar.r()) {
            oVar = oVar.o();
        }
        while (true) {
            oVar = oVar.n();
            if (!oVar.r()) {
                if (oVar instanceof r) {
                    return (r) oVar;
                }
                if (oVar instanceof w1) {
                    return null;
                }
            }
        }
    }

    private final void g0(w1 w1Var, Throwable th) {
        i0(th);
        y yVar = null;
        for (o oVar = (o) w1Var.m(); !k.a(oVar, w1Var); oVar = oVar.n()) {
            if (oVar instanceof n1) {
                r1 r1Var = (r1) oVar;
                try {
                    r1Var.w(th);
                } catch (Throwable th2) {
                    if (yVar != null) {
                        b.a(yVar, th2);
                    } else {
                        yVar = new y("Exception in completion handler " + r1Var + " for " + this, th2);
                        q qVar = q.f5904a;
                    }
                }
            }
        }
        if (yVar != null) {
            X(yVar);
        }
        H(th);
    }

    private final void h0(w1 w1Var, Throwable th) {
        y yVar = null;
        for (o oVar = (o) w1Var.m(); !k.a(oVar, w1Var); oVar = oVar.n()) {
            if (oVar instanceof r1) {
                r1 r1Var = (r1) oVar;
                try {
                    r1Var.w(th);
                } catch (Throwable th2) {
                    if (yVar != null) {
                        b.a(yVar, th2);
                    } else {
                        yVar = new y("Exception in completion handler " + r1Var + " for " + this, th2);
                        q qVar = q.f5904a;
                    }
                }
            }
        }
        if (yVar != null) {
            X(yVar);
        }
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [c4.f1] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void l0(c4.v0 r3) {
        /*
            r2 = this;
            c4.w1 r0 = new c4.w1
            r0.<init>()
            boolean r1 = r3.b()
            if (r1 == 0) goto L_0x000c
            goto L_0x0012
        L_0x000c:
            c4.f1 r1 = new c4.f1
            r1.<init>(r0)
            r0 = r1
        L_0x0012:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f3157e
            androidx.concurrent.futures.b.a(r1, r2, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.s1.l0(c4.v0):void");
    }

    private final void m0(r1 r1Var) {
        r1Var.i(new w1());
        androidx.concurrent.futures.b.a(f3157e, this, r1Var, r1Var.n());
    }

    private final int p0(Object obj) {
        if (obj instanceof v0) {
            if (((v0) obj).b()) {
                return 0;
            }
            if (!androidx.concurrent.futures.b.a(f3157e, this, obj, t1.f3175g)) {
                return -1;
            }
            k0();
            return 1;
        } else if (!(obj instanceof f1)) {
            return 0;
        } else {
            if (!androidx.concurrent.futures.b.a(f3157e, this, obj, ((f1) obj).e())) {
                return -1;
            }
            k0();
            return 1;
        }
    }

    private final String q0(Object obj) {
        if (!(obj instanceof b)) {
            return obj instanceof g1 ? ((g1) obj).b() ? "Active" : "New" : obj instanceof v ? "Cancelled" : "Completed";
        }
        b bVar = (b) obj;
        return bVar.g() ? "Cancelling" : bVar.h() ? "Completing" : "Active";
    }

    public static /* synthetic */ CancellationException s0(s1 s1Var, Throwable th, String str, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 1) != 0) {
                str = null;
            }
            return s1Var.r0(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    private final boolean t(Object obj, w1 w1Var, r1 r1Var) {
        int v5;
        c cVar = new c(r1Var, this, obj);
        do {
            v5 = w1Var.o().v(r1Var, w1Var, cVar);
            if (v5 == 1) {
                return true;
            }
        } while (v5 != 2);
        return false;
    }

    private final void u(Throwable th, List<? extends Throwable> list) {
        if (list.size() > 1) {
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
            for (Throwable th2 : list) {
                if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                    b.a(th, th2);
                }
            }
        }
    }

    private final boolean u0(g1 g1Var, Object obj) {
        if (!androidx.concurrent.futures.b.a(f3157e, this, g1Var, t1.g(obj))) {
            return false;
        }
        i0((Throwable) null);
        j0(obj);
        K(g1Var, obj);
        return true;
    }

    private final boolean v0(g1 g1Var, Throwable th) {
        w1 T = T(g1Var);
        if (T == null) {
            return false;
        }
        if (!androidx.concurrent.futures.b.a(f3157e, this, g1Var, new b(T, false, th))) {
            return false;
        }
        g0(T, th);
        return true;
    }

    private final Object w0(Object obj, Object obj2) {
        return !(obj instanceof g1) ? t1.f3169a : (((obj instanceof v0) || (obj instanceof r1)) && !(obj instanceof r) && !(obj2 instanceof v)) ? u0((g1) obj, obj2) ? obj2 : t1.f3171c : x0((g1) obj, obj2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006e, code lost:
        r3 = (java.lang.Throwable) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0071, code lost:
        if (r2 == null) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0073, code lost:
        g0(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0076, code lost:
        r9 = O(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x007a, code lost:
        if (r9 == null) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0080, code lost:
        if (y0(r1, r9, r10) == false) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0084, code lost:
        return c4.t1.f3170b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0089, code lost:
        return N(r1, r10);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object x0(c4.g1 r9, java.lang.Object r10) {
        /*
            r8 = this;
            c4.w1 r0 = r8.T(r9)
            if (r0 != 0) goto L_0x000b
            kotlinx.coroutines.internal.b0 r9 = c4.t1.f3171c
            return r9
        L_0x000b:
            boolean r1 = r9 instanceof c4.s1.b
            r2 = 0
            if (r1 == 0) goto L_0x0014
            r1 = r9
            c4.s1$b r1 = (c4.s1.b) r1
            goto L_0x0015
        L_0x0014:
            r1 = r2
        L_0x0015:
            r3 = 0
            if (r1 != 0) goto L_0x001d
            c4.s1$b r1 = new c4.s1$b
            r1.<init>(r0, r3, r2)
        L_0x001d:
            kotlin.jvm.internal.q r4 = new kotlin.jvm.internal.q
            r4.<init>()
            monitor-enter(r1)
            boolean r5 = r1.h()     // Catch:{ all -> 0x008a }
            if (r5 == 0) goto L_0x002f
            kotlinx.coroutines.internal.b0 r9 = c4.t1.f3169a     // Catch:{ all -> 0x008a }
            monitor-exit(r1)
            return r9
        L_0x002f:
            r5 = 1
            r1.k(r5)     // Catch:{ all -> 0x008a }
            if (r1 == r9) goto L_0x0043
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = f3157e     // Catch:{ all -> 0x008a }
            boolean r6 = androidx.concurrent.futures.b.a(r6, r8, r9, r1)     // Catch:{ all -> 0x008a }
            if (r6 != 0) goto L_0x0043
            kotlinx.coroutines.internal.b0 r9 = c4.t1.f3171c     // Catch:{ all -> 0x008a }
            monitor-exit(r1)
            return r9
        L_0x0043:
            boolean r6 = r1.g()     // Catch:{ all -> 0x008a }
            boolean r7 = r10 instanceof c4.v     // Catch:{ all -> 0x008a }
            if (r7 == 0) goto L_0x004f
            r7 = r10
            c4.v r7 = (c4.v) r7     // Catch:{ all -> 0x008a }
            goto L_0x0050
        L_0x004f:
            r7 = r2
        L_0x0050:
            if (r7 == 0) goto L_0x0057
            java.lang.Throwable r7 = r7.f3183a     // Catch:{ all -> 0x008a }
            r1.a(r7)     // Catch:{ all -> 0x008a }
        L_0x0057:
            java.lang.Throwable r7 = r1.f()     // Catch:{ all -> 0x008a }
            if (r6 != 0) goto L_0x005e
            r3 = r5
        L_0x005e:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x008a }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x008a }
            if (r3 == 0) goto L_0x0069
            r2 = r7
        L_0x0069:
            r4.f5571e = r2     // Catch:{ all -> 0x008a }
            m3.q r3 = m3.q.f5904a     // Catch:{ all -> 0x008a }
            monitor-exit(r1)
            r3 = r2
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            if (r2 == 0) goto L_0x0076
            r8.g0(r0, r2)
        L_0x0076:
            c4.r r9 = r8.O(r9)
            if (r9 == 0) goto L_0x0085
            boolean r9 = r8.y0(r1, r9, r10)
            if (r9 == 0) goto L_0x0085
            kotlinx.coroutines.internal.b0 r9 = c4.t1.f3170b
            return r9
        L_0x0085:
            java.lang.Object r9 = r8.N(r1, r10)
            return r9
        L_0x008a:
            r9 = move-exception
            monitor-exit(r1)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.s1.x0(c4.g1, java.lang.Object):java.lang.Object");
    }

    private final boolean y0(b bVar, r rVar, Object obj) {
        while (l1.a.d(rVar.f3154i, false, false, new a(this, bVar, rVar, obj), 1, (Object) null) == x1.f3195e) {
            rVar = f0(rVar);
            if (rVar == null) {
                return false;
            }
        }
        return true;
    }

    public void A(Throwable th) {
        y(th);
    }

    public final q B(s sVar) {
        return (q) l1.a.d(this, true, false, new r(sVar), 2, (Object) null);
    }

    public void F(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new m1(I(), (Throwable) null, this);
        }
        A(cancellationException);
    }

    /* access modifiers changed from: protected */
    public String I() {
        return "Job was cancelled";
    }

    public boolean J(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return y(th) && R();
    }

    public boolean R() {
        return true;
    }

    public boolean S() {
        return false;
    }

    public final q U() {
        return (q) this._parentHandle;
    }

    public final Object V() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof w)) {
                return obj;
            }
            ((w) obj).c(this);
        }
    }

    /* access modifiers changed from: protected */
    public boolean W(Throwable th) {
        return false;
    }

    public void X(Throwable th) {
        throw th;
    }

    /* access modifiers changed from: protected */
    public final void Y(l1 l1Var) {
        if (l1Var == null) {
            o0(x1.f3195e);
            return;
        }
        l1Var.start();
        q B = l1Var.B(this);
        o0(B);
        if (Z()) {
            B.dispose();
            o0(x1.f3195e);
        }
    }

    public final boolean Z() {
        return !(V() instanceof g1);
    }

    /* access modifiers changed from: protected */
    public boolean a0() {
        return false;
    }

    public boolean b() {
        Object V = V();
        return (V instanceof g1) && ((g1) V).b();
    }

    public final Object c0(Object obj) {
        Object w02;
        do {
            w02 = w0(V(), obj);
            if (w02 == t1.f3169a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, P(obj));
            }
        } while (w02 == t1.f3171c);
        return w02;
    }

    public <E extends g.b> E d(g.c<E> cVar) {
        return l1.a.c(this, cVar);
    }

    public final u0 e(boolean z4, boolean z5, l<? super Throwable, q> lVar) {
        r1 d02 = d0(lVar, z4);
        while (true) {
            Object V = V();
            if (V instanceof v0) {
                v0 v0Var = (v0) V;
                if (!v0Var.b()) {
                    l0(v0Var);
                } else if (androidx.concurrent.futures.b.a(f3157e, this, V, d02)) {
                    return d02;
                }
            } else {
                Throwable th = null;
                if (V instanceof g1) {
                    w1 e5 = ((g1) V).e();
                    if (e5 != null) {
                        u0 u0Var = x1.f3195e;
                        if (z4 && (V instanceof b)) {
                            synchronized (V) {
                                th = ((b) V).f();
                                if (th == null || ((lVar instanceof r) && !((b) V).h())) {
                                    if (t(V, e5, d02)) {
                                        if (th == null) {
                                            return d02;
                                        }
                                        u0Var = d02;
                                    }
                                }
                                q qVar = q.f5904a;
                            }
                        }
                        if (th != null) {
                            if (z5) {
                                lVar.invoke(th);
                            }
                            return u0Var;
                        } else if (t(V, e5, d02)) {
                            return d02;
                        }
                    } else if (V != null) {
                        m0((r1) V);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    }
                } else {
                    if (z5) {
                        v vVar = V instanceof v ? (v) V : null;
                        if (vVar != null) {
                            th = vVar.f3183a;
                        }
                        lVar.invoke(th);
                    }
                    return x1.f3195e;
                }
            }
        }
    }

    public String e0() {
        return k0.a(this);
    }

    public final g.c<?> getKey() {
        return l1.f3142c;
    }

    public o3.g h(g.c<?> cVar) {
        return l1.a.e(this, cVar);
    }

    /* access modifiers changed from: protected */
    public void i0(Throwable th) {
    }

    /* access modifiers changed from: protected */
    public void j0(Object obj) {
    }

    /* access modifiers changed from: protected */
    public void k0() {
    }

    public final void l(z1 z1Var) {
        y(z1Var);
    }

    public o3.g n(o3.g gVar) {
        return l1.a.f(this, gVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n0(c4.r1 r4) {
        /*
            r3 = this;
        L_0x0000:
            java.lang.Object r0 = r3.V()
            boolean r1 = r0 instanceof c4.r1
            if (r1 == 0) goto L_0x0018
            if (r0 == r4) goto L_0x000b
            return
        L_0x000b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f3157e
            c4.v0 r2 = c4.t1.f3175g
            boolean r0 = androidx.concurrent.futures.b.a(r1, r3, r0, r2)
            if (r0 == 0) goto L_0x0000
            return
        L_0x0018:
            boolean r1 = r0 instanceof c4.g1
            if (r1 == 0) goto L_0x0027
            c4.g1 r0 = (c4.g1) r0
            c4.w1 r0 = r0.e()
            if (r0 == 0) goto L_0x0027
            r4.s()
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.s1.n0(c4.r1):void");
    }

    public final void o0(q qVar) {
        this._parentHandle = qVar;
    }

    public <R> R q(R r5, p<? super R, ? super g.b, ? extends R> pVar) {
        return l1.a.b(this, r5, pVar);
    }

    /* access modifiers changed from: protected */
    public final CancellationException r0(Throwable th, String str) {
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (cancellationException == null) {
            if (str == null) {
                str = I();
            }
            cancellationException = new m1(str, th, this);
        }
        return cancellationException;
    }

    public final boolean start() {
        int p02;
        do {
            p02 = p0(V());
            if (p02 == 0) {
                return false;
            }
        } while (p02 != 1);
        return true;
    }

    public final String t0() {
        return e0() + '{' + q0(V()) + '}';
    }

    public String toString() {
        return t0() + '@' + k0.b(this);
    }

    public CancellationException w() {
        Throwable th;
        Object V = V();
        CancellationException cancellationException = null;
        if (V instanceof b) {
            th = ((b) V).f();
        } else if (V instanceof v) {
            th = ((v) V).f3183a;
        } else if (!(V instanceof g1)) {
            th = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + V).toString());
        }
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        }
        if (cancellationException != null) {
            return cancellationException;
        }
        return new m1("Parent job is " + q0(V), th, this);
    }

    /* access modifiers changed from: protected */
    public void x(Object obj) {
    }

    public final boolean y(Object obj) {
        Object a5 = t1.f3169a;
        if (S() && (a5 = G(obj)) == t1.f3170b) {
            return true;
        }
        if (a5 == t1.f3169a) {
            a5 = b0(obj);
        }
        if (a5 == t1.f3169a || a5 == t1.f3170b) {
            return true;
        }
        if (a5 == t1.f3172d) {
            return false;
        }
        x(a5);
        return true;
    }

    public final CancellationException z() {
        Object V = V();
        if (V instanceof b) {
            Throwable f5 = ((b) V).f();
            if (f5 != null) {
                CancellationException r02 = r0(f5, k0.a(this) + " is cancelling");
                if (r02 != null) {
                    return r02;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (V instanceof g1) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (V instanceof v) {
            return s0(this, ((v) V).f3183a, (String) null, 1, (Object) null);
        } else {
            return new m1(k0.a(this) + " has completed normally", (Throwable) null, this);
        }
    }
}
