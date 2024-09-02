package o4;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import o4.h;

public final class g implements Closeable {
    /* access modifiers changed from: private */
    public static final ExecutorService D = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), j4.c.E("OkHttp Http2Connection", true));
    final j A;
    final l B;
    final Set<Integer> C;

    /* renamed from: e  reason: collision with root package name */
    final boolean f6218e;

    /* renamed from: f  reason: collision with root package name */
    final j f6219f;

    /* renamed from: g  reason: collision with root package name */
    final Map<Integer, i> f6220g = new LinkedHashMap();

    /* renamed from: h  reason: collision with root package name */
    final String f6221h;

    /* renamed from: i  reason: collision with root package name */
    int f6222i;

    /* renamed from: j  reason: collision with root package name */
    int f6223j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f6224k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final ScheduledExecutorService f6225l;

    /* renamed from: m  reason: collision with root package name */
    private final ExecutorService f6226m;

    /* renamed from: n  reason: collision with root package name */
    final l f6227n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public long f6228o = 0;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public long f6229p = 0;

    /* renamed from: q  reason: collision with root package name */
    private long f6230q = 0;

    /* renamed from: r  reason: collision with root package name */
    private long f6231r = 0;

    /* renamed from: s  reason: collision with root package name */
    private long f6232s = 0;

    /* renamed from: t  reason: collision with root package name */
    private long f6233t = 0;

    /* renamed from: u  reason: collision with root package name */
    private long f6234u = 0;

    /* renamed from: v  reason: collision with root package name */
    long f6235v = 0;

    /* renamed from: w  reason: collision with root package name */
    long f6236w;

    /* renamed from: x  reason: collision with root package name */
    m f6237x = new m();

    /* renamed from: y  reason: collision with root package name */
    final m f6238y;

    /* renamed from: z  reason: collision with root package name */
    final Socket f6239z;

    class a extends j4.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f6240f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ b f6241g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, int i5, b bVar) {
            super(str, objArr);
            this.f6240f = i5;
            this.f6241g = bVar;
        }

        public void k() {
            try {
                g.this.Y(this.f6240f, this.f6241g);
            } catch (IOException unused) {
                g.this.v();
            }
        }
    }

    class b extends j4.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f6243f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ long f6244g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, int i5, long j5) {
            super(str, objArr);
            this.f6243f = i5;
            this.f6244g = j5;
        }

        public void k() {
            try {
                g.this.A.w(this.f6243f, this.f6244g);
            } catch (IOException unused) {
                g.this.v();
            }
        }
    }

    class c extends j4.b {
        c(String str, Object... objArr) {
            super(str, objArr);
        }

        public void k() {
            g.this.X(false, 2, 0);
        }
    }

    class d extends j4.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f6247f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ List f6248g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr, int i5, List list) {
            super(str, objArr);
            this.f6247f = i5;
            this.f6248g = list;
        }

        public void k() {
            if (g.this.f6227n.a(this.f6247f, this.f6248g)) {
                try {
                    g.this.A.p(this.f6247f, b.CANCEL);
                    synchronized (g.this) {
                        g.this.C.remove(Integer.valueOf(this.f6247f));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    class e extends j4.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f6250f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ List f6251g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ boolean f6252h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(String str, Object[] objArr, int i5, List list, boolean z4) {
            super(str, objArr);
            this.f6250f = i5;
            this.f6251g = list;
            this.f6252h = z4;
        }

        public void k() {
            boolean c5 = g.this.f6227n.c(this.f6250f, this.f6251g, this.f6252h);
            if (c5) {
                try {
                    g.this.A.p(this.f6250f, b.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (c5 || this.f6252h) {
                synchronized (g.this) {
                    g.this.C.remove(Integer.valueOf(this.f6250f));
                }
            }
        }
    }

    class f extends j4.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f6254f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ s4.c f6255g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ int f6256h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ boolean f6257i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(String str, Object[] objArr, int i5, s4.c cVar, int i6, boolean z4) {
            super(str, objArr);
            this.f6254f = i5;
            this.f6255g = cVar;
            this.f6256h = i6;
            this.f6257i = z4;
        }

        public void k() {
            try {
                boolean b5 = g.this.f6227n.b(this.f6254f, this.f6255g, this.f6256h, this.f6257i);
                if (b5) {
                    g.this.A.p(this.f6254f, b.CANCEL);
                }
                if (b5 || this.f6257i) {
                    synchronized (g.this) {
                        g.this.C.remove(Integer.valueOf(this.f6254f));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: o4.g$g  reason: collision with other inner class name */
    class C0097g extends j4.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f6259f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ b f6260g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0097g(String str, Object[] objArr, int i5, b bVar) {
            super(str, objArr);
            this.f6259f = i5;
            this.f6260g = bVar;
        }

        public void k() {
            g.this.f6227n.d(this.f6259f, this.f6260g);
            synchronized (g.this) {
                g.this.C.remove(Integer.valueOf(this.f6259f));
            }
        }
    }

    public static class h {

        /* renamed from: a  reason: collision with root package name */
        Socket f6262a;

        /* renamed from: b  reason: collision with root package name */
        String f6263b;

        /* renamed from: c  reason: collision with root package name */
        s4.e f6264c;

        /* renamed from: d  reason: collision with root package name */
        s4.d f6265d;

        /* renamed from: e  reason: collision with root package name */
        j f6266e = j.f6271a;

        /* renamed from: f  reason: collision with root package name */
        l f6267f = l.f6332a;

        /* renamed from: g  reason: collision with root package name */
        boolean f6268g;

        /* renamed from: h  reason: collision with root package name */
        int f6269h;

        public h(boolean z4) {
            this.f6268g = z4;
        }

        public g a() {
            return new g(this);
        }

        public h b(j jVar) {
            this.f6266e = jVar;
            return this;
        }

        public h c(int i5) {
            this.f6269h = i5;
            return this;
        }

        public h d(Socket socket, String str, s4.e eVar, s4.d dVar) {
            this.f6262a = socket;
            this.f6263b = str;
            this.f6264c = eVar;
            this.f6265d = dVar;
            return this;
        }
    }

    final class i extends j4.b {
        i() {
            super("OkHttp %s ping", g.this.f6221h);
        }

        public void k() {
            boolean z4;
            synchronized (g.this) {
                if (g.this.f6229p < g.this.f6228o) {
                    z4 = true;
                } else {
                    g.g(g.this);
                    z4 = false;
                }
            }
            g gVar = g.this;
            if (z4) {
                gVar.v();
            } else {
                gVar.X(false, 1, 0);
            }
        }
    }

    public static abstract class j {

        /* renamed from: a  reason: collision with root package name */
        public static final j f6271a = new a();

        class a extends j {
            a() {
            }

            public void b(i iVar) {
                iVar.f(b.REFUSED_STREAM);
            }
        }

        public void a(g gVar) {
        }

        public abstract void b(i iVar);
    }

    final class k extends j4.b {

        /* renamed from: f  reason: collision with root package name */
        final boolean f6272f;

        /* renamed from: g  reason: collision with root package name */
        final int f6273g;

        /* renamed from: h  reason: collision with root package name */
        final int f6274h;

        k(boolean z4, int i5, int i6) {
            super("OkHttp %s ping %08x%08x", g.this.f6221h, Integer.valueOf(i5), Integer.valueOf(i6));
            this.f6272f = z4;
            this.f6273g = i5;
            this.f6274h = i6;
        }

        public void k() {
            g.this.X(this.f6272f, this.f6273g, this.f6274h);
        }
    }

    class l extends j4.b implements h.b {

        /* renamed from: f  reason: collision with root package name */
        final h f6276f;

        class a extends j4.b {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ i f6278f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(String str, Object[] objArr, i iVar) {
                super(str, objArr);
                this.f6278f = iVar;
            }

            public void k() {
                try {
                    g.this.f6219f.b(this.f6278f);
                } catch (IOException e5) {
                    p4.i l5 = p4.i.l();
                    l5.s(4, "Http2Connection.Listener failure for " + g.this.f6221h, e5);
                    try {
                        this.f6278f.f(b.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        class b extends j4.b {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ boolean f6280f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ m f6281g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(String str, Object[] objArr, boolean z4, m mVar) {
                super(str, objArr);
                this.f6280f = z4;
                this.f6281g = mVar;
            }

            public void k() {
                l.this.l(this.f6280f, this.f6281g);
            }
        }

        class c extends j4.b {
            c(String str, Object... objArr) {
                super(str, objArr);
            }

            public void k() {
                g gVar = g.this;
                gVar.f6219f.a(gVar);
            }
        }

        l(h hVar) {
            super("OkHttp %s", g.this.f6221h);
            this.f6276f = hVar;
        }

        public void a() {
        }

        public void b(boolean z4, m mVar) {
            try {
                g.this.f6225l.execute(new b("OkHttp %s ACK Settings", new Object[]{g.this.f6221h}, z4, mVar));
            } catch (RejectedExecutionException unused) {
            }
        }

        public void c(boolean z4, int i5, int i6) {
            if (z4) {
                synchronized (g.this) {
                    if (i5 == 1) {
                        try {
                            g.e(g.this);
                        } catch (Throwable th) {
                            throw th;
                        }
                    } else if (i5 == 2) {
                        g.n(g.this);
                    } else if (i5 == 3) {
                        g.p(g.this);
                        g.this.notifyAll();
                    }
                }
                return;
            }
            try {
                g.this.f6225l.execute(new k(true, i5, i6));
            } catch (RejectedExecutionException unused) {
            }
        }

        public void d(int i5, int i6, int i7, boolean z4) {
        }

        public void e(boolean z4, int i5, s4.e eVar, int i6) {
            if (g.this.P(i5)) {
                g.this.E(i5, eVar, i6, z4);
                return;
            }
            i w4 = g.this.w(i5);
            if (w4 == null) {
                g.this.Z(i5, b.PROTOCOL_ERROR);
                long j5 = (long) i6;
                g.this.V(j5);
                eVar.skip(j5);
                return;
            }
            w4.o(eVar, i6);
            if (z4) {
                w4.p();
            }
        }

        public void f(int i5, b bVar) {
            if (g.this.P(i5)) {
                g.this.O(i5, bVar);
                return;
            }
            i Q = g.this.Q(i5);
            if (Q != null) {
                Q.r(bVar);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0072, code lost:
            r0.q(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0075, code lost:
            if (r10 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0077, code lost:
            r0.p();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void g(boolean r10, int r11, int r12, java.util.List<o4.c> r13) {
            /*
                r9 = this;
                o4.g r12 = o4.g.this
                boolean r12 = r12.P(r11)
                if (r12 == 0) goto L_0x000e
                o4.g r12 = o4.g.this
                r12.M(r11, r13, r10)
                return
            L_0x000e:
                o4.g r12 = o4.g.this
                monitor-enter(r12)
                o4.g r0 = o4.g.this     // Catch:{ all -> 0x007b }
                o4.i r0 = r0.w(r11)     // Catch:{ all -> 0x007b }
                if (r0 != 0) goto L_0x0071
                o4.g r0 = o4.g.this     // Catch:{ all -> 0x007b }
                boolean r0 = r0.f6224k     // Catch:{ all -> 0x007b }
                if (r0 == 0) goto L_0x0023
                monitor-exit(r12)     // Catch:{ all -> 0x007b }
                return
            L_0x0023:
                o4.g r0 = o4.g.this     // Catch:{ all -> 0x007b }
                int r1 = r0.f6222i     // Catch:{ all -> 0x007b }
                if (r11 > r1) goto L_0x002b
                monitor-exit(r12)     // Catch:{ all -> 0x007b }
                return
            L_0x002b:
                int r1 = r11 % 2
                int r0 = r0.f6223j     // Catch:{ all -> 0x007b }
                r2 = 2
                int r0 = r0 % r2
                if (r1 != r0) goto L_0x0035
                monitor-exit(r12)     // Catch:{ all -> 0x007b }
                return
            L_0x0035:
                i4.q r8 = j4.c.F(r13)     // Catch:{ all -> 0x007b }
                o4.i r13 = new o4.i     // Catch:{ all -> 0x007b }
                o4.g r5 = o4.g.this     // Catch:{ all -> 0x007b }
                r6 = 0
                r3 = r13
                r4 = r11
                r7 = r10
                r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x007b }
                o4.g r10 = o4.g.this     // Catch:{ all -> 0x007b }
                r10.f6222i = r11     // Catch:{ all -> 0x007b }
                java.util.Map<java.lang.Integer, o4.i> r10 = r10.f6220g     // Catch:{ all -> 0x007b }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x007b }
                r10.put(r0, r13)     // Catch:{ all -> 0x007b }
                java.util.concurrent.ExecutorService r10 = o4.g.D     // Catch:{ all -> 0x007b }
                o4.g$l$a r0 = new o4.g$l$a     // Catch:{ all -> 0x007b }
                java.lang.String r1 = "OkHttp %s stream %d"
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x007b }
                r3 = 0
                o4.g r4 = o4.g.this     // Catch:{ all -> 0x007b }
                java.lang.String r4 = r4.f6221h     // Catch:{ all -> 0x007b }
                r2[r3] = r4     // Catch:{ all -> 0x007b }
                r3 = 1
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x007b }
                r2[r3] = r11     // Catch:{ all -> 0x007b }
                r0.<init>(r1, r2, r13)     // Catch:{ all -> 0x007b }
                r10.execute(r0)     // Catch:{ all -> 0x007b }
                monitor-exit(r12)     // Catch:{ all -> 0x007b }
                return
            L_0x0071:
                monitor-exit(r12)     // Catch:{ all -> 0x007b }
                r0.q(r13)
                if (r10 == 0) goto L_0x007a
                r0.p()
            L_0x007a:
                return
            L_0x007b:
                r10 = move-exception
                monitor-exit(r12)     // Catch:{ all -> 0x007b }
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: o4.g.l.g(boolean, int, int, java.util.List):void");
        }

        public void h(int i5, long j5) {
            g gVar = g.this;
            if (i5 == 0) {
                synchronized (gVar) {
                    g gVar2 = g.this;
                    gVar2.f6236w += j5;
                    gVar2.notifyAll();
                }
                return;
            }
            i w4 = gVar.w(i5);
            if (w4 != null) {
                synchronized (w4) {
                    w4.c(j5);
                }
            }
        }

        public void i(int i5, int i6, List<c> list) {
            g.this.N(i6, list);
        }

        public void j(int i5, b bVar, s4.f fVar) {
            i[] iVarArr;
            fVar.w();
            synchronized (g.this) {
                iVarArr = (i[]) g.this.f6220g.values().toArray(new i[g.this.f6220g.size()]);
                boolean unused = g.this.f6224k = true;
            }
            for (i iVar : iVarArr) {
                if (iVar.i() > i5 && iVar.l()) {
                    iVar.r(b.REFUSED_STREAM);
                    g.this.Q(iVar.i());
                }
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r0 = o4.b.PROTOCOL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r4.f6277g.q(r0, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x002c, code lost:
            r2 = th;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x001f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void k() {
            /*
                r4 = this;
                o4.b r0 = o4.b.INTERNAL_ERROR
                o4.h r1 = r4.f6276f     // Catch:{ IOException -> 0x001e, all -> 0x001b }
                r1.e(r4)     // Catch:{ IOException -> 0x001e, all -> 0x001b }
            L_0x0007:
                o4.h r1 = r4.f6276f     // Catch:{ IOException -> 0x001e, all -> 0x001b }
                r2 = 0
                boolean r1 = r1.d(r2, r4)     // Catch:{ IOException -> 0x001e, all -> 0x001b }
                if (r1 == 0) goto L_0x0011
                goto L_0x0007
            L_0x0011:
                o4.b r1 = o4.b.NO_ERROR     // Catch:{ IOException -> 0x001e, all -> 0x001b }
                o4.b r0 = o4.b.CANCEL     // Catch:{ IOException -> 0x001f }
                o4.g r2 = o4.g.this     // Catch:{ IOException -> 0x0026 }
                r2.q(r1, r0)     // Catch:{ IOException -> 0x0026 }
                goto L_0x0026
            L_0x001b:
                r2 = move-exception
                r1 = r0
                goto L_0x002d
            L_0x001e:
                r1 = r0
            L_0x001f:
                o4.b r0 = o4.b.PROTOCOL_ERROR     // Catch:{ all -> 0x002c }
                o4.g r1 = o4.g.this     // Catch:{ IOException -> 0x0026 }
                r1.q(r0, r0)     // Catch:{ IOException -> 0x0026 }
            L_0x0026:
                o4.h r0 = r4.f6276f
                j4.c.e(r0)
                return
            L_0x002c:
                r2 = move-exception
            L_0x002d:
                o4.g r3 = o4.g.this     // Catch:{ IOException -> 0x0032 }
                r3.q(r1, r0)     // Catch:{ IOException -> 0x0032 }
            L_0x0032:
                o4.h r0 = r4.f6276f
                j4.c.e(r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: o4.g.l.k():void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:2|3|7|17|18|19|20|21) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0061 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void l(boolean r6, o4.m r7) {
            /*
                r5 = this;
                o4.g r0 = o4.g.this
                o4.j r0 = r0.A
                monitor-enter(r0)
                o4.g r1 = o4.g.this     // Catch:{ all -> 0x0096 }
                monitor-enter(r1)     // Catch:{ all -> 0x0096 }
                o4.g r2 = o4.g.this     // Catch:{ all -> 0x0093 }
                o4.m r2 = r2.f6238y     // Catch:{ all -> 0x0093 }
                int r2 = r2.d()     // Catch:{ all -> 0x0093 }
                if (r6 == 0) goto L_0x0019
                o4.g r6 = o4.g.this     // Catch:{ all -> 0x0093 }
                o4.m r6 = r6.f6238y     // Catch:{ all -> 0x0093 }
                r6.a()     // Catch:{ all -> 0x0093 }
            L_0x0019:
                o4.g r6 = o4.g.this     // Catch:{ all -> 0x0093 }
                o4.m r6 = r6.f6238y     // Catch:{ all -> 0x0093 }
                r6.h(r7)     // Catch:{ all -> 0x0093 }
                o4.g r6 = o4.g.this     // Catch:{ all -> 0x0093 }
                o4.m r6 = r6.f6238y     // Catch:{ all -> 0x0093 }
                int r6 = r6.d()     // Catch:{ all -> 0x0093 }
                r7 = -1
                r3 = 0
                if (r6 == r7) goto L_0x0054
                if (r6 == r2) goto L_0x0054
                int r6 = r6 - r2
                long r6 = (long) r6     // Catch:{ all -> 0x0093 }
                o4.g r2 = o4.g.this     // Catch:{ all -> 0x0093 }
                java.util.Map<java.lang.Integer, o4.i> r2 = r2.f6220g     // Catch:{ all -> 0x0093 }
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0093 }
                if (r2 != 0) goto L_0x0056
                o4.g r2 = o4.g.this     // Catch:{ all -> 0x0093 }
                java.util.Map<java.lang.Integer, o4.i> r2 = r2.f6220g     // Catch:{ all -> 0x0093 }
                java.util.Collection r2 = r2.values()     // Catch:{ all -> 0x0093 }
                o4.g r3 = o4.g.this     // Catch:{ all -> 0x0093 }
                java.util.Map<java.lang.Integer, o4.i> r3 = r3.f6220g     // Catch:{ all -> 0x0093 }
                int r3 = r3.size()     // Catch:{ all -> 0x0093 }
                o4.i[] r3 = new o4.i[r3]     // Catch:{ all -> 0x0093 }
                java.lang.Object[] r2 = r2.toArray(r3)     // Catch:{ all -> 0x0093 }
                o4.i[] r2 = (o4.i[]) r2     // Catch:{ all -> 0x0093 }
                r3 = r2
                goto L_0x0056
            L_0x0054:
                r6 = 0
            L_0x0056:
                monitor-exit(r1)     // Catch:{ all -> 0x0093 }
                o4.g r1 = o4.g.this     // Catch:{ IOException -> 0x0061 }
                o4.j r2 = r1.A     // Catch:{ IOException -> 0x0061 }
                o4.m r1 = r1.f6238y     // Catch:{ IOException -> 0x0061 }
                r2.b(r1)     // Catch:{ IOException -> 0x0061 }
                goto L_0x0066
            L_0x0061:
                o4.g r1 = o4.g.this     // Catch:{ all -> 0x0096 }
                r1.v()     // Catch:{ all -> 0x0096 }
            L_0x0066:
                monitor-exit(r0)     // Catch:{ all -> 0x0096 }
                r0 = 0
                if (r3 == 0) goto L_0x007b
                int r1 = r3.length
                r2 = r0
            L_0x006c:
                if (r2 >= r1) goto L_0x007b
                r4 = r3[r2]
                monitor-enter(r4)
                r4.c(r6)     // Catch:{ all -> 0x0078 }
                monitor-exit(r4)     // Catch:{ all -> 0x0078 }
                int r2 = r2 + 1
                goto L_0x006c
            L_0x0078:
                r6 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0078 }
                throw r6
            L_0x007b:
                java.util.concurrent.ExecutorService r6 = o4.g.D
                o4.g$l$c r7 = new o4.g$l$c
                java.lang.String r1 = "OkHttp %s settings"
                r2 = 1
                java.lang.Object[] r2 = new java.lang.Object[r2]
                o4.g r3 = o4.g.this
                java.lang.String r3 = r3.f6221h
                r2[r0] = r3
                r7.<init>(r1, r2)
                r6.execute(r7)
                return
            L_0x0093:
                r6 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0093 }
                throw r6     // Catch:{ all -> 0x0096 }
            L_0x0096:
                r6 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0096 }
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: o4.g.l.l(boolean, o4.m):void");
        }
    }

    static {
        Class<g> cls = g.class;
    }

    g(h hVar) {
        h hVar2 = hVar;
        m mVar = new m();
        this.f6238y = mVar;
        this.C = new LinkedHashSet();
        this.f6227n = hVar2.f6267f;
        boolean z4 = hVar2.f6268g;
        this.f6218e = z4;
        this.f6219f = hVar2.f6266e;
        int i5 = z4 ? 1 : 2;
        this.f6223j = i5;
        if (z4) {
            this.f6223j = i5 + 2;
        }
        if (z4) {
            this.f6237x.i(7, 16777216);
        }
        String str = hVar2.f6263b;
        this.f6221h = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, j4.c.E(j4.c.p("OkHttp %s Writer", str), false));
        this.f6225l = scheduledThreadPoolExecutor;
        if (hVar2.f6269h != 0) {
            i iVar = new i();
            int i6 = hVar2.f6269h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(iVar, (long) i6, (long) i6, TimeUnit.MILLISECONDS);
        }
        this.f6226m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), j4.c.E(j4.c.p("OkHttp %s Push Observer", str), true));
        mVar.i(7, 65535);
        mVar.i(5, 16384);
        this.f6236w = (long) mVar.d();
        this.f6239z = hVar2.f6262a;
        this.A = new j(hVar2.f6265d, z4);
        this.B = new l(new h(hVar2.f6264c, z4));
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private o4.i C(int r11, java.util.List<o4.c> r12, boolean r13) {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            o4.j r7 = r10.A
            monitor-enter(r7)
            monitor-enter(r10)     // Catch:{ all -> 0x0076 }
            int r0 = r10.f6223j     // Catch:{ all -> 0x0073 }
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L_0x0013
            o4.b r0 = o4.b.REFUSED_STREAM     // Catch:{ all -> 0x0073 }
            r10.S(r0)     // Catch:{ all -> 0x0073 }
        L_0x0013:
            boolean r0 = r10.f6224k     // Catch:{ all -> 0x0073 }
            if (r0 != 0) goto L_0x006d
            int r8 = r10.f6223j     // Catch:{ all -> 0x0073 }
            int r0 = r8 + 2
            r10.f6223j = r0     // Catch:{ all -> 0x0073 }
            o4.i r9 = new o4.i     // Catch:{ all -> 0x0073 }
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0073 }
            if (r13 == 0) goto L_0x003a
            long r0 = r10.f6236w     // Catch:{ all -> 0x0073 }
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x003a
            long r0 = r9.f6296b     // Catch:{ all -> 0x0073 }
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r13 = 0
            goto L_0x003b
        L_0x003a:
            r13 = 1
        L_0x003b:
            boolean r0 = r9.m()     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x004a
            java.util.Map<java.lang.Integer, o4.i> r0 = r10.f6220g     // Catch:{ all -> 0x0073 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0073 }
            r0.put(r1, r9)     // Catch:{ all -> 0x0073 }
        L_0x004a:
            monitor-exit(r10)     // Catch:{ all -> 0x0073 }
            if (r11 != 0) goto L_0x0053
            o4.j r0 = r10.A     // Catch:{ all -> 0x0076 }
            r0.v(r6, r8, r11, r12)     // Catch:{ all -> 0x0076 }
            goto L_0x005c
        L_0x0053:
            boolean r0 = r10.f6218e     // Catch:{ all -> 0x0076 }
            if (r0 != 0) goto L_0x0065
            o4.j r0 = r10.A     // Catch:{ all -> 0x0076 }
            r0.n(r11, r8, r12)     // Catch:{ all -> 0x0076 }
        L_0x005c:
            monitor-exit(r7)     // Catch:{ all -> 0x0076 }
            if (r13 == 0) goto L_0x0064
            o4.j r11 = r10.A
            r11.flush()
        L_0x0064:
            return r9
        L_0x0065:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0076 }
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch:{ all -> 0x0076 }
            throw r11     // Catch:{ all -> 0x0076 }
        L_0x006d:
            o4.a r11 = new o4.a     // Catch:{ all -> 0x0073 }
            r11.<init>()     // Catch:{ all -> 0x0073 }
            throw r11     // Catch:{ all -> 0x0073 }
        L_0x0073:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0073 }
            throw r11     // Catch:{ all -> 0x0076 }
        L_0x0076:
            r11 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0076 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.g.C(int, java.util.List, boolean):o4.i");
    }

    private synchronized void F(j4.b bVar) {
        if (!this.f6224k) {
            this.f6226m.execute(bVar);
        }
    }

    static /* synthetic */ long e(g gVar) {
        long j5 = gVar.f6229p;
        gVar.f6229p = 1 + j5;
        return j5;
    }

    static /* synthetic */ long g(g gVar) {
        long j5 = gVar.f6228o;
        gVar.f6228o = 1 + j5;
        return j5;
    }

    static /* synthetic */ long n(g gVar) {
        long j5 = gVar.f6231r;
        gVar.f6231r = 1 + j5;
        return j5;
    }

    static /* synthetic */ long p(g gVar) {
        long j5 = gVar.f6233t;
        gVar.f6233t = 1 + j5;
        return j5;
    }

    /* access modifiers changed from: private */
    public void v() {
        try {
            b bVar = b.PROTOCOL_ERROR;
            q(bVar, bVar);
        } catch (IOException unused) {
        }
    }

    public synchronized int B() {
        return this.f6238y.e(Integer.MAX_VALUE);
    }

    public i D(List<c> list, boolean z4) {
        return C(0, list, z4);
    }

    /* access modifiers changed from: package-private */
    public void E(int i5, s4.e eVar, int i6, boolean z4) {
        s4.c cVar = new s4.c();
        long j5 = (long) i6;
        eVar.H(j5);
        eVar.K(cVar, j5);
        if (cVar.size() == j5) {
            F(new f("OkHttp %s Push Data[%s]", new Object[]{this.f6221h, Integer.valueOf(i5)}, i5, cVar, i6, z4));
            return;
        }
        throw new IOException(cVar.size() + " != " + i6);
    }

    /* access modifiers changed from: package-private */
    public void M(int i5, List<c> list, boolean z4) {
        try {
            F(new e("OkHttp %s Push Headers[%s]", new Object[]{this.f6221h, Integer.valueOf(i5)}, i5, list, z4));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void N(int i5, List<c> list) {
        synchronized (this) {
            if (this.C.contains(Integer.valueOf(i5))) {
                Z(i5, b.PROTOCOL_ERROR);
                return;
            }
            this.C.add(Integer.valueOf(i5));
            try {
                F(new d("OkHttp %s Push Request[%s]", new Object[]{this.f6221h, Integer.valueOf(i5)}, i5, list));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void O(int i5, b bVar) {
        F(new C0097g("OkHttp %s Push Reset[%s]", new Object[]{this.f6221h, Integer.valueOf(i5)}, i5, bVar));
    }

    /* access modifiers changed from: package-private */
    public boolean P(int i5) {
        return i5 != 0 && (i5 & 1) == 0;
    }

    /* access modifiers changed from: package-private */
    public synchronized i Q(int i5) {
        i remove;
        remove = this.f6220g.remove(Integer.valueOf(i5));
        notifyAll();
        return remove;
    }

    /* access modifiers changed from: package-private */
    public void R() {
        synchronized (this) {
            long j5 = this.f6231r;
            long j6 = this.f6230q;
            if (j5 >= j6) {
                this.f6230q = j6 + 1;
                this.f6234u = System.nanoTime() + 1000000000;
                try {
                    this.f6225l.execute(new c("OkHttp %s ping", this.f6221h));
                } catch (RejectedExecutionException unused) {
                }
            }
        }
    }

    public void S(b bVar) {
        synchronized (this.A) {
            synchronized (this) {
                if (!this.f6224k) {
                    this.f6224k = true;
                    int i5 = this.f6222i;
                    this.A.h(i5, bVar, j4.c.f5475a);
                }
            }
        }
    }

    public void T() {
        U(true);
    }

    /* access modifiers changed from: package-private */
    public void U(boolean z4) {
        if (z4) {
            this.A.d();
            this.A.q(this.f6237x);
            int d5 = this.f6237x.d();
            if (d5 != 65535) {
                this.A.w(0, (long) (d5 - 65535));
            }
        }
        new Thread(this.B).start();
    }

    /* access modifiers changed from: package-private */
    public synchronized void V(long j5) {
        long j6 = this.f6235v + j5;
        this.f6235v = j6;
        if (j6 >= ((long) (this.f6237x.d() / 2))) {
            a0(0, this.f6235v);
            this.f6235v = 0;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r4), r8.A.l());
        r6 = (long) r2;
        r8.f6236w -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0064, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0058 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void W(int r9, boolean r10, s4.c r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto L_0x000d
            o4.j r12 = r8.A
            r12.e(r10, r9, r11, r3)
            return
        L_0x000d:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0067
            monitor-enter(r8)
        L_0x0012:
            long r4 = r8.f6236w     // Catch:{ InterruptedException -> 0x0058 }
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x0030
            java.util.Map<java.lang.Integer, o4.i> r2 = r8.f6220g     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x0058 }
            boolean r2 = r2.containsKey(r4)     // Catch:{ InterruptedException -> 0x0058 }
            if (r2 == 0) goto L_0x0028
            r8.wait()     // Catch:{ InterruptedException -> 0x0058 }
            goto L_0x0012
        L_0x0028:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x0058 }
            throw r9     // Catch:{ InterruptedException -> 0x0058 }
        L_0x0030:
            long r4 = java.lang.Math.min(r12, r4)     // Catch:{ all -> 0x0056 }
            int r2 = (int) r4     // Catch:{ all -> 0x0056 }
            o4.j r4 = r8.A     // Catch:{ all -> 0x0056 }
            int r4 = r4.l()     // Catch:{ all -> 0x0056 }
            int r2 = java.lang.Math.min(r2, r4)     // Catch:{ all -> 0x0056 }
            long r4 = r8.f6236w     // Catch:{ all -> 0x0056 }
            long r6 = (long) r2     // Catch:{ all -> 0x0056 }
            long r4 = r4 - r6
            r8.f6236w = r4     // Catch:{ all -> 0x0056 }
            monitor-exit(r8)     // Catch:{ all -> 0x0056 }
            long r12 = r12 - r6
            o4.j r4 = r8.A
            if (r10 == 0) goto L_0x0051
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L_0x0051
            r5 = 1
            goto L_0x0052
        L_0x0051:
            r5 = r3
        L_0x0052:
            r4.e(r5, r9, r11, r2)
            goto L_0x000d
        L_0x0056:
            r9 = move-exception
            goto L_0x0065
        L_0x0058:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0056 }
            r9.interrupt()     // Catch:{ all -> 0x0056 }
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0056 }
            r9.<init>()     // Catch:{ all -> 0x0056 }
            throw r9     // Catch:{ all -> 0x0056 }
        L_0x0065:
            monitor-exit(r8)     // Catch:{ all -> 0x0056 }
            throw r9
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.g.W(int, boolean, s4.c, long):void");
    }

    /* access modifiers changed from: package-private */
    public void X(boolean z4, int i5, int i6) {
        try {
            this.A.m(z4, i5, i6);
        } catch (IOException unused) {
            v();
        }
    }

    /* access modifiers changed from: package-private */
    public void Y(int i5, b bVar) {
        this.A.p(i5, bVar);
    }

    /* access modifiers changed from: package-private */
    public void Z(int i5, b bVar) {
        try {
            this.f6225l.execute(new a("OkHttp %s stream %d", new Object[]{this.f6221h, Integer.valueOf(i5)}, i5, bVar));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void a0(int i5, long j5) {
        try {
            this.f6225l.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.f6221h, Integer.valueOf(i5)}, i5, j5));
        } catch (RejectedExecutionException unused) {
        }
    }

    public void close() {
        q(b.NO_ERROR, b.CANCEL);
    }

    public void flush() {
        this.A.flush();
    }

    /* access modifiers changed from: package-private */
    public void q(b bVar, b bVar2) {
        i[] iVarArr = null;
        try {
            S(bVar);
            e = null;
        } catch (IOException e5) {
            e = e5;
        }
        synchronized (this) {
            if (!this.f6220g.isEmpty()) {
                iVarArr = (i[]) this.f6220g.values().toArray(new i[this.f6220g.size()]);
                this.f6220g.clear();
            }
        }
        if (iVarArr != null) {
            for (i f5 : iVarArr) {
                try {
                    f5.f(bVar2);
                } catch (IOException e6) {
                    if (e != null) {
                        e = e6;
                    }
                }
            }
        }
        try {
            this.A.close();
        } catch (IOException e7) {
            if (e == null) {
                e = e7;
            }
        }
        try {
            this.f6239z.close();
        } catch (IOException e8) {
            e = e8;
        }
        this.f6225l.shutdown();
        this.f6226m.shutdown();
        if (e != null) {
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized i w(int i5) {
        return this.f6220g.get(Integer.valueOf(i5));
    }

    public synchronized boolean z(long j5) {
        if (this.f6224k) {
            return false;
        }
        return this.f6231r >= this.f6230q || j5 < this.f6234u;
    }
}
