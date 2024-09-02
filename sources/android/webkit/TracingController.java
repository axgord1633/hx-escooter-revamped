package android.webkit;

import android.annotation.NonNull;
import android.annotation.Nullable;
import java.io.OutputStream;
import java.util.concurrent.Executor;

public /* synthetic */ class TracingController {
    static {
        throw new NoClassDefFoundError();
    }

    @NonNull
    public static native /* synthetic */ TracingController getInstance();

    public abstract /* synthetic */ boolean isTracing();

    public abstract /* synthetic */ boolean stop(@Nullable OutputStream outputStream, @NonNull Executor executor);
}
