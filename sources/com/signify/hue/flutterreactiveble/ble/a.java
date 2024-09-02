package com.signify.hue.flutterreactiveble.ble;

import m2.k;
import m2.n;
import m2.o;

public final /* synthetic */ class a implements o {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f3878a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeviceConnector f3879b;

    public /* synthetic */ a(boolean z4, DeviceConnector deviceConnector) {
        this.f3878a = z4;
        this.f3879b = deviceConnector;
    }

    public final n a(k kVar) {
        return DeviceConnector.m21connectDevice$lambda9(this.f3878a, this.f3879b, kVar);
    }
}
