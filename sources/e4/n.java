package e4;

import kotlinx.coroutines.internal.b0;
import m3.q;
import v3.l;

public class n<E> extends a<E> {
    public n(l<? super E, q> lVar) {
        super(lVar);
    }

    /* access modifiers changed from: protected */
    public Object i(E e5) {
        q<?> k5;
        do {
            Object i5 = super.i(e5);
            b0 b0Var = b.f4513b;
            if (i5 == b0Var) {
                return b0Var;
            }
            if (i5 == b.f4514c) {
                k5 = k(e5);
                if (k5 == null) {
                    return b0Var;
                }
            } else if (i5 instanceof j) {
                return i5;
            } else {
                throw new IllegalStateException(("Invalid offerInternal result " + i5).toString());
            }
        } while (!(k5 instanceof j));
        return k5;
    }

    /* access modifiers changed from: protected */
    public final boolean r() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean s() {
        return true;
    }
}
