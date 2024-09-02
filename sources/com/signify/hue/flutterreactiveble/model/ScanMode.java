package com.signify.hue.flutterreactiveble.model;

public enum ScanMode {
    OPPORTUNISTIC(-1),
    LOW_POWER(0),
    BALANCED(1),
    LOW_LATENCY(2);
    
    private final int code;

    private ScanMode(int i5) {
        this.code = i5;
    }

    public final int getCode() {
        return this.code;
    }
}
