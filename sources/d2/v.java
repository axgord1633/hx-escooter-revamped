package d2;

import f2.d;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MethodCall f4319e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f4320f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ i f4321g;

    public /* synthetic */ v(MethodCall methodCall, MethodChannel.Result result, i iVar) {
        this.f4319e = methodCall;
        this.f4320f = result;
        this.f4321g = iVar;
    }

    public final void run() {
        this.f4321g.P(new d(this.f4319e, this.f4320f));
    }
}
