package com.baseflow.geolocator;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
import m0.c;
import n0.k;
import n0.m;
import n0.n;
import n0.p;
import n0.y;
import n0.z;
import o0.b;
import p0.a;

class j implements MethodChannel.MethodCallHandler {

    /* renamed from: a  reason: collision with root package name */
    private final b f3239a;

    /* renamed from: b  reason: collision with root package name */
    private final k f3240b;

    /* renamed from: c  reason: collision with root package name */
    private final m f3241c;

    /* renamed from: d  reason: collision with root package name */
    final Map<String, p> f3242d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private Context f3243e;

    /* renamed from: f  reason: collision with root package name */
    private Activity f3244f;

    /* renamed from: g  reason: collision with root package name */
    private MethodChannel f3245g;

    j(b bVar, k kVar, m mVar) {
        this.f3239a = bVar;
        this.f3240b = kVar;
        this.f3241c = mVar;
    }

    private void h(MethodChannel.Result result, Context context) {
        n a5 = this.f3241c.a(context, new e(result));
        if (a5 != null) {
            result.success(Integer.valueOf(a5.ordinal()));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(boolean[] zArr, p pVar, String str, MethodChannel.Result result, Location location) {
        if (!zArr[0]) {
            zArr[0] = true;
            this.f3240b.f(pVar);
            this.f3242d.remove(str);
            result.success(y.b(location));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(boolean[] zArr, p pVar, String str, MethodChannel.Result result, m0.b bVar) {
        if (!zArr[0]) {
            zArr[0] = true;
            this.f3240b.f(pVar);
            this.f3242d.remove(str);
            result.error(bVar.toString(), bVar.f(), (Object) null);
        }
    }

    private void p(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) ((Map) methodCall.arguments).get("requestId");
        p pVar = this.f3242d.get(str);
        if (pVar != null) {
            pVar.d();
        }
        this.f3242d.remove(str);
        result.success((Object) null);
    }

    private void q(MethodChannel.Result result) {
        try {
            result.success(Integer.valueOf(this.f3239a.a(this.f3243e).f()));
        } catch (c unused) {
            m0.b bVar = m0.b.permissionDefinitionsNotFound;
            result.error(bVar.toString(), bVar.f(), (Object) null);
        }
    }

    private void r(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (!this.f3239a.d(this.f3243e)) {
                m0.b bVar = m0.b.permissionDenied;
                result.error(bVar.toString(), bVar.f(), (Object) null);
                return;
            }
            Map map = (Map) methodCall.arguments;
            boolean booleanValue = map.get("forceLocationManager") != null ? ((Boolean) map.get("forceLocationManager")).booleanValue() : false;
            z e5 = z.e(map);
            String str = (String) map.get("requestId");
            p a5 = this.f3240b.a(this.f3243e, booleanValue, e5);
            this.f3242d.put(str, a5);
            boolean[] zArr = {false};
            p pVar = a5;
            String str2 = str;
            MethodChannel.Result result2 = result;
            this.f3240b.e(a5, this.f3244f, new h(this, zArr, pVar, str2, result2), new i(this, zArr, pVar, str2, result2));
        } catch (c unused) {
            m0.b bVar2 = m0.b.permissionDefinitionsNotFound;
            result.error(bVar2.toString(), bVar2.f(), (Object) null);
        }
    }

    private void s(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (!this.f3239a.d(this.f3243e)) {
                m0.b bVar = m0.b.permissionDenied;
                result.error(bVar.toString(), bVar.f(), (Object) null);
                return;
            }
            Boolean bool = (Boolean) methodCall.argument("forceLocationManager");
            this.f3240b.b(this.f3243e, bool != null && bool.booleanValue(), new c(result), new d(result));
        } catch (c unused) {
            m0.b bVar2 = m0.b.permissionDefinitionsNotFound;
            result.error(bVar2.toString(), bVar2.f(), (Object) null);
        }
    }

    private void t(MethodChannel.Result result) {
        this.f3240b.d(this.f3243e, new n0.c(result));
    }

    private void u(MethodChannel.Result result) {
        try {
            this.f3239a.f(this.f3244f, new f(result), new g(result));
        } catch (c unused) {
            m0.b bVar = m0.b.permissionDefinitionsNotFound;
            result.error(bVar.toString(), bVar.f(), (Object) null);
        }
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        boolean b5;
        String str = methodCall.method;
        str.hashCode();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1757019252:
                if (str.equals("getCurrentPosition")) {
                    c5 = 0;
                    break;
                }
                break;
            case -1156770336:
                if (str.equals("getLastKnownPosition")) {
                    c5 = 1;
                    break;
                }
                break;
            case -821636766:
                if (str.equals("openLocationSettings")) {
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
            case 356040619:
                if (str.equals("isLocationServiceEnabled")) {
                    c5 = 4;
                    break;
                }
                break;
            case 686218487:
                if (str.equals("checkPermission")) {
                    c5 = 5;
                    break;
                }
                break;
            case 746581438:
                if (str.equals("requestPermission")) {
                    c5 = 6;
                    break;
                }
                break;
            case 877043524:
                if (str.equals("getLocationAccuracy")) {
                    c5 = 7;
                    break;
                }
                break;
            case 1774650278:
                if (str.equals("cancelGetCurrentPosition")) {
                    c5 = 8;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                r(methodCall, result);
                return;
            case 1:
                s(methodCall, result);
                return;
            case 2:
                b5 = a.b(this.f3243e);
                break;
            case 3:
                b5 = a.a(this.f3243e);
                break;
            case 4:
                t(result);
                return;
            case 5:
                q(result);
                return;
            case 6:
                u(result);
                return;
            case 7:
                h(result, this.f3243e);
                return;
            case 8:
                p(methodCall, result);
                return;
            default:
                result.notImplemented();
                return;
        }
        result.success(Boolean.valueOf(b5));
    }

    /* access modifiers changed from: package-private */
    public void v(Activity activity) {
        this.f3244f = activity;
    }

    /* access modifiers changed from: package-private */
    public void w(Context context, BinaryMessenger binaryMessenger) {
        if (this.f3245g != null) {
            Log.w("MethodCallHandlerImpl", "Setting a method call handler before the last was disposed.");
            x();
        }
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "flutter.baseflow.com/geolocator_android");
        this.f3245g = methodChannel;
        methodChannel.setMethodCallHandler(this);
        this.f3243e = context;
    }

    /* access modifiers changed from: package-private */
    public void x() {
        MethodChannel methodChannel = this.f3245g;
        if (methodChannel == null) {
            Log.d("MethodCallHandlerImpl", "Tried to stop listening when no MethodChannel had been initialized.");
            return;
        }
        methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.f3245g = null;
    }
}
