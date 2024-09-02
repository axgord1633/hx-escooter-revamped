package f4;

import m3.q;
import o3.d;
import v3.p;

final class g<T> extends a<T> {

    /* renamed from: e  reason: collision with root package name */
    private final p<c<? super T>, d<? super q>, Object> f4635e;

    public g(p<? super c<? super T>, ? super d<? super q>, ? extends Object> pVar) {
        this.f4635e = pVar;
    }

    public Object b(c<? super T> cVar, d<? super q> dVar) {
        Object invoke = this.f4635e.invoke(cVar, dVar);
        return invoke == d.c() ? invoke : q.f5904a;
    }
}
