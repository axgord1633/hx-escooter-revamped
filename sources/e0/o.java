package e0;

import android.webkit.WebResourceError;
import d0.e;
import e0.a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebResourceErrorBoundaryInterface;
import t4.a;

public class o extends e {

    /* renamed from: a  reason: collision with root package name */
    private WebResourceError f4458a;

    /* renamed from: b  reason: collision with root package name */
    private WebResourceErrorBoundaryInterface f4459b;

    public o(WebResourceError webResourceError) {
        this.f4458a = webResourceError;
    }

    public o(InvocationHandler invocationHandler) {
        this.f4459b = (WebResourceErrorBoundaryInterface) a.a(WebResourceErrorBoundaryInterface.class, invocationHandler);
    }

    private WebResourceErrorBoundaryInterface c() {
        if (this.f4459b == null) {
            this.f4459b = (WebResourceErrorBoundaryInterface) a.a(WebResourceErrorBoundaryInterface.class, q.c().e(this.f4458a));
        }
        return this.f4459b;
    }

    private WebResourceError d() {
        if (this.f4458a == null) {
            this.f4458a = q.c().d(Proxy.getInvocationHandler(this.f4459b));
        }
        return this.f4458a;
    }

    public CharSequence a() {
        a.b bVar = p.f4481v;
        if (bVar.c()) {
            return c.e(d());
        }
        if (bVar.d()) {
            return c().getDescription();
        }
        throw p.a();
    }

    public int b() {
        a.b bVar = p.f4482w;
        if (bVar.c()) {
            return c.f(d());
        }
        if (bVar.d()) {
            return c().getErrorCode();
        }
        throw p.a();
    }
}
