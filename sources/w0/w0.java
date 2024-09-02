package w0;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

public final class w0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final int f7446a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ c f7447b;

    public w0(c cVar, int i5) {
        this.f7447b = cVar;
        this.f7446a = i5;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        c cVar = this.f7447b;
        if (iBinder == null) {
            c.b0(cVar, 16);
            return;
        }
        synchronized (cVar.f7305n) {
            c cVar2 = this.f7447b;
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            cVar2.f7306o = (queryLocalInterface == null || !(queryLocalInterface instanceof m)) ? new p0(iBinder) : (m) queryLocalInterface;
        }
        this.f7447b.c0(0, (Bundle) null, this.f7446a);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f7447b.f7305n) {
            this.f7447b.f7306o = null;
        }
        Handler handler = this.f7447b.f7303l;
        handler.sendMessage(handler.obtainMessage(6, this.f7446a, 1));
    }
}
