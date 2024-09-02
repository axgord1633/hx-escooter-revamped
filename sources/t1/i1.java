package t1;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import m2.q;
import o1.d;
import p1.b0;
import p1.n0;
import p1.q0;
import q1.i;
import q1.j;
import q1.k;
import q1.l;
import r2.f;
import y1.e;
import y1.g;

public class i1 {

    /* renamed from: a  reason: collision with root package name */
    private final q f6910a;

    /* renamed from: b  reason: collision with root package name */
    final a f6911b;

    /* renamed from: c  reason: collision with root package name */
    final y f6912c;

    /* renamed from: d  reason: collision with root package name */
    final q0 f6913d;

    /* renamed from: e  reason: collision with root package name */
    final o1.c<n0.a> f6914e = o1.c.R0();

    /* renamed from: f  reason: collision with root package name */
    final c<q0> f6915f = new c<>();

    /* renamed from: g  reason: collision with root package name */
    final c<e<UUID>> f6916g = new c<>();

    /* renamed from: h  reason: collision with root package name */
    final c<e<UUID>> f6917h = new c<>();

    /* renamed from: i  reason: collision with root package name */
    final d<g> f6918i = o1.c.R0().P0();

    /* renamed from: j  reason: collision with root package name */
    final c<e<BluetoothGattDescriptor>> f6919j = new c<>();

    /* renamed from: k  reason: collision with root package name */
    final c<e<BluetoothGattDescriptor>> f6920k = new c<>();

    /* renamed from: l  reason: collision with root package name */
    final c<Integer> f6921l = new c<>();

    /* renamed from: m  reason: collision with root package name */
    final c<Integer> f6922m = new c<>();

    /* renamed from: n  reason: collision with root package name */
    final c<Object> f6923n = new c<>();

    /* renamed from: o  reason: collision with root package name */
    private final f<k, m2.k<?>> f6924o = new a();

    /* renamed from: p  reason: collision with root package name */
    private final BluetoothGattCallback f6925p = new b();

    class a implements f<k, m2.k<?>> {
        a() {
        }

        /* renamed from: a */
        public m2.k<?> apply(k kVar) {
            return m2.k.G(kVar);
        }
    }

    class b extends BluetoothGattCallback {
        b() {
        }

