package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class a<T> implements Iterator<T> {

    /* renamed from: e  reason: collision with root package name */
    private final T[] f5557e;

    /* renamed from: f  reason: collision with root package name */
    private int f5558f;

    public a(T[] tArr) {
        k.e(tArr, "array");
        this.f5557e = tArr;
    }

    public boolean hasNext() {
        return this.f5558f < this.f5557e.length;
    }

    public T next() {
        try {
            T[] tArr = this.f5557e;
            int i5 = this.f5558f;
            this.f5558f = i5 + 1;
            return tArr[i5];
        } catch (ArrayIndexOutOfBoundsException e5) {
            this.f5558f--;
            throw new NoSuchElementException(e5.getMessage());
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
