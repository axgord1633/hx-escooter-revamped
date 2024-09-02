package com.google.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class e1 {

    /* renamed from: c  reason: collision with root package name */
    private static final e1 f3505c = new e1();

    /* renamed from: a  reason: collision with root package name */
    private final j1 f3506a = new k0();

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, i1<?>> f3507b = new ConcurrentHashMap();

    private e1() {
    }

    public static e1 a() {
        return f3505c;
    }

    public <T> void b(T t5, h1 h1Var, q qVar) {
        e(t5).e(t5, h1Var, qVar);
    }

    public i1<?> c(Class<?> cls, i1<?> i1Var) {
        b0.b(cls, "messageType");
        b0.b(i1Var, "schema");
        return this.f3507b.putIfAbsent(cls, i1Var);
    }

    public <T> i1<T> d(Class<T> cls) {
        b0.b(cls, "messageType");
        i1<T> i1Var = this.f3507b.get(cls);
        if (i1Var != null) {
            return i1Var;
        }
        i1<T> a5 = this.f3506a.a(cls);
        i1<?> c5 = c(cls, a5);
        return c5 != null ? c5 : a5;
    }

    public <T> i1<T> e(T t5) {
        return d(t5.getClass());
    }
}
