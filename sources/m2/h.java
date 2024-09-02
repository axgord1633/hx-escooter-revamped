package m2;

import j3.a;
import r2.f;
import t2.b;
import u2.c;
import y2.d;
import y2.e;
import y2.g;

public abstract class h<T> implements j<T> {
    public static <T> h<T> c(Throwable th) {
        b.e(th, "exception is null");
        return a.n(new y2.b(th));
    }

    public final void b(i<? super T> iVar) {
        b.e(iVar, "observer is null");
        i<? super Object> v5 = a.v(this, iVar);
        b.e(v5, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            f(v5);
        } catch (NullPointerException e5) {
            throw e5;
        } catch (Throwable th) {
            q2.b.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final <R> h<R> d(f<? super T, ? extends j<? extends R>> fVar) {
        b.e(fVar, "mapper is null");
        return a.n(new d(this, fVar));
    }

    public final <R> h<R> e(f<? super T, ? extends R> fVar) {
        b.e(fVar, "mapper is null");
        return a.n(new e(this, fVar));
    }

    /* access modifiers changed from: protected */
    public abstract void f(i<? super T> iVar);

    public final r<T> g(v<? extends T> vVar) {
        b.e(vVar, "other is null");
        return a.p(new y2.f(this, vVar));
    }

    public final k<T> h() {
        return this instanceof c ? ((c) this).a() : a.o(new g(this));
    }
}
