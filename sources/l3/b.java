package l3;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import m2.p;
import p2.c;
import v0.f0;

public final class b<T> extends d<T> {

    /* renamed from: g  reason: collision with root package name */
    static final a[] f5749g = new a[0];

    /* renamed from: h  reason: collision with root package name */
    static final a[] f5750h = new a[0];

    /* renamed from: e  reason: collision with root package name */
    final AtomicReference<a<T>[]> f5751e = new AtomicReference<>(f5750h);

    /* renamed from: f  reason: collision with root package name */
    Throwable f5752f;

    static final class a<T> extends AtomicBoolean implements c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f5753e;

        /* renamed from: f  reason: collision with root package name */
        final b<T> f5754f;

        a(p<? super T> pVar, b<T> bVar) {
            this.f5753e = pVar;
            this.f5754f = bVar;
        }

        public void a() {
            if (!get()) {
                this.f5753e.a();
            }
        }

        public void b(Throwable th) {
            if (get()) {
                j3.a.r(th);
            } else {
                this.f5753e.onError(th);
            }
        }

        public void c(T t5) {
            if (!get()) {
                this.f5753e.d(t5);
            }
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f5754f.R0(this);
            }
        }

        public boolean f() {
            return get();
        }
    }

    b() {
    }

    public static <T> b<T> Q0() {
        return new b<>();
    }

    /* access modifiers changed from: package-private */
    public boolean P0(a<T> aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = (a[]) this.f5751e.get();
            if (aVarArr == f5749g) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[(length + 1)];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!f0.a(this.f5751e, aVarArr, aVarArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void R0(a<T> aVar) {
        a<T>[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = (a[]) this.f5751e.get();
            if (aVarArr != f5749g && aVarArr != f5750h) {
                int length = aVarArr.length;
                int i5 = -1;
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        break;
                    } else if (aVarArr[i6] == aVar) {
                        i5 = i6;
                        break;
                    } else {
                        i6++;
                    }
                }
                if (i5 >= 0) {
                    if (length == 1) {
                        aVarArr2 = f5750h;
                    } else {
                        a[] aVarArr3 = new a[(length - 1)];
                        System.arraycopy(aVarArr, 0, aVarArr3, 0, i5);
                        System.arraycopy(aVarArr, i5 + 1, aVarArr3, i5, (length - i5) - 1);
                        aVarArr2 = aVarArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!f0.a(this.f5751e, aVarArr, aVarArr2));
    }

    public void a() {
        a<T>[] aVarArr = this.f5751e.get();
        a<T>[] aVarArr2 = f5749g;
        if (aVarArr != aVarArr2) {
            for (a a5 : (a[]) this.f5751e.getAndSet(aVarArr2)) {
                a5.a();
            }
        }
    }

    public void c(c cVar) {
        if (this.f5751e.get() == f5749g) {
            cVar.dispose();
        }
    }

    public void d(T t5) {
        t2.b.e(t5, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (a c5 : (a[]) this.f5751e.get()) {
            c5.c(t5);
        }
    }

    public void onError(Throwable th) {
        t2.b.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        a<T>[] aVarArr = this.f5751e.get();
        a<T>[] aVarArr2 = f5749g;
        if (aVarArr == aVarArr2) {
            j3.a.r(th);
            return;
        }
        this.f5752f = th;
        for (a b5 : (a[]) this.f5751e.getAndSet(aVarArr2)) {
            b5.b(th);
        }
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super T> pVar) {
        a aVar = new a(pVar, this);
        pVar.c(aVar);
        if (!P0(aVar)) {
            Throwable th = this.f5752f;
            if (th != null) {
                pVar.onError(th);
            } else {
                pVar.a();
            }
        } else if (aVar.f()) {
            R0(aVar);
        }
    }
}
