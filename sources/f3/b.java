package f3;

import java.util.concurrent.atomic.AtomicLong;
import u2.f;

public abstract class b<T> extends AtomicLong implements f<T> {
    public final boolean offer(T t5) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
