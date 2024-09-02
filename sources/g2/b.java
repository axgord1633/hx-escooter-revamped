package g2;

import g2.a;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class b implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.c f4735a;

    public /* synthetic */ b(a.c cVar) {
        this.f4735a = cVar;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        d.b(this.f4735a, obj, reply);
    }
}
