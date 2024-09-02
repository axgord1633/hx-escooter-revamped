package t1;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattService;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import m2.r;
import p1.q0;
import r2.h;
import v1.k;
import v1.x;

class k1 {

    /* renamed from: a  reason: collision with root package name */
    final x1.d f6949a;

    /* renamed from: b  reason: collision with root package name */
    final BluetoothGatt f6950b;

    /* renamed from: c  reason: collision with root package name */
    final k f6951c;

    /* renamed from: d  reason: collision with root package name */
    private r<q0> f6952d;

    /* renamed from: e  reason: collision with root package name */
    final l3.d<x> f6953e = l3.a.Q0().O0();

    /* renamed from: f  reason: collision with root package name */
    boolean f6954f = false;

    class a implements r2.e<p2.c> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ long f6955e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ TimeUnit f6956f;

        a(long j5, TimeUnit timeUnit) {
            this.f6955e = j5;
            this.f6956f = timeUnit;
        }

        /* renamed from: a */
        public void accept(p2.c cVar) {
            k1.this.f6953e.d(new x(this.f6955e, this.f6956f, k3.a.a()));
        }
    }

    class b implements r2.a {
        b() {
        }

        public void run() {
            k1.this.f6954f = true;
        }
    }

    class c implements r2.a {
        c() {
        }

        public void run() {
            k1.this.d();
        }
    }

    class d implements r2.f<List<BluetoothGattService>, q0> {
        d() {
        }

        /* renamed from: a */
        public q0 apply(List<BluetoothGattService> list) {
            return new q0(list);
        }
    }

    class e implements h<List<BluetoothGattService>> {
        e() {
        }

        /* renamed from: a */
        public boolean test(List<BluetoothGattService> list) {
            return list.size() > 0;
        }
    }

    class f implements Callable<List<BluetoothGattService>> {
        f() {
        }

        /* renamed from: a */
        public List<BluetoothGattService> call() {
            return k1.this.f6950b.getServices();
        }
    }

    class g implements r2.f<x, r<q0>> {
        g() {
        }

        /* renamed from: a */
        public r<q0> apply(x xVar) {
            return k1.this.f6949a.a(k1.this.f6951c.b(xVar.f7252a, xVar.f7253b)).L();
        }
    }

    k1(x1.d dVar, BluetoothGatt bluetoothGatt, k kVar) {
        this.f6949a = dVar;
        this.f6950b = bluetoothGatt;
        this.f6951c = kVar;
        d();
    }

    private m2.h<List<BluetoothGattService>> b() {
        return r.t(new f()).q(new e());
    }

    private r<x> c() {
        return this.f6953e.L();
    }

    private r2.f<x, r<q0>> e() {
        return new g();
    }

    private static r2.f<List<BluetoothGattService>, q0> f() {
        return new d();
    }

    /* access modifiers changed from: package-private */
    public r<q0> a(long j5, TimeUnit timeUnit) {
        return this.f6954f ? this.f6952d : this.f6952d.m(new a(j5, timeUnit));
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f6954f = false;
        this.f6952d = b().e(f()).g(c().r(e())).n(t2.a.a(new b())).l(t2.a.a(new c())).f();
    }
}
