package d3;

import j3.a;

public final class j extends a implements Runnable {
    public j(Runnable runnable) {
        super(runnable);
    }

    public void run() {
        this.f4342f = Thread.currentThread();
        try {
            this.f4341e.run();
            this.f4342f = null;
        } catch (Throwable th) {
            this.f4342f = null;
            lazySet(a.f4339g);
            a.r(th);
        }
    }
}
