package g3;

import j3.a;
import java.util.concurrent.atomic.AtomicInteger;
import m2.p;
import u4.b;

public final class g {
    public static void a(p<?> pVar, AtomicInteger atomicInteger, b bVar) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable b5 = bVar.b();
            if (b5 != null) {
                pVar.onError(b5);
            } else {
                pVar.a();
            }
        }
    }

    public static void b(b<?> bVar, AtomicInteger atomicInteger, b bVar2) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable b5 = bVar2.b();
            if (b5 != null) {
                bVar.onError(b5);
            } else {
                bVar.a();
            }
        }
    }

    public static void c(p<?> pVar, Throwable th, AtomicInteger atomicInteger, b bVar) {
        if (!bVar.a(th)) {
            a.r(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            pVar.onError(bVar.b());
        }
    }

    public static void d(b<?> bVar, Throwable th, AtomicInteger atomicInteger, b bVar2) {
        if (!bVar2.a(th)) {
            a.r(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            bVar.onError(bVar2.b());
        }
    }

    public static <T> void e(p<? super T> pVar, T t5, AtomicInteger atomicInteger, b bVar) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            pVar.d(t5);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable b5 = bVar.b();
                if (b5 != null) {
                    pVar.onError(b5);
                } else {
                    pVar.a();
                }
            }
        }
    }

    public static <T> void f(b<? super T> bVar, T t5, AtomicInteger atomicInteger, b bVar2) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            bVar.d(t5);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable b5 = bVar2.b();
                if (b5 != null) {
                    bVar.onError(b5);
                } else {
                    bVar.a();
                }
            }
        }
    }
}
