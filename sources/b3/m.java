package b3;

import m2.v;
import r2.f;

public final class m {

    enum a implements f<v, u4.a> {
        INSTANCE;

        /* renamed from: c */
        public u4.a apply(v vVar) {
            return new s(vVar);
        }
    }

    public static <T> f<v<? extends T>, u4.a<? extends T>> a() {
        return a.INSTANCE;
    }
}
