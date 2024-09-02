package d3;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import m2.q;
import s2.d;
import v0.f0;

public final class f extends q {

    /* renamed from: d  reason: collision with root package name */
    static final i f4384d;

    /* renamed from: e  reason: collision with root package name */
    static final i f4385e;

    /* renamed from: f  reason: collision with root package name */
    private static final long f4386f = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    /* renamed from: g  reason: collision with root package name */
    private static final TimeUnit f4387g = TimeUnit.SECONDS;

    /* renamed from: h  reason: collision with root package name */
    static final c f4388h;

    /* renamed from: i  reason: collision with root package name */
    static final a f4389i;

    /* renamed from: b  reason: collision with root package name */
    final ThreadFactory f4390b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<a> f4391c;

    static final class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        private final long f4392e;

        /* renamed from: f  reason: collision with root package name */
        private final ConcurrentLinkedQueue<c> f4393f;

        /* renamed from: g  reason: collision with root package name */
        final p2.b f4394g;

        /* renamed from: h  reason: collision with root package name */
        private final ScheduledExecutorService f4395h;

        /* renamed from: i  reason: collision with root package name */
        private final Future<?> f4396i;

        /* renamed from: j  reason: collision with root package name */
        private final ThreadFactory f4397j;

        a(long j5, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            long nanos = timeUnit != null ? timeUnit.toNanos(j5) : 0;
            this.f4392e = nanos;
            this.f4393f = new ConcurrentLinkedQueue<>();
            this.f4394g = new p2.b();
            this.f4397j = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, f.f4385e);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f4395h = scheduledExecutorService;
            this.f4396i = scheduledFuture;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (!this.f4393f.isEmpty()) {
                long c5 = c();
                Iterator<c> it = this.f4393f.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.j() > c5) {
                        return;
                    }
                    if (this.f4393f.remove(next)) {
                        this.f4394g.c(next);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public c b() {
            if (this.f4394g.f()) {
                return f.f4388h;
            }
            while (!this.f4393f.isEmpty()) {
                c poll = this.f4393f.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f4397j);
            this.f4394g.b(cVar);
            return cVar;
        }

        /* access modifiers changed from: package-private */
        public long c() {
            return System.nanoTime();
        }

        /* access modifiers changed from: package-private */
        public void d(c cVar) {
            cVar.k(c() + this.f4392e);
            this.f4393f.offer(cVar);
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f4394g.dispose();
            Future<?> future = this.f4396i;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f4395h;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        public void run() {
            a();
        }
    }

    static final class b extends q.c {

        /* renamed from: e  reason: collision with root package name */
        private final p2.b f4398e;

        /* renamed from: f  reason: collision with root package name */
        private final a f4399f;

        /* renamed from: g  reason: collision with root package name */
        private final c f4400g;

        /* renamed from: h  reason: collision with root package name */
        final AtomicBoolean f4401h = new AtomicBoolean();

        b(a aVar) {
            this.f4399f = aVar;
            this.f4398e = new p2.b();
            this.f4400g = aVar.b();
        }

        public p2.c c(Runnable runnable, long j5, TimeUnit timeUnit) {
            if (this.f4398e.f()) {
                return d.INSTANCE;
            }
            return this.f4400g.e(runnable, j5, timeUnit, this.f4398e);
        }

        public void dispose() {
            if (this.f4401h.compareAndSet(false, true)) {
                this.f4398e.dispose();
                this.f4399f.d(this.f4400g);
            }
        }

        public boolean f() {
            return this.f4401h.get();
        }
    }

    static final class c extends h {

        /* renamed from: g  reason: collision with root package name */
        private long f4402g = 0;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        public long j() {
            return this.f4402g;
        }

        public void k(long j5) {
            this.f4402g = j5;
        }
    }

    static {
        c cVar = new c(new i("RxCachedThreadSchedulerShutdown"));
        f4388h = cVar;
        cVar.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        i iVar = new i("RxCachedThreadScheduler", max);
        f4384d = iVar;
        f4385e = new i("RxCachedWorkerPoolEvictor", max);
        a aVar = new a(0, (TimeUnit) null, iVar);
        f4389i = aVar;
        aVar.e();
    }

    public f() {
        this(f4384d);
    }

    public f(ThreadFactory threadFactory) {
        this.f4390b = threadFactory;
        this.f4391c = new AtomicReference<>(f4389i);
        g();
    }

    public q.c a() {
        return new b(this.f4391c.get());
    }

    public void f() {
        a aVar;
        a aVar2;
        do {
            aVar = this.f4391c.get();
            aVar2 = f4389i;
            if (aVar == aVar2) {
                return;
            }
        } while (!f0.a(this.f4391c, aVar, aVar2));
        aVar.e();
    }

    public void g() {
        a aVar = new a(f4386f, f4387g, this.f4390b);
        if (!f0.a(this.f4391c, f4389i, aVar)) {
            aVar.e();
        }
    }
}
