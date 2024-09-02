package d2;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ i f4239e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ MethodCall f4240f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f4241g;

    public /* synthetic */ b0(i iVar, MethodCall methodCall, MethodChannel.Result result) {
        this.f4239e = iVar;
        this.f4240f = methodCall;
        this.f4241g = result;
    }

    public final void run() {
        this.f4239e.h(this.f4240f, this.f4241g);
    }
}
