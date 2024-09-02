package v0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class q extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    Context f7155a;

    /* renamed from: b  reason: collision with root package name */
    private final p f7156b;

    public q(p pVar) {
        this.f7156b = pVar;
    }

    public final void a(Context context) {
        this.f7155a = context;
    }

    public final synchronized void b() {
        Context context = this.f7155a;
        if (context != null) {
            context.unregisterReceiver(this);
        }
        this.f7155a = null;
    }

    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f7156b.a();
            b();
        }
    }
}
