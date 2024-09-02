package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.e;
import androidx.core.view.k0;
import com.yalantis.ucrop.BuildConfig;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

abstract class c0 {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f2240a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<e> f2241b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<e> f2242c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    boolean f2243d = false;

    /* renamed from: e  reason: collision with root package name */
    boolean f2244e = false;

    class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ d f2245e;

        a(d dVar) {
            this.f2245e = dVar;
        }

        public void run() {
            if (c0.this.f2241b.contains(this.f2245e)) {
                this.f2245e.e().c(this.f2245e.f().mView);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ d f2247e;

        b(d dVar) {
            this.f2247e = dVar;
        }

        public void run() {
            c0.this.f2241b.remove(this.f2247e);
            c0.this.f2242c.remove(this.f2247e);
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2249a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f2250b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        static {
            /*
                androidx.fragment.app.c0$e$b[] r0 = androidx.fragment.app.c0.e.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2250b = r0
                r1 = 1
                androidx.fragment.app.c0$e$b r2 = androidx.fragment.app.c0.e.b.ADDING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f2250b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.fragment.app.c0$e$b r3 = androidx.fragment.app.c0.e.b.REMOVING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f2250b     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.fragment.app.c0$e$b r4 = androidx.fragment.app.c0.e.b.NONE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                androidx.fragment.app.c0$e$c[] r3 = androidx.fragment.app.c0.e.c.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f2249a = r3
                androidx.fragment.app.c0$e$c r4 = androidx.fragment.app.c0.e.c.REMOVED     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f2249a     // Catch:{ NoSuchFieldError -> 0x0043 }
                androidx.fragment.app.c0$e$c r3 = androidx.fragment.app.c0.e.c.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f2249a     // Catch:{ NoSuchFieldError -> 0x004d }
                androidx.fragment.app.c0$e$c r1 = androidx.fragment.app.c0.e.c.GONE     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = f2249a     // Catch:{ NoSuchFieldError -> 0x0058 }
                androidx.fragment.app.c0$e$c r1 = androidx.fragment.app.c0.e.c.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.c0.c.<clinit>():void");
        }
    }

    private static class d extends e {

        /* renamed from: h  reason: collision with root package name */
        private final u f2251h;

        d(e.c cVar, e.b bVar, u uVar, androidx.core.os.e eVar) {
            super(cVar, bVar, uVar.k(), eVar);
            this.f2251h = uVar;
        }

        public void c() {
            super.c();
            this.f2251h.m();
        }

        /* access modifiers changed from: package-private */
        public void l() {
            if (g() == e.b.ADDING) {
                Fragment k5 = this.f2251h.k();
                View findFocus = k5.mView.findFocus();
                if (findFocus != null) {
                    k5.setFocusedView(findFocus);
                    if (n.F0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + k5);
                    }
                }
                View requireView = f().requireView();
                if (requireView.getParent() == null) {
                    this.f2251h.b();
                    requireView.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
                }
                if (requireView.getAlpha() == CropImageView.DEFAULT_ASPECT_RATIO && requireView.getVisibility() == 0) {
                    requireView.setVisibility(4);
                }
                requireView.setAlpha(k5.getPostOnViewCreatedAlpha());
            }
        }
    }

    static class e {

        /* renamed from: a  reason: collision with root package name */
        private c f2252a;

        /* renamed from: b  reason: collision with root package name */
        private b f2253b;

        /* renamed from: c  reason: collision with root package name */
        private final Fragment f2254c;

        /* renamed from: d  reason: collision with root package name */
        private final List<Runnable> f2255d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        private final HashSet<androidx.core.os.e> f2256e = new HashSet<>();

        /* renamed from: f  reason: collision with root package name */
        private boolean f2257f = false;

        /* renamed from: g  reason: collision with root package name */
        private boolean f2258g = false;

        class a implements e.b {
            a() {
            }

            public void onCancel() {
                e.this.b();
            }
        }

        enum b {
            NONE,
            ADDING,
            REMOVING
        }

        enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            static c f(int i5) {
                if (i5 == 0) {
                    return VISIBLE;
                }
                if (i5 == 4) {
                    return INVISIBLE;
                }
                if (i5 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i5);
            }

            static c i(View view) {
                return (view.getAlpha() == CropImageView.DEFAULT_ASPECT_RATIO && view.getVisibility() == 0) ? INVISIBLE : f(view.getVisibility());
            }

            /* access modifiers changed from: package-private */
            public void c(View view) {
                int i5;
                int i6 = c.f2249a[ordinal()];
                if (i6 != 1) {
                    if (i6 == 2) {
                        if (n.F0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                        }
                        i5 = 0;
                    } else if (i6 == 3) {
                        if (n.F0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                        }
                        i5 = 8;
                    } else if (i6 == 4) {
                        if (n.F0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                        }
                        view.setVisibility(4);
                        return;
                    } else {
                        return;
                    }
                    view.setVisibility(i5);
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    if (n.F0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                    }
                    viewGroup.removeView(view);
                }
            }
        }

        e(c cVar, b bVar, Fragment fragment, androidx.core.os.e eVar) {
            this.f2252a = cVar;
            this.f2253b = bVar;
            this.f2254c = fragment;
            eVar.c(new a());
        }

        /* access modifiers changed from: package-private */
        public final void a(Runnable runnable) {
            this.f2255d.add(runnable);
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            if (!h()) {
                this.f2257f = true;
                if (this.f2256e.isEmpty()) {
                    c();
                    return;
                }
                Iterator it = new ArrayList(this.f2256e).iterator();
                while (it.hasNext()) {
                    ((androidx.core.os.e) it.next()).a();
                }
            }
        }

        public void c() {
            if (!this.f2258g) {
                if (n.F0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
                }
                this.f2258g = true;
                for (Runnable run : this.f2255d) {
                    run.run();
                }
            }
        }

        public final void d(androidx.core.os.e eVar) {
            if (this.f2256e.remove(eVar) && this.f2256e.isEmpty()) {
                c();
            }
        }

        public c e() {
            return this.f2252a;
        }

        public final Fragment f() {
            return this.f2254c;
        }

        /* access modifiers changed from: package-private */
        public b g() {
            return this.f2253b;
        }

        /* access modifiers changed from: package-private */
        public final boolean h() {
            return this.f2257f;
        }

        /* access modifiers changed from: package-private */
        public final boolean i() {
            return this.f2258g;
        }

        public final void j(androidx.core.os.e eVar) {
            l();
            this.f2256e.add(eVar);
        }

        /* access modifiers changed from: package-private */
        public final void k(c cVar, b bVar) {
            b bVar2;
            int i5 = c.f2250b[bVar.ordinal()];
            if (i5 != 1) {
                if (i5 == 2) {
                    if (n.F0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f2254c + " mFinalState = " + this.f2252a + " -> REMOVED. mLifecycleImpact  = " + this.f2253b + " to REMOVING.");
                    }
                    this.f2252a = c.REMOVED;
                    bVar2 = b.REMOVING;
                } else if (i5 == 3 && this.f2252a != c.REMOVED) {
                    if (n.F0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f2254c + " mFinalState = " + this.f2252a + " -> " + cVar + ". ");
                    }
                    this.f2252a = cVar;
                    return;
                } else {
                    return;
                }
            } else if (this.f2252a == c.REMOVED) {
                if (n.F0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f2254c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f2253b + " to ADDING.");
                }
                this.f2252a = c.VISIBLE;
                bVar2 = b.ADDING;
            } else {
                return;
            }
            this.f2253b = bVar2;
        }

        /* access modifiers changed from: package-private */
        public void l() {
        }

        public String toString() {
            return "Operation " + "{" + Integer.toHexString(System.identityHashCode(this)) + "} " + "{" + "mFinalState = " + this.f2252a + "} " + "{" + "mLifecycleImpact = " + this.f2253b + "} " + "{" + "mFragment = " + this.f2254c + "}";
        }
    }

    c0(ViewGroup viewGroup) {
        this.f2240a = viewGroup;
    }

    private void a(e.c cVar, e.b bVar, u uVar) {
        synchronized (this.f2241b) {
            androidx.core.os.e eVar = new androidx.core.os.e();
            e h5 = h(uVar.k());
            if (h5 != null) {
                h5.k(cVar, bVar);
                return;
            }
            d dVar = new d(cVar, bVar, uVar, eVar);
            this.f2241b.add(dVar);
            dVar.a(new a(dVar));
            dVar.a(new b(dVar));
        }
    }

    private e h(Fragment fragment) {
        Iterator<e> it = this.f2241b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    private e i(Fragment fragment) {
        Iterator<e> it = this.f2242c.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    static c0 n(ViewGroup viewGroup, n nVar) {
        return o(viewGroup, nVar.y0());
    }

    static c0 o(ViewGroup viewGroup, d0 d0Var) {
        int i5 = u.b.f7055b;
        Object tag = viewGroup.getTag(i5);
        if (tag instanceof c0) {
            return (c0) tag;
        }
        c0 a5 = d0Var.a(viewGroup);
        viewGroup.setTag(i5, a5);
        return a5;
    }

    private void q() {
        Iterator<e> it = this.f2241b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.g() == e.b.ADDING) {
                next.k(e.c.f(next.f().requireView().getVisibility()), e.b.NONE);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(e.c cVar, u uVar) {
        if (n.F0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + uVar.k());
        }
        a(cVar, e.b.ADDING, uVar);
    }

    /* access modifiers changed from: package-private */
    public void c(u uVar) {
        if (n.F0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + uVar.k());
        }
        a(e.c.GONE, e.b.NONE, uVar);
    }

    /* access modifiers changed from: package-private */
    public void d(u uVar) {
        if (n.F0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + uVar.k());
        }
        a(e.c.REMOVED, e.b.REMOVING, uVar);
    }

    /* access modifiers changed from: package-private */
    public void e(u uVar) {
        if (n.F0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + uVar.k());
        }
        a(e.c.VISIBLE, e.b.NONE, uVar);
    }

    /* access modifiers changed from: package-private */
    public abstract void f(List<e> list, boolean z4);

    /* access modifiers changed from: package-private */
    public void g() {
        if (!this.f2244e) {
            if (!k0.A(this.f2240a)) {
                j();
                this.f2243d = false;
                return;
            }
            synchronized (this.f2241b) {
                if (!this.f2241b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.f2242c);
                    this.f2242c.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        e eVar = (e) it.next();
                        if (n.F0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + eVar);
                        }
                        eVar.b();
                        if (!eVar.i()) {
                            this.f2242c.add(eVar);
                        }
                    }
                    q();
                    ArrayList arrayList2 = new ArrayList(this.f2241b);
                    this.f2241b.clear();
                    this.f2242c.addAll(arrayList2);
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((e) it2.next()).l();
                    }
                    f(arrayList2, this.f2243d);
                    this.f2243d = false;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        String str;
        String str2;
        boolean A = k0.A(this.f2240a);
        synchronized (this.f2241b) {
            q();
            Iterator<e> it = this.f2241b.iterator();
            while (it.hasNext()) {
                it.next().l();
            }
            Iterator it2 = new ArrayList(this.f2242c).iterator();
            while (it2.hasNext()) {
                e eVar = (e) it2.next();
                if (n.F0(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (A) {
                        str2 = BuildConfig.FLAVOR;
                    } else {
                        str2 = "Container " + this.f2240a + " is not attached to window. ";
                    }
                    sb.append(str2);
                    sb.append("Cancelling running operation ");
                    sb.append(eVar);
                    Log.v("FragmentManager", sb.toString());
                }
                eVar.b();
            }
            Iterator it3 = new ArrayList(this.f2241b).iterator();
            while (it3.hasNext()) {
                e eVar2 = (e) it3.next();
                if (n.F0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (A) {
                        str = BuildConfig.FLAVOR;
                    } else {
                        str = "Container " + this.f2240a + " is not attached to window. ";
                    }
                    sb2.append(str);
                    sb2.append("Cancelling pending operation ");
                    sb2.append(eVar2);
                    Log.v("FragmentManager", sb2.toString());
                }
                eVar2.b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void k() {
        if (this.f2244e) {
            this.f2244e = false;
            g();
        }
    }

    /* access modifiers changed from: package-private */
    public e.b l(u uVar) {
        e h5 = h(uVar.k());
        if (h5 != null) {
            return h5.g();
        }
        e i5 = i(uVar.k());
        if (i5 != null) {
            return i5.g();
        }
        return null;
    }

    public ViewGroup m() {
        return this.f2240a;
    }

    /* access modifiers changed from: package-private */
    public void p() {
        synchronized (this.f2241b) {
            q();
            this.f2244e = false;
            int size = this.f2241b.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                e eVar = this.f2241b.get(size);
                e.c i5 = e.c.i(eVar.f().mView);
                e.c e5 = eVar.e();
                e.c cVar = e.c.VISIBLE;
                if (e5 == cVar && i5 != cVar) {
                    this.f2244e = eVar.f().isPostponed();
                    break;
                }
                size--;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void r(boolean z4) {
        this.f2243d = z4;
    }
}
