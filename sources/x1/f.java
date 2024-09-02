package x1;

import g0.c;
import h0.a;
import java.util.concurrent.ExecutorService;
import m2.q;
import t1.z;

public final class f implements c<e> {

    /* renamed from: a  reason: collision with root package name */
    private final a<String> f7609a;

    /* renamed from: b  reason: collision with root package name */
    private final a<z> f7610b;

    /* renamed from: c  reason: collision with root package name */
    private final a<ExecutorService> f7611c;

    /* renamed from: d  reason: collision with root package name */
    private final a<q> f7612d;

    public f(a<String> aVar, a<z> aVar2, a<ExecutorService> aVar3, a<q> aVar4) {
        this.f7609a = aVar;
        this.f7610b = aVar2;
        this.f7611c = aVar3;
        this.f7612d = aVar4;
    }

    public static f a(a<String> aVar, a<z> aVar2, a<ExecutorService> aVar3, a<q> aVar4) {
        return new f(aVar, aVar2, aVar3, aVar4);
    }

    public static e c(String str, z zVar, ExecutorService executorService, q qVar) {
        return new e(str, zVar, executorService, qVar);
    }

    /* renamed from: b */
    public e get() {
        return c(this.f7609a.get(), this.f7610b.get(), this.f7611c.get(), this.f7612d.get());
    }
}
