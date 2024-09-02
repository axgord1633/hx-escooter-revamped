package c4;

import o3.d;
import o3.g;
import v3.l;
import v3.p;

public abstract class a<T> extends s1 implements d<T>, g0 {

    /* renamed from: f  reason: collision with root package name */
    private final g f3099f;

    public a(g gVar, boolean z4, boolean z5) {
        super(z5);
        if (z4) {
            Y((l1) gVar.d(l1.f3142c));
        }
        this.f3099f = gVar.n(this);
    }

    /* access modifiers changed from: protected */
    public void A0(Throwable th, boolean z4) {
    }

    /* access modifiers changed from: protected */
    public void B0(T t5) {
    }

    public final <R> void C0(i0 i0Var, R r5, p<? super R, ? super d<? super T>, ? extends Object> pVar) {
        i0Var.f(pVar, r5, this);
    }

    /* access modifiers changed from: protected */
    public String I() {
        return k0.a(this) + " was cancelled";
    }

    public final void X(Throwable th) {
        f0.a(this.f3099f, th);
    }

    public boolean b() {
        return super.b();
    }

    public String e0() {
        String b5 = b0.b(this.f3099f);
        if (b5 == null) {
            return super.e0();
        }
        return '\"' + b5 + "\":" + super.e0();
    }

    public final g getContext() {
        return this.f3099f;
    }

    public g i() {
        return this.f3099f;
    }

    /* access modifiers changed from: protected */
    public final void j0(Object obj) {
        if (obj instanceof v) {
            v vVar = (v) obj;
            A0(vVar.f3183a, vVar.a());
            return;
        }
        B0(obj);
    }

    public final void resumeWith(Object obj) {
        Object c02 = c0(z.d(obj, (l) null, 1, (Object) null));
        if (c02 != t1.f3170b) {
            z0(c02);
        }
    }

    /* access modifiers changed from: protected */
    public void z0(Object obj) {
        x(obj);
    }
}
