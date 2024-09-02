package p1;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import m2.q;
import x1.k;
import y1.d0;
import y1.u;

public interface a {

    /* renamed from: p1.a$a  reason: collision with other inner class name */
    public interface C0098a {
        C0098a a(Context context);

        a build();
    }

    public interface b {
        void a();
    }

    public static abstract class c {

        /* renamed from: p1.a$c$a  reason: collision with other inner class name */
        class C0099a implements b {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ExecutorService f6344a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ q f6345b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ExecutorService f6346c;

            C0099a(ExecutorService executorService, q qVar, ExecutorService executorService2) {
                this.f6344a = executorService;
                this.f6345b = qVar;
                this.f6346c = executorService2;
            }

            public void a() {
                this.f6344a.shutdown();
                this.f6345b.f();
                this.f6346c.shutdown();
            }
        }

        static BluetoothAdapter a() {
            return BluetoothAdapter.getDefaultAdapter();
        }

        static q b() {
            return j3.a.e(new k());
        }

        static ExecutorService c() {
            return Executors.newSingleThreadExecutor();
        }

        static q d(ExecutorService executorService) {
            return k3.a.b(executorService);
        }

        static BluetoothManager e(Context context) {
            return (BluetoothManager) context.getSystemService("bluetooth");
        }

        static q f() {
            return k3.a.a();
        }

        static ExecutorService g() {
            return Executors.newCachedThreadPool();
        }

        static ContentResolver h(Context context) {
            return context.getContentResolver();
        }

        static int i() {
            return Build.VERSION.SDK_INT;
        }

        static byte[] j() {
            return BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        }

        static byte[] k() {
            return BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        }

        static byte[] l() {
            return BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        }

        static b m(ExecutorService executorService, q qVar, ExecutorService executorService2) {
            return new C0099a(executorService, qVar, executorService2);
        }

        static boolean n(Context context, int i5) {
            return i5 >= 20 && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
        }

        /* JADX WARNING: type inference failed for: r2v0, types: [h0.a<w1.l>, h0.a] */
        /* JADX WARNING: type inference failed for: r3v0, types: [h0.a<w1.o>, h0.a] */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static w1.k o(int r1, h0.a<w1.l> r2, h0.a<w1.o> r3) {
            /*
                r0 = 26
                if (r1 >= r0) goto L_0x000b
                java.lang.Object r1 = r2.get()
            L_0x0008:
                w1.k r1 = (w1.k) r1
                return r1
            L_0x000b:
                java.lang.Object r1 = r3.get()
                goto L_0x0008
            */
            throw new UnsupportedOperationException("Method not decompiled: p1.a.c.o(int, h0.a, h0.a):w1.k");
        }

        static boolean p(Context context) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
                int i5 = 0;
                while (true) {
                    String[] strArr = packageInfo.requestedPermissions;
                    if (i5 >= strArr.length) {
                        break;
                    } else if ("android.permission.BLUETOOTH_SCAN".equals(strArr[i5])) {
                        return (packageInfo.requestedPermissionsFlags[i5] & 65536) != 0;
                    } else {
                        i5++;
                    }
                }
            } catch (PackageManager.NameNotFoundException e5) {
                r1.q.e(e5, "Could not find application PackageInfo", new Object[0]);
            }
            return false;
        }

        static LocationManager q(Context context) {
            return (LocationManager) context.getSystemService("location");
        }

        static m2.k<Boolean> r(int i5, u uVar) {
            return i5 < 23 ? d0.b(Boolean.TRUE) : uVar.a();
        }

        /* JADX WARNING: type inference failed for: r2v0, types: [h0.a<y1.x>, h0.a] */
        /* JADX WARNING: type inference failed for: r3v0, types: [h0.a<y1.z>, h0.a] */
        /* JADX WARNING: type inference failed for: r4v0, types: [h0.a<y1.b0>, h0.a] */
        /* JADX WARNING: Unknown variable types count: 3 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static y1.w s(int r1, h0.a<y1.x> r2, h0.a<y1.z> r3, h0.a<y1.b0> r4) {
            /*
                r0 = 23
                if (r1 >= r0) goto L_0x000b
                java.lang.Object r1 = r2.get()
            L_0x0008:
                y1.w r1 = (y1.w) r1
                return r1
            L_0x000b:
                r2 = 31
                if (r1 >= r2) goto L_0x0014
                java.lang.Object r1 = r3.get()
                goto L_0x0008
            L_0x0014:
                java.lang.Object r1 = r4.get()
                goto L_0x0008
            */
            throw new UnsupportedOperationException("Method not decompiled: p1.a.c.s(int, h0.a, h0.a, h0.a):y1.w");
        }

        static String[][] t(int i5, int i6) {
            if (Math.min(i5, i6) < 31) {
                return new String[0][];
            }
            return new String[][]{new String[]{"android.permission.BLUETOOTH_CONNECT"}};
        }

        static String[][] u(int i5, int i6, boolean z4) {
            int min = Math.min(i5, i6);
            if (min < 23) {
                return new String[0][];
            }
            if (min < 29) {
                return new String[][]{new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}};
            } else if (min < 31) {
                return new String[][]{new String[]{"android.permission.ACCESS_FINE_LOCATION"}};
            } else if (z4) {
                return new String[][]{new String[]{"android.permission.BLUETOOTH_SCAN"}};
            } else {
                return new String[][]{new String[]{"android.permission.BLUETOOTH_SCAN"}, new String[]{"android.permission.ACCESS_FINE_LOCATION"}};
            }
        }

        /* JADX WARNING: type inference failed for: r2v0, types: [h0.a, h0.a<w1.t>] */
        /* JADX WARNING: type inference failed for: r3v0, types: [h0.a<w1.v>, h0.a] */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static w1.s v(int r1, h0.a<w1.t> r2, h0.a<w1.v> r3) {
            /*
                r0 = 24
                if (r1 >= r0) goto L_0x000b
                java.lang.Object r1 = r2.get()
            L_0x0008:
                w1.s r1 = (w1.s) r1
                return r1
            L_0x000b:
                java.lang.Object r1 = r3.get()
                goto L_0x0008
            */
            throw new UnsupportedOperationException("Method not decompiled: p1.a.c.v(int, h0.a, h0.a):w1.s");
        }

        /* JADX WARNING: type inference failed for: r2v0, types: [h0.a<w1.e0>, h0.a] */
        /* JADX WARNING: type inference failed for: r3v0, types: [h0.a<w1.g0>, h0.a] */
        /* JADX WARNING: type inference failed for: r4v0, types: [h0.a<w1.i0>, h0.a] */
        /* JADX WARNING: Unknown variable types count: 3 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static w1.d0 w(int r1, h0.a<w1.e0> r2, h0.a<w1.g0> r3, h0.a<w1.i0> r4) {
            /*
                r0 = 21
                if (r1 >= r0) goto L_0x000b
                java.lang.Object r1 = r2.get()
            L_0x0008:
                w1.d0 r1 = (w1.d0) r1
                return r1
            L_0x000b:
                r2 = 23
                if (r1 >= r2) goto L_0x0014
                java.lang.Object r1 = r3.get()
                goto L_0x0008
            L_0x0014:
                java.lang.Object r1 = r4.get()
                goto L_0x0008
            */
            throw new UnsupportedOperationException("Method not decompiled: p1.a.c.w(int, h0.a, h0.a, h0.a):w1.d0");
        }

        static int x(Context context) {
            try {
                return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion;
            } catch (Throwable unused) {
                return Integer.MAX_VALUE;
            }
        }
    }

    g0 a();
}
