package com.signify.hue.flutterreactiveble;

import com.signify.hue.flutterreactiveble.ProtobufModel;
import com.signify.hue.flutterreactiveble.ble.CharOperationResult;
import io.flutter.plugin.common.MethodChannel;
import r2.e;

public final /* synthetic */ class k implements e {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f3956e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ PluginController f3957f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ProtobufModel.WriteCharacteristicRequest f3958g;

    public /* synthetic */ k(MethodChannel.Result result, PluginController pluginController, ProtobufModel.WriteCharacteristicRequest writeCharacteristicRequest) {
        this.f3956e = result;
        this.f3957f = pluginController;
        this.f3958g = writeCharacteristicRequest;
    }

    public final void accept(Object obj) {
        PluginController.m12executeWriteAndPropagateResultToChannel$lambda4(this.f3956e, this.f3957f, this.f3958g, (CharOperationResult) obj);
    }
}
