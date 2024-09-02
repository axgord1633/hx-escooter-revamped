package d2;

import android.os.Handler;
import android.os.HandlerThread;

class s implements o {

    /* renamed from: a  reason: collision with root package name */
    final String f4309a;

    /* renamed from: b  reason: collision with root package name */
    final int f4310b;

    /* renamed from: c  reason: collision with root package name */
    private HandlerThread f4311c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f4312d;

    s(String str, int i5) {
        this.f4309a = str;
        this.f4310b = i5;
    }

    public /* synthetic */ void a(i iVar, Runnable runnable) {
        n.a(this, iVar, runnable);
    }

    public void b() {
        HandlerThread handlerThread = this.f4311c;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f4311c = null;
            this.f4312d = null;
        }
    }

    public void c(k kVar) {
        this.f4312d.post(kVar.f4289b);
    }

    public void start() {
        HandlerThread handlerThread = new HandlerThread(this.f4309a, this.f4310b);
        this.f4311c = handlerThread;
        handlerThread.start();
        this.f4312d = new Handler(this.f4311c.getLooper());
    }
}
