package w0;

import android.os.Bundle;
import t0.a;

public final class y0 extends n0 {

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ c f7450g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y0(c cVar, int i5, Bundle bundle) {
        super(cVar, i5, (Bundle) null);
        this.f7450g = cVar;
    }

    /* access modifiers changed from: protected */
    public final void f(a aVar) {
        if (!this.f7450g.s() || !c.f0(this.f7450g)) {
            this.f7450g.f7307p.c(aVar);
            this.f7450g.K(aVar);
            return;
        }
        c.b0(this.f7450g, 16);
    }

    /* access modifiers changed from: protected */
    public final boolean g() {
        this.f7450g.f7307p.c(a.f6807i);
        return true;
    }
}
