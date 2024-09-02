package com.signify.hue.flutterreactiveble.ble;

import java.util.concurrent.Callable;

public final /* synthetic */ class d0 implements Callable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f3885e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ EstablishConnectionResult f3886f;

    public /* synthetic */ d0(String str, EstablishConnectionResult establishConnectionResult) {
        this.f3885e = str;
        this.f3886f = establishConnectionResult;
    }

    public final Object call() {
        return ReactiveBleClient.m51requestConnectionPriority$lambda24$lambda23(this.f3885e, this.f3886f);
    }
}
