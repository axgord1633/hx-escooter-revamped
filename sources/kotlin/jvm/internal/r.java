package kotlin.jvm.internal;

import com.yalantis.ucrop.BuildConfig;
import z3.c;
import z3.d;
import z3.e;
import z3.f;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private static final s f5572a;

    /* renamed from: b  reason: collision with root package name */
    private static final c[] f5573b = new c[0];

    static {
        s sVar = null;
        try {
            sVar = (s) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (sVar == null) {
            sVar = new s();
        }
        f5572a = sVar;
    }

    public static e a(i iVar) {
        return f5572a.a(iVar);
    }

    public static c b(Class cls) {
        return f5572a.b(cls);
    }

    public static d c(Class cls) {
        return f5572a.c(cls, BuildConfig.FLAVOR);
    }

    public static f d(n nVar) {
        return f5572a.d(nVar);
    }

    public static String e(h hVar) {
        return f5572a.e(hVar);
    }

    public static String f(l lVar) {
        return f5572a.f(lVar);
    }
}
