package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f1513a = (IconCompat) aVar.v(remoteActionCompat.f1513a, 1);
        remoteActionCompat.f1514b = aVar.l(remoteActionCompat.f1514b, 2);
        remoteActionCompat.f1515c = aVar.l(remoteActionCompat.f1515c, 3);
        remoteActionCompat.f1516d = (PendingIntent) aVar.r(remoteActionCompat.f1516d, 4);
        remoteActionCompat.f1517e = aVar.h(remoteActionCompat.f1517e, 5);
        remoteActionCompat.f1518f = aVar.h(remoteActionCompat.f1518f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f1513a, 1);
        aVar.D(remoteActionCompat.f1514b, 2);
        aVar.D(remoteActionCompat.f1515c, 3);
        aVar.H(remoteActionCompat.f1516d, 4);
        aVar.z(remoteActionCompat.f1517e, 5);
        aVar.z(remoteActionCompat.f1518f, 6);
    }
}
