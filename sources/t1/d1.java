package t1;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import l3.b;
import m2.k;
import m2.n;
import m2.o;
import p1.d0;
import q1.c;
import q1.d;
import y1.h;

class d1 {

    /* renamed from: h  reason: collision with root package name */
    static final UUID f6859h = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");

    /* renamed from: a  reason: collision with root package name */
    final byte[] f6860a;

    /* renamed from: b  reason: collision with root package name */
    final byte[] f6861b;

    /* renamed from: c  reason: collision with root package name */
    final byte[] f6862c;

    /* renamed from: d  reason: collision with root package name */
    final BluetoothGatt f6863d;

    /* renamed from: e  reason: collision with root package name */
    final i1 f6864e;

    /* renamed from: f  reason: collision with root package name */
    final u f6865f;

    /* renamed from: g  reason: collision with root package name */
    final Map<h, y1.a> f6866g = new HashMap();

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6867a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                p1.d0[] r0 = p1.d0.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6867a = r0
                p1.d0 r1 = p1.d0.COMPAT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f6867a     // Catch:{ NoSuchFieldError -> 0x001d }
                p1.d0 r1 = p1.d0.QUICK_SETUP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f6867a     // Catch:{ NoSuchFieldError -> 0x0028 }
                p1.d0 r1 = p1.d0.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: t1.d1.a.<clinit>():void");
        }
    }

    d1(byte[] bArr, byte[] bArr2, byte[] bArr3, BluetoothGatt bluetoothGatt, i1 i1Var, u uVar) {
        this.f6860a = bArr;
        this.f6861b = bArr2;
        this.f6862c = bArr3;
        this.f6863d = bluetoothGatt;
        this.f6864e = i1Var;
        this.f6865f = uVar;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void m(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z4) {
        if (!bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z4)) {
            throw new c(bluetoothGattCharacteristic, 1, (Throwable) null);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ n o(d0 d0Var, BluetoothGattCharacteristic bluetoothGattCharacteristic, u uVar, byte[] bArr, k kVar) {
        int i5 = a.f6867a[d0Var.ordinal()];
        if (i5 == 1) {
            return kVar;
        }
        if (i5 != 2) {
            return z(bluetoothGattCharacteristic, uVar, bArr).d(kVar);
        }
        m2.a W = z(bluetoothGattCharacteristic, uVar, bArr).o().i0().O0(2).W();
        return kVar.c0(W).Z(new c1(W));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q(b bVar, h hVar, BluetoothGattCharacteristic bluetoothGattCharacteristic, d0 d0Var) {
        bVar.a();
        synchronized (this.f6866g) {
            this.f6866g.remove(hVar);
        }
        v(this.f6863d, bluetoothGattCharacteristic, false).e(y(this.f6865f, bluetoothGattCharacteristic, this.f6862c, d0Var)).l(t2.a.f7034c, t2.a.d());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ n r(BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z4, d0 d0Var) {
        synchronized (this.f6866g) {
            h hVar = new h(bluetoothGattCharacteristic.getUuid(), Integer.valueOf(bluetoothGattCharacteristic.getInstanceId()));
            y1.a aVar = this.f6866g.get(hVar);
            boolean z5 = true;
            if (aVar == null) {
                byte[] bArr = z4 ? this.f6861b : this.f6860a;
                b Q0 = b.Q0();
                k<R> S0 = v(this.f6863d, bluetoothGattCharacteristic, true).d(y1.d0.b(u(this.f6864e, hVar))).j(w(this.f6865f, bluetoothGattCharacteristic, bArr, d0Var)).Z(new u0(Q0)).v(new v0(this, Q0, hVar, bluetoothGattCharacteristic, d0Var)).d0(this.f6864e.l()).m0(1).S0();
                this.f6866g.put(hVar, new y1.a(S0, z4));
                return S0;
            } else if (aVar.f7715b == z4) {
                k<k<byte[]>> kVar = aVar.f7714a;
                return kVar;
            } else {
                UUID uuid = bluetoothGattCharacteristic.getUuid();
                if (z4) {
                    z5 = false;
                }
                k G = k.G(new d(uuid, z5));
                return G;
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ m2.c s(d0 d0Var, BluetoothGattCharacteristic bluetoothGattCharacteristic, u uVar, byte[] bArr, m2.a aVar) {
        return d0Var == d0.COMPAT ? aVar : aVar.c(z(bluetoothGattCharacteristic, uVar, bArr));
    }

    static k<byte[]> u(i1 i1Var, h hVar) {
        return i1Var.b().I(new z0(hVar)).Z(new a1());
    }

    static m2.a v(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z4) {
        return m2.a.g(new y0(bluetoothGatt, bluetoothGattCharacteristic, z4));
    }

    static o<k<byte[]>, k<byte[]>> w(u uVar, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, d0 d0Var) {
        return new w0(d0Var, bluetoothGattCharacteristic, uVar, bArr);
    }

    static m2.d y(u uVar, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, d0 d0Var) {
        return new x0(d0Var, bluetoothGattCharacteristic, uVar, bArr);
    }

    static m2.a z(BluetoothGattCharacteristic bluetoothGattCharacteristic, u uVar, byte[] bArr) {
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(f6859h);
        return descriptor == null ? m2.a.f(new c(bluetoothGattCharacteristic, 2, (Throwable) null)) : uVar.a(descriptor, bArr).k(new b1(bluetoothGattCharacteristic));
    }

    /* access modifiers changed from: package-private */
    public k<k<byte[]>> x(BluetoothGattCharacteristic bluetoothGattCharacteristic, d0 d0Var, boolean z4) {
        return k.o(new t0(this, bluetoothGattCharacteristic, z4, d0Var));
    }
}
