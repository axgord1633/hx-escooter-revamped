package kotlinx.coroutines.internal;

import m3.k;
import m3.l;

public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5578a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f5579b;

    static {
        Object obj;
        Object obj2;
        try {
            k.a aVar = k.f5898e;
            obj = k.a(Class.forName("kotlin.coroutines.jvm.internal.a").getCanonicalName());
        } catch (Throwable th) {
            k.a aVar2 = k.f5898e;
            obj = k.a(l.a(th));
        }
        if (k.b(obj) != null) {
            obj = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f5578a = (String) obj;
        try {
            obj2 = k.a(a0.class.getCanonicalName());
        } catch (Throwable th2) {
            k.a aVar3 = k.f5898e;
            obj2 = k.a(l.a(th2));
        }
        if (k.b(obj2) != null) {
            obj2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f5579b = (String) obj2;
    }

    public static final <E extends Throwable> E a(E e5) {
        return e5;
    }
}
