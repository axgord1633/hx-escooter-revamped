package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.f;
import androidx.lifecycle.j;
import androidx.savedstate.Recreator;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import y.d;

public final class a {

    /* renamed from: g  reason: collision with root package name */
    private static final b f2701g = new b((g) null);

    /* renamed from: a  reason: collision with root package name */
    private final k.b<String, c> f2702a = new k.b<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f2703b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f2704c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2705d;

    /* renamed from: e  reason: collision with root package name */
    private Recreator.b f2706e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2707f = true;

    /* renamed from: androidx.savedstate.a$a  reason: collision with other inner class name */
    public interface C0047a {
        void a(d dVar);
    }

    private static final class b {
        private b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }
    }

    public interface c {
        Bundle a();
    }

    /* access modifiers changed from: private */
    public static final void d(a aVar, j jVar, f.a aVar2) {
        boolean z4;
        k.e(aVar, "this$0");
        k.e(jVar, "<anonymous parameter 0>");
        k.e(aVar2, "event");
        if (aVar2 == f.a.ON_START) {
            z4 = true;
        } else if (aVar2 == f.a.ON_STOP) {
            z4 = false;
        } else {
            return;
        }
        aVar.f2707f = z4;
    }

    public final Bundle b(String str) {
        k.e(str, "key");
        if (this.f2705d) {
            Bundle bundle = this.f2704c;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
            Bundle bundle3 = this.f2704c;
            if (bundle3 != null) {
                bundle3.remove(str);
            }
            Bundle bundle4 = this.f2704c;
            boolean z4 = false;
            if (bundle4 != null && !bundle4.isEmpty()) {
                z4 = true;
            }
            if (!z4) {
                this.f2704c = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
    }

    public final c c(String str) {
        k.e(str, "key");
        Iterator<Map.Entry<String, c>> it = this.f2702a.iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            k.d(next, "components");
            c cVar = (c) next.getValue();
            if (k.a((String) next.getKey(), str)) {
                return cVar;
            }
        }
        return null;
    }

    public final void e(f fVar) {
        k.e(fVar, "lifecycle");
        if (!this.f2703b) {
            fVar.a(new y.b(this));
            this.f2703b = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
    }

    public final void f(Bundle bundle) {
        if (!this.f2703b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        } else if (!this.f2705d) {
            this.f2704c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
            this.f2705d = true;
        } else {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
    }

    public final void g(Bundle bundle) {
        k.e(bundle, "outBundle");
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f2704c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        k.b<K, V>.d f5 = this.f2702a.f();
        k.d(f5, "this.components.iteratorWithAdditions()");
        while (f5.hasNext()) {
            Map.Entry entry = (Map.Entry) f5.next();
            bundle2.putBundle((String) entry.getKey(), ((c) entry.getValue()).a());
        }
        if (!bundle2.isEmpty()) {
            bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
        }
    }

    public final void h(String str, c cVar) {
        k.e(str, "key");
        k.e(cVar, "provider");
        if (!(this.f2702a.m(str, cVar) == null)) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    public final void i(Class<? extends C0047a> cls) {
        k.e(cls, "clazz");
        if (this.f2707f) {
            Recreator.b bVar = this.f2706e;
            if (bVar == null) {
                bVar = new Recreator.b(this);
            }
            this.f2706e = bVar;
            try {
                cls.getDeclaredConstructor(new Class[0]);
                Recreator.b bVar2 = this.f2706e;
                if (bVar2 != null) {
                    String name = cls.getName();
                    k.d(name, "clazz.name");
                    bVar2.b(name);
                }
            } catch (NoSuchMethodException e5) {
                throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e5);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
    }
}
