package kotlin.jvm.internal;

import v3.a;
import v3.b;
import v3.c;
import v3.d;
import v3.e;
import v3.f;
import v3.g;
import v3.h;
import v3.i;
import v3.j;
import v3.k;
import v3.l;
import v3.m;
import v3.n;
import v3.o;
import v3.p;
import v3.q;
import v3.r;
import v3.s;
import v3.t;
import v3.v;
import v3.w;

public class u {
    public static Object a(Object obj, int i5) {
        if (obj != null && !c(obj, i5)) {
            f(obj, "kotlin.jvm.functions.Function" + i5);
        }
        return obj;
    }

    public static int b(Object obj) {
        if (obj instanceof h) {
            return ((h) obj).getArity();
        }
        if (obj instanceof a) {
            return 0;
        }
        if (obj instanceof l) {
            return 1;
        }
        if (obj instanceof p) {
            return 2;
        }
        if (obj instanceof q) {
            return 3;
        }
        if (obj instanceof r) {
            return 4;
        }
        if (obj instanceof s) {
            return 5;
        }
        if (obj instanceof t) {
            return 6;
        }
        if (obj instanceof v3.u) {
            return 7;
        }
        if (obj instanceof v) {
            return 8;
        }
        if (obj instanceof w) {
            return 9;
        }
        if (obj instanceof b) {
            return 10;
        }
        if (obj instanceof c) {
            return 11;
        }
        if (obj instanceof d) {
            return 12;
        }
        if (obj instanceof e) {
            return 13;
        }
        if (obj instanceof f) {
            return 14;
        }
        if (obj instanceof g) {
            return 15;
        }
        if (obj instanceof h) {
            return 16;
        }
        if (obj instanceof i) {
            return 17;
        }
        if (obj instanceof j) {
            return 18;
        }
        if (obj instanceof k) {
            return 19;
        }
        if (obj instanceof m) {
            return 20;
        }
        if (obj instanceof n) {
            return 21;
        }
        return obj instanceof o ? 22 : -1;
    }

    public static boolean c(Object obj, int i5) {
        return (obj instanceof m3.c) && b(obj) == i5;
    }

    private static <T extends Throwable> T d(T t5) {
        return k.i(t5, u.class.getName());
    }

    public static ClassCastException e(ClassCastException classCastException) {
        throw ((ClassCastException) d(classCastException));
    }

    public static void f(Object obj, String str) {
        String name = obj == null ? "null" : obj.getClass().getName();
        g(name + " cannot be cast to " + str);
    }

    public static void g(String str) {
        throw e(new ClassCastException(str));
    }
}
