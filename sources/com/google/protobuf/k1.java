package com.google.protobuf;

import com.google.protobuf.b0;
import com.google.protobuf.v;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class k1 {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f3592a = B();

    /* renamed from: b  reason: collision with root package name */
    private static final p1<?, ?> f3593b = C(false);

    /* renamed from: c  reason: collision with root package name */
    private static final p1<?, ?> f3594c = C(true);

    /* renamed from: d  reason: collision with root package name */
    private static final p1<?, ?> f3595d = new r1();

    static <UT, UB> UB A(int i5, List<Integer> list, b0.e eVar, UB ub, p1<UT, UB> p1Var) {
        if (eVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                int intValue = list.get(i7).intValue();
                if (eVar.a(intValue)) {
                    if (i7 != i6) {
                        list.set(i6, Integer.valueOf(intValue));
                    }
                    i6++;
                } else {
                    ub = L(i5, intValue, ub, p1Var);
                }
            }
            if (i6 != size) {
                list.subList(i6, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!eVar.a(intValue2)) {
                    ub = L(i5, intValue2, ub, p1Var);
                    it.remove();
                }
            }
        }
        return ub;
    }

    private static Class<?> B() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static p1<?, ?> C(boolean z4) {
        try {
            Class<?> D = D();
            if (D == null) {
                return null;
            }
            return (p1) D.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z4)});
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> D() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static <T, FT extends v.b<FT>> void E(r<FT> rVar, T t5, T t6) {
        v<FT> c5 = rVar.c(t6);
        if (!c5.m()) {
            rVar.d(t5).t(c5);
        }
    }

    static <T> void F(n0 n0Var, T t5, T t6, long j5) {
        t1.V(t5, j5, n0Var.a(t1.G(t5, j5), t1.G(t6, j5)));
    }

    static <T, UT, UB> void G(p1<UT, UB> p1Var, T t5, T t6) {
        p1Var.p(t5, p1Var.k(p1Var.g(t5), p1Var.g(t6)));
    }

    public static p1<?, ?> H() {
        return f3593b;
    }

    public static p1<?, ?> I() {
        return f3594c;
    }

    public static void J(Class<?> cls) {
        Class<?> cls2;
        if (!z.class.isAssignableFrom(cls) && (cls2 = f3592a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean K(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <UT, UB> UB L(int i5, int i6, UB ub, p1<UT, UB> p1Var) {
        if (ub == null) {
            ub = p1Var.n();
        }
        p1Var.e(ub, i5, (long) i6);
        return ub;
    }

    public static p1<?, ?> M() {
        return f3595d;
    }

    public static void N(int i5, List<Boolean> list, w1 w1Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w1Var.v(i5, list, z4);
        }
    }

    public static void O(int i5, List<i> list, w1 w1Var) {
        if (list != null && !list.isEmpty()) {
            w1Var.O(i5, list);
        }
    }

    public static void P(int i5, List<Double> list, w1 w1Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w1Var.M(i5, list, z4);
        }
    }

    public static void Q(int i5, List<Integer> list, w1 w1Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w1Var.L(i5, list, z4);
        }
    }

    public static void R(int i5, List<Integer> list, w1 w1Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w1Var.t(i5, list, z4);
        }
    }

    public static void S(int i5, List<Long> list, w1 w1Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w1Var.n(i5, list, z4);
        }
    }

    public static void T(int i5, List<Float> list, w1 w1Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w1Var.d(i5, list, z4);
        }
    }

    public static void U(int i5, List<?> list, w1 w1Var, i1 i1Var) {
        if (list != null && !list.isEmpty()) {
            w1Var.b(i5, list, i1Var);
        }
    }

    public static void V(int i5, List<Integer> list, w1 w1Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w1Var.c(i5, list, z4);
        }
    }

    public static void W(int i5, List<Long> list, w1 w1Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w1Var.K(i5, list, z4);
        }
    }

    public static void X(int i5, List<?> list, w1 w1Var, i1 i1Var) {
        if (list != null && !list.isEmpty()) {
            w1Var.a(i5, list, i1Var);
        }
    }

    public static void Y(int i5, List<Integer> list, w1 w1Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w1Var.o(i5, list, z4);
        }
    }

    public static void Z(int i5, List<Long> list, w1 w1Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w1Var.s(i5, list, z4);
        }
    }

    static int a(int i5, List<?> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z4 ? l.W(i5) + l.D(size) : size * l.e(i5, true);
    }

    public static void a0(int i5, List<Integer> list, w1 w1Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w1Var.H(i5, list, z4);
        }
    }

    static int b(List<?> list) {
        return list.size();
    }

    public static void b0(int i5, List<Long> list, w1 w1Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w1Var.z(i5, list, z4);
        }
    }

    static int c(int i5, List<i> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int W = size * l.W(i5);
        for (int i6 = 0; i6 < list.size(); i6++) {
            W += l.i(list.get(i6));
        }
        return W;
    }

    public static void c0(int i5, List<String> list, w1 w1Var) {
        if (list != null && !list.isEmpty()) {
            w1Var.E(i5, list);
        }
    }

    static int d(int i5, List<Integer> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e5 = e(list);
        int W = l.W(i5);
        return z4 ? W + l.D(e5) : e5 + (size * W);
    }

    public static void d0(int i5, List<Integer> list, w1 w1Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w1Var.y(i5, list, z4);
        }
    }

    static int e(List<Integer> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof a0) {
            a0 a0Var = (a0) list;
            i5 = 0;
            while (i6 < size) {
                i5 += l.m(a0Var.p(i6));
                i6++;
            }
        } else {
            int i7 = 0;
            while (i6 < size) {
                i7 = i5 + l.m(list.get(i6).intValue());
                i6++;
            }
        }
        return i5;
    }

    public static void e0(int i5, List<Long> list, w1 w1Var, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w1Var.u(i5, list, z4);
        }
    }

    static int f(int i5, List<?> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z4 ? l.W(i5) + l.D(size * 4) : size * l.n(i5, 0);
    }

    static int g(List<?> list) {
        return list.size() * 4;
    }

    static int h(int i5, List<?> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z4 ? l.W(i5) + l.D(size * 8) : size * l.p(i5, 0);
    }

    static int i(List<?> list) {
        return list.size() * 8;
    }

    static int j(int i5, List<s0> list, i1 i1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            i6 += l.t(i5, list.get(i7), i1Var);
        }
        return i6;
    }

    static int k(int i5, List<Integer> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l5 = l(list);
        int W = l.W(i5);
        return z4 ? W + l.D(l5) : l5 + (size * W);
    }

    static int l(List<Integer> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof a0) {
            a0 a0Var = (a0) list;
            i5 = 0;
            while (i6 < size) {
                i5 += l.x(a0Var.p(i6));
                i6++;
            }
        } else {
            int i7 = 0;
            while (i6 < size) {
                i7 = i5 + l.x(list.get(i6).intValue());
                i6++;
            }
        }
        return i5;
    }

    static int m(int i5, List<Long> list, boolean z4) {
        if (list.size() == 0) {
            return 0;
        }
        int n5 = n(list);
        return z4 ? l.W(i5) + l.D(n5) : n5 + (list.size() * l.W(i5));
    }

    static int n(List<Long> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof j0) {
            j0 j0Var = (j0) list;
            i5 = 0;
            while (i6 < size) {
                i5 += l.z(j0Var.p(i6));
                i6++;
            }
        } else {
            int i7 = 0;
            while (i6 < size) {
                i7 = i5 + l.z(list.get(i6).longValue());
                i6++;
            }
        }
        return i5;
    }

    static int o(int i5, Object obj, i1 i1Var) {
        return obj instanceof f0 ? l.B(i5, (f0) obj) : l.G(i5, (s0) obj, i1Var);
    }

    static int p(int i5, List<?> list, i1 i1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int W = l.W(i5) * size;
        for (int i6 = 0; i6 < size; i6++) {
            Object obj = list.get(i6);
            W += obj instanceof f0 ? l.C((f0) obj) : l.I((s0) obj, i1Var);
        }
        return W;
    }

    static int q(int i5, List<Integer> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int r5 = r(list);
        int W = l.W(i5);
        return z4 ? W + l.D(r5) : r5 + (size * W);
    }

    static int r(List<Integer> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof a0) {
            a0 a0Var = (a0) list;
            i5 = 0;
            while (i6 < size) {
                i5 += l.R(a0Var.p(i6));
                i6++;
            }
        } else {
            int i7 = 0;
            while (i6 < size) {
                i7 = i5 + l.R(list.get(i6).intValue());
                i6++;
            }
        }
        return i5;
    }

    static int s(int i5, List<Long> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int t5 = t(list);
        int W = l.W(i5);
        return z4 ? W + l.D(t5) : t5 + (size * W);
    }

    static int t(List<Long> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof j0) {
            j0 j0Var = (j0) list;
            i5 = 0;
            while (i6 < size) {
                i5 += l.T(j0Var.p(i6));
                i6++;
            }
        } else {
            int i7 = 0;
            while (i6 < size) {
                i7 = i5 + l.T(list.get(i6).longValue());
                i6++;
            }
        }
        return i5;
    }

    static int u(int i5, List<?> list) {
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        int W = l.W(i5) * size;
        if (list instanceof h0) {
            h0 h0Var = (h0) list;
            while (i6 < size) {
                Object h5 = h0Var.h(i6);
                W += h5 instanceof i ? l.i((i) h5) : l.V((String) h5);
                i6++;
            }
        } else {
            while (i6 < size) {
                Object obj = list.get(i6);
                W += obj instanceof i ? l.i((i) obj) : l.V((String) obj);
                i6++;
            }
        }
        return W;
    }

    static int v(int i5, List<Integer> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int w4 = w(list);
        int W = l.W(i5);
        return z4 ? W + l.D(w4) : w4 + (size * W);
    }

    static int w(List<Integer> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof a0) {
            a0 a0Var = (a0) list;
            i5 = 0;
            while (i6 < size) {
                i5 += l.Y(a0Var.p(i6));
                i6++;
            }
        } else {
            int i7 = 0;
            while (i6 < size) {
                i7 = i5 + l.Y(list.get(i6).intValue());
                i6++;
            }
        }
        return i5;
    }

    static int x(int i5, List<Long> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int y4 = y(list);
        int W = l.W(i5);
        return z4 ? W + l.D(y4) : y4 + (size * W);
    }

    static int y(List<Long> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof j0) {
            j0 j0Var = (j0) list;
            i5 = 0;
            while (i6 < size) {
                i5 += l.a0(j0Var.p(i6));
                i6++;
            }
        } else {
            int i7 = 0;
            while (i6 < size) {
                i7 = i5 + l.a0(list.get(i6).longValue());
                i6++;
            }
        }
        return i5;
    }

    static <UT, UB> UB z(int i5, List<Integer> list, b0.d<?> dVar, UB ub, p1<UT, UB> p1Var) {
        if (dVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                int intValue = list.get(i7).intValue();
                if (dVar.a(intValue) != null) {
                    if (i7 != i6) {
                        list.set(i6, Integer.valueOf(intValue));
                    }
                    i6++;
                } else {
                    ub = L(i5, intValue, ub, p1Var);
                }
            }
            if (i6 != size) {
                list.subList(i6, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (dVar.a(intValue2) == null) {
                    ub = L(i5, intValue2, ub, p1Var);
                    it.remove();
                }
            }
        }
        return ub;
    }
}
