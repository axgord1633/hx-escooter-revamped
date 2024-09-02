package a3;

import d3.o;
import m2.n;
import m2.p;
import m2.q;
import p2.c;
import u2.d;
import u2.i;
import v2.b;

public final class i0<T> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final q f179f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f180g;

    /* renamed from: h  reason: collision with root package name */
    final int f181h;

    static final class a<T> extends b<T> implements p<T>, Runnable {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f182e;

        /* renamed from: f  reason: collision with root package name */
        final q.c f183f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f184g;

        /* renamed from: h  reason: collision with root package name */
        final int f185h;

        /* renamed from: i  reason: collision with root package name */
        i<T> f186i;

        /* renamed from: j  reason: collision with root package name */
        c f187j;

        /* renamed from: k  reason: collision with root package name */
        Throwable f188k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f189l;

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f190m;

        /* renamed from: n  reason: collision with root package name */
        int f191n;

        /* renamed from: o  reason: collision with root package name */
        boolean f192o;

        a(p<? super T> pVar, q.c cVar, boolean z4, int i5) {
            this.f182e = pVar;
            this.f183f = cVar;
            this.f184g = z4;
            this.f185h = i5;
        }

        public void a() {
            if (!this.f189l) {
                this.f189l = true;
                j();
            }
        }

        public void c(c cVar) {
            if (s2.c.q(this.f187j, cVar)) {
                this.f187j = cVar;
                if (cVar instanceof d) {
                    d dVar = (d) cVar;
                    int i5 = dVar.i(7);
                    if (i5 == 1) {
                        this.f191n = i5;
                        this.f186i = dVar;
                        this.f189l = true;
                        this.f182e.c(this);
                        j();
                        return;
                    } else if (i5 == 2) {
                        this.f191n = i5;
                        this.f186i = dVar;
                        this.f182e.c(this);
                        return;
                    }
                }
                this.f186i = new c3.c(this.f185h);
                this.f182e.c(this);
            }
        }

        public void clear() {
            this.f186i.clear();
        }

        public void d(T t5) {
            if (!this.f189l) {
                if (this.f191n != 2) {
                    this.f186i.offer(t5);
                }
                j();
            }
        }

        public void dispose() {
            if (!this.f190m) {
                this.f190m = true;
                this.f187j.dispose();
                this.f183f.dispose();
                if (!this.f192o && getAndIncrement() == 0) {
                    this.f186i.clear();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean e(boolean z4, boolean z5, p<? super T> pVar) {
            if (this.f190m) {
                this.f186i.clear();
                return true;
            } else if (!z4) {
                return false;
            } else {
                Throwable th = this.f188k;
                if (this.f184g) {
                    if (!z5) {
                        return false;
                    }
                    this.f190m = true;
                    if (th != null) {
                        pVar.onError(th);
                    } else {
                        pVar.a();
                    }
                    this.f183f.dispose();
                    return true;
                } else if (th != null) {
                    this.f190m = true;
                    this.f186i.clear();
                    pVar.onError(th);
                    this.f183f.dispose();
                    return true;
                } else if (!z5) {
                    return false;
                } else {
                    this.f190m = true;
                    pVar.a();
                    this.f183f.dispose();
                    return true;
                }
            }
        }

        public boolean f() {
            return this.f190m;
        }

        /* access modifiers changed from: package-private */
        public void g() {
            int i5 = 1;
            while (!this.f190m) {
                boolean z4 = this.f189l;
                Throwable th = this.f188k;
                if (this.f184g || !z4 || th == null) {
                    this.f182e.d(null);
                    if (z4) {
                        this.f190m = true;
                        Throwable th2 = this.f188k;
                        if (th2 != null) {
                            this.f182e.onError(th2);
                        } else {
                            this.f182e.a();
                        }
                    } else {
                        i5 = addAndGet(-i5);
                        if (i5 == 0) {
                            return;
                        }
                    }
                } else {
                    this.f190m = true;
                    this.f182e.onError(this.f188k);
                }
                this.f183f.dispose();
                return;
            }
        }

        /* access modifiers changed from: package-private */
        public void h() {
            i<T> iVar = this.f186i;
            p<? super T> pVar = this.f182e;
            int i5 = 1;
            while (!e(this.f189l, iVar.isEmpty(), pVar)) {
                while (true) {
                    boolean z4 = this.f189l;
                    try {
                        T poll = iVar.poll();
                        boolean z5 = poll == null;
                        if (!e(z4, z5, pVar)) {
                            if (z5) {
                                i5 = addAndGet(-i5);
                                if (i5 == 0) {
                                    return;
                                }
                            } else {
                                pVar.d(poll);
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        q2.b.b(th);
                        this.f190m = true;
                        this.f187j.dispose();
                        iVar.clear();
                        pVar.onError(th);
                        this.f183f.dispose();
                        return;
                    }
                }
            }
        }

        public int i(int i5) {
            if ((i5 & 2) == 0) {
                return 0;
            }
            this.f192o = true;
            return 2;
        }

        public boolean isEmpty() {
            return this.f186i.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public void j() {
            if (getAndIncrement() == 0) {
                this.f183f.b(this);
            }
        }

        public void onError(Throwable th) {
            if (this.f189l) {
                j3.a.r(th);
                return;
            }
            this.f188k = th;
            this.f189l = true;
            j();
        }

        public T poll() {
            return this.f186i.poll();
        }

        public void run() {
            if (this.f192o) {
                g();
            } else {
                h();
            }
        }
    }

    public i0(n<T> nVar, q qVar, boolean z4, int i5) {
        super(nVar);
        this.f179f = qVar;
        this.f180g = z4;
        this.f181h = i5;
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super T> pVar) {
        q qVar = this.f179f;
        if (qVar instanceof o) {
            this.f24e.g(pVar);
            return;
        }
        this.f24e.g(new a(pVar, qVar.a(), this.f180g, this.f181h));
    }
}
