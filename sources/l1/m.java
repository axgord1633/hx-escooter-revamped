package l1;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

final class m implements r {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f5706a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f5707b = new Object();
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public c f5708c;

    public m(Executor executor, c cVar) {
        this.f5706a = executor;
        this.f5708c = cVar;
    }

    public final void a(g gVar) {
        synchronized (this.f5707b) {
            if (this.f5708c != null) {
                this.f5706a.execute(new l(this, gVar));
            }
        }
    }
}
