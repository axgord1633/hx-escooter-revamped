package kotlinx.coroutines.internal;

import androidx.concurrent.futures.b;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public abstract class c<T> extends w {

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f5583a = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_consensus");
    private volatile /* synthetic */ Object _consensus = b.f5580a;

    public c<?> a() {
        return this;
    }

    public final Object c(Object obj) {
        Object obj2 = this._consensus;
        if (obj2 == b.f5580a) {
            obj2 = e(g(obj));
        }
        d(obj, obj2);
        return obj2;
    }

    public abstract void d(T t5, Object obj);

    public final Object e(Object obj) {
        Object obj2 = this._consensus;
        Object obj3 = b.f5580a;
        return obj2 != obj3 ? obj2 : b.a(f5583a, this, obj3, obj) ? obj : this._consensus;
    }

    public long f() {
        return 0;
    }

    public abstract Object g(T t5);
}
