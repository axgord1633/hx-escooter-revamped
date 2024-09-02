package p1;

import g0.c;
import g0.e;
import java.util.concurrent.ExecutorService;
import m2.q;
import p1.a;

public final class n implements c<a.b> {

    /* renamed from: a  reason: collision with root package name */
    private final h0.a<ExecutorService> f6504a;

    /* renamed from: b  reason: collision with root package name */
    private final h0.a<q> f6505b;

    /* renamed from: c  reason: collision with root package name */
    private final h0.a<ExecutorService> f6506c;

    public n(h0.a<ExecutorService> aVar, h0.a<q> aVar2, h0.a<ExecutorService> aVar3) {
        this.f6504a = aVar;
        this.f6505b = aVar2;
        this.f6506c = aVar3;
    }

    public static n a(h0.a<ExecutorService> aVar, h0.a<q> aVar2, h0.a<ExecutorService> aVar3) {
        return new n(aVar, aVar2, aVar3);
    }

    public static a.b c(ExecutorService executorService, q qVar, ExecutorService executorService2) {
        return (a.b) e.d(a.c.m(executorService, qVar, executorService2));
    }

    /* renamed from: b */
    public a.b get() {
        return c(this.f6504a.get(), this.f6505b.get(), this.f6506c.get());
    }
}
