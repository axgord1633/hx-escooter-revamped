package w1;

import android.bluetooth.BluetoothDevice;
import r1.r;
import z1.b;
import z1.c;
import z1.e;

public class q implements r {

    /* renamed from: a  reason: collision with root package name */
    private final BluetoothDevice f7526a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7527b;

    /* renamed from: c  reason: collision with root package name */
    private final long f7528c;

    /* renamed from: d  reason: collision with root package name */
    private final e f7529d;

    /* renamed from: e  reason: collision with root package name */
    private final c f7530e;

    /* renamed from: f  reason: collision with root package name */
    private final b f7531f;

    public q(BluetoothDevice bluetoothDevice, int i5, long j5, e eVar, c cVar, b bVar) {
        this.f7526a = bluetoothDevice;
        this.f7527b = i5;
        this.f7528c = j5;
        this.f7529d = eVar;
        this.f7530e = cVar;
        this.f7531f = bVar;
    }

    public String a() {
        BluetoothDevice d5 = d();
        if (d5 == null) {
            return null;
        }
        return d5.getName();
    }

    public e b() {
        return this.f7529d;
    }

    public String c() {
        return this.f7526a.getAddress();
    }

    public BluetoothDevice d() {
        return this.f7526a;
    }

    public int e() {
        return this.f7527b;
    }

    public c f() {
        return this.f7530e;
    }

    public long g() {
        return this.f7528c;
    }

    public b h() {
        return this.f7531f;
    }
}
