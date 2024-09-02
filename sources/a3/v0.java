package a3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import m2.n;
import m2.p;
import p2.c;
import r2.f;
import u2.d;
import u2.i;
import v0.f0;

public final class v0<T, R> extends a<T, R> {

    /* renamed from: f  reason: collision with root package name */
    final f<? super T, ? extends n<? extends R>> f394f;

    /* renamed from: g  reason: collision with root package name */
    final int f395g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f396h;

    static final class a<T, R> extends AtomicReference<c> implements p<R> {

        /* renamed from: e  reason: collision with root package name */
        final b<T, R> f397e;

        /* renamed from: f  reason: collision with root package name */
        final long f398f;

        /* renamed from: g  reason: collision with root package name */
        final int f399g;

        /* renamed from: h  reason: collision with root package name */
        volatile i<R> f400h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f401i;

        a(b<T, R> bVar, long j5, int i5) {
            this.f397e = bVar;
            this.f398f = j5;
            this.f399g = i5;
        }

        public void a() {
            if (this.f398f == this.f397e.f412n) {
                this.f401i = true;
                this.f397e.e();
            }
        }

        public void b() {
            s2.c.c(this);
        }

        public void c(c cVar) {
            if (s2.c.o(this, cVar)) {
                if (cVar instanceof d) {
                    d dVar = (d) cVar;
                    int i5 = dVar.i(7);
                    if (i5 == 1) {
                        this.f400h = dVar;
                        this.f401i = true;
                        this.f397e.e();
                        return;
                    } else if (i5 == 2) {
                        this.f400h = dVar;
                        return;
                    }
                }
                this.f400h = new c3.c(this.f399g);
            }
        }

        public void d(R r5) {
            if (this.f398f == this.f397e.f412n) {
                if (r5 != null) {
                    this.f400h.offer(r5);
                }
                this.f397e.e();
            }
        }

        public void onError(Throwable th) {
            this.f397e.g(this, th);
        }
    }

    static final class b<T, R> extends AtomicInteger implements p<T>, c {

        /* renamed from: o  reason: collision with root package name */
        static final a<Object, Object> f402o;

        /* renamed from: e  reason: collision with root package name */
        final p<? super R> f403e;

        /* renamed from: f  reason: collision with root package name */
        final f<? super T, ? extends n<? extends R>> f404f;

        /* renamed from: g  reason: collision with root package name */
        final int f405g;

        /* renamed from: h  reason: collision with root package name */
        final boolean f406h;

        /* renamed from: i  reason: collision with root package name */
        final g3.b f407i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f408j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f409k;

        /* renamed from: l  reason: collision with root package name */
        c f410l;

        /* renamed from: m  reason: collision with root package name */
        final AtomicReference<a<T, R>> f411m = new AtomicReference<>();

        /* renamed from: n  reason: collision with root package name */
        volatile long f412n;

        static {
            a<Object, Object> aVar = new a<>((b) null, -1, 1);
            f402o = aVar;
            aVar.b();
        }

        b(p<? super R> pVar, f<? super T, ? extends n<? extends R>> fVar, int i5, boolean z4) {
            this.f403e = pVar;
            this.f404f = fVar;
            this.f405g = i5;
            this.f406h = z4;
            this.f407i = new g3.b();
        }

