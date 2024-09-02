package y1;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import java.util.List;
import q1.f;
import r1.q;

public class f0 {

    /* renamed from: b  reason: collision with root package name */
    private static f f7740b = new f("bluetoothAdapter is null");

    /* renamed from: a  reason: collision with root package name */
    private final BluetoothAdapter f7741a;

    public f0(BluetoothAdapter bluetoothAdapter) {
        this.f7741a = bluetoothAdapter;
    }

    public BluetoothDevice a(String str) {
        BluetoothAdapter bluetoothAdapter = this.f7741a;
        if (bluetoothAdapter != null) {
            return bluetoothAdapter.getRemoteDevice(str);
        }
        throw f7740b;
    }

    public boolean b() {
        return this.f7741a != null;
    }

    public boolean c() {
        BluetoothAdapter bluetoothAdapter = this.f7741a;
        return bluetoothAdapter != null && bluetoothAdapter.isEnabled();
    }

    public void d(List<ScanFilter> list, ScanSettings scanSettings, ScanCallback scanCallback) {
        BluetoothAdapter bluetoothAdapter = this.f7741a;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.getBluetoothLeScanner().startScan(list, scanSettings, scanCallback);
            return;
        }
        throw f7740b;
    }

    public boolean e(BluetoothAdapter.LeScanCallback leScanCallback) {
        BluetoothAdapter bluetoothAdapter = this.f7741a;
        if (bluetoothAdapter != null) {
            return bluetoothAdapter.startLeScan(leScanCallback);
        }
        throw f7740b;
    }

    public void f(ScanCallback scanCallback) {
        BluetoothAdapter bluetoothAdapter = this.f7741a;
        if (bluetoothAdapter == null) {
            throw f7740b;
        } else if (!bluetoothAdapter.isEnabled()) {
            q.p("BluetoothAdapter is disabled, calling BluetoothLeScanner.stopScan(ScanCallback) may cause IllegalStateException", new Object[0]);
        } else {
            BluetoothLeScanner bluetoothLeScanner = this.f7741a.getBluetoothLeScanner();
            if (bluetoothLeScanner == null) {
                q.q("Cannot call BluetoothLeScanner.stopScan(ScanCallback) on 'null' reference; BluetoothAdapter.isEnabled() == %b", Boolean.valueOf(this.f7741a.isEnabled()));
                return;
            }
            bluetoothLeScanner.stopScan(scanCallback);
        }
    }

    public void g(BluetoothAdapter.LeScanCallback leScanCallback) {
        BluetoothAdapter bluetoothAdapter = this.f7741a;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.stopLeScan(leScanCallback);
            return;
        }
        throw f7740b;
    }
}
