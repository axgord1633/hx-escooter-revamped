package com.signify.hue.flutterreactiveble.ble;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public final class ConnectionUpdateSuccess extends ConnectionUpdate {
    private final int connectionState;
    private final String deviceId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionUpdateSuccess(String str, int i5) {
        super((g) null);
        k.e(str, "deviceId");
        this.deviceId = str;
        this.connectionState = i5;
    }

    public static /* synthetic */ ConnectionUpdateSuccess copy$default(ConnectionUpdateSuccess connectionUpdateSuccess, String str, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = connectionUpdateSuccess.deviceId;
        }
        if ((i6 & 2) != 0) {
            i5 = connectionUpdateSuccess.connectionState;
        }
        return connectionUpdateSuccess.copy(str, i5);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final int component2() {
        return this.connectionState;
    }

    public final ConnectionUpdateSuccess copy(String str, int i5) {
        k.e(str, "deviceId");
        return new ConnectionUpdateSuccess(str, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConnectionUpdateSuccess)) {
            return false;
        }
        ConnectionUpdateSuccess connectionUpdateSuccess = (ConnectionUpdateSuccess) obj;
        return k.a(this.deviceId, connectionUpdateSuccess.deviceId) && this.connectionState == connectionUpdateSuccess.connectionState;
    }

    public final int getConnectionState() {
        return this.connectionState;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public int hashCode() {
        return (this.deviceId.hashCode() * 31) + this.connectionState;
    }

    public String toString() {
        return "ConnectionUpdateSuccess(deviceId=" + this.deviceId + ", connectionState=" + this.connectionState + ')';
    }
}
