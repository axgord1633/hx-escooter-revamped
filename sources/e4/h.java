package e4;

import m3.q;
import v3.l;

public final class h {
    public static final <E> f<E> a(int i5, e eVar, l<? super E, q> lVar) {
        int i6 = 1;
        if (i5 == -2) {
            if (eVar == e.SUSPEND) {
                i6 = f.f4532a.a();
            }
            return new d(i6, eVar, lVar);
        } else if (i5 != -1) {
            return i5 != 0 ? i5 != Integer.MAX_VALUE ? (i5 == 1 && eVar == e.DROP_OLDEST) ? new m(lVar) : new d(i5, eVar, lVar) : new n(lVar) : eVar == e.SUSPEND ? new r(lVar) : new d(1, eVar, lVar);
        } else {
            if (eVar != e.SUSPEND) {
                i6 = 0;
            }
            if (i6 != 0) {
                return new m(lVar);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
    }

    public static /* synthetic */ f b(int i5, e eVar, l lVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = 0;
        }
        if ((i6 & 2) != 0) {
            eVar = e.SUSPEND;
        }
        if ((i6 & 4) != 0) {
            lVar = null;
        }
        return a(i5, eVar, lVar);
    }
}
