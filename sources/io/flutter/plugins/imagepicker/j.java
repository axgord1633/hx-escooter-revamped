package io.flutter.plugins.imagepicker;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.imagepicker.Messages;

public final /* synthetic */ class j implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.ImagePickerApi f5330a;

    public /* synthetic */ j(Messages.ImagePickerApi imagePickerApi) {
        this.f5330a = imagePickerApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.ImagePickerApi.CC.b(this.f5330a, obj, reply);
    }
}
