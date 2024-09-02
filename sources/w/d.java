package w;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import w.a;

public final class d extends a {
    public d() {
        this((a) null, 1, (g) null);
    }

    public d(a aVar) {
        k.e(aVar, "initialExtras");
        b().putAll(aVar.b());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(a aVar, int i5, g gVar) {
        this((i5 & 1) != 0 ? a.C0118a.f7283b : aVar);
    }

    public <T> T a(a.b<T> bVar) {
        k.e(bVar, "key");
        return b().get(bVar);
    }

    public final <T> void c(a.b<T> bVar, T t5) {
        k.e(bVar, "key");
        b().put(bVar, t5);
    }
}
