package l1;

import w0.p;

final class n implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ g f5709e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ o f5710f;

    n(o oVar, g gVar) {
        this.f5710f = oVar;
        this.f5709e = gVar;
    }

    public final void run() {
        synchronized (this.f5710f.f5712b) {
            o oVar = this.f5710f;
            if (oVar.f5713c != null) {
                oVar.f5713c.onFailure((Exception) p.g(this.f5709e.f()));
            }
        }
    }
}
