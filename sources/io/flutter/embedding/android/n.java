package io.flutter.embedding.android;

import android.view.KeyEvent;
import io.flutter.embedding.android.KeyboardMap;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ KeyEmbedderResponder f5267e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ KeyboardMap.KeyPair f5268f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KeyEvent f5269g;

    public /* synthetic */ n(KeyEmbedderResponder keyEmbedderResponder, KeyboardMap.KeyPair keyPair, KeyEvent keyEvent) {
        this.f5267e = keyEmbedderResponder;
        this.f5268f = keyPair;
        this.f5269g = keyEvent;
    }

    public final void run() {
        this.f5267e.lambda$synchronizePressingKey$1(this.f5268f, this.f5269g);
    }
}
