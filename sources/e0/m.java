package e0;

import android.webkit.SafeBrowsingResponse;
import d0.a;
import e0.a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.SafeBrowsingResponseBoundaryInterface;

public class m extends a {

    /* renamed from: a  reason: collision with root package name */
    private SafeBrowsingResponse f4454a;

    /* renamed from: b  reason: collision with root package name */
    private SafeBrowsingResponseBoundaryInterface f4455b;

    public m(SafeBrowsingResponse safeBrowsingResponse) {
        this.f4454a = safeBrowsingResponse;
    }

    public m(InvocationHandler invocationHandler) {
        this.f4455b = (SafeBrowsingResponseBoundaryInterface) t4.a.a(SafeBrowsingResponseBoundaryInterface.class, invocationHandler);
    }

    private SafeBrowsingResponseBoundaryInterface b() {
        if (this.f4455b == null) {
            this.f4455b = (SafeBrowsingResponseBoundaryInterface) t4.a.a(SafeBrowsingResponseBoundaryInterface.class, q.c().b(this.f4454a));
        }
        return this.f4455b;
    }

    private SafeBrowsingResponse c() {
        if (this.f4454a == null) {
            this.f4454a = q.c().a(Proxy.getInvocationHandler(this.f4455b));
        }
        return this.f4454a;
    }

    public void a(boolean z4) {
        a.f fVar = p.f4485z;
        if (fVar.c()) {
            g.e(c(), z4);
        } else if (fVar.d()) {
            b().showInterstitial(z4);
        } else {
            throw p.a();
        }
    }
}
