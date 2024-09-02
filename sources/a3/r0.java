package a3;

import java.util.concurrent.atomic.AtomicInteger;
import m2.k;
import m2.n;
import m2.p;
import p2.c;
import q2.b;
import r2.h;
import s2.g;

public final class r0<T> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final h<? super Throwable> f343f;

    /* renamed from: g  reason: collision with root package name */
    final long f344g;

    static final class a<T> extends AtomicInteger implements p<T> {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f345e;

        /* renamed from: f  reason: collision with root package name */
        final g f346f;

        /* renamed from: g  reason: collision with root package name */
        final n<? extends T> f347g;

        /* renamed from: h  reason: collision with root package name */
        final h<? super Throwable> f348h;

        /* renamed from: i  reason: collision with root package name */
        long f349i;

        a(p<? super T> pVar, long j5, h<? super Throwable> hVar, g gVar, n<? extends T> nVar) {
            this.f345e = pVar;
            this.f346f = gVar;
            this.f347g = nVar;
            this.f348h = hVar;
            this.f349i = j5;
        }

        public void a() {
            this.f345e.a();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (getAndIncrement() == 0) {
                int i5 = 1;
                while (!this.f346f.f()) {
                    this.f347g.g(this);
                    i5 = addAndGet(-i5);
                    if (i5 == 0) {
                        return;
                    }
                }
            }
        }

        public void c(c cVar) {
            this.f346f.a(cVar);
        }

        public void d(T t5) {
            this.f345e.d(t5);
        }

        public void onError(Throwable th) {
            long j5 = this.f349i;
            if (j5 != Long.MAX_VALUE) {
                this.f349i = j5 - 1;
            }
            if (j5 == 0) {
                this.f345e.onError(th);
                return;
            }
            try {
                if (!this.f348h.test(th)) {
                    this.f345e.onError(th);
                } else {
                    b();
                }
            } catch (Throwable th2) {
                b.b(th2);
                this.f345e.onError(new q2.a(th, th2));
            }
        }
    }

    public r0(k<T> kVar, long j5, h<? super Throwable> hVar) {
        super(kVar);
        this.f343f = hVar;
        this.f344g = j5;
    }

    public void v0(p<? super T> pVar) {
        g gVar = new g();
        pVar.c(gVar);
        new a(pVar, this.f344g, this.f343f, gVar, this.f24e).b();
    }
}
