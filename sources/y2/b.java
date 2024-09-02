package y2;

import m2.h;
import m2.i;
import p2.d;

public final class b<T> extends h<T> {

    /* renamed from: e  reason: collision with root package name */
    final Throwable f7801e;

    public b(Throwable th) {
        this.f7801e = th;
    }

    /* access modifiers changed from: protected */
    public void f(i<? super T> iVar) {
        iVar.c(d.a());
        iVar.onError(this.f7801e);
    }
}
