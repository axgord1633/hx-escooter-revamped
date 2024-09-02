package v1;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.os.DeadObjectException;
import m2.q;
import m2.r;
import m2.t;
import p1.n0;
import p2.c;
import q1.e;
import r1.j;
import r2.f;
import r2.h;
import t1.i1;
import t1.l;
import x1.i;

public class g extends j<Void> {

    /* renamed from: e  reason: collision with root package name */
    private final i1 f7190e;

    /* renamed from: f  reason: collision with root package name */
    private final t1.a f7191f;

    /* renamed from: g  reason: collision with root package name */
    private final String f7192g;

    /* renamed from: h  reason: collision with root package name */
    private final BluetoothManager f7193h;

    /* renamed from: i  reason: collision with root package name */
    private final q f7194i;

    /* renamed from: j  reason: collision with root package name */
    private final x f7195j;

    /* renamed from: k  reason: collision with root package name */
    private final l f7196k;

    class a implements t<BluetoothGatt> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ m2.l f7197e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ i f7198f;

        a(m2.l lVar, i iVar) {
            this.f7197e = lVar;
            this.f7198f = iVar;
        }

        /* renamed from: a */
        public void b(BluetoothGatt bluetoothGatt) {
            bluetoothGatt.close();
            g.this.l(this.f7197e, this.f7198f);
        }

        public void c(c cVar) {
        }

        public void onError(Throwable th) {
            r1.q.r(th, "Disconnect operation has been executed but finished with an error - considering disconnected.", new Object[0]);
            g.this.l(this.f7197e, this.f7198f);
        }
    }

    private static class b extends r<BluetoothGatt> {

        /* renamed from: e  reason: collision with root package name */
        final BluetoothGatt f7200e;

        /* renamed from: f  reason: collision with root package name */
        private final i1 f7201f;

        /* renamed from: g  reason: collision with root package name */
        private final q f7202g;

        class a implements f<n0.a, BluetoothGatt> {
            a() {
            }

            /* renamed from: a */
            public BluetoothGatt apply(n0.a aVar) {
                return b.this.f7200e;
            }
        }

        /* renamed from: v1.g$b$b  reason: collision with other inner class name */
        class C0117b implements h<n0.a> {
            C0117b() {
            }

            /* renamed from: a */
            public boolean test(n0.a aVar) {
                return aVar == n0.a.DISCONNECTED;
            }
        }

        class c implements Runnable {
            c() {
            }

            public void run() {
                b.this.f7200e.disconnect();
            }
        }

        b(BluetoothGatt bluetoothGatt, i1 i1Var, q qVar) {
            this.f7200e = bluetoothGatt;
            this.f7201f = i1Var;
            this.f7202g = qVar;
        }

        /* access modifiers changed from: protected */
        public void D(t<? super BluetoothGatt> tVar) {
            this.f7201f.e().I(new C0117b()).L().v(new a()).d(tVar);
            this.f7202g.a().b(new c());
        }
    }

    g(i1 i1Var, t1.a aVar, String str, BluetoothManager bluetoothManager, q qVar, x xVar, l lVar) {
        this.f7190e = i1Var;
        this.f7191f = aVar;
        this.f7192g = str;
        this.f7193h = bluetoothManager;
        this.f7194i = qVar;
        this.f7195j = xVar;
        this.f7196k = lVar;
    }

    private r<BluetoothGatt> m(BluetoothGatt bluetoothGatt) {
        b bVar = new b(bluetoothGatt, this.f7190e, this.f7194i);
        x xVar = this.f7195j;
        return bVar.F(xVar.f7252a, xVar.f7253b, xVar.f7254c, r.u(bluetoothGatt));
    }

    private r<BluetoothGatt> n(BluetoothGatt bluetoothGatt) {
        return o(bluetoothGatt) ? r.u(bluetoothGatt) : m(bluetoothGatt);
    }

    private boolean o(BluetoothGatt bluetoothGatt) {
        return this.f7193h.getConnectionState(bluetoothGatt.getDevice(), 7) == 0;
    }

    /* access modifiers changed from: protected */
    public void f(m2.l<Void> lVar, i iVar) {
        this.f7196k.a(n0.a.DISCONNECTING);
        BluetoothGatt a5 = this.f7191f.a();
        if (a5 == null) {
            r1.q.q("Disconnect operation has been executed but GATT instance was null - considering disconnected.", new Object[0]);
            l(lVar, iVar);
            return;
        }
        n(a5).z(this.f7194i).d(new a(lVar, iVar));
    }

    /* access modifiers changed from: protected */
    public q1.f i(DeadObjectException deadObjectException) {
        return new e(deadObjectException, this.f7192g, -1);
    }

    /* access modifiers changed from: package-private */
    public void l(m2.e<Void> eVar, i iVar) {
        this.f7196k.a(n0.a.DISCONNECTED);
        iVar.release();
        eVar.a();
    }

    public String toString() {
        return "DisconnectOperation{" + u1.b.d(this.f7192g) + '}';
    }
}
