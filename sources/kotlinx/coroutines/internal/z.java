package kotlinx.coroutines.internal;

import c4.a;
import c4.l1;
import c4.q;
import kotlin.coroutines.jvm.internal.e;
import o3.d;
import v3.l;

public class z<T> extends a<T> implements e {

    /* renamed from: g  reason: collision with root package name */
    public final d<T> f5640g;

    public final l1 D0() {
        q U = U();
        if (U != null) {
            return U.getParent();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean a0() {
        return true;
    }

    public final e getCallerFrame() {
        d<T> dVar = this.f5640g;
        if (dVar instanceof e) {
            return (e) dVar;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void x(Object obj) {
        g.c(c.b(this.f5640g), c4.z.a(obj, this.f5640g), (l) null, 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void z0(Object obj) {
        d<T> dVar = this.f5640g;
        dVar.resumeWith(c4.z.a(obj, dVar));
    }
}
