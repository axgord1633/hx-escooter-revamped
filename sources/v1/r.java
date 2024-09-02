package v1;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import com.yalantis.ucrop.BuildConfig;
import java.util.Arrays;
import java.util.List;
import m2.l;
import q1.m;
import w1.b;
import w1.f;
import w1.g;
import w1.q;
import y1.f0;
import z1.d;

public class r extends p<q, ScanCallback> {

    /* renamed from: f  reason: collision with root package name */
    final g f7238f;

    /* renamed from: g  reason: collision with root package name */
    private final b f7239g;

    /* renamed from: h  reason: collision with root package name */
    private final z1.g f7240h;

    /* renamed from: i  reason: collision with root package name */
    final f f7241i;

    /* renamed from: j  reason: collision with root package name */
    private final d[] f7242j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public l<q> f7243k = null;

    class a extends ScanCallback {
        a() {
        }

        public void onBatchScanResults(List<ScanResult> list) {
            l o5;
            for (ScanResult c5 : list) {
                q c6 = r.this.f7238f.c(c5);
                if (r.this.f7241i.b(c6) && (o5 = r.this.f7243k) != null) {
                    o5.d(c6);
                }
            }
        }

        public void onScanFailed(int i5) {
            l o5 = r.this.f7243k;
            if (o5 != null) {
                o5.e(new m(r.q(i5)));
            }
        }

        public void onScanResult(int i5, ScanResult scanResult) {
            l o5;
            if (!r.this.f7241i.a() && r1.q.l(3) && r1.q.i()) {
                ScanRecord scanRecord = scanResult.getScanRecord();
                Object[] objArr = new Object[4];
                objArr[0] = u1.b.d(scanResult.getDevice().getAddress());
                objArr[1] = scanResult.getDevice().getName();
                objArr[2] = Integer.valueOf(scanResult.getRssi());
                objArr[3] = u1.b.a(scanRecord != null ? scanRecord.getBytes() : null);
                r1.q.b("%s, name=%s, rssi=%d, data=%s", objArr);
            }
            q a5 = r.this.f7238f.a(i5, scanResult);
            if (r.this.f7241i.b(a5) && (o5 = r.this.f7243k) != null) {
                o5.d(a5);
            }
        }
    }

    public r(f0 f0Var, g gVar, b bVar, z1.g gVar2, f fVar, d[] dVarArr) {
        super(f0Var);
        this.f7238f = gVar;
        this.f7240h = gVar2;
        this.f7241i = fVar;
        this.f7242j = dVarArr;
        this.f7239g = bVar;
    }

    static int q(int i5) {
        if (i5 == 1) {
            return 5;
        }
        if (i5 == 2) {
            return 6;
        }
        if (i5 == 3) {
            return 7;
        }
        if (i5 == 4) {
            return 8;
        }
        if (i5 == 5) {
            return 9;
        }
        r1.q.q("Encountered unknown scanning error code: %d -> check android.bluetooth.le.ScanCallback", new Object[0]);
        return Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public ScanCallback l(l<q> lVar) {
        this.f7243k = lVar;
        return new a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public boolean m(f0 f0Var, ScanCallback scanCallback) {
        if (this.f7241i.a()) {
            r1.q.b("No library side filtering —> debug logs of scanned devices disabled", new Object[0]);
        }
        f0Var.d(this.f7239g.c(this.f7242j), this.f7239g.d(this.f7240h), scanCallback);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public void n(f0 f0Var, ScanCallback scanCallback) {
        f0Var.f(scanCallback);
        l<q> lVar = this.f7243k;
        if (lVar != null) {
            lVar.a();
            this.f7243k = null;
        }
    }

    public String toString() {
        String str;
        d[] dVarArr = this.f7242j;
        boolean z4 = dVarArr == null || dVarArr.length == 0;
        boolean a5 = this.f7241i.a();
        StringBuilder sb = new StringBuilder();
        sb.append("ScanOperationApi21{");
        String str2 = BuildConfig.FLAVOR;
        if (z4) {
            str = str2;
        } else {
            str = "ANY_MUST_MATCH -> nativeFilters=" + Arrays.toString(this.f7242j);
        }
        sb.append(str);
        sb.append((z4 || a5) ? str2 : " and then ");
        if (!a5) {
            str2 = "ANY_MUST_MATCH -> " + this.f7241i;
        }
        sb.append(str2);
        sb.append('}');
        return sb.toString();
    }
}
