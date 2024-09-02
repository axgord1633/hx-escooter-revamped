package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.a0;
import androidx.lifecycle.b0;
import androidx.lifecycle.c0;
import androidx.lifecycle.e0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

final class q extends a0 {

    /* renamed from: k  reason: collision with root package name */
    private static final b0.b f2386k = new a();

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, Fragment> f2387d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<String, q> f2388e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<String, e0> f2389f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private final boolean f2390g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2391h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2392i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f2393j = false;

    class a implements b0.b {
        a() {
        }

        public <T extends a0> T a(Class<T> cls) {
            return new q(true);
        }

        public /* synthetic */ a0 b(Class cls, w.a aVar) {
            return c0.b(this, cls, aVar);
        }
    }

    q(boolean z4) {
        this.f2390g = z4;
    }

    static q j(e0 e0Var) {
        return (q) new b0(e0Var, f2386k).a(q.class);
    }

    /* access modifiers changed from: protected */
    public void d() {
        if (n.F0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f2391h = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        return this.f2387d.equals(qVar.f2387d) && this.f2388e.equals(qVar.f2388e) && this.f2389f.equals(qVar.f2389f);
    }

    /* access modifiers changed from: package-private */
    public void f(Fragment fragment) {
        if (this.f2393j) {
            if (n.F0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (!this.f2387d.containsKey(fragment.mWho)) {
            this.f2387d.put(fragment.mWho, fragment);
            if (n.F0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g(Fragment fragment) {
        if (n.F0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        q qVar = this.f2388e.get(fragment.mWho);
        if (qVar != null) {
            qVar.d();
            this.f2388e.remove(fragment.mWho);
        }
        e0 e0Var = this.f2389f.get(fragment.mWho);
        if (e0Var != null) {
            e0Var.a();
            this.f2389f.remove(fragment.mWho);
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment h(String str) {
        return this.f2387d.get(str);
    }

    public int hashCode() {
        return (((this.f2387d.hashCode() * 31) + this.f2388e.hashCode()) * 31) + this.f2389f.hashCode();
    }

    /* access modifiers changed from: package-private */
    public q i(Fragment fragment) {
        q qVar = this.f2388e.get(fragment.mWho);
        if (qVar != null) {
            return qVar;
        }
        q qVar2 = new q(this.f2390g);
        this.f2388e.put(fragment.mWho, qVar2);
        return qVar2;
    }

    /* access modifiers changed from: package-private */
    public Collection<Fragment> k() {
        return new ArrayList(this.f2387d.values());
    }

    /* access modifiers changed from: package-private */
    public e0 l(Fragment fragment) {
        e0 e0Var = this.f2389f.get(fragment.mWho);
        if (e0Var != null) {
            return e0Var;
        }
        e0 e0Var2 = new e0();
        this.f2389f.put(fragment.mWho, e0Var2);
        return e0Var2;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return this.f2391h;
    }

    /* access modifiers changed from: package-private */
    public void n(Fragment fragment) {
        if (!this.f2393j) {
            if ((this.f2387d.remove(fragment.mWho) != null) && n.F0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
            }
        } else if (n.F0(2)) {
            Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
        }
    }

    /* access modifiers changed from: package-private */
    public void o(boolean z4) {
        this.f2393j = z4;
    }

    /* access modifiers changed from: package-private */
    public boolean p(Fragment fragment) {
        if (!this.f2387d.containsKey(fragment.mWho)) {
            return true;
        }
        return this.f2390g ? this.f2391h : !this.f2392i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f2387d.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f2388e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f2389f.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
