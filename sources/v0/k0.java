package v0;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import m.a;

public final class k0 extends Fragment implements f {

    /* renamed from: h  reason: collision with root package name */
    private static final WeakHashMap f7148h = new WeakHashMap();

    /* renamed from: e  reason: collision with root package name */
    private final Map f7149e = Collections.synchronizedMap(new a());
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f7150f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Bundle f7151g;

    public static k0 f(e eVar) {
        k0 k0Var;
        WeakHashMap weakHashMap = f7148h;
        WeakReference weakReference = (WeakReference) weakHashMap.get(eVar);
        if (weakReference != null && (k0Var = (k0) weakReference.get()) != null) {
            return k0Var;
        }
        try {
            k0 k0Var2 = (k0) eVar.getSupportFragmentManager().i0("SupportLifecycleFragmentImpl");
            if (k0Var2 == null || k0Var2.isRemoving()) {
                k0Var2 = new k0();
                eVar.getSupportFragmentManager().m().d(k0Var2, "SupportLifecycleFragmentImpl").g();
            }
            weakHashMap.put(eVar, new WeakReference(k0Var2));
            return k0Var2;
        } catch (ClassCastException e5) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e5);
        }
    }

    public final void a(String str, LifecycleCallback lifecycleCallback) {
        if (!this.f7149e.containsKey(str)) {
            this.f7149e.put(str, lifecycleCallback);
            if (this.f7150f > 0) {
                new f1.e(Looper.getMainLooper()).post(new j0(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
    }

    public final <T extends LifecycleCallback> T b(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.f7149e.get(str));
    }

    public final /* synthetic */ Activity c() {
        return getActivity();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback a5 : this.f7149e.values()) {
            a5.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final void onActivityResult(int i5, int i6, Intent intent) {
        super.onActivityResult(i5, i6, intent);
        for (LifecycleCallback e5 : this.f7149e.values()) {
            e5.e(i5, i6, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7150f = 1;
        this.f7151g = bundle;
        for (Map.Entry entry : this.f7149e.entrySet()) {
            ((LifecycleCallback) entry.getValue()).f(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f7150f = 5;
        for (LifecycleCallback g5 : this.f7149e.values()) {
            g5.g();
        }
    }

    public final void onResume() {
        super.onResume();
        this.f7150f = 3;
        for (LifecycleCallback h5 : this.f7149e.values()) {
            h5.h();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry entry : this.f7149e.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) entry.getValue()).i(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.f7150f = 2;
        for (LifecycleCallback j5 : this.f7149e.values()) {
            j5.j();
        }
    }

    public final void onStop() {
        super.onStop();
        this.f7150f = 4;
        for (LifecycleCallback k5 : this.f7149e.values()) {
            k5.k();
        }
    }
}
