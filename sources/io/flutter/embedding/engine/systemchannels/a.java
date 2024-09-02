package io.flutter.embedding.engine.systemchannels;

import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class a implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KeyEventChannel.EventResponseHandler f5296a;

    public /* synthetic */ a(KeyEventChannel.EventResponseHandler eventResponseHandler) {
        this.f5296a = eventResponseHandler;
    }

    public final void reply(Object obj) {
        KeyEventChannel.lambda$createReplyHandler$0(this.f5296a, obj);
    }
}
