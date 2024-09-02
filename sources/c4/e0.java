package c4;

import java.util.List;
import java.util.ServiceLoader;
import m3.k;
import m3.l;
import m3.q;
import o3.g;

public final class e0 {

    /* renamed from: a  reason: collision with root package name */
    private static final List<d0> f3117a;

    static {
        Class<d0> cls = d0.class;
        f3117a = h.e(f.a(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
    }

    public static final void a(g gVar, Throwable th) {
        for (d0 j5 : f3117a) {
            try {
                j5.j(gVar, th);
            } catch (Throwable th2) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, f0.b(th, th2));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        try {
            k.a aVar = k.f5898e;
            b.a(th, new o0(gVar));
            k.a(q.f5904a);
        } catch (Throwable th3) {
            k.a aVar2 = k.f5898e;
            k.a(l.a(th3));
        }
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }
}
