package n3;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

public final class x implements List, Serializable, RandomAccess {

    /* renamed from: e  reason: collision with root package name */
    public static final x f6079e = new x();

    private x() {
    }

    public /* bridge */ /* synthetic */ void add(int i5, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i5, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean c(Void voidR) {
        k.e(voidR, "element");
        return false;
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Void)) {
            return false;
        }
        return c((Void) obj);
    }

    public boolean containsAll(Collection collection) {
        k.e(collection, "elements");
        return collection.isEmpty();
    }

    /* renamed from: e */
    public Void get(int i5) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + i5 + '.');
    }

    public boolean equals(Object obj) {
        return (obj instanceof List) && ((List) obj).isEmpty();
    }

    public int f() {
        return 0;
    }

    public int hashCode() {
        return 1;
    }

    public int i(Void voidR) {
        k.e(voidR, "element");
        return -1;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof Void)) {
            return -1;
        }
        return i((Void) obj);
    }

    public boolean isEmpty() {
        return true;
    }

    public Iterator iterator() {
        return w.f6078e;
    }

    public int l(Void voidR) {
        k.e(voidR, "element");
        return -1;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof Void)) {
            return -1;
        }
        return l((Void) obj);
    }

    public ListIterator listIterator() {
        return w.f6078e;
    }

    public ListIterator listIterator(int i5) {
        if (i5 == 0) {
            return w.f6078e;
        }
        throw new IndexOutOfBoundsException("Index: " + i5);
    }

    public /* bridge */ /* synthetic */ Object remove(int i5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object set(int i5, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return f();
    }

    public List subList(int i5, int i6) {
        if (i5 == 0 && i6 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i5 + ", toIndex: " + i6);
    }

    public Object[] toArray() {
        return f.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        k.e(tArr, "array");
        return f.b(this, tArr);
    }

    public String toString() {
        return "[]";
    }
}
