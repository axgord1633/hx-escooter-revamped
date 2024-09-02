package c4;

import h4.b;
import m3.i;
import o3.d;
import o3.f;
import v3.l;
import v3.p;

public enum i0 {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3130a = null;

        static {
            int[] iArr = new int[i0.values().length];
            iArr[i0.DEFAULT.ordinal()] = 1;
            iArr[i0.ATOMIC.ordinal()] = 2;
            iArr[i0.UNDISPATCHED.ordinal()] = 3;
            iArr[i0.LAZY.ordinal()] = 4;
            f3130a = iArr;
        }
    }

    public final <R, T> void f(p<? super R, ? super d<? super T>, ? extends Object> pVar, R r5, d<? super T> dVar) {
        int i5 = a.f3130a[ordinal()];
        if (i5 == 1) {
            h4.a.d(pVar, r5, dVar, (l) null, 4, (Object) null);
        } else if (i5 == 2) {
            f.a(pVar, r5, dVar);
        } else if (i5 == 3) {
            b.a(pVar, r5, dVar);
        } else if (i5 != 4) {
            throw new i();
        }
    }

    public final boolean i() {
        return this == LAZY;
    }
}
