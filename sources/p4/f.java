package p4;

import com.yalantis.ucrop.BuildConfig;
import i4.v;
import j4.c;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

final class f extends i {

    /* renamed from: c  reason: collision with root package name */
    final Method f6575c;

    /* renamed from: d  reason: collision with root package name */
    final Method f6576d;

    f(Method method, Method method2) {
        this.f6575c = method;
        this.f6576d = method2;
    }

    public static f u() {
        try {
            return new f(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public void g(SSLSocket sSLSocket, String str, List<v> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> b5 = i.b(list);
            this.f6575c.invoke(sSLParameters, new Object[]{b5.toArray(new String[b5.size()])});
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e5) {
            throw c.b("unable to set ssl parameters", e5);
        }
    }

    @Nullable
    public String n(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f6576d.invoke(sSLSocket, new Object[0]);
            if (str == null || str.equals(BuildConfig.FLAVOR)) {
                return null;
            }
            return str;
        } catch (InvocationTargetException e5) {
            if (e5.getCause() instanceof UnsupportedOperationException) {
                return null;
            }
            throw c.b("failed to get ALPN selected protocol", e5);
        } catch (IllegalAccessException e6) {
            throw c.b("failed to get ALPN selected protocol", e6);
        }
    }
}
