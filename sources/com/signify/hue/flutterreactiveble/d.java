package com.signify.hue.flutterreactiveble;

import io.flutter.plugin.common.MethodChannel;
import r2.e;

public final /* synthetic */ class d implements e {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f3941e;

    public /* synthetic */ d(MethodChannel.Result result) {
        this.f3941e = result;
    }

    public final void accept(Object obj) {
        PluginController.m11discoverServices$lambda11(this.f3941e, (Throwable) obj);
    }
}
