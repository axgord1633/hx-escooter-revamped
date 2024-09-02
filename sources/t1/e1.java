package t1;

import android.bluetooth.BluetoothGatt;
import g0.c;
import h0.a;

public final class e1 implements c<d1> {

    /* renamed from: a  reason: collision with root package name */
    private final a<byte[]> f6870a;

    /* renamed from: b  reason: collision with root package name */
    private final a<byte[]> f6871b;

    /* renamed from: c  reason: collision with root package name */
    private final a<byte[]> f6872c;

    /* renamed from: d  reason: collision with root package name */
    private final a<BluetoothGatt> f6873d;

    /* renamed from: e  reason: collision with root package name */
    private final a<i1> f6874e;

    /* renamed from: f  reason: collision with root package name */
    private final a<u> f6875f;

    public e1(a<byte[]> aVar, a<byte[]> aVar2, a<byte[]> aVar3, a<BluetoothGatt> aVar4, a<i1> aVar5, a<u> aVar6) {
        this.f6870a = aVar;
        this.f6871b = aVar2;
        this.f6872c = aVar3;
        this.f6873d = aVar4;
        this.f6874e = aVar5;
        this.f6875f = aVar6;
    }

    public static e1 a(a<byte[]> aVar, a<byte[]> aVar2, a<byte[]> aVar3, a<BluetoothGatt> aVar4, a<i1> aVar5, a<u> aVar6) {
        return new e1(aVar, aVar2, aVar3, aVar4, aVar5, aVar6);
    }

    public static d1 c(byte[] bArr, byte[] bArr2, byte[] bArr3, BluetoothGatt bluetoothGatt, i1 i1Var, Object obj) {
        return new d1(bArr, bArr2, bArr3, bluetoothGatt, i1Var, (u) obj);
    }

    /* renamed from: b */
    public d1 get() {
        return c(this.f6870a.get(), this.f6871b.get(), this.f6872c.get(), this.f6873d.get(), this.f6874e.get(), this.f6875f.get());
    }
}
