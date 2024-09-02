package com.guotu.hxscooter;

import android.os.Bundle;
import io.flutter.embedding.android.FlutterActivity;
import j3.a;
import kotlin.jvm.internal.k;
import q2.f;

public final class MainActivity extends FlutterActivity {
    /* access modifiers changed from: private */
    public static final void b(Throwable th) {
        if (!(th instanceof f) || !(th.getCause() instanceof q1.f)) {
            k.d(th, "throwable");
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.z(new n1.a());
    }
}
