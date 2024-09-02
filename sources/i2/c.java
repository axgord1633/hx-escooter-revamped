package i2;

import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.k;

public final class c implements MethodChannel.MethodCallHandler {

    /* renamed from: a  reason: collision with root package name */
    private final PackageManager f4951a;

    /* renamed from: b  reason: collision with root package name */
    private final WindowManager f4952b;

    public c(PackageManager packageManager, WindowManager windowManager) {
        k.e(packageManager, "packageManager");
        k.e(windowManager, "windowManager");
        this.f4951a = packageManager;
        this.f4952b = windowManager;
    }

    private final List<String> a() {
        FeatureInfo[] systemAvailableFeatures = this.f4951a.getSystemAvailableFeatures();
        k.d(systemAvailableFeatures, "packageManager.systemAvailableFeatures");
        ArrayList<FeatureInfo> arrayList = new ArrayList<>();
        for (FeatureInfo featureInfo : systemAvailableFeatures) {
            if (!(featureInfo.name == null)) {
                arrayList.add(featureInfo);
            }
        }
        ArrayList arrayList2 = new ArrayList(o.i(arrayList, 10));
        for (FeatureInfo featureInfo2 : arrayList) {
            arrayList2.add(featureInfo2.name);
        }
        return arrayList2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001d, code lost:
        if (b4.m.o(r0, "generic", false, 2, (java.lang.Object) null) == false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean b() {
        /*
            r6 = this;
            java.lang.String r0 = android.os.Build.BRAND
            java.lang.String r1 = "BRAND"
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r1 = "generic"
            r2 = 0
            r3 = 2
            r4 = 0
            boolean r0 = b4.m.o(r0, r1, r2, r3, r4)
            if (r0 == 0) goto L_0x001f
            java.lang.String r0 = android.os.Build.DEVICE
            java.lang.String r5 = "DEVICE"
            kotlin.jvm.internal.k.d(r0, r5)
            boolean r0 = b4.m.o(r0, r1, r2, r3, r4)
            if (r0 != 0) goto L_0x00b5
        L_0x001f:
            java.lang.String r0 = android.os.Build.FINGERPRINT
            java.lang.String r5 = "FINGERPRINT"
            kotlin.jvm.internal.k.d(r0, r5)
            boolean r1 = b4.m.o(r0, r1, r2, r3, r4)
            if (r1 != 0) goto L_0x00b5
            kotlin.jvm.internal.k.d(r0, r5)
            java.lang.String r1 = "unknown"
            boolean r0 = b4.m.o(r0, r1, r2, r3, r4)
            if (r0 != 0) goto L_0x00b5
            java.lang.String r0 = android.os.Build.HARDWARE
            java.lang.String r1 = "HARDWARE"
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r5 = "goldfish"
            boolean r5 = b4.n.r(r0, r5, r2, r3, r4)
            if (r5 != 0) goto L_0x00b5
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r1 = "ranchu"
            boolean r0 = b4.n.r(r0, r1, r2, r3, r4)
            if (r0 != 0) goto L_0x00b5
            java.lang.String r0 = android.os.Build.MODEL
            java.lang.String r1 = "MODEL"
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r5 = "google_sdk"
            boolean r5 = b4.n.r(r0, r5, r2, r3, r4)
            if (r5 != 0) goto L_0x00b5
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r5 = "Emulator"
            boolean r5 = b4.n.r(r0, r5, r2, r3, r4)
            if (r5 != 0) goto L_0x00b5
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r1 = "Android SDK built for x86"
            boolean r0 = b4.n.r(r0, r1, r2, r3, r4)
            if (r0 != 0) goto L_0x00b5
            java.lang.String r0 = android.os.Build.MANUFACTURER
            java.lang.String r1 = "MANUFACTURER"
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r1 = "Genymotion"
            boolean r0 = b4.n.r(r0, r1, r2, r3, r4)
            if (r0 != 0) goto L_0x00b5
            java.lang.String r0 = android.os.Build.PRODUCT
            java.lang.String r1 = "PRODUCT"
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r5 = "sdk"
            boolean r5 = b4.n.r(r0, r5, r2, r3, r4)
            if (r5 != 0) goto L_0x00b5
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r5 = "vbox86p"
            boolean r5 = b4.n.r(r0, r5, r2, r3, r4)
            if (r5 != 0) goto L_0x00b5
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r5 = "emulator"
            boolean r5 = b4.n.r(r0, r5, r2, r3, r4)
            if (r5 != 0) goto L_0x00b5
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r1 = "simulator"
            boolean r0 = b4.n.r(r0, r1, r2, r3, r4)
            if (r0 == 0) goto L_0x00b6
        L_0x00b5:
            r2 = 1
        L_0x00b6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.c.b():boolean");
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        String str2;
        k.e(methodCall, "call");
        k.e(result, "result");
        if (methodCall.method.equals("getDeviceInfo")) {
            HashMap hashMap = new HashMap();
            String str3 = Build.BOARD;
            k.d(str3, "BOARD");
            hashMap.put("board", str3);
            String str4 = Build.BOOTLOADER;
            k.d(str4, "BOOTLOADER");
            hashMap.put("bootloader", str4);
            String str5 = Build.BRAND;
            k.d(str5, "BRAND");
            hashMap.put("brand", str5);
            String str6 = Build.DEVICE;
            k.d(str6, "DEVICE");
            hashMap.put("device", str6);
            String str7 = Build.DISPLAY;
            k.d(str7, "DISPLAY");
            hashMap.put("display", str7);
            String str8 = Build.FINGERPRINT;
            k.d(str8, "FINGERPRINT");
            hashMap.put("fingerprint", str8);
            String str9 = Build.HARDWARE;
            k.d(str9, "HARDWARE");
            hashMap.put("hardware", str9);
            String str10 = Build.HOST;
            k.d(str10, "HOST");
            hashMap.put("host", str10);
            String str11 = Build.ID;
            k.d(str11, "ID");
            hashMap.put("id", str11);
            String str12 = Build.MANUFACTURER;
            k.d(str12, "MANUFACTURER");
            hashMap.put("manufacturer", str12);
            String str13 = Build.MODEL;
            k.d(str13, "MODEL");
            hashMap.put("model", str13);
            String str14 = Build.PRODUCT;
            k.d(str14, "PRODUCT");
            hashMap.put("product", str14);
            int i5 = Build.VERSION.SDK_INT;
            String[] strArr = Build.SUPPORTED_32_BIT_ABIS;
            k.d(strArr, "SUPPORTED_32_BIT_ABIS");
            hashMap.put("supported32BitAbis", n.f(Arrays.copyOf(strArr, strArr.length)));
            String[] strArr2 = Build.SUPPORTED_64_BIT_ABIS;
            k.d(strArr2, "SUPPORTED_64_BIT_ABIS");
            hashMap.put("supported64BitAbis", n.f(Arrays.copyOf(strArr2, strArr2.length)));
            String[] strArr3 = Build.SUPPORTED_ABIS;
            k.d(strArr3, "SUPPORTED_ABIS");
            hashMap.put("supportedAbis", n.f(Arrays.copyOf(strArr3, strArr3.length)));
            String str15 = Build.TAGS;
            k.d(str15, "TAGS");
            hashMap.put("tags", str15);
            String str16 = Build.TYPE;
            k.d(str16, "TYPE");
            hashMap.put("type", str16);
            hashMap.put("isPhysicalDevice", Boolean.valueOf(!b()));
            hashMap.put("systemFeatures", a());
            HashMap hashMap2 = new HashMap();
            String str17 = Build.VERSION.BASE_OS;
            k.d(str17, "BASE_OS");
            hashMap2.put("baseOS", str17);
            hashMap2.put("previewSdkInt", Integer.valueOf(Build.VERSION.PREVIEW_SDK_INT));
            String str18 = Build.VERSION.SECURITY_PATCH;
            k.d(str18, "SECURITY_PATCH");
            hashMap2.put("securityPatch", str18);
            String str19 = Build.VERSION.CODENAME;
            k.d(str19, "CODENAME");
            hashMap2.put("codename", str19);
            String str20 = Build.VERSION.INCREMENTAL;
            k.d(str20, "INCREMENTAL");
            hashMap2.put("incremental", str20);
            String str21 = Build.VERSION.RELEASE;
            k.d(str21, "RELEASE");
            hashMap2.put("release", str21);
            hashMap2.put("sdkInt", Integer.valueOf(i5));
            hashMap.put("version", hashMap2);
            Display defaultDisplay = this.f4952b.getDefaultDisplay();
            k.d(defaultDisplay, "windowManager.defaultDisplay");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            HashMap hashMap3 = new HashMap();
            hashMap3.put("widthPx", Double.valueOf((double) displayMetrics.widthPixels));
            hashMap3.put("heightPx", Double.valueOf((double) displayMetrics.heightPixels));
            hashMap3.put("xDpi", Float.valueOf(displayMetrics.xdpi));
            hashMap3.put("yDpi", Float.valueOf(displayMetrics.ydpi));
            hashMap.put("displayMetrics", hashMap3);
            if (i5 >= 26) {
                try {
                    str2 = Build.getSerial();
                } catch (SecurityException unused) {
                    str2 = "unknown";
                }
                str = "try {\n                  …UNKNOWN\n                }";
            } else {
                str2 = Build.SERIAL;
                str = "SERIAL";
            }
            k.d(str2, str);
            hashMap.put("serialNumber", str2);
            result.success(hashMap);
            return;
        }
        result.notImplemented();
    }
}
