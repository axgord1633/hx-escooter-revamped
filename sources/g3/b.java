package g3;

import java.util.concurrent.atomic.AtomicReference;

public final class b extends AtomicReference<Throwable> {
    public boolean a(Throwable th) {
        return f.a(this, th);
    }

    public Throwable b() {
        return f.b(this);
    }
}
