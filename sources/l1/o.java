package l1;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

final class o implements r {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f5711a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f5712b = new Object();
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public d f5713c;

    public o(Executor executor, d dVar) {
        this.f5711a = executor;
        this.f5713c = dVar;
    }

    public final void a(g gVar) {
        if (!gVar.j() && !gVar.h()) {
            synchronized (this.f5712b) {
                if (this.f5713c != null) {
                    this.f5711a.execute(new n(this, gVar));
                }
            }
        }
    }
}
