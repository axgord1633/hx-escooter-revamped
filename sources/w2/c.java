package w2;

import m2.a;
import m2.b;
import p2.d;

public final class c extends a {

    /* renamed from: e  reason: collision with root package name */
    final r2.a f7559e;

    public c(r2.a aVar) {
        this.f7559e = aVar;
    }

    /* access modifiers changed from: protected */
    public void m(b bVar) {
        p2.c b5 = d.b();
        bVar.c(b5);
        try {
            this.f7559e.run();
            if (!b5.f()) {
                bVar.a();
            }
        } catch (Throwable th) {
            q2.b.b(th);
            if (!b5.f()) {
                bVar.onError(th);
            } else {
                j3.a.r(th);
            }
        }
    }
}
