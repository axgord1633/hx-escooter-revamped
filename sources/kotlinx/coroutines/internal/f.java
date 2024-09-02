package kotlinx.coroutines.internal;

import androidx.concurrent.futures.b;
import c4.c0;
import c4.c2;
import c4.k0;
import c4.l;
import c4.q0;
import c4.w;
import c4.w0;
import c4.z;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.jvm.internal.e;
import kotlin.jvm.internal.k;
import m3.q;
import o3.d;
import o3.g;

public final class f<T> extends q0<T> implements e, d<T> {

    /* renamed from: l  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f5587l = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_reusableCancellableContinuation");
    private volatile /* synthetic */ Object _reusableCancellableContinuation = null;

    /* renamed from: h  reason: collision with root package name */
    public final c0 f5588h;

    /* renamed from: i  reason: collision with root package name */
    public final d<T> f5589i;

    /* renamed from: j  reason: collision with root package name */
    public Object f5590j = g.f5599a;

    /* renamed from: k  reason: collision with root package name */
    public final Object f5591k = f0.b(getContext());

    public f(c0 c0Var, d<? super T> dVar) {
        super(-1);
        this.f5588h = c0Var;
        this.f5589i = dVar;
    }

    private final l<?> m() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof l) {
            return (l) obj;
        }
        return null;
    }

    public void b(Object obj, Throwable th) {
        if (obj instanceof w) {
            ((w) obj).f3186b.invoke(th);
        }
    }

    public d<T> d() {
        return this;
    }

    public e getCallerFrame() {
        d<T> dVar = this.f5589i;
        if (dVar instanceof e) {
            return (e) dVar;
        }
        return null;
    }

    public g getContext() {
        return this.f5589i.getContext();
    }

    public Object i() {
        Object obj = this.f5590j;
        this.f5590j = g.f5599a;
        return obj;
    }

    public final void j() {
        do {
        } while (this._reusableCancellableContinuation == g.f5600b);
    }

    public final l<T> l() {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = g.f5600b;
                return null;
            } else if (obj instanceof l) {
                if (b.a(f5587l, this, obj, g.f5600b)) {
                    return (l) obj;
                }
            } else if (obj != g.f5600b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final boolean n() {
        return this._reusableCancellableContinuation != null;
    }

    public final boolean q(Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            b0 b0Var = g.f5600b;
            if (k.a(obj, b0Var)) {
                if (b.a(f5587l, this, b0Var, th)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (b.a(f5587l, this, obj, (Object) null)) {
                    return false;
                }
            }
        }
    }

    public final void r() {
        j();
        l<?> m5 = m();
        if (m5 != null) {
            m5.s();
        }
    }

    public void resumeWith(Object obj) {
        g context;
        Object c5;
        g context2 = this.f5589i.getContext();
        Object d5 = z.d(obj, (v3.l) null, 1, (Object) null);
        if (this.f5588h.N(context2)) {
            this.f5590j = d5;
            this.f3153g = 0;
            this.f5588h.M(context2, this);
            return;
        }
        w0 a5 = c2.f3110a.a();
        if (a5.V()) {
            this.f5590j = d5;
            this.f3153g = 0;
            a5.R(this);
            return;
        }
        a5.T(true);
        try {
            context = getContext();
            c5 = f0.c(context, this.f5591k);
            this.f5589i.resumeWith(obj);
            q qVar = q.f5904a;
            f0.a(context, c5);
            do {
            } while (a5.X());
        } catch (Throwable th) {
            try {
                h(th, (Throwable) null);
            } catch (Throwable th2) {
                a5.P(true);
                throw th2;
            }
        }
        a5.P(true);
    }

    public final Throwable s(c4.k<?> kVar) {
        b0 b0Var;
        do {
            Object obj = this._reusableCancellableContinuation;
            b0Var = g.f5600b;
            if (obj != b0Var) {
                if (!(obj instanceof Throwable)) {
                    throw new IllegalStateException(("Inconsistent state " + obj).toString());
                } else if (b.a(f5587l, this, obj, (Object) null)) {
                    return (Throwable) obj;
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
        } while (!b.a(f5587l, this, b0Var, kVar));
        return null;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f5588h + ", " + k0.c(this.f5589i) + ']';
    }
}
