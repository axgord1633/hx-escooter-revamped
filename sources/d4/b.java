package d4;

import android.os.Build;
import c4.d0;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import o3.a;
import o3.g;

public final class b extends a implements d0 {
    private volatile Object _preHandler = this;

    public b() {
        super(d0.f3113b);
    }

    private final Method M() {
        Object obj = this._preHandler;
        if (obj != this) {
            return (Method) obj;
        }
        Method method = null;
        boolean z4 = false;
        try {
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
            if (Modifier.isPublic(declaredMethod.getModifiers()) && Modifier.isStatic(declaredMethod.getModifiers())) {
                z4 = true;
            }
            if (z4) {
                method = declaredMethod;
            }
        } catch (Throwable unused) {
        }
        this._preHandler = method;
        return method;
    }

    public void j(g gVar, Throwable th) {
        int i5 = Build.VERSION.SDK_INT;
        if (26 <= i5 && i5 < 28) {
            Method M = M();
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;
            Object invoke = M != null ? M.invoke((Object) null, new Object[0]) : null;
            if (invoke instanceof Thread.UncaughtExceptionHandler) {
                uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) invoke;
            }
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
        }
    }
}
