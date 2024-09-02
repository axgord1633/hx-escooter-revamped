package com.google.protobuf;

final class p0 {

    /* renamed from: a  reason: collision with root package name */
    private static final n0 f3645a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final n0 f3646b = new o0();

    static n0 a() {
        return f3645a;
    }

    static n0 b() {
        return f3646b;
    }

    private static n0 c() {
        try {
            return (n0) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
