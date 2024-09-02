package x1;

import java.util.concurrent.atomic.AtomicBoolean;
import r1.q;

class j implements i {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f7622a = new AtomicBoolean(false);

    j() {
    }

    public synchronized void a() {
        while (!this.f7622a.get()) {
            try {
                wait();
            } catch (InterruptedException e5) {
                if (!this.f7622a.get()) {
                    q.r(e5, "Queue's awaitRelease() has been interrupted abruptly while it wasn't released by the release() method.", new Object[0]);
                }
            }
        }
    }

    public synchronized void release() {
        if (this.f7622a.compareAndSet(false, true)) {
            notify();
        }
    }
}
