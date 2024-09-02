package p1;

import android.content.Context;
import g0.c;
import h0.a;
import p1.a;

public final class y implements c<Integer> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f6542a;

    public y(a<Context> aVar) {
        this.f6542a = aVar;
    }

    public static y a(a<Context> aVar) {
        return new y(aVar);
    }

    public static int c(Context context) {
        return a.c.x(context);
    }

    /* renamed from: b */
    public Integer get() {
        return Integer.valueOf(c(this.f6542a.get()));
    }
}
