package y1;

import android.bluetooth.BluetoothManager;
import g0.c;
import h0.a;

public final class d implements c<c> {

    /* renamed from: a  reason: collision with root package name */
    private final a<BluetoothManager> f7731a;

    public d(a<BluetoothManager> aVar) {
        this.f7731a = aVar;
    }

    public static d a(a<BluetoothManager> aVar) {
        return new d(aVar);
    }

    public static c c(BluetoothManager bluetoothManager) {
        return new c(bluetoothManager);
    }

    /* renamed from: b */
    public c get() {
        return c(this.f7731a.get());
    }
}
