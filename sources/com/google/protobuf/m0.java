package com.google.protobuf;

import com.google.protobuf.b0;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class m0<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: f  reason: collision with root package name */
    private static final m0 f3632f;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3633e = true;

    static {
        m0 m0Var = new m0();
        f3632f = m0Var;
        m0Var.j();
    }

    private m0() {
    }

    private m0(Map<K, V> map) {
        super(map);
    }

    static <K, V> int a(Map<K, V> map) {
        int i5 = 0;
        for (Map.Entry next : map.entrySet()) {
            i5 += b(next.getValue()) ^ b(next.getKey());
        }
        return i5;
    }

    private static int b(Object obj) {
        if (obj instanceof byte[]) {
            return b0.d((byte[]) obj);
        }
        if (!(obj instanceof b0.c)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    private static void c(Map<?, ?> map) {
        for (Object next : map.keySet()) {
            b0.a(next);
            b0.a(map.get(next));
        }
    }

    public static <K, V> m0<K, V> d() {
        return f3632f;
    }

    private void f() {
        if (!i()) {
            throw new UnsupportedOperationException();
        }
    }

    private static boolean g(Object obj, Object obj2) {
        return (!(obj instanceof byte[]) || !(obj2 instanceof byte[])) ? obj.equals(obj2) : Arrays.equals((byte[]) obj, (byte[]) obj2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <K, V> boolean h(java.util.Map<K, V> r4, java.util.Map<K, V> r5) {
        /*
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r4.size()
            int r2 = r5.size()
            r3 = 0
            if (r1 == r2) goto L_0x0010
            return r3
        L_0x0010:
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0018:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x0042
            java.lang.Object r1 = r4.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            boolean r2 = r5.containsKey(r2)
            if (r2 != 0) goto L_0x002f
            return r3
        L_0x002f:
            java.lang.Object r2 = r1.getValue()
            java.lang.Object r1 = r1.getKey()
            java.lang.Object r1 = r5.get(r1)
            boolean r1 = g(r2, r1)
            if (r1 != 0) goto L_0x0018
            return r3
        L_0x0042:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.m0.h(java.util.Map, java.util.Map):boolean");
    }

    public void clear() {
        f();
        super.clear();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public boolean equals(Object obj) {
        return (obj instanceof Map) && h(this, (Map) obj);
    }

    public int hashCode() {
        return a(this);
    }

    public boolean i() {
        return this.f3633e;
    }

    public void j() {
        this.f3633e = false;
    }

    public void k(m0<K, V> m0Var) {
        f();
        if (!m0Var.isEmpty()) {
            putAll(m0Var);
        }
    }

    public m0<K, V> l() {
        return isEmpty() ? new m0<>() : new m0<>(this);
    }

    public V put(K k5, V v5) {
        f();
        b0.a(k5);
        b0.a(v5);
        return super.put(k5, v5);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        f();
        c(map);
        super.putAll(map);
    }

    public V remove(Object obj) {
        f();
        return super.remove(obj);
    }
}
