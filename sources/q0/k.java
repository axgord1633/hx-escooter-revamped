package q0;

import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class k implements b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f6611a;

    public /* synthetic */ k(MethodChannel.Result result) {
        this.f6611a = result;
    }

    public final void a(String str, String str2) {
        this.f6611a.error(str, str2, (Object) null);
    }
}
