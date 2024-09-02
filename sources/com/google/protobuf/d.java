package com.google.protobuf;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f3477a;

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?> f3478b = a("libcore.io.Memory");

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f3479c = (!f3477a && a("org.robolectric.Robolectric") != null);

    private static <T> Class<T> a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static Class<?> b() {
        return f3478b;
    }

    static boolean c() {
        return f3477a || (f3478b != null && !f3479c);
    }
}
