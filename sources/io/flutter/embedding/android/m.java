package io.flutter.embedding.android;

import android.view.KeyEvent;
import io.flutter.embedding.android.KeyboardMap;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ KeyEmbedderResponder f5263e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ KeyboardMap.KeyPair f5264f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f5265g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ KeyEvent f5266h;

    public /* synthetic */ m(KeyEmbedderResponder keyEmbedderResponder, KeyboardMap.KeyPair keyPair, long j5, KeyEvent keyEvent) {
        this.f5263e = keyEmbedderResponder;
        this.f5264f = keyPair;
        this.f5265g = j5;
        this.f5266h = keyEvent;
    }

    public final void run() {
        this.f5263e.lambda$synchronizePressingKey$0(this.f5264f, this.f5265g, this.f5266h);
    }
}
