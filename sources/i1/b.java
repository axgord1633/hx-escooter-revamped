package i1;

import android.location.Location;
import android.os.Looper;
import com.google.android.gms.location.LocationRequest;
import l1.g;

public interface b {
    g<Location> b();

    g<Void> d(e eVar);

    g<Void> e(LocationRequest locationRequest, e eVar, Looper looper);
}
