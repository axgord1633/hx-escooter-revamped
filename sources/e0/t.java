package e0;

import android.webkit.SafeBrowsingResponse;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceError;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

public class t {

    /* renamed from: a  reason: collision with root package name */
    private final WebkitToCompatConverterBoundaryInterface f4489a;

    public t(WebkitToCompatConverterBoundaryInterface webkitToCompatConverterBoundaryInterface) {
        this.f4489a = webkitToCompatConverterBoundaryInterface;
    }

    public SafeBrowsingResponse a(InvocationHandler invocationHandler) {
        return (SafeBrowsingResponse) this.f4489a.convertSafeBrowsingResponse(invocationHandler);
    }

    public InvocationHandler b(SafeBrowsingResponse safeBrowsingResponse) {
        return this.f4489a.convertSafeBrowsingResponse((Object) safeBrowsingResponse);
    }

    public WebMessagePort c(InvocationHandler invocationHandler) {
        return (WebMessagePort) this.f4489a.convertWebMessagePort(invocationHandler);
    }

    public WebResourceError d(InvocationHandler invocationHandler) {
        return (WebResourceError) this.f4489a.convertWebResourceError(invocationHandler);
    }

    public InvocationHandler e(WebResourceError webResourceError) {
        return this.f4489a.convertWebResourceError((Object) webResourceError);
    }
}
