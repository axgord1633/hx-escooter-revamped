package s4;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class a extends t {

    /* renamed from: h  reason: collision with root package name */
    private static final long f6745h;

    /* renamed from: i  reason: collision with root package name */
    private static final long f6746i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    static a f6747j;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6748e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private a f6749f;

    /* renamed from: g  reason: collision with root package name */
    private long f6750g;

    /* renamed from: s4.a$a  reason: collision with other inner class name */
    class C0109a implements r {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ r f6751e;

        C0109a(r rVar) {
            this.f6751e = rVar;
        }

        public void G(c cVar, long j5) {
            u.b(cVar.f6759f, 0, j5);
            while (true) {
                long j6 = 0;
                if (j5 > 0) {
                    o oVar = cVar.f6758e;
                    while (true) {
                        if (j6 >= 65536) {
                            break;
                        }
                        j6 += (long) (oVar.f6791c - oVar.f6790b);
                        if (j6 >= j5) {
                            j6 = j5;
                            break;
                        }
                        oVar = oVar.f6794f;
                    }
                    a.this.k();
                    try {
                        this.f6751e.G(cVar, j6);
                        j5 -= j6;
                        a.this.m(true);
                    } catch (IOException e5) {
                        throw a.this.l(e5);
                    } catch (Throwable th) {
                        a.this.m(false);
                        throw th;
                    }
                } else {
                    return;
                }
            }
        }

        public t c() {
            return a.this;
        }

        public void close() {
            a.this.k();
            try {
                this.f6751e.close();
                a.this.m(true);
            } catch (IOException e5) {
                throw a.this.l(e5);
            } catch (Throwable th) {
                a.this.m(false);
                throw th;
            }
        }

        public void flush() {
            a.this.k();
            try {
                this.f6751e.flush();
                a.this.m(true);
            } catch (IOException e5) {
                throw a.this.l(e5);
            } catch (Throwable th) {
                a.this.m(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f6751e + ")";
        }
    }

    class b implements s {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ s f6753e;

        b(s sVar) {
            this.f6753e = sVar;
        }

        public long K(c cVar, long j5) {
            a.this.k();
            try {
                long K = this.f6753e.K(cVar, j5);
                a.this.m(true);
                return K;
            } catch (IOException e5) {
                throw a.this.l(e5);
            } catch (Throwable th) {
                a.this.m(false);
                throw th;
            }
        }

        public t c() {
            return a.this;
        }

        public void close() {
            try {
                this.f6753e.close();
                a.this.m(true);
            } catch (IOException e5) {
                throw a.this.l(e5);
            } catch (Throwable th) {
                a.this.m(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f6753e + ")";
        }
    }

    private static final class c extends Thread {
        c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1.t();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<s4.a> r0 = s4.a.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
                s4.a r1 = s4.a.i()     // Catch:{ all -> 0x0019 }
                if (r1 != 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                goto L_0x0000
            L_0x000b:
                s4.a r2 = s4.a.f6747j     // Catch:{ all -> 0x0019 }
                if (r1 != r2) goto L_0x0014
                r1 = 0
                s4.a.f6747j = r1     // Catch:{ all -> 0x0019 }
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                return
            L_0x0014:
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                r1.t()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x0019:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                throw r1     // Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: s4.a.c.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60);
        f6745h = millis;
        f6746i = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    @Nullable
    static a i() {
        Class<a> cls = a.class;
        a aVar = f6747j.f6749f;
        long nanoTime = System.nanoTime();
        if (aVar == null) {
            cls.wait(f6745h);
            if (f6747j.f6749f != null || System.nanoTime() - nanoTime < f6746i) {
                return null;
            }
            return f6747j;
        }
        long p5 = aVar.p(nanoTime);
        if (p5 > 0) {
            long j5 = p5 / 1000000;
            cls.wait(j5, (int) (p5 - (1000000 * j5)));
            return null;
        }
        f6747j.f6749f = aVar.f6749f;
        aVar.f6749f = null;
        return aVar;
    }

    private static synchronized boolean j(a aVar) {
        boolean z4;
        synchronized (a.class) {
            a aVar2 = f6747j;
            while (true) {
                if (aVar2 == null) {
                    z4 = true;
                    break;
                }
                a aVar3 = aVar2.f6749f;
                if (aVar3 == aVar) {
                    aVar2.f6749f = aVar.f6749f;
                    aVar.f6749f = null;
                    z4 = false;
                    break;
                }
                aVar2 = aVar3;
            }
        }
        return z4;
    }

    private long p(long j5) {
        return this.f6750g - j5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0050 A[EDGE_INSN: B:33:0x0050->B:22:0x0050 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void q(s4.a r5, long r6, boolean r8) {
        /*
            java.lang.Class<s4.a> r0 = s4.a.class
            monitor-enter(r0)
            s4.a r1 = f6747j     // Catch:{ all -> 0x0065 }
            if (r1 != 0) goto L_0x0016
            s4.a r1 = new s4.a     // Catch:{ all -> 0x0065 }
            r1.<init>()     // Catch:{ all -> 0x0065 }
            f6747j = r1     // Catch:{ all -> 0x0065 }
            s4.a$c r1 = new s4.a$c     // Catch:{ all -> 0x0065 }
            r1.<init>()     // Catch:{ all -> 0x0065 }
            r1.start()     // Catch:{ all -> 0x0065 }
        L_0x0016:
            long r1 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0065 }
            r3 = 0
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x002f
            if (r8 == 0) goto L_0x002f
            long r3 = r5.c()     // Catch:{ all -> 0x0065 }
            long r3 = r3 - r1
            long r6 = java.lang.Math.min(r6, r3)     // Catch:{ all -> 0x0065 }
        L_0x002b:
            long r6 = r6 + r1
            r5.f6750g = r6     // Catch:{ all -> 0x0065 }
            goto L_0x003a
        L_0x002f:
            if (r3 == 0) goto L_0x0032
            goto L_0x002b
        L_0x0032:
            if (r8 == 0) goto L_0x005f
            long r6 = r5.c()     // Catch:{ all -> 0x0065 }
            r5.f6750g = r6     // Catch:{ all -> 0x0065 }
        L_0x003a:
            long r6 = r5.p(r1)     // Catch:{ all -> 0x0065 }
            s4.a r8 = f6747j     // Catch:{ all -> 0x0065 }
        L_0x0040:
            s4.a r3 = r8.f6749f     // Catch:{ all -> 0x0065 }
            if (r3 == 0) goto L_0x0050
            long r3 = r3.p(r1)     // Catch:{ all -> 0x0065 }
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x004d
            goto L_0x0050
        L_0x004d:
            s4.a r8 = r8.f6749f     // Catch:{ all -> 0x0065 }
            goto L_0x0040
        L_0x0050:
            s4.a r6 = r8.f6749f     // Catch:{ all -> 0x0065 }
            r5.f6749f = r6     // Catch:{ all -> 0x0065 }
            r8.f6749f = r5     // Catch:{ all -> 0x0065 }
            s4.a r5 = f6747j     // Catch:{ all -> 0x0065 }
            if (r8 != r5) goto L_0x005d
            r0.notify()     // Catch:{ all -> 0x0065 }
        L_0x005d:
            monitor-exit(r0)
            return
        L_0x005f:
            java.lang.AssertionError r5 = new java.lang.AssertionError     // Catch:{ all -> 0x0065 }
            r5.<init>()     // Catch:{ all -> 0x0065 }
            throw r5     // Catch:{ all -> 0x0065 }
        L_0x0065:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: s4.a.q(s4.a, long, boolean):void");
    }

    public final void k() {
        if (!this.f6748e) {
            long h5 = h();
            boolean e5 = e();
            if (h5 != 0 || e5) {
                this.f6748e = true;
                q(this, h5, e5);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    /* access modifiers changed from: package-private */
    public final IOException l(IOException iOException) {
        return !n() ? iOException : o(iOException);
    }

    /* access modifiers changed from: package-private */
    public final void m(boolean z4) {
        if (n() && z4) {
            throw o((IOException) null);
        }
    }

    public final boolean n() {
        if (!this.f6748e) {
            return false;
        }
        this.f6748e = false;
        return j(this);
    }

    /* access modifiers changed from: protected */
    public IOException o(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final r r(r rVar) {
        return new C0109a(rVar);
    }

    public final s s(s sVar) {
        return new b(sVar);
    }

    /* access modifiers changed from: protected */
    public void t() {
    }
}
