package com.signify.hue.flutterreactiveble;

import com.signify.hue.flutterreactiveble.ProtobufModel;
import io.flutter.plugin.common.MethodChannel;
import p1.q0;
import r2.e;

public final /* synthetic */ class a implements e {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f3874e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ PluginController f3875f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ProtobufModel.DiscoverServicesRequest f3876g;

    public /* synthetic */ a(MethodChannel.Result result, PluginController pluginController, ProtobufModel.DiscoverServicesRequest discoverServicesRequest) {
        this.f3874e = result;
        this.f3875f = pluginController;
        this.f3876g = discoverServicesRequest;
    }

    public final void accept(Object obj) {
        PluginController.m10discoverServices$lambda10(this.f3874e, this.f3875f, this.f3876g, (q0) obj);
    }
}
