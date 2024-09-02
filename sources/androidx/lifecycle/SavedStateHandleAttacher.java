package androidx.lifecycle;

import androidx.lifecycle.f;
import kotlin.jvm.internal.k;

public final class SavedStateHandleAttacher implements h {

    /* renamed from: e  reason: collision with root package name */
    private final w f2546e;

    public SavedStateHandleAttacher(w wVar) {
        k.e(wVar, "provider");
        this.f2546e = wVar;
    }

    public void a(j jVar, f.a aVar) {
        k.e(jVar, "source");
        k.e(aVar, "event");
        if (aVar == f.a.ON_CREATE) {
            jVar.getLifecycle().c(this);
            this.f2546e.d();
            return;
        }
        throw new IllegalStateException(("Next event must be ON_CREATE, it was " + aVar).toString());
    }
}
