package q0;

import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class i implements b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f6609a;

    public /* synthetic */ i(MethodChannel.Result result) {
        this.f6609a = result;
    }

    public final void a(String str, String str2) {
        this.f6609a.error(str, str2, (Object) null);
    }
}
