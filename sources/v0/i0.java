package v0;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import f1.e;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import m.a;

public final class i0 extends Fragment implements f {

    /* renamed from: h  reason: collision with root package name */
    private static final WeakHashMap f7141h = new WeakHashMap();

    /* renamed from: e  reason: collision with root package name */
    private final Map f7142e = Collections.synchronizedMap(new a());
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f7143f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Bundle f7144g;

    public static i0 f(Activity activity) {
        i0 i0Var;
        WeakHashMap weakHashMap = f7141h;
        WeakReference weakReference = (WeakReference) weakHashMap.get(activity);
        if (weakReference != null && (i0Var = (i0) weakReference.get()) != null) {
            return i0Var;
        }
        try {
            i0 i0Var2 = (i0) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (i0Var2 == null || i0Var2.isRemoving()) {
                i0Var2 = new i0();
                activity.getFragmentManager().beginTransaction().add(i0Var2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(activity, new WeakReference(i0Var2));
            return i0Var2;
        } catch (ClassCastException e5) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e5);
        }
    }

    public final void a(String str, LifecycleCallback lifecycleCallback) {
        if (!this.f7142e.containsKey(str)) {
            this.f7142e.put(str, lifecycleCallback);
            if (this.f7143f > 0) {
                new e(Looper.getMainLooper()).post(new h0(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
    }

    public final <T extends LifecycleCallback> T b(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.f7142e.get(str));
    }

    public final Activity c() {
        return getActivity();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback a5 : this.f7142e.values()) {
            a5.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final void onActivityResult(int i5, int i6, Intent intent) {
        super.onActivityResult(i5, i6, intent);
        for (LifecycleCallback e5 : this.f7142e.values()) {
            e5.e(i5, i6, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7143f = 1;
        this.f7144g = bundle;
        for (Map.Entry entry : this.f7142e.entrySet()) {
            ((LifecycleCallback) entry.getValue()).f(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f7143f = 5;
        for (LifecycleCallback g5 : this.f7142e.values()) {
            g5.g();
        }
    }

    public final void onResume() {
        super.onResume();
        this.f7143f = 3;
        for (LifecycleCallback h5 : this.f7142e.values()) {
            h5.h();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry entry : this.f7142e.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) entry.getValue()).i(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.f7143f = 2;
        for (LifecycleCallback j5 : this.f7142e.values()) {
            j5.j();
        }
    }

    public final void onStop() {
        super.onStop();
        this.f7143f = 4;
        for (LifecycleCallback k5 : this.f7142e.values()) {
            k5.k();
        }
    }
}
