package com.signify.hue.flutterreactiveble.ble;

public enum Connectable {
    UNKNOWN(0),
    NOT_CONNECTABLE(1),
    CONNECTABLE(2);
    
    private final int code;

    private Connectable(int i5) {
        this.code = i5;
    }

    public final int getCode() {
        return this.code;
    }
}
