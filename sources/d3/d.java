package d3;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import m2.q;
import s2.g;

public final class d extends q {

    /* renamed from: d  reason: collision with root package name */
    static final q f4358d = k3.a.c();

    /* renamed from: b  reason: collision with root package name */
    final boolean f4359b;

    /* renamed from: c  reason: collision with root package name */
    final Executor f4360c;

    final class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        private final b f4361e;

        a(b bVar) {
            this.f4361e = bVar;
        }

        public void run() {
            b bVar = this.f4361e;
            bVar.f4364f.a(d.this.c(bVar));
        }
    }

    static final class b extends AtomicReference<Runnable> implements Runnable, p2.c {

        /* renamed from: e  reason: collision with root package name */
        final g f4363e = new g();

        /* renamed from: f  reason: collision with root package name */
        final g f4364f = new g();

        b(Runnable runnable) {
            super(runnable);
        }

        public void dispose() {
            if (getAndSet((Object) null) != null) {
                this.f4363e.dispose();
                this.f4364f.dispose();
            }
        }

        public boolean f() {
            return get() == null;
        }

        public void run() {
            Runnable runnable = (Runnable) get();
            if (runnable != null) {
                try {
                    runnable.run();
                    lazySet((Object) null);
                    g gVar = this.f4363e;
                    s2.c cVar = s2.c.DISPOSED;
                    gVar.lazySet(cVar);
                    this.f4364f.lazySet(cVar);
                } catch (Throwable th) {
                    lazySet((Object) null);
                    this.f4363e.lazySet(s2.c.DISPOSED);
                    this.f4364f.lazySet(s2.c.DISPOSED);
                    throw th;
                }
            }
        }
    }

    public static final class c extends q.c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final boolean f4365e;

        /* renamed from: f  reason: collision with root package name */
        final Executor f4366f;

        /* renamed from: g  reason: collision with root package name */
        final c3.a<Runnable> f4367g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f4368h;

        /* renamed from: i  reason: collision with root package name */
        final AtomicInteger f4369i = new AtomicInteger();

        /* renamed from: j  reason: collision with root package name */
        final p2.b f4370j = new p2.b();

        static final class a extends AtomicBoolean implements Runnable, p2.c {

            /* renamed from: e  reason: collision with root package name */
            final Runnable f4371e;

            a(Runnable runnable) {
                this.f4371e = runnable;
            }

            public void dispose() {
                lazySet(true);
            }

            public boolean f() {
                return get();
            }

            public void run() {
                if (!get()) {
                    try {
                        this.f4371e.run();
                    } finally {
                        lazySet(true);
                    }
                }
            }
        }

        static final class b extends AtomicInteger implements Runnable, p2.c {

            /* renamed from: e  reason: collision with root package name */
            final Runnable f4372e;

            /* renamed from: f  reason: collision with root package name */
            final s2.b f4373f;

            /* renamed from: g  reason: collision with root package name */
            volatile Thread f4374g;

            b(Runnable runnable, s2.b bVar) {
                this.f4372e = runnable;
                this.f4373f = bVar;
            }

            /* access modifiers changed from: package-private */
            public void a() {
                s2.b bVar = this.f4373f;
                if (bVar != null) {
                    bVar.a(this);
                }
            }

            public void dispose() {
                while (true) {
                    int i5 = get();
                    if (i5 < 2) {
                        if (i5 == 0) {
                            if (compareAndSet(0, 4)) {
                                break;
                            }
                        } else if (compareAndSet(1, 3)) {
                            Thread thread = this.f4374g;
                            if (thread != null) {
                                thread.interrupt();
                                this.f4374g = null;
                            }
                            set(4);
                        }
                    } else {
                        return;
                    }
                }
                a();
            }

            public boolean f() {
                return get() >= 2;
            }

            public void run() {
                if (get() == 0) {
                    this.f4374g = Thread.currentThread();
                    if (compareAndSet(0, 1)) {
                        try {
                            this.f4372e.run();
                            this.f4374g = null;
                            if (compareAndSet(1, 2)) {
                                a();
                                return;
                            }
                            while (get() == 3) {
                                Thread.yield();
                            }
                            Thread.interrupted();
                        } catch (Throwable th) {
                            this.f4374g = null;
                            if (!compareAndSet(1, 2)) {
                                while (get() == 3) {
                                    Thread.yield();
                                }
                                Thread.interrupted();
                            } else {
                                a();
                            }
                            throw th;
                        }
                    } else {
                        this.f4374g = null;
                    }
                }
            }
        }

        /* renamed from: d3.d$c$c  reason: collision with other inner class name */
        final class C0072c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            private final g f4375e;

            /* renamed from: f  reason: collision with root package name */
            private final Runnable f4376f;

            C0072c(g gVar, Runnable runnable) {
                this.f4375e = gVar;
                this.f4376f = runnable;
            }

            public void run() {
                this.f4375e.a(c.this.b(this.f4376f));
            }
        }

        public c(Executor executor, boolean z4) {
            this.f4366f = executor;
            this.f4367g = new c3.a<>();
            this.f4365e = z4;
        }

        public p2.c b(Runnable runnable) {
            p2.c cVar;
            if (this.f4368h) {
                return s2.d.INSTANCE;
            }
            Runnable s5 = j3.a.s(runnable);
            if (this.f4365e) {
                cVar = new b(s5, this.f4370j);
                this.f4370j.b(cVar);
            } else {
                cVar = new a(s5);
            }
            this.f4367g.offer(cVar);
            if (this.f4369i.getAndIncrement() == 0) {
                try {
                    this.f4366f.execute(this);
                } catch (RejectedExecutionException e5) {
                    this.f4368h = true;
                    this.f4367g.clear();
                    j3.a.r(e5);
                    return s2.d.INSTANCE;
                }
            }
            return cVar;
        }

        public p2.c c(Runnable runnable, long j5, TimeUnit timeUnit) {
            if (j5 <= 0) {
                return b(runnable);
            }
            if (this.f4368h) {
                return s2.d.INSTANCE;
            }
            g gVar = new g();
            g gVar2 = new g(gVar);
            l lVar = new l(new C0072c(gVar2, j3.a.s(runnable)), this.f4370j);
            this.f4370j.b(lVar);
            Executor executor = this.f4366f;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    lVar.a(((ScheduledExecutorService) executor).schedule(lVar, j5, timeUnit));
                } catch (RejectedExecutionException e5) {
                    this.f4368h = true;
                    j3.a.r(e5);
                    return s2.d.INSTANCE;
                }
            } else {
                lVar.a(new c(d.f4358d.d(lVar, j5, timeUnit)));
            }
            gVar.a(lVar);
            return gVar2;
        }

        public void dispose() {
            if (!this.f4368h) {
                this.f4368h = true;
                this.f4370j.dispose();
                if (this.f4369i.getAndIncrement() == 0) {
                    this.f4367g.clear();
                }
            }
        }

        public boolean f() {
            return this.f4368h;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
            r1 = r3.f4369i.addAndGet(-r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
            if (r1 != 0) goto L_0x0003;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
            if (r3.f4368h == false) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            r0.clear();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
                c3.a<java.lang.Runnable> r0 = r3.f4367g
                r1 = 1
            L_0x0003:
                boolean r2 = r3.f4368h
                if (r2 == 0) goto L_0x000b
                r0.clear()
                return
            L_0x000b:
                java.lang.Object r2 = r0.poll()
                java.lang.Runnable r2 = (java.lang.Runnable) r2
                if (r2 != 0) goto L_0x0025
                boolean r2 = r3.f4368h
                if (r2 == 0) goto L_0x001b
                r0.clear()
                return
            L_0x001b:
                java.util.concurrent.atomic.AtomicInteger r2 = r3.f4369i
                int r1 = -r1
                int r1 = r2.addAndGet(r1)
                if (r1 != 0) goto L_0x0003
                return
            L_0x0025:
                r2.run()
                boolean r2 = r3.f4368h
                if (r2 == 0) goto L_0x000b
                r0.clear()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: d3.d.c.run():void");
        }
    }

    public d(Executor executor, boolean z4) {
        this.f4360c = executor;
        this.f4359b = z4;
    }

    public q.c a() {
        return new c(this.f4360c, this.f4359b);
    }

    public p2.c c(Runnable runnable) {
        Runnable s5 = j3.a.s(runnable);
        try {
            if (this.f4360c instanceof ExecutorService) {
                k kVar = new k(s5);
                kVar.a(((ExecutorService) this.f4360c).submit(kVar));
                return kVar;
            } else if (this.f4359b) {
                c.b bVar = new c.b(s5, (s2.b) null);
                this.f4360c.execute(bVar);
                return bVar;
            } else {
                c.a aVar = new c.a(s5);
                this.f4360c.execute(aVar);
                return aVar;
            }
        } catch (RejectedExecutionException e5) {
            j3.a.r(e5);
            return s2.d.INSTANCE;
        }
    }

    public p2.c d(Runnable runnable, long j5, TimeUnit timeUnit) {
        Runnable s5 = j3.a.s(runnable);
        if (this.f4360c instanceof ScheduledExecutorService) {
            try {
                k kVar = new k(s5);
                kVar.a(((ScheduledExecutorService) this.f4360c).schedule(kVar, j5, timeUnit));
                return kVar;
            } catch (RejectedExecutionException e5) {
                j3.a.r(e5);
                return s2.d.INSTANCE;
            }
        } else {
            b bVar = new b(s5);
            bVar.f4363e.a(f4358d.d(new a(bVar), j5, timeUnit));
            return bVar;
        }
    }

    public p2.c e(Runnable runnable, long j5, long j6, TimeUnit timeUnit) {
        if (!(this.f4360c instanceof ScheduledExecutorService)) {
            return super.e(runnable, j5, j6, timeUnit);
        }
        try {
            j jVar = new j(j3.a.s(runnable));
            jVar.a(((ScheduledExecutorService) this.f4360c).scheduleAtFixedRate(jVar, j5, j6, timeUnit));
            return jVar;
        } catch (RejectedExecutionException e5) {
            j3.a.r(e5);
            return s2.d.INSTANCE;
        }
    }
}
