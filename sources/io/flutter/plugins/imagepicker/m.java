package io.flutter.plugins.imagepicker;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.imagepicker.Messages;

public final /* synthetic */ class m implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.ImagePickerApi f5333a;

    public /* synthetic */ m(Messages.ImagePickerApi imagePickerApi) {
        this.f5333a = imagePickerApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.ImagePickerApi.CC.e(this.f5333a, obj, reply);
    }
}
