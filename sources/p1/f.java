package p1;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import g0.c;
import g0.e;
import h0.a;
import p1.a;

public final class f implements c<BluetoothManager> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f6453a;

    public f(a<Context> aVar) {
        this.f6453a = aVar;
    }

    public static f a(a<Context> aVar) {
        return new f(aVar);
    }

    public static BluetoothManager c(Context context) {
        return (BluetoothManager) e.d(a.c.e(context));
    }

    /* renamed from: b */
    public BluetoothManager get() {
        return c(this.f6453a.get());
    }
}
