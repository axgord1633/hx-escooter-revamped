package w0;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import t0.a;

public final class x0 extends n0 {

    /* renamed from: g  reason: collision with root package name */
    public final IBinder f7448g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ c f7449h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x0(c cVar, int i5, IBinder iBinder, Bundle bundle) {
        super(cVar, i5, bundle);
        this.f7449h = cVar;
        this.f7448g = iBinder;
    }

    /* access modifiers changed from: protected */
    public final void f(a aVar) {
        if (this.f7449h.f7313v != null) {
            this.f7449h.f7313v.a(aVar);
        }
        this.f7449h.K(aVar);
    }

    /* access modifiers changed from: protected */
    public final boolean g() {
        String str;
        try {
            IBinder iBinder = this.f7448g;
            p.g(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.f7449h.D().equals(interfaceDescriptor)) {
                str = "service descriptor mismatch: " + this.f7449h.D() + " vs. " + interfaceDescriptor;
                Log.w("GmsClient", str);
                return false;
            }
            IInterface r5 = this.f7449h.r(this.f7448g);
            if (r5 == null || (!c.e0(this.f7449h, 2, 4, r5) && !c.e0(this.f7449h, 3, 4, r5))) {
                return false;
            }
            this.f7449h.f7317z = null;
            Bundle w4 = this.f7449h.w();
            c cVar = this.f7449h;
            if (cVar.f7312u == null) {
                return true;
            }
            cVar.f7312u.e(w4);
            return true;
        } catch (RemoteException unused) {
            str = "service probably died";
        }
    }
}
