package v1;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import h0.a;
import java.util.concurrent.TimeUnit;
import m2.q;
import t1.i1;
import u1.c;

public class l implements k {

    /* renamed from: a  reason: collision with root package name */
    private final i1 f7214a;

    /* renamed from: b  reason: collision with root package name */
    private final BluetoothGatt f7215b;

    /* renamed from: c  reason: collision with root package name */
    private final c f7216c;

    /* renamed from: d  reason: collision with root package name */
    private final x f7217d;

    /* renamed from: e  reason: collision with root package name */
    private final q f7218e;

    /* renamed from: f  reason: collision with root package name */
    private final q f7219f;

    /* renamed from: g  reason: collision with root package name */
    private final a<n> f7220g;

    l(i1 i1Var, BluetoothGatt bluetoothGatt, c cVar, x xVar, q qVar, q qVar2, a<n> aVar) {
        this.f7214a = i1Var;
        this.f7215b = bluetoothGatt;
        this.f7216c = cVar;
        this.f7217d = xVar;
        this.f7218e = qVar;
        this.f7219f = qVar2;
        this.f7220g = aVar;
    }

    public i a(int i5) {
        return new i(this.f7214a, this.f7215b, this.f7217d, i5);
    }

    public w b(long j5, TimeUnit timeUnit) {
        return new w(this.f7214a, this.f7215b, this.f7216c, new x(j5, timeUnit, this.f7219f));
    }

    public b c(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        return new b(this.f7214a, this.f7215b, this.f7217d, bluetoothGattCharacteristic, bArr);
    }

    public e d(int i5, long j5, TimeUnit timeUnit) {
        return new e(this.f7214a, this.f7215b, this.f7217d, i5, new x(j5, timeUnit, this.f7219f));
    }

    public f e(BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr) {
        return new f(this.f7214a, this.f7215b, this.f7217d, 2, bluetoothGattDescriptor, bArr);
    }

    public a f(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return new a(this.f7214a, this.f7215b, this.f7217d, bluetoothGattCharacteristic);
    }
}
