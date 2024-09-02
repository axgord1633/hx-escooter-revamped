package e0;

import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import t4.a;

public class s implements r {

    /* renamed from: a  reason: collision with root package name */
    final WebViewProviderFactoryBoundaryInterface f4488a;

    public s(WebViewProviderFactoryBoundaryInterface webViewProviderFactoryBoundaryInterface) {
        this.f4488a = webViewProviderFactoryBoundaryInterface;
    }

    public String[] a() {
        return this.f4488a.getSupportedFeatures();
    }

    public WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter() {
        return (WebkitToCompatConverterBoundaryInterface) a.a(WebkitToCompatConverterBoundaryInterface.class, this.f4488a.getWebkitToCompatConverter());
    }
}
