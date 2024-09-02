package o0;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.yalantis.ucrop.R;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import m0.a;
import m0.c;

public class b implements PluginRegistry.RequestPermissionsResultListener {

    /* renamed from: e  reason: collision with root package name */
    private Activity f6113e;

    /* renamed from: f  reason: collision with root package name */
    private a f6114f;

    /* renamed from: g  reason: collision with root package name */
    private c f6115g;

    private static List<String> b(Context context) {
        boolean b5 = d.b(context, "android.permission.ACCESS_FINE_LOCATION");
        boolean b6 = d.b(context, "android.permission.ACCESS_COARSE_LOCATION");
        if (b5 || b6) {
            ArrayList arrayList = new ArrayList();
            if (b5) {
                arrayList.add("android.permission.ACCESS_FINE_LOCATION");
            }
            if (b6) {
                arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
            }
            return arrayList;
        }
        throw new c();
    }

    private boolean c(String[] strArr, int[] iArr) {
        int e5 = e(strArr, "android.permission.ACCESS_BACKGROUND_LOCATION");
        return e5 >= 0 && iArr[e5] == 0;
    }

    private static <T> int e(T[] tArr, T t5) {
        return Arrays.asList(tArr).indexOf(t5);
    }

    public a a(Context context) {
        boolean z4;
        Iterator<String> it = b(context).iterator();
        while (true) {
            if (it.hasNext()) {
                if (androidx.core.content.a.a(context, it.next()) == 0) {
                    z4 = false;
                    break;
                }
            } else {
                z4 = true;
                break;
            }
        }
        return z4 ? a.denied : Build.VERSION.SDK_INT < 29 ? a.always : !d.b(context, "android.permission.ACCESS_BACKGROUND_LOCATION") ? a.whileInUse : androidx.core.content.a.a(context, "android.permission.ACCESS_BACKGROUND_LOCATION") == 0 ? a.always : a.whileInUse;
    }

    public boolean d(Context context) {
        a a5 = a(context);
        return a5 == a.whileInUse || a5 == a.always;
    }

    public void f(Activity activity, c cVar, a aVar) {
        if (activity == null) {
            aVar.a(m0.b.activityMissing);
            return;
        }
        int i5 = Build.VERSION.SDK_INT;
        List<String> b5 = b(activity);
        if (i5 >= 29 && d.b(activity, "android.permission.ACCESS_BACKGROUND_LOCATION") && a(activity) == a.whileInUse) {
            b5.add("android.permission.ACCESS_BACKGROUND_LOCATION");
        }
        this.f6114f = aVar;
        this.f6115g = cVar;
        this.f6113e = activity;
        androidx.core.app.b.o(activity, (String[]) b5.toArray(new String[0]), R.styleable.AppCompatTheme_textAppearanceSmallPopupMenu);
    }

    public boolean onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        if (i5 != 109) {
            return false;
        }
        Activity activity = this.f6113e;
        if (activity == null) {
            Log.e("Geolocator", "Trying to process permission result without an valid Activity instance");
            a aVar = this.f6114f;
            if (aVar != null) {
                aVar.a(m0.b.activityMissing);
            }
            return false;
        }
        try {
            List<String> b5 = b(activity);
            if (iArr.length == 0) {
                Log.i("Geolocator", "The grantResults array is empty. This can happen when the user cancels the permission request");
                return false;
            }
            a aVar2 = a.denied;
            char c5 = 65535;
            boolean z4 = false;
            boolean z5 = false;
            for (String next : b5) {
                int e5 = e(strArr, next);
                if (e5 >= 0) {
                    z4 = true;
                }
                if (iArr[e5] == 0) {
                    c5 = 0;
                }
                if (androidx.core.app.b.r(this.f6113e, next)) {
                    z5 = true;
                }
            }
            if (!z4) {
                Log.w("Geolocator", "Location permissions not part of permissions send to onRequestPermissionsResult method.");
                return false;
            }
            if (c5 == 0) {
                aVar2 = (Build.VERSION.SDK_INT < 29 || c(strArr, iArr)) ? a.always : a.whileInUse;
            } else if (!z5) {
                aVar2 = a.deniedForever;
            }
            c cVar = this.f6115g;
            if (cVar != null) {
                cVar.a(aVar2);
            }
            return true;
        } catch (c unused) {
            a aVar3 = this.f6114f;
            if (aVar3 != null) {
                aVar3.a(m0.b.permissionDefinitionsNotFound);
            }
            return false;
        }
    }
}
