package com.signify.hue.flutterreactiveble;

import io.flutter.plugin.common.MethodChannel;
import r2.a;

public final /* synthetic */ class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f3877a;

    public /* synthetic */ b(MethodChannel.Result result) {
        this.f3877a = result;
    }

    public final void run() {
        PluginController.m8clearGattCache$lambda0(this.f3877a);
    }
}
