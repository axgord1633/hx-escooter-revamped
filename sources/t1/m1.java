package t1;

import android.bluetooth.BluetoothGattCharacteristic;
import r1.a;

public class m1 extends d0 {
    public m1(e0 e0Var) {
        super(e0Var);
    }

    public a a(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i5) {
        return new a(this.f6858a.a(bluetoothGattCharacteristic, i5), bluetoothGattCharacteristic.getUuid(), bluetoothGattCharacteristic.getProperties(), i5);
    }
}
