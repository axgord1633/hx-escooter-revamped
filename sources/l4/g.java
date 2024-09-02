package l4;

import i4.b0;
import i4.d;
import i4.i;
import i4.o;
import i4.s;
import i4.u;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import l4.f;
import m4.c;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final i4.a f5802a;

    /* renamed from: b  reason: collision with root package name */
    private f.a f5803b;

    /* renamed from: c  reason: collision with root package name */
    private b0 f5804c;

    /* renamed from: d  reason: collision with root package name */
    private final i f5805d;

    /* renamed from: e  reason: collision with root package name */
    public final d f5806e;

    /* renamed from: f  reason: collision with root package name */
    public final o f5807f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f5808g;

    /* renamed from: h  reason: collision with root package name */
    private final f f5809h;

    /* renamed from: i  reason: collision with root package name */
    private int f5810i;

    /* renamed from: j  reason: collision with root package name */
    private c f5811j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5812k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f5813l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f5814m;

    /* renamed from: n  reason: collision with root package name */
    private c f5815n;

    public static final class a extends WeakReference<g> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f5816a;

        a(g gVar, Object obj) {
            super(gVar);
            this.f5816a = obj;
        }
    }

    public g(i iVar, i4.a aVar, d dVar, o oVar, Object obj) {
        this.f5805d = iVar;
        this.f5802a = aVar;
        this.f5806e = dVar;
        this.f5807f = oVar;
        this.f5809h = new f(aVar, p(), dVar, oVar);
        this.f5808g = obj;
    }

    private Socket e(boolean z4, boolean z5, boolean z6) {
        Socket socket;
        if (z6) {
            this.f5815n = null;
        }
        if (z5) {
            this.f5813l = true;
        }
        c cVar = this.f5811j;
        if (cVar == null) {
            return null;
        }
        if (z4) {
            cVar.f5784k = true;
        }
        if (this.f5815n != null) {
            return null;
        }
        if (!this.f5813l && !cVar.f5784k) {
            return null;
        }
        l(cVar);
        if (this.f5811j.f5787n.isEmpty()) {
            this.f5811j.f5788o = System.nanoTime();
            if (j4.a.f5473a.e(this.f5805d, this.f5811j)) {
                socket = this.f5811j.q();
                this.f5811j = null;
                return socket;
            }
        }
        socket = null;
        this.f5811j = null;
        return socket;
    }

    private c f(int i5, int i6, int i7, int i8, boolean z4) {
        c cVar;
        Socket n5;
        c cVar2;
        Socket socket;
        boolean z5;
        b0 b0Var;
        boolean z6;
        f.a aVar;
        synchronized (this.f5805d) {
            if (this.f5813l) {
                throw new IllegalStateException("released");
            } else if (this.f5815n != null) {
                throw new IllegalStateException("codec != null");
            } else if (!this.f5814m) {
                cVar = this.f5811j;
                n5 = n();
                cVar2 = this.f5811j;
                socket = null;
                if (cVar2 != null) {
                    cVar = null;
                } else {
                    cVar2 = null;
                }
                if (!this.f5812k) {
                    cVar = null;
                }
                if (cVar2 == null) {
                    j4.a.f5473a.h(this.f5805d, this.f5802a, this, (b0) null);
                    c cVar3 = this.f5811j;
                    if (cVar3 != null) {
                        z5 = true;
                        cVar2 = cVar3;
                        b0Var = null;
                    } else {
                        b0Var = this.f5804c;
                    }
                } else {
                    b0Var = null;
                }
                z5 = false;
            } else {
                throw new IOException("Canceled");
            }
        }
        j4.c.f(n5);
        if (cVar != null) {
            this.f5807f.h(this.f5806e, cVar);
        }
        if (z5) {
            this.f5807f.g(this.f5806e, cVar2);
        }
        if (cVar2 != null) {
            this.f5804c = this.f5811j.p();
            return cVar2;
        }
        if (b0Var != null || ((aVar = this.f5803b) != null && aVar.b())) {
            z6 = false;
        } else {
            this.f5803b = this.f5809h.e();
            z6 = true;
        }
        synchronized (this.f5805d) {
            if (!this.f5814m) {
                if (z6) {
                    List<b0> a5 = this.f5803b.a();
                    int size = a5.size();
                    int i9 = 0;
                    while (true) {
                        if (i9 >= size) {
                            break;
                        }
                        b0 b0Var2 = a5.get(i9);
                        j4.a.f5473a.h(this.f5805d, this.f5802a, this, b0Var2);
                        c cVar4 = this.f5811j;
                        if (cVar4 != null) {
                            this.f5804c = b0Var2;
                            z5 = true;
                            cVar2 = cVar4;
                            break;
                        }
                        i9++;
                    }
                }
                if (!z5) {
                    if (b0Var == null) {
                        b0Var = this.f5803b.c();
                    }
                    this.f5804c = b0Var;
                    this.f5810i = 0;
                    cVar2 = new c(this.f5805d, b0Var);
                    a(cVar2, false);
                }
            } else {
                throw new IOException("Canceled");
            }
        }
        if (z5) {
            this.f5807f.g(this.f5806e, cVar2);
            return cVar2;
        }
        cVar2.d(i5, i6, i7, i8, z4, this.f5806e, this.f5807f);
        p().a(cVar2.p());
        synchronized (this.f5805d) {
            this.f5812k = true;
            j4.a.f5473a.i(this.f5805d, cVar2);
            if (cVar2.n()) {
                socket = j4.a.f5473a.f(this.f5805d, this.f5802a, this);
                cVar2 = this.f5811j;
            }
        }
        j4.c.f(socket);
        this.f5807f.g(this.f5806e, cVar2);
        return cVar2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        if (r0.m(r9) != false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private l4.c g(int r4, int r5, int r6, int r7, boolean r8, boolean r9) {
        /*
            r3 = this;
        L_0x0000:
            l4.c r0 = r3.f(r4, r5, r6, r7, r8)
            i4.i r1 = r3.f5805d
            monitor-enter(r1)
            int r2 = r0.f5785l     // Catch:{ all -> 0x001f }
            if (r2 != 0) goto L_0x0013
            boolean r2 = r0.n()     // Catch:{ all -> 0x001f }
            if (r2 != 0) goto L_0x0013
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            return r0
        L_0x0013:
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            boolean r1 = r0.m(r9)
            if (r1 != 0) goto L_0x001e
            r3.j()
            goto L_0x0000
        L_0x001e:
            return r0
        L_0x001f:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.g.g(int, int, int, int, boolean, boolean):l4.c");
    }

    private void l(c cVar) {
        int size = cVar.f5787n.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (cVar.f5787n.get(i5).get() == this) {
                cVar.f5787n.remove(i5);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private Socket n() {
        c cVar = this.f5811j;
        if (cVar == null || !cVar.f5784k) {
            return null;
        }
        return e(false, false, true);
    }

    private d p() {
        return j4.a.f5473a.j(this.f5805d);
    }

    public void a(c cVar, boolean z4) {
        if (this.f5811j == null) {
            this.f5811j = cVar;
            this.f5812k = z4;
            cVar.f5787n.add(new a(this, this.f5808g));
            return;
        }
        throw new IllegalStateException();
    }

    public void b() {
        c cVar;
        c cVar2;
        synchronized (this.f5805d) {
            this.f5814m = true;
            cVar = this.f5815n;
            cVar2 = this.f5811j;
        }
        if (cVar != null) {
            cVar.cancel();
        } else if (cVar2 != null) {
            cVar2.c();
        }
    }

    public c c() {
        c cVar;
        synchronized (this.f5805d) {
            cVar = this.f5815n;
        }
        return cVar;
    }

    public synchronized c d() {
        return this.f5811j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f5803b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean h() {
        /*
            r1 = this;
            i4.b0 r0 = r1.f5804c
            if (r0 != 0) goto L_0x0019
            l4.f$a r0 = r1.f5803b
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.b()
            if (r0 != 0) goto L_0x0019
        L_0x000e:
            l4.f r0 = r1.f5809h
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r0 = 0
            goto L_0x001a
        L_0x0019:
            r0 = 1
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.g.h():boolean");
    }

    public c i(u uVar, s.a aVar, boolean z4) {
        try {
            c o5 = g(aVar.a(), aVar.c(), aVar.d(), uVar.t(), uVar.z(), z4).o(uVar, aVar, this);
            synchronized (this.f5805d) {
                this.f5815n = o5;
            }
            return o5;
        } catch (IOException e5) {
            throw new e(e5);
        }
    }

    public void j() {
        c cVar;
        Socket e5;
        synchronized (this.f5805d) {
            cVar = this.f5811j;
            e5 = e(true, false, false);
            if (this.f5811j != null) {
                cVar = null;
            }
        }
        j4.c.f(e5);
        if (cVar != null) {
            this.f5807f.h(this.f5806e, cVar);
        }
    }

    public void k() {
        c cVar;
        Socket e5;
        synchronized (this.f5805d) {
            cVar = this.f5811j;
            e5 = e(false, true, false);
            if (this.f5811j != null) {
                cVar = null;
            }
        }
        j4.c.f(e5);
        if (cVar != null) {
            j4.a.f5473a.k(this.f5806e, (IOException) null);
            this.f5807f.h(this.f5806e, cVar);
            this.f5807f.a(this.f5806e);
        }
    }

    public Socket m(c cVar) {
        if (this.f5815n == null && this.f5811j.f5787n.size() == 1) {
            Socket e5 = e(true, false, false);
            this.f5811j = cVar;
            cVar.f5787n.add(this.f5811j.f5787n.get(0));
            return e5;
        }
        throw new IllegalStateException();
    }

    public b0 o() {
        return this.f5804c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r7 != o4.b.f6167k) goto L_0x001e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void q(java.io.IOException r7) {
        /*
            r6 = this;
            i4.i r0 = r6.f5805d
            monitor-enter(r0)
            boolean r1 = r7 instanceof o4.n     // Catch:{ all -> 0x0062 }
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0021
            o4.n r7 = (o4.n) r7     // Catch:{ all -> 0x0062 }
            o4.b r7 = r7.f6335e     // Catch:{ all -> 0x0062 }
            o4.b r1 = o4.b.REFUSED_STREAM     // Catch:{ all -> 0x0062 }
            if (r7 != r1) goto L_0x001a
            int r7 = r6.f5810i     // Catch:{ all -> 0x0062 }
            int r7 = r7 + r4
            r6.f5810i = r7     // Catch:{ all -> 0x0062 }
            if (r7 <= r4) goto L_0x0043
            goto L_0x001e
        L_0x001a:
            o4.b r1 = o4.b.CANCEL     // Catch:{ all -> 0x0062 }
            if (r7 == r1) goto L_0x0043
        L_0x001e:
            r6.f5804c = r3     // Catch:{ all -> 0x0062 }
            goto L_0x0041
        L_0x0021:
            l4.c r1 = r6.f5811j     // Catch:{ all -> 0x0062 }
            if (r1 == 0) goto L_0x0043
            boolean r1 = r1.n()     // Catch:{ all -> 0x0062 }
            if (r1 == 0) goto L_0x002f
            boolean r1 = r7 instanceof o4.a     // Catch:{ all -> 0x0062 }
            if (r1 == 0) goto L_0x0043
        L_0x002f:
            l4.c r1 = r6.f5811j     // Catch:{ all -> 0x0062 }
            int r1 = r1.f5785l     // Catch:{ all -> 0x0062 }
            if (r1 != 0) goto L_0x0041
            i4.b0 r1 = r6.f5804c     // Catch:{ all -> 0x0062 }
            if (r1 == 0) goto L_0x001e
            if (r7 == 0) goto L_0x001e
            l4.f r5 = r6.f5809h     // Catch:{ all -> 0x0062 }
            r5.a(r1, r7)     // Catch:{ all -> 0x0062 }
            goto L_0x001e
        L_0x0041:
            r7 = r4
            goto L_0x0044
        L_0x0043:
            r7 = r2
        L_0x0044:
            l4.c r1 = r6.f5811j     // Catch:{ all -> 0x0062 }
            java.net.Socket r7 = r6.e(r7, r2, r4)     // Catch:{ all -> 0x0062 }
            l4.c r2 = r6.f5811j     // Catch:{ all -> 0x0062 }
            if (r2 != 0) goto L_0x0054
            boolean r2 = r6.f5812k     // Catch:{ all -> 0x0062 }
            if (r2 != 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r3 = r1
        L_0x0054:
            monitor-exit(r0)     // Catch:{ all -> 0x0062 }
            j4.c.f(r7)
            if (r3 == 0) goto L_0x0061
            i4.o r7 = r6.f5807f
            i4.d r0 = r6.f5806e
            r7.h(r0, r3)
        L_0x0061:
            return
        L_0x0062:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0062 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.g.q(java.io.IOException):void");
    }

    public void r(boolean z4, c cVar, long j5, IOException iOException) {
        c cVar2;
        Socket e5;
        boolean z5;
        this.f5807f.p(this.f5806e, j5);
        synchronized (this.f5805d) {
            if (cVar != null) {
                if (cVar == this.f5815n) {
                    if (!z4) {
                        this.f5811j.f5785l++;
                    }
                    cVar2 = this.f5811j;
                    e5 = e(z4, false, true);
                    if (this.f5811j != null) {
                        cVar2 = null;
                    }
                    z5 = this.f5813l;
                }
            }
            throw new IllegalStateException("expected " + this.f5815n + " but was " + cVar);
        }
        j4.c.f(e5);
        if (cVar2 != null) {
            this.f5807f.h(this.f5806e, cVar2);
        }
        if (iOException != null) {
            this.f5807f.b(this.f5806e, j4.a.f5473a.k(this.f5806e, iOException));
        } else if (z5) {
            j4.a.f5473a.k(this.f5806e, (IOException) null);
            this.f5807f.a(this.f5806e);
        }
    }

    public String toString() {
        c d5 = d();
        return d5 != null ? d5.toString() : this.f5802a.toString();
    }
}
