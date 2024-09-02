package a3;

import m2.k;
import m2.p;
import t2.b;
import v2.c;

public final class x<T> extends k<T> {

    /* renamed from: e  reason: collision with root package name */
    final T[] f430e;

    static final class a<T> extends c<T> {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f431e;

        /* renamed from: f  reason: collision with root package name */
        final T[] f432f;

        /* renamed from: g  reason: collision with root package name */
        int f433g;

        /* renamed from: h  reason: collision with root package name */
        boolean f434h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f435i;

        a(p<? super T> pVar, T[] tArr) {
            this.f431e = pVar;
            this.f432f = tArr;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            T[] tArr = this.f432f;
            int length = tArr.length;
            for (int i5 = 0; i5 < length && !f(); i5++) {
                T t5 = tArr[i5];
                if (t5 == null) {
                    p<? super T> pVar = this.f431e;
                    pVar.onError(new NullPointerException("The element at index " + i5 + " is null"));
                    return;
                }
                this.f431e.d(t5);
            }
            if (!f()) {
                this.f431e.a();
            }
        }

        public void clear() {
            this.f433g = this.f432f.length;
        }

        public void dispose() {
            this.f435i = true;
        }

        public boolean f() {
            return this.f435i;
        }

        public int i(int i5) {
            if ((i5 & 1) == 0) {
                return 0;
            }
            this.f434h = true;
            return 1;
        }

        public boolean isEmpty() {
            return this.f433g == this.f432f.length;
        }

        public T poll() {
            int i5 = this.f433g;
            T[] tArr = this.f432f;
            if (i5 == tArr.length) {
                return null;
            }
            this.f433g = i5 + 1;
            return b.e(tArr[i5], "The array element is null");
        }
    }

    public x(T[] tArr) {
        this.f430e = tArr;
    }

    public void v0(p<? super T> pVar) {
        a aVar = new a(pVar, this.f430e);
        pVar.c(aVar);
        if (!aVar.f434h) {
            aVar.b();
        }
    }
}
