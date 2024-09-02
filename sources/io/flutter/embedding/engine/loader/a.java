package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.os.Handler;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ FlutterLoader f5285e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f5286f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String[] f5287g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Handler f5288h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Runnable f5289i;

    public /* synthetic */ a(FlutterLoader flutterLoader, Context context, String[] strArr, Handler handler, Runnable runnable) {
        this.f5285e = flutterLoader;
        this.f5286f = context;
        this.f5287g = strArr;
        this.f5288h = handler;
        this.f5289i = runnable;
    }

    public final void run() {
        this.f5285e.lambda$ensureInitializationCompleteAsync$0(this.f5286f, this.f5287g, this.f5288h, this.f5289i);
    }
}
