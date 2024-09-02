package l1;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

final class q implements r {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f5716a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f5717b = new Object();
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public e f5718c;

    public q(Executor executor, e eVar) {
        this.f5716a = executor;
        this.f5718c = eVar;
    }

    public final void a(g gVar) {
        if (gVar.j()) {
            synchronized (this.f5717b) {
                if (this.f5718c != null) {
                    this.f5716a.execute(new p(this, gVar));
                }
            }
        }
    }
}
