package s4;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class t {

    /* renamed from: d  reason: collision with root package name */
    public static final t f6800d = new a();

    /* renamed from: a  reason: collision with root package name */
    private boolean f6801a;

    /* renamed from: b  reason: collision with root package name */
    private long f6802b;

    /* renamed from: c  reason: collision with root package name */
    private long f6803c;

    class a extends t {
        a() {
        }

        public t d(long j5) {
            return this;
        }

        public void f() {
        }

        public t g(long j5, TimeUnit timeUnit) {
            return this;
        }
    }

    public t a() {
        this.f6801a = false;
        return this;
    }

    public t b() {
        this.f6803c = 0;
        return this;
    }

    public long c() {
        if (this.f6801a) {
            return this.f6802b;
        }
        throw new IllegalStateException("No deadline");
    }

    public t d(long j5) {
        this.f6801a = true;
        this.f6802b = j5;
        return this;
    }

    public boolean e() {
        return this.f6801a;
    }

    public void f() {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        } else if (this.f6801a && this.f6802b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public t g(long j5, TimeUnit timeUnit) {
        if (j5 < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j5);
        } else if (timeUnit != null) {
            this.f6803c = timeUnit.toNanos(j5);
            return this;
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public long h() {
        return this.f6803c;
    }
}
