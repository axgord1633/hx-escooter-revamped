package a3;

import g3.b;
import g3.g;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import m2.c;
import m2.k;
import m2.p;

public final class g0<T> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final c f154f;

    static final class a<T> extends AtomicInteger implements p<T>, p2.c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f155e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<p2.c> f156f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        final C0005a f157g = new C0005a(this);

        /* renamed from: h  reason: collision with root package name */
        final b f158h = new b();

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f159i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f160j;

        /* renamed from: a3.g0$a$a  reason: collision with other inner class name */
        static final class C0005a extends AtomicReference<p2.c> implements m2.b {

            /* renamed from: e  reason: collision with root package name */
            final a<?> f161e;

            C0005a(a<?> aVar) {
                this.f161e = aVar;
            }

            public void a() {
                this.f161e.b();
            }

            public void c(p2.c cVar) {
                s2.c.o(this, cVar);
            }

            public void onError(Throwable th) {
                this.f161e.e(th);
            }
        }

        a(p<? super T> pVar) {
            this.f155e = pVar;
        }

        public void a() {
            this.f159i = true;
            if (this.f160j) {
                g.a(this.f155e, this, this.f158h);
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f160j = true;
            if (this.f159i) {
                g.a(this.f155e, this, this.f158h);
            }
        }

        public void c(p2.c cVar) {
            s2.c.o(this.f156f, cVar);
        }

        public void d(T t5) {
            g.e(this.f155e, t5, this, this.f158h);
        }

        public void dispose() {
            s2.c.c(this.f156f);
            s2.c.c(this.f157g);
        }

        /* access modifiers changed from: package-private */
        public void e(Throwable th) {
            s2.c.c(this.f156f);
            g.c(this.f155e, th, this, this.f158h);
        }

        public boolean f() {
            return s2.c.i(this.f156f.get());
        }

        public void onError(Throwable th) {
            s2.c.c(this.f157g);
            g.c(this.f155e, th, this, this.f158h);
        }
    }

    public g0(k<T> kVar, c cVar) {
        super(kVar);
        this.f154f = cVar;
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super T> pVar) {
        a aVar = new a(pVar);
        pVar.c(aVar);
        this.f24e.g(aVar);
        this.f154f.b(aVar.f157g);
    }
}
