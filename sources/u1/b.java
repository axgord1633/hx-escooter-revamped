package u1;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import java.util.UUID;
import r1.q;
import v1.j;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f7099a = "0123456789ABCDEF".toCharArray();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final UUID f7100a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f7101b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f7102c;

        public a(UUID uuid, byte[] bArr, boolean z4) {
            this.f7100a = uuid;
            this.f7101b = bArr;
            this.f7102c = z4;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[uuid='");
            sb.append(b.g(this.f7100a));
            if (this.f7102c) {
                str = "', hexValue=" + b.a(this.f7101b);
            } else {
                str = "'";
            }
            sb.append(str);
            sb.append(']');
            return sb.toString();
        }
    }

    private b() {
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "null";
        }
        if (!q.h()) {
            return "[...]";
        }
        int length = bArr.length;
        if (length == 0) {
            return "[]";
        }
        int i5 = length - 1;
        int i6 = (length * 2) + (i5 * 2) + 2;
        char[] cArr = new char[i6];
        for (int i7 = 0; i7 < length; i7++) {
            byte b5 = bArr[i7] & 255;
            int i8 = i7 * 2;
            int i9 = i8 + 1 + i8;
            char[] cArr2 = f7099a;
            cArr[i9] = cArr2[b5 >>> 4];
            cArr[i9 + 1] = cArr2[b5 & 15];
        }
        for (int i10 = 0; i10 < i5; i10++) {
            int i11 = i10 * 2;
            int i12 = i11 + 1 + i11 + 2;
            cArr[i12] = ',';
            cArr[i12 + 1] = ' ';
        }
        cArr[0] = '[';
        cArr[i6 - 1] = ']';
        return new String(cArr);
    }

    private static String b() {
        return " %24s()";
    }

    public static String c(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt == null ? "MAC=null" : d(bluetoothGatt.getDevice().getAddress());
    }

    public static String d(String str) {
        if (str == null) {
            return "MAC=null";
        }
        int g5 = q.g();
        if (g5 == 3) {
            str = str.substring(0, 15) + "XX";
        } else if (g5 == Integer.MAX_VALUE) {
            str = "XX:XX:XX:XX:XX:XX";
        }
        return String.format("MAC='%s'", new Object[]{str});
    }

    private static String e() {
        return ", status=%d";
    }

    private static String f() {
        return ", value=%s";
    }

    public static String g(UUID uuid) {
        return q.j() == 2 ? uuid.toString() : "...";
    }

    public static void h(String str, BluetoothGatt bluetoothGatt, int i5) {
        if (q.l(4)) {
            q.k(c(bluetoothGatt) + b() + e(), str, Integer.valueOf(i5));
        }
    }

    public static void i(String str, BluetoothGatt bluetoothGatt, int i5, int i6) {
        if (q.l(4)) {
            q.k(c(bluetoothGatt) + b() + e() + f(), str, Integer.valueOf(i5), Integer.valueOf(i6));
        }
    }

    public static void j(String str, BluetoothGatt bluetoothGatt, int i5, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z4) {
        if (q.l(4)) {
            a aVar = new a(bluetoothGattCharacteristic.getUuid(), bluetoothGattCharacteristic.getValue(), z4);
            q.k(c(bluetoothGatt) + b() + e() + f(), str, Integer.valueOf(i5), aVar);
        }
    }

    public static void k(String str, BluetoothGatt bluetoothGatt, int i5, BluetoothGattDescriptor bluetoothGattDescriptor, boolean z4) {
        if (q.l(4)) {
            a aVar = new a(bluetoothGattDescriptor.getUuid(), bluetoothGattDescriptor.getValue(), z4);
            q.k(c(bluetoothGatt) + b() + e() + f(), str, Integer.valueOf(i5), aVar);
        }
    }

    public static void l(String str, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z4) {
        if (q.l(4)) {
            a aVar = new a(bluetoothGattCharacteristic.getUuid(), bluetoothGattCharacteristic.getValue(), z4);
            q.k(c(bluetoothGatt) + b() + f(), str, aVar);
        }
    }

    public static void m(String str, BluetoothGatt bluetoothGatt, int i5, int i6, int i7, int i8) {
        if (q.l(4)) {
            q.k(c(bluetoothGatt) + b() + e() + ", interval=%d (%.2f ms), latency=%d, timeout=%d (%.0f ms)", str, Integer.valueOf(i5), Integer.valueOf(i6), Float.valueOf(((float) i6) * 1.25f), Integer.valueOf(i7), Integer.valueOf(i8), Float.valueOf(((float) i8) * 10.0f));
        }
    }

    public static void n(j jVar, long j5, long j6) {
        if (q.l(3)) {
            q.b("FINISHED %s(%d) in %d ms", jVar.getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(jVar)), Long.valueOf(j6 - j5));
        }
    }

    public static void o(j jVar) {
        if (q.l(3)) {
            q.b("QUEUED   %s(%d)", jVar.getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(jVar)));
        }
    }

    public static void p(j jVar) {
        if (q.l(3)) {
            q.b("REMOVED  %s(%d)", jVar.getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(jVar)));
        }
    }

    public static void q(j jVar) {
        q.k("RUNNING  %s", jVar);
    }

    public static void r(j jVar) {
        if (q.l(2)) {
            q.p("SKIPPED  %s(%d) just before running — is disposed", jVar.getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(jVar)));
        }
    }

    public static void s(j jVar) {
        if (q.l(3)) {
            q.b("STARTED  %s(%d)", jVar.getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(jVar)));
        }
    }

    public static a t(BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z4) {
        return new a(bluetoothGattCharacteristic.getUuid(), bluetoothGattCharacteristic.getValue(), z4);
    }
}
