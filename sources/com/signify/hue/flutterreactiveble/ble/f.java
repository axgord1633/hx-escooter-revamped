package com.signify.hue.flutterreactiveble.ble;

import java.util.List;
import p1.p0;

public final /* synthetic */ class f implements r2.f {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f3891e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ DeviceConnector f3892f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ p0 f3893g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f3894h;

    public /* synthetic */ f(String str, DeviceConnector deviceConnector, p0 p0Var, boolean z4) {
        this.f3891e = str;
        this.f3892f = deviceConnector;
        this.f3893g = p0Var;
        this.f3894h = z4;
    }

    public final Object apply(Object obj) {
        return DeviceConnector.m24establishConnection$lambda2(this.f3891e, this.f3892f, this.f3893g, this.f3894h, (List) obj);
    }
}
