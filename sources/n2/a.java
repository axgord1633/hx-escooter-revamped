package n2;

import java.util.concurrent.Callable;
import m2.q;
import q2.b;
import r2.f;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile f<Callable<q>, q> f6060a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile f<q, q> f6061b;

    static <T, R> R a(f<T, R> fVar, T t5) {
        try {
            return fVar.apply(t5);
        } catch (Throwable th) {
            throw b.a(th);
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [r2.f<java.util.concurrent.Callable<m2.q>, m2.q>, r2.f] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static m2.q b(r2.f<java.util.concurrent.Callable<m2.q>, m2.q> r0, java.util.concurrent.Callable<m2.q> r1) {
        /*
            java.lang.Object r0 = a(r0, r1)
            m2.q r0 = (m2.q) r0
            if (r0 == 0) goto L_0x0009
            return r0
        L_0x0009:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Scheduler Callable returned null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n2.a.b(r2.f, java.util.concurrent.Callable):m2.q");
    }

    static q c(Callable<q> callable) {
        try {
            q call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw b.a(th);
        }
    }

    public static q d(Callable<q> callable) {
        if (callable != null) {
            f<Callable<q>, q> fVar = f6060a;
            return fVar == null ? c(callable) : b(fVar, callable);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static q e(q qVar) {
        if (qVar != null) {
            f fVar = f6061b;
            return fVar == null ? qVar : (q) a(fVar, qVar);
        }
        throw new NullPointerException("scheduler == null");
    }
}
