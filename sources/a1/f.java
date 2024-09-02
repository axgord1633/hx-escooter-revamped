package a1;

import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import com.yalantis.ucrop.BuildConfig;
import java.lang.reflect.Method;
import w0.p;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final int f11a = Process.myUid();

    /* renamed from: b  reason: collision with root package name */
    private static final Method f12b;

    /* renamed from: c  reason: collision with root package name */
    private static final Method f13c;

    /* renamed from: d  reason: collision with root package name */
    private static final Method f14d;

    /* renamed from: e  reason: collision with root package name */
    private static final Method f15e;

    /* renamed from: f  reason: collision with root package name */
    private static final Method f16f;

    /* renamed from: g  reason: collision with root package name */
    private static final Method f17g;

    /* renamed from: h  reason: collision with root package name */
    private static final Method f18h;

    /* renamed from: i  reason: collision with root package name */
    private static final Method f19i;

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c A[SYNTHETIC, Splitter:B:23:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b4  */
    static {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r1 = "add"
            int r2 = android.os.Process.myUid()
            f11a = r2
            r2 = 1
            r3 = 0
            r4 = 0
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x001a }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x001a }
            r5[r3] = r6     // Catch:{ Exception -> 0x001a }
            java.lang.Class<android.os.WorkSource> r6 = android.os.WorkSource.class
            java.lang.reflect.Method r5 = r6.getMethod(r1, r5)     // Catch:{ Exception -> 0x001a }
            goto L_0x001b
        L_0x001a:
            r5 = r4
        L_0x001b:
            f12b = r5
            boolean r5 = a1.e.b()
            r6 = 2
            if (r5 == 0) goto L_0x0033
            java.lang.Class[] r5 = new java.lang.Class[r6]     // Catch:{ Exception -> 0x0033 }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0033 }
            r5[r3] = r7     // Catch:{ Exception -> 0x0033 }
            r5[r2] = r0     // Catch:{ Exception -> 0x0033 }
            java.lang.Class<android.os.WorkSource> r7 = android.os.WorkSource.class
            java.lang.reflect.Method r1 = r7.getMethod(r1, r5)     // Catch:{ Exception -> 0x0033 }
            goto L_0x0034
        L_0x0033:
            r1 = r4
        L_0x0034:
            f13c = r1
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            java.lang.String r5 = "size"
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0041 }
            java.lang.reflect.Method r1 = r1.getMethod(r5, r7)     // Catch:{ Exception -> 0x0041 }
            goto L_0x0042
        L_0x0041:
            r1 = r4
        L_0x0042:
            f14d = r1
            java.lang.Class[] r1 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0053 }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0053 }
            r1[r3] = r5     // Catch:{ Exception -> 0x0053 }
            java.lang.Class<android.os.WorkSource> r5 = android.os.WorkSource.class
            java.lang.String r7 = "get"
            java.lang.reflect.Method r1 = r5.getMethod(r7, r1)     // Catch:{ Exception -> 0x0053 }
            goto L_0x0054
        L_0x0053:
            r1 = r4
        L_0x0054:
            f15e = r1
            boolean r1 = a1.e.b()
            if (r1 == 0) goto L_0x006b
            java.lang.Class[] r1 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x006b }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x006b }
            r1[r3] = r5     // Catch:{ Exception -> 0x006b }
            java.lang.Class<android.os.WorkSource> r5 = android.os.WorkSource.class
            java.lang.String r7 = "getName"
            java.lang.reflect.Method r1 = r5.getMethod(r7, r1)     // Catch:{ Exception -> 0x006b }
            goto L_0x006c
        L_0x006b:
            r1 = r4
        L_0x006c:
            f16f = r1
            boolean r1 = a1.e.g()
            java.lang.String r5 = "WorkSourceUtil"
            if (r1 == 0) goto L_0x0087
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            java.lang.String r7 = "createWorkChain"
            java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0081 }
            java.lang.reflect.Method r1 = r1.getMethod(r7, r8)     // Catch:{ Exception -> 0x0081 }
            goto L_0x0088
        L_0x0081:
            r1 = move-exception
            java.lang.String r7 = "Missing WorkChain API createWorkChain"
            android.util.Log.w(r5, r7, r1)
        L_0x0087:
            r1 = r4
        L_0x0088:
            f17g = r1
            boolean r1 = a1.e.g()
            if (r1 == 0) goto L_0x00ab
            java.lang.String r1 = "android.os.WorkSource$WorkChain"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x00a5 }
            java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch:{ Exception -> 0x00a5 }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x00a5 }
            r6[r3] = r7     // Catch:{ Exception -> 0x00a5 }
            r6[r2] = r0     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r0 = "addNode"
            java.lang.reflect.Method r0 = r1.getMethod(r0, r6)     // Catch:{ Exception -> 0x00a5 }
            goto L_0x00ac
        L_0x00a5:
            r0 = move-exception
            java.lang.String r1 = "Missing WorkChain class"
            android.util.Log.w(r5, r1, r0)
        L_0x00ab:
            r0 = r4
        L_0x00ac:
            f18h = r0
            boolean r0 = a1.e.g()
            if (r0 == 0) goto L_0x00c1
            java.lang.Class<android.os.WorkSource> r0 = android.os.WorkSource.class
            java.lang.String r1 = "isEmpty"
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x00c1 }
            java.lang.reflect.Method r4 = r0.getMethod(r1, r3)     // Catch:{ Exception -> 0x00c1 }
            r4.setAccessible(r2)     // Catch:{ Exception -> 0x00c1 }
        L_0x00c1:
            f19i = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.f.<clinit>():void");
    }

    public static void a(WorkSource workSource, int i5, String str) {
        Method method = f13c;
        if (method != null) {
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            try {
                method.invoke(workSource, new Object[]{Integer.valueOf(i5), str});
            } catch (Exception e5) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e5);
            }
        } else {
            Method method2 = f12b;
            if (method2 != null) {
                try {
                    method2.invoke(workSource, new Object[]{Integer.valueOf(i5)});
                } catch (Exception e6) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e6);
                }
            }
        }
    }

    public static boolean b(WorkSource workSource) {
        Method method = f19i;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, new Object[0]);
                p.g(invoke);
                return ((Boolean) invoke).booleanValue();
            } catch (Exception e5) {
                Log.e("WorkSourceUtil", "Unable to check WorkSource emptiness", e5);
            }
        }
        return c(workSource) == 0;
    }

    public static int c(WorkSource workSource) {
        Method method = f14d;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, new Object[0]);
                p.g(invoke);
                return ((Integer) invoke).intValue();
            } catch (Exception e5) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e5);
            }
        }
        return 0;
    }
}
