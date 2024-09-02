package d2;

import f2.d;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MethodCall f4316e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f4317f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ i f4318g;

    public /* synthetic */ u(MethodCall methodCall, MethodChannel.Result result, i iVar) {
        this.f4316e = methodCall;
        this.f4317f = result;
        this.f4318g = iVar;
    }

    public final void run() {
        this.f4318g.E(new d(this.f4316e, this.f4317f));
    }
}
