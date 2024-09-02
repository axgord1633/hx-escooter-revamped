package m2;

import a3.a0;
import a3.a1;
import a3.c0;
import a3.d;
import a3.d0;
import a3.d1;
import a3.e0;
import a3.e1;
import a3.f0;
import a3.f1;
import a3.g;
import a3.g0;
import a3.h0;
import a3.i;
import a3.i0;
import a3.j;
import a3.j0;
import a3.k0;
import a3.l;
import a3.m;
import a3.n;
import a3.n0;
import a3.o;
import a3.p0;
import a3.q;
import a3.q0;
import a3.r;
import a3.r0;
import a3.s;
import a3.s0;
import a3.t;
import a3.t0;
import a3.u;
import a3.u0;
import a3.v;
import a3.v0;
import a3.w;
import a3.w0;
import a3.x;
import a3.x0;
import a3.y;
import a3.y0;
import a3.z;
import a3.z0;
import g3.e;
import j3.a;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import p2.c;
import r2.f;
import r2.h;
import t2.b;

public abstract class k<T> implements n<T> {
    public static <T> k<T> F() {
        return a.o(s.f350e);
    }

    public static <T> k<T> G(Throwable th) {
        b.e(th, "exception is null");
        return H(t2.a.f(th));
    }

    public static <T> k<T> H(Callable<? extends Throwable> callable) {
        b.e(callable, "errorSupplier is null");
        return a.o(new t(callable));
    }

    private <U, V> k<T> H0(n<U> nVar, f<? super T, ? extends n<V>> fVar, n<? extends T> nVar2) {
        b.e(fVar, "itemTimeoutIndicator is null");
        return a.o(new a1(this, nVar, fVar, nVar2));
    }

    public static k<Long> I0(long j5, TimeUnit timeUnit) {
        return J0(j5, timeUnit, k3.a.a());
    }

    public static k<Long> J0(long j5, TimeUnit timeUnit, q qVar) {
        b.e(timeUnit, "unit is null");
        b.e(qVar, "scheduler is null");
        return a.o(new d1(Math.max(j5, 0), timeUnit, qVar));
    }

    public static <T> k<T> N0(n<T> nVar) {
        b.e(nVar, "source is null");
        return nVar instanceof k ? a.o((k) nVar) : a.o(new z(nVar));
    }

    public static <T> k<T> S(T... tArr) {
        b.e(tArr, "items is null");
        return tArr.length == 0 ? F() : tArr.length == 1 ? Y(tArr[0]) : a.o(new x(tArr));
    }

    public static <T> k<T> T(Callable<? extends T> callable) {
        b.e(callable, "supplier is null");
        return a.o(new y(callable));
    }

    public static k<Long> X(long j5, long j6, TimeUnit timeUnit, q qVar) {
        b.e(timeUnit, "unit is null");
        b.e(qVar, "scheduler is null");
        return a.o(new d0(Math.max(0, j5), Math.max(0, j6), timeUnit, qVar));
    }

    public static <T> k<T> Y(T t5) {
        b.e(t5, "item is null");
        return a.o(new e0(t5));
    }

    public static <T> k<T> a0(n<? extends T> nVar, n<? extends T> nVar2) {
        b.e(nVar, "source1 is null");
        b.e(nVar2, "source2 is null");
        return S(nVar, nVar2).O(t2.a.e(), false, 2);
    }

    public static <T> k<T> b0(n<? extends T> nVar, n<? extends T> nVar2, n<? extends T> nVar3) {
        b.e(nVar, "source1 is null");
        b.e(nVar2, "source2 is null");
        b.e(nVar3, "source3 is null");
        return S(nVar, nVar2, nVar3).O(t2.a.e(), false, 3);
    }

    public static <T> k<T> e0() {
        return a.o(h0.f177e);
    }

    public static <T> k<T> f(Iterable<? extends n<? extends T>> iterable) {
        b.e(iterable, "sources is null");
        return a.o(new a3.b((n<? extends T>[]) null, iterable));
    }

    public static int h() {
        return f.b();
    }

