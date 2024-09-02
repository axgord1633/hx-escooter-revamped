package p1;

import g0.c;
import h0.a;
import java.util.concurrent.ExecutorService;
import m2.q;
import p1.a;

public final class e implements c<q> {

    /* renamed from: a  reason: collision with root package name */
    private final a<ExecutorService> f6439a;

    public e(a<ExecutorService> aVar) {
        this.f6439a = aVar;
    }

    public static e a(a<ExecutorService> aVar) {
        return new e(aVar);
    }

    public static q c(ExecutorService executorService) {
        return (q) g0.e.d(a.c.d(executorService));
    }

    /* renamed from: b */
    public q get() {
        return c(this.f6439a.get());
    }
}
