package com.signify.hue.flutterreactiveble.model;

public enum ConnectionErrorType {
    UNKNOWN(0),
    FAILEDTOCONNECT(1);
    
    private final int code;

    private ConnectionErrorType(int i5) {
        this.code = i5;
    }

    public final int getCode() {
        return this.code;
    }
}
