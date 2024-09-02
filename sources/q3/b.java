package q3;

import kotlin.jvm.internal.k;
import s3.a;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f6660a;

    static {
        a aVar;
        a newInstance;
        Class<a> cls = a.class;
        try {
            newInstance = a.class.newInstance();
            k.d(newInstance, "forName(\"kotlin.internal…entations\").newInstance()");
            if (newInstance != null) {
                aVar = newInstance;
                f6660a = aVar;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
        } catch (ClassCastException e5) {
            ClassLoader classLoader = newInstance.getClass().getClassLoader();
            ClassLoader classLoader2 = cls.getClassLoader();
            if (!k.a(classLoader, classLoader2)) {
                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e5);
            }
            throw e5;
        } catch (ClassNotFoundException unused) {
            try {
                Object newInstance2 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                k.d(newInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                if (newInstance2 != null) {
                    try {
                        aVar = (a) newInstance2;
                    } catch (ClassCastException e6) {
                        ClassLoader classLoader3 = newInstance2.getClass().getClassLoader();
                        ClassLoader classLoader4 = cls.getClassLoader();
                        if (!k.a(classLoader3, classLoader4)) {
                            throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e6);
                        }
                        throw e6;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                }
            } catch (ClassNotFoundException unused2) {
                try {
                    r3.a newInstance3 = r3.a.class.newInstance();
                    k.d(newInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
                    if (newInstance3 != null) {
                        try {
                            aVar = newInstance3;
                        } catch (ClassCastException e7) {
                            ClassLoader classLoader5 = newInstance3.getClass().getClassLoader();
                            ClassLoader classLoader6 = cls.getClassLoader();
                            if (!k.a(classLoader5, classLoader6)) {
                                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e7);
                            }
                            throw e7;
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                } catch (ClassNotFoundException unused3) {
                    try {
                        Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                        k.d(newInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                        if (newInstance4 != null) {
                            try {
                                aVar = (a) newInstance4;
                            } catch (ClassCastException e8) {
                                ClassLoader classLoader7 = newInstance4.getClass().getClassLoader();
                                ClassLoader classLoader8 = cls.getClassLoader();
                                if (!k.a(classLoader7, classLoader8)) {
                                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e8);
                                }
                                throw e8;
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                    } catch (ClassNotFoundException unused4) {
                        aVar = new a();
                    }
                }
            }
        }
    }
}
