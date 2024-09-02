package d2;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.yalantis.ucrop.BuildConfig;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.HashMap;
import java.util.Map;

public class c0 implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: c  reason: collision with root package name */
    static final Map<String, Integer> f4244c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    static final Map<Integer, i> f4245d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private static final Object f4246e = new Object();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final Object f4247f = new Object();

    /* renamed from: g  reason: collision with root package name */
    static int f4248g = 0;

    /* renamed from: h  reason: collision with root package name */
    static String f4249h;

    /* renamed from: i  reason: collision with root package name */
    private static int f4250i = 0;

    /* renamed from: j  reason: collision with root package name */
    private static int f4251j = 1;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static int f4252k = 0;

    /* renamed from: l  reason: collision with root package name */
    private static o f4253l;

    /* renamed from: a  reason: collision with root package name */
    private Context f4254a;

    /* renamed from: b  reason: collision with root package name */
    private MethodChannel f4255b;

    class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ i f4256e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ MethodChannel.Result f4257f;

        a(i iVar, MethodChannel.Result result) {
            this.f4256e = iVar;
            this.f4257f = result;
        }

        public void run() {
            synchronized (c0.f4247f) {
                c0.this.l(this.f4256e);
            }
            this.f4257f.success((Object) null);
        }
    }

    class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ i f4259e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f4260f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ MethodChannel.Result f4261g;

        b(i iVar, String str, MethodChannel.Result result) {
            this.f4259e = iVar;
            this.f4260f = str;
            this.f4261g = result;
        }

        public void run() {
            synchronized (c0.f4247f) {
                i iVar = this.f4259e;
                if (iVar != null) {
                    c0.this.l(iVar);
                }
                try {
                    if (r.c(c0.f4248g)) {
                        Log.d("Sqflite", "delete database " + this.f4260f);
                    }
                    i.o(this.f4260f);
                } catch (Exception e5) {
                    Log.e("Sqflite", "error " + e5 + " while closing database " + c0.f4252k);
                }
            }
            this.f4261g.success((Object) null);
        }
    }

    private void A(MethodCall methodCall, MethodChannel.Result result) {
        int intValue = ((Integer) methodCall.argument("id")).intValue();
        i n5 = n(methodCall, result);
        if (n5 != null) {
            if (r.b(n5.f4277d)) {
                Log.d("Sqflite", n5.A() + "closing " + intValue + " " + n5.f4275b);
            }
            String str = n5.f4275b;
            synchronized (f4246e) {
                f4245d.remove(Integer.valueOf(intValue));
                if (n5.f4274a) {
                    f4244c.remove(str);
                }
            }
            f4253l.a(n5, new a(n5, result));
        }
    }

    private void B(MethodCall methodCall, MethodChannel.Result result) {
        result.success(Boolean.valueOf(i.x((String) methodCall.argument("path"))));
    }

    private void C(MethodCall methodCall, MethodChannel.Result result) {
        HashMap hashMap = new HashMap();
        if ("get".equals((String) methodCall.argument("cmd"))) {
            int i5 = f4248g;
            if (i5 > 0) {
                hashMap.put("logLevel", Integer.valueOf(i5));
            }
            Map<Integer, i> map = f4245d;
            if (!map.isEmpty()) {
                HashMap hashMap2 = new HashMap();
                for (Map.Entry next : map.entrySet()) {
                    i iVar = (i) next.getValue();
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("path", iVar.f4275b);
                    hashMap3.put("singleInstance", Boolean.valueOf(iVar.f4274a));
                    int i6 = iVar.f4277d;
                    if (i6 > 0) {
                        hashMap3.put("logLevel", Integer.valueOf(i6));
                    }
                    hashMap2.put(((Integer) next.getKey()).toString(), hashMap3);
                }
                hashMap.put("databases", hashMap2);
            }
        }
        result.success(hashMap);
    }

    private void D(MethodCall methodCall, MethodChannel.Result result) {
        e2.a.f4496a = Boolean.TRUE.equals(methodCall.arguments());
        e2.a.f4498c = e2.a.f4497b && e2.a.f4496a;
        if (!e2.a.f4496a) {
            f4248g = 0;
        } else if (e2.a.f4498c) {
            f4248g = 2;
        } else if (e2.a.f4496a) {
            f4248g = 1;
        }
        result.success((Object) null);
    }

    private void E(MethodCall methodCall, MethodChannel.Result result) {
        i iVar;
        Map<Integer, i> map;
        String str = (String) methodCall.argument("path");
        synchronized (f4246e) {
            if (r.c(f4248g)) {
                Log.d("Sqflite", "Look for " + str + " in " + f4244c.keySet());
            }
            Map<String, Integer> map2 = f4244c;
            Integer num = map2.get(str);
            if (num == null || (iVar = map.get(num)) == null || !iVar.f4282i.isOpen()) {
                iVar = null;
            } else {
                if (r.c(f4248g)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(iVar.A());
                    sb.append("found single instance ");
                    sb.append(iVar.F() ? "(in transaction) " : BuildConfig.FLAVOR);
                    sb.append(num);
                    sb.append(" ");
                    sb.append(str);
                    Log.d("Sqflite", sb.toString());
                }
                (map = f4245d).remove(num);
                map2.remove(str);
            }
        }
        b bVar = new b(iVar, str, result);
        o oVar = f4253l;
        if (oVar != null) {
            oVar.a(iVar, bVar);
        } else {
            bVar.run();
        }
    }

    private void F(MethodCall methodCall, MethodChannel.Result result) {
        i n5 = n(methodCall, result);
        if (n5 != null) {
            f4253l.a(n5, new x(methodCall, result, n5));
        }
    }

    private void H(MethodCall methodCall, MethodChannel.Result result) {
        i n5 = n(methodCall, result);
        if (n5 != null) {
            f4253l.a(n5, new u(methodCall, result, n5));
        }
    }

    private void I(MethodCall methodCall, MethodChannel.Result result) {
        int i5;
        i iVar;
        MethodCall methodCall2 = methodCall;
        String str = (String) methodCall2.argument("path");
        Boolean bool = (Boolean) methodCall2.argument("readOnly");
        boolean o5 = o(str);
        boolean z4 = !Boolean.FALSE.equals(methodCall2.argument("singleInstance")) && !o5;
        if (z4) {
            synchronized (f4246e) {
                if (r.c(f4248g)) {
                    Log.d("Sqflite", "Look for " + str + " in " + f4244c.keySet());
                }
                Integer num = f4244c.get(str);
                if (!(num == null || (iVar = f4245d.get(num)) == null)) {
                    if (iVar.f4282i.isOpen()) {
                        if (r.c(f4248g)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(iVar.A());
                            sb.append("re-opened single instance ");
                            sb.append(iVar.F() ? "(in transaction) " : BuildConfig.FLAVOR);
                            sb.append(num);
                            sb.append(" ");
                            sb.append(str);
                            Log.d("Sqflite", sb.toString());
                        }
                        result.success(x(num.intValue(), true, iVar.F()));
                        return;
                    } else if (r.c(f4248g)) {
                        Log.d("Sqflite", iVar.A() + "single instance database of " + str + " not opened");
                    }
                }
                MethodChannel.Result result2 = result;
            }
        } else {
            MethodChannel.Result result3 = result;
        }
        Object obj = f4246e;
        synchronized (obj) {
            i5 = f4252k + 1;
            f4252k = i5;
        }
        i iVar2 = new i(this.f4254a, str, i5, z4, f4248g);
        synchronized (obj) {
            if (f4253l == null) {
                o b5 = n.b("Sqflite", f4251j, f4250i);
                f4253l = b5;
                b5.start();
                if (r.b(iVar2.f4277d)) {
                    Log.d("Sqflite", iVar2.A() + "starting worker pool with priority " + f4250i);
                }
            }
            iVar2.f4281h = f4253l;
            if (r.b(iVar2.f4277d)) {
                Log.d("Sqflite", iVar2.A() + "opened " + i5 + " " + str);
            }
            z zVar = r1;
            o oVar = f4253l;
            z zVar2 = new z(o5, str, result, bool, iVar2, methodCall, z4, i5);
            oVar.a(iVar2, zVar);
        }
    }

    private void K(MethodCall methodCall, MethodChannel.Result result) {
        i n5 = n(methodCall, result);
        if (n5 != null) {
            f4253l.a(n5, new y(methodCall, result, n5));
        }
    }

    private void L(MethodCall methodCall, MethodChannel.Result result) {
        i n5 = n(methodCall, result);
        if (n5 != null) {
            f4253l.a(n5, new v(methodCall, result, n5));
        }
    }

    private void M(MethodCall methodCall, MethodChannel.Result result) {
        i n5 = n(methodCall, result);
        if (n5 != null) {
            f4253l.a(n5, new a0(methodCall, n5, result));
        }
    }

    private void N(MethodCall methodCall, MethodChannel.Result result) {
        i n5 = n(methodCall, result);
        if (n5 != null) {
            f4253l.a(n5, new w(methodCall, result, n5));
        }
    }

    /* access modifiers changed from: private */
    public void l(i iVar) {
        try {
            if (r.b(iVar.f4277d)) {
                Log.d("Sqflite", iVar.A() + "closing database ");
            }
            iVar.k();
        } catch (Exception e5) {
            Log.e("Sqflite", "error " + e5 + " while closing database " + f4252k);
        }
        synchronized (f4246e) {
            if (f4245d.isEmpty() && f4253l != null) {
                if (r.b(iVar.f4277d)) {
                    Log.d("Sqflite", iVar.A() + "stopping thread");
                }
                f4253l.b();
                f4253l = null;
            }
        }
    }

    private i m(int i5) {
        return f4245d.get(Integer.valueOf(i5));
    }

    private i n(MethodCall methodCall, MethodChannel.Result result) {
        int intValue = ((Integer) methodCall.argument("id")).intValue();
        i m5 = m(intValue);
        if (m5 != null) {
            return m5;
        }
        result.error("sqlite_error", "database_closed " + intValue, (Object) null);
        return null;
    }

    static boolean o(String str) {
        return str == null || str.equals(":memory:");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0093, code lost:
        r4.success(x(r9, false, false));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a1, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a2, code lost:
        r6.D(r2, new f2.d(r7, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ab, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void s(boolean r2, java.lang.String r3, io.flutter.plugin.common.MethodChannel.Result r4, java.lang.Boolean r5, d2.i r6, io.flutter.plugin.common.MethodCall r7, boolean r8, int r9) {
        /*
            java.lang.Object r0 = f4247f
            monitor-enter(r0)
            if (r2 != 0) goto L_0x003e
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x009f }
            r2.<init>(r3)     // Catch:{ all -> 0x009f }
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x009f }
            java.lang.String r2 = r2.getParent()     // Catch:{ all -> 0x009f }
            r1.<init>(r2)     // Catch:{ all -> 0x009f }
            boolean r2 = r1.exists()     // Catch:{ all -> 0x009f }
            if (r2 != 0) goto L_0x003e
            boolean r2 = r1.mkdirs()     // Catch:{ all -> 0x009f }
            if (r2 != 0) goto L_0x003e
            boolean r2 = r1.exists()     // Catch:{ all -> 0x009f }
            if (r2 != 0) goto L_0x003e
            java.lang.String r2 = "sqlite_error"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x009f }
            r5.<init>()     // Catch:{ all -> 0x009f }
            java.lang.String r6 = "open_failed "
            r5.append(r6)     // Catch:{ all -> 0x009f }
            r5.append(r3)     // Catch:{ all -> 0x009f }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x009f }
            r5 = 0
            r4.error(r2, r3, r5)     // Catch:{ all -> 0x009f }
            monitor-exit(r0)     // Catch:{ all -> 0x009f }
            return
        L_0x003e:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x00a1 }
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x00a1 }
            if (r2 == 0) goto L_0x004a
            r6.N()     // Catch:{ Exception -> 0x00a1 }
            goto L_0x004d
        L_0x004a:
            r6.M()     // Catch:{ Exception -> 0x00a1 }
        L_0x004d:
            java.lang.Object r2 = f4246e     // Catch:{ all -> 0x009f }
            monitor-enter(r2)     // Catch:{ all -> 0x009f }
            if (r8 == 0) goto L_0x005b
            java.util.Map<java.lang.String, java.lang.Integer> r5 = f4244c     // Catch:{ all -> 0x009c }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x009c }
            r5.put(r3, r7)     // Catch:{ all -> 0x009c }
        L_0x005b:
            java.util.Map<java.lang.Integer, d2.i> r5 = f4245d     // Catch:{ all -> 0x009c }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x009c }
            r5.put(r7, r6)     // Catch:{ all -> 0x009c }
            monitor-exit(r2)     // Catch:{ all -> 0x009c }
            int r2 = r6.f4277d     // Catch:{ all -> 0x009f }
            boolean r2 = d2.r.b(r2)     // Catch:{ all -> 0x009f }
            if (r2 == 0) goto L_0x0092
            java.lang.String r2 = "Sqflite"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x009f }
            r5.<init>()     // Catch:{ all -> 0x009f }
            java.lang.String r6 = r6.A()     // Catch:{ all -> 0x009f }
            r5.append(r6)     // Catch:{ all -> 0x009f }
            java.lang.String r6 = "opened "
            r5.append(r6)     // Catch:{ all -> 0x009f }
            r5.append(r9)     // Catch:{ all -> 0x009f }
            java.lang.String r6 = " "
            r5.append(r6)     // Catch:{ all -> 0x009f }
            r5.append(r3)     // Catch:{ all -> 0x009f }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x009f }
            android.util.Log.d(r2, r3)     // Catch:{ all -> 0x009f }
        L_0x0092:
            monitor-exit(r0)     // Catch:{ all -> 0x009f }
            r2 = 0
            java.util.Map r2 = x(r9, r2, r2)
            r4.success(r2)
            return
        L_0x009c:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x009c }
            throw r3     // Catch:{ all -> 0x009f }
        L_0x009f:
            r2 = move-exception
            goto L_0x00ac
        L_0x00a1:
            r2 = move-exception
            f2.d r3 = new f2.d     // Catch:{ all -> 0x009f }
            r3.<init>(r7, r4)     // Catch:{ all -> 0x009f }
            r6.D(r2, r3)     // Catch:{ all -> 0x009f }
            monitor-exit(r0)     // Catch:{ all -> 0x009f }
            return
        L_0x00ac:
            monitor-exit(r0)     // Catch:{ all -> 0x009f }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.c0.s(boolean, java.lang.String, io.flutter.plugin.common.MethodChannel$Result, java.lang.Boolean, d2.i, io.flutter.plugin.common.MethodCall, boolean, int):void");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void v(MethodCall methodCall, i iVar, MethodChannel.Result result) {
        try {
            iVar.f4282i.setLocale(e0.d((String) methodCall.argument("locale")));
            result.success((Object) null);
        } catch (Exception e5) {
            result.error("sqlite_error", "Error calling setLocale: " + e5.getMessage(), (Object) null);
        }
    }

    static Map x(int i5, boolean z4, boolean z5) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", Integer.valueOf(i5));
        if (z4) {
            hashMap.put("recovered", Boolean.TRUE);
        }
        if (z5) {
            hashMap.put("recoveredInTransaction", Boolean.TRUE);
        }
        return hashMap;
    }

    private void y(Context context, BinaryMessenger binaryMessenger) {
        this.f4254a = context;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "com.tekartik.sqflite", StandardMethodCodec.INSTANCE, binaryMessenger.makeBackgroundTaskQueue());
        this.f4255b = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    private void z(MethodCall methodCall, MethodChannel.Result result) {
        i n5 = n(methodCall, result);
        if (n5 != null) {
            f4253l.a(n5, new b0(n5, methodCall, result));
        }
    }

    /* access modifiers changed from: package-private */
    public void G(MethodCall methodCall, MethodChannel.Result result) {
        if (f4249h == null) {
            f4249h = this.f4254a.getDatabasePath("tekartik_sqflite.db").getParent();
        }
        result.success(f4249h);
    }

    /* access modifiers changed from: package-private */
    public void J(MethodCall methodCall, MethodChannel.Result result) {
        Object argument = methodCall.argument("androidThreadPriority");
        if (argument != null) {
            f4250i = ((Integer) argument).intValue();
        }
        Object argument2 = methodCall.argument("androidThreadCount");
        if (argument2 != null && !argument2.equals(Integer.valueOf(f4251j))) {
            f4251j = ((Integer) argument2).intValue();
            o oVar = f4253l;
            if (oVar != null) {
                oVar.b();
                f4253l = null;
            }
        }
        Integer a5 = r.a(methodCall);
        if (a5 != null) {
            f4248g = a5.intValue();
        }
        result.success((Object) null);
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        y(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f4254a = null;
        this.f4255b.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.f4255b = null;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1319569547:
                if (str.equals("execute")) {
                    c5 = 0;
                    break;
                }
                break;
            case -1253581933:
                if (str.equals("closeDatabase")) {
                    c5 = 1;
                    break;
                }
                break;
            case -1249474914:
                if (str.equals("options")) {
                    c5 = 2;
                    break;
                }
                break;
            case -1183792455:
                if (str.equals("insert")) {
                    c5 = 3;
                    break;
                }
                break;
            case -838846263:
                if (str.equals("update")) {
                    c5 = 4;
                    break;
                }
                break;
            case -396289107:
                if (str.equals("androidSetLocale")) {
                    c5 = 5;
                    break;
                }
                break;
            case -263511994:
                if (str.equals("deleteDatabase")) {
                    c5 = 6;
                    break;
                }
                break;
            case -198450538:
                if (str.equals("debugMode")) {
                    c5 = 7;
                    break;
                }
                break;
            case -17190427:
                if (str.equals("openDatabase")) {
                    c5 = 8;
                    break;
                }
                break;
            case 93509434:
                if (str.equals("batch")) {
                    c5 = 9;
                    break;
                }
                break;
            case 95458899:
                if (str.equals("debug")) {
                    c5 = 10;
                    break;
                }
                break;
            case 107944136:
                if (str.equals("query")) {
                    c5 = 11;
                    break;
                }
                break;
            case 956410295:
                if (str.equals("databaseExists")) {
                    c5 = 12;
                    break;
                }
                break;
            case 1193546321:
                if (str.equals("queryCursorNext")) {
                    c5 = 13;
                    break;
                }
                break;
            case 1385449135:
                if (str.equals("getPlatformVersion")) {
                    c5 = 14;
                    break;
                }
                break;
            case 1863829223:
                if (str.equals("getDatabasesPath")) {
                    c5 = 15;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                F(methodCall, result);
                return;
            case 1:
                A(methodCall, result);
                return;
            case 2:
                J(methodCall, result);
                return;
            case 3:
                H(methodCall, result);
                return;
            case 4:
                N(methodCall, result);
                return;
            case 5:
                M(methodCall, result);
                return;
            case 6:
                E(methodCall, result);
                return;
            case 7:
                D(methodCall, result);
                return;
            case 8:
                I(methodCall, result);
                return;
            case 9:
                z(methodCall, result);
                return;
            case 10:
                C(methodCall, result);
                return;
            case 11:
                K(methodCall, result);
                return;
            case 12:
                B(methodCall, result);
                return;
            case 13:
                L(methodCall, result);
                return;
            case 14:
                result.success("Android " + Build.VERSION.RELEASE);
                return;
            case 15:
                G(methodCall, result);
                return;
            default:
                result.notImplemented();
                return;
        }
    }
}
