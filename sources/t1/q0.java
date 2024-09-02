package t1;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import p1.b0;

class q0 {

    /* renamed from: a  reason: collision with root package name */
    private BluetoothGattCallback f6981a;

    /* renamed from: b  reason: collision with root package name */
    private b0 f6982b;

    q0() {
    }

    /* access modifiers changed from: package-private */
    public void a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGattCallback bluetoothGattCallback = this.f6981a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(BluetoothGatt bluetoothGatt, int i5, int i6) {
        BluetoothGattCallback bluetoothGattCallback = this.f6981a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onConnectionStateChange(bluetoothGatt, i5, i6);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i5) {
        BluetoothGattCallback bluetoothGattCallback = this.f6981a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i5);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i5) {
        BluetoothGattCallback bluetoothGattCallback = this.f6981a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i5);
        }
    }

    /* access modifiers changed from: package-private */
    public void e(BluetoothGatt bluetoothGatt, int i5, int i6) {
        BluetoothGattCallback bluetoothGattCallback = this.f6981a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onMtuChanged(bluetoothGatt, i5, i6);
        }
    }

    /* access modifiers changed from: package-private */
    public void f(BluetoothGatt bluetoothGatt, int i5, int i6, int i7, int i8) {
        b0 b0Var = this.f6982b;
        if (b0Var != null) {
            b0Var.a(bluetoothGatt, i5, i6, i7, i8);
        }
    }

    /* access modifiers changed from: package-private */
    public void g(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i5) {
        BluetoothGattCallback bluetoothGattCallback = this.f6981a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i5);
        }
    }

    /* access modifiers changed from: package-private */
    public void h(BluetoothGatt bluetoothGatt, int i5, int i6) {
        BluetoothGattCallback bluetoothGattCallback = this.f6981a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onReadRemoteRssi(bluetoothGatt, i5, i6);
        }
    }

    /* access modifiers changed from: package-private */
    public void i(BluetoothGatt bluetoothGatt, int i5) {
        BluetoothGattCallback bluetoothGattCallback = this.f6981a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onReliableWriteCompleted(bluetoothGatt, i5);
        }
    }

    /* access modifiers changed from: package-private */
    public void j(BluetoothGatt bluetoothGatt, int i5) {
        BluetoothGattCallback bluetoothGattCallback = this.f6981a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onServicesDiscovered(bluetoothGatt, i5);
        }
    }

    /* access modifiers changed from: package-private */
    public void k(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i5) {
        BluetoothGattCallback bluetoothGattCallback = this.f6981a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i5);
        }
    }

    /* access modifiers changed from: package-private */
    public void l(BluetoothGattCallback bluetoothGattCallback) {
        this.f6981a = bluetoothGattCallback;
    }

    /* access modifiers changed from: package-private */
    public void m(b0 b0Var) {
        this.f6982b = b0Var;
    }
}
