package f3;

import j3.a;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import q2.e;
import t2.b;
import u4.c;
import v0.f0;

public enum g implements c {
    CANCELLED;

    public static boolean c(AtomicReference<c> atomicReference) {
        c andSet;
        c cVar = atomicReference.get();
        g gVar = CANCELLED;
        if (cVar == gVar || (andSet = atomicReference.getAndSet(gVar)) == gVar) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.cancel();
        return true;
    }

    public static void i(AtomicReference<c> atomicReference, AtomicLong atomicLong, long j5) {
        c cVar = atomicReference.get();
        if (cVar != null) {
            cVar.f(j5);
        } else if (p(j5)) {
            g3.c.a(atomicLong, j5);
            c cVar2 = atomicReference.get();
            if (cVar2 != null) {
                long andSet = atomicLong.getAndSet(0);
                if (andSet != 0) {
                    cVar2.f(andSet);
                }
            }
        }
    }

    public static boolean l(AtomicReference<c> atomicReference, AtomicLong atomicLong, c cVar) {
        if (!o(atomicReference, cVar)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0);
        if (andSet == 0) {
            return true;
        }
        cVar.f(andSet);
        return true;
    }

    public static void m(long j5) {
        a.r(new e("More produced than requested: " + j5));
    }

    public static void n() {
        a.r(new e("Subscription already set!"));
    }

    public static boolean o(AtomicReference<c> atomicReference, c cVar) {
        b.e(cVar, "s is null");
        if (f0.a(atomicReference, (Object) null, cVar)) {
            return true;
        }
        cVar.cancel();
        if (atomicReference.get() == CANCELLED) {
            return false;
        }
        n();
        return false;
    }

    public static boolean p(long j5) {
        if (j5 > 0) {
            return true;
        }
        a.r(new IllegalArgumentException("n > 0 required but it was " + j5));
        return false;
    }

    public static boolean q(c cVar, c cVar2) {
        if (cVar2 == null) {
            a.r(new NullPointerException("next is null"));
            return false;
        } else if (cVar == null) {
            return true;
        } else {
            cVar2.cancel();
            n();
            return false;
        }
    }

    public void cancel() {
    }

    public void f(long j5) {
    }
}
