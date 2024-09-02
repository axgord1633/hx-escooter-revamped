package g1;

import java.util.NoSuchElementException;

abstract class o0 extends v0 {

    /* renamed from: e  reason: collision with root package name */
    private final int f4707e;

    /* renamed from: f  reason: collision with root package name */
    private int f4708f;

    protected o0(int i5, int i6) {
        m0.b(i6, i5, "index");
        this.f4707e = i5;
        this.f4708f = i6;
    }

    /* access modifiers changed from: protected */
    public abstract Object b(int i5);

    public final boolean hasNext() {
        return this.f4708f < this.f4707e;
    }

    public final boolean hasPrevious() {
        return this.f4708f > 0;
    }

    public final Object next() {
        if (hasNext()) {
            int i5 = this.f4708f;
            this.f4708f = i5 + 1;
            return b(i5);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.f4708f;
    }

    public final Object previous() {
        if (hasPrevious()) {
            int i5 = this.f4708f - 1;
            this.f4708f = i5;
            return b(i5);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.f4708f - 1;
    }
}
