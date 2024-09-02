package com.signify.hue.flutterreactiveble.model;

public enum NegotiateMtuErrorType {
    UNKNOWN(0);
    
    private final int code;

    private NegotiateMtuErrorType(int i5) {
        this.code = i5;
    }

    public final int getCode() {
        return this.code;
    }
}
