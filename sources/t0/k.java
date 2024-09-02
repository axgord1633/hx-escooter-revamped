package t0;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class k extends e1.k {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6833a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d f6834b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(d dVar, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f6834b = dVar;
        this.f6833a = context.getApplicationContext();
    }

    public final void handleMessage(Message message) {
        int i5 = message.what;
        if (i5 != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i5);
            return;
        }
        int e5 = this.f6834b.e(this.f6833a);
        if (this.f6834b.h(e5)) {
            this.f6834b.m(this.f6833a, e5);
        }
    }
}
