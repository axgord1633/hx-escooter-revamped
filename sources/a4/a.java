package a4;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.k;

public final class a<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<b<T>> f454a;

    public a(b<? extends T> bVar) {
        k.e(bVar, "sequence");
        this.f454a = new AtomicReference<>(bVar);
    }

    public Iterator<T> iterator() {
        b andSet = this.f454a.getAndSet((Object) null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
