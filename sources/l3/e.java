package l3;

import c3.c;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import m2.p;
import s2.d;
import u2.i;
import v0.f0;
import v2.b;

public final class e<T> extends d<T> {

    /* renamed from: e  reason: collision with root package name */
    final c<T> f5759e;

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<p<? super T>> f5760f = new AtomicReference<>();

    /* renamed from: g  reason: collision with root package name */
    final AtomicReference<Runnable> f5761g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f5762h;

    /* renamed from: i  reason: collision with root package name */
    volatile boolean f5763i;

    /* renamed from: j  reason: collision with root package name */
    volatile boolean f5764j;

    /* renamed from: k  reason: collision with root package name */
    Throwable f5765k;

    /* renamed from: l  reason: collision with root package name */
    final AtomicBoolean f5766l = new AtomicBoolean();

    /* renamed from: m  reason: collision with root package name */
    final b<T> f5767m = new a();

    /* renamed from: n  reason: collision with root package name */
    boolean f5768n;

    final class a extends b<T> {
        a() {
        }

        public void clear() {
            e.this.f5759e.clear();
        }

        public void dispose() {
            if (!e.this.f5763i) {
                e.this.f5763i = true;
                e.this.Q0();
                e.this.f5760f.lazySet((Object) null);
                if (e.this.f5767m.getAndIncrement() == 0) {
                    e.this.f5760f.lazySet((Object) null);
                    e eVar = e.this;
                    if (!eVar.f5768n) {
                        eVar.f5759e.clear();
                    }
                }
            }
        }

        public boolean f() {
            return e.this.f5763i;
        }

        public int i(int i5) {
            if ((i5 & 2) == 0) {
                return 0;
            }
            e.this.f5768n = true;
            return 2;
        }

        public boolean isEmpty() {
            return e.this.f5759e.isEmpty();
        }

        public T poll() {
            return e.this.f5759e.poll();
        }
    }

    e(int i5, Runnable runnable, boolean z4) {
        this.f5759e = new c<>(t2.b.f(i5, "capacityHint"));
        this.f5761g = new AtomicReference<>(t2.b.e(runnable, "onTerminate"));
        this.f5762h = z4;
    }

    public static <T> e<T> P0(int i5, Runnable runnable) {
        return new e<>(i5, runnable, true);
    }

    /* access modifiers changed from: package-private */
    public void Q0() {
        Runnable runnable = this.f5761g.get();
        if (runnable != null && f0.a(this.f5761g, runnable, (Object) null)) {
            runnable.run();
        }
    }

    /* access modifiers changed from: package-private */
    public void R0() {
        if (this.f5767m.getAndIncrement() == 0) {
            p pVar = this.f5760f.get();
            int i5 = 1;
            while (pVar == null) {
                i5 = this.f5767m.addAndGet(-i5);
                if (i5 != 0) {
                    pVar = this.f5760f.get();
                } else {
                    return;
                }
            }
            if (this.f5768n) {
                S0(pVar);
            } else {
                T0(pVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void S0(p<? super T> pVar) {
        c<T> cVar = this.f5759e;
        int i5 = 1;
        boolean z4 = !this.f5762h;
        while (!this.f5763i) {
            boolean z5 = this.f5764j;
            if (!z4 || !z5 || !V0(cVar, pVar)) {
                pVar.d(null);
                if (z5) {
                    U0(pVar);
                    return;
                }
                i5 = this.f5767m.addAndGet(-i5);
                if (i5 == 0) {
                    return;
                }
            } else {
                return;
            }
        }
        this.f5760f.lazySet((Object) null);
    }

    /* access modifiers changed from: package-private */
    public void T0(p<? super T> pVar) {
        c<T> cVar = this.f5759e;
        boolean z4 = !this.f5762h;
        boolean z5 = true;
        int i5 = 1;
        while (!this.f5763i) {
            boolean z6 = this.f5764j;
            T poll = this.f5759e.poll();
            boolean z7 = poll == null;
            if (z6) {
                if (z4 && z5) {
                    if (!V0(cVar, pVar)) {
                        z5 = false;
                    } else {
                        return;
                    }
                }
                if (z7) {
                    U0(pVar);
                    return;
                }
            }
            if (z7) {
                i5 = this.f5767m.addAndGet(-i5);
                if (i5 == 0) {
                    return;
                }
            } else {
                pVar.d(poll);
            }
        }
        this.f5760f.lazySet((Object) null);
        cVar.clear();
    }

    /* access modifiers changed from: package-private */
    public void U0(p<? super T> pVar) {
        this.f5760f.lazySet((Object) null);
        Throwable th = this.f5765k;
        if (th != null) {
            pVar.onError(th);
        } else {
            pVar.a();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean V0(i<T> iVar, p<? super T> pVar) {
        Throwable th = this.f5765k;
        if (th == null) {
            return false;
        }
        this.f5760f.lazySet((Object) null);
        iVar.clear();
        pVar.onError(th);
        return true;
    }

    public void a() {
        if (!this.f5764j && !this.f5763i) {
            this.f5764j = true;
            Q0();
            R0();
        }
    }

    public void c(p2.c cVar) {
        if (this.f5764j || this.f5763i) {
            cVar.dispose();
        }
    }

    public void d(T t5) {
        t2.b.e(t5, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f5764j && !this.f5763i) {
            this.f5759e.offer(t5);
            R0();
        }
    }

    public void onError(Throwable th) {
        t2.b.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f5764j || this.f5763i) {
            j3.a.r(th);
            return;
        }
        this.f5765k = th;
        this.f5764j = true;
        Q0();
        R0();
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super T> pVar) {
        if (this.f5766l.get() || !this.f5766l.compareAndSet(false, true)) {
            d.m(new IllegalStateException("Only a single observer allowed."), pVar);
            return;
        }
        pVar.c(this.f5767m);
        this.f5760f.lazySet(pVar);
        if (this.f5763i) {
            this.f5760f.lazySet((Object) null);
        } else {
            R0();
        }
    }
}
