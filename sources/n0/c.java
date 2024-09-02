package n0;

import io.flutter.plugin.common.MethodChannel;
import m0.b;

public class c implements a0 {

    /* renamed from: a  reason: collision with root package name */
    private MethodChannel.Result f5999a;

    public c(MethodChannel.Result result) {
        this.f5999a = result;
    }

    public void a(b bVar) {
        this.f5999a.error(bVar.toString(), bVar.f(), (Object) null);
    }

    public void b(boolean z4) {
        this.f5999a.success(Boolean.valueOf(z4));
    }
}
