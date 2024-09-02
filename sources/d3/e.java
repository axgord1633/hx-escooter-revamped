package d3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import p2.c;
import t2.a;
import v0.f0;

final class e implements Callable<Void>, c {

    /* renamed from: j  reason: collision with root package name */
    static final FutureTask<Void> f4378j = new FutureTask<>(a.f7033b, (Object) null);

    /* renamed from: e  reason: collision with root package name */
    final Runnable f4379e;

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<Future<?>> f4380f = new AtomicReference<>();

    /* renamed from: g  reason: collision with root package name */
    final AtomicReference<Future<?>> f4381g = new AtomicReference<>();

    /* renamed from: h  reason: collision with root package name */
    final ExecutorService f4382h;

    /* renamed from: i  reason: collision with root package name */
    Thread f4383i;

    e(Runnable runnable, ExecutorService executorService) {
        this.f4379e = runnable;
        this.f4382h = executorService;
    }

    /* renamed from: a */
    public Void call() {
        this.f4383i = Thread.currentThread();
        try {
            this.f4379e.run();
            c(this.f4382h.submit(this));
            this.f4383i = null;
        } catch (Throwable th) {
            this.f4383i = null;
            j3.a.r(th);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void b(Future<?> future) {
        Future future2;
        do {
            future2 = this.f4381g.get();
            if (future2 == f4378j) {
                future.cancel(this.f4383i != Thread.currentThread());
                return;
            }
        } while (!f0.a(this.f4381g, future2, future));
    }

    /* access modifiers changed from: package-private */
    public void c(Future<?> future) {
        Future future2;
        do {
            future2 = this.f4380f.get();
            if (future2 == f4378j) {
                future.cancel(this.f4383i != Thread.currentThread());
                return;
            }
        } while (!f0.a(this.f4380f, future2, future));
    }

    public void dispose() {
        AtomicReference<Future<?>> atomicReference = this.f4381g;
        Future future = f4378j;
        Future andSet = atomicReference.getAndSet(future);
        boolean z4 = true;
        if (!(andSet == null || andSet == future)) {
            andSet.cancel(this.f4383i != Thread.currentThread());
        }
        Future andSet2 = this.f4380f.getAndSet(future);
        if (andSet2 != null && andSet2 != future) {
            if (this.f4383i == Thread.currentThread()) {
                z4 = false;
            }
            andSet2.cancel(z4);
        }
    }

    public boolean f() {
        return this.f4381g.get() == f4378j;
    }
}
