package v0;

import android.os.IBinder;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ g f7158e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ IBinder f7159f;

    public /* synthetic */ t(g gVar, IBinder iBinder) {
        this.f7158e = gVar;
        this.f7159f = iBinder;
    }

    public final void run() {
        this.f7158e.q(this.f7159f);
    }
}
