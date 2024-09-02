package o2;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import m2.q;
import p2.c;
import p2.d;

final class b extends q {

    /* renamed from: b  reason: collision with root package name */
    private final Handler f6144b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f6145c;

    private static final class a extends q.c {

        /* renamed from: e  reason: collision with root package name */
        private final Handler f6146e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f6147f;

        /* renamed from: g  reason: collision with root package name */
        private volatile boolean f6148g;

        a(Handler handler, boolean z4) {
            this.f6146e = handler;
            this.f6147f = z4;
        }

        public c c(Runnable runnable, long j5, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else if (this.f6148g) {
                return d.a();
            } else {
                C0095b bVar = new C0095b(this.f6146e, j3.a.s(runnable));
                Message obtain = Message.obtain(this.f6146e, bVar);
                obtain.obj = this;
                if (this.f6147f) {
                    obtain.setAsynchronous(true);
                }
                this.f6146e.sendMessageDelayed(obtain, timeUnit.toMillis(j5));
                if (!this.f6148g) {
                    return bVar;
                }
                this.f6146e.removeCallbacks(bVar);
                return d.a();
            }
        }

        public void dispose() {
            this.f6148g = true;
            this.f6146e.removeCallbacksAndMessages(this);
        }

        public boolean f() {
            return this.f6148g;
        }
    }

    /* renamed from: o2.b$b  reason: collision with other inner class name */
    private static final class C0095b implements Runnable, c {

        /* renamed from: e  reason: collision with root package name */
        private final Handler f6149e;

        /* renamed from: f  reason: collision with root package name */
        private final Runnable f6150f;

        /* renamed from: g  reason: collision with root package name */
        private volatile boolean f6151g;

        C0095b(Handler handler, Runnable runnable) {
            this.f6149e = handler;
            this.f6150f = runnable;
        }

        public void dispose() {
            this.f6149e.removeCallbacks(this);
            this.f6151g = true;
        }

        public boolean f() {
            return this.f6151g;
        }

        public void run() {
            try {
                this.f6150f.run();
            } catch (Throwable th) {
                j3.a.r(th);
            }
        }
    }

    b(Handler handler, boolean z4) {
        this.f6144b = handler;
        this.f6145c = z4;
    }

    public q.c a() {
        return new a(this.f6144b, this.f6145c);
    }

    public c d(Runnable runnable, long j5, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        } else if (timeUnit != null) {
            C0095b bVar = new C0095b(this.f6144b, j3.a.s(runnable));
            Message obtain = Message.obtain(this.f6144b, bVar);
            if (this.f6145c) {
                obtain.setAsynchronous(true);
            }
            this.f6144b.sendMessageDelayed(obtain, timeUnit.toMillis(j5));
            return bVar;
        } else {
            throw new NullPointerException("unit == null");
        }
    }
}
