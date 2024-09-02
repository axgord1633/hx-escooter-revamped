package r1;

import android.bluetooth.BluetoothDevice;
import java.util.concurrent.TimeUnit;
import m2.q;
import o1.b;
import p1.n0;
import t1.l;
import v1.x;
import y1.f0;

public abstract class c {

    class a implements l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f6676a;

        a(b bVar) {
            this.f6676a = bVar;
        }

        public void a(n0.a aVar) {
            this.f6676a.accept(aVar);
        }
    }

    static BluetoothDevice a(String str, f0 f0Var) {
        return f0Var.a(str);
    }

    static l b(b<n0.a> bVar) {
        return new a(bVar);
    }

    static b<n0.a> c() {
        return b.S0(n0.a.DISCONNECTED);
    }

    static x d(q qVar) {
        return new x(35, TimeUnit.SECONDS, qVar);
    }

    static x e(q qVar) {
        return new x(10, TimeUnit.SECONDS, qVar);
    }
}
