package w0;

import android.app.Activity;
import android.content.Intent;

final class c0 extends e0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Intent f7319e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Activity f7320f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ int f7321g;

    c0(Intent intent, Activity activity, int i5) {
        this.f7319e = intent;
        this.f7320f = activity;
        this.f7321g = i5;
    }

    public final void a() {
        Intent intent = this.f7319e;
        if (intent != null) {
            this.f7320f.startActivityForResult(intent, this.f7321g);
        }
    }
}
