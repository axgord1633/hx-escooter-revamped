package m2;

import d3.h;
import g3.f;
import java.util.concurrent.TimeUnit;
import s2.d;
import s2.g;

public abstract class q {

    /* renamed from: a  reason: collision with root package name */
    static final long f5882a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    static final class a implements p2.c, Runnable {

        /* renamed from: e  reason: collision with root package name */
        final Runnable f5883e;

        /* renamed from: f  reason: collision with root package name */
        final c f5884f;

        /* renamed from: g  reason: collision with root package name */
        Thread f5885g;

        a(Runnable runnable, c cVar) {
            this.f5883e = runnable;
            this.f5884f = cVar;
        }

        public void dispose() {
            if (this.f5885g == Thread.currentThread()) {
                c cVar = this.f5884f;
                if (cVar instanceof h) {
                    ((h) cVar).i();
                    return;
                }
            }
            this.f5884f.dispose();
        }

        public boolean f() {
            return this.f5884f.f();
        }

        public void run() {
            this.f5885g = Thread.currentThread();
            try {
                this.f5883e.run();
            } finally {
                dispose();
                this.f5885g = null;
            }
        }
    }

    static final class b implements p2.c, Runnable {

        /* renamed from: e  reason: collision with root package name */
        final Runnable f5886e;

        /* renamed from: f  reason: collision with root package name */
        final c f5887f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f5888g;

        b(Runnable runnable, c cVar) {
            this.f5886e = runnable;
            this.f5887f = cVar;
        }

        public void dispose() {
            this.f5888g = true;
            this.f5887f.dispose();
        }

        public boolean f() {
            return this.f5888g;
        }

        public void run() {
            if (!this.f5888g) {
                try {
                    this.f5886e.run();
                } catch (Throwable th) {
                    q2.b.b(th);
                    this.f5887f.dispose();
                    throw f.d(th);
                }
            }
        }
    }

    public static abstract class c implements p2.c {

        final class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            final Runnable f5889e;

            /* renamed from: f  reason: collision with root package name */
            final g f5890f;

            /* renamed from: g  reason: collision with root package name */
            final long f5891g;

            /* renamed from: h  reason: collision with root package name */
            long f5892h;

            /* renamed from: i  reason: collision with root package name */
            long f5893i;

            /* renamed from: j  reason: collision with root package name */
            long f5894j;

            a(long j5, Runnable runnable, long j6, g gVar, long j7) {
                this.f5889e = runnable;
                this.f5890f = gVar;
                this.f5891g = j7;
                this.f5893i = j6;
                this.f5894j = j5;
            }

            public void run() {
                long j5;
                this.f5889e.run();
                if (!this.f5890f.f()) {
                    c cVar = c.this;
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    long a5 = cVar.a(timeUnit);
                    long j6 = q.f5882a;
                    long j7 = this.f5893i;
                    if (a5 + j6 >= j7) {
                        long j8 = this.f5891g;
                        if (a5 < j7 + j8 + j6) {
                            long j9 = this.f5894j;
                            long j10 = this.f5892h + 1;
                            this.f5892h = j10;
                            j5 = j9 + (j10 * j8);
                            this.f5893i = a5;
                            this.f5890f.a(c.this.c(this, j5 - a5, timeUnit));
                        }
                    }
                    long j11 = this.f5891g;
                    long j12 = a5 + j11;
                    long j13 = this.f5892h + 1;
                    this.f5892h = j13;
                    this.f5894j = j12 - (j11 * j13);
                    j5 = j12;
                    this.f5893i = a5;
                    this.f5890f.a(c.this.c(this, j5 - a5, timeUnit));
                }
            }
        }

        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public p2.c b(Runnable runnable) {
            return c(runnable, 0, TimeUnit.NANOSECONDS);
        }

        public abstract p2.c c(Runnable runnable, long j5, TimeUnit timeUnit);

        public p2.c d(Runnable runnable, long j5, long j6, TimeUnit timeUnit) {
            long j7 = j5;
            TimeUnit timeUnit2 = timeUnit;
            g gVar = new g();
            g gVar2 = new g(gVar);
            Runnable s5 = j3.a.s(runnable);
            long nanos = timeUnit2.toNanos(j6);
            long a5 = a(TimeUnit.NANOSECONDS);
            g gVar3 = gVar;
            a aVar = r0;
            a aVar2 = new a(a5 + timeUnit2.toNanos(j7), s5, a5, gVar2, nanos);
            p2.c c5 = c(aVar, j7, timeUnit2);
            if (c5 == d.INSTANCE) {
                return c5;
            }
            gVar3.a(c5);
            return gVar2;
        }
    }

    public abstract c a();

    public long b(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public p2.c c(Runnable runnable) {
        return d(runnable, 0, TimeUnit.NANOSECONDS);
    }

    public p2.c d(Runnable runnable, long j5, TimeUnit timeUnit) {
        c a5 = a();
        a aVar = new a(j3.a.s(runnable), a5);
        a5.c(aVar, j5, timeUnit);
        return aVar;
    }

    public p2.c e(Runnable runnable, long j5, long j6, TimeUnit timeUnit) {
        c a5 = a();
        b bVar = new b(j3.a.s(runnable), a5);
        p2.c d5 = a5.d(bVar, j5, j6, timeUnit);
        return d5 == d.INSTANCE ? d5 : bVar;
    }

    public void f() {
    }
}
