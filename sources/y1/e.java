package y1;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import java.util.Arrays;
import java.util.UUID;

public class e<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f7733a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f7734b;

    public e(T t5, byte[] bArr) {
        this.f7733a = t5;
        this.f7734b = bArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Arrays.equals(eVar.f7734b, this.f7734b) && eVar.f7733a.equals(this.f7733a);
    }

    public int hashCode() {
        return this.f7733a.hashCode() ^ Arrays.hashCode(this.f7734b);
    }

    public String toString() {
        String str;
        StringBuilder sb;
        String obj;
        UUID uuid;
        T t5 = this.f7733a;
        if (t5 instanceof BluetoothGattCharacteristic) {
            sb = new StringBuilder();
            sb.append(BluetoothGattCharacteristic.class.getSimpleName());
            sb.append("(");
            uuid = ((BluetoothGattCharacteristic) this.f7733a).getUuid();
        } else if (t5 instanceof BluetoothGattDescriptor) {
            sb = new StringBuilder();
            sb.append(BluetoothGattDescriptor.class.getSimpleName());
            sb.append("(");
            uuid = ((BluetoothGattDescriptor) this.f7733a).getUuid();
        } else if (t5 instanceof UUID) {
            sb = new StringBuilder();
            sb.append(UUID.class.getSimpleName());
            sb.append("(");
            obj = this.f7733a.toString();
            sb.append(obj);
            sb.append(")");
            str = sb.toString();
            return getClass().getSimpleName() + "[first=" + str + ", second=" + Arrays.toString(this.f7734b) + "]";
        } else {
            str = t5.getClass().getSimpleName();
            return getClass().getSimpleName() + "[first=" + str + ", second=" + Arrays.toString(this.f7734b) + "]";
        }
        obj = uuid.toString();
        sb.append(obj);
        sb.append(")");
        str = sb.toString();
        return getClass().getSimpleName() + "[first=" + str + ", second=" + Arrays.toString(this.f7734b) + "]";
    }
}
