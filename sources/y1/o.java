package y1;

import android.content.Context;
import g0.c;
import h0.a;

public final class o implements c<n> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f7764a;

    public o(a<Context> aVar) {
        this.f7764a = aVar;
    }

    public static o a(a<Context> aVar) {
        return new o(aVar);
    }

    public static n c(Context context) {
        return new n(context);
    }

    /* renamed from: b */
    public n get() {
        return c(this.f7764a.get());
    }
}
