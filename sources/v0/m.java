package v0;

import android.os.Handler;
import java.util.concurrent.Executor;

public final /* synthetic */ class m implements Executor {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Handler f7153e;

    public /* synthetic */ m(Handler handler) {
        this.f7153e = handler;
    }

    public final void execute(Runnable runnable) {
        this.f7153e.post(runnable);
    }
}
