package l1;

final class l implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ g f5704e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ m f5705f;

    l(m mVar, g gVar) {
        this.f5705f = mVar;
        this.f5704e = gVar;
    }

    public final void run() {
        synchronized (this.f5705f.f5707b) {
            m mVar = this.f5705f;
            if (mVar.f5708c != null) {
                mVar.f5708c.a(this.f5704e);
            }
        }
    }
}
