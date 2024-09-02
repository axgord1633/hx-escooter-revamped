package io.flutter.embedding.android;

import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;

public final /* synthetic */ class k implements KeyEventChannel.EventResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KeyboardManager.Responder.OnKeyEventHandledCallback f5261a;

    public /* synthetic */ k(KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        this.f5261a = onKeyEventHandledCallback;
    }

    public final void onFrameworkResponse(boolean z4) {
        this.f5261a.onKeyEventHandled(z4);
    }
}
