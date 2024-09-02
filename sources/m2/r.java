package m2;

import b3.c;
import b3.d;
import b3.g;
import b3.i;
import b3.j;
import b3.k;
import b3.m;
import b3.n;
import b3.o;
import b3.p;
import b3.q;
import b3.s;
import b3.t;
import j3.a;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import r2.e;
import r2.h;
import t2.b;
import x2.f;
import x2.l;

public abstract class r<T> implements v<T> {
    private r<T> G(long j5, TimeUnit timeUnit, q qVar, v<? extends T> vVar) {
        b.e(timeUnit, "unit is null");
        b.e(qVar, "scheduler is null");
        return a.p(new q(this, j5, timeUnit, qVar, vVar));
    }

    public static r<Long> H(long j5, TimeUnit timeUnit) {
        return I(j5, timeUnit, k3.a.a());
    }

    public static r<Long> I(long j5, TimeUnit timeUnit, q qVar) {
        b.e(timeUnit, "unit is null");
        b.e(qVar, "scheduler is null");
        return a.p(new b3.r(j5, timeUnit, qVar));
    }

    private static <T> r<T> L(f<T> fVar) {
        return a.p(new l(fVar, null));
    }

    public static <T> r<T> M(v<T> vVar) {
        b.e(vVar, "source is null");
        return vVar instanceof r ? a.p((r) vVar) : a.p(new b3.l(vVar));
    }

    public static <T> r<T> h(u<T> uVar) {
        b.e(uVar, "source is null");
        return a.p(new b3.b(uVar));
    }

    public static <T> r<T> i(Callable<? extends v<? extends T>> callable) {
        b.e(callable, "singleSupplier is null");
        return a.p(new c(callable));
    }

    public static <T> r<T> o(Throwable th) {
        b.e(th, "exception is null");
        return p(t2.a.f(th));
    }

    public static <T> r<T> p(Callable<? extends Throwable> callable) {
        b.e(callable, "errorSupplier is null");
        return a.p(new i(callable));
    }

    public static <T> r<T> t(Callable<? extends T> callable) {
        b.e(callable, "callable is null");
        return a.p(new k(callable));
    }

    public static <T> r<T> u(T t5) {
        b.e(t5, "item is null");
        return a.p(new n(t5));
    }

    public static <T> f<T> w(v<? extends T> vVar, v<? extends T> vVar2) {
        b.e(vVar, "source1 is null");
        b.e(vVar2, "source2 is null");
        return x(f.f(vVar, vVar2));
    }

    public static <T> f<T> x(u4.a<? extends v<? extends T>> aVar) {
        b.e(aVar, "sources is null");
        return a.m(new f(aVar, m.a(), false, Integer.MAX_VALUE, f.b()));
    }

    public final r<T> A(long j5, h<? super Throwable> hVar) {
        return L(J().h(j5, hVar));
    }

    public final p2.c B() {
        return C(t2.a.d(), t2.a.f7037f);
    }

    public final p2.c C(e<? super T> eVar, e<? super Throwable> eVar2) {
        b.e(eVar, "onSuccess is null");
        b.e(eVar2, "onError is null");
        v2.e eVar3 = new v2.e(eVar, eVar2);
        d(eVar3);
        return eVar3;
    }

    /* access modifiers changed from: protected */
    public abstract void D(t<? super T> tVar);

    public final <E extends t<? super T>> E E(E e5) {
        d(e5);
        return e5;
    }

    public final r<T> F(long j5, TimeUnit timeUnit, q qVar, v<? extends T> vVar) {
        b.e(vVar, "other is null");
        return G(j5, timeUnit, qVar, vVar);
    }

    public final f<T> J() {
        return this instanceof u2.b ? ((u2.b) this).e() : a.m(new s(this));
    }

    public final k<T> K() {
        return this instanceof u2.c ? ((u2.c) this).a() : a.o(new t(this));
    }

    public final void d(t<? super T> tVar) {
        b.e(tVar, "observer is null");
        t<? super Object> x4 = a.x(this, tVar);
        b.e(x4, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            D(x4);
        } catch (NullPointerException e5) {
            throw e5;
        } catch (Throwable th) {
            q2.b.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final r<T> f() {
        return a.p(new b3.a(this));
    }

    public final <R> r<R> g(w<? super T, ? extends R> wVar) {
        return M(((w) b.e(wVar, "transformer is null")).a(this));
    }

    public final <U> r<T> j(n<U> nVar) {
        b.e(nVar, "other is null");
        return a.p(new d(this, nVar));
    }

    public final r<T> k(r2.a aVar) {
        b.e(aVar, "onFinally is null");
        return a.p(new b3.e(this, aVar));
    }

    public final r<T> l(e<? super Throwable> eVar) {
        b.e(eVar, "onError is null");
        return a.p(new b3.f(this, eVar));
    }

    public final r<T> m(e<? super p2.c> eVar) {
        b.e(eVar, "onSubscribe is null");
        return a.p(new g(this, eVar));
    }

    public final r<T> n(e<? super T> eVar) {
        b.e(eVar, "onSuccess is null");
        return a.p(new b3.h(this, eVar));
    }

    public final h<T> q(h<? super T> hVar) {
        b.e(hVar, "predicate is null");
        return a.n(new y2.c(this, hVar));
    }

    public final <R> r<R> r(r2.f<? super T, ? extends v<? extends R>> fVar) {
        b.e(fVar, "mapper is null");
        return a.p(new j(this, fVar));
    }

    public final <R> k<R> s(r2.f<? super T, ? extends n<? extends R>> fVar) {
        b.e(fVar, "mapper is null");
        return a.o(new z2.d(this, fVar));
    }

    public final <R> r<R> v(r2.f<? super T, ? extends R> fVar) {
        b.e(fVar, "mapper is null");
        return a.p(new o(this, fVar));
    }

    public final f<T> y(v<? extends T> vVar) {
        return w(this, vVar);
    }

    public final r<T> z(q qVar) {
        b.e(qVar, "scheduler is null");
        return a.p(new p(this, qVar));
    }
}
