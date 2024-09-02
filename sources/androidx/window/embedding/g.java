package androidx.window.embedding;

import androidx.window.embedding.ExtensionEmbeddingBackend;
import java.util.List;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ExtensionEmbeddingBackend.SplitListenerWrapper f2829e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ List f2830f;

    public /* synthetic */ g(ExtensionEmbeddingBackend.SplitListenerWrapper splitListenerWrapper, List list) {
        this.f2829e = splitListenerWrapper;
        this.f2830f = list;
    }

    public final void run() {
        ExtensionEmbeddingBackend.SplitListenerWrapper.m5accept$lambda1(this.f2829e, this.f2830f);
    }
}
