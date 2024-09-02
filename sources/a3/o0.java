package a3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import m2.k;
import m2.p;
import m2.q;
import p2.c;
import r2.e;
import s2.f;

public final class o0<T> extends k<T> {

    /* renamed from: e  reason: collision with root package name */
    final h3.a<T> f269e;

    /* renamed from: f  reason: collision with root package name */
    final int f270f;

    /* renamed from: g  reason: collision with root package name */
    final long f271g;

    /* renamed from: h  reason: collision with root package name */
    final TimeUnit f272h;

    /* renamed from: i  reason: collision with root package name */
    final q f273i;

    /* renamed from: j  reason: collision with root package name */
    a f274j;

    static final class a extends AtomicReference<c> implements Runnable, e<c> {

        /* renamed from: e  reason: collision with root package name */
        final o0<?> f275e;

        /* renamed from: f  reason: collision with root package name */
        c f276f;

        /* renamed from: g  reason: collision with root package name */
        long f277g;

        /* renamed from: h  reason: collision with root package name */
        boolean f278h;

        /* renamed from: i  reason: collision with root package name */
        boolean f279i;

        a(o0<?> o0Var) {
            this.f275e = o0Var;
        }

        /* renamed from: a */
        public void accept(c cVar) {
            s2.c.l(this, cVar);
            synchronized (this.f275e) {
                if (this.f279i) {
                    ((f) this.f275e.f269e).b(cVar);
                }
            }
        }

        public void run() {
            this.f275e.S0(this);
        }
    }

    static final class b<T> extends AtomicBoolean implements p<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f280e;

        /* renamed from: f  reason: collision with root package name */
        final o0<T> f281f;

        /* renamed from: g  reason: collision with root package name */
        final a f282g;

        /* renamed from: h  reason: collision with root package name */
        c f283h;

        b(p<? super T> pVar, o0<T> o0Var, a aVar) {
            this.f280e = pVar;
            this.f281f = o0Var;
            this.f282g = aVar;
        }

        public void a() {
            if (compareAndSet(false, true)) {
                this.f281f.R0(this.f282g);
                this.f280e.a();
            }
        }

        public void c(c cVar) {
            if (s2.c.q(this.f283h, cVar)) {
                this.f283h = cVar;
                this.f280e.c(this);
            }
        }

        public void d(T t5) {
            this.f280e.d(t5);
        }

        public void dispose() {
            this.f283h.dispose();
            if (compareAndSet(false, true)) {
                this.f281f.O0(this.f282g);
            }
        }