    public static <T> k<T> k(n<? extends T>... nVarArr) {
        return nVarArr.length == 0 ? F() : nVarArr.length == 1 ? N0(nVarArr[0]) : a.o(new d(S(nVarArr), t2.a.e(), h(), e.BOUNDARY));
    }

    public static <T> k<T> m(m<T> mVar) {
        b.e(mVar, "source is null");
        return a.o(new g(mVar));
    }

    public static <T> k<T> o(Callable<? extends n<? extends T>> callable) {
        b.e(callable, "supplier is null");
        return a.o(new i(callable));
    }

    private k<T> w(r2.e<? super T> eVar, r2.e<? super Throwable> eVar2, r2.a aVar, r2.a aVar2) {
        b.e(eVar, "onNext is null");
        b.e(eVar2, "onError is null");
        b.e(aVar, "onComplete is null");
        b.e(aVar2, "onAfterTerminate is null");
        return a.o(new n(this, eVar, eVar2, aVar, aVar2));
    }

    public final k<T> A(r2.e<? super c> eVar) {
        return y(eVar, t2.a.f7034c);
    }

    public final <R> k<R> A0(f<? super T, ? extends v<? extends R>> fVar) {
        b.e(fVar, "mapper is null");
        return a.o(new z2.b(this, fVar, false));
    }

    public final k<T> B(r2.a aVar) {
        b.e(aVar, "onTerminate is null");
        return w(t2.a.d(), t2.a.a(aVar), aVar, t2.a.f7034c);
    }

    public final k<T> B0(long j5) {
        if (j5 >= 0) {
            return a.o(new w0(this, j5));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j5);
    }

    public final h<T> C(long j5) {
        if (j5 >= 0) {
            return a.n(new q(this, j5));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j5);
    }

    public final k<T> C0(long j5, TimeUnit timeUnit, q qVar) {
        return D0(J0(j5, timeUnit, qVar));
    }

    public final r<T> D(long j5, T t5) {
        if (j5 >= 0) {
            b.e(t5, "defaultItem is null");
            return a.p(new r(this, j5, t5));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j5);
    }

    public final <U> k<T> D0(n<U> nVar) {
        b.e(nVar, "other is null");
        return a.o(new x0(this, nVar));
    }

