package com.signify.hue.flutterreactiveble;

import com.signify.hue.flutterreactiveble.ble.RequestConnectionPriorityResult;
import io.flutter.plugin.common.MethodChannel;
import r2.e;

public final /* synthetic */ class i implements e {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f3951e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ PluginController f3952f;

    public /* synthetic */ i(MethodChannel.Result result, PluginController pluginController) {
        this.f3951e = result;
        this.f3952f = pluginController;
    }

    public final void accept(Object obj) {
        PluginController.m18requestConnectionPriority$lambda8(this.f3951e, this.f3952f, (RequestConnectionPriorityResult) obj);
    }
}
