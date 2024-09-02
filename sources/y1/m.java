package y1;

import android.content.ContentResolver;
import android.location.LocationManager;
import g0.c;
import h0.a;

public final class m implements c<l> {

    /* renamed from: a  reason: collision with root package name */
    private final a<ContentResolver> f7760a;

    /* renamed from: b  reason: collision with root package name */
    private final a<LocationManager> f7761b;

    public m(a<ContentResolver> aVar, a<LocationManager> aVar2) {
        this.f7760a = aVar;
        this.f7761b = aVar2;
    }

    public static m a(a<ContentResolver> aVar, a<LocationManager> aVar2) {
        return new m(aVar, aVar2);
    }

    public static l c(ContentResolver contentResolver, LocationManager locationManager) {
        return new l(contentResolver, locationManager);
    }

    /* renamed from: b */
    public l get() {
        return c(this.f7760a.get(), this.f7761b.get());
    }
}
