package g3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import v0.f0;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final Throwable f4747a = new a();

    static final class a extends Throwable {
        a() {
            super("No further exceptions");
        }

        public Throwable fillInStackTrace() {
            return this;
        }
    }

    public static <T> boolean a(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        Throwable th3;
        do {
            th2 = atomicReference.get();
            if (th2 == f4747a) {
                return false;
            }
            if (th2 == null) {
                th3 = th;
            } else {
                th3 = new q2.a(th2, th);
            }
        } while (!f0.a(atomicReference, th2, th3));
        return true;
    }

    public static <T> Throwable b(AtomicReference<Throwable> atomicReference) {
        Throwable th = atomicReference.get();
        Throwable th2 = f4747a;
        return th != th2 ? atomicReference.getAndSet(th2) : th;
    }

    public static String c(long j5, TimeUnit timeUnit) {
        return "The source did not signal an event for " + j5 + " " + timeUnit.toString().toLowerCase() + " and has been terminated.";
    }

    public static RuntimeException d(Throwable th) {
        if (!(th instanceof Error)) {
            return th instanceof RuntimeException ? (RuntimeException) th : new RuntimeException(th);
        }
        throw ((Error) th);
    }
}
