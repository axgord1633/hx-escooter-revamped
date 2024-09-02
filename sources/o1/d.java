package o1;

import m2.k;
import r2.e;

public abstract class d<T> extends k<T> implements e<T> {
    public abstract boolean O0();

    public final d<T> P0() {
        return this instanceof e ? this : new e(this);
    }

    public abstract void accept(T t5);
}
