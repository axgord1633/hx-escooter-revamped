package n3;

import java.util.AbstractList;

public abstract class c<E> extends AbstractList<E> {
    protected c() {
    }

    public abstract int c();

    public abstract E e(int i5);

    public final /* bridge */ E remove(int i5) {
        return e(i5);
    }

    public final /* bridge */ int size() {
        return c();
    }
}
