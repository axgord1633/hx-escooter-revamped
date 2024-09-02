package b1;

import android.os.Handler;
import android.os.Looper;
import f1.e;
import java.util.concurrent.Executor;

public class a implements Executor {

    /* renamed from: e  reason: collision with root package name */
    private final Handler f2969e;

    public a(Looper looper) {
        this.f2969e = new e(looper);
    }

    public final void execute(Runnable runnable) {
        this.f2969e.post(runnable);
    }
}
