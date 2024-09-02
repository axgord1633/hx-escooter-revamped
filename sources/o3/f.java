package o3;

import kotlin.jvm.internal.k;
import m3.k;
import m3.q;
import v3.p;

public final class f {
    public static final <R, T> void a(p<? super R, ? super d<? super T>, ? extends Object> pVar, R r5, d<? super T> dVar) {
        k.e(pVar, "<this>");
        k.e(dVar, "completion");
        d b5 = c.b(c.a(pVar, r5, dVar));
        k.a aVar = m3.k.f5898e;
        b5.resumeWith(m3.k.a(q.f5904a));
    }
}
