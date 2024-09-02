package r1;

import android.bluetooth.BluetoothDevice;
import g0.c;
import h0.a;
import o1.b;
import p1.n0;
import y1.j;

public final class n implements c<m> {

    /* renamed from: a  reason: collision with root package name */
    private final a<BluetoothDevice> f6696a;

    /* renamed from: b  reason: collision with root package name */
    private final a<t1.n> f6697b;

    /* renamed from: c  reason: collision with root package name */
    private final a<b<n0.a>> f6698c;

    /* renamed from: d  reason: collision with root package name */
    private final a<j> f6699d;

    public n(a<BluetoothDevice> aVar, a<t1.n> aVar2, a<b<n0.a>> aVar3, a<j> aVar4) {
        this.f6696a = aVar;
        this.f6697b = aVar2;
        this.f6698c = aVar3;
        this.f6699d = aVar4;
    }

    public static n a(a<BluetoothDevice> aVar, a<t1.n> aVar2, a<b<n0.a>> aVar3, a<j> aVar4) {
        return new n(aVar, aVar2, aVar3, aVar4);
    }

    public static m c(BluetoothDevice bluetoothDevice, t1.n nVar, b<n0.a> bVar, j jVar) {
        return new m(bluetoothDevice, nVar, bVar, jVar);
    }

    /* renamed from: b */
    public m get() {
        return c(this.f6696a.get(), this.f6697b.get(), this.f6698c.get(), this.f6699d.get());
    }
}
