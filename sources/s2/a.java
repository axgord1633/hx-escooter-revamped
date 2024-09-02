package s2;

import java.util.concurrent.atomic.AtomicReference;
import p2.c;
import q2.b;
import r2.d;

public final class a extends AtomicReference<d> implements c {
    public a(d dVar) {
        super(dVar);
    }

    public void dispose() {
        d dVar;
        if (get() != null && (dVar = (d) getAndSet((Object) null)) != null) {
            try {
                dVar.cancel();
            } catch (Exception e5) {
                b.b(e5);
                j3.a.r(e5);
            }
        }
    }

    public boolean f() {
        return get() == null;
    }
}
