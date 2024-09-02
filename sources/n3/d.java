package n3;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.b;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

final class d<T> implements Collection<T> {

    /* renamed from: e  reason: collision with root package name */
    private final T[] f6070e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f6071f;

    public d(T[] tArr, boolean z4) {
        k.e(tArr, "values");
        this.f6070e = tArr;
        this.f6071f = z4;
    }

    public boolean add(T t5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public int c() {
        return this.f6070e.length;
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Object obj) {
        return j.i(this.f6070e, obj);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        k.e(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.f6070e.length == 0;
    }

    public Iterator<T> iterator() {
        return b.a(this.f6070e);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return c();
    }

    public final Object[] toArray() {
        return m.a(this.f6070e, this.f6071f);
    }

    public <T> T[] toArray(T[] tArr) {
        k.e(tArr, "array");
        return f.b(this, tArr);
    }
}
