package a3;

import java.util.concurrent.Callable;
import m2.k;
import m2.p;
import s2.d;
import t2.b;

public final class t<T> extends k<T> {

    /* renamed from: e  reason: collision with root package name */
    final Callable<? extends Throwable> f355e;

    public t(Callable<? extends Throwable> callable) {
        this.f355e = callable;
    }

    public void v0(p<? super T> pVar) {
        try {
            th = (Throwable) b.e(this.f355e.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            q2.b.b(th);
        }
        d.m(th, pVar);
    }
}
