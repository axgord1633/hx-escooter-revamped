package j0;

import android.location.Address;
import android.util.Log;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.io.IOException;
import java.util.List;
import k0.b;

final class c implements MethodChannel.MethodCallHandler {

    /* renamed from: a  reason: collision with root package name */
    private final a f5430a;

    /* renamed from: b  reason: collision with root package name */
    private MethodChannel f5431b;

    c(a aVar) {
        this.f5430a = aVar;
    }

    private void a(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("address");
        String str2 = (String) methodCall.argument("localeIdentifier");
        if (str == null || str.isEmpty()) {
            result.error("ARGUMENT_ERROR", "Supply a valid value for the 'address' parameter.", (Object) null);
        }
        try {
            List<Address> b5 = this.f5430a.b(str, k0.c.a(str2));
            if (b5 != null) {
                if (!b5.isEmpty()) {
                    result.success(b.c(b5));
                    return;
                }
            }
            result.error("NOT_FOUND", String.format("No coordinates found for '%s'", new Object[]{str}), (Object) null);
        } catch (IOException unused) {
            result.error("IO_ERROR", String.format("A network error occurred trying to lookup the address ''.", new Object[]{str}), (Object) null);
        }
    }

    private void b(MethodCall methodCall, MethodChannel.Result result) {
        MethodCall methodCall2 = methodCall;
        MethodChannel.Result result2 = result;
        double doubleValue = ((Double) methodCall2.argument("latitude")).doubleValue();
        double doubleValue2 = ((Double) methodCall2.argument("longitude")).doubleValue();
        try {
            List<Address> c5 = this.f5430a.c(doubleValue, doubleValue2, k0.c.a((String) methodCall2.argument("localeIdentifier")));
            if (c5 != null) {
                if (!c5.isEmpty()) {
                    result2.success(b.b(c5));
                    return;
                }
            }
            result2.error("NOT_FOUND", String.format("No address information found for supplied coordinates (latitude: %f, longitude: %f).", new Object[]{Double.valueOf(doubleValue), Double.valueOf(doubleValue2)}), (Object) null);
        } catch (IOException unused) {
            result2.error("IO_ERROR", String.format("A network error occurred trying to lookup the supplied coordinates (latitude: %f, longitude: %f).", new Object[]{Double.valueOf(doubleValue), Double.valueOf(doubleValue2)}), (Object) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(BinaryMessenger binaryMessenger) {
        if (this.f5431b != null) {
            Log.wtf("MethodCallHandlerImpl", "Setting a method call handler before the last was disposed.");
            d();
        }
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "flutter.baseflow.com/geocoding", StandardMethodCodec.INSTANCE, binaryMessenger.makeBackgroundTaskQueue());
        this.f5431b = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        MethodChannel methodChannel = this.f5431b;
        if (methodChannel == null) {
            Log.d("MethodCallHandlerImpl", "Tried to stop listening when no MethodChannel had been initialized.");
            return;
        }
        methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.f5431b = null;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        if (str.equals("placemarkFromCoordinates")) {
            b(methodCall, result);
        } else if (!str.equals("locationFromAddress")) {
            result.notImplemented();
        } else {
            a(methodCall, result);
        }
    }
}
