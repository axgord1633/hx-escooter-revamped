package s2;

import j3.a;
import java.util.concurrent.atomic.AtomicReference;
import q2.e;
import t2.b;
import v0.f0;

public enum c implements p2.c {
    DISPOSED;

    public static boolean c(AtomicReference<p2.c> atomicReference) {
        p2.c andSet;
        p2.c cVar = atomicReference.get();
        c cVar2 = DISPOSED;
        if (cVar == cVar2 || (andSet = atomicReference.getAndSet(cVar2)) == cVar2) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }

    public static boolean i(p2.c cVar) {
        return cVar == DISPOSED;
    }

    public static boolean l(AtomicReference<p2.c> atomicReference, p2.c cVar) {
        p2.c cVar2;
        do {
            cVar2 = atomicReference.get();
            if (cVar2 == DISPOSED) {
                if (cVar == null) {
                    return false;
                }
                cVar.dispose();
                return false;
            }
        } while (!f0.a(atomicReference, cVar2, cVar));
        return true;
    }

    public static void m() {
        a.r(new e("Disposable already set!"));
    }

    public static boolean n(AtomicReference<p2.c> atomicReference, p2.c cVar) {
        p2.c cVar2;
        do {
            cVar2 = atomicReference.get();
            if (cVar2 == DISPOSED) {
                if (cVar == null) {
                    return false;
                }
                cVar.dispose();
                return false;
            }
        } while (!f0.a(atomicReference, cVar2, cVar));
        if (cVar2 == null) {
            return true;
        }
        cVar2.dispose();
        return true;
    }

    public static boolean o(AtomicReference<p2.c> atomicReference, p2.c cVar) {
        b.e(cVar, "d is null");
        if (f0.a(atomicReference, (Object) null, cVar)) {
            return true;
        }
        cVar.dispose();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        m();
        return false;
    }

    public static boolean p(AtomicReference<p2.c> atomicReference, p2.c cVar) {
        if (f0.a(atomicReference, (Object) null, cVar)) {
            return true;
        }
        if (atomicReference.get() != DISPOSED) {
            return false;
        }
        cVar.dispose();
        return false;
    }

    public static boolean q(p2.c cVar, p2.c cVar2) {
        if (cVar2 == null) {
            a.r(new NullPointerException("next is null"));
            return false;
        } else if (cVar == null) {
            return true;
        } else {
            cVar2.dispose();
            m();
            return false;
        }
    }

    public void dispose() {
    }

    public boolean f() {
        return true;
    }
}
