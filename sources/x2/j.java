package x2;

import f3.d;
import f3.e;
import java.util.concurrent.Callable;
import r2.f;
import u4.a;
import u4.b;

public final class j {
    public static <T, R> boolean a(a<T> aVar, b<? super R> bVar, f<? super T, ? extends a<? extends R>> fVar) {
        if (!(aVar instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) aVar).call();
            if (call == null) {
                d.c(bVar);
                return true;
            }
            a aVar2 = (a) t2.b.e(fVar.apply(call), "The mapper returned a null Publisher");
            if (aVar2 instanceof Callable) {
                Object call2 = ((Callable) aVar2).call();
                if (call2 == null) {
                    d.c(bVar);
                    return true;
                }
                bVar.e(new e(bVar, call2));
            } else {
                aVar2.a(bVar);
            }
            return true;
        } catch (Throwable th) {
            q2.b.b(th);
            d.l(th, bVar);
            return true;
        }
    }
}
