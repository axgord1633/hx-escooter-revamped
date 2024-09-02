package com.signify.hue.flutterreactiveble.ble;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.k;

public final class ScanInfo {
    private final Connectable connectable;
    private final String deviceId;
    private final byte[] manufacturerData;
    private final String name;
    private final int rssi;
    private final Map<UUID, byte[]> serviceData;
    private final List<UUID> serviceUuids;

    public ScanInfo(String str, String str2, int i5, Connectable connectable2, Map<UUID, byte[]> map, List<UUID> list, byte[] bArr) {
        k.e(str, "deviceId");
        k.e(str2, "name");
        k.e(connectable2, "connectable");
        k.e(map, "serviceData");
        k.e(list, "serviceUuids");
        k.e(bArr, "manufacturerData");
        this.deviceId = str;
        this.name = str2;
        this.rssi = i5;
        this.connectable = connectable2;
        this.serviceData = map;
        this.serviceUuids = list;
        this.manufacturerData = bArr;
    }

    public static /* synthetic */ ScanInfo copy$default(ScanInfo scanInfo, String str, String str2, int i5, Connectable connectable2, Map<UUID, byte[]> map, List<UUID> list, byte[] bArr, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = scanInfo.deviceId;
        }
        if ((i6 & 2) != 0) {
            str2 = scanInfo.name;
        }
        String str3 = str2;
        if ((i6 & 4) != 0) {
            i5 = scanInfo.rssi;
        }
        int i7 = i5;
        if ((i6 & 8) != 0) {
            connectable2 = scanInfo.connectable;
        }
        Connectable connectable3 = connectable2;
        if ((i6 & 16) != 0) {
            map = scanInfo.serviceData;
        }
        Map<UUID, byte[]> map2 = map;
        if ((i6 & 32) != 0) {
            list = scanInfo.serviceUuids;
        }
        List<UUID> list2 = list;
        if ((i6 & 64) != 0) {
            bArr = scanInfo.manufacturerData;
        }
        return scanInfo.copy(str, str3, i7, connectable3, map2, list2, bArr);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.rssi;
    }

    public final Connectable component4() {
        return this.connectable;
    }

    public final Map<UUID, byte[]> component5() {
        return this.serviceData;
    }

    public final List<UUID> component6() {
        return this.serviceUuids;
    }

    public final byte[] component7() {
        return this.manufacturerData;
    }

    public final ScanInfo copy(String str, String str2, int i5, Connectable connectable2, Map<UUID, byte[]> map, List<UUID> list, byte[] bArr) {
        k.e(str, "deviceId");
        k.e(str2, "name");
        k.e(connectable2, "connectable");
        k.e(map, "serviceData");
        k.e(list, "serviceUuids");
        byte[] bArr2 = bArr;
        k.e(bArr2, "manufacturerData");
        return new ScanInfo(str, str2, i5, connectable2, map, list, bArr2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!k.a(ScanInfo.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        k.c(obj, "null cannot be cast to non-null type com.signify.hue.flutterreactiveble.ble.ScanInfo");
        ScanInfo scanInfo = (ScanInfo) obj;
        return k.a(this.deviceId, scanInfo.deviceId) && k.a(this.name, scanInfo.name) && this.rssi == scanInfo.rssi && this.connectable == scanInfo.connectable && k.a(this.serviceData, scanInfo.serviceData) && k.a(this.serviceUuids, scanInfo.serviceUuids) && Arrays.equals(this.manufacturerData, scanInfo.manufacturerData);
    }

    public final Connectable getConnectable() {
        return this.connectable;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final byte[] getManufacturerData() {
        return this.manufacturerData;
    }

    public final String getName() {
        return this.name;
    }

    public final int getRssi() {
        return this.rssi;
    }

    public final Map<UUID, byte[]> getServiceData() {
        return this.serviceData;
    }

    public final List<UUID> getServiceUuids() {
        return this.serviceUuids;
    }

    public int hashCode() {
        return (((((((((((this.deviceId.hashCode() * 31) + this.name.hashCode()) * 31) + this.rssi) * 31) + this.connectable.hashCode()) * 31) + this.serviceData.hashCode()) * 31) + this.serviceUuids.hashCode()) * 31) + Arrays.hashCode(this.manufacturerData);
    }

    public String toString() {
        return "ScanInfo(deviceId=" + this.deviceId + ", name=" + this.name + ", rssi=" + this.rssi + ", connectable=" + this.connectable + ", serviceData=" + this.serviceData + ", serviceUuids=" + this.serviceUuids + ", manufacturerData=" + Arrays.toString(this.manufacturerData) + ')';
    }
}
