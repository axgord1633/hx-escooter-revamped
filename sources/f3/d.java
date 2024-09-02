package f3;

import u2.f;
import u4.b;

public enum d implements f<Object> {
    INSTANCE;

    public static void c(b<?> bVar) {
        bVar.e(INSTANCE);
        bVar.a();
    }

    public static void l(Throwable th, b<?> bVar) {
        bVar.e(INSTANCE);
        bVar.onError(th);
    }

    public void cancel() {
    }

    public void clear() {
    }

    public void f(long j5) {
        g.p(j5);
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

    public String toString() {
        return "EmptySubscription";
    }
}
