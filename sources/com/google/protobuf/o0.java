package com.google.protobuf;

import com.google.protobuf.l0;
import java.util.Map;

class o0 implements n0 {
    o0() {
    }

    private static <K, V> int i(int i5, Object obj, Object obj2) {
        m0 m0Var = (m0) obj;
        l0 l0Var = (l0) obj2;
        int i6 = 0;
        if (m0Var.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : m0Var.entrySet()) {
            i6 += l0Var.a(i5, entry.getKey(), entry.getValue());
        }
        return i6;
    }

    private static <K, V> m0<K, V> j(Object obj, Object obj2) {
        m0<K, V> m0Var = (m0) obj;
        m0 m0Var2 = (m0) obj2;
        if (!m0Var2.isEmpty()) {
            if (!m0Var.i()) {
                m0Var = m0Var.l();
            }
            m0Var.k(m0Var2);
        }
        return m0Var;
    }

    public Object a(Object obj, Object obj2) {
        return j(obj, obj2);
    }

    public Object b(Object obj) {
        return m0.d().l();
    }

    public int c(int i5, Object obj, Object obj2) {
        return i(i5, obj, obj2);
    }

    public boolean d(Object obj) {
        return !((m0) obj).i();
    }

    public Object e(Object obj) {
        ((m0) obj).j();
        return obj;
    }

    public l0.a<?, ?> f(Object obj) {
        ((l0) obj).c();
        return null;
    }

    public Map<?, ?> g(Object obj) {
        return (m0) obj;
    }

    public Map<?, ?> h(Object obj) {
        return (m0) obj;
    }
}
