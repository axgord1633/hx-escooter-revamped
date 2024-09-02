package l1;

import java.util.concurrent.Executor;

final class k implements r {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f5701a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final a f5702b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final v f5703c;

    public k(Executor executor, a aVar, v vVar) {
        this.f5701a = executor;
        this.f5702b = aVar;
        this.f5703c = vVar;
    }

    public final void a(g gVar) {
        this.f5701a.execute(new j(this, gVar));
    }
}
