package com.signify.hue.flutterreactiveble;

import com.signify.hue.flutterreactiveble.ProtobufModel;
import io.flutter.plugin.common.MethodChannel;
import r2.e;

public final /* synthetic */ class f implements e {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f3944e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ PluginController f3945f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ProtobufModel.NegotiateMtuRequest f3946g;

    public /* synthetic */ f(MethodChannel.Result result, PluginController pluginController, ProtobufModel.NegotiateMtuRequest negotiateMtuRequest) {
        this.f3944e = result;
        this.f3945f = pluginController;
        this.f3946g = negotiateMtuRequest;
    }

    public final void accept(Object obj) {
        PluginController.m15negotiateMtuSize$lambda7(this.f3944e, this.f3945f, this.f3946g, (Throwable) obj);
    }
}
