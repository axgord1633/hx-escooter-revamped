package d3;

import java.util.concurrent.ThreadFactory;
import m2.q;

public final class g extends q {

    /* renamed from: c  reason: collision with root package name */
    private static final i f4403c = new i("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: b  reason: collision with root package name */
    final ThreadFactory f4404b;

    public g() {
        this(f4403c);
    }

    public g(ThreadFactory threadFactory) {
        this.f4404b = threadFactory;
    }

    public q.c a() {
        return new h(this.f4404b);
    }
}
