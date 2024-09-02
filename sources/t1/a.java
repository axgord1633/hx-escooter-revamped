package t1;

import android.bluetooth.BluetoothGatt;
import java.util.concurrent.atomic.AtomicReference;
import v0.f0;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<BluetoothGatt> f6846a = new AtomicReference<>();

    a() {
    }

    public BluetoothGatt a() {
        return this.f6846a.get();
    }

    public void b(BluetoothGatt bluetoothGatt) {
        f0.a(this.f6846a, (Object) null, bluetoothGatt);
    }
}
