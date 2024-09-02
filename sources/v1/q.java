package v1;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.yalantis.ucrop.BuildConfig;
import m2.l;
import u1.b;
import w1.f;
import w1.g;
import y1.f0;

public class q extends p<w1.q, BluetoothAdapter.LeScanCallback> {

    /* renamed from: f  reason: collision with root package name */
    final g f7234f;

    /* renamed from: g  reason: collision with root package name */
    final f f7235g;

    class a implements BluetoothAdapter.LeScanCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f7236a;

        a(l lVar) {
            this.f7236a = lVar;
        }

        public void onLeScan(BluetoothDevice bluetoothDevice, int i5, byte[] bArr) {
            if (!q.this.f7235g.a() && r1.q.l(3) && r1.q.i()) {
                r1.q.b("%s, name=%s, rssi=%d, data=%s", b.d(bluetoothDevice.getAddress()), bluetoothDevice.getName(), Integer.valueOf(i5), b.a(bArr));
            }
            w1.q b5 = q.this.f7234f.b(bluetoothDevice, i5, bArr);
            if (q.this.f7235g.b(b5)) {
                this.f7236a.d(b5);
            }
        }
    }

    public q(f0 f0Var, g gVar, f fVar) {
        super(f0Var);
        this.f7234f = gVar;
        this.f7235g = fVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public BluetoothAdapter.LeScanCallback l(l<w1.q> lVar) {
        return new a(lVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public boolean m(f0 f0Var, BluetoothAdapter.LeScanCallback leScanCallback) {
        if (this.f7235g.a()) {
            r1.q.b("No library side filtering —> debug logs of scanned devices disabled", new Object[0]);
        }
        return f0Var.e(leScanCallback);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public void n(f0 f0Var, BluetoothAdapter.LeScanCallback leScanCallback) {
        f0Var.g(leScanCallback);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("ScanOperationApi18{");
        if (this.f7235g.a()) {
            str = BuildConfig.FLAVOR;
        } else {
            str = "ANY_MUST_MATCH -> " + this.f7235g;
        }
        sb.append(str);
        sb.append('}');
        return sb.toString();
    }
}
