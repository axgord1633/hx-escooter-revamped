package w0;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public final class v0 extends o0 {

    /* renamed from: b  reason: collision with root package name */
    private c f7444b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7445c;

    public v0(c cVar, int i5) {
        this.f7444b = cVar;
        this.f7445c = i5;
    }

    public final void n(int i5, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    public final void q(int i5, IBinder iBinder, z0 z0Var) {
        c cVar = this.f7444b;
        p.h(cVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        p.g(z0Var);
        c.a0(cVar, z0Var);
        x(i5, iBinder, z0Var.f7451e);
    }

    public final void x(int i5, IBinder iBinder, Bundle bundle) {
        p.h(this.f7444b, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f7444b.M(i5, iBinder, bundle, this.f7445c);
        this.f7444b = null;
    }
}
