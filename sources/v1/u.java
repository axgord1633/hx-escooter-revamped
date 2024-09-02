package v1;

import android.bluetooth.BluetoothGatt;
import m2.r;
import r2.f;

public final /* synthetic */ class u implements f {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BluetoothGatt f7248e;

    public /* synthetic */ u(BluetoothGatt bluetoothGatt) {
        this.f7248e = bluetoothGatt;
    }

    public final Object apply(Object obj) {
        return r.t(new v(this.f7248e));
    }
}
