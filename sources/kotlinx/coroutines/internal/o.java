package kotlinx.coroutines.internal;

import c4.k0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.k;

public class o {

    /* renamed from: e  reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f5615e;

    /* renamed from: f  reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f5616f;

    /* renamed from: g  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f5617g;
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    public static abstract class a extends c<o> {

        /* renamed from: b  reason: collision with root package name */
        public final o f5618b;

        /* renamed from: c  reason: collision with root package name */
        public o f5619c;

        public a(o oVar) {
            this.f5618b = oVar;
        }

        /* renamed from: h */
        public void d(o oVar, Object obj) {
            boolean z4 = obj == null;
            o oVar2 = z4 ? this.f5618b : this.f5619c;
            if (oVar2 != null && androidx.concurrent.futures.b.a(o.f5615e, oVar, this, oVar2) && z4) {
                o oVar3 = this.f5618b;
                o oVar4 = this.f5619c;
                k.b(oVar4);
                oVar3.l(oVar4);
            }
        }
    }

    public static final class b extends w {
    }

    /* synthetic */ class c extends kotlin.jvm.internal.o {
        c(Object obj) {
            super(obj, k0.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", 1);
        }

        public Object get() {
            return k0.a(this.receiver);
        }
    }

    static {
        Class<Object> cls = Object.class;
        Class<o> cls2 = o.class;
        f5615e = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_next");
        f5616f = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_prev");
        f5617g = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_removedRef");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: kotlinx.coroutines.internal.w} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: kotlinx.coroutines.internal.o} */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (androidx.concurrent.futures.b.a(f5615e, r3, r2, ((kotlinx.coroutines.internal.x) r4).f5639a) != false) goto L_0x004b;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlinx.coroutines.internal.o j(kotlinx.coroutines.internal.w r8) {
        /*
            r7 = this;
        L_0x0000:
            java.lang.Object r0 = r7._prev
            kotlinx.coroutines.internal.o r0 = (kotlinx.coroutines.internal.o) r0
            r1 = 0
            r2 = r0
        L_0x0006:
            r3 = r1
        L_0x0007:
            java.lang.Object r4 = r2._next
            if (r4 != r7) goto L_0x0018
            if (r0 != r2) goto L_0x000e
            return r2
        L_0x000e:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f5616f
            boolean r0 = androidx.concurrent.futures.b.a(r1, r7, r0, r2)
            if (r0 != 0) goto L_0x0017
            goto L_0x0000
        L_0x0017:
            return r2
        L_0x0018:
            boolean r5 = r7.r()
            if (r5 == 0) goto L_0x001f
            return r1
        L_0x001f:
            if (r4 != r8) goto L_0x0022
            return r2
        L_0x0022:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.w
            if (r5 == 0) goto L_0x0038
            if (r8 == 0) goto L_0x0032
            r0 = r4
            kotlinx.coroutines.internal.w r0 = (kotlinx.coroutines.internal.w) r0
            boolean r0 = r8.b(r0)
            if (r0 == 0) goto L_0x0032
            return r1
        L_0x0032:
            kotlinx.coroutines.internal.w r4 = (kotlinx.coroutines.internal.w) r4
            r4.c(r2)
            goto L_0x0000
        L_0x0038:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.x
            if (r5 == 0) goto L_0x0052
            if (r3 == 0) goto L_0x004d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = f5615e
            kotlinx.coroutines.internal.x r4 = (kotlinx.coroutines.internal.x) r4
            kotlinx.coroutines.internal.o r4 = r4.f5639a
            boolean r2 = androidx.concurrent.futures.b.a(r5, r3, r2, r4)
            if (r2 != 0) goto L_0x004b
            goto L_0x0000
        L_0x004b:
            r2 = r3
            goto L_0x0006
        L_0x004d:
            java.lang.Object r2 = r2._prev
            kotlinx.coroutines.internal.o r2 = (kotlinx.coroutines.internal.o) r2
            goto L_0x0007
        L_0x0052:
            r3 = r4
            kotlinx.coroutines.internal.o r3 = (kotlinx.coroutines.internal.o) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.o.j(kotlinx.coroutines.internal.w):kotlinx.coroutines.internal.o");
    }

    private final o k(o oVar) {
        while (oVar.r()) {
            oVar = (o) oVar._prev;
        }
        return oVar;
    }

    /* access modifiers changed from: private */
    public final void l(o oVar) {
        o oVar2;
        do {
            oVar2 = (o) oVar._prev;
            if (m() != oVar) {
                return;
            }
        } while (!androidx.concurrent.futures.b.a(f5616f, oVar, oVar2, this));
        if (r()) {
            oVar.j((w) null);
        }
    }

    private final x u() {
        x xVar = (x) this._removedRef;
        if (xVar != null) {
            return xVar;
        }
        x xVar2 = new x(this);
        f5617g.lazySet(this, xVar2);
        return xVar2;
    }

    public final boolean h(o oVar, o oVar2) {
        f5616f.lazySet(oVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5615e;
        atomicReferenceFieldUpdater.lazySet(oVar, oVar2);
        if (!androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, oVar2, oVar)) {
            return false;
        }
        oVar.l(oVar2);
        return true;
    }

    public final boolean i(o oVar) {
        f5616f.lazySet(oVar, this);
        f5615e.lazySet(oVar, this);
        while (m() == this) {
            if (androidx.concurrent.futures.b.a(f5615e, this, this, oVar)) {
                oVar.l(this);
                return true;
            }
        }
        return false;
    }

    public final Object m() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof w)) {
                return obj;
            }
            ((w) obj).c(this);
        }
    }

    public final o n() {
        return n.b(m());
    }

    public final o o() {
        o j5 = j((w) null);
        return j5 == null ? k((o) this._prev) : j5;
    }

    public final void p() {
        ((x) m()).f5639a.q();
    }

    public final void q() {
        o oVar = this;
        while (true) {
            Object m5 = oVar.m();
            if (m5 instanceof x) {
                oVar = ((x) m5).f5639a;
            } else {
                oVar.j((w) null);
                return;
            }
        }
    }

    public boolean r() {
        return m() instanceof x;
    }

    public boolean s() {
        return t() == null;
    }

    public final o t() {
        Object m5;
        o oVar;
        do {
            m5 = m();
            if (m5 instanceof x) {
                return ((x) m5).f5639a;
            }
            if (m5 == this) {
                return (o) m5;
            }
            oVar = (o) m5;
        } while (!androidx.concurrent.futures.b.a(f5615e, this, m5, oVar.u()));
        oVar.j((w) null);
        return null;
    }

    public String toString() {
        return new c(this) + '@' + k0.b(this);
    }

    public final int v(o oVar, o oVar2, a aVar) {
        f5616f.lazySet(oVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5615e;
        atomicReferenceFieldUpdater.lazySet(oVar, oVar2);
        aVar.f5619c = oVar2;
        if (!androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, oVar2, aVar)) {
            return 0;
        }
        return aVar.c(this) == null ? 1 : 2;
    }
}
