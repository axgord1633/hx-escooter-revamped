package io.flutter.embedding.engine.dart;

import android.os.Handler;
import android.os.Looper;
import io.flutter.embedding.engine.dart.DartMessenger;
import io.flutter.util.HandlerCompat;

public class PlatformTaskQueue implements DartMessenger.DartMessengerTaskQueue {
    private final Handler handler = HandlerCompat.createAsyncHandler(Looper.getMainLooper());

    public void dispatch(Runnable runnable) {
        this.handler.post(runnable);
    }
}
