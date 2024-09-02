package a3;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import m2.n;
import m2.p;
import r2.f;
import s2.d;

public final class a0<T, K, V> extends a<T, h3.b<K, V>> {

    /* renamed from: f  reason: collision with root package name */
    final f<? super T, ? extends K> f25f;

    /* renamed from: g  reason: collision with root package name */
    final f<? super T, ? extends V> f26g;

    /* renamed from: h  reason: collision with root package name */
    final int f27h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f28i;

    public static final class a<T, K, V> extends AtomicInteger implements p<T>, p2.c {

        /* renamed from: m  reason: collision with root package name */
        static final Object f29m = new Object();

        /* renamed from: e  reason: collision with root package name */
        final p<? super h3.b<K, V>> f30e;

        /* renamed from: f  reason: collision with root package name */
        final f<? super T, ? extends K> f31f;

        /* renamed from: g  reason: collision with root package name */
        final f<? super T, ? extends V> f32g;

        /* renamed from: h  reason: collision with root package name */
        final int f33h;

        /* renamed from: i  reason: collision with root package name */
        final boolean f34i;

        /* renamed from: j  reason: collision with root package name */
        final Map<Object, b<K, V>> f35j;

        /* renamed from: k  reason: collision with root package name */
        p2.c f36k;

        /* renamed from: l  reason: collision with root package name */
        final AtomicBoolean f37l = new AtomicBoolean();

        public a(p<? super h3.b<K, V>> pVar, f<? super T, ? extends K> fVar, f<? super T, ? extends V> fVar2, int i5, boolean z4) {
            this.f30e = pVar;
            this.f31f = fVar;
            this.f32g = fVar2;
            this.f33h = i5;
            this.f34i = z4;
            this.f35j = new ConcurrentHashMap();
            lazySet(1);
        }

        public void a() {
            ArrayList<b> arrayList = new ArrayList<>(this.f35j.values());
            this.f35j.clear();
            for (b a5 : arrayList) {
                a5.a();
            }
            this.f30e.a();
        }

        public void b(K k5) {
            if (k5 == null) {
                k5 = f29m;
            }
            this.f35j.remove(k5);
            if (decrementAndGet() == 0) {
                this.f36k.dispose();
            }
        }

        public void c(p2.c cVar) {
            if (s2.c.q(this.f36k, cVar)) {
                this.f36k = cVar;
                this.f30e.c(this);
            }
        }

        public void d(T t5) {
            try {
                Object apply = this.f31f.apply(t5);
                Object obj = apply != null ? apply : f29m;
                b bVar = this.f35j.get(obj);
                if (bVar == null) {
                    if (!this.f37l.get()) {
                        bVar = b.O0(apply, this.f33h, this, this.f34i);
                        this.f35j.put(obj, bVar);
                        getAndIncrement();
                        this.f30e.d(bVar);
                    } else {
                        return;
                    }
                }
                bVar.d(t2.b.e(this.f32g.apply(t5), "The value supplied is null"));
            } catch (Throwable th) {
                q2.b.b(th);
                this.f36k.dispose();
                onError(th);
            }
        }

        public void dispose() {
            if (this.f37l.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.f36k.dispose();
            }
        }

        public boolean f() {
            return this.f37l.get();
        }

        public void onError(Throwable th) {
            ArrayList<b> arrayList = new ArrayList<>(this.f35j.values());
            this.f35j.clear();
            for (b onError : arrayList) {
                onError.onError(th);
            }
            this.f30e.onError(th);
        }
    }

    static final class b<K, T> extends h3.b<K, T> {

        /* renamed from: f  reason: collision with root package name */
        final c<T, K> f38f;

        protected b(K k5, c<T, K> cVar) {
            super(k5);
            this.f38f = cVar;
        }

        public static <T, K> b<K, T> O0(K k5, int i5, a<?, K, T> aVar, boolean z4) {
            return new b<>(k5, new c(i5, aVar, k5, z4));
        }

        public void a() {
            this.f38f.c();
        }

        public void d(T t5) {
            this.f38f.e(t5);
        }

        public void onError(Throwable th) {
            this.f38f.d(th);
        }

