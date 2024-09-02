package d2;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class z implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f4331e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f4332f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f4333g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Boolean f4334h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ i f4335i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MethodCall f4336j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f4337k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f4338l;

    public /* synthetic */ z(boolean z4, String str, MethodChannel.Result result, Boolean bool, i iVar, MethodCall methodCall, boolean z5, int i5) {
        this.f4331e = z4;
        this.f4332f = str;
        this.f4333g = result;
        this.f4334h = bool;
        this.f4335i = iVar;
        this.f4336j = methodCall;
        this.f4337k = z5;
        this.f4338l = i5;
    }

    public final void run() {
        c0.s(this.f4331e, this.f4332f, this.f4333g, this.f4334h, this.f4335i, this.f4336j, this.f4337k, this.f4338l);
    }
}
