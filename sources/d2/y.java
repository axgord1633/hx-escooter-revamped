package d2;

import f2.d;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class y implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MethodCall f4328e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f4329f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ i f4330g;

    public /* synthetic */ y(MethodCall methodCall, MethodChannel.Result result, i iVar) {
        this.f4328e = methodCall;
        this.f4329f = result;
        this.f4330g = iVar;
    }

    public final void run() {
        this.f4330g.O(new d(this.f4328e, this.f4329f));
    }
}
