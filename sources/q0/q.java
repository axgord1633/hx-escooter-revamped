package q0;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import androidx.core.app.j0;
import io.flutter.plugin.common.PluginRegistry;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

final class q implements PluginRegistry.ActivityResultListener, PluginRegistry.RequestPermissionsResultListener {

    /* renamed from: e  reason: collision with root package name */
    private final Context f6621e;

    /* renamed from: f  reason: collision with root package name */
    private b f6622f;

    /* renamed from: g  reason: collision with root package name */
    private Activity f6623g;

    /* renamed from: h  reason: collision with root package name */
    private int f6624h;

    /* renamed from: i  reason: collision with root package name */
    private Map<Integer, Integer> f6625i;

    @FunctionalInterface
    interface a {
        void a(int i5);
    }

    @FunctionalInterface
    interface b {
        void a(Map<Integer, Integer> map);
    }

    @FunctionalInterface
    interface c {
        void a(boolean z4);
    }

    public q(Context context) {
        this.f6621e = context;
    }

    private int a() {
        List<String> c5 = s.c(this.f6621e, 21);
        if (!(c5 == null || c5.isEmpty())) {
            return 1;
        }
        Log.d("permissions_handler", "Bluetooth permission missing in manifest");
        return 0;
    }

    private int b() {
        if (Build.VERSION.SDK_INT < 33) {
            return j0.c(this.f6621e).a() ? 1 : 0;
        }
        if (this.f6621e.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) {
            return 1;
        }
        return s.b(this.f6623g, "android.permission.POST_NOTIFICATIONS");
    }

    private int d(int i5) {
        int i6;
        int valueOf;
        if (i5 == 17) {
            return b();
        }
        if (i5 == 21) {
            return a();
        }
        if ((i5 == 30 || i5 == 28 || i5 == 29) && Build.VERSION.SDK_INT < 31) {
            return a();
        }
        if ((i5 == 37 || i5 == 0) && !e()) {
            return 0;
        }
        List<String> c5 = s.c(this.f6621e, i5);
        if (c5 == null) {
            Log.d("permissions_handler", "No android specific permissions needed for: " + i5);
            return 1;
        } else if (c5.size() == 0) {
            Log.d("permissions_handler", "No permissions found in manifest for: " + c5 + i5);
            return (i5 != 22 || Build.VERSION.SDK_INT >= 30) ? 0 : 2;
        } else {
            if (this.f6621e.getApplicationInfo().targetSdkVersion >= 23) {
                HashSet hashSet = new HashSet();
                for (String next : c5) {
                    if (i5 == 16) {
                        String packageName = this.f6621e.getPackageName();
                        PowerManager powerManager = (PowerManager) this.f6621e.getSystemService("power");
                        if (powerManager == null || !powerManager.isIgnoringBatteryOptimizations(packageName)) {
                            valueOf = 0;
                            hashSet.add(valueOf);
                        }
                    } else {
                        if (i5 == 22) {
                            if (Build.VERSION.SDK_INT < 30) {
                                hashSet.add(2);
                            }
                            i6 = Environment.isExternalStorageManager();
                        } else if (i5 == 23) {
                            i6 = Settings.canDrawOverlays(this.f6621e);
                        } else if (i5 == 24) {
                            if (Build.VERSION.SDK_INT >= 26) {
                                i6 = this.f6621e.getPackageManager().canRequestPackageInstalls();
                            }
                        } else if (i5 == 27) {
                            i6 = ((NotificationManager) this.f6621e.getSystemService("notification")).isNotificationPolicyAccessGranted();
                        } else if (i5 == 34) {
                            if (Build.VERSION.SDK_INT >= 31) {
                                i6 = ((AlarmManager) this.f6621e.getSystemService("alarm")).canScheduleExactAlarms();
                            }
                        } else if (androidx.core.content.a.a(this.f6621e, next) != 0) {
                            i6 = s.b(this.f6623g, next);
                        }
                        valueOf = Integer.valueOf(i6);
                        hashSet.add(valueOf);
                    }
                    valueOf = 1;
                    hashSet.add(valueOf);
                }
                if (!hashSet.isEmpty()) {
                    return s.j(hashSet).intValue();
                }
            }
            return 1;
        }
    }

