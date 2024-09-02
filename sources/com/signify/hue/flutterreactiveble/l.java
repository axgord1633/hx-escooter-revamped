package com.signify.hue.flutterreactiveble;

import com.signify.hue.flutterreactiveble.ProtobufModel;
import io.flutter.plugin.common.MethodChannel;
import r2.e;

public final /* synthetic */ class l implements e {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f3959e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ PluginController f3960f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ProtobufModel.WriteCharacteristicRequest f3961g;

    public /* synthetic */ l(MethodChannel.Result result, PluginController pluginController, ProtobufModel.WriteCharacteristicRequest writeCharacteristicRequest) {
        this.f3959e = result;
        this.f3960f = pluginController;
        this.f3961g = writeCharacteristicRequest;
    }

    public final void accept(Object obj) {
        PluginController.m13executeWriteAndPropagateResultToChannel$lambda5(this.f3959e, this.f3960f, this.f3961g, (Throwable) obj);
    }
}
