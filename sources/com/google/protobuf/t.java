package com.google.protobuf;

final class t {

    /* renamed from: a  reason: collision with root package name */
    private static final r<?> f3666a = new s();

    /* renamed from: b  reason: collision with root package name */
    private static final r<?> f3667b = c();

    static r<?> a() {
        r<?> rVar = f3667b;
        if (rVar != null) {
            return rVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static r<?> b() {
        return f3666a;
    }

    private static r<?> c() {
        try {
            return (r) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
