package l1;

import java.util.concurrent.Executor;

final class t implements Executor {
    t() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
