package androidx.window.layout;

import android.app.Activity;
import androidx.core.util.a;
import java.util.concurrent.Executor;

public interface WindowBackend {
    void registerLayoutChangeCallback(Activity activity, Executor executor, a<WindowLayoutInfo> aVar);

    void unregisterLayoutChangeCallback(a<WindowLayoutInfo> aVar);
}
