package kotlin.coroutines.jvm.internal;

import kotlin.jvm.internal.h;
import kotlin.jvm.internal.r;
import o3.d;

public abstract class k extends d implements h<Object> {
    private final int arity;

    public k(int i5) {
        this(i5, (d<Object>) null);
    }

    public k(int i5, d<Object> dVar) {
        super(dVar);
        this.arity = i5;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String e5 = r.e(this);
        kotlin.jvm.internal.k.d(e5, "renderLambdaToString(this)");
        return e5;
    }
}
