package e0;

import android.os.Build;
import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

public class q {

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        static final t f4486a = new t(q.d().getWebkitToCompatConverter());
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        static final r f4487a = q.a();
    }

    static r a() {
        try {
            return new s((WebViewProviderFactoryBoundaryInterface) t4.a.a(WebViewProviderFactoryBoundaryInterface.class, b()));
        } catch (IllegalAccessException e5) {
            throw new RuntimeException(e5);
        } catch (InvocationTargetException e6) {
            throw new RuntimeException(e6);
        } catch (ClassNotFoundException unused) {
            return new l();
        } catch (NoSuchMethodException e7) {
            throw new RuntimeException(e7);
        }
    }

    private static InvocationHandler b() {
        return (InvocationHandler) Class.forName("org.chromium.support_lib_glue.SupportLibReflectionUtil", false, e()).getDeclaredMethod("createWebViewProviderFactory", new Class[0]).invoke((Object) null, new Object[0]);
    }

    public static t c() {
        return a.f4486a;
    }

    public static r d() {
        return b.f4487a;
    }

    public static ClassLoader e() {
        return Build.VERSION.SDK_INT >= 28 ? j.b() : f().getClass().getClassLoader();
    }

    private static Object f() {
        try {
            Method declaredMethod = WebView.class.getDeclaredMethod("getFactory", new Class[0]);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke((Object) null, new Object[0]);
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException(e5);
        } catch (InvocationTargetException e6) {
            throw new RuntimeException(e6);
        } catch (IllegalAccessException e7) {
            throw new RuntimeException(e7);
        }
    }
}
