package d3;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class i extends AtomicLong implements ThreadFactory {

    /* renamed from: e  reason: collision with root package name */
    final String f4407e;

    /* renamed from: f  reason: collision with root package name */
    final int f4408f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f4409g;

    static final class a extends Thread {
        a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public i(String str) {
        this(str, 5, false);
    }

    public i(String str, int i5) {
        this(str, i5, false);
    }

    public i(String str, int i5, boolean z4) {
        this.f4407e = str;
        this.f4408f = i5;
        this.f4409g = z4;
    }

    public Thread newThread(Runnable runnable) {
        String str = this.f4407e + '-' + incrementAndGet();
        Thread aVar = this.f4409g ? new a(runnable, str) : new Thread(runnable, str);
        aVar.setPriority(this.f4408f);
        aVar.setDaemon(true);
        return aVar;
    }

    public String toString() {
        return "RxThreadFactory[" + this.f4407e + "]";
    }
}