        public boolean f() {
            return this.f283h.f();
        }

        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.f281f.R0(this.f282g);
                this.f280e.onError(th);
                return;
            }
            j3.a.r(th);
        }
    }

    public o0(h3.a<T> aVar) {
        this(aVar, 1, 0, TimeUnit.NANOSECONDS, (q) null);
    }

    public o0(h3.a<T> aVar, int i5, long j5, TimeUnit timeUnit, q qVar) {
        this.f269e = aVar;
        this.f270f = i5;
        this.f271g = j5;
        this.f272h = timeUnit;
        this.f273i = qVar;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void O0(a3.o0.a r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            a3.o0$a r0 = r5.f274j     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x003d
            if (r0 == r6) goto L_0x0008
            goto L_0x003d
        L_0x0008:
            long r0 = r6.f277g     // Catch:{ all -> 0x003f }
            r2 = 1
            long r0 = r0 - r2
            r6.f277g = r0     // Catch:{ all -> 0x003f }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x003b
            boolean r0 = r6.f278h     // Catch:{ all -> 0x003f }
            if (r0 != 0) goto L_0x001a
            goto L_0x003b
        L_0x001a:
            long r0 = r5.f271g     // Catch:{ all -> 0x003f }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0025
            r5.S0(r6)     // Catch:{ all -> 0x003f }
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            return
        L_0x0025:
            s2.g r0 = new s2.g     // Catch:{ all -> 0x003f }
            r0.<init>()     // Catch:{ all -> 0x003f }
            r6.f276f = r0     // Catch:{ all -> 0x003f }
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            m2.q r1 = r5.f273i
            long r2 = r5.f271g
            java.util.concurrent.TimeUnit r4 = r5.f272h
            p2.c r6 = r1.d(r6, r2, r4)
            r0.a(r6)
            return
        L_0x003b:
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            return
        L_0x003d:
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.o0.O0(a3.o0$a):void");
    }

    /* access modifiers changed from: package-private */
    public void P0(a aVar) {
        c cVar = aVar.f276f;
        if (cVar != null) {
            cVar.dispose();
            aVar.f276f = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void Q0(a aVar) {
        h3.a<T> aVar2 = this.f269e;
        if (aVar2 instanceof c) {
            ((c) aVar2).dispose();
        } else if (aVar2 instanceof f) {
            ((f) aVar2).b((c) aVar.get());
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        if (r0 == 0) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void R0(a3.o0.a r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            h3.a<T> r0 = r8.f269e     // Catch:{ all -> 0x003b }
            boolean r0 = r0 instanceof a3.m0     // Catch:{ all -> 0x003b }
            r1 = 0
            r2 = 0
            r4 = 1
            if (r0 == 0) goto L_0x0024
            a3.o0$a r0 = r8.f274j     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x0017
            if (r0 != r9) goto L_0x0017
            r8.f274j = r1     // Catch:{ all -> 0x003b }
            r8.P0(r9)     // Catch:{ all -> 0x003b }
        L_0x0017:
            long r0 = r9.f277g     // Catch:{ all -> 0x003b }
            long r0 = r0 - r4
            r9.f277g = r0     // Catch:{ all -> 0x003b }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0039
        L_0x0020:
            r8.Q0(r9)     // Catch:{ all -> 0x003b }
            goto L_0x0039
        L_0x0024:
            a3.o0$a r0 = r8.f274j     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x0039
            if (r0 != r9) goto L_0x0039
            r8.P0(r9)     // Catch:{ all -> 0x003b }
            long r6 = r9.f277g     // Catch:{ all -> 0x003b }
            long r6 = r6 - r4
            r9.f277g = r6     // Catch:{ all -> 0x003b }
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0039
            r8.f274j = r1     // Catch:{ all -> 0x003b }
            goto L_0x0020
        L_0x0039:
            monitor-exit(r8)     // Catch:{ all -> 0x003b }
            return
        L_0x003b:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x003b }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.o0.R0(a3.o0$a):void");
    }

    /* access modifiers changed from: package-private */
    public void S0(a aVar) {
        synchronized (this) {
            if (aVar.f277g == 0 && aVar == this.f274j) {
                this.f274j = null;
                c cVar = (c) aVar.get();
                s2.c.c(aVar);
                h3.a<T> aVar2 = this.f269e;
                if (aVar2 instanceof c) {
                    ((c) aVar2).dispose();
                } else if (aVar2 instanceof f) {
                    if (cVar == null) {
                        aVar.f279i = true;
                    } else {
                        ((f) aVar2).b(cVar);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super T> pVar) {
        a aVar;
        boolean z4;
        c cVar;
        synchronized (this) {
            aVar = this.f274j;
            if (aVar == null) {
                aVar = new a(this);
                this.f274j = aVar;
            }
            long j5 = aVar.f277g;
            if (j5 == 0 && (cVar = aVar.f276f) != null) {
                cVar.dispose();
            }
            long j6 = j5 + 1;
            aVar.f277g = j6;
            z4 = true;
            if (aVar.f278h || j6 != ((long) this.f270f)) {
                z4 = false;
            } else {
                aVar.f278h = true;
            }
        }
        this.f269e.g(new b(pVar, this, aVar));
        if (z4) {
            this.f269e.Q0(aVar);
        }
    }
}
