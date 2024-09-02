package androidx.lifecycle;

import androidx.lifecycle.f;
import kotlin.jvm.internal.k;

public final class SingleGeneratedAdapterObserver implements h {

    /* renamed from: e  reason: collision with root package name */
    private final c f2550e;

    public SingleGeneratedAdapterObserver(c cVar) {
        k.e(cVar, "generatedAdapter");
        this.f2550e = cVar;
    }

    public void a(j jVar, f.a aVar) {
        k.e(jVar, "source");
        k.e(aVar, "event");
        this.f2550e.a(jVar, aVar, false, (n) null);
        this.f2550e.a(jVar, aVar, true, (n) null);
    }
}
