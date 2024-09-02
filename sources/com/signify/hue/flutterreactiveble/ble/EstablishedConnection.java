package com.signify.hue.flutterreactiveble.ble;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import p1.n0;

public final class EstablishedConnection extends EstablishConnectionResult {
    private final String deviceId;
    private final n0 rxConnection;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EstablishedConnection(String str, n0 n0Var) {
        super((g) null);
        k.e(str, "deviceId");
        k.e(n0Var, "rxConnection");
        this.deviceId = str;
        this.rxConnection = n0Var;
    }

    public static /* synthetic */ EstablishedConnection copy$default(EstablishedConnection establishedConnection, String str, n0 n0Var, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = establishedConnection.deviceId;
        }
        if ((i5 & 2) != 0) {
            n0Var = establishedConnection.rxConnection;
        }
        return establishedConnection.copy(str, n0Var);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final n0 component2() {
        return this.rxConnection;
    }

    public final EstablishedConnection copy(String str, n0 n0Var) {
        k.e(str, "deviceId");
        k.e(n0Var, "rxConnection");
        return new EstablishedConnection(str, n0Var);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EstablishedConnection)) {
            return false;
        }
        EstablishedConnection establishedConnection = (EstablishedConnection) obj;
        return k.a(this.deviceId, establishedConnection.deviceId) && k.a(this.rxConnection, establishedConnection.rxConnection);
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final n0 getRxConnection() {
        return this.rxConnection;
    }

    public int hashCode() {
        return (this.deviceId.hashCode() * 31) + this.rxConnection.hashCode();
    }

    public String toString() {
        return "EstablishedConnection(deviceId=" + this.deviceId + ", rxConnection=" + this.rxConnection + ')';
    }
}
