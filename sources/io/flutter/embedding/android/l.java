package io.flutter.embedding.android;

import io.flutter.embedding.android.KeyboardManager;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;

public final /* synthetic */ class l implements BinaryMessenger.BinaryReply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KeyboardManager.Responder.OnKeyEventHandledCallback f5262a;

    public /* synthetic */ l(KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        this.f5262a = onKeyEventHandledCallback;
    }

    public final void reply(ByteBuffer byteBuffer) {
        KeyEmbedderResponder.lambda$sendKeyEvent$2(this.f5262a, byteBuffer);
    }
}
