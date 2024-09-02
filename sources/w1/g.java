package w1;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import r1.q;
import y1.h0;
import z1.b;
import z1.c;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private final h0 f7502a;

    /* renamed from: b  reason: collision with root package name */
    private final k f7503b;

    public g(h0 h0Var, k kVar) {
        this.f7502a = h0Var;
        this.f7503b = kVar;
    }

    private static c d(int i5) {
        if (i5 == 1) {
            return c.CALLBACK_TYPE_ALL_MATCHES;
        }
        if (i5 == 2) {
            return c.CALLBACK_TYPE_FIRST_MATCH;
        }
        if (i5 == 4) {
            return c.CALLBACK_TYPE_MATCH_LOST;
        }
        q.q("Unknown callback type %d -> check android.bluetooth.le.ScanSettings", Integer.valueOf(i5));
        return c.CALLBACK_TYPE_UNKNOWN;
    }

    public q a(int i5, ScanResult scanResult) {
        return new q(scanResult.getDevice(), scanResult.getRssi(), scanResult.getTimestampNanos(), new z(scanResult.getScanRecord(), this.f7502a), d(i5), this.f7503b.a(scanResult));
    }

    public q b(BluetoothDevice bluetoothDevice, int i5, byte[] bArr) {
        return new q(bluetoothDevice, i5, System.nanoTime(), this.f7502a.b(bArr), c.CALLBACK_TYPE_UNSPECIFIED, b.LEGACY_UNKNOWN);
    }

    public q c(ScanResult scanResult) {
        return new q(scanResult.getDevice(), scanResult.getRssi(), scanResult.getTimestampNanos(), new z(scanResult.getScanRecord(), this.f7502a), c.CALLBACK_TYPE_BATCH, this.f7503b.a(scanResult));
    }
}
