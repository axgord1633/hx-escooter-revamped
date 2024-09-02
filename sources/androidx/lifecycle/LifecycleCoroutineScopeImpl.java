package androidx.lifecycle;

import androidx.lifecycle.f;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.k;
import o3.g;

public final class LifecycleCoroutineScopeImpl extends g implements h {

    /* renamed from: e  reason: collision with root package name */
    private final f f2523e;

    /* renamed from: f  reason: collision with root package name */
    private final g f2524f;

    public void a(j jVar, f.a aVar) {
        k.e(jVar, "source");
        k.e(aVar, "event");
        if (b().b().compareTo(f.b.DESTROYED) <= 0) {
            b().c(this);
            q1.d(i(), (CancellationException) null, 1, (Object) null);
        }
    }

    public f b() {
        return this.f2523e;
    }

    public g i() {
        return this.f2524f;
    }
}
