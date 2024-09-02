package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.d;
import java.util.Calendar;

class p {

    /* renamed from: d  reason: collision with root package name */
    private static p f734d;

    /* renamed from: a  reason: collision with root package name */
    private final Context f735a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationManager f736b;

    /* renamed from: c  reason: collision with root package name */
    private final a f737c = new a();

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f738a;

        /* renamed from: b  reason: collision with root package name */
        long f739b;

        /* renamed from: c  reason: collision with root package name */
        long f740c;

        /* renamed from: d  reason: collision with root package name */
        long f741d;

        /* renamed from: e  reason: collision with root package name */
        long f742e;

        /* renamed from: f  reason: collision with root package name */
        long f743f;

        a() {
        }
    }

    p(Context context, LocationManager locationManager) {
        this.f735a = context;
        this.f736b = locationManager;
    }

    static p a(Context context) {
        if (f734d == null) {
            Context applicationContext = context.getApplicationContext();
            f734d = new p(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f734d;
    }

    private Location b() {
        Location location = null;
        Location c5 = d.b(this.f735a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        if (d.b(this.f735a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = c("gps");
        }
        return (location == null || c5 == null) ? location != null ? location : c5 : location.getTime() > c5.getTime() ? location : c5;
    }

    private Location c(String str) {
        try {
            if (this.f736b.isProviderEnabled(str)) {
                return this.f736b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e5) {
            Log.d("TwilightManager", "Failed to get last known location", e5);
            return null;
        }
    }

    private boolean e() {
        return this.f737c.f743f > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j5;
        a aVar = this.f737c;
        long currentTimeMillis = System.currentTimeMillis();
        o b5 = o.b();
        o oVar = b5;
        oVar.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j6 = b5.f731a;
        oVar.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z4 = true;
        if (b5.f733c != 1) {
            z4 = false;
        }
        long j7 = b5.f732b;
        long j8 = j6;
        long j9 = b5.f731a;
        long j10 = j7;
        boolean z5 = z4;
        b5.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j11 = b5.f732b;
        if (j10 == -1 || j9 == -1) {
            j5 = 43200000 + currentTimeMillis;
        } else {
            j5 = (currentTimeMillis > j9 ? 0 + j11 : currentTimeMillis > j10 ? 0 + j9 : 0 + j10) + 60000;
        }
        aVar.f738a = z5;
        aVar.f739b = j8;
        aVar.f740c = j10;
        aVar.f741d = j9;
        aVar.f742e = j11;
        aVar.f743f = j5;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        a aVar = this.f737c;
        if (e()) {
            return aVar.f738a;
        }
        Location b5 = b();
        if (b5 != null) {
            f(b5);
            return aVar.f738a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i5 = Calendar.getInstance().get(11);
        return i5 < 6 || i5 >= 22;
    }
}
