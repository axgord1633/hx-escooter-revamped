package t1;

import android.bluetooth.BluetoothGatt;
import g0.c;
import g0.e;
import h0.a;

public final class g implements c<BluetoothGatt> {

    /* renamed from: a  reason: collision with root package name */
    private final a<a> f6878a;

    public g(a<a> aVar) {
        this.f6878a = aVar;
    }

    public static g a(a<a> aVar) {
        return new g(aVar);
    }

    public static BluetoothGatt c(a aVar) {
        return (BluetoothGatt) e.d(d.c(aVar));
    }

    /* renamed from: b */
    public BluetoothGatt get() {
        return c(this.f6878a.get());
    }
}
