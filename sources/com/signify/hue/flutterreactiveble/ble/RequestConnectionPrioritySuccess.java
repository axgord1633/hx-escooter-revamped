package com.signify.hue.flutterreactiveble.ble;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public final class RequestConnectionPrioritySuccess extends RequestConnectionPriorityResult {
    private final String deviceId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RequestConnectionPrioritySuccess(String str) {
        super((g) null);
        k.e(str, "deviceId");
        this.deviceId = str;
    }

    public static /* synthetic */ RequestConnectionPrioritySuccess copy$default(RequestConnectionPrioritySuccess requestConnectionPrioritySuccess, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = requestConnectionPrioritySuccess.deviceId;
        }
        return requestConnectionPrioritySuccess.copy(str);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final RequestConnectionPrioritySuccess copy(String str) {
        k.e(str, "deviceId");
        return new RequestConnectionPrioritySuccess(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RequestConnectionPrioritySuccess) && k.a(this.deviceId, ((RequestConnectionPrioritySuccess) obj).deviceId);
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public int hashCode() {
        return this.deviceId.hashCode();
    }

    public String toString() {
        return "RequestConnectionPrioritySuccess(deviceId=" + this.deviceId + ')';
    }
}
