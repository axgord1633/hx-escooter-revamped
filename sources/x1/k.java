package x1;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class k extends AtomicLong implements ThreadFactory {

    static final class a extends Thread {
        a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public Thread newThread(Runnable runnable) {
        a aVar = new a(runnable, "RxBleThread-" + incrementAndGet());
        aVar.setPriority(5);
        aVar.setDaemon(true);
        return aVar;
    }
}
