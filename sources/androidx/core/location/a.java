package androidx.core.location;

import android.location.Location;
import java.util.List;

public final /* synthetic */ class a {
    public static void a(b bVar, int i5) {
    }

    public static void b(b bVar, List list) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            bVar.onLocationChanged((Location) list.get(i5));
        }
    }
}
