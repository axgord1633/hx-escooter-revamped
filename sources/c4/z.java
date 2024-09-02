package c4;

import kotlin.jvm.internal.g;
import m3.k;
import m3.l;
import m3.q;
import o3.d;

public final class z {
    public static final <T> Object a(Object obj, d<? super T> dVar) {
        if (obj instanceof v) {
            k.a aVar = k.f5898e;
            obj = l.a(((v) obj).f3183a);
        }
        return k.a(obj);
    }

    public static final <T> Object b(Object obj, k<?> kVar) {
        Throwable b5 = k.b(obj);
        return b5 == null ? obj : new v(b5, false, 2, (g) null);
    }

    public static final <T> Object c(Object obj, v3.l<? super Throwable, q> lVar) {
        Throwable b5 = k.b(obj);
        return b5 == null ? lVar != null ? new w(obj, lVar) : obj : new v(b5, false, 2, (g) null);
    }

    public static /* synthetic */ Object d(Object obj, v3.l lVar, int i5, Object obj2) {
        if ((i5 & 1) != 0) {
            lVar = null;
        }
        return c(obj, lVar);
    }
}
