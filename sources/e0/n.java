package e0;

import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import d0.c;
import d0.d;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface;

public class n extends d {

    /* renamed from: a  reason: collision with root package name */
    private WebMessagePort f4456a;

    /* renamed from: b  reason: collision with root package name */
    private WebMessagePortBoundaryInterface f4457b;

    public n(WebMessagePort webMessagePort) {
        this.f4456a = webMessagePort;
    }

    public static WebMessagePort[] b(d[] dVarArr) {
        if (dVarArr == null) {
            return null;
        }
        int length = dVarArr.length;
        WebMessagePort[] webMessagePortArr = new WebMessagePort[length];
        for (int i5 = 0; i5 < length; i5++) {
            webMessagePortArr[i5] = dVarArr[i5].a();
        }
        return webMessagePortArr;
    }

    public static c c(WebMessage webMessage) {
        return c.d(webMessage);
    }

    private WebMessagePort d() {
        if (this.f4456a == null) {
            this.f4456a = q.c().c(Proxy.getInvocationHandler(this.f4457b));
        }
        return this.f4456a;
    }

    public static d[] e(WebMessagePort[] webMessagePortArr) {
        if (webMessagePortArr == null) {
            return null;
        }
        d[] dVarArr = new d[webMessagePortArr.length];
        for (int i5 = 0; i5 < webMessagePortArr.length; i5++) {
            dVarArr[i5] = new n(webMessagePortArr[i5]);
        }
        return dVarArr;
    }

    public WebMessagePort a() {
        return d();
    }
}
