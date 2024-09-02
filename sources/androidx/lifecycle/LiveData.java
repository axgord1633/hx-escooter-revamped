package androidx.lifecycle;

import androidx.lifecycle.f;
import java.util.Map;

public abstract class LiveData<T> {

    /* renamed from: k  reason: collision with root package name */
    static final Object f2525k = new Object();

    /* renamed from: a  reason: collision with root package name */
    final Object f2526a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private k.b<p<? super T>, LiveData<T>.c> f2527b = new k.b<>();

    /* renamed from: c  reason: collision with root package name */
    int f2528c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2529d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Object f2530e;

    /* renamed from: f  reason: collision with root package name */
    volatile Object f2531f;

    /* renamed from: g  reason: collision with root package name */
    private int f2532g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2533h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2534i;

    /* renamed from: j  reason: collision with root package name */
    private final Runnable f2535j;

    class LifecycleBoundObserver extends LiveData<T>.c implements h {

        /* renamed from: i  reason: collision with root package name */
        final j f2536i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ LiveData f2537j;

        public void a(j jVar, f.a aVar) {
            f.b b5 = this.f2536i.getLifecycle().b();
            if (b5 == f.b.DESTROYED) {
                this.f2537j.h(this.f2540e);
                return;
            }
            f.b bVar = null;
            while (bVar != b5) {
                b(d());
                bVar = b5;
                b5 = this.f2536i.getLifecycle().b();
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f2536i.getLifecycle().c(this);
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            return this.f2536i.getLifecycle().b().f(f.b.STARTED);
        }
    }

    class a implements Runnable {
        a() {
        }

        public void run() {
            Object obj;
            synchronized (LiveData.this.f2526a) {
                obj = LiveData.this.f2531f;
                LiveData.this.f2531f = LiveData.f2525k;
            }
            LiveData.this.i(obj);
        }
    }

    private class b extends LiveData<T>.c {
        b(p<? super T> pVar) {
            super(pVar);
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            return true;
        }
    }

    private abstract class c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f2540e;

        /* renamed from: f  reason: collision with root package name */
        boolean f2541f;

        /* renamed from: g  reason: collision with root package name */
        int f2542g = -1;

        c(p<? super T> pVar) {
            this.f2540e = pVar;
        }

        /* access modifiers changed from: package-private */
        public void b(boolean z4) {
            if (z4 != this.f2541f) {
                this.f2541f = z4;
                LiveData.this.b(z4 ? 1 : -1);
                if (this.f2541f) {
                    LiveData.this.d(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
        }

        /* access modifiers changed from: package-private */
        public abstract boolean d();
    }

    public LiveData() {
        Object obj = f2525k;
        this.f2531f = obj;
        this.f2535j = new a();
        this.f2530e = obj;
        this.f2532g = -1;
    }

    static void a(String str) {
        if (!j.c.f().b()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }

    private void c(LiveData<T>.c cVar) {
        if (cVar.f2541f) {
            if (!cVar.d()) {
                cVar.b(false);
                return;
            }
            int i5 = cVar.f2542g;
            int i6 = this.f2532g;
            if (i5 < i6) {
                cVar.f2542g = i6;
                cVar.f2540e.a(this.f2530e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i5) {
        int i6 = this.f2528c;
        this.f2528c = i5 + i6;
        if (!this.f2529d) {
            this.f2529d = true;
            while (true) {
                try {
                    int i7 = this.f2528c;
                    if (i6 != i7) {
                        boolean z4 = i6 == 0 && i7 > 0;
                        boolean z5 = i6 > 0 && i7 == 0;
                        if (z4) {
                            f();
                        } else if (z5) {
                            g();
                        }
                        i6 = i7;
                    } else {
                        return;
                    }
                } finally {
                    this.f2529d = false;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(LiveData<T>.c cVar) {
        if (this.f2533h) {
            this.f2534i = true;
            return;
        }
        this.f2533h = true;
        do {
            this.f2534i = false;
            if (cVar == null) {
                k.b<K, V>.d f5 = this.f2527b.f();
                while (f5.hasNext()) {
                    c((c) ((Map.Entry) f5.next()).getValue());
                    if (this.f2534i) {
                        break;
                    }
                }
            } else {
                c(cVar);
                cVar = null;
            }
        } while (this.f2534i);
        this.f2533h = false;
    }

    public void e(p<? super T> pVar) {
        a("observeForever");
        b bVar = new b(pVar);
        c m5 = this.f2527b.m(pVar, bVar);
        if (m5 instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (m5 == null) {
            bVar.b(true);
        }
    }

    /* access modifiers changed from: protected */
    public void f() {
    }

    /* access modifiers changed from: protected */
    public void g() {
    }

    public void h(p<? super T> pVar) {
        a("removeObserver");
        c n5 = this.f2527b.n(pVar);
        if (n5 != null) {
            n5.c();
            n5.b(false);
        }
    }

    /* access modifiers changed from: protected */
    public void i(T t5) {
        a("setValue");
        this.f2532g++;
        this.f2530e = t5;
        d((LiveData<T>.c) null);
    }
}
