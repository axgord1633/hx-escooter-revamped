package f2;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class d extends a {

    /* renamed from: a  reason: collision with root package name */
    public final a f4609a;

    /* renamed from: b  reason: collision with root package name */
    final MethodCall f4610b;

    class a implements f {

        /* renamed from: a  reason: collision with root package name */
        final MethodChannel.Result f4611a;

        a(MethodChannel.Result result) {
            this.f4611a = result;
        }

        public void error(String str, String str2, Object obj) {
            this.f4611a.error(str, str2, obj);
        }

        public void success(Object obj) {
            this.f4611a.success(obj);
        }
    }

    public d(MethodCall methodCall, MethodChannel.Result result) {
        this.f4610b = methodCall;
        this.f4609a = new a(result);
    }

    public <T> T a(String str) {
        return this.f4610b.argument(str);
    }

    public boolean g(String str) {
        return this.f4610b.hasArgument(str);
    }

    public String getMethod() {
        return this.f4610b.method;
    }

    public f l() {
        return this.f4609a;
    }
}
