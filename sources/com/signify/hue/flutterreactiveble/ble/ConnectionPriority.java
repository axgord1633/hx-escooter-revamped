package com.signify.hue.flutterreactiveble.ble;

public enum ConnectionPriority {
    BALANCED(0),
    HIGH_PERFORMACE(1),
    LOW_POWER(2);
    
    private final int code;

    private ConnectionPriority(int i5) {
        this.code = i5;
    }

    public final int getCode() {
        return this.code;
    }
}
