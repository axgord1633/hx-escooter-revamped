package y3;

import java.util.NoSuchElementException;
import n3.a0;

public final class b extends a0 {

    /* renamed from: e  reason: collision with root package name */
    private final int f7828e;

    /* renamed from: f  reason: collision with root package name */
    private final int f7829f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7830g;

    /* renamed from: h  reason: collision with root package name */
    private int f7831h;

    public b(int i5, int i6, int i7) {
        this.f7828e = i7;
        this.f7829f = i6;
        boolean z4 = true;
        if (i7 <= 0 ? i5 < i6 : i5 > i6) {
            z4 = false;
        }
        this.f7830g = z4;
        this.f7831h = !z4 ? i6 : i5;
    }

    public boolean hasNext() {
        return this.f7830g;
    }

    public int nextInt() {
        int i5 = this.f7831h;
        if (i5 != this.f7829f) {
            this.f7831h = this.f7828e + i5;
        } else if (this.f7830g) {
            this.f7830g = false;
        } else {
            throw new NoSuchElementException();
        }
        return i5;
    }
}
