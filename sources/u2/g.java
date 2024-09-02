package u2;

import java.util.concurrent.Callable;

public interface g<T> extends Callable<T> {
    T call();
}
