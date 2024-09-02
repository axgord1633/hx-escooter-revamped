package com.signify.hue.flutterreactiveble.ble;

import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import l3.a;
import m3.q;
import v3.l;

/* synthetic */ class ReactiveBleClient$createDeviceConnector$1 extends j implements l<ConnectionUpdate, q> {
    ReactiveBleClient$createDeviceConnector$1(Object obj) {
        super(1, obj, a.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ConnectionUpdate) obj);
        return q.f5904a;
    }

    public final void invoke(ConnectionUpdate connectionUpdate) {
        k.e(connectionUpdate, "p0");
        ((a) this.receiver).d(connectionUpdate);
    }
}
