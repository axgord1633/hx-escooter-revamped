package g1;

import com.google.android.gms.common.api.internal.c;
import l1.h;
import v0.i;

final class k implements i, w {

    /* renamed from: a  reason: collision with root package name */
    private final j f4700a;

    /* renamed from: b  reason: collision with root package name */
    private c f4701b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4702c = true;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ l f4703d;

    k(l lVar, c cVar, j jVar) {
        this.f4703d = lVar;
        this.f4701b = cVar;
        this.f4700a = jVar;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj, Object obj2) {
        c.a b5;
        boolean z4;
        c0 c0Var = (c0) obj;
        h hVar = (h) obj2;
        synchronized (this) {
            b5 = this.f4701b.b();
            z4 = this.f4702c;
            this.f4701b.a();
        }
        if (b5 == null) {
            hVar.c(Boolean.FALSE);
        } else {
            this.f4700a.a(c0Var, b5, z4, hVar);
        }
    }

    public final void d() {
        c.a b5;
        synchronized (this) {
            this.f4702c = false;
            b5 = this.f4701b.b();
        }
        if (b5 != null) {
            this.f4703d.j(b5, 2441);
        }
    }

    public final synchronized void e(c cVar) {
        c cVar2 = this.f4701b;
        if (cVar2 != cVar) {
            cVar2.a();
            this.f4701b = cVar;
        }
    }

    public final synchronized c f() {
        return this.f4701b;
    }
}
