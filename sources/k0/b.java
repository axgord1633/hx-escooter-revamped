package k0;

import android.location.Address;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class b {
    private static Map<String, Object> a(Address address) {
        HashMap hashMap = new HashMap();
        String a5 = a.a(address.getAddressLine(0));
        hashMap.put("name", address.getFeatureName());
        hashMap.put("street", a5);
        hashMap.put("isoCountryCode", address.getCountryCode());
        hashMap.put("country", address.getCountryName());
        hashMap.put("thoroughfare", address.getThoroughfare());
        hashMap.put("subThoroughfare", address.getSubThoroughfare());
        hashMap.put("postalCode", address.getPostalCode());
        hashMap.put("administrativeArea", address.getAdminArea());
        hashMap.put("subAdministrativeArea", address.getSubAdminArea());
        hashMap.put("locality", address.getLocality());
        hashMap.put("subLocality", address.getSubLocality());
        return hashMap;
    }

    public static List<Map<String, Object>> b(List<Address> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Address a5 : list) {
            arrayList.add(a(a5));
        }
        return arrayList;
    }

    public static List<Map<String, Object>> c(List<Address> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Address d5 : list) {
            arrayList.add(d(d5));
        }
        return arrayList;
    }

    private static Map<String, Object> d(Address address) {
        HashMap hashMap = new HashMap();
        hashMap.put("latitude", Double.valueOf(address.getLatitude()));
        hashMap.put("longitude", Double.valueOf(address.getLongitude()));
        hashMap.put("timestamp", Long.valueOf(Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis()));
        return hashMap;
    }
}
