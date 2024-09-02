package p1;

import android.content.Context;
import g0.c;
import h0.a;

public final class f0 implements c<e0> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f6454a;

    public f0(a<Context> aVar) {
        this.f6454a = aVar;
    }

    public static f0 a(a<Context> aVar) {
        return new f0(aVar);
    }

    public static e0 c(Context context) {
        return new e0(context);
    }

    /* renamed from: b */
    public e0 get() {
        return c(this.f6454a.get());
    }
}
