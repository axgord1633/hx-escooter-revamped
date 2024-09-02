package com.signify.hue.flutterreactiveble;

import com.signify.hue.flutterreactiveble.ProtobufModel;
import io.flutter.plugin.common.MethodChannel;
import r2.e;

public final /* synthetic */ class j implements e {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f3953e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ PluginController f3954f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ProtobufModel.ChangeConnectionPriorityRequest f3955g;

    public /* synthetic */ j(MethodChannel.Result result, PluginController pluginController, ProtobufModel.ChangeConnectionPriorityRequest changeConnectionPriorityRequest) {
        this.f3953e = result;
        this.f3954f = pluginController;
        this.f3955g = changeConnectionPriorityRequest;
    }

    public final void accept(Object obj) {
        PluginController.m19requestConnectionPriority$lambda9(this.f3953e, this.f3954f, this.f3955g, (Throwable) obj);
    }
}
