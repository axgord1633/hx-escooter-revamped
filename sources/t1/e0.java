package t1;

import android.bluetooth.BluetoothGattCharacteristic;
import java.util.Locale;
import u1.b;
import y1.i;

public class e0 {

    /* renamed from: a  reason: collision with root package name */
    private final i f6869a;

    public e0(i iVar) {
        this.f6869a = iVar;
    }

    public String a(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i5) {
        return String.format(Locale.getDefault(), "Characteristic %s supports properties: %s (%d) does not have any property matching %s (%d)", new Object[]{b.g(bluetoothGattCharacteristic.getUuid()), this.f6869a.c(bluetoothGattCharacteristic.getProperties()), Integer.valueOf(bluetoothGattCharacteristic.getProperties()), this.f6869a.c(i5), Integer.valueOf(i5)});
    }
}
