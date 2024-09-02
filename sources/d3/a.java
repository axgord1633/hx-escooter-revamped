package d3;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import p2.c;

abstract class a extends AtomicReference<Future<?>> implements c {

    /* renamed from: g  reason: collision with root package name */
    protected static final FutureTask<Void> f4339g;

    /* renamed from: h  reason: collision with root package name */
    protected static final FutureTask<Void> f4340h;

    /* renamed from: e  reason: collision with root package name */
    protected final Runnable f4341e;

    /* renamed from: f  reason: collision with root package name */
    protected Thread f4342f;

    static {
        Runnable runnable = t2.a.f7033b;
        f4339g = new FutureTask<>(runnable, (Object) null);
        f4340h = new FutureTask<>(runnable, (Object) null);
    }

    a(Runnable runnable) {
        this.f4341e = runnable;
    }

    public final void a(Future<?> future) {
        Future future2;
        do {
            future2 = (Future) get();
            if (future2 != f4339g) {
                if (future2 == f4340h) {
                    future.cancel(this.f4342f != Thread.currentThread());
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    public final void dispose() {
        FutureTask<Void> futureTask;
        Future future = (Future) get();
        if (future != f4339g && future != (futureTask = f4340h) && compareAndSet(future, futureTask) && future != null) {
            future.cancel(this.f4342f != Thread.currentThread());
        }
    }

    public final boolean f() {
        Future future = (Future) get();
        return future == f4339g || future == f4340h;
    }
}
