package p1;

import android.content.Context;
import g0.c;
import h0.a;
import p1.a;

public final class o implements c<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f6514a;

    /* renamed from: b  reason: collision with root package name */
    private final a<Integer> f6515b;

    public o(a<Context> aVar, a<Integer> aVar2) {
        this.f6514a = aVar;
        this.f6515b = aVar2;
    }

    public static o a(a<Context> aVar, a<Integer> aVar2) {
        return new o(aVar, aVar2);
    }

    public static boolean c(Context context, int i5) {
        return a.c.n(context, i5);
    }

    /* renamed from: b */
    public Boolean get() {
        return Boolean.valueOf(c(this.f6514a.get(), this.f6515b.get().intValue()));
    }
}
