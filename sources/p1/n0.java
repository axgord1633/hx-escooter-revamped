package p1;

import android.bluetooth.BluetoothGattCharacteristic;
import java.util.concurrent.TimeUnit;
import m2.o;
import m2.r;
import q1.k;

public interface n0 {

    public enum a {
        CONNECTING("CONNECTING"),
        CONNECTED("CONNECTED"),
        DISCONNECTED("DISCONNECTED"),
        DISCONNECTING("DISCONNECTING");
        

        /* renamed from: e  reason: collision with root package name */
        private final String f6512e;

        private a(String str) {
            this.f6512e = str;
        }

        public String toString() {
            return "RxBleConnectionState{" + this.f6512e + '}';
        }
    }

    public interface b extends o<Boolean, Boolean> {
    }

    public interface c extends o<a, a> {

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            final k f6513a;

            public k a() {
                return this.f6513a;
            }
        }
    }

    <T> m2.k<T> a(o0<T> o0Var);

    m2.k<m2.k<byte[]>> b(BluetoothGattCharacteristic bluetoothGattCharacteristic, d0 d0Var);

    m2.a c(int i5, long j5, TimeUnit timeUnit);

    r<q0> d();

    r<Integer> e(int i5);

    r<byte[]> f(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr);

    r<byte[]> g(BluetoothGattCharacteristic bluetoothGattCharacteristic);

    m2.k<m2.k<byte[]>> h(BluetoothGattCharacteristic bluetoothGattCharacteristic, d0 d0Var);
}
