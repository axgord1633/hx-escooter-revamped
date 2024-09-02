package v1;

import android.bluetooth.BluetoothGatt;
import java.util.concurrent.Callable;

public final /* synthetic */ class v implements Callable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BluetoothGatt f7249e;

    public /* synthetic */ v(BluetoothGatt bluetoothGatt) {
        this.f7249e = bluetoothGatt;
    }

    public final Object call() {
        return w.t(this.f7249e);
    }
}
