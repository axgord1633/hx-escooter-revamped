package com.google.protobuf;

final class z0 {

    /* renamed from: a  reason: collision with root package name */
    private static final x0 f3825a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final x0 f3826b = new y0();

    static x0 a() {
        return f3825a;
    }

    static x0 b() {
        return f3826b;
    }

    private static x0 c() {
        try {
            return (x0) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
