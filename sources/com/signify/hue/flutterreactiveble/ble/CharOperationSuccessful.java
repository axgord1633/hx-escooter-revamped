package com.signify.hue.flutterreactiveble.ble;

import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public final class CharOperationSuccessful extends CharOperationResult {
    private final String deviceId;
    private final List<Byte> value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CharOperationSuccessful(String str, List<Byte> list) {
        super((g) null);
        k.e(str, "deviceId");
        k.e(list, "value");
        this.deviceId = str;
        this.value = list;
    }

    public static /* synthetic */ CharOperationSuccessful copy$default(CharOperationSuccessful charOperationSuccessful, String str, List<Byte> list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = charOperationSuccessful.deviceId;
        }
        if ((i5 & 2) != 0) {
            list = charOperationSuccessful.value;
        }
        return charOperationSuccessful.copy(str, list);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final List<Byte> component2() {
        return this.value;
    }

    public final CharOperationSuccessful copy(String str, List<Byte> list) {
        k.e(str, "deviceId");
        k.e(list, "value");
        return new CharOperationSuccessful(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CharOperationSuccessful)) {
            return false;
        }
        CharOperationSuccessful charOperationSuccessful = (CharOperationSuccessful) obj;
        return k.a(this.deviceId, charOperationSuccessful.deviceId) && k.a(this.value, charOperationSuccessful.value);
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final List<Byte> getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.deviceId.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return "CharOperationSuccessful(deviceId=" + this.deviceId + ", value=" + this.value + ')';
    }
}
