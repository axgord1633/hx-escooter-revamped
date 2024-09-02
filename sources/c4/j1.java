package c4;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import m3.q;
import v3.l;

final class j1 extends n1 {

    /* renamed from: j  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f3132j = AtomicIntegerFieldUpdater.newUpdater(j1.class, "_invoked");
    private volatile /* synthetic */ int _invoked = 0;

    /* renamed from: i  reason: collision with root package name */
    private final l<Throwable, q> f3133i;

    public j1(l<? super Throwable, q> lVar) {
        this.f3133i = lVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        w((Throwable) obj);
        return q.f5904a;
    }

    public void w(Throwable th) {
        if (f3132j.compareAndSet(this, 0, 1)) {
            this.f3133i.invoke(th);
        }
    }
}
