package l2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;

public final class a implements MethodChannel.MethodCallHandler, FlutterPlugin {

    /* renamed from: a  reason: collision with root package name */
    private MethodChannel f5729a;

    /* renamed from: b  reason: collision with root package name */
    private Context f5730b;

    private final void a(Signature signature, MethodChannel.Result result) {
        MessageDigest instance = MessageDigest.getInstance("SHA1");
        k.d(instance, "getInstance(\"SHA1\")");
        instance.update(signature.toByteArray());
        byte[] digest = instance.digest();
        k.d(digest, "md.digest()");
        BigInteger bigInteger = new BigInteger(1, digest);
        t tVar = t.f5574a;
        String format = String.format("%0" + (digest.length << 1) + 'x', Arrays.copyOf(new Object[]{bigInteger}, 1));
        k.d(format, "format(format, *args)");
        result.success(format);
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        k.e(flutterPluginBinding, "binding");
        this.f5730b = flutterPluginBinding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "google_api_headers");
        methodChannel.setMethodCallHandler(this);
        this.f5729a = methodChannel;
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        k.e(flutterPluginBinding, "binding");
        MethodChannel methodChannel = this.f5729a;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.f5729a = null;
        this.f5730b = null;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        k.e(methodCall, "call");
        k.e(result, "result");
        if (k.a(methodCall.method, "getSigningCertSha1")) {
            try {
                Context context = this.f5730b;
                k.b(context);
                PackageManager packageManager = context.getPackageManager();
                Object arguments = methodCall.arguments();
                k.b(arguments);
                String str = (String) arguments;
                int i5 = 0;
                if (Build.VERSION.SDK_INT >= 28) {
                    Signature[] apkContentsSigners = packageManager.getPackageInfo(str, 134217728).signingInfo.getApkContentsSigners();
                    k.d(apkContentsSigners, "packageManager.getPackag…ngInfo.apkContentsSigners");
                    int length = apkContentsSigners.length;
                    while (i5 < length) {
                        Signature signature = apkContentsSigners[i5];
                        k.d(signature, "signature");
                        a(signature, result);
                        i5++;
                    }
                    return;
                }
                Signature[] signatureArr = packageManager.getPackageInfo(str, 64).signatures;
                k.d(signatureArr, "packageManager.getPackag…             ).signatures");
                int length2 = signatureArr.length;
                while (i5 < length2) {
                    Signature signature2 = signatureArr[i5];
                    k.d(signature2, "signature");
                    a(signature2, result);
                    i5++;
                }
            } catch (Exception e5) {
                result.error("ERROR", e5.toString(), (Object) null);
            }
        } else {
            result.notImplemented();
        }
    }
}
