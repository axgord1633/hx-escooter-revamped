package q0;

import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class g implements b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f6607a;

    public /* synthetic */ g(MethodChannel.Result result) {
        this.f6607a = result;
    }

    public final void a(String str, String str2) {
        this.f6607a.error(str, str2, (Object) null);
    }
}
