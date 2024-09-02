package i0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public final class a implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: d  reason: collision with root package name */
    public static final C0082a f4876d = new C0082a((g) null);

    /* renamed from: a  reason: collision with root package name */
    private MethodChannel f4877a;

    /* renamed from: b  reason: collision with root package name */
    private Context f4878b;

    /* renamed from: c  reason: collision with root package name */
    private final List<b> f4879c = n.f(new b(c.google, "Google Maps", "com.google.android.apps.maps", "geo://"), new b(c.googleGo, "Google Maps Go", "com.google.android.apps.mapslite", "geo://"), new b(c.amap, "Amap", "com.autonavi.minimap", "iosamap://"), new b(c.baidu, "Baidu Maps", "com.baidu.BaiduMap", "baidumap://"), new b(c.waze, "Waze", "com.waze", "waze://"), new b(c.yandexNavi, "Yandex Navigator", "ru.yandex.yandexnavi", "yandexnavi://"), new b(c.yandexMaps, "Yandex Maps", "ru.yandex.yandexmaps", "yandexmaps://"), new b(c.citymapper, "Citymapper", "com.citymapper.app.release", "citymapper://"), new b(c.mapswithme, "MAPS.ME", "com.mapswithme.maps.pro", "mapswithme://"), new b(c.osmand, "OsmAnd", "net.osmand", "osmandmaps://"), new b(c.osmandplus, "OsmAnd+", "net.osmand.plus", "osmandmaps://"), new b(c.doubleGis, "2GIS", "ru.dublgis.dgismobile", "dgis://"), new b(c.tencent, "Tencent (QQ Maps)", "com.tencent.map", "qqmap://"), new b(c.here, "HERE WeGo", "com.here.app.maps", "here-location://"), new b(c.petal, "Petal Maps", "com.huawei.maps.app", "petalmaps://"), new b(c.tomtomgo, "TomTom Go", "com.tomtom.gplay.navapp", "tomtomgo://"), new b(c.tomtomgofleet, "TomTom Go Fleet", "com.tomtom.gplay.navapp.gofleet", "tomtomgofleet://"), new b(c.sygicTruck, "Sygic Truck", "com.sygic.truck", "com.sygic.aura://"), new b(c.copilot, "CoPilot", "com.alk.copilot.mapviewer", "copilot://"), new b(c.flitsmeister, "Flitsmeister", "nl.flitsmeister", "flitsmeister://"), new b(c.truckmeister, "Truckmeister", "nl.flitsmeister.flux", "truckmeister://"), new b(c.naver, "Naver Map", "com.nhn.android.nmap", "nmap://"), new b(c.kakao, "Kakao Maps", "net.daum.android.map", "kakaomap://"), new b(c.tmap, "TMap", "com.skt.tmap.ku", "tmap://"));

    /* renamed from: i0.a$a  reason: collision with other inner class name */
    public static final class C0082a {
        private C0082a() {
        }

        public /* synthetic */ C0082a(g gVar) {
            this();
        }
    }

    private final List<b> a() {
        List<b> list = this.f4879c;
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            b bVar = (b) next;
            Context context = this.f4878b;
            Intent intent = null;
            if (context == null) {
                k.o("context");
                context = null;
            }
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                intent = packageManager.getLaunchIntentForPackage(bVar.b());
            }
            if (intent != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private final boolean b(String str) {
        List<b> a5 = a();
        if ((a5 instanceof Collection) && a5.isEmpty()) {
            return false;
        }
        for (b a6 : a5) {
            if (k.a(a6.a().name(), str)) {
                return true;
            }
        }
        return false;
    }

    private final void c(c cVar, String str, MethodChannel.Result result) {
        T t5;
        boolean z4;
        Context context = this.f4878b;
        if (context == null) {
            k.o("context");
            context = null;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        Iterator<T> it = this.f4879c.iterator();
        while (true) {
            if (!it.hasNext()) {
                t5 = null;
                break;
            }
            t5 = it.next();
            if (((b) t5).a() == cVar) {
                z4 = true;
                continue;
            } else {
                z4 = false;
                continue;
            }
            if (z4) {
                break;
            }
        }
        b bVar = (b) t5;
        if (bVar != null) {
            intent.setPackage(bVar.b());
        }
        context.startActivity(intent);
        result.success((Object) null);
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        k.e(flutterPluginBinding, "flutterPluginBinding");
        this.f4877a = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "map_launcher");
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        k.d(applicationContext, "flutterPluginBinding.applicationContext");
        this.f4878b = applicationContext;
        MethodChannel methodChannel = this.f4877a;
        if (methodChannel == null) {
            k.o("channel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        k.e(flutterPluginBinding, "binding");
        MethodChannel methodChannel = this.f4877a;
        if (methodChannel == null) {
            k.o("channel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0059, code lost:
        if (r0.equals("showDirections") == false) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0062, code lost:
        if (r0.equals("showMarker") == false) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0065, code lost:
        r6 = r6.arguments;
        kotlin.jvm.internal.k.c(r6, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        r6 = (java.util.Map) r6;
        r0 = r6.get("mapType");
        kotlin.jvm.internal.k.c(r0, "null cannot be cast to non-null type kotlin.String");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0079, code lost:
        if (b((java.lang.String) r0) != false) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007b, code lost:
        r7.error("MAP_NOT_AVAILABLE", "Map is not installed on a device", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0083, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0084, code lost:
        r0 = r6.get("mapType");
        kotlin.jvm.internal.k.c(r0, "null cannot be cast to non-null type kotlin.String");
        r0 = i0.c.valueOf((java.lang.String) r0);
        r6 = r6.get("url");
        kotlin.jvm.internal.k.c(r6, "null cannot be cast to non-null type kotlin.String");
        c(r0, (java.lang.String) r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r6, io.flutter.plugin.common.MethodChannel.Result r7) {
        /*
            r5 = this;
            java.lang.String r0 = "call"
            kotlin.jvm.internal.k.e(r6, r0)
            java.lang.String r0 = "result"
            kotlin.jvm.internal.k.e(r7, r0)
            java.lang.String r0 = r6.method
            if (r0 == 0) goto L_0x00c5
            int r1 = r0.hashCode()
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.collections.Map<*, *>"
            java.lang.String r3 = "mapType"
            java.lang.String r4 = "null cannot be cast to non-null type kotlin.String"
            switch(r1) {
                case -1346420969: goto L_0x00a0;
                case 593783191: goto L_0x005c;
                case 1818544049: goto L_0x0053;
                case 2005082491: goto L_0x001d;
                default: goto L_0x001b;
            }
        L_0x001b:
            goto L_0x00c5
        L_0x001d:
            java.lang.String r6 = "getInstalledMaps"
            boolean r6 = r0.equals(r6)
            if (r6 != 0) goto L_0x0027
            goto L_0x00c5
        L_0x0027:
            java.util.List r6 = r5.a()
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = n3.o.i(r6, r1)
            r0.<init>(r1)
            java.util.Iterator r6 = r6.iterator()
        L_0x003a:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x004e
            java.lang.Object r1 = r6.next()
            i0.b r1 = (i0.b) r1
            java.util.Map r1 = r1.c()
            r0.add(r1)
            goto L_0x003a
        L_0x004e:
            r7.success(r0)
            goto L_0x00c8
        L_0x0053:
            java.lang.String r1 = "showDirections"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0065
            goto L_0x00c5
        L_0x005c:
            java.lang.String r1 = "showMarker"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0065
            goto L_0x00c5
        L_0x0065:
            java.lang.Object r6 = r6.arguments
            kotlin.jvm.internal.k.c(r6, r2)
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Object r0 = r6.get(r3)
            kotlin.jvm.internal.k.c(r0, r4)
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r5.b(r0)
            if (r0 != 0) goto L_0x0084
            r6 = 0
            java.lang.String r0 = "MAP_NOT_AVAILABLE"
            java.lang.String r1 = "Map is not installed on a device"
            r7.error(r0, r1, r6)
            return
        L_0x0084:
            java.lang.Object r0 = r6.get(r3)
            kotlin.jvm.internal.k.c(r0, r4)
            java.lang.String r0 = (java.lang.String) r0
            i0.c r0 = i0.c.valueOf(r0)
            java.lang.String r1 = "url"
            java.lang.Object r6 = r6.get(r1)
            kotlin.jvm.internal.k.c(r6, r4)
            java.lang.String r6 = (java.lang.String) r6
            r5.c(r0, r6, r7)
            goto L_0x00c8
        L_0x00a0:
            java.lang.String r1 = "isMapAvailable"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00a9
            goto L_0x00c5
        L_0x00a9:
            java.lang.Object r6 = r6.arguments
            kotlin.jvm.internal.k.c(r6, r2)
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Object r6 = r6.get(r3)
            kotlin.jvm.internal.k.c(r6, r4)
            java.lang.String r6 = (java.lang.String) r6
            boolean r6 = r5.b(r6)
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            r7.success(r6)
            goto L_0x00c8
        L_0x00c5:
            r7.notImplemented()
        L_0x00c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.a.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }
}
