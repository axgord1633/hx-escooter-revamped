package i4;

import com.yalantis.ucrop.BuildConfig;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import m4.c;
import m4.g;
import m4.j;
import p4.i;

final class w implements d {

    /* renamed from: e  reason: collision with root package name */
    final u f5212e;

    /* renamed from: f  reason: collision with root package name */
    final j f5213f;

    /* renamed from: g  reason: collision with root package name */
    final s4.a f5214g;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public o f5215h;

    /* renamed from: i  reason: collision with root package name */
    final x f5216i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f5217j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5218k;

    class a extends s4.a {
        a() {
        }

        /* access modifiers changed from: protected */
        public void t() {
            w.this.b();
        }
    }

    final class b extends j4.b {

        /* renamed from: f  reason: collision with root package name */
        private final e f5220f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ w f5221g;

        static {
            Class<w> cls = w.class;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0032 A[Catch:{ IOException -> 0x0050, all -> 0x0027, all -> 0x0090 }] */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x005c A[Catch:{ IOException -> 0x0050, all -> 0x0027, all -> 0x0090 }] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x007c A[Catch:{ IOException -> 0x0050, all -> 0x0027, all -> 0x0090 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void k() {
            /*
                r6 = this;
                i4.w r0 = r6.f5221g
                s4.a r0 = r0.f5214g
                r0.k()
                r0 = 0
                i4.w r1 = r6.f5221g     // Catch:{ IOException -> 0x0050, all -> 0x0027 }
                i4.z r0 = r1.f()     // Catch:{ IOException -> 0x0050, all -> 0x0027 }
                r1 = 1
                i4.e r2 = r6.f5220f     // Catch:{ IOException -> 0x0025, all -> 0x0023 }
                i4.w r3 = r6.f5221g     // Catch:{ IOException -> 0x0025, all -> 0x0023 }
                r2.a(r3, r0)     // Catch:{ IOException -> 0x0025, all -> 0x0023 }
            L_0x0016:
                i4.w r0 = r6.f5221g
                i4.u r0 = r0.f5212e
                i4.m r0 = r0.i()
                r0.d(r6)
                goto L_0x008f
            L_0x0023:
                r0 = move-exception
                goto L_0x002b
            L_0x0025:
                r0 = move-exception
                goto L_0x0054
            L_0x0027:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
            L_0x002b:
                i4.w r2 = r6.f5221g     // Catch:{ all -> 0x0090 }
                r2.b()     // Catch:{ all -> 0x0090 }
                if (r1 != 0) goto L_0x004f
                java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x0090 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
                r2.<init>()     // Catch:{ all -> 0x0090 }
                java.lang.String r3 = "canceled due to "
                r2.append(r3)     // Catch:{ all -> 0x0090 }
                r2.append(r0)     // Catch:{ all -> 0x0090 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0090 }
                r1.<init>(r2)     // Catch:{ all -> 0x0090 }
                i4.e r2 = r6.f5220f     // Catch:{ all -> 0x0090 }
                i4.w r3 = r6.f5221g     // Catch:{ all -> 0x0090 }
                r2.b(r3, r1)     // Catch:{ all -> 0x0090 }
            L_0x004f:
                throw r0     // Catch:{ all -> 0x0090 }
            L_0x0050:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
            L_0x0054:
                i4.w r2 = r6.f5221g     // Catch:{ all -> 0x0090 }
                java.io.IOException r0 = r2.j(r0)     // Catch:{ all -> 0x0090 }
                if (r1 == 0) goto L_0x007c
                p4.i r1 = p4.i.l()     // Catch:{ all -> 0x0090 }
                r2 = 4
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
                r3.<init>()     // Catch:{ all -> 0x0090 }
                java.lang.String r4 = "Callback failure for "
                r3.append(r4)     // Catch:{ all -> 0x0090 }
                i4.w r4 = r6.f5221g     // Catch:{ all -> 0x0090 }
                java.lang.String r4 = r4.k()     // Catch:{ all -> 0x0090 }
                r3.append(r4)     // Catch:{ all -> 0x0090 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0090 }
                r1.s(r2, r3, r0)     // Catch:{ all -> 0x0090 }
                goto L_0x0016
            L_0x007c:
                i4.w r1 = r6.f5221g     // Catch:{ all -> 0x0090 }
                i4.o r1 = r1.f5215h     // Catch:{ all -> 0x0090 }
                i4.w r2 = r6.f5221g     // Catch:{ all -> 0x0090 }
                r1.b(r2, r0)     // Catch:{ all -> 0x0090 }
                i4.e r1 = r6.f5220f     // Catch:{ all -> 0x0090 }
                i4.w r2 = r6.f5221g     // Catch:{ all -> 0x0090 }
                r1.b(r2, r0)     // Catch:{ all -> 0x0090 }
                goto L_0x0016
            L_0x008f:
                return
            L_0x0090:
                r0 = move-exception
                i4.w r1 = r6.f5221g
                i4.u r1 = r1.f5212e
                i4.m r1 = r1.i()
                r1.d(r6)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: i4.w.b.k():void");
        }

        /* access modifiers changed from: package-private */
        public void l(ExecutorService executorService) {
            try {
                executorService.execute(this);
            } catch (RejectedExecutionException e5) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(e5);
                this.f5221g.f5215h.b(this.f5221g, interruptedIOException);
                this.f5220f.b(this.f5221g, interruptedIOException);
                this.f5221g.f5212e.i().d(this);
            } catch (Throwable th) {
                this.f5221g.f5212e.i().d(this);
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public w m() {
            return this.f5221g;
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return this.f5221g.f5216i.h().l();
        }
    }

    private w(u uVar, x xVar, boolean z4) {
        this.f5212e = uVar;
        this.f5216i = xVar;
        this.f5217j = z4;
        this.f5213f = new j(uVar, z4);
        a aVar = new a();
        this.f5214g = aVar;
        aVar.g((long) uVar.b(), TimeUnit.MILLISECONDS);
    }

    private void c() {
        this.f5213f.k(i.l().o("response.body().close()"));
    }

    static w h(u uVar, x xVar, boolean z4) {
        w wVar = new w(uVar, xVar, z4);
        wVar.f5215h = uVar.k().a(wVar);
        return wVar;
    }

    public void b() {
        this.f5213f.b();
    }

    /* renamed from: d */
    public w clone() {
        return h(this.f5212e, this.f5216i, this.f5217j);
    }

    public z e() {
        synchronized (this) {
            if (!this.f5218k) {
                this.f5218k = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        c();
        this.f5214g.k();
        this.f5215h.c(this);
        try {
            this.f5212e.i().b(this);
            z f5 = f();
            if (f5 != null) {
                this.f5212e.i().e(this);
                return f5;
            }
            throw new IOException("Canceled");
        } catch (IOException e5) {
            IOException j5 = j(e5);
            this.f5215h.b(this, j5);
            throw j5;
        } catch (Throwable th) {
            this.f5212e.i().e(this);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public z f() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f5212e.o());
        arrayList.add(this.f5213f);
        arrayList.add(new m4.a(this.f5212e.h()));
        arrayList.add(new k4.a(this.f5212e.p()));
        arrayList.add(new l4.a(this.f5212e));
        if (!this.f5217j) {
            arrayList.addAll(this.f5212e.q());
        }
        arrayList.add(new m4.b(this.f5217j));
        z b5 = new g(arrayList, (l4.g) null, (c) null, (l4.c) null, 0, this.f5216i, this, this.f5215h, this.f5212e.d(), this.f5212e.y(), this.f5212e.C()).b(this.f5216i);
        if (!this.f5213f.e()) {
            return b5;
        }
        j4.c.e(b5);
        throw new IOException("Canceled");
    }

    public boolean g() {
        return this.f5213f.e();
    }

    /* access modifiers changed from: package-private */
    public String i() {
        return this.f5216i.h().z();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public IOException j(@Nullable IOException iOException) {
        if (!this.f5214g.n()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* access modifiers changed from: package-private */
    public String k() {
        StringBuilder sb = new StringBuilder();
        sb.append(g() ? "canceled " : BuildConfig.FLAVOR);
        sb.append(this.f5217j ? "web socket" : "call");
        sb.append(" to ");
        sb.append(i());
        return sb.toString();
    }
}
