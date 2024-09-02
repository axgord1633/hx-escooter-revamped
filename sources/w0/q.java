package w0;

public final class q {

    /* renamed from: b  reason: collision with root package name */
    private static q f7423b;

    /* renamed from: c  reason: collision with root package name */
    private static final r f7424c = new r(0, false, false, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    private r f7425a;

    private q() {
    }

    public static synchronized q b() {
        q qVar;
        synchronized (q.class) {
            if (f7423b == null) {
                f7423b = new q();
            }
            qVar = f7423b;
        }
        return qVar;
    }

    public r a() {
        return this.f7425a;
    }

    public final synchronized void c(r rVar) {
        if (rVar == null) {
            this.f7425a = f7424c;
            return;
        }
        r rVar2 = this.f7425a;
        if (rVar2 == null || rVar2.e() < rVar.e()) {
            this.f7425a = rVar;
        }
    }
}
