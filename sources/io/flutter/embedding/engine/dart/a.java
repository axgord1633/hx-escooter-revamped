package io.flutter.embedding.engine.dart;

import io.flutter.embedding.engine.dart.DartMessenger;
import java.nio.ByteBuffer;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ DartMessenger f5271e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f5272f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f5273g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DartMessenger.HandlerInfo f5274h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ByteBuffer f5275i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f5276j;

    public /* synthetic */ a(DartMessenger dartMessenger, String str, int i5, DartMessenger.HandlerInfo handlerInfo, ByteBuffer byteBuffer, long j5) {
        this.f5271e = dartMessenger;
        this.f5272f = str;
        this.f5273g = i5;
        this.f5274h = handlerInfo;
        this.f5275i = byteBuffer;
        this.f5276j = j5;
    }

    public final void run() {
        this.f5271e.lambda$dispatchMessageToQueue$0(this.f5272f, this.f5273g, this.f5274h, this.f5275i, this.f5276j);
    }
}
