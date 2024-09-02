package c4;

import androidx.concurrent.futures.b;
import c4.l1;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.jvm.internal.e;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.f;
import m3.q;
import o3.d;
import o3.g;

public class l<T> extends q0<T> implements k<T>, e {

    /* renamed from: k  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f3135k = AtomicIntegerFieldUpdater.newUpdater(l.class, "_decision");

    /* renamed from: l  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f3136l = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_state");
    private volatile /* synthetic */ int _decision = 0;
    private volatile /* synthetic */ Object _state = d.f3112e;

    /* renamed from: h  reason: collision with root package name */
    private final d<T> f3137h;

    /* renamed from: i  reason: collision with root package name */
    private final g f3138i;

    /* renamed from: j  reason: collision with root package name */
    private u0 f3139j;

    public l(d<? super T> dVar, int i5) {
        super(i5);
        this.f3137h = dVar;
        this.f3138i = dVar.getContext();
    }

    private final boolean A() {
        return r0.c(this.f3153g) && ((f) this.f3137h).n();
    }

    private final i B(v3.l<? super Throwable, q> lVar) {
        return lVar instanceof i ? (i) lVar : new i1(lVar);
    }

    private final void C(v3.l<? super Throwable, q> lVar, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + lVar + ", already has " + obj).toString());
    }

    private final void F() {
        Throwable s5;
        d<T> dVar = this.f3137h;
        f fVar = dVar instanceof f ? (f) dVar : null;
        if (fVar != null && (s5 = fVar.s(this)) != null) {
            s();
            q(s5);
        }
    }

    private final void H(Object obj, int i5, v3.l<? super Throwable, q> lVar) {
        Object obj2;
        do {
            obj2 = this._state;
            if (obj2 instanceof y1) {
            } else {
                if (obj2 instanceof o) {
                    o oVar = (o) obj2;
                    if (oVar.c()) {
                        if (lVar != null) {
                            n(lVar, oVar.f3183a);
                            return;
                        }
                        return;
                    }
                }
                j(obj);
                throw new m3.d();
            }
        } while (!b.a(f3136l, this, obj2, J((y1) obj2, obj, i5, lVar, (Object) null)));
        t();
        u(i5);
    }

    static /* synthetic */ void I(l lVar, Object obj, int i5, v3.l lVar2, int i6, Object obj2) {
        if (obj2 == null) {
            if ((i6 & 4) != 0) {
                lVar2 = null;
            }
            lVar.H(obj, i5, lVar2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final Object J(y1 y1Var, Object obj, int i5, v3.l<? super Throwable, q> lVar, Object obj2) {
        if (obj instanceof v) {
            return obj;
        }
        if (!r0.b(i5) && obj2 == null) {
            return obj;
        }
        if (lVar == null && ((!(y1Var instanceof i) || (y1Var instanceof e)) && obj2 == null)) {
            return obj;
        }
        return new u(obj, y1Var instanceof i ? (i) y1Var : null, lVar, obj2, (Throwable) null, 16, (kotlin.jvm.internal.g) null);
    }

    private final boolean K() {
        do {
            int i5 = this._decision;
            if (i5 != 0) {
                if (i5 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f3135k.compareAndSet(this, 0, 2));
        return true;
    }

    private final b0 L(Object obj, Object obj2, v3.l<? super Throwable, q> lVar) {
        Object obj3;
        do {
            obj3 = this._state;
            if (obj3 instanceof y1) {
            } else if (!(obj3 instanceof u) || obj2 == null || ((u) obj3).f3179d != obj2) {
                return null;
            } else {
                return m.f3144a;
            }
        } while (!b.a(f3136l, this, obj3, J((y1) obj3, obj, this.f3153g, lVar, obj2)));
        t();
        return m.f3144a;
    }

    private final boolean M() {
        do {
            int i5 = this._decision;
            if (i5 != 0) {
                if (i5 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f3135k.compareAndSet(this, 0, 1));
        return true;
    }

    private final Void j(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void m(v3.l<? super Throwable, q> lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            g context = getContext();
            f0.a(context, new y("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    private final boolean r(Throwable th) {
        if (!A()) {
            return false;
        }
        return ((f) this.f3137h).q(th);
    }

    private final void t() {
        if (!A()) {
            s();
        }
    }

    private final void u(int i5) {
        if (!K()) {
            r0.a(this, i5);
        }
    }

    private final String y() {
        Object x4 = x();
        return x4 instanceof y1 ? "Active" : x4 instanceof o ? "Cancelled" : "Completed";
    }

    private final u0 z() {
        l1 l1Var = (l1) getContext().d(l1.f3142c);
        if (l1Var == null) {
            return null;
        }
        u0 d5 = l1.a.d(l1Var, true, false, new p(this), 2, (Object) null);
        this.f3139j = d5;
        return d5;
    }

    /* access modifiers changed from: protected */
    public String D() {
        return "CancellableContinuation";
    }

    public final void E(Throwable th) {
        if (!r(th)) {
            q(th);
            t();
        }
    }

    public final boolean G() {
        Object obj = this._state;
        if (!(obj instanceof u) || ((u) obj).f3179d == null) {
            this._decision = 0;
            this._state = d.f3112e;
            return true;
        }
        s();
        return false;
    }

    public Object a(T t5, Object obj) {
        return L(t5, obj, (v3.l<? super Throwable, q>) null);
    }

    public void b(Object obj, Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof y1) {
                throw new IllegalStateException("Not completed".toString());
            } else if (!(obj2 instanceof v)) {
                if (obj2 instanceof u) {
                    u uVar = (u) obj2;
                    if (!uVar.c()) {
                        if (b.a(f3136l, this, obj2, u.b(uVar, (Object) null, (i) null, (v3.l) null, (Object) null, th, 15, (Object) null))) {
                            uVar.d(this, th);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else if (b.a(f3136l, this, obj2, new u(obj2, (i) null, (v3.l) null, (Object) null, th, 14, (kotlin.jvm.internal.g) null))) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void c(v3.l<? super Throwable, q> lVar) {
        i B = B(lVar);
        while (true) {
            Object obj = this._state;
            if (obj instanceof d) {
                if (b.a(f3136l, this, obj, B)) {
                    return;
                }
            } else if (obj instanceof i) {
                C(lVar, obj);
            } else {
                boolean z4 = obj instanceof v;
                if (z4) {
                    v vVar = (v) obj;
                    if (!vVar.b()) {
                        C(lVar, obj);
                    }
                    if (obj instanceof o) {
                        Throwable th = null;
                        if (!z4) {
                            vVar = null;
                        }
                        if (vVar != null) {
                            th = vVar.f3183a;
                        }
                        m(lVar, th);
                        return;
                    }
                    return;
                } else if (obj instanceof u) {
                    u uVar = (u) obj;
                    if (uVar.f3177b != null) {
                        C(lVar, obj);
                    }
                    if (!(B instanceof e)) {
                        if (uVar.c()) {
                            m(lVar, uVar.f3180e);
                            return;
                        }
                        if (b.a(f3136l, this, obj, u.b(uVar, (Object) null, B, (v3.l) null, (Object) null, (Throwable) null, 29, (Object) null))) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (!(B instanceof e)) {
                    if (b.a(f3136l, this, obj, new u(obj, B, (v3.l) null, (Object) null, (Throwable) null, 28, (kotlin.jvm.internal.g) null))) {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final d<T> d() {
        return this.f3137h;
    }

    public Throwable e(Object obj) {
        Throwable e5 = super.e(obj);
        if (e5 != null) {
            return e5;
        }
        return null;
    }

    public void f(T t5, v3.l<? super Throwable, q> lVar) {
        H(t5, this.f3153g, lVar);
    }

    public <T> T g(Object obj) {
        return obj instanceof u ? ((u) obj).f3176a : obj;
    }

    public e getCallerFrame() {
        d<T> dVar = this.f3137h;
        if (dVar instanceof e) {
            return (e) dVar;
        }
        return null;
    }

    public g getContext() {
        return this.f3138i;
    }

    public Object i() {
        return x();
    }

    public Object k(T t5, Object obj, v3.l<? super Throwable, q> lVar) {
        return L(t5, obj, lVar);
    }

    public final void l(i iVar, Throwable th) {
        try {
            iVar.a(th);
        } catch (Throwable th2) {
            g context = getContext();
            f0.a(context, new y("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void n(v3.l<? super Throwable, q> lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            g context = getContext();
            f0.a(context, new y("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public Object o(Throwable th) {
        return L(new v(th, false, 2, (kotlin.jvm.internal.g) null), (Object) null, (v3.l<? super Throwable, q>) null);
    }

    public void p(Object obj) {
        u(this.f3153g);
    }

    public boolean q(Throwable th) {
        Object obj;
        boolean z4;
        do {
            obj = this._state;
            if (!(obj instanceof y1)) {
                return false;
            }
            z4 = obj instanceof i;
        } while (!b.a(f3136l, this, obj, new o(this, th, z4)));
        i iVar = z4 ? (i) obj : null;
        if (iVar != null) {
            l(iVar, th);
        }
        t();
        u(this.f3153g);
        return true;
    }

    public void resumeWith(Object obj) {
        I(this, z.b(obj, this), this.f3153g, (v3.l) null, 4, (Object) null);
    }

    public final void s() {
        u0 u0Var = this.f3139j;
        if (u0Var != null) {
            u0Var.dispose();
            this.f3139j = x1.f3195e;
        }
    }

    public String toString() {
        return D() + '(' + k0.c(this.f3137h) + "){" + y() + "}@" + k0.b(this);
    }

    public Throwable v(l1 l1Var) {
        return l1Var.z();
    }

    public final Object w() {
        l1 l1Var;
        boolean A = A();
        if (M()) {
            if (this.f3139j == null) {
                z();
            }
            if (A) {
                F();
            }
            return d.c();
        }
        if (A) {
            F();
        }
        Object x4 = x();
        if (x4 instanceof v) {
            throw ((v) x4).f3183a;
        } else if (!r0.b(this.f3153g) || (l1Var = (l1) getContext().d(l1.f3142c)) == null || l1Var.b()) {
            return g(x4);
        } else {
            CancellationException z4 = l1Var.z();
            b(x4, z4);
            throw z4;
        }
    }

    public final Object x() {
        return this._state;
    }
}
