package com.signify.hue.flutterreactiveble.ble;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public final class ConnectionUpdateError extends ConnectionUpdate {
    private final String deviceId;
    private final String errorMessage;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionUpdateError(String str, String str2) {
        super((g) null);
        k.e(str, "deviceId");
        k.e(str2, "errorMessage");
        this.deviceId = str;
        this.errorMessage = str2;
    }

    public static /* synthetic */ ConnectionUpdateError copy$default(ConnectionUpdateError connectionUpdateError, String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = connectionUpdateError.deviceId;
        }
        if ((i5 & 2) != 0) {
            str2 = connectionUpdateError.errorMessage;
        }
        return connectionUpdateError.copy(str, str2);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final ConnectionUpdateError copy(String str, String str2) {
        k.e(str, "deviceId");
        k.e(str2, "errorMessage");
        return new ConnectionUpdateError(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConnectionUpdateError)) {
            return false;
        }
        ConnectionUpdateError connectionUpdateError = (ConnectionUpdateError) obj;
        return k.a(this.deviceId, connectionUpdateError.deviceId) && k.a(this.errorMessage, connectionUpdateError.errorMessage);
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public int hashCode() {
        return (this.deviceId.hashCode() * 31) + this.errorMessage.hashCode();
    }

    public String toString() {
        return "ConnectionUpdateError(deviceId=" + this.deviceId + ", errorMessage=" + this.errorMessage + ')';
    }
}
