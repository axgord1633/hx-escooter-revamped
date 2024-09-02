package d3;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import m2.q;
import s2.d;

public final class o extends q {

    /* renamed from: b  reason: collision with root package name */
    private static final o f4426b = new o();

    static final class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        private final Runnable f4427e;

        /* renamed from: f  reason: collision with root package name */
        private final c f4428f;

        /* renamed from: g  reason: collision with root package name */
        private final long f4429g;

        a(Runnable runnable, c cVar, long j5) {
            this.f4427e = runnable;
            this.f4428f = cVar;
            this.f4429g = j5;
        }

        public void run() {
            if (!this.f4428f.f4437h) {
                long a5 = this.f4428f.a(TimeUnit.MILLISECONDS);
                long j5 = this.f4429g;
                if (j5 > a5) {
                    try {
                        Thread.sleep(j5 - a5);
                    } catch (InterruptedException e5) {
                        Thread.currentThread().interrupt();
                        j3.a.r(e5);
                        return;
                    }
                }
                if (!this.f4428f.f4437h) {
                    this.f4427e.run();
                }
            }
        }
    }

    static final class b implements Comparable<b> {

        /* renamed from: e  reason: collision with root package name */
        final Runnable f4430e;

        /* renamed from: f  reason: collision with root package name */
        final long f4431f;

        /* renamed from: g  reason: collision with root package name */
        final int f4432g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f4433h;

        b(Runnable runnable, Long l5, int i5) {
            this.f4430e = runnable;
            this.f4431f = l5.longValue();
            this.f4432g = i5;
        }

        /* renamed from: c */
        public int compareTo(b bVar) {
            int b5 = t2.b.b(this.f4431f, bVar.f4431f);
            return b5 == 0 ? t2.b.a(this.f4432g, bVar.f4432g) : b5;
        }
    }

    static final class c extends q.c {

        /* renamed from: e  reason: collision with root package name */
        final PriorityBlockingQueue<b> f4434e = new PriorityBlockingQueue<>();

        /* renamed from: f  reason: collision with root package name */
        private final AtomicInteger f4435f = new AtomicInteger();

        /* renamed from: g  reason: collision with root package name */
        final AtomicInteger f4436g = new AtomicInteger();

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f4437h;

        final class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            final b f4438e;

            a(b bVar) {
                this.f4438e = bVar;
            }

            public void run() {
                this.f4438e.f4433h = true;
                c.this.f4434e.remove(this.f4438e);
            }
        }

        c() {
        }

        public p2.c b(Runnable runnable) {
            return e(runnable, a(TimeUnit.MILLISECONDS));
        }

        public p2.c c(Runnable runnable, long j5, TimeUnit timeUnit) {
            long a5 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j5);
            return e(new a(runnable, this, a5), a5);
        }

        public void dispose() {
            this.f4437h = true;
        }

        /* access modifiers changed from: package-private */
        public p2.c e(Runnable runnable, long j5) {
            if (this.f4437h) {
                return d.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j5), this.f4436g.incrementAndGet());
            this.f4434e.add(bVar);
            if (this.f4435f.getAndIncrement() != 0) {
                return p2.d.d(new a(bVar));
            }
            int i5 = 1;
            while (!this.f4437h) {
                b poll = this.f4434e.poll();
                if (poll == null) {
                    i5 = this.f4435f.addAndGet(-i5);
                    if (i5 == 0) {
                        return d.INSTANCE;
                    }
                } else if (!poll.f4433h) {
                    poll.f4430e.run();
                }
            }
            this.f4434e.clear();
            return d.INSTANCE;
        }

        public boolean f() {
            return this.f4437h;
        }
    }

    o() {
    }

    public static o g() {
        return f4426b;
    }

    public q.c a() {
        return new c();
    }

    public p2.c c(Runnable runnable) {
        j3.a.s(runnable).run();
        return d.INSTANCE;
    }

    public p2.c d(Runnable runnable, long j5, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j5);
            j3.a.s(runnable).run();
        } catch (InterruptedException e5) {
            Thread.currentThread().interrupt();
            j3.a.r(e5);
        }
        return d.INSTANCE;
    }
}
