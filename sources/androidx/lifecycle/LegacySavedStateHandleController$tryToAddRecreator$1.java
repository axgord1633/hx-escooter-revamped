package androidx.lifecycle;

import androidx.lifecycle.LegacySavedStateHandleController;
import androidx.lifecycle.f;
import androidx.savedstate.a;
import kotlin.jvm.internal.k;

public final class LegacySavedStateHandleController$tryToAddRecreator$1 implements h {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ f f2521e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ a f2522f;

    LegacySavedStateHandleController$tryToAddRecreator$1(f fVar, a aVar) {
        this.f2521e = fVar;
        this.f2522f = aVar;
    }

    public void a(j jVar, f.a aVar) {
        k.e(jVar, "source");
        k.e(aVar, "event");
        if (aVar == f.a.ON_START) {
            this.f2521e.c(this);
            this.f2522f.i(LegacySavedStateHandleController.a.class);
        }
    }
}
