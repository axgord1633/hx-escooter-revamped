package com.signify.hue.flutterreactiveble.ble;

public enum BleStatus {
    UNKNOWN(0),
    UNSUPPORTED(1),
    UNAUTHORIZED(2),
    POWERED_OFF(3),
    LOCATION_SERVICES_DISABLED(4),
    READY(5);
    
    private final int code;

    private BleStatus(int i5) {
        this.code = i5;
    }

    public final int getCode() {
        return this.code;
    }
}
