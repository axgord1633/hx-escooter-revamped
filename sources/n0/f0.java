package n0;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import java.util.Calendar;

public class f0 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6009a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationManager f6010b;

    /* renamed from: c  reason: collision with root package name */
    private final z f6011c;

    /* renamed from: d  reason: collision with root package name */
    private OnNmeaMessageListener f6012d;

    /* renamed from: e  reason: collision with root package name */
    private String f6013e;

    /* renamed from: f  reason: collision with root package name */
    private Calendar f6014f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6015g = false;

    public f0(Context context, z zVar) {
        this.f6009a = context;
        this.f6011c = zVar;
        this.f6010b = (LocationManager) context.getSystemService("location");
        if (Build.VERSION.SDK_INT >= 24) {
            this.f6012d = new e0(this);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(String str, long j5) {
        if (str.startsWith("$GPGGA")) {
            this.f6013e = str;
            this.f6014f = Calendar.getInstance();
        }
    }

    public void b(Location location) {
        if (location != null && this.f6013e != null && this.f6011c != null && this.f6015g) {
            Calendar instance = Calendar.getInstance();
            instance.add(13, -5);
            Calendar calendar = this.f6014f;
            if ((calendar == null || !calendar.before(instance)) && this.f6011c.d()) {
                String[] split = this.f6013e.split(",");
                if (split[0].startsWith("$GPGGA") && split.length > 9 && !split[9].isEmpty()) {
                    double parseDouble = Double.parseDouble(split[9]);
                    if (location.getExtras() == null) {
                        location.setExtras(Bundle.EMPTY);
                    }
                    location.getExtras().putDouble("geolocator_mslAltitude", parseDouble);
                }
            }
        }
    }

    public void d() {
        z zVar;
        LocationManager locationManager;
        if (!this.f6015g && (zVar = this.f6011c) != null && zVar.d() && Build.VERSION.SDK_INT >= 24 && (locationManager = this.f6010b) != null) {
            boolean unused = locationManager.addNmeaListener(this.f6012d, (Handler) null);
            this.f6015g = true;
        }
    }

    public void e() {
        LocationManager locationManager;
        z zVar = this.f6011c;
        if (zVar != null && zVar.d() && Build.VERSION.SDK_INT >= 24 && (locationManager = this.f6010b) != null) {
            locationManager.removeNmeaListener(this.f6012d);
            this.f6015g = false;
        }
    }
}
