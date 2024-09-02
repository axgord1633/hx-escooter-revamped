package o1;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import m2.p;
import v0.f0;

public final class c<T> extends d<T> {

    /* renamed from: f  reason: collision with root package name */
    static final a[] f6135f = new a[0];

    /* renamed from: e  reason: collision with root package name */
    final AtomicReference<a<T>[]> f6136e = new AtomicReference<>(f6135f);

    static final class a<T> extends AtomicBoolean implements p2.c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f6137e;

        /* renamed from: f  reason: collision with root package name */
        final c<T> f6138f;

        a(p<? super T> pVar, c<T> cVar) {
            this.f6137e = pVar;
            this.f6138f = cVar;
        }

        public void a(T t5) {
            if (!get()) {
                this.f6137e.d(t5);
            }
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f6138f.S0(this);
            }
        }

        public boolean f() {
            return get();
        }
    }

    c() {
    }

    public static <T> c<T> R0() {
        return new c<>();
    }

    public boolean O0() {
        return ((a[]) this.f6136e.get()).length != 0;
    }

    /* access modifiers changed from: package-private */
    public void Q0(a<T> aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = (a[]) this.f6136e.get();
            int length = aVarArr.length;
            aVarArr2 = new a[(length + 1)];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!f0.a(this.f6136e, aVarArr, aVarArr2));
    }

    /* access modifiers changed from: package-private */
    public void S0(a<T> aVar) {
        a<T>[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = (a[]) this.f6136e.get();
            if (aVarArr != f6135f) {
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
                        aVarArr2 = f6135f;
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
        } while (!f0.a(this.f6136e, aVarArr, aVarArr2));
    }

    public void accept(T t5) {
        if (t5 != null) {
            for (a a5 : (a[]) this.f6136e.get()) {
                a5.a(t5);
            }
            return;
        }
        throw new NullPointerException("value == null");
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super T> pVar) {
        a aVar = new a(pVar, this);
        pVar.c(aVar);
        Q0(aVar);
        if (aVar.f()) {
            S0(aVar);
        }
    }
}
