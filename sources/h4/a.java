package h4;

import kotlinx.coroutines.internal.g;
import m3.k;
import m3.l;
import m3.q;
import o3.d;
import v3.p;

public final class a {
    private static final void a(d<?> dVar, Throwable th) {
        k.a aVar = k.f5898e;
        dVar.resumeWith(k.a(l.a(th)));
        throw th;
    }

    public static final void b(d<? super q> dVar, d<?> dVar2) {
        try {
            d b5 = c.b(dVar);
            k.a aVar = k.f5898e;
            g.c(b5, k.a(q.f5904a), (v3.l) null, 2, (Object) null);
        } catch (Throwable th) {
            a(dVar2, th);
        }
    }

    public static final <R, T> void c(p<? super R, ? super d<? super T>, ? extends Object> pVar, R r5, d<? super T> dVar, v3.l<? super Throwable, q> lVar) {
        try {
            d b5 = c.b(c.a(pVar, r5, dVar));
            k.a aVar = k.f5898e;
            g.b(b5, k.a(q.f5904a), lVar);
        } catch (Throwable th) {
            a(dVar, th);
        }
    }

    public static /* synthetic */ void d(p pVar, Object obj, d dVar, v3.l lVar, int i5, Object obj2) {
        if ((i5 & 4) != 0) {
            lVar = null;
        }
        c(pVar, obj, dVar, lVar);
    }
}
