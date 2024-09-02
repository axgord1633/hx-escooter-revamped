package y0;

import android.os.IBinder;
import android.os.Parcel;
import e1.c;
import w0.s;

public final class a extends e1.a {
    a(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    public final void z(s sVar) {
        Parcel a5 = a();
        c.c(a5, sVar);
        e(1, a5);
    }
}
