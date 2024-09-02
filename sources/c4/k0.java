package c4;

import kotlinx.coroutines.internal.f;
import m3.k;
import m3.l;
import o3.d;

public final class k0 {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(d<?> dVar) {
        Object obj;
        if (dVar instanceof f) {
            return dVar.toString();
        }
        try {
            k.a aVar = k.f5898e;
            obj = k.a(dVar + '@' + b(dVar));
        } catch (Throwable th) {
            k.a aVar2 = k.f5898e;
            obj = k.a(l.a(th));
        }
        Throwable b5 = k.b(obj);
        String str = obj;
        if (b5 != null) {
            str = dVar.getClass().getName() + '@' + b(dVar);
        }
        return (String) str;
    }
}
