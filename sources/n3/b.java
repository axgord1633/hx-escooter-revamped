package n3;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public abstract class b<E> extends a<E> implements List<E> {

    /* renamed from: e  reason: collision with root package name */
    public static final a f6063e = new a((g) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final void a(int i5, int i6) {
            if (i5 < 0 || i5 >= i6) {
                throw new IndexOutOfBoundsException("index: " + i5 + ", size: " + i6);
            }
        }

        public final void b(int i5, int i6) {
            if (i5 < 0 || i5 > i6) {
                throw new IndexOutOfBoundsException("index: " + i5 + ", size: " + i6);
            }
        }

        public final void c(int i5, int i6, int i7) {
            if (i5 < 0 || i6 > i7) {
                throw new IndexOutOfBoundsException("fromIndex: " + i5 + ", toIndex: " + i6 + ", size: " + i7);
            } else if (i5 > i6) {
                throw new IllegalArgumentException("fromIndex: " + i5 + " > toIndex: " + i6);
            }
        }

        public final boolean d(Collection<?> collection, Collection<?> collection2) {
            k.e(collection, "c");
            k.e(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it = collection2.iterator();
            for (Object a5 : collection) {
                if (!k.a(a5, it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int e(Collection<?> collection) {
            k.e(collection, "c");
            Iterator<?> it = collection.iterator();
            int i5 = 1;
            while (it.hasNext()) {
                Object next = it.next();
                i5 = (i5 * 31) + (next != null ? next.hashCode() : 0);
            }
            return i5;
        }
    }

    /* renamed from: n3.b$b  reason: collision with other inner class name */
    private class C0090b implements Iterator<E> {

        /* renamed from: e  reason: collision with root package name */
        private int f6064e;

        public C0090b() {
        }

        /* access modifiers changed from: protected */
        public final int b() {
            return this.f6064e;
        }

        /* access modifiers changed from: protected */
        public final void c(int i5) {
            this.f6064e = i5;
        }

        public boolean hasNext() {
            return this.f6064e < b.this.size();
        }

        public E next() {
            if (hasNext()) {
                b<E> bVar = b.this;
                int i5 = this.f6064e;
                this.f6064e = i5 + 1;
                return bVar.get(i5);
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private class c extends b<E>.b implements ListIterator<E> {
        public c(int i5) {
            super();
            b.f6063e.b(i5, b.this.size());
            c(i5);
        }

        public void add(E e5) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean hasPrevious() {
            return b() > 0;
        }

        public int nextIndex() {
            return b();
        }

        public E previous() {
            if (hasPrevious()) {
                b<E> bVar = b.this;
                c(b() - 1);
                return bVar.get(b());
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return b() - 1;
        }

        public void set(E e5) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private static final class d<E> extends b<E> implements RandomAccess {

        /* renamed from: f  reason: collision with root package name */
        private final b<E> f6067f;

        /* renamed from: g  reason: collision with root package name */
        private final int f6068g;

        /* renamed from: h  reason: collision with root package name */
        private int f6069h;

        public d(b<? extends E> bVar, int i5, int i6) {
            k.e(bVar, "list");
            this.f6067f = bVar;
            this.f6068g = i5;
            b.f6063e.c(i5, i6, bVar.size());
            this.f6069h = i6 - i5;
        }

        public int c() {
            return this.f6069h;
        }

        public E get(int i5) {
            b.f6063e.a(i5, this.f6069h);
            return this.f6067f.get(this.f6068g + i5);
        }
    }

    protected b() {
    }

    public void add(int i5, E e5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i5, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        return f6063e.d(this, (Collection) obj);
    }

    public abstract E get(int i5);

    public int hashCode() {
        return f6063e.e(this);
    }

    public int indexOf(E e5) {
        int i5 = 0;
        for (Object a5 : this) {
            if (k.a(a5, e5)) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public Iterator<E> iterator() {
        return new C0090b();
    }

    public int lastIndexOf(E e5) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (k.a(listIterator.previous(), e5)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public ListIterator<E> listIterator() {
        return new c(0);
    }

    public ListIterator<E> listIterator(int i5) {
        return new c(i5);
    }

    public E remove(int i5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public E set(int i5, E e5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<E> subList(int i5, int i6) {
        return new d(this, i5, i6);
    }
}
