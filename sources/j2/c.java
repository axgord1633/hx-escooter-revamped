package j2;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.security.MessageDigest;
import java.util.HashMap;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public final class c implements MethodChannel.MethodCallHandler, FlutterPlugin {

    /* renamed from: c  reason: collision with root package name */
    public static final a f5450c = new a((g) null);

    /* renamed from: a  reason: collision with root package name */
    private Context f5451a;

    /* renamed from: b  reason: collision with root package name */
    private MethodChannel f5452b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    private final String a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[(bArr.length * 2)];
        int length = bArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            byte b5 = bArr[i5] & 255;
            int i6 = i5 * 2;
            cArr2[i6] = cArr[b5 >>> 4];
            cArr2[i6 + 1] = cArr[b5 & 15];
        }
        return new String(cArr2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0077, code lost:
        if ((r5.length == 0) != false) goto L_0x0079;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String b(android.content.pm.PackageManager r5) {
        /*
            r4 = this;
            r0 = 0
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            r2 = 28
            if (r1 < r2) goto L_0x005c
            android.content.Context r1 = r4.f5451a     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            kotlin.jvm.internal.k.b(r1)     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            r2 = 134217728(0x8000000, float:3.85186E-34)
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r1, r2)     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            android.content.pm.SigningInfo r5 = r5.signingInfo     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            if (r5 != 0) goto L_0x001b
            return r0
        L_0x001b:
            boolean r1 = r5.hasMultipleSigners()     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            if (r1 == 0) goto L_0x003e
            android.content.pm.Signature[] r5 = r5.getApkContentsSigners()     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            java.lang.String r1 = "signingInfo.apkContentsSigners"
            kotlin.jvm.internal.k.d(r5, r1)     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            java.lang.Object r5 = n3.j.l(r5)     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            android.content.pm.Signature r5 = (android.content.pm.Signature) r5     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            byte[] r5 = r5.toByteArray()     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            java.lang.String r1 = "signingInfo.apkContentsS…ers.first().toByteArray()"
            kotlin.jvm.internal.k.d(r5, r1)     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            java.lang.String r5 = r4.e(r5)     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            goto L_0x005a
        L_0x003e:
            android.content.pm.Signature[] r5 = r5.getSigningCertificateHistory()     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            java.lang.String r1 = "signingInfo.signingCertificateHistory"
            kotlin.jvm.internal.k.d(r5, r1)     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            java.lang.Object r5 = n3.j.l(r5)     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            android.content.pm.Signature r5 = (android.content.pm.Signature) r5     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            byte[] r5 = r5.toByteArray()     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            java.lang.String r1 = "signingInfo.signingCerti…ory.first().toByteArray()"
            kotlin.jvm.internal.k.d(r5, r1)     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            java.lang.String r5 = r4.e(r5)     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
        L_0x005a:
            r0 = r5
            goto L_0x00a1
        L_0x005c:
            android.content.Context r1 = r4.f5451a     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            kotlin.jvm.internal.k.b(r1)     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            r2 = 64
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r1, r2)     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            android.content.pm.Signature[] r5 = r5.signatures     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            r1 = 0
            r2 = 1
            if (r5 == 0) goto L_0x0079
            int r3 = r5.length     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            if (r3 != 0) goto L_0x0076
            r3 = r2
            goto L_0x0077
        L_0x0076:
            r3 = r1
        L_0x0077:
            if (r3 == 0) goto L_0x007a
        L_0x0079:
            r1 = r2
        L_0x007a:
            if (r1 != 0) goto L_0x00a1
            java.lang.String r1 = "packageInfo.signatures"
            kotlin.jvm.internal.k.d(r5, r1)     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            java.lang.Object r1 = n3.j.l(r5)     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            if (r1 != 0) goto L_0x0088
            goto L_0x00a1
        L_0x0088:
            java.lang.String r1 = "signatures"
            kotlin.jvm.internal.k.d(r5, r1)     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            java.lang.Object r5 = n3.j.l(r5)     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            android.content.pm.Signature r5 = (android.content.pm.Signature) r5     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            byte[] r5 = r5.toByteArray()     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            java.lang.String r1 = "signatures.first().toByteArray()"
            kotlin.jvm.internal.k.d(r5, r1)     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            java.lang.String r5 = r4.e(r5)     // Catch:{ NameNotFoundException | NoSuchAlgorithmException -> 0x00a1 }
            goto L_0x005a
        L_0x00a1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.c.b(android.content.pm.PackageManager):java.lang.String");
    }

    private final String c() {
        Context context = this.f5451a;
        k.b(context);
        PackageManager packageManager = context.getPackageManager();
        Context context2 = this.f5451a;
        k.b(context2);
        String packageName = context2.getPackageName();
        return Build.VERSION.SDK_INT >= 30 ? packageManager.getInstallSourceInfo(packageName).getInitiatingPackageName() : packageManager.getInstallerPackageName(packageName);
    }

    private final long d(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : (long) packageInfo.versionCode;
    }

    private final String e(byte[] bArr) {
        MessageDigest instance = MessageDigest.getInstance("SHA1");
        instance.update(bArr);
        byte[] digest = instance.digest();
        k.d(digest, "hashText");
        return a(digest);
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        k.e(flutterPluginBinding, "binding");
        this.f5451a = flutterPluginBinding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "dev.fluttercommunity.plus/package_info");
        this.f5452b = methodChannel;
        k.b(methodChannel);
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        k.e(flutterPluginBinding, "binding");
        this.f5451a = null;
        MethodChannel methodChannel = this.f5452b;
        k.b(methodChannel);
        methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.f5452b = null;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        k.e(methodCall, "call");
        k.e(result, "result");
        try {
            if (k.a(methodCall.method, "getAll")) {
                Context context = this.f5451a;
                k.b(context);
                PackageManager packageManager = context.getPackageManager();
                Context context2 = this.f5451a;
                k.b(context2);
                PackageInfo packageInfo = packageManager.getPackageInfo(context2.getPackageName(), 0);
                k.d(packageManager, "packageManager");
                String b5 = b(packageManager);
                String c5 = c();
                HashMap hashMap = new HashMap();
                hashMap.put("appName", packageInfo.applicationInfo.loadLabel(packageManager).toString());
                Context context3 = this.f5451a;
                k.b(context3);
                hashMap.put("packageName", context3.getPackageName());
                hashMap.put("version", packageInfo.versionName);
                k.d(packageInfo, "info");
                hashMap.put("buildNumber", String.valueOf(d(packageInfo)));
                if (b5 != null) {
                    hashMap.put("buildSignature", b5);
                }
                if (c5 != null) {
                    hashMap.put("installerStore", c5);
                }
                result.success(hashMap);
                return;
            }
            result.notImplemented();
        } catch (PackageManager.NameNotFoundException e5) {
            result.error("Name not found", e5.getMessage(), (Object) null);
        }
    }
}
