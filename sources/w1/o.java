package w1;

import android.bluetooth.le.ScanResult;
import z1.b;

public class o implements k {
    public b a(ScanResult scanResult) {
        return scanResult.isConnectable() ? b.CONNECTABLE : b.NOT_CONNECTABLE;
    }
}
