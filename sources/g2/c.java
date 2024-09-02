package g2;

import g2.a;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class c implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.c f4736a;

    public /* synthetic */ c(a.c cVar) {
        this.f4736a = cVar;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        d.c(this.f4736a, obj, reply);
    }
}
