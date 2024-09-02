package c4;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.internal.g;
import kotlinx.coroutines.internal.z;
import v3.l;

public final class p0<T> extends z<T> {

    /* renamed from: h  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f3152h = AtomicIntegerFieldUpdater.newUpdater(p0.class, "_decision");
    private volatile /* synthetic */ int _decision;

    private final boolean E0() {
        do {
            int i5 = this._decision;
            if (i5 != 0) {
                if (i5 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f3152h.compareAndSet(this, 0, 2));
        return true;
    }

    /* access modifiers changed from: protected */
    public void x(Object obj) {
        z0(obj);
    }

    /* access modifiers changed from: protected */
    public void z0(Object obj) {
        if (!E0()) {
            g.c(c.b(this.f5640g), z.a(obj, this.f5640g), (l) null, 2, (Object) null);
        }
    }
}
