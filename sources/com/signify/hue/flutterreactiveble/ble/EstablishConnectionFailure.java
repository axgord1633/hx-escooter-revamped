package com.signify.hue.flutterreactiveble.ble;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public final class EstablishConnectionFailure extends EstablishConnectionResult {
    private final String deviceId;
    private final String errorMessage;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EstablishConnectionFailure(String str, String str2) {
        super((g) null);
        k.e(str, "deviceId");
        k.e(str2, "errorMessage");
        this.deviceId = str;
        this.errorMessage = str2;
    }

    public static /* synthetic */ EstablishConnectionFailure copy$default(EstablishConnectionFailure establishConnectionFailure, String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = establishConnectionFailure.deviceId;
        }
        if ((i5 & 2) != 0) {
            str2 = establishConnectionFailure.errorMessage;
        }
        return establishConnectionFailure.copy(str, str2);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final EstablishConnectionFailure copy(String str, String str2) {
        k.e(str, "deviceId");
        k.e(str2, "errorMessage");
        return new EstablishConnectionFailure(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EstablishConnectionFailure)) {
            return false;
        }
        EstablishConnectionFailure establishConnectionFailure = (EstablishConnectionFailure) obj;
        return k.a(this.deviceId, establishConnectionFailure.deviceId) && k.a(this.errorMessage, establishConnectionFailure.errorMessage);
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
        return "EstablishConnectionFailure(deviceId=" + this.deviceId + ", errorMessage=" + this.errorMessage + ')';
    }
}
