package d3;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import m2.q;
import p2.b;
import p2.c;
import s2.d;

public final class n extends q {

    /* renamed from: d  reason: collision with root package name */
    static final i f4419d = new i("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);

    /* renamed from: e  reason: collision with root package name */
    static final ScheduledExecutorService f4420e;

    /* renamed from: b  reason: collision with root package name */
    final ThreadFactory f4421b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<ScheduledExecutorService> f4422c;

    static final class a extends q.c {

        /* renamed from: e  reason: collision with root package name */
        final ScheduledExecutorService f4423e;

        /* renamed from: f  reason: collision with root package name */
        final b f4424f = new b();

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f4425g;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.f4423e = scheduledExecutorService;
        }

        public c c(Runnable runnable, long j5, TimeUnit timeUnit) {
            Future future;
            if (this.f4425g) {
                return d.INSTANCE;
            }
            l lVar = new l(j3.a.s(runnable), this.f4424f);
            this.f4424f.b(lVar);
            if (j5 <= 0) {
                try {
                    future = this.f4423e.submit(lVar);
                } catch (RejectedExecutionException e5) {
                    dispose();
                    j3.a.r(e5);
                    return d.INSTANCE;
                }
            } else {
                future = this.f4423e.schedule(lVar, j5, timeUnit);
            }
            lVar.a(future);
            return lVar;
        }

        public void dispose() {
            if (!this.f4425g) {
                this.f4425g = true;
                this.f4424f.dispose();
            }
        }

        public boolean f() {
            return this.f4425g;
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f4420e = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
    }

    public n() {
        this(f4419d);
    }

    public n(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.f4422c = atomicReference;
        this.f4421b = threadFactory;
        atomicReference.lazySet(g(threadFactory));
    }

    static ScheduledExecutorService g(ThreadFactory threadFactory) {
        return m.a(threadFactory);
    }

    public q.c a() {
        return new a(this.f4422c.get());
    }

    public c d(Runnable runnable, long j5, TimeUnit timeUnit) {
        Future future;
        k kVar = new k(j3.a.s(runnable));
        if (j5 <= 0) {
            try {
                future = this.f4422c.get().submit(kVar);
            } catch (RejectedExecutionException e5) {
                j3.a.r(e5);
                return d.INSTANCE;
            }
        } else {
            future = this.f4422c.get().schedule(kVar, j5, timeUnit);
        }
        kVar.a(future);
        return kVar;
    }

    public c e(Runnable runnable, long j5, long j6, TimeUnit timeUnit) {
        Future future;
        Runnable s5 = j3.a.s(runnable);
        if (j6 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.f4422c.get();
            e eVar = new e(s5, scheduledExecutorService);
            if (j5 <= 0) {
                try {
                    future = scheduledExecutorService.submit(eVar);
                } catch (RejectedExecutionException e5) {
                    j3.a.r(e5);
                    return d.INSTANCE;
                }
            } else {
                future = scheduledExecutorService.schedule(eVar, j5, timeUnit);
            }
            eVar.b(future);
            return eVar;
        }
        j jVar = new j(s5);
        jVar.a(this.f4422c.get().scheduleAtFixedRate(jVar, j5, j6, timeUnit));
        return jVar;
    }

    public void f() {
        ScheduledExecutorService andSet;
        ScheduledExecutorService scheduledExecutorService = this.f4422c.get();
        ScheduledExecutorService scheduledExecutorService2 = f4420e;
        if (scheduledExecutorService != scheduledExecutorService2 && (andSet = this.f4422c.getAndSet(scheduledExecutorService2)) != scheduledExecutorService2) {
            andSet.shutdownNow();
        }
    }
}
