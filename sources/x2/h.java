package x2;

import f3.e;
import m2.f;
import u2.g;
import u4.b;

public final class h<T> extends f<T> implements g<T> {

    /* renamed from: f  reason: collision with root package name */
    private final T f7681f;

    public h(T t5) {
        this.f7681f = t5;
    }

    public T call() {
        return this.f7681f;
    }

    /* access modifiers changed from: protected */
    public void j(b<? super T> bVar) {
        bVar.e(new e(bVar, this.f7681f));
    }
}
