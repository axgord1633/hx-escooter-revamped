package m2;

import java.util.concurrent.Callable;
import r2.h;
import t2.b;
import w2.c;
import w2.d;
import w2.e;
import w2.f;
import w2.g;
import w2.i;

public abstract class a implements c {
    public static a f(Throwable th) {
        b.e(th, "error is null");
        return j3.a.l(new w2.b(th));
    }

    public static a g(r2.a aVar) {
        b.e(aVar, "run is null");
        return j3.a.l(new c(aVar));
    }

    private static NullPointerException n(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    public static a q(c cVar) {
        b.e(cVar, "source is null");
        return cVar instanceof a ? j3.a.l((a) cVar) : j3.a.l(new d(cVar));
    }

    public final void b(b bVar) {
        b.e(bVar, "observer is null");
        try {
            b u5 = j3.a.u(this, bVar);
            b.e(u5, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            m(u5);
        } catch (NullPointerException e5) {
            throw e5;
        } catch (Throwable th) {
            q2.b.b(th);
            j3.a.r(th);
            throw n(th);
        }
    }

    public final a c(c cVar) {
        b.e(cVar, "next is null");
        return j3.a.l(new w2.a(this, cVar));
    }

    public final <T> k<T> d(n<T> nVar) {
        b.e(nVar, "next is null");
        return j3.a.o(new z2.a(this, nVar));
    }

    public final a e(d dVar) {
        return q(((d) b.e(dVar, "transformer is null")).a(this));
    }

    public final a h(q qVar) {
        b.e(qVar, "scheduler is null");
        return j3.a.l(new e(this, qVar));
    }

    public final a i() {
        return j(t2.a.b());
    }

    public final a j(h<? super Throwable> hVar) {
        b.e(hVar, "predicate is null");
        return j3.a.l(new f(this, hVar));
    }

    public final a k(r2.f<? super Throwable, ? extends c> fVar) {
        b.e(fVar, "errorMapper is null");
        return j3.a.l(new g(this, fVar));
    }

    public final p2.c l(r2.a aVar, r2.e<? super Throwable> eVar) {
        b.e(eVar, "onError is null");
        b.e(aVar, "onComplete is null");
        v2.d dVar = new v2.d(eVar, aVar);
        b(dVar);
        return dVar;
    }

    /* access modifiers changed from: protected */
    public abstract void m(b bVar);

    public final <T> k<T> o() {
        return this instanceof u2.c ? ((u2.c) this).a() : j3.a.o(new w2.h(this));
    }

    public final <T> r<T> p(Callable<? extends T> callable) {
        b.e(callable, "completionValueSupplier is null");
        return j3.a.p(new i(this, callable, null));
    }
}
