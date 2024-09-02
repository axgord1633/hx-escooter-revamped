package l1;

final class j implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ g f5699e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ k f5700f;

    j(k kVar, g gVar) {
        this.f5700f = kVar;
        this.f5699e = gVar;
    }

    public final void run() {
        if (this.f5699e.h()) {
            this.f5700f.f5703c.o();
            return;
        }
        try {
            this.f5700f.f5703c.n(this.f5700f.f5702b.a(this.f5699e));
        } catch (f e5) {
            if (e5.getCause() instanceof Exception) {
                this.f5700f.f5703c.m((Exception) e5.getCause());
            } else {
                this.f5700f.f5703c.m(e5);
            }
        } catch (Exception e6) {
            this.f5700f.f5703c.m(e6);
        }
    }
}
