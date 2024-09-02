package w1;

import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import java.util.ArrayList;
import java.util.List;
import z1.d;
import z1.g;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f7478a;

    public b(int i5) {
        this.f7478a = i5;
    }

    private static void a(g gVar, ScanSettings.Builder builder) {
        builder.setCallbackType(gVar.b()).setMatchMode(gVar.d()).setNumOfMatches(gVar.e());
    }

    private static ScanFilter b(d dVar) {
        ScanFilter.Builder builder = new ScanFilter.Builder();
        if (dVar.l() != null) {
            builder.setServiceData(dVar.l(), dVar.j(), dVar.k());
        }
        if (dVar.e() != null) {
            builder.setDeviceAddress(dVar.e());
        }
        return builder.setDeviceName(dVar.f()).setManufacturerData(dVar.i(), dVar.g(), dVar.h()).setServiceUuid(dVar.m(), dVar.n()).build();
    }

    public List<ScanFilter> c(d... dVarArr) {
        if (!(dVarArr != null && dVarArr.length > 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(dVarArr.length);
        for (d b5 : dVarArr) {
            arrayList.add(b(b5));
        }
        return arrayList;
    }

    public ScanSettings d(g gVar) {
        ScanSettings.Builder builder = new ScanSettings.Builder();
        if (this.f7478a >= 23) {
            a(gVar, builder);
            if (this.f7478a >= 26) {
                ScanSettings.Builder unused = builder.setLegacy(gVar.c());
            }
        }
        return builder.setReportDelay(gVar.f()).setScanMode(gVar.g()).build();
    }
}
