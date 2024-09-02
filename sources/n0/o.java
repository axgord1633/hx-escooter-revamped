package n0;

import android.content.Context;
import android.location.LocationManager;

public final /* synthetic */ class o {
    public static boolean a(p pVar, Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
    }
}
