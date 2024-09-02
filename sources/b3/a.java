package b3;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import m2.r;
import m2.t;
import m2.v;
import p2.c;
import v0.f0;

public final class a<T> extends r<T> implements t<T> {

    /* renamed from: j  reason: collision with root package name */
    static final C0053a[] f2972j = new C0053a[0];

    /* renamed from: k  reason: collision with root package name */
    static final C0053a[] f2973k = new C0053a[0];

    /* renamed from: e  reason: collision with root package name */
    final v<? extends T> f2974e;

    /* renamed from: f  reason: collision with root package name */
    final AtomicInteger f2975f = new AtomicInteger();

    /* renamed from: g  reason: collision with root package name */
    final AtomicReference<C0053a<T>[]> f2976g = new AtomicReference<>(f2972j);

    /* renamed from: h  reason: collision with root package name */
    T f2977h;

    /* renamed from: i  reason: collision with root package name */
    Throwable f2978i;

    /* renamed from: b3.a$a  reason: collision with other inner class name */
    static final class C0053a<T> extends AtomicBoolean implements c {

        /* renamed from: e  reason: collision with root package name */
        final t<? super T> f2979e;

        /* renamed from: f  reason: collision with root package name */
        final a<T> f2980f;

        C0053a(t<? super T> tVar, a<T> aVar) {
            this.f2979e = tVar;
            this.f2980f = aVar;
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f2980f.O(this);
            }
        }

        public boolean f() {
            return get();
        }
    }

    public a(v<? extends T> vVar) {
        this.f2974e = vVar;
    }

    /* access modifiers changed from: protected */
    public void D(t<? super T> tVar) {
        C0053a aVar = new C0053a(tVar, this);
        tVar.c(aVar);
        if (N(aVar)) {
            if (aVar.f()) {
                O(aVar);
            }
            if (this.f2975f.getAndIncrement() == 0) {
                this.f2974e.d(this);
                return;
            }
            return;
        }
        Throwable th = this.f2978i;
        if (th != null) {
            tVar.onError(th);
        } else {
            tVar.b(this.f2977h);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean N(C0053a<T> aVar) {
        C0053a[] aVarArr;
        C0053a[] aVarArr2;
        do {
            aVarArr = (C0053a[]) this.f2976g.get();
            if (aVarArr == f2973k) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new C0053a[(length + 1)];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!f0.a(this.f2976g, aVarArr, aVarArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void O(C0053a<T> aVar) {
        C0053a<T>[] aVarArr;
        C0053a[] aVarArr2;
        do {
            aVarArr = (C0053a[]) this.f2976g.get();
            int length = aVarArr.length;
            if (length != 0) {
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
                        aVarArr2 = f2972j;
                    } else {
                        C0053a[] aVarArr3 = new C0053a[(length - 1)];
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
        } while (!f0.a(this.f2976g, aVarArr, aVarArr2));
    }

    public void b(T t5) {
        this.f2977h = t5;
        for (C0053a aVar : (C0053a[]) this.f2976g.getAndSet(f2973k)) {
            if (!aVar.f()) {
                aVar.f2979e.b(t5);
            }
        }
    }

    public void c(c cVar) {
    }

    public void onError(Throwable th) {
        this.f2978i = th;
        for (C0053a aVar : (C0053a[]) this.f2976g.getAndSet(f2973k)) {
            if (!aVar.f()) {
                aVar.f2979e.onError(th);
            }
        }
    }
}
