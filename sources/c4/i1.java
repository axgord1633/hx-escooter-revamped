package c4;

import m3.q;
import v3.l;

final class i1 extends i {

    /* renamed from: e  reason: collision with root package name */
    private final l<Throwable, q> f3131e;

    public i1(l<? super Throwable, q> lVar) {
        this.f3131e = lVar;
    }

    public void a(Throwable th) {
        this.f3131e.invoke(th);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return q.f5904a;
    }

    public String toString() {
        return "InvokeOnCancel[" + k0.a(this.f3131e) + '@' + k0.b(this) + ']';
    }
}
