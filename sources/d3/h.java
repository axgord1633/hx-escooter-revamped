package d3;

import j3.a;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import m2.q;
import p2.c;
import s2.b;
import s2.d;

public class h extends q.c {

    /* renamed from: e  reason: collision with root package name */
    private final ScheduledExecutorService f4405e;

    /* renamed from: f  reason: collision with root package name */
    volatile boolean f4406f;

    public h(ThreadFactory threadFactory) {
        this.f4405e = m.a(threadFactory);
    }

    public c b(Runnable runnable) {
        return c(runnable, 0, (TimeUnit) null);
    }

    public c c(Runnable runnable, long j5, TimeUnit timeUnit) {
        return this.f4406f ? d.INSTANCE : e(runnable, j5, timeUnit, (b) null);
    }

    public void dispose() {
        if (!this.f4406f) {
            this.f4406f = true;
            this.f4405e.shutdownNow();
        }
    }

    public l e(Runnable runnable, long j5, TimeUnit timeUnit, b bVar) {
        Future future;
        l lVar = new l(a.s(runnable), bVar);
        if (bVar != null && !bVar.b(lVar)) {
            return lVar;
        }
        if (j5 <= 0) {
            try {
                future = this.f4405e.submit(lVar);
            } catch (RejectedExecutionException e5) {
                if (bVar != null) {
                    bVar.c(lVar);
                }
                a.r(e5);
            }
        } else {
            future = this.f4405e.schedule(lVar, j5, timeUnit);
        }
        lVar.a(future);
        return lVar;
    }

    public boolean f() {
        return this.f4406f;
    }

    public c g(Runnable runnable, long j5, TimeUnit timeUnit) {
        Future future;
        k kVar = new k(a.s(runnable));
        if (j5 <= 0) {
            try {
                future = this.f4405e.submit(kVar);
            } catch (RejectedExecutionException e5) {
                a.r(e5);
                return d.INSTANCE;
            }
        } else {
            future = this.f4405e.schedule(kVar, j5, timeUnit);
        }
        kVar.a(future);
        return kVar;
    }

    public c h(Runnable runnable, long j5, long j6, TimeUnit timeUnit) {
        Future future;
        Runnable s5 = a.s(runnable);
        if (j6 <= 0) {
            e eVar = new e(s5, this.f4405e);
            if (j5 <= 0) {
                try {
                    future = this.f4405e.submit(eVar);
                } catch (RejectedExecutionException e5) {
                    a.r(e5);
                    return d.INSTANCE;
                }
            } else {
                future = this.f4405e.schedule(eVar, j5, timeUnit);
            }
            eVar.b(future);
            return eVar;
        }
        j jVar = new j(s5);
        jVar.a(this.f4405e.scheduleAtFixedRate(jVar, j5, j6, timeUnit));
        return jVar;
    }

    public void i() {
        if (!this.f4406f) {
            this.f4406f = true;
            this.f4405e.shutdown();
        }
    }
}