        /* access modifiers changed from: protected */
        public void v0(p<? super T> pVar) {
            this.f38f.g(pVar);
        }
    }

    static final class c<T, K> extends AtomicInteger implements p2.c, n<T> {

        /* renamed from: e  reason: collision with root package name */
        final K f39e;

        /* renamed from: f  reason: collision with root package name */
        final c3.c<T> f40f;

        /* renamed from: g  reason: collision with root package name */
        final a<?, K, T> f41g;

        /* renamed from: h  reason: collision with root package name */
        final boolean f42h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f43i;

        /* renamed from: j  reason: collision with root package name */
        Throwable f44j;

        /* renamed from: k  reason: collision with root package name */
        final AtomicBoolean f45k = new AtomicBoolean();

        /* renamed from: l  reason: collision with root package name */
        final AtomicBoolean f46l = new AtomicBoolean();

        /* renamed from: m  reason: collision with root package name */
        final AtomicReference<p<? super T>> f47m = new AtomicReference<>();

        c(int i5, a<?, K, T> aVar, K k5, boolean z4) {
            this.f40f = new c3.c<>(i5);
            this.f41g = aVar;
            this.f39e = k5;
            this.f42h = z4;
        }

        /* access modifiers changed from: package-private */
        public boolean a(boolean z4, boolean z5, p<? super T> pVar, boolean z6) {
            if (this.f45k.get()) {
                this.f40f.clear();
                this.f41g.b(this.f39e);
                this.f47m.lazySet((Object) null);
                return true;
            } else if (!z4) {
                return false;
            } else {
                if (!z6) {
                    Throwable th = this.f44j;
                    if (th != null) {
                        this.f40f.clear();
                        this.f47m.lazySet((Object) null);
                        pVar.onError(th);
                        return true;
                    } else if (!z5) {
                        return false;
                    } else {
                        this.f47m.lazySet((Object) null);
                        pVar.a();
                        return true;
                    }
                } else if (!z5) {
                    return false;
                } else {
                    Throwable th2 = this.f44j;
                    this.f47m.lazySet((Object) null);
                    if (th2 != null) {
                        pVar.onError(th2);
                    } else {
                        pVar.a();
                    }
                    return true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (getAndIncrement() == 0) {
                c3.c<T> cVar = this.f40f;
                boolean z4 = this.f42h;
                p pVar = this.f47m.get();
                int i5 = 1;
                while (true) {
                    if (pVar != null) {
                        while (true) {
                            boolean z5 = this.f43i;
                            T poll = cVar.poll();
                            boolean z6 = poll == null;
                            if (!a(z5, z6, pVar, z4)) {
                                if (z6) {
                                    break;
                                }
                                pVar.d(poll);
                            } else {
                                return;
                            }
                        }
                    }
                    i5 = addAndGet(-i5);
                    if (i5 != 0) {
                        if (pVar == null) {
                            pVar = this.f47m.get();
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public void c() {
            this.f43i = true;
            b();
        }

        public void d(Throwable th) {
            this.f44j = th;
            this.f43i = true;
            b();
        }

        public void dispose() {
            if (this.f45k.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.f47m.lazySet((Object) null);
                this.f41g.b(this.f39e);
            }
        }

        public void e(T t5) {
            this.f40f.offer(t5);
            b();
        }

        public boolean f() {
            return this.f45k.get();
        }

        public void g(p<? super T> pVar) {
            if (this.f46l.compareAndSet(false, true)) {
                pVar.c(this);
                this.f47m.lazySet(pVar);
                if (this.f45k.get()) {
                    this.f47m.lazySet((Object) null);
                } else {
                    b();
                }
            } else {
                d.m(new IllegalStateException("Only one Observer allowed!"), pVar);
            }
        }
    }

    public a0(n<T> nVar, f<? super T, ? extends K> fVar, f<? super T, ? extends V> fVar2, int i5, boolean z4) {
        super(nVar);
        this.f25f = fVar;
        this.f26g = fVar2;
        this.f27h = i5;
        this.f28i = z4;
    }

    public void v0(p<? super h3.b<K, V>> pVar) {
        this.f24e.g(new a(pVar, this.f25f, this.f26g, this.f27h, this.f28i));
    }
}
