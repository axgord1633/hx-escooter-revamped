package kotlin.jvm.internal;

import java.io.Serializable;

public abstract class l<R> implements h<R>, Serializable {
    private final int arity;

    public l(int i5) {
        this.arity = i5;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String f5 = r.f(this);
        k.d(f5, "renderLambdaToString(this)");
        return f5;
    }
}
