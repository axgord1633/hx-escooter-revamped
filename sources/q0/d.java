package q0;

import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f6604a;

    public /* synthetic */ d(MethodChannel.Result result) {
        this.f6604a = result;
    }

    public final void a(String str, String str2) {
        this.f6604a.error(str, str2, (Object) null);
    }
}
