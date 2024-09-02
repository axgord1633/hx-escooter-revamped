package v1;

import android.bluetooth.BluetoothGatt;
import java.util.concurrent.Callable;
import m2.q;

public final /* synthetic */ class t implements Callable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BluetoothGatt f7246e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ q f7247f;

    public /* synthetic */ t(BluetoothGatt bluetoothGatt, q qVar) {
        this.f7246e = bluetoothGatt;
        this.f7247f = qVar;
    }

    public final Object call() {
        return w.v(this.f7246e, this.f7247f);
    }
}
