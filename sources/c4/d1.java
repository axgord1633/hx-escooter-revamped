package c4;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import kotlinx.coroutines.internal.d;
import o3.g;

public final class d1 extends c1 implements n0 {

    /* renamed from: h  reason: collision with root package name */
    private final Executor f3115h;

    public d1(Executor executor) {
        this.f3115h = executor;
        d.a(Q());
    }

    private final void P(g gVar, RejectedExecutionException rejectedExecutionException) {
        p1.c(gVar, b1.a("The task was rejected", rejectedExecutionException));
    }

    public void M(g gVar, Runnable runnable) {
        try {
            Executor Q = Q();
            c.a();
            Q.execute(runnable);
        } catch (RejectedExecutionException e5) {
            c.a();
            P(gVar, e5);
            t0.b().M(gVar, runnable);
        }
    }

    public Executor Q() {
        return this.f3115h;
    }

    public void close() {
        Executor Q = Q();
        ExecutorService executorService = Q instanceof ExecutorService ? (ExecutorService) Q : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof d1) && ((d1) obj).Q() == Q();
    }

    public int hashCode() {
        return System.identityHashCode(Q());
    }

    public String toString() {
        return Q().toString();
    }
}
