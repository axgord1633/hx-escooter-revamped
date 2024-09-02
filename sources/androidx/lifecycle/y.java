package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.b0;
import androidx.savedstate.a;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.k;
import y.d;

public final class y extends b0.d implements b0.b {

    /* renamed from: a  reason: collision with root package name */
    private Application f2618a;

    /* renamed from: b  reason: collision with root package name */
    private final b0.b f2619b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f2620c;

    /* renamed from: d  reason: collision with root package name */
    private f f2621d;

    /* renamed from: e  reason: collision with root package name */
    private a f2622e;

    public y(Application application, d dVar, Bundle bundle) {
        k.e(dVar, "owner");
        this.f2622e = dVar.getSavedStateRegistry();
        this.f2621d = dVar.getLifecycle();
        this.f2620c = bundle;
        this.f2618a = application;
        this.f2619b = application != null ? b0.a.f2564e.a(application) : new b0.a();
    }

    public <T extends a0> T a(Class<T> cls) {
        k.e(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return d(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends a0> T b(Class<T> cls, w.a aVar) {
        k.e(cls, "modelClass");
        k.e(aVar, "extras");
        String str = (String) aVar.a(b0.c.f2571c);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        } else if (aVar.a(v.f2608a) != null && aVar.a(v.f2609b) != null) {
            Application application = (Application) aVar.a(b0.a.f2566g);
            boolean isAssignableFrom = a.class.isAssignableFrom(cls);
            Constructor<T> c5 = z.c(cls, (!isAssignableFrom || application == null) ? z.f2624b : z.f2623a);
            if (c5 == null) {
                return this.f2619b.b(cls, aVar);
            }
            if (!isAssignableFrom || application == null) {
                return z.d(cls, c5, v.a(aVar));
            }
            return z.d(cls, c5, application, v.a(aVar));
        } else if (this.f2621d != null) {
            return d(str, cls);
        } else {
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
    }

    public void c(a0 a0Var) {
        k.e(a0Var, "viewModel");
        if (this.f2621d != null) {
            a aVar = this.f2622e;
            k.b(aVar);
            f fVar = this.f2621d;
            k.b(fVar);
            LegacySavedStateHandleController.a(a0Var, aVar, fVar);
        }
    }

    public final <T extends a0> T d(String str, Class<T> cls) {
        T t5;
        Application application;
        k.e(str, "key");
        k.e(cls, "modelClass");
        f fVar = this.f2621d;
        if (fVar != null) {
            boolean isAssignableFrom = a.class.isAssignableFrom(cls);
            Constructor<T> c5 = z.c(cls, (!isAssignableFrom || this.f2618a == null) ? z.f2624b : z.f2623a);
            if (c5 == null) {
                return this.f2618a != null ? this.f2619b.a(cls) : b0.c.f2569a.a().a(cls);
            }
            a aVar = this.f2622e;
            k.b(aVar);
            SavedStateHandleController b5 = LegacySavedStateHandleController.b(aVar, fVar, str, this.f2620c);
            if (!isAssignableFrom || (application = this.f2618a) == null) {
                t5 = z.d(cls, c5, b5.c());
            } else {
                k.b(application);
                t5 = z.d(cls, c5, application, b5.c());
            }
            t5.e("androidx.lifecycle.savedstate.vm.tag", b5);
            return t5;
        }
        throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }
}
