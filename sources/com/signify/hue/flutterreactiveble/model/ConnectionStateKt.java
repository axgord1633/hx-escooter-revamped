package com.signify.hue.flutterreactiveble.model;

import kotlin.jvm.internal.k;
import p1.n0;

public final class ConnectionStateKt {
    public static final ConnectionState toConnectionState(n0.a aVar) {
        k.e(aVar, "<this>");
        String name = aVar.name();
        switch (name.hashCode()) {
            case -2087582999:
                if (name.equals("CONNECTED")) {
                    return ConnectionState.CONNECTED;
                }
                break;
            case -1052098138:
                if (name.equals("DISCONNECTING")) {
                    return ConnectionState.DISCONNECTING;
                }
                break;
            case -290559304:
                if (name.equals("CONNECTING")) {
                    return ConnectionState.CONNECTING;
                }
                break;
            case 935892539:
                if (name.equals("DISCONNECTED")) {
                    return ConnectionState.DISCONNECTED;
                }
                break;
        }
        return ConnectionState.UNKNOWN;
    }
}
