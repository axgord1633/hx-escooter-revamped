package kotlinx.coroutines.scheduling;

import c4.c0;
import c4.c1;
import java.util.concurrent.Executor;
import o3.g;
import o3.h;

public final class b extends c1 implements Executor {

    /* renamed from: h  reason: collision with root package name */
    public static final b f5668h = new b();

    /* renamed from: i  reason: collision with root package name */
    private static final c0 f5669i = m.f5688g.O(e0.d("kotlinx.coroutines.io.parallelism", f.a(64, kotlinx.coroutines.internal.c0.a()), 0, 0, 12, (Object) null));

    private b() {
    }

    public void M(g gVar, Runnable runnable) {
        f5669i.M(gVar, runnable);
    }

    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    public void execute(Runnable runnable) {
        M(h.f6161e, runnable);
    }

    public String toString() {
        return "Dispatchers.IO";
    }
}
