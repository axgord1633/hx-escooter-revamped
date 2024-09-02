package r1;

import android.bluetooth.BluetoothDevice;
import java.util.concurrent.atomic.AtomicBoolean;
import m2.k;
import o1.b;
import p1.n0;
import p1.p0;
import p1.z;
import t1.n;
import y1.j;

class m implements p0 {

    /* renamed from: a  reason: collision with root package name */
    final BluetoothDevice f6691a;

    /* renamed from: b  reason: collision with root package name */
    final n f6692b;

    /* renamed from: c  reason: collision with root package name */
    private final b<n0.a> f6693c;

    /* renamed from: d  reason: collision with root package name */
    private final j f6694d;

    /* renamed from: e  reason: collision with root package name */
    final AtomicBoolean f6695e = new AtomicBoolean(false);

    m(BluetoothDevice bluetoothDevice, n nVar, b<n0.a> bVar, j jVar) {
        this.f6691a = bluetoothDevice;
        this.f6692b = nVar;
        this.f6693c = bVar;
        this.f6694d = jVar;
    }

    private String h(boolean z4) {
        return (!z4 || this.f6694d.a()) ? this.f6691a.getName() : "[NO BLUETOOTH_CONNECT PERMISSION]";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i() {
        this.f6695e.set(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ m2.n j(z zVar) {
        return this.f6695e.compareAndSet(false, true) ? this.f6692b.a(zVar).v(new l(this)) : k.G(new q1.b(this.f6691a.getAddress()));
    }

    public k<n0> a(boolean z4) {
        return g(new z.a().b(z4).c(true).a());
    }

    public BluetoothDevice b() {
        return this.f6691a;
    }

    public String c() {
        return this.f6691a.getAddress();
    }

    public k<n0.a> d() {
        return this.f6693c.t().q0(1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        return this.f6691a.equals(((m) obj).f6691a);
    }

    public k<n0> g(z zVar) {
        return k.o(new k(this, zVar));
    }

    public n0.a getConnectionState() {
        return this.f6693c.T0();
    }

    public String getName() {
        return h(false);
    }

    public int hashCode() {
        return this.f6691a.hashCode();
    }

    public String toString() {
        return "RxBleDeviceImpl{" + u1.b.d(this.f6691a.getAddress()) + ", name=" + h(true) + '}';
    }
}
