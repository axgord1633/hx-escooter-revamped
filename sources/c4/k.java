package c4;

import m3.q;
import o3.d;
import v3.l;

public interface k<T> extends d<T> {

    public static final class a {
        public static /* synthetic */ Object a(k kVar, Object obj, Object obj2, int i5, Object obj3) {
            if (obj3 == null) {
                if ((i5 & 2) != 0) {
                    obj2 = null;
                }
                return kVar.a(obj, obj2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
        }
    }

    Object a(T t5, Object obj);

    void c(l<? super Throwable, q> lVar);

    void f(T t5, l<? super Throwable, q> lVar);

    Object k(T t5, Object obj, l<? super Throwable, q> lVar);

    Object o(Throwable th);

    void p(Object obj);
}
