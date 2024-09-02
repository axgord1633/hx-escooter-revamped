package com.signify.hue.flutterreactiveble;

import io.flutter.plugin.common.MethodChannel;
import r2.e;

public final /* synthetic */ class c implements e {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ PluginController f3929e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f3930f;

    public /* synthetic */ c(PluginController pluginController, MethodChannel.Result result) {
        this.f3929e = pluginController;
        this.f3930f = result;
    }

    public final void accept(Object obj) {
        PluginController.m9clearGattCache$lambda1(this.f3929e, this.f3930f, (Throwable) obj);
    }
}
