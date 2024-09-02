package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.f;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import androidx.savedstate.a;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import y.d;

public final class Recreator implements h {

    /* renamed from: f  reason: collision with root package name */
    public static final a f2698f = new a((g) null);

    /* renamed from: e  reason: collision with root package name */
    private final d f2699e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public static final class b implements a.c {

        /* renamed from: a  reason: collision with root package name */
        private final Set<String> f2700a = new LinkedHashSet();

        public b(a aVar) {
            k.e(aVar, "registry");
            aVar.h("androidx.savedstate.Restarter", this);
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList(this.f2700a));
            return bundle;
        }

        public final void b(String str) {
            k.e(str, "className");
            this.f2700a.add(str);
        }
    }

    public Recreator(d dVar) {
        k.e(dVar, "owner");
        this.f2699e = dVar;
    }

    private final void b(String str) {
        try {
            Class<? extends U> asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(a.C0047a.class);
            k.d(asSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Constructor<? extends U> declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    Object newInstance = declaredConstructor.newInstance(new Object[0]);
                    k.d(newInstance, "{\n                constr…wInstance()\n            }");
                    ((a.C0047a) newInstance).a(this.f2699e);
                } catch (Exception e5) {
                    throw new RuntimeException("Failed to instantiate " + str, e5);
                }
            } catch (NoSuchMethodException e6) {
                throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e6);
            }
        } catch (ClassNotFoundException e7) {
            throw new RuntimeException("Class " + str + " wasn't found", e7);
        }
    }

    public void a(j jVar, f.a aVar) {
        k.e(jVar, "source");
        k.e(aVar, "event");
        if (aVar == f.a.ON_CREATE) {
            jVar.getLifecycle().c(this);
            Bundle b5 = this.f2699e.getSavedStateRegistry().b("androidx.savedstate.Restarter");
            if (b5 != null) {
                ArrayList<String> stringArrayList = b5.getStringArrayList("classes_to_restore");
                if (stringArrayList != null) {
                    for (String b6 : stringArrayList) {
                        b(b6);
                    }
                    return;
                }
                throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            }
            return;
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }
}