    public final r<T> E(long j5) {
        if (j5 >= 0) {
            return a.p(new r(this, j5, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j5);
    }

    public final k<T> E0(h<? super T> hVar) {
        b.e(hVar, "stopPredicate is null");
        return a.o(new y0(this, hVar));
    }

    public final k<T> F0(h<? super T> hVar) {
        b.e(hVar, "predicate is null");
        return a.o(new z0(this, hVar));
    }

    public final <U, V> k<T> G0(n<U> nVar, f<? super T, ? extends n<V>> fVar) {
        b.e(nVar, "firstTimeoutIndicator is null");
        return H0(nVar, fVar, (n) null);
    }

    public final k<T> I(h<? super T> hVar) {
        b.e(hVar, "predicate is null");
        return a.o(new u(this, hVar));
    }

    public final r<T> J(T t5) {
        return D(0, t5);
    }

    public final h<T> K() {
        return C(0);
    }

    public final k<T> K0(q qVar) {
        b.e(qVar, "scheduler is null");
        return a.o(new e1(this, qVar));
    }

    public final r<T> L() {
        return E(0);
    }

    public final <B> k<k<T>> L0(n<B> nVar) {
        return M0(nVar, h());
    }

    public final <R> k<R> M(f<? super T, ? extends n<? extends R>> fVar) {
        return N(fVar, false);
    }

    public final <B> k<k<T>> M0(n<B> nVar, int i5) {
        b.e(nVar, "boundary is null");
        b.f(i5, "bufferSize");
        return a.o(new f1(this, nVar, i5));
    }

    public final <R> k<R> N(f<? super T, ? extends n<? extends R>> fVar, boolean z4) {
        return O(fVar, z4, Integer.MAX_VALUE);
    }

    public final <R> k<R> O(f<? super T, ? extends n<? extends R>> fVar, boolean z4, int i5) {
        return P(fVar, z4, i5, h());
    }

    public final <R> k<R> P(f<? super T, ? extends n<? extends R>> fVar, boolean z4, int i5, int i6) {
        b.e(fVar, "mapper is null");
        b.f(i5, "maxConcurrency");
        b.f(i6, "bufferSize");
        if (!(this instanceof u2.g)) {
            return a.o(new v(this, fVar, z4, i5, i6));
        }
        Object call = ((u2.g) this).call();
        return call == null ? F() : s0.a(call, fVar);
    }

    public final <R> k<R> Q(f<? super T, ? extends v<? extends R>> fVar) {
        return R(fVar, false);
    }

    public final <R> k<R> R(f<? super T, ? extends v<? extends R>> fVar, boolean z4) {
        b.e(fVar, "mapper is null");
        return a.o(new w(this, fVar, z4));
    }

    public final <K> k<h3.b<K, T>> U(f<? super T, ? extends K> fVar) {
        return V(fVar, t2.a.e(), false, h());
    }

    public final <K, V> k<h3.b<K, V>> V(f<? super T, ? extends K> fVar, f<? super T, ? extends V> fVar2, boolean z4, int i5) {
        b.e(fVar, "keySelector is null");
        b.e(fVar2, "valueSelector is null");
        b.f(i5, "bufferSize");
        return a.o(new a0(this, fVar, fVar2, i5, z4));
    }

    public final a W() {
        return a.l(new c0(this));
    }

    public final <R> k<R> Z(f<? super T, ? extends R> fVar) {
        b.e(fVar, "mapper is null");
        return a.o(new f0(this, fVar));
    }

    public final k<T> c0(c cVar) {
        b.e(cVar, "other is null");
        return a.o(new g0(this, cVar));
    }

    public final k<T> d0(n<? extends T> nVar) {
        b.e(nVar, "other is null");
        return a0(this, nVar);
    }

    public final k<T> f0(q qVar) {
        return g0(qVar, false, h());
    }

    public final void g(p<? super T> pVar) {
        b.e(pVar, "observer is null");
        try {
            p<? super Object> w4 = a.w(this, pVar);
            b.e(w4, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            v0(w4);
        } catch (NullPointerException e5) {
            throw e5;
        } catch (Throwable th) {
            q2.b.b(th);
            a.r(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final k<T> g0(q qVar, boolean z4, int i5) {
        b.e(qVar, "scheduler is null");
        b.f(i5, "bufferSize");
        return a.o(new i0(this, qVar, z4, i5));
    }

    public final k<T> h0(f<? super Throwable, ? extends T> fVar) {
        b.e(fVar, "valueSupplier is null");
        return a.o(new j0(this, fVar));
    }

    public final <U> k<U> i(Class<U> cls) {
        b.e(cls, "clazz is null");
        return Z(t2.a.c(cls));
    }

    public final h3.a<T> i0() {
        return k0.T0(this);
    }

    public final <R> k<R> j(o<? super T, ? extends R> oVar) {
        return N0(((o) b.e(oVar, "composer is null")).a(this));
    }

    public final <R> k<R> j0(f<? super k<T>, ? extends n<R>> fVar) {
        b.e(fVar, "selector is null");
        return a.o(new n0(this, fVar));
    }

    public final k<T> k0(f<? super k<Object>, ? extends n<?>> fVar) {
        b.e(fVar, "handler is null");
        return a.o(new p0(this, fVar));
    }

    public final r<Long> l() {
        return a.p(new a3.f(this));
    }

    public final h3.a<T> l0() {
        return q0.V0(this);
    }

    public final h3.a<T> m0(int i5) {
        b.f(i5, "bufferSize");
        return q0.T0(this, i5);
    }

    public final k<T> n(long j5, TimeUnit timeUnit, q qVar) {
        b.e(timeUnit, "unit is null");
        b.e(qVar, "scheduler is null");
        return a.o(new a3.h(this, j5, timeUnit, qVar));
    }

    public final k<T> n0(long j5, h<? super Throwable> hVar) {
        if (j5 >= 0) {
            b.e(hVar, "predicate is null");
            return a.o(new r0(this, j5, hVar));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j5);
    }

    public final k<T> o0(h<? super Throwable> hVar) {
        return n0(Long.MAX_VALUE, hVar);
    }

    public final k<T> p(long j5, TimeUnit timeUnit) {
        return r(j5, timeUnit, k3.a.a(), false);
    }

    public final k<T> p0() {
        return i0().S0();
    }

    public final k<T> q(long j5, TimeUnit timeUnit, q qVar) {
        return r(j5, timeUnit, qVar, false);
    }

    public final k<T> q0(long j5) {
        return j5 <= 0 ? a.o(this) : a.o(new t0(this, j5));
    }

    public final k<T> r(long j5, TimeUnit timeUnit, q qVar, boolean z4) {
        b.e(timeUnit, "unit is null");
        b.e(qVar, "scheduler is null");
        return a.o(new j(this, j5, timeUnit, qVar, z4));
    }

    public final k<T> r0(T t5) {
        b.e(t5, "item is null");
        return k(Y(t5), this);
    }

    public final <U> k<T> s(n<U> nVar) {
        b.e(nVar, "other is null");
        return a.o(new a3.k(this, nVar));
    }

    public final c s0(r2.e<? super T> eVar) {
        return u0(eVar, t2.a.f7037f, t2.a.f7034c, t2.a.d());
    }

    public final k<T> t() {
        return u(t2.a.e());
    }

    public final c t0(r2.e<? super T> eVar, r2.e<? super Throwable> eVar2) {
        return u0(eVar, eVar2, t2.a.f7034c, t2.a.d());
    }

    public final <K> k<T> u(f<? super T, K> fVar) {
        b.e(fVar, "keySelector is null");
        return a.o(new l(this, fVar, b.d()));
    }

    public final c u0(r2.e<? super T> eVar, r2.e<? super Throwable> eVar2, r2.a aVar, r2.e<? super c> eVar3) {
        b.e(eVar, "onNext is null");
        b.e(eVar2, "onError is null");
        b.e(aVar, "onComplete is null");
        b.e(eVar3, "onSubscribe is null");
        v2.h hVar = new v2.h(eVar, eVar2, aVar, eVar3);
        g(hVar);
        return hVar;
    }

    public final k<T> v(r2.a aVar) {
        b.e(aVar, "onFinally is null");
        return a.o(new m(this, aVar));
    }

    /* access modifiers changed from: protected */
    public abstract void v0(p<? super T> pVar);

    public final k<T> w0(q qVar) {
        b.e(qVar, "scheduler is null");
        return a.o(new u0(this, qVar));
    }

    public final k<T> x(r2.e<? super Throwable> eVar) {
        r2.e d5 = t2.a.d();
        r2.a aVar = t2.a.f7034c;
        return w(d5, eVar, aVar, aVar);
    }

    public final <E extends p<? super T>> E x0(E e5) {
        g(e5);
        return e5;
    }

    public final k<T> y(r2.e<? super c> eVar, r2.a aVar) {
        b.e(eVar, "onSubscribe is null");
        b.e(aVar, "onDispose is null");
        return a.o(new o(this, eVar, aVar));
    }

    public final <R> k<R> y0(f<? super T, ? extends n<? extends R>> fVar) {
        return z0(fVar, h());
    }

    public final k<T> z(r2.e<? super T> eVar) {
        r2.e d5 = t2.a.d();
        r2.a aVar = t2.a.f7034c;
        return w(eVar, d5, aVar, aVar);
    }

    public final <R> k<R> z0(f<? super T, ? extends n<? extends R>> fVar, int i5) {
        b.e(fVar, "mapper is null");
        b.f(i5, "bufferSize");
        if (!(this instanceof u2.g)) {
            return a.o(new v0(this, fVar, i5, false));
        }
        Object call = ((u2.g) this).call();
        return call == null ? F() : s0.a(call, fVar);
    }
}
