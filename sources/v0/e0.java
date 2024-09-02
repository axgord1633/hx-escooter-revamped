package v0;

import java.util.Set;
import l1.h;
import m.a;
import u0.c;

public final class e0 {

    /* renamed from: a  reason: collision with root package name */
    private final a f7121a;

    /* renamed from: b  reason: collision with root package name */
    private final a f7122b;

    /* renamed from: c  reason: collision with root package name */
    private final h f7123c;

    /* renamed from: d  reason: collision with root package name */
    private int f7124d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7125e;

    public final Set a() {
        return this.f7121a.keySet();
    }

    public final void b(b bVar, t0.a aVar, String str) {
        this.f7121a.put(bVar, aVar);
        this.f7122b.put(bVar, str);
        this.f7124d--;
        if (!aVar.e()) {
            this.f7125e = true;
        }
        if (this.f7124d != 0) {
            return;
        }
        if (this.f7125e) {
            this.f7123c.b(new c(this.f7121a));
            return;
        }
        this.f7123c.c(this.f7122b);
    }
}
