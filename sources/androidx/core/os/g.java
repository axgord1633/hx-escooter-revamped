package androidx.core.os;

import android.os.Handler;
import androidx.core.util.d;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class g {

    private static class a implements Executor {

        /* renamed from: e  reason: collision with root package name */
        private final Handler f1787e;

        a(Handler handler) {
            this.f1787e = (Handler) d.h(handler);
        }

        public void execute(Runnable runnable) {
            if (!this.f1787e.post((Runnable) d.h(runnable))) {
                throw new RejectedExecutionException(this.f1787e + " is shutting down");
            }
        }
    }

    public static Executor a(Handler handler) {
        return new a(handler);
    }
}
