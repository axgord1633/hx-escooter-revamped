package t1;

import android.bluetooth.BluetoothGattCharacteristic;
import java.util.concurrent.Callable;
import p1.d0;

public final /* synthetic */ class t0 implements Callable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ d1 f6992e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ BluetoothGattCharacteristic f6993f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f6994g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ d0 f6995h;

    public /* synthetic */ t0(d1 d1Var, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z4, d0 d0Var) {
        this.f6992e = d1Var;
        this.f6993f = bluetoothGattCharacteristic;
        this.f6994g = z4;
        this.f6995h = d0Var;
    }

    public final Object call() {
        return this.f6992e.r(this.f6993f, this.f6994g, this.f6995h);
    }
}
