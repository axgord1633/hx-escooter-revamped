package c;

import android.content.Context;
import android.content.Intent;
import c.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import m3.j;
import m3.n;

public final class e extends a<String[], Map<String, Boolean>> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f3073a = new a((g) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final Intent a(String[] strArr) {
            k.e(strArr, "input");
            Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
            k.d(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
            return putExtra;
        }
    }

    /* renamed from: d */
    public Intent a(Context context, String[] strArr) {
        k.e(context, "context");
        k.e(strArr, "input");
        return f3073a.a(strArr);
    }

    /* renamed from: e */
    public a.C0056a<Map<String, Boolean>> b(Context context, String[] strArr) {
        k.e(context, "context");
        k.e(strArr, "input");
        boolean z4 = true;
        if (strArr.length == 0) {
            return new a.C0056a<>(e0.d());
        }
        int length = strArr.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                break;
            }
            if (!(androidx.core.content.a.a(context, strArr[i5]) == 0)) {
                z4 = false;
                break;
            }
            i5++;
        }
        if (!z4) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.a(d0.a(strArr.length), 16));
        for (String a5 : strArr) {
            j a6 = n.a(a5, Boolean.TRUE);
            linkedHashMap.put(a6.e(), a6.f());
        }
        return new a.C0056a<>(linkedHashMap);
    }

    /* renamed from: f */
    public Map<String, Boolean> c(int i5, Intent intent) {
        if (i5 != -1) {
            return e0.d();
        }
        if (intent == null) {
            return e0.d();
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (intArrayExtra == null || stringArrayExtra == null) {
            return e0.d();
        }
        ArrayList arrayList = new ArrayList(intArrayExtra.length);
        int length = intArrayExtra.length;
        for (int i6 = 0; i6 < length; i6++) {
            arrayList.add(Boolean.valueOf(intArrayExtra[i6] == 0));
        }
        return e0.i(v.z(j.j(stringArrayExtra), arrayList));
    }
}
