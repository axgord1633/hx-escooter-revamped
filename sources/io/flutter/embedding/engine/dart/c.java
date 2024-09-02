package io.flutter.embedding.engine.dart;

import io.flutter.embedding.engine.dart.DartMessenger;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ DartMessenger.SerialTaskQueue f5278e;

    public /* synthetic */ c(DartMessenger.SerialTaskQueue serialTaskQueue) {
        this.f5278e = serialTaskQueue;
    }

    public final void run() {
        this.f5278e.lambda$dispatch$0();
    }
}
