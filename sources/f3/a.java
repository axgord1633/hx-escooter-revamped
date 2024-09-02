package f3;

import java.util.concurrent.atomic.AtomicInteger;
import u2.f;

public abstract class a<T> extends AtomicInteger implements f<T> {
    public final boolean offer(T t5) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
