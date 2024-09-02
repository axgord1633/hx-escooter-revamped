package a3;

import a3.s0;
import m2.k;
import m2.p;
import u2.g;

public final class e0<T> extends k<T> implements g<T> {

    /* renamed from: e  reason: collision with root package name */
    private final T f125e;

    public e0(T t5) {
        this.f125e = t5;
    }

    public T call() {
        return this.f125e;
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super T> pVar) {
        s0.a aVar = new s0.a(pVar, this.f125e);
        pVar.c(aVar);
        aVar.run();
    }
}
