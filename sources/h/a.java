package h;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import d.b;
import d.d;
import d.j;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f4770a;

    private a(Context context) {
        this.f4770a = context;
    }

    public static a b(Context context) {
        return new a(context);
    }

    public boolean a() {
        return this.f4770a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int c() {
        return this.f4770a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int d() {
        Configuration configuration = this.f4770a.getResources().getConfiguration();
        int i5 = configuration.screenWidthDp;
        int i6 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i5 > 600) {
            return 5;
        }
        if (i5 > 960 && i6 > 720) {
            return 5;
        }
        if (i5 > 720 && i6 > 960) {
            return 5;
        }
        if (i5 >= 500) {
            return 4;
        }
        if (i5 > 640 && i6 > 480) {
            return 4;
        }
        if (i5 <= 480 || i6 <= 640) {
            return i5 >= 360 ? 3 : 2;
        }
        return 4;
    }

    public int e() {
        return this.f4770a.getResources().getDimensionPixelSize(d.f3998b);
    }

    public int f() {
        TypedArray obtainStyledAttributes = this.f4770a.obtainStyledAttributes((AttributeSet) null, j.f4100a, d.a.f3964c, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(j.f4145j, 0);
        Resources resources = this.f4770a.getResources();
        if (!g()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(d.f3997a));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean g() {
        return this.f4770a.getResources().getBoolean(b.f3988a);
    }

    public boolean h() {
        return true;
    }
}
