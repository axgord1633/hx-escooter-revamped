package z2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import m2.k;
import m2.p;
import m2.t;
import m2.v;
import p2.c;
import r2.f;
import v0.f0;

public final class b<T, R> extends k<R> {

    /* renamed from: e  reason: collision with root package name */
    final k<T> f7897e;

    /* renamed from: f  reason: collision with root package name */
    final f<? super T, ? extends v<? extends R>> f7898f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f7899g;

    static final class a<T, R> extends AtomicInteger implements p<T>, c {

        /* renamed from: m  reason: collision with root package name */
        static final C0129a<Object> f7900m = new C0129a<>((a) null);

        /* renamed from: e  reason: collision with root package name */
        final p<? super R> f7901e;

        /* renamed from: f  reason: collision with root package name */
        final f<? super T, ? extends v<? extends R>> f7902f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f7903g;

        /* renamed from: h  reason: collision with root package name */
        final g3.b f7904h = new g3.b();

        /* renamed from: i  reason: collision with root package name */
        final AtomicReference<C0129a<R>> f7905i = new AtomicReference<>();

        /* renamed from: j  reason: collision with root package name */
        c f7906j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f7907k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f7908l;

        /* renamed from: z2.b$a$a  reason: collision with other inner class name */
        static final class C0129a<R> extends AtomicReference<c> implements t<R> {

            /* renamed from: e  reason: collision with root package name */
            final a<?, R> f7909e;

            /* renamed from: f  reason: collision with root package name */
            volatile R f7910f;

            C0129a(a<?, R> aVar) {
                this.f7909e = aVar;
            }

            /* access modifiers changed from: package-private */
            public void a() {
                s2.c.c(this);
            }

            public void b(R r5) {
                this.f7910f = r5;
                this.f7909e.e();
            }

            public void c(c cVar) {
                s2.c.o(this, cVar);
            }

            public void onError(Throwable th) {
                this.f7909e.g(this, th);
            }
        }

        a(p<? super R> pVar, f<? super T, ? extends v<? extends R>> fVar, boolean z4) {
            this.f7901e = pVar;
            this.f7902f = fVar;
            this.f7903g = z4;
        }

        public void a() {
            this.f7907k = true;
            e();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            AtomicReference<C0129a<R>> atomicReference = this.f7905i;
            C0129a<Object> aVar = f7900m;
            C0129a<Object> andSet = atomicReference.getAndSet(aVar);
            if (andSet != null && andSet != aVar) {
                andSet.a();
            }
        }

        public void c(c cVar) {
            if (s2.c.q(this.f7906j, cVar)) {
                this.f7906j = cVar;
                this.f7901e.c(this);
            }
        }

        public void d(T t5) {
            C0129a<Object> aVar;
            C0129a aVar2 = this.f7905i.get();
            if (aVar2 != null) {
                aVar2.a();
            }
            try {
                v vVar = (v) t2.b.e(this.f7902f.apply(t5), "The mapper returned a null SingleSource");
                C0129a aVar3 = new C0129a(this);
                do {
                    aVar = this.f7905i.get();
                    if (aVar == f7900m) {
                        return;
                    }
                } while (!f0.a(this.f7905i, aVar, aVar3));
                vVar.d(aVar3);
            } catch (Throwable th) {
                q2.b.b(th);
                this.f7906j.dispose();
                this.f7905i.getAndSet(f7900m);
                onError(th);
            }
        }

        public void dispose() {
            this.f7908l = true;
            this.f7906j.dispose();
            b();
        }

        /* access modifiers changed from: package-private */
        public void e() {
            if (getAndIncrement() == 0) {
                p<? super R> pVar = this.f7901e;
                g3.b bVar = this.f7904h;
                AtomicReference<C0129a<R>> atomicReference = this.f7905i;
                int i5 = 1;
                while (!this.f7908l) {
                    if (bVar.get() == null || this.f7903g) {
                        boolean z4 = this.f7907k;
                        C0129a aVar = atomicReference.get();
                        boolean z5 = aVar == null;
                        if (z4 && z5) {
                            Throwable b5 = bVar.b();
                            if (b5 != null) {
                                pVar.onError(b5);
                                return;
                            } else {
                                pVar.a();
                                return;
                            }
                        } else if (z5 || aVar.f7910f == null) {
                            i5 = addAndGet(-i5);
                            if (i5 == 0) {
                                return;
                            }
                        } else {
                            f0.a(atomicReference, aVar, (Object) null);
                            pVar.d(aVar.f7910f);
                        }
                    } else {
                        pVar.onError(bVar.b());
                        return;
                    }
                }
            }
        }

        public boolean f() {
            return this.f7908l;
        }

        /* access modifiers changed from: package-private */
        public void g(C0129a<R> aVar, Throwable th) {
            if (!f0.a(this.f7905i, aVar, (Object) null) || !this.f7904h.a(th)) {
                j3.a.r(th);
                return;
            }
            if (!this.f7903g) {
                this.f7906j.dispose();
                b();
            }
            e();
        }

        public void onError(Throwable th) {
            if (this.f7904h.a(th)) {
                if (!this.f7903g) {
                    b();
                }
                this.f7907k = true;
                e();
                return;
            }
            j3.a.r(th);
        }
    }

    public b(k<T> kVar, f<? super T, ? extends v<? extends R>> fVar, boolean z4) {
        this.f7897e = kVar;
        this.f7898f = fVar;
        this.f7899g = z4;
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super R> pVar) {
        if (!c.a(this.f7897e, this.f7898f, pVar)) {
            this.f7897e.g(new a(pVar, this.f7898f, this.f7899g));
        }
    }
}
