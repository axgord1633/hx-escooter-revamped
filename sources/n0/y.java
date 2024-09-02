package n0;

import android.location.Location;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;

public class y {
    private static boolean a(Location location) {
        return Build.VERSION.SDK_INT >= 31 ? location.isMock() : location.isFromMockProvider();
    }

    public static Map<String, Object> b(Location location) {
        if (location == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("latitude", Double.valueOf(location.getLatitude()));
        hashMap.put("longitude", Double.valueOf(location.getLongitude()));
        hashMap.put("timestamp", Long.valueOf(location.getTime()));
        hashMap.put("is_mocked", Boolean.valueOf(a(location)));
        if (location.hasAltitude()) {
            hashMap.put("altitude", Double.valueOf(location.getAltitude()));
        }
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 26 && location.hasVerticalAccuracy()) {
            hashMap.put("altitude_accuracy", Float.valueOf(location.getVerticalAccuracyMeters()));
        }
        if (location.hasAccuracy()) {
            hashMap.put("accuracy", Double.valueOf((double) location.getAccuracy()));
        }
        if (location.hasBearing()) {
            hashMap.put("heading", Double.valueOf((double) location.getBearing()));
        }
        if (i5 >= 26 && location.hasBearingAccuracy()) {
            hashMap.put("heading_accuracy", Float.valueOf(location.getBearingAccuracyDegrees()));
        }
        if (location.hasSpeed()) {
            hashMap.put("speed", Double.valueOf((double) location.getSpeed()));
        }
        if (i5 >= 26 && location.hasSpeedAccuracy()) {
            hashMap.put("speed_accuracy", Double.valueOf((double) location.getSpeedAccuracyMetersPerSecond()));
        }
        if (location.getExtras() != null && location.getExtras().containsKey("geolocator_mslAltitude")) {
            hashMap.put("altitude", Double.valueOf(location.getExtras().getDouble("geolocator_mslAltitude")));
        }
        return hashMap;
    }
}
