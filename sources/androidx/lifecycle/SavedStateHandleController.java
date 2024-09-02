package androidx.lifecycle;

import androidx.lifecycle.f;
import androidx.savedstate.a;
import kotlin.jvm.internal.k;

public final class SavedStateHandleController implements h {

    /* renamed from: e  reason: collision with root package name */
    private final String f2547e;

    /* renamed from: f  reason: collision with root package name */
    private final u f2548f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2549g;

    public SavedStateHandleController(String str, u uVar) {
        k.e(str, "key");
        k.e(uVar, "handle");
        this.f2547e = str;
        this.f2548f = uVar;
    }

    public void a(j jVar, f.a aVar) {
        k.e(jVar, "source");
        k.e(aVar, "event");
        if (aVar == f.a.ON_DESTROY) {
            this.f2549g = false;
            jVar.getLifecycle().c(this);
        }
    }

    public final void b(a aVar, f fVar) {
        k.e(aVar, "registry");
        k.e(fVar, "lifecycle");
        if (!this.f2549g) {
            this.f2549g = true;
            fVar.a(this);
            aVar.h(this.f2547e, this.f2548f.c());
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner".toString());
    }

    public final u c() {
        return this.f2548f;
    }

    public final boolean d() {
        return this.f2549g;
    }
}
