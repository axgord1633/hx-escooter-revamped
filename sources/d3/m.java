package d3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import r2.f;
import v0.f0;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f4415a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f4416b;

    /* renamed from: c  reason: collision with root package name */
    static final AtomicReference<ScheduledExecutorService> f4417c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    static final Map<ScheduledThreadPoolExecutor, Object> f4418d = new ConcurrentHashMap();

    static final class a implements Runnable {
        a() {
        }

        public void run() {
            Iterator it = new ArrayList(m.f4418d.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    m.f4418d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    static final class b implements f<String, String> {
        b() {
        }

        /* renamed from: a */
        public String apply(String str) {
            return System.getProperty(str);
        }
    }

    static {
        b bVar = new b();
        boolean b5 = b(true, "rx2.purge-enabled", true, true, bVar);
        f4415a = b5;
        f4416b = c(b5, "rx2.purge-period-seconds", 1, 1, bVar);
        d();
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        e(f4415a, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    static boolean b(boolean z4, String str, boolean z5, boolean z6, f<String, String> fVar) {
        if (!z4) {
            return z6;
        }
        try {
            String apply = fVar.apply(str);
            return apply == null ? z5 : "true".equals(apply);
        } catch (Throwable unused) {
            return z5;
        }
    }

    static int c(boolean z4, String str, int i5, int i6, f<String, String> fVar) {
        if (!z4) {
            return i6;
        }
        try {
            String apply = fVar.apply(str);
            return apply == null ? i5 : Integer.parseInt(apply);
        } catch (Throwable unused) {
            return i5;
        }
    }

    public static void d() {
        f(f4415a);
    }

    static void e(boolean z4, ScheduledExecutorService scheduledExecutorService) {
        if (z4 && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f4418d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    static void f(boolean z4) {
        if (z4) {
            while (true) {
                AtomicReference<ScheduledExecutorService> atomicReference = f4417c;
                ScheduledExecutorService scheduledExecutorService = atomicReference.get();
                if (scheduledExecutorService == null) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new i("RxSchedulerPurge"));
                    if (f0.a(atomicReference, scheduledExecutorService, newScheduledThreadPool)) {
                        a aVar = new a();
                        int i5 = f4416b;
                        newScheduledThreadPool.scheduleAtFixedRate(aVar, (long) i5, (long) i5, TimeUnit.SECONDS);
                        return;
                    }
                    newScheduledThreadPool.shutdownNow();
                } else {
                    return;
                }
            }
        }
    }
}
