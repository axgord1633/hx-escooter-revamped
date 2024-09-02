package c4;

import c4.x0;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public final class l0 extends x0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: l  reason: collision with root package name */
    public static final l0 f3140l;

    /* renamed from: m  reason: collision with root package name */
    private static final long f3141m;

    static {
        Long l5;
        l0 l0Var = new l0();
        f3140l = l0Var;
        w0.U(l0Var, false, 1, (Object) null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l5 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException unused) {
            l5 = 1000L;
        }
        f3141m = timeUnit.toNanos(l5.longValue());
    }

    private l0() {
    }

    private final synchronized void p0() {
        if (s0()) {
            debugStatus = 3;
            k0();
            notifyAll();
        }
    }

    private final synchronized Thread q0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean r0() {
        return debugStatus == 4;
    }

    private final boolean s0() {
        int i5 = debugStatus;
        return i5 == 2 || i5 == 3;
    }

    private final synchronized boolean t0() {
        if (s0()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    private final void u0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    /* access modifiers changed from: protected */
    public Thread Y() {
        Thread thread = _thread;
        return thread == null ? q0() : thread;
    }

    /* access modifiers changed from: protected */
    public void Z(long j5, x0.a aVar) {
        u0();
    }

    public void e0(Runnable runnable) {
        if (r0()) {
            u0();
        }
        super.e0(runnable);
    }

    public void run() {
        c2.f3110a.c(this);
        c.a();
        try {
            if (t0()) {
                long j5 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long i02 = i0();
                    if (i02 == Long.MAX_VALUE) {
                        c.a();
                        long nanoTime = System.nanoTime();
                        if (j5 == Long.MAX_VALUE) {
                            j5 = f3141m + nanoTime;
                        }
                        long j6 = j5 - nanoTime;
                        if (j6 <= 0) {
                            _thread = null;
                            p0();
                            c.a();
                            if (!h0()) {
                                Y();
                                return;
                            }
                            return;
                        }
                        i02 = f.d(i02, j6);
                    } else {
                        j5 = Long.MAX_VALUE;
                    }
                    if (i02 > 0) {
                        if (s0()) {
                            _thread = null;
                            p0();
                            c.a();
                            if (!h0()) {
                                Y();
                                return;
                            }
                            return;
                        }
                        c.a();
                        LockSupport.parkNanos(this, i02);
                    }
                }
            }
        } finally {
            _thread = null;
            p0();
            c.a();
            if (!h0()) {
                Y();
            }
        }
    }

    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
