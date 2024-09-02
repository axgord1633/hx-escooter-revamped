package v1;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import java.util.concurrent.TimeUnit;

public interface k {
    i a(int i5);

    w b(long j5, TimeUnit timeUnit);

    b c(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr);

    e d(int i5, long j5, TimeUnit timeUnit);

    f e(BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr);

    a f(BluetoothGattCharacteristic bluetoothGattCharacteristic);
}
