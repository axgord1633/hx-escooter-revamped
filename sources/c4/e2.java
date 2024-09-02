package c4;

import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.internal.z;
import m3.j;
import m3.n;
import m3.q;
import o3.d;
import o3.g;

public final class e2<T> extends z<T> {

    /* renamed from: h  reason: collision with root package name */
    private ThreadLocal<j<g, Object>> f3118h;

    public final boolean E0() {
        if (this.f3118h.get() == null) {
            return false;
        }
        this.f3118h.set((Object) null);
        return true;
    }

    public final void F0(g gVar, Object obj) {
        this.f3118h.set(n.a(gVar, obj));
    }

    /* access modifiers changed from: protected */
    public void z0(Object obj) {
        j jVar = this.f3118h.get();
        e2<?> e2Var = null;
        if (jVar != null) {
            f0.a((g) jVar.a(), jVar.b());
            this.f3118h.set(e2Var);
        }
        Object a5 = z.a(obj, this.f5640g);
        d<T> dVar = this.f5640g;
        g context = dVar.getContext();
        Object c5 = f0.c(context, e2Var);
        if (c5 != f0.f5592a) {
            e2Var = b0.f(dVar, context, c5);
        }
        try {
            this.f5640g.resumeWith(a5);
            q qVar = q.f5904a;
        } finally {
            if (e2Var == null || e2Var.E0()) {
                f0.a(context, c5);
            }
        }
    }
}
