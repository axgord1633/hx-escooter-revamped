package x2;

import f3.f;
import java.util.concurrent.atomic.AtomicInteger;
import m2.g;
import r2.h;
import u4.b;
import u4.c;

public final class i<T> extends a<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final h<? super Throwable> f7682g;

    /* renamed from: h  reason: collision with root package name */
    final long f7683h;

    static final class a<T> extends AtomicInteger implements g<T> {

        /* renamed from: e  reason: collision with root package name */
        final b<? super T> f7684e;

        /* renamed from: f  reason: collision with root package name */
        final f f7685f;

        /* renamed from: g  reason: collision with root package name */
        final u4.a<? extends T> f7686g;

        /* renamed from: h  reason: collision with root package name */
        final h<? super Throwable> f7687h;

        /* renamed from: i  reason: collision with root package name */
        long f7688i;

        /* renamed from: j  reason: collision with root package name */
        long f7689j;

        a(b<? super T> bVar, long j5, h<? super Throwable> hVar, f fVar, u4.a<? extends T> aVar) {
            this.f7684e = bVar;
            this.f7685f = fVar;
            this.f7686g = aVar;
            this.f7687h = hVar;
            this.f7688i = j5;
        }

        public void a() {
            this.f7684e.a();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (getAndIncrement() == 0) {
                int i5 = 1;
                while (!this.f7685f.c()) {
                    long j5 = this.f7689j;
                    if (j5 != 0) {
                        this.f7689j = 0;
                        this.f7685f.d(j5);
                    }
                    this.f7686g.a(this);
                    i5 = addAndGet(-i5);
                    if (i5 == 0) {
                        return;
                    }
                }
            }
        }

        public void d(T t5) {
            this.f7689j++;
            this.f7684e.d(t5);
        }

        public void e(c cVar) {
            this.f7685f.e(cVar);
        }

        public void onError(Throwable th) {
            long j5 = this.f7688i;
            if (j5 != Long.MAX_VALUE) {
                this.f7688i = j5 - 1;
            }
            if (j5 == 0) {
                this.f7684e.onError(th);
                return;
            }
            try {
                if (!this.f7687h.test(th)) {
                    this.f7684e.onError(th);
                } else {
                    b();
                }
            } catch (Throwable th2) {
                q2.b.b(th2);
                this.f7684e.onError(new q2.a(th, th2));
            }
        }
    }

    public i(m2.f<T> fVar, long j5, h<? super Throwable> hVar) {
        super(fVar);
        this.f7682g = hVar;
        this.f7683h = j5;
    }

    public void j(b<? super T> bVar) {
        f fVar = new f(false);
        bVar.e(fVar);
        new a(bVar, this.f7683h, this.f7682g, fVar, this.f7623f).b();
    }
}
