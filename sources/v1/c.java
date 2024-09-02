package v1;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.DeadObjectException;
import java.util.concurrent.Callable;
import m2.r;
import m2.s;
import m2.u;
import m2.w;
import p1.n0;
import q1.f;
import q1.g;
import r1.j;
import r2.h;
import t1.i1;
import t1.l;
import x1.i;
import y1.t;

public class c extends j<BluetoothGatt> {

    /* renamed from: e  reason: collision with root package name */
    final BluetoothDevice f7171e;

    /* renamed from: f  reason: collision with root package name */
    final y1.b f7172f;

    /* renamed from: g  reason: collision with root package name */
    final i1 f7173g;

    /* renamed from: h  reason: collision with root package name */
    final t1.a f7174h;

    /* renamed from: i  reason: collision with root package name */
    final x f7175i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f7176j;

    /* renamed from: k  reason: collision with root package name */
    final l f7177k;

    class a implements r2.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f7178a;

        a(i iVar) {
            this.f7178a = iVar;
        }

        public void run() {
            this.f7178a.release();
        }
    }

    class b implements w<BluetoothGatt, BluetoothGatt> {
        b() {
        }

        /* renamed from: b */
        public r<BluetoothGatt> a(r<BluetoothGatt> rVar) {
            c cVar = c.this;
            if (cVar.f7176j) {
                return rVar;
            }
            x xVar = cVar.f7175i;
            return rVar.F(xVar.f7252a, xVar.f7253b, xVar.f7254c, cVar.n());
        }
    }

    /* renamed from: v1.c$c  reason: collision with other inner class name */
    class C0116c implements Callable<BluetoothGatt> {
        C0116c() {
        }

        /* renamed from: a */
        public BluetoothGatt call() {
            throw new g(c.this.f7174h.a(), q1.l.f6637b);
        }
    }

    class d implements u<BluetoothGatt> {

        class a implements h<n0.a> {
            a() {
            }

            /* renamed from: a */
            public boolean test(n0.a aVar) {
                return aVar == n0.a.CONNECTED;
            }
        }

        d() {
        }

        public void a(s<BluetoothGatt> sVar) {
            sVar.c((i3.b) c.this.l().j(c.this.f7173g.e().I(new a())).y(c.this.f7173g.l().L()).e().E(t.b(sVar)));
            c.this.f7177k.a(n0.a.CONNECTING);
            c cVar = c.this;
            c.this.f7174h.b(cVar.f7172f.a(cVar.f7171e, cVar.f7176j, cVar.f7173g.a()));
        }
    }

    class e implements Callable<BluetoothGatt> {
        e() {
        }

        /* renamed from: a */
        public BluetoothGatt call() {
            c.this.f7177k.a(n0.a.CONNECTED);
            return c.this.f7174h.a();
        }
    }

    c(BluetoothDevice bluetoothDevice, y1.b bVar, i1 i1Var, t1.a aVar, x xVar, boolean z4, l lVar) {
        this.f7171e = bluetoothDevice;
        this.f7172f = bVar;
        this.f7173g = i1Var;
        this.f7174h = aVar;
        this.f7175i = xVar;
        this.f7176j = z4;
        this.f7177k = lVar;
    }

    private r<BluetoothGatt> m() {
        return r.h(new d());
    }

    private w<BluetoothGatt, BluetoothGatt> o() {
        return new b();
    }

    /* access modifiers changed from: protected */
    public void f(m2.l<BluetoothGatt> lVar, i iVar) {
        lVar.c((i3.b) m().g(o()).k(new a(iVar)).E(t.a(lVar)));
        if (this.f7176j) {
            iVar.release();
        }
    }

    /* access modifiers changed from: protected */
    public f i(DeadObjectException deadObjectException) {
        return new q1.e(deadObjectException, this.f7171e.getAddress(), -1);
    }

    /* access modifiers changed from: package-private */
    public r<BluetoothGatt> l() {
        return r.t(new e());
    }

    /* access modifiers changed from: package-private */
    public r<BluetoothGatt> n() {
        return r.t(new C0116c());
    }

    public String toString() {
        return "ConnectOperation{" + u1.b.d(this.f7171e.getAddress()) + ", autoConnect=" + this.f7176j + '}';
    }
}
