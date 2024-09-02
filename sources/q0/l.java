package q0;

import android.content.Context;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;
import java.util.Objects;

final class l implements MethodChannel.MethodCallHandler {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6612a;

    /* renamed from: b  reason: collision with root package name */
    private final a f6613b;

    /* renamed from: c  reason: collision with root package name */
    private final q f6614c;

    /* renamed from: d  reason: collision with root package name */
    private final u f6615d;

    l(Context context, a aVar, q qVar, u uVar) {
        this.f6612a = context;
        this.f6613b = aVar;
        this.f6614c = qVar;
        this.f6615d = uVar;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1544053025:
                if (str.equals("checkServiceStatus")) {
                    c5 = 0;
                    break;
                }
                break;
            case -1017315255:
                if (str.equals("shouldShowRequestPermissionRationale")) {
                    c5 = 1;
                    break;
                }
                break;
            case -576207927:
                if (str.equals("checkPermissionStatus")) {
                    c5 = 2;
                    break;
                }
                break;
            case 347240634:
                if (str.equals("openAppSettings")) {
                    c5 = 3;
                    break;
                }
                break;
            case 1669188213:
                if (str.equals("requestPermissions")) {
                    c5 = 4;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                int parseInt = Integer.parseInt(methodCall.arguments.toString());
                u uVar = this.f6615d;
                Context context = this.f6612a;
                Objects.requireNonNull(result);
                uVar.a(parseInt, context, new c(result), new d(result));
                return;
            case 1:
                int parseInt2 = Integer.parseInt(methodCall.arguments.toString());
                q qVar = this.f6614c;
                Objects.requireNonNull(result);
                qVar.i(parseInt2, new h(result), new i(result));
                return;
            case 2:
                int parseInt3 = Integer.parseInt(methodCall.arguments.toString());
                q qVar2 = this.f6614c;
                Objects.requireNonNull(result);
                qVar2.c(parseInt3, new e(result));
                return;
            case 3:
                a aVar = this.f6613b;
                Context context2 = this.f6612a;
                Objects.requireNonNull(result);
                aVar.a(context2, new j(result), new k(result));
                return;
            case 4:
                q qVar3 = this.f6614c;
                Objects.requireNonNull(result);
                qVar3.g((List) methodCall.arguments(), new f(result), new g(result));
                return;
            default:
                result.notImplemented();
                return;
        }
    }
}
