package com.signify.hue.flutterreactiveble.ble;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public final class MtuNegotiateSuccesful extends MtuNegotiateResult {
    private final String deviceId;
    private final int size;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MtuNegotiateSuccesful(String str, int i5) {
        super((g) null);
        k.e(str, "deviceId");
        this.deviceId = str;
        this.size = i5;
    }

    public static /* synthetic */ MtuNegotiateSuccesful copy$default(MtuNegotiateSuccesful mtuNegotiateSuccesful, String str, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = mtuNegotiateSuccesful.deviceId;
        }
        if ((i6 & 2) != 0) {
            i5 = mtuNegotiateSuccesful.size;
        }
        return mtuNegotiateSuccesful.copy(str, i5);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final int component2() {
        return this.size;
    }

    public final MtuNegotiateSuccesful copy(String str, int i5) {
        k.e(str, "deviceId");
        return new MtuNegotiateSuccesful(str, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MtuNegotiateSuccesful)) {
            return false;
        }
        MtuNegotiateSuccesful mtuNegotiateSuccesful = (MtuNegotiateSuccesful) obj;
        return k.a(this.deviceId, mtuNegotiateSuccesful.deviceId) && this.size == mtuNegotiateSuccesful.size;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final int getSize() {
        return this.size;
    }

    public int hashCode() {
        return (this.deviceId.hashCode() * 31) + this.size;
    }

    public String toString() {
        return "MtuNegotiateSuccesful(deviceId=" + this.deviceId + ", size=" + this.size + ')';
    }
}
