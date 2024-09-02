package a3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import m2.k;
import m2.n;
import m2.p;
import p2.c;
import s2.d;

public final class b<T> extends k<T> {

    /* renamed from: e  reason: collision with root package name */
    final n<? extends T>[] f63e;

    /* renamed from: f  reason: collision with root package name */
    final Iterable<? extends n<? extends T>> f64f;

    static final class a<T> implements c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f65e;

        /* renamed from: f  reason: collision with root package name */
        final C0002b<T>[] f66f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicInteger f67g = new AtomicInteger();

        a(p<? super T> pVar, int i5) {
            this.f65e = pVar;
            this.f66f = new C0002b[i5];
        }

        public void a(n<? extends T>[] nVarArr) {
            C0002b<T>[] bVarArr = this.f66f;
            int length = bVarArr.length;
            int i5 = 0;
            while (i5 < length) {
                int i6 = i5 + 1;
                bVarArr[i5] = new C0002b<>(this, i6, this.f65e);
                i5 = i6;
            }
            this.f67g.lazySet(0);
            this.f65e.c(this);
            for (int i7 = 0; i7 < length && this.f67g.get() == 0; i7++) {
                nVarArr[i7].g(bVarArr[i7]);
            }
        }

        public boolean b(int i5) {
            int i6 = this.f67g.get();
            int i7 = 0;
            if (i6 != 0) {
                return i6 == i5;
            }
            if (!this.f67g.compareAndSet(0, i5)) {
                return false;
            }
            C0002b<T>[] bVarArr = this.f66f;
            int length = bVarArr.length;
            while (i7 < length) {
                int i8 = i7 + 1;
                if (i8 != i5) {
                    bVarArr[i7].b();
                }
                i7 = i8;
            }
            return true;
        }

        public void dispose() {
            if (this.f67g.get() != -1) {
                this.f67g.lazySet(-1);
                for (C0002b<T> b5 : this.f66f) {
                    b5.b();
                }
            }
        }

        public boolean f() {
            return this.f67g.get() == -1;
        }
    }

    /* renamed from: a3.b$b  reason: collision with other inner class name */
    static final class C0002b<T> extends AtomicReference<c> implements p<T> {

        /* renamed from: e  reason: collision with root package name */
        final a<T> f68e;

        /* renamed from: f  reason: collision with root package name */
        final int f69f;

        /* renamed from: g  reason: collision with root package name */
        final p<? super T> f70g;

        /* renamed from: h  reason: collision with root package name */
        boolean f71h;

        C0002b(a<T> aVar, int i5, p<? super T> pVar) {
            this.f68e = aVar;
            this.f69f = i5;
            this.f70g = pVar;
        }

        public void a() {
            if (!this.f71h) {
                if (this.f68e.b(this.f69f)) {
                    this.f71h = true;
                } else {
                    return;
                }
            }
            this.f70g.a();
        }

        public void b() {
            s2.c.c(this);
        }

        public void c(c cVar) {
            s2.c.o(this, cVar);
        }

        public void d(T t5) {
            if (!this.f71h) {
                if (this.f68e.b(this.f69f)) {
                    this.f71h = true;
                } else {
                    ((c) get()).dispose();
                    return;
                }
            }
            this.f70g.d(t5);
        }

        public void onError(Throwable th) {
            if (!this.f71h) {
                if (this.f68e.b(this.f69f)) {
                    this.f71h = true;
                } else {
                    j3.a.r(th);
                    return;
                }
            }
            this.f70g.onError(th);
        }
    }

    public b(n<? extends T>[] nVarArr, Iterable<? extends n<? extends T>> iterable) {
        this.f63e = nVarArr;
        this.f64f = iterable;
    }

    public void v0(p<? super T> pVar) {
        int i5;
        n<? extends T>[] nVarArr = this.f63e;
        if (nVarArr == null) {
            nVarArr = new n[8];
            try {
                i5 = 0;
                for (n<? extends T> nVar : this.f64f) {
                    if (nVar == null) {
                        d.m(new NullPointerException("One of the sources is null"), pVar);
                        return;
                    }
                    if (i5 == nVarArr.length) {
                        n<? extends T>[] nVarArr2 = new n[((i5 >> 2) + i5)];
                        System.arraycopy(nVarArr, 0, nVarArr2, 0, i5);
                        nVarArr = nVarArr2;
                    }
                    int i6 = i5 + 1;
                    nVarArr[i5] = nVar;
                    i5 = i6;
                }
            } catch (Throwable th) {
                q2.b.b(th);
                d.m(th, pVar);
                return;
            }
        } else {
            i5 = nVarArr.length;
        }
        if (i5 == 0) {
            d.c(pVar);
        } else if (i5 == 1) {
            nVarArr[0].g(pVar);
        } else {
            new a(pVar, i5).a(nVarArr);
        }
    }
}
