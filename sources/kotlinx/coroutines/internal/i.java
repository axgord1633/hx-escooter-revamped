package kotlinx.coroutines.internal;

import m3.k;
import m3.l;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f5603a;

    static {
        Object obj;
        try {
            k.a aVar = k.f5898e;
            obj = k.a(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            k.a aVar2 = k.f5898e;
            obj = k.a(l.a(th));
        }
        f5603a = k.d(obj);
    }

    public static final boolean a() {
        return f5603a;
    }
}
