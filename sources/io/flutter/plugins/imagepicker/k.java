package io.flutter.plugins.imagepicker;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.imagepicker.Messages;

public final /* synthetic */ class k implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.ImagePickerApi f5331a;

    public /* synthetic */ k(Messages.ImagePickerApi imagePickerApi) {
        this.f5331a = imagePickerApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.ImagePickerApi.CC.c(this.f5331a, obj, reply);
    }
}
