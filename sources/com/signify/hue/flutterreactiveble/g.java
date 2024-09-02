package com.signify.hue.flutterreactiveble;

import com.signify.hue.flutterreactiveble.ProtobufModel;
import com.signify.hue.flutterreactiveble.ble.CharOperationResult;
import r2.e;

public final /* synthetic */ class g implements e {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ PluginController f3947e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ProtobufModel.ReadCharacteristicRequest f3948f;

    public /* synthetic */ g(PluginController pluginController, ProtobufModel.ReadCharacteristicRequest readCharacteristicRequest) {
        this.f3947e = pluginController;
        this.f3948f = readCharacteristicRequest;
    }

    public final void accept(Object obj) {
        PluginController.m16readCharacteristic$lambda2(this.f3947e, this.f3948f, (CharOperationResult) obj);
    }
}
