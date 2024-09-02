package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.b0;
import androidx.lifecycle.f;
import androidx.savedstate.a;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.r;
import w.a;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    public static final a.b<y.d> f2608a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final a.b<f0> f2609b = new c();

    /* renamed from: c  reason: collision with root package name */
    public static final a.b<Bundle> f2610c = new a();

    public static final class a implements a.b<Bundle> {
        a() {
        }
    }

    public static final class b implements a.b<y.d> {
        b() {
        }
    }

    public static final class c implements a.b<f0> {
        c() {
        }
    }

    static final class d extends l implements v3.l<w.a, x> {

        /* renamed from: e  reason: collision with root package name */
        public static final d f2611e = new d();

        d() {
            super(1);
        }

        /* renamed from: a */
        public final x invoke(w.a aVar) {
            k.e(aVar, "$this$initializer");
            return new x();
        }
    }

    public static final u a(w.a aVar) {
        k.e(aVar, "<this>");
        y.d dVar = (y.d) aVar.a(f2608a);
        if (dVar != null) {
            f0 f0Var = (f0) aVar.a(f2609b);
            if (f0Var != null) {
                Bundle bundle = (Bundle) aVar.a(f2610c);
                String str = (String) aVar.a(b0.c.f2571c);
                if (str != null) {
                    return b(dVar, f0Var, str, bundle);
                }
                throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
            }
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
    }

    private static final u b(y.d dVar, f0 f0Var, String str, Bundle bundle) {
        w d5 = d(dVar);
        x e5 = e(f0Var);
        u uVar = e5.f().get(str);
        if (uVar != null) {
            return uVar;
        }
        u a5 = u.f2601f.a(d5.b(str), bundle);
        e5.f().put(str, a5);
        return a5;
    }

    public static final <T extends y.d & f0> void c(T t5) {
        k.e(t5, "<this>");
        f.b b5 = t5.getLifecycle().b();
        if (!(b5 == f.b.INITIALIZED || b5 == f.b.CREATED)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (t5.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            w wVar = new w(t5.getSavedStateRegistry(), (f0) t5);
            t5.getSavedStateRegistry().h("androidx.lifecycle.internal.SavedStateHandlesProvider", wVar);
            t5.getLifecycle().a(new SavedStateHandleAttacher(wVar));
        }
    }

    public static final w d(y.d dVar) {
        k.e(dVar, "<this>");
        a.c c5 = dVar.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        w wVar = c5 instanceof w ? (w) c5 : null;
        if (wVar != null) {
            return wVar;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final x e(f0 f0Var) {
        Class cls = x.class;
        k.e(f0Var, "<this>");
        w.c cVar = new w.c();
        cVar.a(r.b(cls), d.f2611e);
        return (x) new b0(f0Var, cVar.b()).b("androidx.lifecycle.internal.SavedStateHandlesVM", cls);
    }
}