        public void a() {
            if (!this.f408j) {
                this.f408j = true;
                e();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            a<Object, Object> andSet;
            a<Object, Object> aVar = this.f411m.get();
            a<Object, Object> aVar2 = f402o;
            if (aVar != aVar2 && (andSet = this.f411m.getAndSet(aVar2)) != aVar2 && andSet != null) {
                andSet.b();
            }
        }

        public void c(c cVar) {
            if (s2.c.q(this.f410l, cVar)) {
                this.f410l = cVar;
                this.f403e.c(this);
            }
        }

        public void d(T t5) {
            a<Object, Object> aVar;
            long j5 = this.f412n + 1;
            this.f412n = j5;
            a aVar2 = this.f411m.get();
            if (aVar2 != null) {
                aVar2.b();
            }
            try {
                n nVar = (n) t2.b.e(this.f404f.apply(t5), "The ObservableSource returned is null");
                a aVar3 = new a(this, j5, this.f405g);
                do {
                    aVar = this.f411m.get();
                    if (aVar == f402o) {
                        return;
                    }
                } while (!f0.a(this.f411m, aVar, aVar3));
                nVar.g(aVar3);
            } catch (Throwable th) {
                q2.b.b(th);
                this.f410l.dispose();
                onError(th);
            }
        }

        public void dispose() {
            if (!this.f409k) {
                this.f409k = true;
                this.f410l.dispose();
                b();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x000f A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void e() {
            /*
                r13 = this;
                int r0 = r13.getAndIncrement()
                if (r0 == 0) goto L_0x0007
                return
            L_0x0007:
                m2.p<? super R> r0 = r13.f403e
                java.util.concurrent.atomic.AtomicReference<a3.v0$a<T, R>> r1 = r13.f411m
                boolean r2 = r13.f406h
                r3 = 1
                r4 = r3
            L_0x000f:
                boolean r5 = r13.f409k
                if (r5 == 0) goto L_0x0014
                return
            L_0x0014:
                boolean r5 = r13.f408j
                r6 = 0
                if (r5 == 0) goto L_0x0052
                java.lang.Object r5 = r1.get()
                if (r5 != 0) goto L_0x0021
                r5 = r3
                goto L_0x0022
            L_0x0021:
                r5 = r6
            L_0x0022:
                if (r2 == 0) goto L_0x0038
                if (r5 == 0) goto L_0x0052
                g3.b r1 = r13.f407i
                java.lang.Object r1 = r1.get()
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                if (r1 == 0) goto L_0x0034
                r0.onError(r1)
                goto L_0x0037
            L_0x0034:
                r0.a()
            L_0x0037:
                return
            L_0x0038:
                g3.b r7 = r13.f407i
                java.lang.Object r7 = r7.get()
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 == 0) goto L_0x004c
            L_0x0042:
                g3.b r1 = r13.f407i
                java.lang.Throwable r1 = r1.b()
                r0.onError(r1)
                return
            L_0x004c:
                if (r5 == 0) goto L_0x0052
                r0.a()
                return
            L_0x0052:
                java.lang.Object r5 = r1.get()
                a3.v0$a r5 = (a3.v0.a) r5
                if (r5 == 0) goto L_0x00d7
                u2.i<R> r7 = r5.f400h
                if (r7 == 0) goto L_0x00d7
                boolean r8 = r5.f401i
                r9 = 0
                if (r8 == 0) goto L_0x0080
                boolean r8 = r7.isEmpty()
                if (r2 == 0) goto L_0x006f
                if (r8 == 0) goto L_0x0080
                v0.f0.a(r1, r5, r9)
                goto L_0x000f
            L_0x006f:
                g3.b r10 = r13.f407i
                java.lang.Object r10 = r10.get()
                java.lang.Throwable r10 = (java.lang.Throwable) r10
                if (r10 == 0) goto L_0x007a
                goto L_0x0042
            L_0x007a:
                if (r8 == 0) goto L_0x0080
                v0.f0.a(r1, r5, r9)
                goto L_0x000f
            L_0x0080:
                r8 = r6
            L_0x0081:
                boolean r10 = r13.f409k
                if (r10 == 0) goto L_0x0086
                return
            L_0x0086:
                java.lang.Object r10 = r1.get()
                if (r5 == r10) goto L_0x008e
            L_0x008c:
                r8 = r3
                goto L_0x00cf
            L_0x008e:
                if (r2 != 0) goto L_0x009b
                g3.b r10 = r13.f407i
                java.lang.Object r10 = r10.get()
                java.lang.Throwable r10 = (java.lang.Throwable) r10
                if (r10 == 0) goto L_0x009b
                goto L_0x0042
            L_0x009b:
                boolean r10 = r5.f401i
                java.lang.Object r11 = r7.poll()     // Catch:{ all -> 0x00a2 }
                goto L_0x00c0
            L_0x00a2:
                r8 = move-exception
                q2.b.b(r8)
                g3.b r11 = r13.f407i
                r11.a(r8)
                v0.f0.a(r1, r5, r9)
                if (r2 != 0) goto L_0x00bb
                r13.b()
                p2.c r8 = r13.f410l
                r8.dispose()
                r13.f408j = r3
                goto L_0x00be
            L_0x00bb:
                r5.b()
            L_0x00be:
                r8 = r3
                r11 = r9
            L_0x00c0:
                if (r11 != 0) goto L_0x00c4
                r12 = r3
                goto L_0x00c5
            L_0x00c4:
                r12 = r6
            L_0x00c5:
                if (r10 == 0) goto L_0x00cd
                if (r12 == 0) goto L_0x00cd
                v0.f0.a(r1, r5, r9)
                goto L_0x008c
            L_0x00cd:
                if (r12 == 0) goto L_0x00d3
            L_0x00cf:
                if (r8 == 0) goto L_0x00d7
                goto L_0x000f
            L_0x00d3:
                r0.d(r11)
                goto L_0x0081
            L_0x00d7:
                int r4 = -r4
                int r4 = r13.addAndGet(r4)
                if (r4 != 0) goto L_0x000f
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: a3.v0.b.e():void");
        }

        public boolean f() {
            return this.f409k;
        }

        /* access modifiers changed from: package-private */
        public void g(a<T, R> aVar, Throwable th) {
            if (aVar.f398f != this.f412n || !this.f407i.a(th)) {
                j3.a.r(th);
                return;
            }
            if (!this.f406h) {
                this.f410l.dispose();
                this.f408j = true;
            }
            aVar.f401i = true;
            e();
        }

        public void onError(Throwable th) {
            if (this.f408j || !this.f407i.a(th)) {
                j3.a.r(th);
                return;
            }
            if (!this.f406h) {
                b();
            }
            this.f408j = true;
            e();
        }
    }

    public v0(n<T> nVar, f<? super T, ? extends n<? extends R>> fVar, int i5, boolean z4) {
        super(nVar);
        this.f394f = fVar;
        this.f395g = i5;
        this.f396h = z4;
    }

    public void v0(p<? super R> pVar) {
        if (!s0.b(this.f24e, pVar, this.f394f)) {
            this.f24e.g(new b(pVar, this.f394f, this.f395g, this.f396h));
        }
    }
}
