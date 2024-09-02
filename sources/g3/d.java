package g3;

import j3.a;
import java.util.concurrent.atomic.AtomicReference;
import p2.c;
import q2.e;
import t2.b;
import v0.f0;

public final class d {
    public static String a(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void b(Class<?> cls) {
        a.r(new e(a(cls.getName())));
    }

    public static boolean c(AtomicReference<c> atomicReference, c cVar, Class<?> cls) {
        b.e(cVar, "next is null");
        if (f0.a(atomicReference, (Object) null, cVar)) {
            return true;
        }
        cVar.dispose();
        if (atomicReference.get() == s2.c.DISPOSED) {
            return false;
        }
        b(cls);
        return false;
    }
}
