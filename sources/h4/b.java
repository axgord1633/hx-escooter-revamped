package h4;

import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.u;
import kotlinx.coroutines.internal.f0;
import m3.k;
import m3.l;
import o3.d;
import o3.g;
import v3.p;

public final class b {
    public static final <R, T> void a(p<? super R, ? super d<? super T>, ? extends Object> pVar, R r5, d<? super T> dVar) {
        Object obj;
        g context;
        Object c5;
        d<? super T> a5 = h.a(dVar);
        try {
            context = dVar.getContext();
            c5 = f0.c(context, (Object) null);
            obj = ((p) u.a(pVar, 2)).invoke(r5, a5);
            f0.a(context, c5);
            if (obj == d.c()) {
                return;
            }
        } catch (Throwable th) {
            k.a aVar = k.f5898e;
            obj = l.a(th);
        }
        a5.resumeWith(k.a(obj));
    }
}
