package p2;

import java.util.concurrent.atomic.AtomicReference;
import s2.c;

public final class g implements c {

    /* renamed from: e  reason: collision with root package name */
    final AtomicReference<c> f6551e = new AtomicReference<>();

    public boolean a(c cVar) {
        return c.n(this.f6551e, cVar);
    }

    public void dispose() {
        c.c(this.f6551e);
    }

    public boolean f() {
        return c.i(this.f6551e.get());
    }
}