        private boolean a(int i5) {
            return i5 == 0 || i5 == 3;
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            u1.b.l("onCharacteristicChanged", bluetoothGatt, bluetoothGattCharacteristic, true);
            i1.this.f6913d.a(bluetoothGatt, bluetoothGattCharacteristic);
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            if (i1.this.f6918i.O0()) {
                i1.this.f6918i.accept(new g(bluetoothGattCharacteristic.getUuid(), Integer.valueOf(bluetoothGattCharacteristic.getInstanceId()), bluetoothGattCharacteristic.getValue()));
            }
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i5) {
            u1.b.j("onCharacteristicRead", bluetoothGatt, i5, bluetoothGattCharacteristic, true);
            i1.this.f6913d.g(bluetoothGatt, bluetoothGattCharacteristic, i5);
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i5);
            if (i1.this.f6916g.a() && !i1.n(i1.this.f6916g, bluetoothGatt, bluetoothGattCharacteristic, i5, l.f6639d)) {
                i1.this.f6916g.f6928a.accept(new e(bluetoothGattCharacteristic.getUuid(), bluetoothGattCharacteristic.getValue()));
            }
        }

        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i5) {
            u1.b.j("onCharacteristicWrite", bluetoothGatt, i5, bluetoothGattCharacteristic, false);
            i1.this.f6913d.k(bluetoothGatt, bluetoothGattCharacteristic, i5);
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i5);
            if (i1.this.f6917h.a() && !i1.n(i1.this.f6917h, bluetoothGatt, bluetoothGattCharacteristic, i5, l.f6640e)) {
                i1.this.f6917h.f6928a.accept(new e(bluetoothGattCharacteristic.getUuid(), bluetoothGattCharacteristic.getValue()));
            }
        }

        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i5, int i6) {
            u1.b.i("onConnectionStateChange", bluetoothGatt, i5, i6);
            i1.this.f6913d.b(bluetoothGatt, i5, i6);
            super.onConnectionStateChange(bluetoothGatt, i5, i6);
            i1.this.f6911b.b(bluetoothGatt);
            if (a(i6)) {
                i1.this.f6912c.d(new q1.e(bluetoothGatt.getDevice().getAddress(), i5));
            } else if (i5 != 0) {
                i1.this.f6912c.e(new k(bluetoothGatt, i5, l.f6637b));
            }
            i1.this.f6914e.accept(i1.k(i6));
        }

        public void onConnectionUpdated(BluetoothGatt bluetoothGatt, int i5, int i6, int i7, int i8) {
            int i9 = i5;
            int i10 = i6;
            int i11 = i7;
            u1.b.m("onConnectionUpdated", bluetoothGatt, i8, i9, i10, i11);
            i1.this.f6913d.f(bluetoothGatt, i9, i10, i11, i8);
            if (i1.this.f6923n.a() && !i1.m(i1.this.f6923n, bluetoothGatt, i8, l.f6648m)) {
                i1.this.f6923n.f6928a.accept(new k(i5, i6, i7));
            }
        }

        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i5) {
            u1.b.k("onDescriptorRead", bluetoothGatt, i5, bluetoothGattDescriptor, true);
            i1.this.f6913d.c(bluetoothGatt, bluetoothGattDescriptor, i5);
            super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i5);
            if (i1.this.f6919j.a() && !i1.o(i1.this.f6919j, bluetoothGatt, bluetoothGattDescriptor, i5, l.f6643h)) {
                i1.this.f6919j.f6928a.accept(new e(bluetoothGattDescriptor, bluetoothGattDescriptor.getValue()));
            }
        }

        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i5) {
            u1.b.k("onDescriptorWrite", bluetoothGatt, i5, bluetoothGattDescriptor, false);
            i1.this.f6913d.d(bluetoothGatt, bluetoothGattDescriptor, i5);
            super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i5);
            if (i1.this.f6920k.a() && !i1.o(i1.this.f6920k, bluetoothGatt, bluetoothGattDescriptor, i5, l.f6644i)) {
                i1.this.f6920k.f6928a.accept(new e(bluetoothGattDescriptor, bluetoothGattDescriptor.getValue()));
            }
        }

        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i5, int i6) {
            u1.b.i("onMtuChanged", bluetoothGatt, i6, i5);
            i1.this.f6913d.e(bluetoothGatt, i5, i6);
            super.onMtuChanged(bluetoothGatt, i5, i6);
            if (i1.this.f6922m.a() && !i1.m(i1.this.f6922m, bluetoothGatt, i6, l.f6647l)) {
                i1.this.f6922m.f6928a.accept(Integer.valueOf(i5));
            }
        }

        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i5, int i6) {
            u1.b.i("onReadRemoteRssi", bluetoothGatt, i6, i5);
            i1.this.f6913d.h(bluetoothGatt, i5, i6);
            super.onReadRemoteRssi(bluetoothGatt, i5, i6);
            if (i1.this.f6921l.a() && !i1.m(i1.this.f6921l, bluetoothGatt, i6, l.f6646k)) {
                i1.this.f6921l.f6928a.accept(Integer.valueOf(i5));
            }
        }

        public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i5) {
            u1.b.h("onReliableWriteCompleted", bluetoothGatt, i5);
            i1.this.f6913d.i(bluetoothGatt, i5);
            super.onReliableWriteCompleted(bluetoothGatt, i5);
        }

        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i5) {
            u1.b.h("onServicesDiscovered", bluetoothGatt, i5);
            i1.this.f6913d.j(bluetoothGatt, i5);
            super.onServicesDiscovered(bluetoothGatt, i5);
            if (i1.this.f6915f.a() && !i1.m(i1.this.f6915f, bluetoothGatt, i5, l.f6638c)) {
                i1.this.f6915f.f6928a.accept(new q0(bluetoothGatt.getServices()));
            }
        }
    }

    private static class c<T> {

        /* renamed from: a  reason: collision with root package name */
        final o1.c<T> f6928a = o1.c.R0();

        /* renamed from: b  reason: collision with root package name */
        final o1.c<k> f6929b = o1.c.R0();

        c() {
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f6928a.O0() || this.f6929b.O0();
        }
    }

    public i1(q qVar, a aVar, y yVar, q0 q0Var) {
        this.f6910a = qVar;
        this.f6911b = aVar;
        this.f6912c = yVar;
        this.f6913d = q0Var;
    }

    private static boolean j(int i5) {
        return i5 != 0;
    }

    static n0.a k(int i5) {
        return i5 != 1 ? i5 != 2 ? i5 != 3 ? n0.a.DISCONNECTED : n0.a.DISCONNECTING : n0.a.CONNECTED : n0.a.CONNECTING;
    }

    static boolean m(c<?> cVar, BluetoothGatt bluetoothGatt, int i5, l lVar) {
        return j(i5) && p(cVar, new k(bluetoothGatt, i5, lVar));
    }

    static boolean n(c<?> cVar, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i5, l lVar) {
        return j(i5) && p(cVar, new i(bluetoothGatt, bluetoothGattCharacteristic, i5, lVar));
    }

    static boolean o(c<?> cVar, BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i5, l lVar) {
        return j(i5) && p(cVar, new j(bluetoothGatt, bluetoothGattDescriptor, i5, lVar));
    }

    private static boolean p(c<?> cVar, k kVar) {
        cVar.f6929b.accept(kVar);
        return true;
    }

    private <T> m2.k<T> s(c<T> cVar) {
        return m2.k.b0(this.f6912c.b(), cVar.f6928a, cVar.f6929b.M(this.f6924o));
    }

    public BluetoothGattCallback a() {
        return this.f6925p;
    }

    public m2.k<g> b() {
        return m2.k.a0(this.f6912c.b(), this.f6918i).q(0, TimeUnit.SECONDS, this.f6910a);
    }

    public m2.k<e<UUID>> c() {
        return s(this.f6916g).q(0, TimeUnit.SECONDS, this.f6910a);
    }

    public m2.k<e<UUID>> d() {
        return s(this.f6917h).q(0, TimeUnit.SECONDS, this.f6910a);
    }

    public m2.k<n0.a> e() {
        return this.f6914e.q(0, TimeUnit.SECONDS, this.f6910a);
    }

    public m2.k<e<BluetoothGattDescriptor>> f() {
        return s(this.f6920k).q(0, TimeUnit.SECONDS, this.f6910a);
    }

    public m2.k<Integer> g() {
        return s(this.f6922m).q(0, TimeUnit.SECONDS, this.f6910a);
    }

    public m2.k<Integer> h() {
        return s(this.f6921l).q(0, TimeUnit.SECONDS, this.f6910a);
    }

    public m2.k<q0> i() {
        return s(this.f6915f).q(0, TimeUnit.SECONDS, this.f6910a);
    }

    public <T> m2.k<T> l() {
        return this.f6912c.b();
    }

    public void q(b0 b0Var) {
        this.f6913d.m(b0Var);
    }

    public void r(BluetoothGattCallback bluetoothGattCallback) {
        this.f6913d.l(bluetoothGattCallback);
    }
}
