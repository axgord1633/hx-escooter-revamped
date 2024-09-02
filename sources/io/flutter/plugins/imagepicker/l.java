package io.flutter.plugins.imagepicker;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.imagepicker.Messages;

public final /* synthetic */ class l implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.ImagePickerApi f5332a;

    public /* synthetic */ l(Messages.ImagePickerApi imagePickerApi) {
        this.f5332a = imagePickerApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.ImagePickerApi.CC.d(this.f5332a, obj, reply);
    }
}
