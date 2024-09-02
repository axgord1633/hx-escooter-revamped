package w1;

import android.bluetooth.le.ScanRecord;
import android.os.Build;
import android.os.ParcelUuid;
import android.util.SparseArray;
import java.util.List;
import java.util.Map;
import y1.h0;
import z1.e;

public class z implements e {

    /* renamed from: a  reason: collision with root package name */
    private final ScanRecord f7550a;

    /* renamed from: b  reason: collision with root package name */
    private final h0 f7551b;

    public z(ScanRecord scanRecord, h0 h0Var) {
        this.f7550a = scanRecord;
        this.f7551b = h0Var;
    }

    public String a() {
        return this.f7550a.getDeviceName();
    }

    public List<ParcelUuid> b() {
        return this.f7550a.getServiceUuids();
    }

    public byte[] c() {
        return this.f7550a.getBytes();
    }

    public Map<ParcelUuid, byte[]> d() {
        return this.f7550a.getServiceData();
    }

    public byte[] e(ParcelUuid parcelUuid) {
        return this.f7550a.getServiceData(parcelUuid);
    }

    public byte[] f(int i5) {
        return this.f7550a.getManufacturerSpecificData(i5);
    }

    public List<ParcelUuid> g() {
        return Build.VERSION.SDK_INT >= 29 ? this.f7550a.getServiceSolicitationUuids() : this.f7551b.b(this.f7550a.getBytes()).g();
    }

    public SparseArray<byte[]> h() {
        return this.f7550a.getManufacturerSpecificData();
    }
}
