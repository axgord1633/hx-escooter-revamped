package j0;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import java.util.List;
import java.util.Locale;

class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5427a;

    a(Context context) {
        this.f5427a = context;
    }

    private static Geocoder a(Context context, Locale locale) {
        Geocoder geocoder;
        if (locale == null) {
            geocoder = new Geocoder(context);
        }
        return geocoder;
    }

    /* access modifiers changed from: package-private */
    public List<Address> b(String str, Locale locale) {
        return a(this.f5427a, locale).getFromLocationName(str, 5);
    }

    /* access modifiers changed from: package-private */
    public List<Address> c(double d5, double d6, Locale locale) {
        return a(this.f5427a, locale).getFromLocation(d5, d6, 5);
    }
}
