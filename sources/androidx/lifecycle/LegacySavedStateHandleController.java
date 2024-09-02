package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.f;
import androidx.savedstate.a;
import kotlin.jvm.internal.k;
import y.d;

public final class LegacySavedStateHandleController {

    /* renamed from: a  reason: collision with root package name */
    public static final LegacySavedStateHandleController f2520a = new LegacySavedStateHandleController();

    public static final class a implements a.C0047a {
        public void a(d dVar) {
            k.e(dVar, "owner");
            if (dVar instanceof f0) {
                e0 viewModelStore = ((f0) dVar).getViewModelStore();
                androidx.savedstate.a savedStateRegistry = dVar.getSavedStateRegistry();
                for (String b5 : viewModelStore.c()) {
                    a0 b6 = viewModelStore.b(b5);
                    k.b(b6);
                    LegacySavedStateHandleController.a(b6, savedStateRegistry, dVar.getLifecycle());
                }
                if (!viewModelStore.c().isEmpty()) {
                    savedStateRegistry.i(a.class);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
        }
    }

    private LegacySavedStateHandleController() {
    }

    public static final void a(a0 a0Var, androidx.savedstate.a aVar, f fVar) {
        k.e(a0Var, "viewModel");
        k.e(aVar, "registry");
        k.e(fVar, "lifecycle");
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) a0Var.c("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController != null && !savedStateHandleController.d()) {
            savedStateHandleController.b(aVar, fVar);
            f2520a.c(aVar, fVar);
        }
    }

    public static final SavedStateHandleController b(androidx.savedstate.a aVar, f fVar, String str, Bundle bundle) {
        k.e(aVar, "registry");
        k.e(fVar, "lifecycle");
        k.b(str);
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, u.f2601f.a(aVar.b(str), bundle));
        savedStateHandleController.b(aVar, fVar);
        f2520a.c(aVar, fVar);
        return savedStateHandleController;
    }

    private final void c(androidx.savedstate.a aVar, f fVar) {
        f.b b5 = fVar.b();
        if (b5 == f.b.INITIALIZED || b5.f(f.b.STARTED)) {
            aVar.i(a.class);
        } else {
            fVar.a(new LegacySavedStateHandleController$tryToAddRecreator$1(fVar, aVar));
        }
    }
}
