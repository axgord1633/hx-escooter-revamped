package l0;

import android.location.Location;
import io.flutter.plugin.common.EventChannel;
import n0.g0;
import n0.y;

public final /* synthetic */ class a implements g0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventChannel.EventSink f5694a;

    public /* synthetic */ a(EventChannel.EventSink eventSink) {
        this.f5694a = eventSink;
    }

    public final void a(Location location) {
        this.f5694a.success(y.b(location));
    }
}
