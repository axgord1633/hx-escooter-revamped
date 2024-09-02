package com.signify.hue.flutterreactiveble.channelhandlers;

import com.signify.hue.flutterreactiveble.ProtobufModel;

public final /* synthetic */ class e implements r2.e {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ProtobufModel.NotifyCharacteristicRequest f3936e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ CharNotificationHandler f3937f;

    public /* synthetic */ e(ProtobufModel.NotifyCharacteristicRequest notifyCharacteristicRequest, CharNotificationHandler charNotificationHandler) {
        this.f3936e = notifyCharacteristicRequest;
        this.f3937f = charNotificationHandler;
    }

    public final void accept(Object obj) {
        CharNotificationHandler.m61subscribeToNotifications$lambda2(this.f3936e, this.f3937f, (Throwable) obj);
    }
}
