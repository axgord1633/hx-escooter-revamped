package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.os.Handler;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ FlutterLoader f5290e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f5291f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String[] f5292g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Handler f5293h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Runnable f5294i;

    public /* synthetic */ b(FlutterLoader flutterLoader, Context context, String[] strArr, Handler handler, Runnable runnable) {
        this.f5290e = flutterLoader;
        this.f5291f = context;
        this.f5292g = strArr;
        this.f5293h = handler;
        this.f5294i = runnable;
    }

    public final void run() {
        this.f5290e.lambda$ensureInitializationCompleteAsync$1(this.f5291f, this.f5292g, this.f5293h, this.f5294i);
    }
}
