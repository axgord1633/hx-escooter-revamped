package r1;

import android.bluetooth.BluetoothDevice;
import g0.c;
import g0.e;
import h0.a;
import y1.f0;

public final class d implements c<BluetoothDevice> {

    /* renamed from: a  reason: collision with root package name */
    private final a<String> f6677a;

    /* renamed from: b  reason: collision with root package name */
    private final a<f0> f6678b;

    public d(a<String> aVar, a<f0> aVar2) {
        this.f6677a = aVar;
        this.f6678b = aVar2;
    }

    public static d a(a<String> aVar, a<f0> aVar2) {
        return new d(aVar, aVar2);
    }

    public static BluetoothDevice c(String str, f0 f0Var) {
        return (BluetoothDevice) e.d(c.a(str, f0Var));
    }

    /* renamed from: b */
    public BluetoothDevice get() {
        return c(this.f6677a.get(), this.f6678b.get());
    }
}
