package d3;

import java.util.concurrent.Callable;

public final class k extends a implements Callable<Void> {
    public k(Runnable runnable) {
        super(runnable);
    }

    /* renamed from: b */
    public Void call() {
        this.f4342f = Thread.currentThread();
        try {
            this.f4341e.run();
            return null;
        } finally {
            lazySet(a.f4339g);
            this.f4342f = null;
        }
    }
}
