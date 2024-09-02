package l1;

import android.os.Handler;
import android.os.Looper;
import h1.a;
import java.util.concurrent.Executor;

final class u implements Executor {

    /* renamed from: e  reason: collision with root package name */
    private final Handler f5722e = new a(Looper.getMainLooper());

    public final void execute(Runnable runnable) {
        this.f5722e.post(runnable);
    }
}
