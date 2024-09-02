package p1;

import android.content.Context;
import g0.c;
import h0.a;
import p1.a;

public final class q implements c<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f6519a;

    public q(a<Context> aVar) {
        this.f6519a = aVar;
    }

    public static q a(a<Context> aVar) {
        return new q(aVar);
    }

    public static boolean c(Context context) {
        return a.c.p(context);
    }

    /* renamed from: b */
    public Boolean get() {
        return Boolean.valueOf(c(this.f6519a.get()));
    }
}
