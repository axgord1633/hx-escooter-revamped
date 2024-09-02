package n0;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import androidx.core.location.b;
import androidx.core.location.c;
import androidx.core.location.m;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;

class q implements p, b {

    /* renamed from: a  reason: collision with root package name */
    private final LocationManager f6046a;

    /* renamed from: b  reason: collision with root package name */
    private final f0 f6047b;

    /* renamed from: c  reason: collision with root package name */
    private final z f6048c;

    /* renamed from: d  reason: collision with root package name */
    public Context f6049d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6050e = false;

    /* renamed from: f  reason: collision with root package name */
    private Location f6051f;

    /* renamed from: g  reason: collision with root package name */
    private String f6052g;

    /* renamed from: h  reason: collision with root package name */
    private g0 f6053h;

    /* renamed from: i  reason: collision with root package name */
    private m0.a f6054i;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6055a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                n0.l[] r0 = n0.l.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6055a = r0
                n0.l r1 = n0.l.lowest     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f6055a     // Catch:{ NoSuchFieldError -> 0x001d }
                n0.l r1 = n0.l.low     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f6055a     // Catch:{ NoSuchFieldError -> 0x0028 }
                n0.l r1 = n0.l.high     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f6055a     // Catch:{ NoSuchFieldError -> 0x0033 }
                n0.l r1 = n0.l.best     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f6055a     // Catch:{ NoSuchFieldError -> 0x003e }
                n0.l r1 = n0.l.bestForNavigation     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f6055a     // Catch:{ NoSuchFieldError -> 0x0049 }
                n0.l r1 = n0.l.medium     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: n0.q.a.<clinit>():void");
        }
    }

    public q(Context context, z zVar) {
        this.f6046a = (LocationManager) context.getSystemService("location");
        this.f6048c = zVar;
        this.f6049d = context;
        this.f6047b = new f0(context, zVar);
    }

    private static int f(l lVar) {
        int i5 = a.f6055a[lVar.ordinal()];
        if (i5 == 1 || i5 == 2) {
            return R.styleable.AppCompatTheme_textAppearanceListItemSecondary;
        }
        if (i5 == 3 || i5 == 4 || i5 == 5) {
            return 100;
        }
        return R.styleable.AppCompatTheme_textAppearanceLargePopupMenu;
    }

    private static String h(LocationManager locationManager, l lVar) {
        List<String> providers = locationManager.getProviders(true);
        if (lVar == l.lowest) {
            return "passive";
        }
        if (providers.contains("fused") && Build.VERSION.SDK_INT >= 31) {
            return "fused";
        }
        if (providers.contains("gps")) {
            return "gps";
        }
        if (providers.contains("network")) {
            return "network";
        }
        if (!providers.isEmpty()) {
            return providers.get(0);
        }
        return null;
    }

    static boolean i(Location location, Location location2) {
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        boolean z4 = time > 120000;
        boolean z5 = time < -120000;
        boolean z6 = time > 0;
        if (z4) {
            return true;
        }
        if (z5) {
            return false;
        }
        float accuracy = (float) ((int) (location.getAccuracy() - location2.getAccuracy()));
        boolean z7 = accuracy > CropImageView.DEFAULT_ASPECT_RATIO;
        boolean z8 = accuracy < CropImageView.DEFAULT_ASPECT_RATIO;
        boolean z9 = accuracy > 200.0f;
        boolean equals = location.getProvider() != null ? location.getProvider().equals(location2.getProvider()) : false;
        if (z8) {
            return true;
        }
        if (!z6 || z7) {
            return z6 && !z9 && equals;
        }
        return true;
    }

    public boolean a(int i5, int i6) {
        return false;
    }

    public void b(a0 a0Var) {
        a0Var.b(this.f6046a == null ? false : g(this.f6049d));
    }

    public void c(g0 g0Var, m0.a aVar) {
        Location location = null;
        for (String lastKnownLocation : this.f6046a.getProviders(true)) {
            Location lastKnownLocation2 = this.f6046a.getLastKnownLocation(lastKnownLocation);
            if (lastKnownLocation2 != null && i(lastKnownLocation2, location)) {
                location = lastKnownLocation2;
            }
        }
        g0Var.a(location);
    }

    public void d() {
        this.f6050e = false;
        this.f6047b.e();
        this.f6046a.removeUpdates(this);
    }

    public void e(Activity activity, g0 g0Var, m0.a aVar) {
        if (!g(this.f6049d)) {
            aVar.a(m0.b.locationServicesDisabled);
            return;
        }
        this.f6053h = g0Var;
        this.f6054i = aVar;
        l lVar = l.best;
        long j5 = 0;
        float f5 = CropImageView.DEFAULT_ASPECT_RATIO;
        int i5 = R.styleable.AppCompatTheme_textAppearanceLargePopupMenu;
        z zVar = this.f6048c;
        if (zVar != null) {
            f5 = (float) zVar.b();
            lVar = this.f6048c.a();
            j5 = lVar == l.lowest ? Long.MAX_VALUE : this.f6048c.c();
            i5 = f(lVar);
        }
        String h5 = h(this.f6046a, lVar);
        this.f6052g = h5;
        if (h5 == null) {
            aVar.a(m0.b.locationServicesDisabled);
            return;
        }
        m a5 = new m.c(j5).c(f5).d(i5).a();
        this.f6050e = true;
        this.f6047b.d();
        c.b(this.f6046a, this.f6052g, a5, this, Looper.getMainLooper());
    }

    public /* synthetic */ boolean g(Context context) {
        return o.a(this, context);
    }

    public /* synthetic */ void onFlushComplete(int i5) {
        androidx.core.location.a.a(this, i5);
    }

    public synchronized void onLocationChanged(Location location) {
        if (i(location, this.f6051f)) {
            this.f6051f = location;
            if (this.f6053h != null) {
                this.f6047b.b(location);
                this.f6053h.a(this.f6051f);
            }
        }
    }

    public /* synthetic */ void onLocationChanged(List list) {
        androidx.core.location.a.b(this, list);
    }

    public void onProviderDisabled(String str) {
        if (str.equals(this.f6052g)) {
            if (this.f6050e) {
                this.f6046a.removeUpdates(this);
            }
            m0.a aVar = this.f6054i;
            if (aVar != null) {
                aVar.a(m0.b.locationServicesDisabled);
            }
            this.f6052g = null;
        }
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i5, Bundle bundle) {
        if (i5 == 2) {
            onProviderEnabled(str);
        } else if (i5 == 0) {
            onProviderDisabled(str);
        }
    }
}
