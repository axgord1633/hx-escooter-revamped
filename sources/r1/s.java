package r1;

import android.bluetooth.BluetoothGatt;
import android.os.DeadObjectException;
import java.util.concurrent.TimeUnit;
import m2.q;
import m2.r;
import q1.e;
import q1.f;
import q1.g;
import q1.h;
import q1.l;
import t1.i1;
import u1.b;
import v1.x;
import x1.i;
import y1.e0;

public abstract class s<T> extends j<T> {

    /* renamed from: e  reason: collision with root package name */
    private final BluetoothGatt f6708e;

    /* renamed from: f  reason: collision with root package name */
    private final i1 f6709f;

    /* renamed from: g  reason: collision with root package name */
    private final l f6710g;

    /* renamed from: h  reason: collision with root package name */
    private final x f6711h;

    public s(BluetoothGatt bluetoothGatt, i1 i1Var, l lVar, x xVar) {
        this.f6708e = bluetoothGatt;
        this.f6709f = i1Var;
        this.f6710g = lVar;
        this.f6711h = xVar;
    }

    /* access modifiers changed from: protected */
    public final void f(m2.l<T> lVar, i iVar) {
        e0 e0Var = new e0(lVar, iVar);
        r l5 = l(this.f6709f);
        x xVar = this.f6711h;
        long j5 = xVar.f7252a;
        TimeUnit timeUnit = xVar.f7253b;
        q qVar = xVar.f7254c;
        l5.F(j5, timeUnit, qVar, n(this.f6708e, this.f6709f, qVar)).K().g(e0Var);
        if (!m(this.f6708e)) {
            e0Var.cancel();
            e0Var.onError(new h(this.f6708e, this.f6710g));
        }
    }

    /* access modifiers changed from: protected */
    public f i(DeadObjectException deadObjectException) {
        return new e(deadObjectException, this.f6708e.getDevice().getAddress(), -1);
    }

    /* access modifiers changed from: protected */
    public abstract r<T> l(i1 i1Var);

    /* access modifiers changed from: protected */
    public abstract boolean m(BluetoothGatt bluetoothGatt);

    /* access modifiers changed from: protected */
    public r<T> n(BluetoothGatt bluetoothGatt, i1 i1Var, q qVar) {
        return r.o(new g(this.f6708e, this.f6710g));
    }

    public String toString() {
        return b.c(this.f6708e);
    }
}
