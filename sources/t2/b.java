package t2;

import r2.c;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    static final c<Object, Object> f7047a = new a();

    static final class a implements c<Object, Object> {
        a() {
        }

        public boolean a(Object obj, Object obj2) {
            return b.c(obj, obj2);
        }
    }

    public static int a(int i5, int i6) {
        if (i5 < i6) {
            return -1;
        }
        return i5 > i6 ? 1 : 0;
    }

    public static int b(long j5, long j6) {
        int i5 = (j5 > j6 ? 1 : (j5 == j6 ? 0 : -1));
        if (i5 < 0) {
            return -1;
        }
        return i5 > 0 ? 1 : 0;
    }

    public static boolean c(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T> c<T, T> d() {
        return f7047a;
    }

    public static <T> T e(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }

    public static int f(int i5, String str) {
        if (i5 > 0) {
            return i5;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i5);
    }
}
