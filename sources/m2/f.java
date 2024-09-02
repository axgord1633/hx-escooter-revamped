package m2;

import t2.b;
import u4.a;
import x2.c;
import x2.d;
import x2.g;
import x2.h;
import x2.i;

public abstract class f<T> implements a<T> {

    /* renamed from: e  reason: collision with root package name */
    static final int f5881e = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static int b() {
        return f5881e;
    }

    public static <T> f<T> d() {
        return j3.a.m(d.f7642f);
    }

    public static <T> f<T> f(T... tArr) {
        b.e(tArr, "items is null");
        return tArr.length == 0 ? d() : tArr.length == 1 ? g(tArr[0]) : j3.a.m(new g(tArr));
    }

    public static <T> f<T> g(T t5) {
        b.e(t5, "item is null");
        return j3.a.m(new h(t5));
    }

    public final void a(u4.b<? super T> bVar) {
        if (bVar instanceof g) {
            i((g) bVar);
            return;
        }
        b.e(bVar, "s is null");
        i(new e3.a(bVar));
    }

    public final r<T> c(long j5) {
        if (j5 >= 0) {
            return j3.a.p(new c(this, j5, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j5);
    }

    public final r<T> e() {
        return c(0);
    }

    public final f<T> h(long j5, r2.h<? super Throwable> hVar) {
        if (j5 >= 0) {
            b.e(hVar, "predicate is null");
            return j3.a.m(new i(this, j5, hVar));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j5);
    }

    public final void i(g<? super T> gVar) {
        b.e(gVar, "s is null");
        try {
            u4.b<? super Object> y4 = j3.a.y(this, gVar);
            b.e(y4, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            j(y4);
        } catch (NullPointerException e5) {
            throw e5;
        } catch (Throwable th) {
            q2.b.b(th);
            j3.a.r(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void j(u4.b<? super T> bVar);
}
