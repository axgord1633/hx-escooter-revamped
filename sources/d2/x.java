package d2;

import f2.d;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class x implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MethodCall f4325e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f4326f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ i f4327g;

    public /* synthetic */ x(MethodCall methodCall, MethodChannel.Result result, i iVar) {
        this.f4325e = methodCall;
        this.f4326f = result;
        this.f4327g = iVar;
    }

    public final void run() {
        this.f4327g.v(new d(this.f4325e, this.f4326f));
    }
}
