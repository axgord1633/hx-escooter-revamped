package y1;

import android.content.ContentResolver;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import r1.q;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private final ContentResolver f7758a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationManager f7759b;

    l(ContentResolver contentResolver, LocationManager locationManager) {
        this.f7758a = contentResolver;
        this.f7759b = locationManager;
    }

    private boolean b() {
        return this.f7759b.isProviderEnabled("network") || this.f7759b.isProviderEnabled("gps");
    }

    private boolean c() {
        try {
            return Settings.Secure.getInt(this.f7758a, "location_mode") != 0;
        } catch (Settings.SettingNotFoundException e5) {
            q.r(e5, "Could not use LOCATION_MODE check. Falling back to a legacy/heuristic function.", new Object[0]);
            return b();
        }
    }

    public boolean a() {
        return Build.VERSION.SDK_INT >= 28 ? this.f7759b.isLocationEnabled() : c();
    }
}
