package androidx.core.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import java.util.List;

public interface b extends LocationListener {
    void onFlushComplete(int i5);

    void onLocationChanged(List<Location> list);

    void onProviderDisabled(String str);

    void onProviderEnabled(String str);

    void onStatusChanged(String str, int i5, Bundle bundle);
}
