package t1;

import android.bluetooth.BluetoothGattCharacteristic;

public class b0 {

    /* renamed from: a  reason: collision with root package name */
    final d0 f6851a;

    class a implements r2.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BluetoothGattCharacteristic f6852a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f6853b;

        a(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i5) {
            this.f6852a = bluetoothGattCharacteristic;
            this.f6853b = i5;
        }

        public void run() {
            r1.a a5;
            int properties = this.f6852a.getProperties();
            int i5 = this.f6853b;
            if ((properties & i5) == 0 && (a5 = b0.this.f6851a.a(this.f6852a, i5)) != null) {
                throw a5;
            }
        }
    }

    public b0(d0 d0Var) {
        this.f6851a = d0Var;
    }

    public m2.a a(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i5) {
        return m2.a.g(new a(bluetoothGattCharacteristic, i5));
    }
}
