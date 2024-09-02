package y1;

import android.bluetooth.BluetoothAdapter;
import g0.c;
import h0.a;

public final class g0 implements c<f0> {

    /* renamed from: a  reason: collision with root package name */
    private final a<BluetoothAdapter> f7743a;

    public g0(a<BluetoothAdapter> aVar) {
        this.f7743a = aVar;
    }

    public static g0 a(a<BluetoothAdapter> aVar) {
        return new g0(aVar);
    }

    public static f0 c(BluetoothAdapter bluetoothAdapter) {
        return new f0(bluetoothAdapter);
    }

    /* renamed from: b */
    public f0 get() {
        return c(this.f7743a.get());
    }
}
