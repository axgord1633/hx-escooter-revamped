package d2;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class a0 implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MethodCall f4234e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ i f4235f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f4236g;

    public /* synthetic */ a0(MethodCall methodCall, i iVar, MethodChannel.Result result) {
        this.f4234e = methodCall;
        this.f4235f = iVar;
        this.f4236g = result;
    }

    public final void run() {
        c0.v(this.f4234e, this.f4235f, this.f4236g);
    }
}
