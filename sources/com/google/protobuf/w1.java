package com.google.protobuf;

import com.google.protobuf.l0;
import java.util.List;
import java.util.Map;

interface w1 {

    public enum a {
        ASCENDING,
        DESCENDING
    }

    void A(int i5, long j5);

    a B();

    void C(int i5, long j5);

    void D(int i5, float f5);

    void E(int i5, List<String> list);

    @Deprecated
    void F(int i5);

    void G(int i5, String str);

    void H(int i5, List<Integer> list, boolean z4);

    void I(int i5, long j5);

    void J(int i5, int i6);

    void K(int i5, List<Long> list, boolean z4);

    void L(int i5, List<Integer> list, boolean z4);

    void M(int i5, List<Double> list, boolean z4);

    void N(int i5, int i6);

    void O(int i5, List<i> list);

    void a(int i5, List<?> list, i1 i1Var);

    @Deprecated
    void b(int i5, List<?> list, i1 i1Var);

    void c(int i5, List<Integer> list, boolean z4);

    void d(int i5, List<Float> list, boolean z4);

    void e(int i5, long j5);

    void f(int i5, boolean z4);

    void g(int i5, int i6);

    void h(int i5, Object obj);

    @Deprecated
    void i(int i5, Object obj, i1 i1Var);

    void j(int i5, int i6);

    @Deprecated
    void k(int i5);

    void l(int i5, i iVar);

    void m(int i5, int i6);

    void n(int i5, List<Long> list, boolean z4);

    void o(int i5, List<Integer> list, boolean z4);

    void p(int i5, int i6);

    void q(int i5, double d5);

    void r(int i5, long j5);

    void s(int i5, List<Long> list, boolean z4);

    void t(int i5, List<Integer> list, boolean z4);

    void u(int i5, List<Long> list, boolean z4);

    void v(int i5, List<Boolean> list, boolean z4);

    void w(int i5, Object obj, i1 i1Var);

    <K, V> void x(int i5, l0.a<K, V> aVar, Map<K, V> map);

    void y(int i5, List<Integer> list, boolean z4);

    void z(int i5, List<Long> list, boolean z4);
}
