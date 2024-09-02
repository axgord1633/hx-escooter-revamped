package x2;

import m2.f;

public final class g<T> extends f<T> {

    /* renamed from: f  reason: collision with root package name */
    final T[] f7675f;

    static final class a<T> extends c<T> {

        /* renamed from: h  reason: collision with root package name */
        final u2.a<? super T> f7676h;

        a(u2.a<? super T> aVar, T[] tArr) {
            super(tArr);
            this.f7676h = aVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            T[] tArr = this.f7678e;
            int length = tArr.length;
            u2.a<? super T> aVar = this.f7676h;
            int i5 = this.f7679f;
            while (i5 != length) {
                if (!this.f7680g) {
                    T t5 = tArr[i5];
                    if (t5 == null) {
                        aVar.onError(new NullPointerException("The element at index " + i5 + " is null"));
                        return;
                    }
                    aVar.g(t5);
                    i5++;
                } else {
                    return;
                }
            }
            if (!this.f7680g) {
                aVar.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(long j5) {
            T[] tArr = this.f7678e;
            int length = tArr.length;
            int i5 = this.f7679f;
            u2.a<? super T> aVar = this.f7676h;
            do {
                long j6 = 0;
                while (true) {
                    if (j6 == j5 || i5 == length) {
                        if (i5 != length) {
                            j5 = get();
                            if (j6 == j5) {
                                this.f7679f = i5;
                                j5 = addAndGet(-j6);
                            }
                        } else if (!this.f7680g) {
                            aVar.a();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.f7680g) {
                        T t5 = tArr[i5];
                        if (t5 == null) {
                            aVar.onError(new NullPointerException("The element at index " + i5 + " is null"));
                            return;
                        }
                        if (aVar.g(t5)) {
                            j6++;
                        }
                        i5++;
                    } else {
                        return;
                    }
                }
            } while (j5 != 0);
        }
    }

    static final class b<T> extends c<T> {

        /* renamed from: h  reason: collision with root package name */
        final u4.b<? super T> f7677h;

        b(u4.b<? super T> bVar, T[] tArr) {
            super(tArr);
            this.f7677h = bVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            T[] tArr = this.f7678e;
            int length = tArr.length;
            u4.b<? super T> bVar = this.f7677h;
            int i5 = this.f7679f;
            while (i5 != length) {
                if (!this.f7680g) {
                    T t5 = tArr[i5];
                    if (t5 == null) {
                        bVar.onError(new NullPointerException("The element at index " + i5 + " is null"));
                        return;
                    }
                    bVar.d(t5);
                    i5++;
                } else {
                    return;
                }
            }
            if (!this.f7680g) {
                bVar.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(long j5) {
            T[] tArr = this.f7678e;
            int length = tArr.length;
            int i5 = this.f7679f;
            u4.b<? super T> bVar = this.f7677h;
            do {
                long j6 = 0;
                while (true) {
                    if (j6 == j5 || i5 == length) {
                        if (i5 != length) {
                            j5 = get();
                            if (j6 == j5) {
                                this.f7679f = i5;
                                j5 = addAndGet(-j6);
                            }
                        } else if (!this.f7680g) {
                            bVar.a();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.f7680g) {
                        T t5 = tArr[i5];
                        if (t5 == null) {
                            bVar.onError(new NullPointerException("The element at index " + i5 + " is null"));
                            return;
                        }
                        bVar.d(t5);
                        j6++;
                        i5++;
                    } else {
                        return;
                    }
                }
            } while (j5 != 0);
        }
    }

    static abstract class c<T> extends f3.b<T> {

        /* renamed from: e  reason: collision with root package name */
        final T[] f7678e;

        /* renamed from: f  reason: collision with root package name */
        int f7679f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f7680g;

        c(T[] tArr) {
            this.f7678e = tArr;
        }

        /* access modifiers changed from: package-private */
        public abstract void a();

        /* access modifiers changed from: package-private */
        public abstract void b(long j5);

        public final void cancel() {
            this.f7680g = true;
        }

        public final void clear() {
            this.f7679f = this.f7678e.length;
        }

        public final void f(long j5) {
            if (f3.g.p(j5) && g3.c.a(this, j5) == 0) {
                if (j5 == Long.MAX_VALUE) {
                    a();
                } else {
                    b(j5);
                }
            }
        }

        public final int i(int i5) {
            return i5 & 1;
        }

        public final boolean isEmpty() {
            return this.f7679f == this.f7678e.length;
        }

        public final T poll() {
            int i5 = this.f7679f;
            T[] tArr = this.f7678e;
            if (i5 == tArr.length) {
                return null;
            }
            this.f7679f = i5 + 1;
            return t2.b.e(tArr[i5], "array element is null");
        }
    }

    public g(T[] tArr) {
        this.f7675f = tArr;
    }

    public void j(u4.b<? super T> bVar) {
        bVar.e(bVar instanceof u2.a ? new a((u2.a) bVar, this.f7675f) : new b(bVar, this.f7675f));
    }
}
