package h3;

import a3.l0;
import a3.m0;
import a3.o0;
import m2.k;
import p2.c;
import r2.e;

public abstract class a<T> extends k<T> {
    private a<T> R0() {
        return this instanceof m0 ? j3.a.k(new l0(((m0) this).e())) : this;
    }

    public k<T> O0(int i5) {
        return P0(i5, t2.a.d());
    }

    public k<T> P0(int i5, e<? super c> eVar) {
        if (i5 > 0) {
            return j3.a.o(new a3.c(this, i5, eVar));
        }
        Q0(eVar);
        return j3.a.k(this);
    }

    public abstract void Q0(e<? super c> eVar);

    public k<T> S0() {
        return j3.a.o(new o0(R0()));
    }
}
