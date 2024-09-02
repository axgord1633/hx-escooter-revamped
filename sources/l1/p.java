package l1;

final class p implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ g f5714e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ q f5715f;

    p(q qVar, g gVar) {
        this.f5715f = qVar;
        this.f5714e = gVar;
    }

    public final void run() {
        synchronized (this.f5715f.f5717b) {
            q qVar = this.f5715f;
            if (qVar.f5718c != null) {
                qVar.f5718c.b(this.f5714e.g());
            }
        }
    }
}
