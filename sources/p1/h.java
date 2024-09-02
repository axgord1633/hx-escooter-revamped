package p1;

import g0.c;
import g0.e;
import java.util.concurrent.ExecutorService;
import p1.a;

public final class h implements c<ExecutorService> {

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final h f6462a = new h();
    }

    public static h a() {
        return a.f6462a;
    }

    public static ExecutorService c() {
        return (ExecutorService) e.d(a.c.g());
    }

    /* renamed from: b */
    public ExecutorService get() {
        return c();
    }
}
