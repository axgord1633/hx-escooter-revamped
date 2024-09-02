package o4;

import i4.q;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import javax.annotation.Nullable;
import o4.c;
import s4.e;
import s4.r;
import s4.s;
import s4.t;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    long f6295a = 0;

    /* renamed from: b  reason: collision with root package name */
    long f6296b;

    /* renamed from: c  reason: collision with root package name */
    final int f6297c;

    /* renamed from: d  reason: collision with root package name */
    final g f6298d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Deque<q> f6299e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public c.a f6300f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6301g;

    /* renamed from: h  reason: collision with root package name */
    private final b f6302h;

    /* renamed from: i  reason: collision with root package name */
    final a f6303i;

    /* renamed from: j  reason: collision with root package name */
    final c f6304j;

    /* renamed from: k  reason: collision with root package name */
    final c f6305k;

    /* renamed from: l  reason: collision with root package name */
    b f6306l;

    final class a implements r {

        /* renamed from: e  reason: collision with root package name */
        private final s4.c f6307e = new s4.c();

        /* renamed from: f  reason: collision with root package name */
        boolean f6308f;

        /* renamed from: g  reason: collision with root package name */
        boolean f6309g;

        a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            r1.f6305k.u();
            r11.f6310h.e();
            r9 = java.lang.Math.min(r11.f6310h.f6296b, r11.f6307e.size());
            r1 = r11.f6310h;
            r1.f6296b -= r9;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void b(boolean r12) {
            /*
                r11 = this;
                o4.i r0 = o4.i.this
                monitor-enter(r0)
                o4.i r1 = o4.i.this     // Catch:{ all -> 0x007e }
                o4.i$c r1 = r1.f6305k     // Catch:{ all -> 0x007e }
                r1.k()     // Catch:{ all -> 0x007e }
            L_0x000a:
                o4.i r1 = o4.i.this     // Catch:{ all -> 0x0075 }
                long r2 = r1.f6296b     // Catch:{ all -> 0x0075 }
                r4 = 0
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 > 0) goto L_0x0024
                boolean r2 = r11.f6309g     // Catch:{ all -> 0x0075 }
                if (r2 != 0) goto L_0x0024
                boolean r2 = r11.f6308f     // Catch:{ all -> 0x0075 }
                if (r2 != 0) goto L_0x0024
                o4.b r2 = r1.f6306l     // Catch:{ all -> 0x0075 }
                if (r2 != 0) goto L_0x0024
                r1.t()     // Catch:{ all -> 0x0075 }
                goto L_0x000a
            L_0x0024:
                o4.i$c r1 = r1.f6305k     // Catch:{ all -> 0x007e }
                r1.u()     // Catch:{ all -> 0x007e }
                o4.i r1 = o4.i.this     // Catch:{ all -> 0x007e }
                r1.e()     // Catch:{ all -> 0x007e }
                o4.i r1 = o4.i.this     // Catch:{ all -> 0x007e }
                long r1 = r1.f6296b     // Catch:{ all -> 0x007e }
                s4.c r3 = r11.f6307e     // Catch:{ all -> 0x007e }
                long r3 = r3.size()     // Catch:{ all -> 0x007e }
                long r9 = java.lang.Math.min(r1, r3)     // Catch:{ all -> 0x007e }
                o4.i r1 = o4.i.this     // Catch:{ all -> 0x007e }
                long r2 = r1.f6296b     // Catch:{ all -> 0x007e }
                long r2 = r2 - r9
                r1.f6296b = r2     // Catch:{ all -> 0x007e }
                monitor-exit(r0)     // Catch:{ all -> 0x007e }
                o4.i$c r0 = r1.f6305k
                r0.k()
                o4.i r0 = o4.i.this     // Catch:{ all -> 0x006c }
                o4.g r5 = r0.f6298d     // Catch:{ all -> 0x006c }
                int r6 = r0.f6297c     // Catch:{ all -> 0x006c }
                if (r12 == 0) goto L_0x005d
                s4.c r12 = r11.f6307e     // Catch:{ all -> 0x006c }
                long r0 = r12.size()     // Catch:{ all -> 0x006c }
                int r12 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r12 != 0) goto L_0x005d
                r12 = 1
                goto L_0x005e
            L_0x005d:
                r12 = 0
            L_0x005e:
                r7 = r12
                s4.c r8 = r11.f6307e     // Catch:{ all -> 0x006c }
                r5.W(r6, r7, r8, r9)     // Catch:{ all -> 0x006c }
                o4.i r12 = o4.i.this
                o4.i$c r12 = r12.f6305k
                r12.u()
                return
            L_0x006c:
                r12 = move-exception
                o4.i r0 = o4.i.this
                o4.i$c r0 = r0.f6305k
                r0.u()
                throw r12
            L_0x0075:
                r12 = move-exception
                o4.i r1 = o4.i.this     // Catch:{ all -> 0x007e }
                o4.i$c r1 = r1.f6305k     // Catch:{ all -> 0x007e }
                r1.u()     // Catch:{ all -> 0x007e }
                throw r12     // Catch:{ all -> 0x007e }
            L_0x007e:
                r12 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x007e }
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: o4.i.a.b(boolean):void");
        }

        public void G(s4.c cVar, long j5) {
            this.f6307e.G(cVar, j5);
            while (this.f6307e.size() >= 16384) {
                b(false);
            }
        }

        public t c() {
            return i.this.f6305k;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
            if (r8.f6307e.size() <= 0) goto L_0x002d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
            if (r8.f6307e.size() <= 0) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
            b(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
            r0 = r8.f6310h;
            r0.f6298d.W(r0.f6297c, true, (s4.c) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
            r2 = r8.f6310h;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r8.f6308f = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
            r8.f6310h.f6298d.flush();
            r8.f6310h.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            if (r8.f6310h.f6303i.f6309g != false) goto L_0x003a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() {
            /*
                r8 = this;
                o4.i r0 = o4.i.this
                monitor-enter(r0)
                boolean r1 = r8.f6308f     // Catch:{ all -> 0x0050 }
                if (r1 == 0) goto L_0x0009
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                return
            L_0x0009:
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                o4.i r0 = o4.i.this
                o4.i$a r0 = r0.f6303i
                boolean r0 = r0.f6309g
                r1 = 1
                if (r0 != 0) goto L_0x003a
                s4.c r0 = r8.f6307e
                long r2 = r0.size()
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x002d
            L_0x001f:
                s4.c r0 = r8.f6307e
                long r2 = r0.size()
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x003a
                r8.b(r1)
                goto L_0x001f
            L_0x002d:
                o4.i r0 = o4.i.this
                o4.g r2 = r0.f6298d
                int r3 = r0.f6297c
                r4 = 1
                r5 = 0
                r6 = 0
                r2.W(r3, r4, r5, r6)
            L_0x003a:
                o4.i r2 = o4.i.this
                monitor-enter(r2)
                r8.f6308f = r1     // Catch:{ all -> 0x004d }
                monitor-exit(r2)     // Catch:{ all -> 0x004d }
                o4.i r0 = o4.i.this
                o4.g r0 = r0.f6298d
                r0.flush()
                o4.i r0 = o4.i.this
                r0.d()
                return
            L_0x004d:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x004d }
                throw r0
            L_0x0050:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: o4.i.a.close():void");
        }

        public void flush() {
            synchronized (i.this) {
                i.this.e();
            }
            while (this.f6307e.size() > 0) {
                b(false);
                i.this.f6298d.flush();
            }
        }
    }

    private final class b implements s {

        /* renamed from: e  reason: collision with root package name */
        private final s4.c f6311e = new s4.c();

        /* renamed from: f  reason: collision with root package name */
        private final s4.c f6312f = new s4.c();

        /* renamed from: g  reason: collision with root package name */
        private final long f6313g;

        /* renamed from: h  reason: collision with root package name */
        boolean f6314h;

        /* renamed from: i  reason: collision with root package name */
        boolean f6315i;

        b(long j5) {
            this.f6313g = j5;
        }

        private void d(long j5) {
            i.this.f6298d.V(j5);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: i4.q} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long K(s4.c r17, long r18) {
            /*
                r16 = this;
                r1 = r16
                r2 = r18
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 < 0) goto L_0x00e0
            L_0x000a:
                o4.i r6 = o4.i.this
                monitor-enter(r6)
                o4.i r0 = o4.i.this     // Catch:{ all -> 0x00dd }
                o4.i$c r0 = r0.f6304j     // Catch:{ all -> 0x00dd }
                r0.k()     // Catch:{ all -> 0x00dd }
                o4.i r0 = o4.i.this     // Catch:{ all -> 0x00d4 }
                o4.b r7 = r0.f6306l     // Catch:{ all -> 0x00d4 }
                if (r7 == 0) goto L_0x001b
                goto L_0x001c
            L_0x001b:
                r7 = 0
            L_0x001c:
                boolean r9 = r1.f6314h     // Catch:{ all -> 0x00d4 }
                if (r9 != 0) goto L_0x00cc
                java.util.Deque r0 = r0.f6299e     // Catch:{ all -> 0x00d4 }
                boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x00d4 }
                if (r0 != 0) goto L_0x0049
                o4.i r0 = o4.i.this     // Catch:{ all -> 0x00d4 }
                o4.c$a r0 = r0.f6300f     // Catch:{ all -> 0x00d4 }
                if (r0 == 0) goto L_0x0049
                o4.i r0 = o4.i.this     // Catch:{ all -> 0x00d4 }
                java.util.Deque r0 = r0.f6299e     // Catch:{ all -> 0x00d4 }
                java.lang.Object r0 = r0.removeFirst()     // Catch:{ all -> 0x00d4 }
                r8 = r0
                i4.q r8 = (i4.q) r8     // Catch:{ all -> 0x00d4 }
                o4.i r0 = o4.i.this     // Catch:{ all -> 0x00d4 }
                o4.c$a r0 = r0.f6300f     // Catch:{ all -> 0x00d4 }
                r13 = r17
                r10 = r0
                goto L_0x00a6
            L_0x0049:
                s4.c r0 = r1.f6312f     // Catch:{ all -> 0x00d4 }
                long r11 = r0.size()     // Catch:{ all -> 0x00d4 }
                int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x008d
                s4.c r0 = r1.f6312f     // Catch:{ all -> 0x00d4 }
                long r11 = r0.size()     // Catch:{ all -> 0x00d4 }
                long r11 = java.lang.Math.min(r2, r11)     // Catch:{ all -> 0x00d4 }
                r13 = r17
                long r11 = r0.K(r13, r11)     // Catch:{ all -> 0x00d4 }
                o4.i r0 = o4.i.this     // Catch:{ all -> 0x00d4 }
                long r14 = r0.f6295a     // Catch:{ all -> 0x00d4 }
                long r14 = r14 + r11
                r0.f6295a = r14     // Catch:{ all -> 0x00d4 }
                if (r7 != 0) goto L_0x008a
                o4.g r0 = r0.f6298d     // Catch:{ all -> 0x00d4 }
                o4.m r0 = r0.f6237x     // Catch:{ all -> 0x00d4 }
                int r0 = r0.d()     // Catch:{ all -> 0x00d4 }
                int r0 = r0 / 2
                long r8 = (long) r0     // Catch:{ all -> 0x00d4 }
                int r0 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
                if (r0 < 0) goto L_0x008a
                o4.i r0 = o4.i.this     // Catch:{ all -> 0x00d4 }
                o4.g r8 = r0.f6298d     // Catch:{ all -> 0x00d4 }
                int r9 = r0.f6297c     // Catch:{ all -> 0x00d4 }
                long r14 = r0.f6295a     // Catch:{ all -> 0x00d4 }
                r8.a0(r9, r14)     // Catch:{ all -> 0x00d4 }
                o4.i r0 = o4.i.this     // Catch:{ all -> 0x00d4 }
                r0.f6295a = r4     // Catch:{ all -> 0x00d4 }
            L_0x008a:
                r8 = 0
                r10 = 0
                goto L_0x00a8
            L_0x008d:
                r13 = r17
                boolean r0 = r1.f6315i     // Catch:{ all -> 0x00d4 }
                if (r0 != 0) goto L_0x00a4
                if (r7 != 0) goto L_0x00a4
                o4.i r0 = o4.i.this     // Catch:{ all -> 0x00d4 }
                r0.t()     // Catch:{ all -> 0x00d4 }
                o4.i r0 = o4.i.this     // Catch:{ all -> 0x00dd }
                o4.i$c r0 = r0.f6304j     // Catch:{ all -> 0x00dd }
                r0.u()     // Catch:{ all -> 0x00dd }
                monitor-exit(r6)     // Catch:{ all -> 0x00dd }
                goto L_0x000a
            L_0x00a4:
                r8 = 0
                r10 = 0
            L_0x00a6:
                r11 = -1
            L_0x00a8:
                o4.i r0 = o4.i.this     // Catch:{ all -> 0x00dd }
                o4.i$c r0 = r0.f6304j     // Catch:{ all -> 0x00dd }
                r0.u()     // Catch:{ all -> 0x00dd }
                monitor-exit(r6)     // Catch:{ all -> 0x00dd }
                if (r8 == 0) goto L_0x00b9
                if (r10 == 0) goto L_0x00b9
                r10.a(r8)
                goto L_0x000a
            L_0x00b9:
                r2 = -1
                int r0 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
                if (r0 == 0) goto L_0x00c3
                r1.d(r11)
                return r11
            L_0x00c3:
                if (r7 != 0) goto L_0x00c6
                return r2
            L_0x00c6:
                o4.n r0 = new o4.n
                r0.<init>(r7)
                throw r0
            L_0x00cc:
                java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00d4 }
                java.lang.String r2 = "stream closed"
                r0.<init>(r2)     // Catch:{ all -> 0x00d4 }
                throw r0     // Catch:{ all -> 0x00d4 }
            L_0x00d4:
                r0 = move-exception
                o4.i r2 = o4.i.this     // Catch:{ all -> 0x00dd }
                o4.i$c r2 = r2.f6304j     // Catch:{ all -> 0x00dd }
                r2.u()     // Catch:{ all -> 0x00dd }
                throw r0     // Catch:{ all -> 0x00dd }
            L_0x00dd:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x00dd }
                throw r0
            L_0x00e0:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "byteCount < 0: "
                r4.append(r5)
                r4.append(r2)
                java.lang.String r2 = r4.toString()
                r0.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: o4.i.b.K(s4.c, long):long");
        }

        /* access modifiers changed from: package-private */
        public void b(e eVar, long j5) {
            boolean z4;
            boolean z5;
            boolean z6;
            long j6;
            while (j5 > 0) {
                synchronized (i.this) {
                    z4 = this.f6315i;
                    z5 = true;
                    z6 = this.f6312f.size() + j5 > this.f6313g;
                }
                if (z6) {
                    eVar.skip(j5);
                    i.this.h(b.FLOW_CONTROL_ERROR);
                    return;
                } else if (z4) {
                    eVar.skip(j5);
                    return;
                } else {
                    long K = eVar.K(this.f6311e, j5);
                    if (K != -1) {
                        j5 -= K;
                        synchronized (i.this) {
                            if (this.f6314h) {
                                j6 = this.f6311e.size();
                                this.f6311e.b();
                            } else {
                                if (this.f6312f.size() != 0) {
                                    z5 = false;
                                }
                                this.f6312f.M(this.f6311e);
                                if (z5) {
                                    i.this.notifyAll();
                                }
                                j6 = 0;
                            }
                        }
                        if (j6 > 0) {
                            d(j6);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        public t c() {
            return i.this.f6304j;
        }

        public void close() {
            long size;
            c.a aVar;
            ArrayList<q> arrayList;
            synchronized (i.this) {
                this.f6314h = true;
                size = this.f6312f.size();
                this.f6312f.b();
                aVar = null;
                if (i.this.f6299e.isEmpty() || i.this.f6300f == null) {
                    arrayList = null;
                } else {
                    ArrayList arrayList2 = new ArrayList(i.this.f6299e);
                    i.this.f6299e.clear();
                    ArrayList arrayList3 = arrayList2;
                    aVar = i.this.f6300f;
                    arrayList = arrayList3;
                }
                i.this.notifyAll();
            }
            if (size > 0) {
                d(size);
            }
            i.this.d();
            if (aVar != null) {
                for (q a5 : arrayList) {
                    aVar.a(a5);
                }
            }
        }
    }

    class c extends s4.a {
        c() {
        }

        /* access modifiers changed from: protected */
        public IOException o(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* access modifiers changed from: protected */
        public void t() {
            i.this.h(b.CANCEL);
            i.this.f6298d.R();
        }

        public void u() {
            if (n()) {
                throw o((IOException) null);
            }
        }
    }

    i(int i5, g gVar, boolean z4, boolean z5, @Nullable q qVar) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f6299e = arrayDeque;
        this.f6304j = new c();
        this.f6305k = new c();
        this.f6306l = null;
        if (gVar != null) {
            this.f6297c = i5;
            this.f6298d = gVar;
            this.f6296b = (long) gVar.f6238y.d();
            b bVar = new b((long) gVar.f6237x.d());
            this.f6302h = bVar;
            a aVar = new a();
            this.f6303i = aVar;
            bVar.f6315i = z5;
            aVar.f6309g = z4;
            if (qVar != null) {
                arrayDeque.add(qVar);
            }
            if (l() && qVar != null) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            } else if (!l() && qVar == null) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            throw new NullPointerException("connection == null");
        }
    }

    private boolean g(b bVar) {
        synchronized (this) {
            if (this.f6306l != null) {
                return false;
            }
            if (this.f6302h.f6315i && this.f6303i.f6309g) {
                return false;
            }
            this.f6306l = bVar;
            notifyAll();
            this.f6298d.Q(this.f6297c);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void c(long j5) {
        this.f6296b += j5;
        if (j5 > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        boolean z4;
        boolean m5;
        synchronized (this) {
            b bVar = this.f6302h;
            if (!bVar.f6315i && bVar.f6314h) {
                a aVar = this.f6303i;
                if (aVar.f6309g || aVar.f6308f) {
                    z4 = true;
                    m5 = m();
                }
            }
            z4 = false;
            m5 = m();
        }
        if (z4) {
            f(b.CANCEL);
        } else if (!m5) {
            this.f6298d.Q(this.f6297c);
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        a aVar = this.f6303i;
        if (aVar.f6308f) {
            throw new IOException("stream closed");
        } else if (aVar.f6309g) {
            throw new IOException("stream finished");
        } else if (this.f6306l != null) {
            throw new n(this.f6306l);
        }
    }

    public void f(b bVar) {
        if (g(bVar)) {
            this.f6298d.Y(this.f6297c, bVar);
        }
    }

    public void h(b bVar) {
        if (g(bVar)) {
            this.f6298d.Z(this.f6297c, bVar);
        }
    }

    public int i() {
        return this.f6297c;
    }

    public r j() {
        synchronized (this) {
            if (!this.f6301g) {
                if (!l()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.f6303i;
    }

    public s k() {
        return this.f6302h;
    }

    public boolean l() {
        return this.f6298d.f6218e == ((this.f6297c & 1) == 1);
    }

    public synchronized boolean m() {
        if (this.f6306l != null) {
            return false;
        }
        b bVar = this.f6302h;
        if (bVar.f6315i || bVar.f6314h) {
            a aVar = this.f6303i;
            if ((aVar.f6309g || aVar.f6308f) && this.f6301g) {
                return false;
            }
        }
        return true;
    }

    public t n() {
        return this.f6304j;
    }

    /* access modifiers changed from: package-private */
    public void o(e eVar, int i5) {
        this.f6302h.b(eVar, (long) i5);
    }

    /* access modifiers changed from: package-private */
    public void p() {
        boolean m5;
        synchronized (this) {
            this.f6302h.f6315i = true;
            m5 = m();
            notifyAll();
        }
        if (!m5) {
            this.f6298d.Q(this.f6297c);
        }
    }

    /* access modifiers changed from: package-private */
    public void q(List<c> list) {
        boolean m5;
        synchronized (this) {
            this.f6301g = true;
            this.f6299e.add(j4.c.F(list));
            m5 = m();
            notifyAll();
        }
        if (!m5) {
            this.f6298d.Q(this.f6297c);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void r(b bVar) {
        if (this.f6306l == null) {
            this.f6306l = bVar;
            notifyAll();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        r2.f6304j.u();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized i4.q s() {
        /*
            r2 = this;
            monitor-enter(r2)
            o4.i$c r0 = r2.f6304j     // Catch:{ all -> 0x003c }
            r0.k()     // Catch:{ all -> 0x003c }
        L_0x0006:
            java.util.Deque<i4.q> r0 = r2.f6299e     // Catch:{ all -> 0x0035 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0016
            o4.b r0 = r2.f6306l     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x0016
            r2.t()     // Catch:{ all -> 0x0035 }
            goto L_0x0006
        L_0x0016:
            o4.i$c r0 = r2.f6304j     // Catch:{ all -> 0x003c }
            r0.u()     // Catch:{ all -> 0x003c }
            java.util.Deque<i4.q> r0 = r2.f6299e     // Catch:{ all -> 0x003c }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x002d
            java.util.Deque<i4.q> r0 = r2.f6299e     // Catch:{ all -> 0x003c }
            java.lang.Object r0 = r0.removeFirst()     // Catch:{ all -> 0x003c }
            i4.q r0 = (i4.q) r0     // Catch:{ all -> 0x003c }
            monitor-exit(r2)
            return r0
        L_0x002d:
            o4.n r0 = new o4.n     // Catch:{ all -> 0x003c }
            o4.b r1 = r2.f6306l     // Catch:{ all -> 0x003c }
            r0.<init>(r1)     // Catch:{ all -> 0x003c }
            throw r0     // Catch:{ all -> 0x003c }
        L_0x0035:
            r0 = move-exception
            o4.i$c r1 = r2.f6304j     // Catch:{ all -> 0x003c }
            r1.u()     // Catch:{ all -> 0x003c }
            throw r0     // Catch:{ all -> 0x003c }
        L_0x003c:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.i.s():i4.q");
    }

    /* access modifiers changed from: package-private */
    public void t() {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public t u() {
        return this.f6305k;
    }
}
