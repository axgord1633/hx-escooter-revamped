package w0;

import android.content.Intent;
import v0.f;

final class d0 extends e0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Intent f7324e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ f f7325f;

    d0(Intent intent, f fVar, int i5) {
        this.f7324e = intent;
        this.f7325f = fVar;
    }

    public final void a() {
        Intent intent = this.f7324e;
        if (intent != null) {
            this.f7325f.startActivityForResult(intent, 2);
        }
    }
}
