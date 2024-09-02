package s2;

import m2.b;
import m2.p;
import m2.t;

public enum d implements u2.d<Object> {
    INSTANCE,
    NEVER;

    public static void c(p<?> pVar) {
        pVar.c(INSTANCE);
        pVar.a();
    }

    public static void l(Throwable th, b bVar) {
        bVar.c(INSTANCE);
        bVar.onError(th);
    }

    public static void m(Throwable th, p<?> pVar) {
        pVar.c(INSTANCE);
        pVar.onError(th);
    }

    public static void n(Throwable th, t<?> tVar) {
        tVar.c(INSTANCE);
        tVar.onError(th);
    }

    public void clear() {
    }

    public void dispose() {
    }

    public boolean f() {
        return this == INSTANCE;
    }

    public int i(int i5) {
        return i5 & 2;
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public Object poll() {
        return null;
    }
}
