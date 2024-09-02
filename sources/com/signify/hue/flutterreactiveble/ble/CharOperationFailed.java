package com.signify.hue.flutterreactiveble.ble;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public final class CharOperationFailed extends CharOperationResult {
    private final String deviceId;
    private final String errorMessage;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CharOperationFailed(String str, String str2) {
        super((g) null);
        k.e(str, "deviceId");
        k.e(str2, "errorMessage");
        this.deviceId = str;
        this.errorMessage = str2;
    }

    public static /* synthetic */ CharOperationFailed copy$default(CharOperationFailed charOperationFailed, String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = charOperationFailed.deviceId;
        }
        if ((i5 & 2) != 0) {
            str2 = charOperationFailed.errorMessage;
        }
        return charOperationFailed.copy(str, str2);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final CharOperationFailed copy(String str, String str2) {
        k.e(str, "deviceId");
        k.e(str2, "errorMessage");
        return new CharOperationFailed(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CharOperationFailed)) {
            return false;
        }
        CharOperationFailed charOperationFailed = (CharOperationFailed) obj;
        return k.a(this.deviceId, charOperationFailed.deviceId) && k.a(this.errorMessage, charOperationFailed.errorMessage);
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
        return "CharOperationFailed(deviceId=" + this.deviceId + ", errorMessage=" + this.errorMessage + ')';
    }
}
