package androidx.lifecycle;

import androidx.lifecycle.f;
import kotlin.jvm.internal.k;

public final class CompositeGeneratedAdaptersObserver implements h {

    /* renamed from: e  reason: collision with root package name */
    private final c[] f2516e;

    public CompositeGeneratedAdaptersObserver(c[] cVarArr) {
        k.e(cVarArr, "generatedAdapters");
        this.f2516e = cVarArr;
    }

    public void a(j jVar, f.a aVar) {
        k.e(jVar, "source");
        k.e(aVar, "event");
        n nVar = new n();
        for (c a5 : this.f2516e) {
            a5.a(jVar, aVar, false, nVar);
        }
        for (c a6 : this.f2516e) {
            a6.a(jVar, aVar, true, nVar);
        }
    }
}
