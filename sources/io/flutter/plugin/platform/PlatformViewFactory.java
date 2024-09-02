package io.flutter.plugin.platform;

import android.content.Context;
import io.flutter.plugin.common.MessageCodec;

public abstract class PlatformViewFactory {
    private final MessageCodec<Object> createArgsCodec;

    public PlatformViewFactory(MessageCodec<Object> messageCodec) {
        this.createArgsCodec = messageCodec;
    }

    public abstract PlatformView create(Context context, int i5, Object obj);

    public final MessageCodec<Object> getCreateArgsCodec() {
        return this.createArgsCodec;
    }
}
