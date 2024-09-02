package n3;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.k;

class n extends m {
    public static final <T> Collection<T> c(T[] tArr) {
        k.e(tArr, "<this>");
        return new d(tArr, false);
    }

    public static <T> List<T> d() {
        return x.f6079e;
    }

    public static <T> int e(List<? extends T> list) {
        k.e(list, "<this>");
        return list.size() - 1;
    }

    public static <T> List<T> f(T... tArr) {
        k.e(tArr, "elements");
        return tArr.length > 0 ? i.c(tArr) : d();
    }

    public static <T> List<T> g(List<? extends T> list) {
        k.e(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : m.b(list.get(0)) : d();
    }

    public static void h() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
