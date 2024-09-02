package y1;

import android.content.Context;
import g0.c;
import h0.a;

public final class v implements c<u> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f7792a;

    /* renamed from: b  reason: collision with root package name */
    private final a<w> f7793b;

    public v(a<Context> aVar, a<w> aVar2) {
        this.f7792a = aVar;
        this.f7793b = aVar2;
    }

    public static v a(a<Context> aVar, a<w> aVar2) {
        return new v(aVar, aVar2);
    }

    public static u c(Context context, w wVar) {
        return new u(context, wVar);
    }

    /* renamed from: b */
    public u get() {
        return c(this.f7792a.get(), this.f7793b.get());
    }
}
