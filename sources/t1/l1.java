package t1;

import android.bluetooth.BluetoothGatt;
import g0.c;
import h0.a;
import v1.k;
import x1.d;

public final class l1 implements c<k1> {

    /* renamed from: a  reason: collision with root package name */
    private final a<d> f6965a;

    /* renamed from: b  reason: collision with root package name */
    private final a<BluetoothGatt> f6966b;

    /* renamed from: c  reason: collision with root package name */
    private final a<k> f6967c;

    public l1(a<d> aVar, a<BluetoothGatt> aVar2, a<k> aVar3) {
        this.f6965a = aVar;
        this.f6966b = aVar2;
        this.f6967c = aVar3;
    }

    public static l1 a(a<d> aVar, a<BluetoothGatt> aVar2, a<k> aVar3) {
        return new l1(aVar, aVar2, aVar3);
    }

    public static k1 c(d dVar, BluetoothGatt bluetoothGatt, k kVar) {
        return new k1(dVar, bluetoothGatt, kVar);
    }

    /* renamed from: b */
    public k1 get() {
        return c(this.f6965a.get(), this.f6966b.get(), this.f6967c.get());
    }
}
