package d3;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import m2.q;
import s2.d;
import s2.e;
import v0.f0;

public final class b extends q {

    /* renamed from: d  reason: collision with root package name */
    static final C0071b f4343d;

    /* renamed from: e  reason: collision with root package name */
    static final i f4344e;

    /* renamed from: f  reason: collision with root package name */
    static final int f4345f = g(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* renamed from: g  reason: collision with root package name */
    static final c f4346g;

    /* renamed from: b  reason: collision with root package name */
    final ThreadFactory f4347b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<C0071b> f4348c;

    static final class a extends q.c {

        /* renamed from: e  reason: collision with root package name */
        private final e f4349e;

        /* renamed from: f  reason: collision with root package name */
        private final p2.b f4350f;

        /* renamed from: g  reason: collision with root package name */
        private final e f4351g;

        /* renamed from: h  reason: collision with root package name */
        private final c f4352h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f4353i;

        a(c cVar) {
            this.f4352h = cVar;
            e eVar = new e();
            this.f4349e = eVar;
            p2.b bVar = new p2.b();
            this.f4350f = bVar;
            e eVar2 = new e();
            this.f4351g = eVar2;
            eVar2.b(eVar);
            eVar2.b(bVar);
        }

        public p2.c b(Runnable runnable) {
            if (this.f4353i) {
                return d.INSTANCE;
            }
            return this.f4352h.e(runnable, 0, TimeUnit.MILLISECONDS, this.f4349e);
        }

        public p2.c c(Runnable runnable, long j5, TimeUnit timeUnit) {
            if (this.f4353i) {
                return d.INSTANCE;
            }
            return this.f4352h.e(runnable, j5, timeUnit, this.f4350f);
        }

        public void dispose() {
            if (!this.f4353i) {
                this.f4353i = true;
                this.f4351g.dispose();
            }
        }

        public boolean f() {
            return this.f4353i;
        }
    }

    /* renamed from: d3.b$b  reason: collision with other inner class name */
    static final class C0071b {

        /* renamed from: a  reason: collision with root package name */
        final int f4354a;

        /* renamed from: b  reason: collision with root package name */
        final c[] f4355b;

        /* renamed from: c  reason: collision with root package name */
        long f4356c;

        C0071b(int i5, ThreadFactory threadFactory) {
            this.f4354a = i5;
            this.f4355b = new c[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                this.f4355b[i6] = new c(threadFactory);
            }
        }

        public c a() {
            int i5 = this.f4354a;
            if (i5 == 0) {
                return b.f4346g;
            }
            c[] cVarArr = this.f4355b;
            long j5 = this.f4356c;
            this.f4356c = 1 + j5;
            return cVarArr[(int) (j5 % ((long) i5))];
        }

        public void b() {
            for (c dispose : this.f4355b) {
                dispose.dispose();
            }
        }
    }

    static final class c extends h {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new i("RxComputationShutdown"));
        f4346g = cVar;
        cVar.dispose();
        i iVar = new i("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f4344e = iVar;
        C0071b bVar = new C0071b(0, iVar);
        f4343d = bVar;
        bVar.b();
    }

    public b() {
        this(f4344e);
    }

    public b(ThreadFactory threadFactory) {
        this.f4347b = threadFactory;
        this.f4348c = new AtomicReference<>(f4343d);
        h();
    }

    static int g(int i5, int i6) {
        return (i6 <= 0 || i6 > i5) ? i5 : i6;
    }

    public q.c a() {
        return new a(this.f4348c.get().a());
    }

    public p2.c d(Runnable runnable, long j5, TimeUnit timeUnit) {
        return this.f4348c.get().a().g(runnable, j5, timeUnit);
    }

    public p2.c e(Runnable runnable, long j5, long j6, TimeUnit timeUnit) {
        return this.f4348c.get().a().h(runnable, j5, j6, timeUnit);
    }

    public void f() {
        C0071b bVar;
        C0071b bVar2;
        do {
            bVar = this.f4348c.get();
            bVar2 = f4343d;
            if (bVar == bVar2) {
                return;
            }
        } while (!f0.a(this.f4348c, bVar, bVar2));
        bVar.b();
    }

    public void h() {
        C0071b bVar = new C0071b(f4345f, this.f4347b);
        if (!f0.a(this.f4348c, f4343d, bVar)) {
            bVar.b();
        }
    }
}
