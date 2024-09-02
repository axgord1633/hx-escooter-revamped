package com.signify.hue.flutterreactiveble;

import com.signify.hue.flutterreactiveble.ble.MtuNegotiateResult;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class e implements r2.e {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f3942e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ PluginController f3943f;

    public /* synthetic */ e(MethodChannel.Result result, PluginController pluginController) {
        this.f3942e = result;
        this.f3943f = pluginController;
    }

    public final void accept(Object obj) {
        PluginController.m14negotiateMtuSize$lambda6(this.f3942e, this.f3943f, (MtuNegotiateResult) obj);
    }
}
