package com.signify.hue.flutterreactiveble.channelhandlers;

import com.signify.hue.flutterreactiveble.ProtobufModel;
import r2.e;

public final /* synthetic */ class d implements e {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ CharNotificationHandler f3934e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ProtobufModel.NotifyCharacteristicRequest f3935f;

    public /* synthetic */ d(CharNotificationHandler charNotificationHandler, ProtobufModel.NotifyCharacteristicRequest notifyCharacteristicRequest) {
        this.f3934e = charNotificationHandler;
        this.f3935f = notifyCharacteristicRequest;
    }

    public final void accept(Object obj) {
        CharNotificationHandler.m60subscribeToNotifications$lambda1(this.f3934e, this.f3935f, (byte[]) obj);
    }
}
