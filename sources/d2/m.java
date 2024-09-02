package d2;

import android.os.Handler;
import android.os.HandlerThread;

class m {

    /* renamed from: a  reason: collision with root package name */
    private final String f4292a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4293b;

    /* renamed from: c  reason: collision with root package name */
    private HandlerThread f4294c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f4295d;

    /* renamed from: e  reason: collision with root package name */
    protected Runnable f4296e;

    /* renamed from: f  reason: collision with root package name */
    private k f4297f;

    m(String str, int i5) {
        this.f4292a = str;
        this.f4293b = i5;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        k kVar = this.f4297f;
        return kVar != null && kVar.b();
    }

    /* access modifiers changed from: package-private */
    public Integer d() {
        k kVar = this.f4297f;
        if (kVar != null) {
            return kVar.a();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void e(k kVar) {
        this.f4295d.post(new l(this, kVar));
    }

    /* access modifiers changed from: package-private */
    public synchronized void f() {
        HandlerThread handlerThread = this.f4294c;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f4294c = null;
            this.f4295d = null;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void g(Runnable runnable) {
        HandlerThread handlerThread = new HandlerThread(this.f4292a, this.f4293b);
        this.f4294c = handlerThread;
        handlerThread.start();
        this.f4295d = new Handler(this.f4294c.getLooper());
        this.f4296e = runnable;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void c(k kVar) {
        kVar.f4289b.run();
        this.f4297f = kVar;
        this.f4296e.run();
    }
}
