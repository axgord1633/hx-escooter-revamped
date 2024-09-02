package a3;

import g3.b;
import g3.g;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import l3.d;
import m2.k;
import m2.n;
import m2.p;
import p2.c;
import r2.f;

public final class p0<T> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final f<? super k<Object>, ? extends n<?>> f294f;

    static final class a<T> extends AtomicInteger implements p<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f295e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicInteger f296f = new AtomicInteger();

        /* renamed from: g  reason: collision with root package name */
        final b f297g = new b();

        /* renamed from: h  reason: collision with root package name */
        final d<Object> f298h;

        /* renamed from: i  reason: collision with root package name */
        final a<T>.a f299i = new C0008a();

        /* renamed from: j  reason: collision with root package name */
        final AtomicReference<c> f300j = new AtomicReference<>();

        /* renamed from: k  reason: collision with root package name */
        final n<T> f301k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f302l;

        /* renamed from: a3.p0$a$a  reason: collision with other inner class name */
        final class C0008a extends AtomicReference<c> implements p<Object> {
            C0008a() {
            }

            public void a() {
                a.this.b();
            }

            public void c(c cVar) {
                s2.c.o(this, cVar);
            }

            public void d(Object obj) {
                a.this.g();
            }

            public void onError(Throwable th) {
                a.this.e(th);
            }
        }

        a(p<? super T> pVar, d<Object> dVar, n<T> nVar) {
            this.f295e = pVar;
            this.f298h = dVar;
            this.f301k = nVar;
        }

        public void a() {
            s2.c.l(this.f300j, (c) null);
            this.f302l = false;
            this.f298h.d(0);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            s2.c.c(this.f300j);
            g.a(this.f295e, this, this.f297g);
        }

        public void c(c cVar) {
            s2.c.o(this.f300j, cVar);
        }

        public void d(T t5) {
            g.e(this.f295e, t5, this, this.f297g);
        }

        public void dispose() {
            s2.c.c(this.f300j);
            s2.c.c(this.f299i);
        }

        /* access modifiers changed from: package-private */
        public void e(Throwable th) {
            s2.c.c(this.f300j);
            g.c(this.f295e, th, this, this.f297g);
        }

        public boolean f() {
            return s2.c.i(this.f300j.get());
        }

        /* access modifiers changed from: package-private */
        public void g() {
            h();
        }

        /* access modifiers changed from: package-private */
        public void h() {
            if (this.f296f.getAndIncrement() == 0) {
                while (!f()) {
                    if (!this.f302l) {
                        this.f302l = true;
                        this.f301k.g(this);
                    }
                    if (this.f296f.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void onError(Throwable th) {
            s2.c.c(this.f299i);
            g.c(this.f295e, th, this, this.f297g);
        }
    }

    public p0(n<T> nVar, f<? super k<Object>, ? extends n<?>> fVar) {
        super(nVar);
        this.f294f = fVar;
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super T> pVar) {
        d O0 = l3.b.Q0().O0();
        try {
            n nVar = (n) t2.b.e(this.f294f.apply(O0), "The handler returned a null ObservableSource");
            a aVar = new a(pVar, O0, this.f24e);
            pVar.c(aVar);
            nVar.g(aVar.f299i);
            aVar.h();
        } catch (Throwable th) {
            q2.b.b(th);
            s2.d.m(th, pVar);
        }
    }
}
