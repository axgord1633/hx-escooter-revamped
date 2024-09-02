package p1;

import g0.c;
import g0.e;
import java.util.concurrent.ExecutorService;
import p1.a;

public final class d implements c<ExecutorService> {

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final d f6434a = new d();
    }

    public static d a() {
        return a.f6434a;
    }

    public static ExecutorService c() {
        return (ExecutorService) e.d(a.c.c());
    }

    /* renamed from: b */
    public ExecutorService get() {
        return c();
    }
}
