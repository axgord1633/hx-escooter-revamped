package com.signify.hue.flutterreactiveble.ble;

import java.util.concurrent.Callable;

public final /* synthetic */ class c0 implements Callable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f3884e;

    public /* synthetic */ c0(String str) {
        this.f3884e = str;
    }

    public final Object call() {
        return ReactiveBleClient.m50requestConnectionPriority$lambda24$lambda22(this.f3884e);
    }
}
