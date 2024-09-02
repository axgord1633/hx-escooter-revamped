package l0;

import io.flutter.plugin.common.EventChannel;
import m0.a;

public final /* synthetic */ class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventChannel.EventSink f5695a;

    public /* synthetic */ b(EventChannel.EventSink eventSink) {
        this.f5695a = eventSink;
    }

    public final void a(m0.b bVar) {
        this.f5695a.error(bVar.toString(), bVar.f(), (Object) null);
    }
}
