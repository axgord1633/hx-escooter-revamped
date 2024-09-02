package t1;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import r2.a;

public final /* synthetic */ class y0 implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BluetoothGatt f7028a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BluetoothGattCharacteristic f7029b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f7030c;

    public /* synthetic */ y0(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z4) {
        this.f7028a = bluetoothGatt;
        this.f7029b = bluetoothGattCharacteristic;
        this.f7030c = z4;
    }

    public final void run() {
        d1.m(this.f7028a, this.f7029b, this.f7030c);
    }
}
