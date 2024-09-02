package n0;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.j0;
import androidx.core.app.l;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5993a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f5994b;

    /* renamed from: c  reason: collision with root package name */
    private final String f5995c;

    /* renamed from: d  reason: collision with root package name */
    private l.d f5996d;

    public b(Context context, String str, Integer num, d dVar) {
        this.f5993a = context;
        this.f5994b = num;
        this.f5995c = str;
        this.f5996d = new l.d(context, str).m(1);
        e(dVar, false);
    }

    private PendingIntent b() {
        Intent launchIntentForPackage = this.f5993a.getPackageManager().getLaunchIntentForPackage(this.f5993a.getPackageName());
        if (launchIntentForPackage == null) {
            return null;
        }
        launchIntentForPackage.setPackage((String) null);
        launchIntentForPackage.setFlags(270532608);
        int i5 = 134217728;
        if (Build.VERSION.SDK_INT > 23) {
            i5 = 201326592;
        }
        return PendingIntent.getActivity(this.f5993a, 0, launchIntentForPackage, i5);
    }

    private int c(String str, String str2) {
        return this.f5993a.getResources().getIdentifier(str, str2, this.f5993a.getPackageName());
    }

    private void e(d dVar, boolean z4) {
        int c5 = c(dVar.a().b(), dVar.a().a());
        if (c5 == 0) {
            c("ic_launcher.png", "mipmap");
        }
        this.f5996d = this.f5996d.i(dVar.c()).n(c5).h(dVar.b()).g(b()).l(dVar.f());
        if (z4) {
            j0.c(this.f5993a).e(this.f5994b.intValue(), this.f5996d.b());
        }
    }

    public Notification a() {
        return this.f5996d.b();
    }

    public void d(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            j0 c5 = j0.c(this.f5993a);
            NotificationChannel notificationChannel = new NotificationChannel(this.f5995c, str, 0);
            notificationChannel.setLockscreenVisibility(0);
            c5.b(notificationChannel);
        }
    }

    public void f(d dVar, boolean z4) {
        e(dVar, z4);
    }
}
