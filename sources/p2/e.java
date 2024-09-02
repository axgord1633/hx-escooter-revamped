package p2;

import java.util.concurrent.atomic.AtomicReference;
import t2.b;

abstract class e<T> extends AtomicReference<T> implements c {
    e(T t5) {
        super(b.e(t5, "value is null"));
    }

    /* access modifiers changed from: protected */
    public abstract void a(T t5);

    public final void dispose() {
        Object andSet;
        if (get() != null && (andSet = getAndSet((Object) null)) != null) {
            a(andSet);
        }
    }

    public final boolean f() {
        return get() == null;
    }
}
