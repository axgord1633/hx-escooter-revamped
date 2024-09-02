package com.google.protobuf;

final class p {

    /* renamed from: a  reason: collision with root package name */
    static final Class<?> f3644a = c();

    public static q a() {
        q b5 = b("getEmptyRegistry");
        return b5 != null ? b5 : q.f3649d;
    }

    private static final q b(String str) {
        Class<?> cls = f3644a;
        if (cls == null) {
            return null;
        }
        try {
            return (q) cls.getDeclaredMethod(str, new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static Class<?> c() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
