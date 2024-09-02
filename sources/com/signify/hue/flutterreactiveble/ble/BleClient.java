package com.signify.hue.flutterreactiveble.ble;

import android.os.ParcelUuid;
import com.signify.hue.flutterreactiveble.model.ScanMode;
import com.signify.hue.flutterreactiveble.utils.Duration;
import java.util.List;
import java.util.UUID;
import m2.a;
import m2.k;
import m2.r;
import p1.q0;

public interface BleClient {
    a clearGattCache(String str);

    void connectToDevice(String str, Duration duration);

    void disconnectAllDevices();

    void disconnectDevice(String str);

    r<q0> discoverServices(String str);

    l3.a<ConnectionUpdate> getConnectionUpdateSubject();

    void initializeClient();

    r<MtuNegotiateResult> negotiateMtuSize(String str, int i5);

    k<BleStatus> observeBleStatus();

    r<CharOperationResult> readCharacteristic(String str, UUID uuid, int i5);

    r<RequestConnectionPriorityResult> requestConnectionPriority(String str, ConnectionPriority connectionPriority);

    k<ScanInfo> scanForDevices(List<ParcelUuid> list, ScanMode scanMode, boolean z4);

    k<byte[]> setupNotification(String str, UUID uuid, int i5);

    r<CharOperationResult> writeCharacteristicWithResponse(String str, UUID uuid, int i5, byte[] bArr);

    r<CharOperationResult> writeCharacteristicWithoutResponse(String str, UUID uuid, int i5, byte[] bArr);
}
