package com.signify.hue.flutterreactiveble;

import com.signify.hue.flutterreactiveble.ProtobufModel;
import r2.e;

public final /* synthetic */ class h implements e {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ PluginController f3949e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ProtobufModel.ReadCharacteristicRequest f3950f;

    public /* synthetic */ h(PluginController pluginController, ProtobufModel.ReadCharacteristicRequest readCharacteristicRequest) {
        this.f3949e = pluginController;
        this.f3950f = readCharacteristicRequest;
    }

    public final void accept(Object obj) {
        PluginController.m17readCharacteristic$lambda3(this.f3949e, this.f3950f, (Throwable) obj);
    }
}
