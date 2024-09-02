package com.signify.hue.flutterreactiveble.model;

public enum ConnectionState {
    CONNECTING(0),
    CONNECTED(1),
    DISCONNECTING(2),
    DISCONNECTED(3),
    UNKNOWN(4);
    
    private final int code;

    private ConnectionState(int i5) {
        this.code = i5;
    }

    public final int getCode() {
        return this.code;
    }
}
