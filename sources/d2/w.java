package d2;

import f2.d;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MethodCall f4322e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f4323f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ i f4324g;

    public /* synthetic */ w(MethodCall methodCall, MethodChannel.Result result, i iVar) {
        this.f4322e = methodCall;
        this.f4323f = result;
        this.f4324g = iVar;
    }

    public final void run() {
        this.f4324g.R(new d(this.f4322e, this.f4323f));
    }
}