    private boolean e() {
        List<String> c5 = s.c(this.f6621e, 37);
        boolean z4 = c5 != null && c5.contains("android.permission.WRITE_CALENDAR");
        boolean z5 = c5 != null && c5.contains("android.permission.READ_CALENDAR");
        if (z4 && z5) {
            return true;
        }
        if (!z4) {
            Log.d("permissions_handler", "android.permission.WRITE_CALENDAR missing in manifest");
        }
        if (!z5) {
            Log.d("permissions_handler", "android.permission.READ_CALENDAR missing in manifest");
        }
        return false;
    }

    private void f(String str, int i5) {
        if (this.f6623g != null) {
            Intent intent = new Intent(str);
            if (!str.equals("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS")) {
                intent.setData(Uri.parse("package:" + this.f6623g.getPackageName()));
            }
            this.f6623g.startActivityForResult(intent, i5);
            this.f6624h++;
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i5, a aVar) {
        aVar.a(d(i5));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x011a, code lost:
        if (android.os.Build.VERSION.SDK_INT < 30) goto L_0x0050;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(java.util.List<java.lang.Integer> r10, q0.q.b r11, q0.b r12) {
        /*
            r9 = this;
            int r0 = r9.f6624h
            java.lang.String r1 = "PermissionHandler.PermissionManager"
            if (r0 <= 0) goto L_0x000c
            java.lang.String r10 = "A request for permissions is already running, please wait for it to finish before doing another request (note that you can request multiple permissions at the same time)."
        L_0x0008:
            r12.a(r1, r10)
            return
        L_0x000c:
            android.app.Activity r0 = r9.f6623g
            if (r0 != 0) goto L_0x001a
            java.lang.String r10 = "permissions_handler"
            java.lang.String r11 = "Unable to detect current Activity."
            android.util.Log.d(r10, r11)
            java.lang.String r10 = "Unable to detect current Android Activity."
            goto L_0x0008
        L_0x001a:
            r9.f6622f = r11
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            r9.f6625i = r11
            r11 = 0
            r9.f6624h = r11
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x002f:
            boolean r0 = r10.hasNext()
            r1 = 24
            if (r0 == 0) goto L_0x0126
            java.lang.Object r0 = r10.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r2 = r0.intValue()
            int r2 = r9.d(r2)
            r3 = 1
            if (r2 != r3) goto L_0x005a
            java.util.Map<java.lang.Integer, java.lang.Integer> r1 = r9.f6625i
            boolean r1 = r1.containsKey(r0)
            if (r1 != 0) goto L_0x002f
        L_0x0050:
            java.util.Map<java.lang.Integer, java.lang.Integer> r1 = r9.f6625i
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
        L_0x0056:
            r1.put(r0, r2)
            goto L_0x002f
        L_0x005a:
            android.app.Activity r2 = r9.f6623g
            int r3 = r0.intValue()
            java.util.List r2 = q0.s.c(r2, r3)
            r3 = 2
            r4 = 22
            r5 = 30
            r6 = 16
            if (r2 == 0) goto L_0x00fd
            boolean r7 = r2.isEmpty()
            if (r7 == 0) goto L_0x0075
            goto L_0x00fd
        L_0x0075:
            int r7 = android.os.Build.VERSION.SDK_INT
            int r8 = r0.intValue()
            if (r8 != r6) goto L_0x0085
            r0 = 209(0xd1, float:2.93E-43)
            java.lang.String r1 = "android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS"
        L_0x0081:
            r9.f(r1, r0)
            goto L_0x002f
        L_0x0085:
            if (r7 < r5) goto L_0x0092
            int r5 = r0.intValue()
            if (r5 != r4) goto L_0x0092
            r0 = 210(0xd2, float:2.94E-43)
            java.lang.String r1 = "android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION"
            goto L_0x0081
        L_0x0092:
            int r4 = r0.intValue()
            r5 = 23
            if (r4 != r5) goto L_0x009f
            r0 = 211(0xd3, float:2.96E-43)
            java.lang.String r1 = "android.settings.action.MANAGE_OVERLAY_PERMISSION"
            goto L_0x0081
        L_0x009f:
            r4 = 26
            if (r7 < r4) goto L_0x00ae
            int r4 = r0.intValue()
            if (r4 != r1) goto L_0x00ae
            r0 = 212(0xd4, float:2.97E-43)
            java.lang.String r1 = "android.settings.MANAGE_UNKNOWN_APP_SOURCES"
            goto L_0x0081
        L_0x00ae:
            int r1 = r0.intValue()
            r4 = 27
            if (r1 != r4) goto L_0x00bb
            r0 = 213(0xd5, float:2.98E-43)
            java.lang.String r1 = "android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS"
            goto L_0x0081
        L_0x00bb:
            r1 = 31
            if (r7 < r1) goto L_0x00cc
            int r1 = r0.intValue()
            r4 = 34
            if (r1 != r4) goto L_0x00cc
            r0 = 214(0xd6, float:3.0E-43)
            java.lang.String r1 = "android.settings.REQUEST_SCHEDULE_EXACT_ALARM"
            goto L_0x0081
        L_0x00cc:
            int r1 = r0.intValue()
            r4 = 37
            if (r1 == r4) goto L_0x00e6
            int r1 = r0.intValue()
            if (r1 != 0) goto L_0x00db
            goto L_0x00e6
        L_0x00db:
            r12.addAll(r2)
            int r0 = r9.f6624h
            int r1 = r2.size()
            int r0 = r0 + r1
            goto L_0x00f9
        L_0x00e6:
            boolean r1 = r9.e()
            if (r1 == 0) goto L_0x011e
            java.lang.String r0 = "android.permission.WRITE_CALENDAR"
            r12.add(r0)
            java.lang.String r0 = "android.permission.READ_CALENDAR"
            r12.add(r0)
            int r0 = r9.f6624h
            int r0 = r0 + r3
        L_0x00f9:
            r9.f6624h = r0
            goto L_0x002f
        L_0x00fd:
            java.util.Map<java.lang.Integer, java.lang.Integer> r1 = r9.f6625i
            boolean r1 = r1.containsKey(r0)
            if (r1 != 0) goto L_0x002f
            int r1 = r0.intValue()
            java.util.Map<java.lang.Integer, java.lang.Integer> r1 = r9.f6625i
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)
            r1.put(r0, r2)
            int r1 = r0.intValue()
            if (r1 != r4) goto L_0x011e
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 >= r5) goto L_0x011e
            goto L_0x0050
        L_0x011e:
            java.util.Map<java.lang.Integer, java.lang.Integer> r1 = r9.f6625i
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)
            goto L_0x0056
        L_0x0126:
            int r10 = r12.size()
            if (r10 <= 0) goto L_0x0139
            java.lang.String[] r10 = new java.lang.String[r11]
            java.lang.Object[] r10 = r12.toArray(r10)
            java.lang.String[] r10 = (java.lang.String[]) r10
            android.app.Activity r11 = r9.f6623g
            androidx.core.app.b.o(r11, r10, r1)
        L_0x0139:
            q0.q$b r10 = r9.f6622f
            if (r10 == 0) goto L_0x0146
            int r11 = r9.f6624h
            if (r11 != 0) goto L_0x0146
            java.util.Map<java.lang.Integer, java.lang.Integer> r11 = r9.f6625i
            r10.a(r11)
        L_0x0146:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.q.g(java.util.List, q0.q$b, q0.b):void");
    }

    public void h(Activity activity) {
        this.f6623g = activity;
    }

    /* access modifiers changed from: package-private */
    public void i(int i5, c cVar, b bVar) {
        Activity activity = this.f6623g;
        if (activity == null) {
            Log.d("permissions_handler", "Unable to detect current Activity.");
            bVar.a("PermissionHandler.PermissionManager", "Unable to detect current Android Activity.");
            return;
        }
        List<String> c5 = s.c(activity, i5);
        if (c5 == null) {
            Log.d("permissions_handler", "No android specific permissions needed for: " + i5);
            cVar.a(false);
        } else if (c5.isEmpty()) {
            Log.d("permissions_handler", "No permissions found in manifest for: " + i5 + " no need to show request rationale");
            cVar.a(false);
        } else {
            cVar.a(androidx.core.app.b.r(this.f6623g, c5.get(0)));
        }
    }

    public boolean onActivityResult(int i5, int i6, Intent intent) {
        int i7;
        Activity activity = this.f6623g;
        boolean z4 = false;
        if (activity == null) {
            return false;
        }
        if (i5 == 209) {
            i7 = 16;
            String packageName = this.f6621e.getPackageName();
            PowerManager powerManager = (PowerManager) this.f6621e.getSystemService("power");
            if (powerManager != null && powerManager.isIgnoringBatteryOptimizations(packageName)) {
                z4 = true;
            }
        } else if (i5 == 210) {
            if (Build.VERSION.SDK_INT < 30) {
                return false;
            }
            z4 = Environment.isExternalStorageManager();
            i7 = 22;
        } else if (i5 == 211) {
            z4 = Settings.canDrawOverlays(activity);
            i7 = 23;
        } else if (i5 == 212) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            z4 = activity.getPackageManager().canRequestPackageInstalls();
            i7 = 24;
        } else if (i5 == 213) {
            z4 = ((NotificationManager) activity.getSystemService("notification")).isNotificationPolicyAccessGranted();
            i7 = 27;
        } else if (i5 != 214 || Build.VERSION.SDK_INT < 31) {
            return false;
        } else {
            z4 = ((AlarmManager) activity.getSystemService("alarm")).canScheduleExactAlarms();
            i7 = 34;
        }
        this.f6625i.put(Integer.valueOf(i7), Integer.valueOf(z4 ? 1 : 0));
        int i8 = this.f6624h - 1;
        this.f6624h = i8;
        b bVar = this.f6622f;
        if (bVar != null && i8 == 0) {
            bVar.a(this.f6625i);
        }
        return true;
    }

    public boolean onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        int g5;
        Map<Integer, Integer> map;
        int i6;
        Integer valueOf;
        if (i5 != 24) {
            this.f6624h = 0;
            return false;
        } else if (this.f6625i == null) {
            return false;
        } else {
            if (strArr.length == 0 && iArr.length == 0) {
                Log.w("permissions_handler", "onRequestPermissionsResult is called without results. This is probably caused by interfering request codes. If you see this error, please file an issue in flutter-permission-handler, including a list of plugins used by this application: https://github.com/Baseflow/flutter-permission-handler/issues");
                return false;
            }
            List asList = Arrays.asList(strArr);
            int indexOf = asList.indexOf("android.permission.WRITE_CALENDAR");
            if (indexOf >= 0) {
                int k5 = s.k(this.f6623g, "android.permission.WRITE_CALENDAR", iArr[indexOf]);
                this.f6625i.put(36, Integer.valueOf(k5));
                int indexOf2 = asList.indexOf("android.permission.READ_CALENDAR");
                if (indexOf2 >= 0) {
                    int intValue = s.i(Integer.valueOf(k5), Integer.valueOf(s.k(this.f6623g, "android.permission.READ_CALENDAR", iArr[indexOf2]))).intValue();
                    this.f6625i.put(37, Integer.valueOf(intValue));
                    this.f6625i.put(0, Integer.valueOf(intValue));
                }
            }
            for (int i7 = 0; i7 < strArr.length; i7++) {
                String str = strArr[i7];
                if (!str.equals("android.permission.WRITE_CALENDAR") && !str.equals("android.permission.READ_CALENDAR") && (g5 = s.g(str)) != 20) {
                    int i8 = iArr[i7];
                    if (g5 == 8) {
                        valueOf = s.i(this.f6625i.get(8), Integer.valueOf(s.k(this.f6623g, str, i8)));
                        map = this.f6625i;
                        i6 = 8;
                    } else if (g5 == 7) {
                        if (!this.f6625i.containsKey(7)) {
                            this.f6625i.put(7, Integer.valueOf(s.k(this.f6623g, str, i8)));
                        }
                        if (!this.f6625i.containsKey(14)) {
                            this.f6625i.put(14, Integer.valueOf(s.k(this.f6623g, str, i8)));
                        }
                    } else if (g5 == 4) {
                        int k6 = s.k(this.f6623g, str, i8);
                        if (!this.f6625i.containsKey(4)) {
                            map = this.f6625i;
                            i6 = 4;
                            valueOf = Integer.valueOf(k6);
                        }
                    } else if (g5 == 3) {
                        int k7 = s.k(this.f6623g, str, i8);
                        if (Build.VERSION.SDK_INT < 29 && !this.f6625i.containsKey(4)) {
                            this.f6625i.put(4, Integer.valueOf(k7));
                        }
                        if (!this.f6625i.containsKey(5)) {
                            this.f6625i.put(5, Integer.valueOf(k7));
                        }
                        this.f6625i.put(Integer.valueOf(g5), Integer.valueOf(k7));
                    } else if (!this.f6625i.containsKey(Integer.valueOf(g5))) {
                        this.f6625i.put(Integer.valueOf(g5), Integer.valueOf(s.k(this.f6623g, str, i8)));
                    }
                    map.put(i6, valueOf);
                }
            }
            int length = this.f6624h - iArr.length;
            this.f6624h = length;
            b bVar = this.f6622f;
            if (bVar == null || length != 0) {
                return true;
            }
            bVar.a(this.f6625i);
            return true;
        }
    }
}
