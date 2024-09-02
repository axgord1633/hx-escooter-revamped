package q0;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import androidx.core.app.b;
import com.yalantis.ucrop.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class s {
    private static String a(Context context, String str) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 31 && e(context, (ArrayList<String>) null, str)) {
            return str;
        }
        if (i5 < 29) {
            if (e(context, (ArrayList<String>) null, "android.permission.ACCESS_FINE_LOCATION")) {
                return "android.permission.ACCESS_FINE_LOCATION";
            }
            if (e(context, (ArrayList<String>) null, "android.permission.ACCESS_COARSE_LOCATION")) {
                return "android.permission.ACCESS_COARSE_LOCATION";
            }
            return null;
        } else if (e(context, (ArrayList<String>) null, "android.permission.ACCESS_FINE_LOCATION")) {
            return "android.permission.ACCESS_FINE_LOCATION";
        } else {
            return null;
        }
    }

    static int b(Activity activity, String str) {
        if (activity == null) {
            return 0;
        }
        boolean l5 = l(activity, str);
        boolean z4 = true;
        boolean z5 = !f(activity, str);
        if (!l5) {
            z4 = z5;
        } else if (z5) {
            z4 = false;
        }
        if (!l5 && z4) {
            h(activity, str);
        }
        return (!l5 || !z4) ? 0 : 4;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x016f, code lost:
        if (e(r6, r0, r7) != false) goto L_0x024c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x017d, code lost:
        if (e(r6, r0, r7) != false) goto L_0x024c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x01f4, code lost:
        if (e(r6, r0, r7) != false) goto L_0x024c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x024a, code lost:
        if (e(r6, r0, r7) != false) goto L_0x024c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x024c, code lost:
        r0.add(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x025f, code lost:
        if (e(r6, r0, r7) != false) goto L_0x024c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0078, code lost:
        if (r6 != null) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0085, code lost:
        if (r6 != null) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0092, code lost:
        if (r6 != null) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b1, code lost:
        if (e(r6, r0, r7) != false) goto L_0x024c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00cc, code lost:
        if (e(r6, r0, r7) != false) goto L_0x024c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00df, code lost:
        r0.add(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00ef, code lost:
        if (e(r6, r0, r7) != false) goto L_0x024c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00fd, code lost:
        if (e(r6, r0, r7) != false) goto L_0x024c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0107, code lost:
        if (e(r6, r0, r7) != false) goto L_0x024c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.List<java.lang.String> c(android.content.Context r6, int r7) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = 31
            java.lang.String r3 = "android.permission.WRITE_CALENDAR"
            r4 = 29
            r5 = 33
            switch(r7) {
                case 0: goto L_0x0250;
                case 1: goto L_0x0244;
                case 2: goto L_0x0222;
                case 3: goto L_0x01f8;
                case 4: goto L_0x01f8;
                case 5: goto L_0x01f8;
                case 6: goto L_0x01f7;
                case 7: goto L_0x01ee;
                case 8: goto L_0x0181;
                case 9: goto L_0x0173;
                case 10: goto L_0x0011;
                case 11: goto L_0x01f7;
                case 12: goto L_0x0169;
                case 13: goto L_0x012d;
                case 14: goto L_0x01ee;
                case 15: goto L_0x010b;
                case 16: goto L_0x0101;
                case 17: goto L_0x00f3;
                case 18: goto L_0x00e4;
                case 19: goto L_0x00d0;
                case 20: goto L_0x01f7;
                case 21: goto L_0x00c6;
                case 22: goto L_0x00b5;
                case 23: goto L_0x00ab;
                case 24: goto L_0x00a0;
                case 25: goto L_0x0011;
                case 26: goto L_0x0011;
                case 27: goto L_0x0095;
                case 28: goto L_0x0088;
                case 29: goto L_0x007b;
                case 30: goto L_0x006e;
                case 31: goto L_0x005e;
                case 32: goto L_0x004e;
                case 33: goto L_0x003e;
                case 34: goto L_0x002e;
                case 35: goto L_0x001e;
                case 36: goto L_0x0013;
                case 37: goto L_0x0250;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x0262
        L_0x0013:
            boolean r6 = e(r6, r0, r3)
            if (r6 == 0) goto L_0x0262
            r0.add(r3)
            goto L_0x0262
        L_0x001e:
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r5) goto L_0x0262
            java.lang.String r7 = "android.permission.BODY_SENSORS_BACKGROUND"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
            java.lang.String r6 = "android.permission.BODY_SENSORS_BACKGROUND"
            goto L_0x00df
        L_0x002e:
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r2) goto L_0x0262
            java.lang.String r7 = "android.permission.SCHEDULE_EXACT_ALARM"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
            java.lang.String r6 = "android.permission.SCHEDULE_EXACT_ALARM"
            goto L_0x00df
        L_0x003e:
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r5) goto L_0x0262
            java.lang.String r7 = "android.permission.READ_MEDIA_AUDIO"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
            java.lang.String r6 = "android.permission.READ_MEDIA_AUDIO"
            goto L_0x00df
        L_0x004e:
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r5) goto L_0x0262
            java.lang.String r7 = "android.permission.READ_MEDIA_VIDEO"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
            java.lang.String r6 = "android.permission.READ_MEDIA_VIDEO"
            goto L_0x00df
        L_0x005e:
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r5) goto L_0x0262
            java.lang.String r7 = "android.permission.NEARBY_WIFI_DEVICES"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
            java.lang.String r6 = "android.permission.NEARBY_WIFI_DEVICES"
            goto L_0x00df
        L_0x006e:
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r2) goto L_0x0262
            java.lang.String r7 = "android.permission.BLUETOOTH_CONNECT"
            java.lang.String r6 = a(r6, r7)
            if (r6 == 0) goto L_0x0262
        L_0x007a:
            goto L_0x00df
        L_0x007b:
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r2) goto L_0x0262
            java.lang.String r7 = "android.permission.BLUETOOTH_ADVERTISE"
            java.lang.String r6 = a(r6, r7)
            if (r6 == 0) goto L_0x0262
            goto L_0x007a
        L_0x0088:
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r2) goto L_0x0262
            java.lang.String r7 = "android.permission.BLUETOOTH_SCAN"
            java.lang.String r6 = a(r6, r7)
            if (r6 == 0) goto L_0x0262
            goto L_0x007a
        L_0x0095:
            java.lang.String r7 = "android.permission.ACCESS_NOTIFICATION_POLICY"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
            java.lang.String r6 = "android.permission.ACCESS_NOTIFICATION_POLICY"
            goto L_0x00df
        L_0x00a0:
            java.lang.String r7 = "android.permission.REQUEST_INSTALL_PACKAGES"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
            java.lang.String r6 = "android.permission.REQUEST_INSTALL_PACKAGES"
            goto L_0x00df
        L_0x00ab:
            java.lang.String r7 = "android.permission.SYSTEM_ALERT_WINDOW"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
            goto L_0x024c
        L_0x00b5:
            int r7 = android.os.Build.VERSION.SDK_INT
            r1 = 30
            if (r7 < r1) goto L_0x0262
            java.lang.String r7 = "android.permission.MANAGE_EXTERNAL_STORAGE"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
            java.lang.String r6 = "android.permission.MANAGE_EXTERNAL_STORAGE"
            goto L_0x00df
        L_0x00c6:
            java.lang.String r7 = "android.permission.BLUETOOTH"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
            goto L_0x024c
        L_0x00d0:
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 >= r4) goto L_0x00d5
            return r1
        L_0x00d5:
            java.lang.String r7 = "android.permission.ACTIVITY_RECOGNITION"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
            java.lang.String r6 = "android.permission.ACTIVITY_RECOGNITION"
        L_0x00df:
            r0.add(r6)
            goto L_0x0262
        L_0x00e4:
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 >= r4) goto L_0x00e9
            return r1
        L_0x00e9:
            java.lang.String r7 = "android.permission.ACCESS_MEDIA_LOCATION"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
            goto L_0x024c
        L_0x00f3:
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r5) goto L_0x0262
            java.lang.String r7 = "android.permission.POST_NOTIFICATIONS"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
            goto L_0x024c
        L_0x0101:
            java.lang.String r7 = "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
            goto L_0x024c
        L_0x010b:
            java.lang.String r7 = "android.permission.READ_EXTERNAL_STORAGE"
            boolean r1 = e(r6, r0, r7)
            if (r1 == 0) goto L_0x0116
            r0.add(r7)
        L_0x0116:
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r4) goto L_0x0122
            if (r7 != r4) goto L_0x0262
            boolean r7 = android.os.Environment.isExternalStorageLegacy()
            if (r7 == 0) goto L_0x0262
        L_0x0122:
            java.lang.String r7 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
            java.lang.String r6 = "android.permission.WRITE_EXTERNAL_STORAGE"
            goto L_0x00df
        L_0x012d:
            java.lang.String r7 = "android.permission.SEND_SMS"
            boolean r1 = e(r6, r0, r7)
            if (r1 == 0) goto L_0x0138
            r0.add(r7)
        L_0x0138:
            java.lang.String r7 = "android.permission.RECEIVE_SMS"
            boolean r1 = e(r6, r0, r7)
            if (r1 == 0) goto L_0x0143
            r0.add(r7)
        L_0x0143:
            java.lang.String r7 = "android.permission.READ_SMS"
            boolean r7 = e(r6, r0, r7)
            if (r7 == 0) goto L_0x0150
            java.lang.String r7 = "android.permission.READ_SMS"
            r0.add(r7)
        L_0x0150:
            java.lang.String r7 = "android.permission.RECEIVE_WAP_PUSH"
            boolean r7 = e(r6, r0, r7)
            if (r7 == 0) goto L_0x015d
            java.lang.String r7 = "android.permission.RECEIVE_WAP_PUSH"
            r0.add(r7)
        L_0x015d:
            java.lang.String r7 = "android.permission.RECEIVE_MMS"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
            java.lang.String r6 = "android.permission.RECEIVE_MMS"
            goto L_0x00df
        L_0x0169:
            java.lang.String r7 = "android.permission.BODY_SENSORS"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
            goto L_0x024c
        L_0x0173:
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r5) goto L_0x0262
            java.lang.String r7 = "android.permission.READ_MEDIA_IMAGES"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
            goto L_0x024c
        L_0x0181:
            java.lang.String r7 = "android.permission.READ_PHONE_STATE"
            boolean r1 = e(r6, r0, r7)
            if (r1 == 0) goto L_0x018c
            r0.add(r7)
        L_0x018c:
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 <= r4) goto L_0x019d
            java.lang.String r1 = "android.permission.READ_PHONE_NUMBERS"
            boolean r1 = e(r6, r0, r1)
            if (r1 == 0) goto L_0x019d
            java.lang.String r1 = "android.permission.READ_PHONE_NUMBERS"
            r0.add(r1)
        L_0x019d:
            java.lang.String r1 = "android.permission.CALL_PHONE"
            boolean r1 = e(r6, r0, r1)
            if (r1 == 0) goto L_0x01aa
            java.lang.String r1 = "android.permission.CALL_PHONE"
            r0.add(r1)
        L_0x01aa:
            java.lang.String r1 = "android.permission.READ_CALL_LOG"
            boolean r1 = e(r6, r0, r1)
            if (r1 == 0) goto L_0x01b7
            java.lang.String r1 = "android.permission.READ_CALL_LOG"
            r0.add(r1)
        L_0x01b7:
            java.lang.String r1 = "android.permission.WRITE_CALL_LOG"
            boolean r1 = e(r6, r0, r1)
            if (r1 == 0) goto L_0x01c4
            java.lang.String r1 = "android.permission.WRITE_CALL_LOG"
            r0.add(r1)
        L_0x01c4:
            java.lang.String r1 = "com.android.voicemail.permission.ADD_VOICEMAIL"
            boolean r1 = e(r6, r0, r1)
            if (r1 == 0) goto L_0x01d1
            java.lang.String r1 = "com.android.voicemail.permission.ADD_VOICEMAIL"
            r0.add(r1)
        L_0x01d1:
            java.lang.String r1 = "android.permission.USE_SIP"
            boolean r1 = e(r6, r0, r1)
            if (r1 == 0) goto L_0x01de
            java.lang.String r1 = "android.permission.USE_SIP"
            r0.add(r1)
        L_0x01de:
            r1 = 26
            if (r7 < r1) goto L_0x0262
            java.lang.String r7 = "android.permission.ANSWER_PHONE_CALLS"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
            java.lang.String r6 = "android.permission.ANSWER_PHONE_CALLS"
            goto L_0x00df
        L_0x01ee:
            java.lang.String r7 = "android.permission.RECORD_AUDIO"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
            goto L_0x024c
        L_0x01f7:
            return r1
        L_0x01f8:
            r1 = 4
            if (r7 != r1) goto L_0x020b
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r4) goto L_0x020b
            java.lang.String r7 = "android.permission.ACCESS_BACKGROUND_LOCATION"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
            java.lang.String r6 = "android.permission.ACCESS_BACKGROUND_LOCATION"
            goto L_0x00df
        L_0x020b:
            java.lang.String r7 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r1 = e(r6, r0, r7)
            if (r1 == 0) goto L_0x0216
            r0.add(r7)
        L_0x0216:
            java.lang.String r7 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
            java.lang.String r6 = "android.permission.ACCESS_FINE_LOCATION"
            goto L_0x00df
        L_0x0222:
            java.lang.String r7 = "android.permission.READ_CONTACTS"
            boolean r1 = e(r6, r0, r7)
            if (r1 == 0) goto L_0x022d
            r0.add(r7)
        L_0x022d:
            java.lang.String r7 = "android.permission.WRITE_CONTACTS"
            boolean r1 = e(r6, r0, r7)
            if (r1 == 0) goto L_0x0238
            r0.add(r7)
        L_0x0238:
            java.lang.String r7 = "android.permission.GET_ACCOUNTS"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
            java.lang.String r6 = "android.permission.GET_ACCOUNTS"
            goto L_0x00df
        L_0x0244:
            java.lang.String r7 = "android.permission.CAMERA"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
        L_0x024c:
            r0.add(r7)
            goto L_0x0262
        L_0x0250:
            boolean r7 = e(r6, r0, r3)
            if (r7 == 0) goto L_0x0259
            r0.add(r3)
        L_0x0259:
            java.lang.String r7 = "android.permission.READ_CALENDAR"
            boolean r6 = e(r6, r0, r7)
            if (r6 == 0) goto L_0x0262
            goto L_0x024c
        L_0x0262:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.s.c(android.content.Context, int):java.util.List");
    }

    private static PackageInfo d(Context context) {
        PackageManager packageManager = context.getPackageManager();
        int i5 = Build.VERSION.SDK_INT;
        String packageName = context.getPackageName();
        return i5 >= 33 ? packageManager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(4096)) : packageManager.getPackageInfo(packageName, 4096);
    }

    private static boolean e(Context context, ArrayList<String> arrayList, String str) {
        if (arrayList != null) {
            try {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(str)) {
                        return true;
                    }
                }
            } catch (Exception e5) {
                Log.d("permissions_handler", "Unable to check manifest for permission: ", e5);
            }
        }
        if (context == null) {
            Log.d("permissions_handler", "Unable to detect current Activity or App Context.");
            return false;
        }
        PackageInfo d5 = d(context);
        if (d5 == null) {
            Log.d("permissions_handler", "Unable to get Package info, will not be able to determine permissions to request.");
            return false;
        }
        Iterator it2 = new ArrayList(Arrays.asList(d5.requestedPermissions)).iterator();
        while (it2.hasNext()) {
            if (((String) it2.next()).equals(str)) {
                return true;
            }
        }
        return false;
    }

    static boolean f(Activity activity, String str) {
        return !b.r(activity, str);
    }

    static int g(String str) {
        String str2 = str;
        str.hashCode();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -2062386608:
                if (str2.equals("android.permission.READ_SMS")) {
                    c5 = 0;
                    break;
                }
                break;
            case -1928411001:
                if (str2.equals("android.permission.READ_CALENDAR")) {
                    c5 = 1;
                    break;
                }
                break;
            case -1925850455:
                if (str2.equals("android.permission.POST_NOTIFICATIONS")) {
                    c5 = 2;
                    break;
                }
                break;
            case -1921431796:
                if (str2.equals("android.permission.READ_CALL_LOG")) {
                    c5 = 3;
                    break;
                }
                break;
            case -1888586689:
                if (str2.equals("android.permission.ACCESS_FINE_LOCATION")) {
                    c5 = 4;
                    break;
                }
                break;
            case -1813079487:
                if (str2.equals("android.permission.MANAGE_EXTERNAL_STORAGE")) {
                    c5 = 5;
                    break;
                }
                break;
            case -1783097621:
                if (str2.equals("android.permission.ACCESS_NOTIFICATION_POLICY")) {
                    c5 = 6;
                    break;
                }
                break;
            case -1561629405:
                if (str2.equals("android.permission.SYSTEM_ALERT_WINDOW")) {
                    c5 = 7;
                    break;
                }
                break;
            case -1479758289:
                if (str2.equals("android.permission.RECEIVE_WAP_PUSH")) {
                    c5 = 8;
                    break;
                }
                break;
            case -1238066820:
                if (str2.equals("android.permission.BODY_SENSORS")) {
                    c5 = 9;
                    break;
                }
                break;
            case -1164582768:
                if (str2.equals("android.permission.READ_PHONE_NUMBERS")) {
                    c5 = 10;
                    break;
                }
                break;
            case -909527021:
                if (str2.equals("android.permission.NEARBY_WIFI_DEVICES")) {
                    c5 = 11;
                    break;
                }
                break;
            case -895679497:
                if (str2.equals("android.permission.RECEIVE_MMS")) {
                    c5 = 12;
                    break;
                }
                break;
            case -895673731:
                if (str2.equals("android.permission.RECEIVE_SMS")) {
                    c5 = 13;
                    break;
                }
                break;
            case -798669607:
                if (str2.equals("android.permission.BLUETOOTH_CONNECT")) {
                    c5 = 14;
                    break;
                }
                break;
            case -406040016:
                if (str2.equals("android.permission.READ_EXTERNAL_STORAGE")) {
                    c5 = 15;
                    break;
                }
                break;
            case -63024214:
                if (str2.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                    c5 = 16;
                    break;
                }
                break;
            case -5573545:
                if (str2.equals("android.permission.READ_PHONE_STATE")) {
                    c5 = 17;
                    break;
                }
                break;
            case 52602690:
                if (str2.equals("android.permission.SEND_SMS")) {
                    c5 = 18;
                    break;
                }
                break;
            case 112197485:
                if (str2.equals("android.permission.CALL_PHONE")) {
                    c5 = 19;
                    break;
                }
                break;
            case 175802396:
                if (str2.equals("android.permission.READ_MEDIA_IMAGES")) {
                    c5 = 20;
                    break;
                }
                break;
            case 214526995:
                if (str2.equals("android.permission.WRITE_CONTACTS")) {
                    c5 = 21;
                    break;
                }
                break;
            case 361658321:
                if (str2.equals("android.permission.BODY_SENSORS_BACKGROUND")) {
                    c5 = 22;
                    break;
                }
                break;
            case 463403621:
                if (str2.equals("android.permission.CAMERA")) {
                    c5 = 23;
                    break;
                }
                break;
            case 603653886:
                if (str2.equals("android.permission.WRITE_CALENDAR")) {
                    c5 = 24;
                    break;
                }
                break;
            case 610633091:
                if (str2.equals("android.permission.WRITE_CALL_LOG")) {
                    c5 = 25;
                    break;
                }
                break;
            case 691260818:
                if (str2.equals("android.permission.READ_MEDIA_AUDIO")) {
                    c5 = 26;
                    break;
                }
                break;
            case 710297143:
                if (str2.equals("android.permission.READ_MEDIA_VIDEO")) {
                    c5 = 27;
                    break;
                }
                break;
            case 784519842:
                if (str2.equals("android.permission.USE_SIP")) {
                    c5 = 28;
                    break;
                }
                break;
            case 970694249:
                if (str2.equals("android.permission.SCHEDULE_EXACT_ALARM")) {
                    c5 = 29;
                    break;
                }
                break;
            case 1166454870:
                if (str2.equals("android.permission.BLUETOOTH_ADVERTISE")) {
                    c5 = 30;
                    break;
                }
                break;
            case 1271781903:
                if (str2.equals("android.permission.GET_ACCOUNTS")) {
                    c5 = 31;
                    break;
                }
                break;
            case 1365911975:
                if (str2.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    c5 = ' ';
                    break;
                }
                break;
            case 1777263169:
                if (str2.equals("android.permission.REQUEST_INSTALL_PACKAGES")) {
                    c5 = '!';
                    break;
                }
                break;
            case 1780337063:
                if (str2.equals("android.permission.ACTIVITY_RECOGNITION")) {
                    c5 = '\"';
                    break;
                }
                break;
            case 1831139720:
                if (str2.equals("android.permission.RECORD_AUDIO")) {
                    c5 = '#';
                    break;
                }
                break;
            case 1977429404:
                if (str2.equals("android.permission.READ_CONTACTS")) {
                    c5 = '$';
                    break;
                }
                break;
            case 2024715147:
                if (str2.equals("android.permission.ACCESS_BACKGROUND_LOCATION")) {
                    c5 = '%';
                    break;
                }
                break;
            case 2062356686:
                if (str2.equals("android.permission.BLUETOOTH_SCAN")) {
                    c5 = '&';
                    break;
                }
                break;
            case 2114579147:
                if (str2.equals("android.permission.ACCESS_MEDIA_LOCATION")) {
                    c5 = '\'';
                    break;
                }
                break;
            case 2133799037:
                if (str2.equals("com.android.voicemail.permission.ADD_VOICEMAIL")) {
                    c5 = '(';
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
            case 8:
            case 12:
            case 13:
            case 18:
                return 13;
            case 1:
            case 24:
                return 0;
            case 2:
                return 17;
            case 3:
            case 10:
            case 17:
            case 19:
            case 25:
            case 28:
            case R.styleable.AppCompatTheme_borderlessButtonStyle:
                return 8;
            case 4:
            case 16:
                return 3;
            case 5:
                return 22;
            case 6:
                return 27;
            case 7:
                return 23;
            case 9:
                return 12;
            case 11:
                return 31;
            case 14:
                return 30;
            case 15:
            case R.styleable.AppCompatTheme_actionOverflowButtonStyle:
                return 15;
            case 20:
                return 9;
            case 21:
            case R.styleable.AppCompatTheme_actionModeWebSearchDrawable:
            case R.styleable.AppCompatTheme_alertDialogCenterButtons:
                return 2;
            case 22:
                return 35;
            case 23:
                return 1;
            case 26:
                return 33;
            case 27:
                return 32;
            case 29:
                return 34;
            case R.styleable.AppCompatTheme_actionModeTheme:
                return 29;
            case R.styleable.AppCompatTheme_actionOverflowMenuStyle:
                return 24;
            case R.styleable.AppCompatTheme_activityChooserViewStyle:
                return 19;
            case R.styleable.AppCompatTheme_alertDialogButtonGroupStyle:
                return 7;
            case R.styleable.AppCompatTheme_alertDialogStyle:
                return 4;
            case R.styleable.AppCompatTheme_alertDialogTheme:
                return 28;
            case R.styleable.AppCompatTheme_autoCompleteTextViewStyle:
                return 18;
            default:
                return 20;
        }
    }

    private static void h(Context context, String str) {
        context.getSharedPreferences(str, 0).edit().putBoolean("sp_permission_handler_permission_was_denied_before", true).apply();
    }

    static Integer i(Integer num, Integer num2) {
        HashSet hashSet = new HashSet();
        hashSet.add(num);
        hashSet.add(num2);
        return j(hashSet);
    }

    static Integer j(Collection<Integer> collection) {
        if (collection.contains(4)) {
            return 4;
        }
        if (collection.contains(2)) {
            return 2;
        }
        if (collection.contains(0)) {
            return 0;
        }
        return collection.contains(3) ? 3 : 1;
    }

    static int k(Activity activity, String str, int i5) {
        if (i5 == -1) {
            return b(activity, str);
        }
        return 1;
    }

    private static boolean l(Context context, String str) {
        return context.getSharedPreferences(str, 0).getBoolean("sp_permission_handler_permission_was_denied_before", false);
    }
}
