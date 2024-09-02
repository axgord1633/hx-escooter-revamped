package com.signify.hue.flutterreactiveble.ble;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public final class RequestConnectionPriorityFailed extends RequestConnectionPriorityResult {
    private final String deviceId;
    private final String errorMessage;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RequestConnectionPriorityFailed(String str, String str2) {
        super((g) null);
        k.e(str, "deviceId");
        k.e(str2, "errorMessage");
        this.deviceId = str;
        this.errorMessage = str2;
    }

    public static /* synthetic */ RequestConnectionPriorityFailed copy$default(RequestConnectionPriorityFailed requestConnectionPriorityFailed, String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = requestConnectionPriorityFailed.deviceId;
        }
        if ((i5 & 2) != 0) {
            str2 = requestConnectionPriorityFailed.errorMessage;
        }
        return requestConnectionPriorityFailed.copy(str, str2);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final RequestConnectionPriorityFailed copy(String str, String str2) {
        k.e(str, "deviceId");
        k.e(str2, "errorMessage");
        return new RequestConnectionPriorityFailed(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RequestConnectionPriorityFailed)) {
            return false;
        }
        RequestConnectionPriorityFailed requestConnectionPriorityFailed = (RequestConnectionPriorityFailed) obj;
        return k.a(this.deviceId, requestConnectionPriorityFailed.deviceId) && k.a(this.errorMessage, requestConnectionPriorityFailed.errorMessage);
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
        return "RequestConnectionPriorityFailed(deviceId=" + this.deviceId + ", errorMessage=" + this.errorMessage + ')';
    }
}
