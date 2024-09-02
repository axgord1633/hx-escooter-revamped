package n3;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

public abstract class a<E> implements Collection<E> {

    /* renamed from: n3.a$a  reason: collision with other inner class name */
    static final class C0089a extends l implements v3.l<E, CharSequence> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ a<E> f6062e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0089a(a<? extends E> aVar) {
            super(1);
            this.f6062e = aVar;
        }

        /* renamed from: a */
        public final CharSequence invoke(E e5) {
            return e5 == this.f6062e ? "(this Collection)" : String.valueOf(e5);
        }
    }

    protected a() {
    }

    public boolean add(E e5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public abstract int c();

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(E e5) {
        if (isEmpty()) {
            return false;
        }
        for (Object a5 : this) {
            if (k.a(a5, e5)) {
                return true;
            }
        }
        return false;
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
        return size() == 0;
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

    public Object[] toArray() {
        return f.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        k.e(tArr, "array");
        return f.b(this, tArr);
    }

    public String toString() {
        return v.p(this, ", ", "[", "]", 0, (CharSequence) null, new C0089a(this), 24, (Object) null);
    }
}
