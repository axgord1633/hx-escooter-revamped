package s2;

import java.util.concurrent.atomic.AtomicReference;
import p2.c;

public final class g extends AtomicReference<c> implements c {
    public g() {
    }

    public g(c cVar) {
        lazySet(cVar);
    }

    public boolean a(c cVar) {
        return c.l(this, cVar);
    }

    public boolean b(c cVar) {
        return c.n(this, cVar);
    }

    public void dispose() {
        c.c(this);
    }

    public boolean f() {
        return c.i((c) get());
    }
}
