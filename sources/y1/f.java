package y1;

import android.bluetooth.BluetoothGattDescriptor;
import java.util.UUID;
import r2.h;

public class f {

    class a implements h<e<UUID>> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ UUID f7738e;

        a(UUID uuid) {
            this.f7738e = uuid;
        }

        /* renamed from: a */
        public boolean test(e<UUID> eVar) {
            return ((UUID) eVar.f7733a).equals(this.f7738e);
        }
    }

    class b implements r2.f<e<?>, byte[]> {
        b() {
        }

        /* renamed from: a */
        public byte[] apply(e<?> eVar) {
            return eVar.f7734b;
        }
    }

    class c implements h<e<BluetoothGattDescriptor>> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ BluetoothGattDescriptor f7739e;

        c(BluetoothGattDescriptor bluetoothGattDescriptor) {
            this.f7739e = bluetoothGattDescriptor;
        }

        /* renamed from: a */
        public boolean test(e<BluetoothGattDescriptor> eVar) {
            return ((BluetoothGattDescriptor) eVar.f7733a).equals(this.f7739e);
        }
    }

    public static h<? super e<UUID>> a(UUID uuid) {
        return new a(uuid);
    }

    public static h<? super e<BluetoothGattDescriptor>> b(BluetoothGattDescriptor bluetoothGattDescriptor) {
        return new c(bluetoothGattDescriptor);
    }

    public static r2.f<e<?>, byte[]> c() {
        return new b();
    }
}
