package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.e;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f;
import androidx.fragment.app.w;
import androidx.fragment.app.x;
import androidx.lifecycle.e0;
import androidx.lifecycle.f;
import com.yalantis.ucrop.view.CropImageView;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class n {
    private static boolean O = false;
    static boolean P = true;
    private androidx.activity.result.c<androidx.activity.result.e> A;
    private androidx.activity.result.c<String[]> B;
    ArrayDeque<l> C = new ArrayDeque<>();
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private ArrayList<a> I;
    private ArrayList<Boolean> J;
    private ArrayList<Fragment> K;
    private ArrayList<p> L;
    private q M;
    private Runnable N = new g();

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<C0038n> f2329a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f2330b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final v f2331c = new v();

    /* renamed from: d  reason: collision with root package name */
    ArrayList<a> f2332d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<Fragment> f2333e;

    /* renamed from: f  reason: collision with root package name */
    private final l f2334f = new l(this);

    /* renamed from: g  reason: collision with root package name */
    private OnBackPressedDispatcher f2335g;

    /* renamed from: h  reason: collision with root package name */
    private final androidx.activity.j f2336h = new c(false);

    /* renamed from: i  reason: collision with root package name */
    private final AtomicInteger f2337i = new AtomicInteger();
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final Map<String, Bundle> f2338j = Collections.synchronizedMap(new HashMap());
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final Map<String, Object> f2339k = Collections.synchronizedMap(new HashMap());

    /* renamed from: l  reason: collision with root package name */
    private ArrayList<m> f2340l;

    /* renamed from: m  reason: collision with root package name */
    private Map<Fragment, HashSet<androidx.core.os.e>> f2341m = Collections.synchronizedMap(new HashMap());

    /* renamed from: n  reason: collision with root package name */
    private final x.g f2342n = new d();

    /* renamed from: o  reason: collision with root package name */
    private final m f2343o = new m(this);

    /* renamed from: p  reason: collision with root package name */
    private final CopyOnWriteArrayList<r> f2344p = new CopyOnWriteArrayList<>();

    /* renamed from: q  reason: collision with root package name */
    int f2345q = -1;

    /* renamed from: r  reason: collision with root package name */
    private k<?> f2346r;

    /* renamed from: s  reason: collision with root package name */
    private g f2347s;

    /* renamed from: t  reason: collision with root package name */
    private Fragment f2348t;

    /* renamed from: u  reason: collision with root package name */
    Fragment f2349u;

    /* renamed from: v  reason: collision with root package name */
    private j f2350v = null;

    /* renamed from: w  reason: collision with root package name */
    private j f2351w = new e();

    /* renamed from: x  reason: collision with root package name */
    private d0 f2352x = null;

    /* renamed from: y  reason: collision with root package name */
    private d0 f2353y = new f();

    /* renamed from: z  reason: collision with root package name */
    private androidx.activity.result.c<Intent> f2354z;

    class a implements androidx.activity.result.b<androidx.activity.result.a> {
        a() {
        }

        /* renamed from: b */
        public void a(androidx.activity.result.a aVar) {
            l pollFirst = n.this.C.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = pollFirst.f2369e;
            int i5 = pollFirst.f2370f;
            Fragment i6 = n.this.f2331c.i(str);
            if (i6 == null) {
                Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
                return;
            }
            i6.onActivityResult(i5, aVar.b(), aVar.a());
        }
    }

    class b implements androidx.activity.result.b<Map<String, Boolean>> {
        b() {
        }

        /* renamed from: b */
        public void a(Map<String, Boolean> map) {
            StringBuilder sb;
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                iArr[i5] = ((Boolean) arrayList.get(i5)).booleanValue() ? 0 : -1;
            }
            l pollFirst = n.this.C.pollFirst();
            if (pollFirst == null) {
                sb = new StringBuilder();
                sb.append("No permissions were requested for ");
                sb.append(this);
            } else {
                String str = pollFirst.f2369e;
                int i6 = pollFirst.f2370f;
                Fragment i7 = n.this.f2331c.i(str);
                if (i7 == null) {
                    sb = new StringBuilder();
                    sb.append("Permission request result delivered for unknown Fragment ");
                    sb.append(str);
                } else {
                    i7.onRequestPermissionsResult(i6, strArr, iArr);
                    return;
                }
            }
            Log.w("FragmentManager", sb.toString());
        }
    }

    class c extends androidx.activity.j {
        c(boolean z4) {
            super(z4);
        }

        public void handleOnBackPressed() {
            n.this.B0();
        }
    }

    class d implements x.g {
        d() {
        }

        public void a(Fragment fragment, androidx.core.os.e eVar) {
            if (!eVar.b()) {
                n.this.b1(fragment, eVar);
            }
        }

        public void b(Fragment fragment, androidx.core.os.e eVar) {
            n.this.f(fragment, eVar);
        }
    }

    class e extends j {
        e() {
        }

        public Fragment a(ClassLoader classLoader, String str) {
            return n.this.t0().b(n.this.t0().f(), str, (Bundle) null);
        }
    }

    class f implements d0 {
        f() {
        }

        public c0 a(ViewGroup viewGroup) {
            return new c(viewGroup);
        }
    }

    class g implements Runnable {
        g() {
        }

        public void run() {
            n.this.b0(true);
        }
    }

    class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2362a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f2363b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Fragment f2364c;

        h(ViewGroup viewGroup, View view, Fragment fragment) {
            this.f2362a = viewGroup;
            this.f2363b = view;
            this.f2364c = fragment;
        }

        public void onAnimationEnd(Animator animator) {
            this.f2362a.endViewTransition(this.f2363b);
            animator.removeListener(this);
            Fragment fragment = this.f2364c;
            View view = fragment.mView;
            if (view != null && fragment.mHidden) {
                view.setVisibility(8);
            }
        }
    }

    class i implements r {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Fragment f2366e;

        i(Fragment fragment) {
            this.f2366e = fragment;
        }

        public void a(n nVar, Fragment fragment) {
            this.f2366e.onAttachFragment(fragment);
        }
    }

    class j implements androidx.activity.result.b<androidx.activity.result.a> {
        j() {
        }

        /* renamed from: b */
        public void a(androidx.activity.result.a aVar) {
            l pollFirst = n.this.C.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = pollFirst.f2369e;
            int i5 = pollFirst.f2370f;
            Fragment i6 = n.this.f2331c.i(str);
            if (i6 == null) {
                Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
                return;
            }
            i6.onActivityResult(i5, aVar.b(), aVar.a());
        }
    }

    static class k extends c.a<androidx.activity.result.e, androidx.activity.result.a> {
        k() {
        }

        /* renamed from: d */
        public Intent a(Context context, androidx.activity.result.e eVar) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent a5 = eVar.a();
            if (!(a5 == null || (bundleExtra = a5.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) == null)) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                a5.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (a5.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    eVar = new e.a(eVar.d()).b((Intent) null).c(eVar.c(), eVar.b()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", eVar);
            if (n.F0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        /* renamed from: e */
        public androidx.activity.result.a c(int i5, Intent intent) {
            return new androidx.activity.result.a(i5, intent);
        }
    }

    static class l implements Parcelable {
        public static final Parcelable.Creator<l> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        String f2369e;

        /* renamed from: f  reason: collision with root package name */
        int f2370f;

        class a implements Parcelable.Creator<l> {
            a() {
            }

            /* renamed from: a */
            public l createFromParcel(Parcel parcel) {
                return new l(parcel);
            }

            /* renamed from: b */
            public l[] newArray(int i5) {
                return new l[i5];
            }
        }

        l(Parcel parcel) {
            this.f2369e = parcel.readString();
            this.f2370f = parcel.readInt();
        }

        l(String str, int i5) {
            this.f2369e = str;
            this.f2370f = i5;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i5) {
            parcel.writeString(this.f2369e);
            parcel.writeInt(this.f2370f);
        }
    }

    public interface m {
        void onBackStackChanged();
    }

    /* renamed from: androidx.fragment.app.n$n  reason: collision with other inner class name */
    interface C0038n {
        boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2);
    }

    private class o implements C0038n {

        /* renamed from: a  reason: collision with root package name */
        final String f2371a;

        /* renamed from: b  reason: collision with root package name */
        final int f2372b;

        /* renamed from: c  reason: collision with root package name */
        final int f2373c;

        o(String str, int i5, int i6) {
            this.f2371a = str;
            this.f2372b = i5;
            this.f2373c = i6;
        }

        public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = n.this.f2349u;
            if (fragment != null && this.f2372b < 0 && this.f2371a == null && fragment.getChildFragmentManager().X0()) {
                return false;
            }
            return n.this.Z0(arrayList, arrayList2, this.f2371a, this.f2372b, this.f2373c);
        }
    }

    static class p implements Fragment.l {

        /* renamed from: a  reason: collision with root package name */
        final boolean f2375a;

        /* renamed from: b  reason: collision with root package name */
        final a f2376b;

        /* renamed from: c  reason: collision with root package name */
        private int f2377c;

        p(a aVar, boolean z4) {
            this.f2375a = z4;
            this.f2376b = aVar;
        }

        public void a() {
            int i5 = this.f2377c - 1;
            this.f2377c = i5;
            if (i5 == 0) {
                this.f2376b.f2175t.j1();
            }
        }

        public void b() {
            this.f2377c++;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            a aVar = this.f2376b;
            aVar.f2175t.u(aVar, this.f2375a, false, false);
        }

        /* access modifiers changed from: package-private */
        public void d() {
            boolean z4 = this.f2377c > 0;
            for (Fragment next : this.f2376b.f2175t.s0()) {
                next.setOnStartEnterTransitionListener((Fragment.l) null);
                if (z4 && next.isPostponed()) {
                    next.startPostponedEnterTransition();
                }
            }
            a aVar = this.f2376b;
            aVar.f2175t.u(aVar, this.f2375a, !z4, true);
        }

        public boolean e() {
            return this.f2377c == 0;
        }
    }

    static boolean F0(int i5) {
        return O || Log.isLoggable("FragmentManager", i5);
    }

    private boolean G0(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.o();
    }

    private void M(Fragment fragment) {
        if (fragment != null && fragment.equals(g0(fragment.mWho))) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    private void O0(m.b<Fragment> bVar) {
        int size = bVar.size();
        for (int i5 = 0; i5 < size; i5++) {
            Fragment o5 = bVar.o(i5);
            if (!o5.mAdded) {
                View requireView = o5.requireView();
                o5.mPostponedAlpha = requireView.getAlpha();
                requireView.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
            }
        }
    }

    /* JADX INFO: finally extract failed */
    private void T(int i5) {
        try {
            this.f2330b = true;
            this.f2331c.d(i5);
            Q0(i5, false);
            if (P) {
                for (c0 j5 : s()) {
                    j5.j();
                }
            }
            this.f2330b = false;
            b0(true);
        } catch (Throwable th) {
            this.f2330b = false;
            throw th;
        }
    }

    private void W() {
        if (this.H) {
            this.H = false;
            p1();
        }
    }

    private void Y() {
        if (P) {
            for (c0 j5 : s()) {
                j5.j();
            }
        } else if (!this.f2341m.isEmpty()) {
            for (Fragment next : this.f2341m.keySet()) {
                n(next);
                R0(next);
            }
        }
    }

    private boolean Y0(String str, int i5, int i6) {
        b0(false);
        a0(true);
        Fragment fragment = this.f2349u;
        if (fragment != null && i5 < 0 && str == null && fragment.getChildFragmentManager().X0()) {
            return true;
        }
        boolean Z0 = Z0(this.I, this.J, str, i5, i6);
        if (Z0) {
            this.f2330b = true;
            try {
                d1(this.I, this.J);
            } finally {
                q();
            }
        }
        q1();
        W();
        this.f2331c.b();
        return Z0;
    }

    private void a0(boolean z4) {
        if (this.f2330b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.f2346r == null) {
            if (this.G) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() == this.f2346r.g().getLooper()) {
            if (!z4) {
                p();
            }
            if (this.I == null) {
                this.I = new ArrayList<>();
                this.J = new ArrayList<>();
            }
            this.f2330b = true;
            try {
                f0((ArrayList<a>) null, (ArrayList<Boolean>) null);
            } finally {
                this.f2330b = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    private int a1(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i5, int i6, m.b<Fragment> bVar) {
        int i7 = i6;
        for (int i8 = i6 - 1; i8 >= i5; i8--) {
            a aVar = arrayList.get(i8);
            boolean booleanValue = arrayList2.get(i8).booleanValue();
            if (aVar.x() && !aVar.v(arrayList, i8 + 1, i6)) {
                if (this.L == null) {
                    this.L = new ArrayList<>();
                }
                p pVar = new p(aVar, booleanValue);
                this.L.add(pVar);
                aVar.z(pVar);
                if (booleanValue) {
                    aVar.q();
                } else {
                    aVar.r(false);
                }
                i7--;
                if (i8 != i7) {
                    arrayList.remove(i8);
                    arrayList.add(i7, aVar);
                }
                d(bVar);
            }
        }
        return i7;
    }

    private void d(m.b<Fragment> bVar) {
        int i5 = this.f2345q;
        if (i5 >= 1) {
            int min = Math.min(i5, 5);
            for (Fragment next : this.f2331c.n()) {
                if (next.mState < min) {
                    S0(next, min);
                    if (next.mView != null && !next.mHidden && next.mIsNewlyAdded) {
                        bVar.add(next);
                    }
                }
            }
        }
    }

    private static void d0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i5, int i6) {
        while (i5 < i6) {
            a aVar = arrayList.get(i5);
            boolean z4 = true;
            if (arrayList2.get(i5).booleanValue()) {
                aVar.m(-1);
                if (i5 != i6 - 1) {
                    z4 = false;
                }
                aVar.r(z4);
            } else {
                aVar.m(1);
                aVar.q();
            }
            i5++;
        }
    }

    private void d1(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                f0(arrayList, arrayList2);
                int size = arrayList.size();
                int i5 = 0;
                int i6 = 0;
                while (i5 < size) {
                    if (!arrayList.get(i5).f2435r) {
                        if (i6 != i5) {
                            e0(arrayList, arrayList2, i6, i5);
                        }
                        i6 = i5 + 1;
                        if (arrayList2.get(i5).booleanValue()) {
                            while (i6 < size && arrayList2.get(i6).booleanValue() && !arrayList.get(i6).f2435r) {
                                i6++;
                            }
                        }
                        e0(arrayList, arrayList2, i5, i6);
                        i5 = i6 - 1;
                    }
                    i5++;
                }
                if (i6 != size) {
                    e0(arrayList, arrayList2, i6, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v4, resolved type: int} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e0(java.util.ArrayList<androidx.fragment.app.a> r18, java.util.ArrayList<java.lang.Boolean> r19, int r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            r15 = r18
            r5 = r19
            r4 = r20
            r3 = r21
            java.lang.Object r0 = r15.get(r4)
            androidx.fragment.app.a r0 = (androidx.fragment.app.a) r0
            boolean r2 = r0.f2435r
            java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r6.K
            if (r0 != 0) goto L_0x001e
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r6.K = r0
            goto L_0x0021
        L_0x001e:
            r0.clear()
        L_0x0021:
            java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r6.K
            androidx.fragment.app.v r1 = r6.f2331c
            java.util.List r1 = r1.n()
            r0.addAll(r1)
            androidx.fragment.app.Fragment r0 = r17.x0()
            r1 = 0
            r16 = r1
            r7 = r4
        L_0x0034:
            r14 = 1
            if (r7 >= r3) goto L_0x0065
            java.lang.Object r8 = r15.get(r7)
            androidx.fragment.app.a r8 = (androidx.fragment.app.a) r8
            java.lang.Object r9 = r5.get(r7)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L_0x0050
            java.util.ArrayList<androidx.fragment.app.Fragment> r9 = r6.K
            androidx.fragment.app.Fragment r0 = r8.s(r9, r0)
            goto L_0x0056
        L_0x0050:
            java.util.ArrayList<androidx.fragment.app.Fragment> r9 = r6.K
            androidx.fragment.app.Fragment r0 = r8.A(r9, r0)
        L_0x0056:
            if (r16 != 0) goto L_0x0060
            boolean r8 = r8.f2426i
            if (r8 == 0) goto L_0x005d
            goto L_0x0060
        L_0x005d:
            r16 = r1
            goto L_0x0062
        L_0x0060:
            r16 = r14
        L_0x0062:
            int r7 = r7 + 1
            goto L_0x0034
        L_0x0065:
            java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r6.K
            r0.clear()
            if (r2 != 0) goto L_0x00bd
            int r0 = r6.f2345q
            if (r0 < r14) goto L_0x00bd
            boolean r0 = P
            if (r0 == 0) goto L_0x00a4
            r0 = r4
        L_0x0075:
            if (r0 >= r3) goto L_0x00bd
            java.lang.Object r1 = r15.get(r0)
            androidx.fragment.app.a r1 = (androidx.fragment.app.a) r1
            java.util.ArrayList<androidx.fragment.app.w$a> r1 = r1.f2420c
            java.util.Iterator r1 = r1.iterator()
        L_0x0083:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x00a1
            java.lang.Object r7 = r1.next()
            androidx.fragment.app.w$a r7 = (androidx.fragment.app.w.a) r7
            androidx.fragment.app.Fragment r7 = r7.f2438b
            if (r7 == 0) goto L_0x0083
            androidx.fragment.app.n r8 = r7.mFragmentManager
            if (r8 == 0) goto L_0x0083
            androidx.fragment.app.u r7 = r6.w(r7)
            androidx.fragment.app.v r8 = r6.f2331c
            r8.p(r7)
            goto L_0x0083
        L_0x00a1:
            int r0 = r0 + 1
            goto L_0x0075
        L_0x00a4:
            androidx.fragment.app.k<?> r0 = r6.f2346r
            android.content.Context r7 = r0.f()
            androidx.fragment.app.g r8 = r6.f2347s
            r13 = 0
            androidx.fragment.app.x$g r0 = r6.f2342n
            r9 = r18
            r10 = r19
            r11 = r20
            r12 = r21
            r1 = r14
            r14 = r0
            androidx.fragment.app.x.B(r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x00be
        L_0x00bd:
            r1 = r14
        L_0x00be:
            d0(r18, r19, r20, r21)
            boolean r0 = P
            if (r0 == 0) goto L_0x0143
            int r0 = r3 + -1
            java.lang.Object r0 = r5.get(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r2 = r4
        L_0x00d2:
            if (r2 >= r3) goto L_0x011c
            java.lang.Object r7 = r15.get(r2)
            androidx.fragment.app.a r7 = (androidx.fragment.app.a) r7
            if (r0 == 0) goto L_0x00fb
            java.util.ArrayList<androidx.fragment.app.w$a> r8 = r7.f2420c
            int r8 = r8.size()
            int r8 = r8 - r1
        L_0x00e3:
            if (r8 < 0) goto L_0x0119
            java.util.ArrayList<androidx.fragment.app.w$a> r9 = r7.f2420c
            java.lang.Object r9 = r9.get(r8)
            androidx.fragment.app.w$a r9 = (androidx.fragment.app.w.a) r9
            androidx.fragment.app.Fragment r9 = r9.f2438b
            if (r9 == 0) goto L_0x00f8
            androidx.fragment.app.u r9 = r6.w(r9)
            r9.m()
        L_0x00f8:
            int r8 = r8 + -1
            goto L_0x00e3
        L_0x00fb:
            java.util.ArrayList<androidx.fragment.app.w$a> r7 = r7.f2420c
            java.util.Iterator r7 = r7.iterator()
        L_0x0101:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0119
            java.lang.Object r8 = r7.next()
            androidx.fragment.app.w$a r8 = (androidx.fragment.app.w.a) r8
            androidx.fragment.app.Fragment r8 = r8.f2438b
            if (r8 == 0) goto L_0x0101
            androidx.fragment.app.u r8 = r6.w(r8)
            r8.m()
            goto L_0x0101
        L_0x0119:
            int r2 = r2 + 1
            goto L_0x00d2
        L_0x011c:
            int r2 = r6.f2345q
            r6.Q0(r2, r1)
            java.util.Set r1 = r6.t(r15, r4, r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x0129:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x013f
            java.lang.Object r2 = r1.next()
            androidx.fragment.app.c0 r2 = (androidx.fragment.app.c0) r2
            r2.r(r0)
            r2.p()
            r2.g()
            goto L_0x0129
        L_0x013f:
            r0 = r3
            r3 = r5
            goto L_0x0199
        L_0x0143:
            if (r2 == 0) goto L_0x0165
            m.b r7 = new m.b
            r7.<init>()
            r6.d(r7)
            r0 = r17
            r14 = r1
            r1 = r18
            r8 = r2
            r2 = r19
            r13 = r3
            r3 = r20
            r12 = r4
            r4 = r21
            r11 = r5
            r5 = r7
            int r0 = r0.a1(r1, r2, r3, r4, r5)
            r6.O0(r7)
            goto L_0x016b
        L_0x0165:
            r14 = r1
            r8 = r2
            r13 = r3
            r12 = r4
            r11 = r5
            r0 = r13
        L_0x016b:
            if (r0 == r12) goto L_0x0197
            if (r8 == 0) goto L_0x0197
            int r1 = r6.f2345q
            if (r1 < r14) goto L_0x018e
            androidx.fragment.app.k<?> r1 = r6.f2346r
            android.content.Context r7 = r1.f()
            androidx.fragment.app.g r8 = r6.f2347s
            r1 = 1
            androidx.fragment.app.x$g r2 = r6.f2342n
            r9 = r18
            r10 = r19
            r3 = r11
            r11 = r20
            r12 = r0
            r0 = r13
            r13 = r1
            r1 = r14
            r14 = r2
            androidx.fragment.app.x.B(r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x0191
        L_0x018e:
            r3 = r11
            r0 = r13
            r1 = r14
        L_0x0191:
            int r2 = r6.f2345q
            r6.Q0(r2, r1)
            goto L_0x0199
        L_0x0197:
            r3 = r11
            r0 = r13
        L_0x0199:
            r1 = r20
        L_0x019b:
            if (r1 >= r0) goto L_0x01bc
            java.lang.Object r2 = r15.get(r1)
            androidx.fragment.app.a r2 = (androidx.fragment.app.a) r2
            java.lang.Object r4 = r3.get(r1)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x01b6
            int r4 = r2.f2177v
            if (r4 < 0) goto L_0x01b6
            r4 = -1
            r2.f2177v = r4
        L_0x01b6:
            r2.y()
            int r1 = r1 + 1
            goto L_0x019b
        L_0x01bc:
            if (r16 == 0) goto L_0x01c1
            r17.f1()
        L_0x01c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.n.e0(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    private void f0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<p> arrayList3 = this.L;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i5 = 0;
        while (i5 < size) {
            p pVar = this.L.get(i5);
            if (arrayList == null || pVar.f2375a || (indexOf2 = arrayList.indexOf(pVar.f2376b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf2).booleanValue()) {
                if (pVar.e() || (arrayList != null && pVar.f2376b.v(arrayList, 0, arrayList.size()))) {
                    this.L.remove(i5);
                    i5--;
                    size--;
                    if (arrayList == null || pVar.f2375a || (indexOf = arrayList.indexOf(pVar.f2376b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf).booleanValue()) {
                        pVar.d();
                    }
                }
                i5++;
            } else {
                this.L.remove(i5);
                i5--;
                size--;
            }
            pVar.c();
            i5++;
        }
    }

    private void f1() {
        if (this.f2340l != null) {
            for (int i5 = 0; i5 < this.f2340l.size(); i5++) {
                this.f2340l.get(i5).onBackStackChanged();
            }
        }
    }

    static int h1(int i5) {
        if (i5 == 4097) {
            return 8194;
        }
        if (i5 != 4099) {
            return i5 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    private void k0() {
        if (P) {
            for (c0 k5 : s()) {
                k5.k();
            }
        } else if (this.L != null) {
            while (!this.L.isEmpty()) {
                this.L.remove(0).d();
            }
        }
    }

    private boolean l0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.f2329a) {
            if (this.f2329a.isEmpty()) {
                return false;
            }
            int size = this.f2329a.size();
            boolean z4 = false;
            for (int i5 = 0; i5 < size; i5++) {
                z4 |= this.f2329a.get(i5).a(arrayList, arrayList2);
            }
            this.f2329a.clear();
            this.f2346r.g().removeCallbacks(this.N);
            return z4;
        }
    }

    private void n(Fragment fragment) {
        HashSet hashSet = this.f2341m.get(fragment);
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((androidx.core.os.e) it.next()).a();
            }
            hashSet.clear();
            x(fragment);
            this.f2341m.remove(fragment);
        }
    }

    private q n0(Fragment fragment) {
        return this.M.i(fragment);
    }

    private void n1(Fragment fragment) {
        ViewGroup p02 = p0(fragment);
        if (p02 != null && fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() > 0) {
            int i5 = u.b.f7056c;
            if (p02.getTag(i5) == null) {
                p02.setTag(i5, fragment);
            }
            ((Fragment) p02.getTag(i5)).setPopDirection(fragment.getPopDirection());
        }
    }

    private void p() {
        if (K0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private ViewGroup p0(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.f2347s.d()) {
            View c5 = this.f2347s.c(fragment.mContainerId);
            if (c5 instanceof ViewGroup) {
                return (ViewGroup) c5;
            }
        }
        return null;
    }

    private void p1() {
        for (u V0 : this.f2331c.k()) {
            V0(V0);
        }
    }

    private void q() {
        this.f2330b = false;
        this.J.clear();
        this.I.clear();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (m0() <= 0) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (I0(r3.f2348t) == false) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        r0.setEnabled(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r0 = r3.f2336h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void q1() {
        /*
            r3 = this;
            java.util.ArrayList<androidx.fragment.app.n$n> r0 = r3.f2329a
            monitor-enter(r0)
            java.util.ArrayList<androidx.fragment.app.n$n> r1 = r3.f2329a     // Catch:{ all -> 0x002a }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x002a }
            r2 = 1
            if (r1 != 0) goto L_0x0013
            androidx.activity.j r1 = r3.f2336h     // Catch:{ all -> 0x002a }
            r1.setEnabled(r2)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            androidx.activity.j r0 = r3.f2336h
            int r1 = r3.m0()
            if (r1 <= 0) goto L_0x0025
            androidx.fragment.app.Fragment r1 = r3.f2348t
            boolean r1 = r3.I0(r1)
            if (r1 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r2 = 0
        L_0x0026:
            r0.setEnabled(r2)
            return
        L_0x002a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.n.q1():void");
    }

    private Set<c0> s() {
        HashSet hashSet = new HashSet();
        for (u k5 : this.f2331c.k()) {
            ViewGroup viewGroup = k5.k().mContainer;
            if (viewGroup != null) {
                hashSet.add(c0.o(viewGroup, y0()));
            }
        }
        return hashSet;
    }

    private Set<c0> t(ArrayList<a> arrayList, int i5, int i6) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i5 < i6) {
            Iterator<w.a> it = arrayList.get(i5).f2420c.iterator();
            while (it.hasNext()) {
                Fragment fragment = it.next().f2438b;
                if (!(fragment == null || (viewGroup = fragment.mContainer) == null)) {
                    hashSet.add(c0.n(viewGroup, this));
                }
            }
            i5++;
        }
        return hashSet;
    }

    private void v(Fragment fragment) {
        Animator animator;
        if (fragment.mView != null) {
            f.d c5 = f.c(this.f2346r.f(), fragment, !fragment.mHidden, fragment.getPopDirection());
            if (c5 == null || (animator = c5.f2306b) == null) {
                if (c5 != null) {
                    fragment.mView.startAnimation(c5.f2305a);
                    c5.f2305a.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                animator.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    ViewGroup viewGroup = fragment.mContainer;
                    View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    c5.f2306b.addListener(new h(viewGroup, view, fragment));
                }
                c5.f2306b.start();
            }
        }
        D0(fragment);
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    private void x(Fragment fragment) {
        fragment.performDestroyView();
        this.f2343o.n(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.i(null);
        fragment.mInLayout = false;
    }

    static Fragment z0(View view) {
        Object tag = view.getTag(u.b.f7054a);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void A() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        T(0);
    }

    /* access modifiers changed from: package-private */
    public e0 A0(Fragment fragment) {
        return this.M.l(fragment);
    }

    /* access modifiers changed from: package-private */
    public void B(Configuration configuration) {
        for (Fragment next : this.f2331c.n()) {
            if (next != null) {
                next.performConfigurationChanged(configuration);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void B0() {
        b0(true);
        if (this.f2336h.isEnabled()) {
            X0();
        } else {
            this.f2335g.e();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean C(MenuItem menuItem) {
        if (this.f2345q < 1) {
            return false;
        }
        for (Fragment next : this.f2331c.n()) {
            if (next != null && next.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void C0(Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
            n1(fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public void D() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        T(1);
    }

    /* access modifiers changed from: package-private */
    public void D0(Fragment fragment) {
        if (fragment.mAdded && G0(fragment)) {
            this.D = true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean E(Menu menu, MenuInflater menuInflater) {
        if (this.f2345q < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z4 = false;
        for (Fragment next : this.f2331c.n()) {
            if (next != null && H0(next) && next.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(next);
                z4 = true;
            }
        }
        if (this.f2333e != null) {
            for (int i5 = 0; i5 < this.f2333e.size(); i5++) {
                Fragment fragment = this.f2333e.get(i5);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.onDestroyOptionsMenu();
                }
            }
        }
        this.f2333e = arrayList;
        return z4;
    }

    public boolean E0() {
        return this.G;
    }

    /* access modifiers changed from: package-private */
    public void F() {
        this.G = true;
        b0(true);
        Y();
        T(-1);
        this.f2346r = null;
        this.f2347s = null;
        this.f2348t = null;
        if (this.f2335g != null) {
            this.f2336h.remove();
            this.f2335g = null;
        }
        androidx.activity.result.c<Intent> cVar = this.f2354z;
        if (cVar != null) {
            cVar.c();
            this.A.c();
            this.B.c();
        }
    }

    /* access modifiers changed from: package-private */
    public void G() {
        T(1);
    }

    /* access modifiers changed from: package-private */
    public void H() {
        for (Fragment next : this.f2331c.n()) {
            if (next != null) {
                next.performLowMemory();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean H0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    /* access modifiers changed from: package-private */
    public void I(boolean z4) {
        for (Fragment next : this.f2331c.n()) {
            if (next != null) {
                next.performMultiWindowModeChanged(z4);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean I0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        n nVar = fragment.mFragmentManager;
        return fragment.equals(nVar.x0()) && I0(nVar.f2348t);
    }

    /* access modifiers changed from: package-private */
    public void J(Fragment fragment) {
        Iterator<r> it = this.f2344p.iterator();
        while (it.hasNext()) {
            it.next().a(this, fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean J0(int i5) {
        return this.f2345q >= i5;
    }

    /* access modifiers changed from: package-private */
    public boolean K(MenuItem menuItem) {
        if (this.f2345q < 1) {
            return false;
        }
        for (Fragment next : this.f2331c.n()) {
            if (next != null && next.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean K0() {
        return this.E || this.F;
    }

    /* access modifiers changed from: package-private */
    public void L(Menu menu) {
        if (this.f2345q >= 1) {
            for (Fragment next : this.f2331c.n()) {
                if (next != null) {
                    next.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void L0(Fragment fragment, String[] strArr, int i5) {
        if (this.B != null) {
            this.C.addLast(new l(fragment.mWho, i5));
            this.B.a(strArr);
            return;
        }
        this.f2346r.j(fragment, strArr, i5);
    }

    /* access modifiers changed from: package-private */
    public void M0(Fragment fragment, Intent intent, int i5, Bundle bundle) {
        if (this.f2354z != null) {
            this.C.addLast(new l(fragment.mWho, i5));
            if (!(intent == null || bundle == null)) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            this.f2354z.a(intent);
            return;
        }
        this.f2346r.m(fragment, intent, i5, bundle);
    }

    /* access modifiers changed from: package-private */
    public void N() {
        T(5);
    }

    /* access modifiers changed from: package-private */
    public void N0(Fragment fragment, IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8, Bundle bundle) {
        Intent intent2;
        Fragment fragment2 = fragment;
        Bundle bundle2 = bundle;
        if (this.A != null) {
            if (bundle2 != null) {
                if (intent == null) {
                    intent2 = new Intent();
                    intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
                } else {
                    intent2 = intent;
                }
                if (F0(2)) {
                    Log.v("FragmentManager", "ActivityOptions " + bundle2 + " were added to fillInIntent " + intent2 + " for fragment " + fragment);
                }
                intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle2);
            } else {
                intent2 = intent;
            }
            IntentSender intentSender2 = intentSender;
            androidx.activity.result.e a5 = new e.a(intentSender).b(intent2).c(i7, i6).a();
            int i9 = i5;
            this.C.addLast(new l(fragment2.mWho, i5));
            if (F0(2)) {
                Log.v("FragmentManager", "Fragment " + fragment + "is launching an IntentSender for result ");
            }
            this.A.a(a5);
            return;
        }
        IntentSender intentSender3 = intentSender;
        int i10 = i5;
        int i11 = i6;
        int i12 = i7;
        this.f2346r.n(fragment, intentSender, i5, intent, i6, i7, i8, bundle);
    }

    /* access modifiers changed from: package-private */
    public void O(boolean z4) {
        for (Fragment next : this.f2331c.n()) {
            if (next != null) {
                next.performPictureInPictureModeChanged(z4);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean P(Menu menu) {
        boolean z4 = false;
        if (this.f2345q < 1) {
            return false;
        }
        for (Fragment next : this.f2331c.n()) {
            if (next != null && H0(next) && next.performPrepareOptionsMenu(menu)) {
                z4 = true;
            }
        }
        return z4;
    }

    /* access modifiers changed from: package-private */
    public void P0(Fragment fragment) {
        if (this.f2331c.c(fragment.mWho)) {
            R0(fragment);
            View view = fragment.mView;
            if (!(view == null || !fragment.mIsNewlyAdded || fragment.mContainer == null)) {
                float f5 = fragment.mPostponedAlpha;
                if (f5 > CropImageView.DEFAULT_ASPECT_RATIO) {
                    view.setAlpha(f5);
                }
                fragment.mPostponedAlpha = CropImageView.DEFAULT_ASPECT_RATIO;
                fragment.mIsNewlyAdded = false;
                f.d c5 = f.c(this.f2346r.f(), fragment, true, fragment.getPopDirection());
                if (c5 != null) {
                    Animation animation = c5.f2305a;
                    if (animation != null) {
                        fragment.mView.startAnimation(animation);
                    } else {
                        c5.f2306b.setTarget(fragment.mView);
                        c5.f2306b.start();
                    }
                }
            }
            if (fragment.mHiddenChanged) {
                v(fragment);
            }
        } else if (F0(3)) {
            Log.d("FragmentManager", "Ignoring moving " + fragment + " to state " + this.f2345q + "since it is not added to " + this);
        }
    }

    /* access modifiers changed from: package-private */
    public void Q() {
        q1();
        M(this.f2349u);
    }

    /* access modifiers changed from: package-private */
    public void Q0(int i5, boolean z4) {
        k<?> kVar;
        if (this.f2346r == null && i5 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z4 || i5 != this.f2345q) {
            this.f2345q = i5;
            if (P) {
                this.f2331c.r();
            } else {
                for (Fragment P0 : this.f2331c.n()) {
                    P0(P0);
                }
                for (u next : this.f2331c.k()) {
                    Fragment k5 = next.k();
                    if (!k5.mIsNewlyAdded) {
                        P0(k5);
                    }
                    if (k5.mRemoving && !k5.isInBackStack()) {
                        this.f2331c.q(next);
                    }
                }
            }
            p1();
            if (this.D && (kVar = this.f2346r) != null && this.f2345q == 7) {
                kVar.o();
                this.D = false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void R() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        T(7);
    }

    /* access modifiers changed from: package-private */
    public void R0(Fragment fragment) {
        S0(fragment, this.f2345q);
    }

    /* access modifiers changed from: package-private */
    public void S() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        T(5);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        if (r2 != 5) goto L_0x0164;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0160  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void S0(androidx.fragment.app.Fragment r11, int r12) {
        /*
            r10 = this;
            androidx.fragment.app.v r0 = r10.f2331c
            java.lang.String r1 = r11.mWho
            androidx.fragment.app.u r0 = r0.m(r1)
            r1 = 1
            if (r0 != 0) goto L_0x0017
            androidx.fragment.app.u r0 = new androidx.fragment.app.u
            androidx.fragment.app.m r2 = r10.f2343o
            androidx.fragment.app.v r3 = r10.f2331c
            r0.<init>(r2, r3, r11)
            r0.t(r1)
        L_0x0017:
            boolean r2 = r11.mFromLayout
            r3 = 2
            if (r2 == 0) goto L_0x0028
            boolean r2 = r11.mInLayout
            if (r2 == 0) goto L_0x0028
            int r2 = r11.mState
            if (r2 != r3) goto L_0x0028
            int r12 = java.lang.Math.max(r12, r3)
        L_0x0028:
            int r2 = r0.d()
            int r12 = java.lang.Math.min(r12, r2)
            int r2 = r11.mState
            r4 = 3
            java.lang.String r5 = "FragmentManager"
            r6 = -1
            r7 = 5
            r8 = 4
            if (r2 > r12) goto L_0x007c
            if (r2 >= r12) goto L_0x0047
            java.util.Map<androidx.fragment.app.Fragment, java.util.HashSet<androidx.core.os.e>> r2 = r10.f2341m
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0047
            r10.n(r11)
        L_0x0047:
            int r2 = r11.mState
            if (r2 == r6) goto L_0x0057
            if (r2 == 0) goto L_0x005c
            if (r2 == r1) goto L_0x0061
            if (r2 == r3) goto L_0x006b
            if (r2 == r8) goto L_0x0070
            if (r2 == r7) goto L_0x0075
            goto L_0x0164
        L_0x0057:
            if (r12 <= r6) goto L_0x005c
            r0.c()
        L_0x005c:
            if (r12 <= 0) goto L_0x0061
            r0.e()
        L_0x0061:
            if (r12 <= r6) goto L_0x0066
            r0.j()
        L_0x0066:
            if (r12 <= r1) goto L_0x006b
            r0.f()
        L_0x006b:
            if (r12 <= r3) goto L_0x0070
            r0.a()
        L_0x0070:
            if (r12 <= r8) goto L_0x0075
            r0.u()
        L_0x0075:
            if (r12 <= r7) goto L_0x0164
            r0.p()
            goto L_0x0164
        L_0x007c:
            if (r2 <= r12) goto L_0x0164
            if (r2 == 0) goto L_0x015d
            if (r2 == r1) goto L_0x014f
            if (r2 == r3) goto L_0x00c6
            if (r2 == r8) goto L_0x0097
            if (r2 == r7) goto L_0x0092
            r9 = 7
            if (r2 == r9) goto L_0x008d
            goto L_0x0164
        L_0x008d:
            if (r12 >= r9) goto L_0x0092
            r0.n()
        L_0x0092:
            if (r12 >= r7) goto L_0x0097
            r0.v()
        L_0x0097:
            if (r12 >= r8) goto L_0x00c6
            boolean r2 = F0(r4)
            if (r2 == 0) goto L_0x00b3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r7 = "movefrom ACTIVITY_CREATED: "
            r2.append(r7)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r5, r2)
        L_0x00b3:
            android.view.View r2 = r11.mView
            if (r2 == 0) goto L_0x00c6
            androidx.fragment.app.k<?> r2 = r10.f2346r
            boolean r2 = r2.k(r11)
            if (r2 == 0) goto L_0x00c6
            android.util.SparseArray<android.os.Parcelable> r2 = r11.mSavedViewState
            if (r2 != 0) goto L_0x00c6
            r0.s()
        L_0x00c6:
            if (r12 >= r3) goto L_0x014f
            r2 = 0
            android.view.View r7 = r11.mView
            if (r7 == 0) goto L_0x0144
            android.view.ViewGroup r8 = r11.mContainer
            if (r8 == 0) goto L_0x0144
            r8.endViewTransition(r7)
            android.view.View r7 = r11.mView
            r7.clearAnimation()
            boolean r7 = r11.isRemovingParent()
            if (r7 != 0) goto L_0x0144
            int r7 = r10.f2345q
            r8 = 0
            if (r7 <= r6) goto L_0x0105
            boolean r6 = r10.G
            if (r6 != 0) goto L_0x0105
            android.view.View r6 = r11.mView
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L_0x0105
            float r6 = r11.mPostponedAlpha
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 < 0) goto L_0x0105
            androidx.fragment.app.k<?> r2 = r10.f2346r
            android.content.Context r2 = r2.f()
            r6 = 0
            boolean r7 = r11.getPopDirection()
            androidx.fragment.app.f$d r2 = androidx.fragment.app.f.c(r2, r11, r6, r7)
        L_0x0105:
            r11.mPostponedAlpha = r8
            android.view.ViewGroup r6 = r11.mContainer
            android.view.View r7 = r11.mView
            if (r2 == 0) goto L_0x0112
            androidx.fragment.app.x$g r8 = r10.f2342n
            androidx.fragment.app.f.a(r11, r2, r8)
        L_0x0112:
            r6.removeView(r7)
            boolean r2 = F0(r3)
            if (r2 == 0) goto L_0x013f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Removing view "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r3 = " for fragment "
            r2.append(r3)
            r2.append(r11)
            java.lang.String r3 = " from container "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            android.util.Log.v(r5, r2)
        L_0x013f:
            android.view.ViewGroup r2 = r11.mContainer
            if (r6 == r2) goto L_0x0144
            return
        L_0x0144:
            java.util.Map<androidx.fragment.app.Fragment, java.util.HashSet<androidx.core.os.e>> r2 = r10.f2341m
            java.lang.Object r2 = r2.get(r11)
            if (r2 != 0) goto L_0x014f
            r0.h()
        L_0x014f:
            if (r12 >= r1) goto L_0x015d
            java.util.Map<androidx.fragment.app.Fragment, java.util.HashSet<androidx.core.os.e>> r2 = r10.f2341m
            java.lang.Object r2 = r2.get(r11)
            if (r2 == 0) goto L_0x015a
            goto L_0x015e
        L_0x015a:
            r0.g()
        L_0x015d:
            r1 = r12
        L_0x015e:
            if (r1 >= 0) goto L_0x0163
            r0.i()
        L_0x0163:
            r12 = r1
        L_0x0164:
            int r0 = r11.mState
            if (r0 == r12) goto L_0x0196
            boolean r0 = F0(r4)
            if (r0 == 0) goto L_0x0194
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveToState: Fragment state for "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r1 = " not updated inline; expected state "
            r0.append(r1)
            r0.append(r12)
            java.lang.String r1 = " found "
            r0.append(r1)
            int r1 = r11.mState
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r5, r0)
        L_0x0194:
            r11.mState = r12
        L_0x0196:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.n.S0(androidx.fragment.app.Fragment, int):void");
    }

    /* access modifiers changed from: package-private */
    public void T0() {
        if (this.f2346r != null) {
            this.E = false;
            this.F = false;
            this.M.o(false);
            for (Fragment next : this.f2331c.n()) {
                if (next != null) {
                    next.noteStateNotSaved();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void U() {
        this.F = true;
        this.M.o(true);
        T(4);
    }

    /* access modifiers changed from: package-private */
    public void U0(h hVar) {
        View view;
        for (u next : this.f2331c.k()) {
            Fragment k5 = next.k();
            if (k5.mContainerId == hVar.getId() && (view = k5.mView) != null && view.getParent() == null) {
                k5.mContainer = hVar;
                next.b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void V() {
        T(2);
    }

    /* access modifiers changed from: package-private */
    public void V0(u uVar) {
        Fragment k5 = uVar.k();
        if (!k5.mDeferStart) {
            return;
        }
        if (this.f2330b) {
            this.H = true;
            return;
        }
        k5.mDeferStart = false;
        if (P) {
            uVar.m();
        } else {
            R0(k5);
        }
    }

    public void W0(int i5, int i6) {
        if (i5 >= 0) {
            Z(new o((String) null, i5, i6), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i5);
    }

    public void X(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f2331c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.f2333e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i5 = 0; i5 < size2; i5++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(this.f2333e.get(i5).toString());
            }
        }
        ArrayList<a> arrayList2 = this.f2332d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i6 = 0; i6 < size; i6++) {
                a aVar = this.f2332d.get(i6);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.o(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f2337i.get());
        synchronized (this.f2329a) {
            int size3 = this.f2329a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i7 = 0; i7 < size3; i7++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i7);
                    printWriter.print(": ");
                    printWriter.println(this.f2329a.get(i7));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f2346r);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f2347s);
        if (this.f2348t != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f2348t);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f2345q);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.E);
        printWriter.print(" mStopped=");
        printWriter.print(this.F);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.G);
        if (this.D) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.D);
        }
    }

    public boolean X0() {
        return Y0((String) null, -1, 0);
    }

    /* access modifiers changed from: package-private */
    public void Z(C0038n nVar, boolean z4) {
        if (!z4) {
            if (this.f2346r != null) {
                p();
            } else if (this.G) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            } else {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
        }
        synchronized (this.f2329a) {
            if (this.f2346r != null) {
                this.f2329a.add(nVar);
                j1();
            } else if (!z4) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean Z0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, String str, int i5, int i6) {
        int i7;
        ArrayList<a> arrayList3 = this.f2332d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i5 < 0 && (i6 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f2332d.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i5 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    a aVar = this.f2332d.get(size2);
                    if ((str != null && str.equals(aVar.t())) || (i5 >= 0 && i5 == aVar.f2177v)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i6 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        a aVar2 = this.f2332d.get(size2);
                        if ((str == null || !str.equals(aVar2.t())) && (i5 < 0 || i5 != aVar2.f2177v)) {
                            break;
                        }
                    }
                }
                i7 = size2;
            } else {
                i7 = -1;
            }
            if (i7 == this.f2332d.size() - 1) {
                return false;
            }
            for (int size3 = this.f2332d.size() - 1; size3 > i7; size3--) {
                arrayList.add(this.f2332d.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public boolean b0(boolean z4) {
        a0(z4);
        boolean z5 = false;
        while (l0(this.I, this.J)) {
            this.f2330b = true;
            try {
                d1(this.I, this.J);
                q();
                z5 = true;
            } catch (Throwable th) {
                q();
                throw th;
            }
        }
        q1();
        W();
        this.f2331c.b();
        return z5;
    }

    /* access modifiers changed from: package-private */
    public void b1(Fragment fragment, androidx.core.os.e eVar) {
        HashSet hashSet = this.f2341m.get(fragment);
        if (hashSet != null && hashSet.remove(eVar) && hashSet.isEmpty()) {
            this.f2341m.remove(fragment);
            if (fragment.mState < 5) {
                x(fragment);
                R0(fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c0(C0038n nVar, boolean z4) {
        if (!z4 || (this.f2346r != null && !this.G)) {
            a0(z4);
            if (nVar.a(this.I, this.J)) {
                this.f2330b = true;
                try {
                    d1(this.I, this.J);
                } finally {
                    q();
                }
            }
            q1();
            W();
            this.f2331c.b();
        }
    }

    /* access modifiers changed from: package-private */
    public void c1(Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z4 = !fragment.isInBackStack();
        if (!fragment.mDetached || z4) {
            this.f2331c.s(fragment);
            if (G0(fragment)) {
                this.D = true;
            }
            fragment.mRemoving = true;
            n1(fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public void e(a aVar) {
        if (this.f2332d == null) {
            this.f2332d = new ArrayList<>();
        }
        this.f2332d.add(aVar);
    }

    /* access modifiers changed from: package-private */
    public void e1(Fragment fragment) {
        this.M.n(fragment);
    }

    /* access modifiers changed from: package-private */
    public void f(Fragment fragment, androidx.core.os.e eVar) {
        if (this.f2341m.get(fragment) == null) {
            this.f2341m.put(fragment, new HashSet());
        }
        this.f2341m.get(fragment).add(eVar);
    }

    /* access modifiers changed from: package-private */
    public u g(Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        u w4 = w(fragment);
        fragment.mFragmentManager = this;
        this.f2331c.p(w4);
        if (!fragment.mDetached) {
            this.f2331c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (G0(fragment)) {
                this.D = true;
            }
        }
        return w4;
    }

    /* access modifiers changed from: package-private */
    public Fragment g0(String str) {
        return this.f2331c.f(str);
    }

    /* access modifiers changed from: package-private */
    public void g1(Parcelable parcelable) {
        u uVar;
        if (parcelable != null) {
            p pVar = (p) parcelable;
            if (pVar.f2378e != null) {
                this.f2331c.t();
                Iterator<t> it = pVar.f2378e.iterator();
                while (it.hasNext()) {
                    t next = it.next();
                    if (next != null) {
                        Fragment h5 = this.M.h(next.f2395f);
                        if (h5 != null) {
                            if (F0(2)) {
                                Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + h5);
                            }
                            uVar = new u(this.f2343o, this.f2331c, h5, next);
                        } else {
                            uVar = new u(this.f2343o, this.f2331c, this.f2346r.f().getClassLoader(), q0(), next);
                        }
                        Fragment k5 = uVar.k();
                        k5.mFragmentManager = this;
                        if (F0(2)) {
                            Log.v("FragmentManager", "restoreSaveState: active (" + k5.mWho + "): " + k5);
                        }
                        uVar.o(this.f2346r.f().getClassLoader());
                        this.f2331c.p(uVar);
                        uVar.t(this.f2345q);
                    }
                }
                for (Fragment next2 : this.M.k()) {
                    if (!this.f2331c.c(next2.mWho)) {
                        if (F0(2)) {
                            Log.v("FragmentManager", "Discarding retained Fragment " + next2 + " that was not found in the set of active Fragments " + pVar.f2378e);
                        }
                        this.M.n(next2);
                        next2.mFragmentManager = this;
                        u uVar2 = new u(this.f2343o, this.f2331c, next2);
                        uVar2.t(1);
                        uVar2.m();
                        next2.mRemoving = true;
                        uVar2.m();
                    }
                }
                this.f2331c.u(pVar.f2379f);
                if (pVar.f2380g != null) {
                    this.f2332d = new ArrayList<>(pVar.f2380g.length);
                    int i5 = 0;
                    while (true) {
                        b[] bVarArr = pVar.f2380g;
                        if (i5 >= bVarArr.length) {
                            break;
                        }
                        a a5 = bVarArr[i5].a(this);
                        if (F0(2)) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i5 + " (index " + a5.f2177v + "): " + a5);
                            PrintWriter printWriter = new PrintWriter(new b0("FragmentManager"));
                            a5.p("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f2332d.add(a5);
                        i5++;
                    }
                } else {
                    this.f2332d = null;
                }
                this.f2337i.set(pVar.f2381h);
                String str = pVar.f2382i;
                if (str != null) {
                    Fragment g02 = g0(str);
                    this.f2349u = g02;
                    M(g02);
                }
                ArrayList<String> arrayList = pVar.f2383j;
                if (arrayList != null) {
                    for (int i6 = 0; i6 < arrayList.size(); i6++) {
                        Bundle bundle = pVar.f2384k.get(i6);
                        bundle.setClassLoader(this.f2346r.f().getClassLoader());
                        this.f2338j.put(arrayList.get(i6), bundle);
                    }
                }
                this.C = new ArrayDeque<>(pVar.f2385l);
            }
        }
    }

    public void h(r rVar) {
        this.f2344p.add(rVar);
    }

    public Fragment h0(int i5) {
        return this.f2331c.g(i5);
    }

    /* access modifiers changed from: package-private */
    public void i(Fragment fragment) {
        this.M.f(fragment);
    }

    public Fragment i0(String str) {
        return this.f2331c.h(str);
    }

    /* access modifiers changed from: package-private */
    public Parcelable i1() {
        int size;
        k0();
        Y();
        b0(true);
        this.E = true;
        this.M.o(true);
        ArrayList<t> v5 = this.f2331c.v();
        b[] bVarArr = null;
        if (v5.isEmpty()) {
            if (F0(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList<String> w4 = this.f2331c.w();
        ArrayList<a> arrayList = this.f2332d;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            bVarArr = new b[size];
            for (int i5 = 0; i5 < size; i5++) {
                bVarArr[i5] = new b(this.f2332d.get(i5));
                if (F0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i5 + ": " + this.f2332d.get(i5));
                }
            }
        }
        p pVar = new p();
        pVar.f2378e = v5;
        pVar.f2379f = w4;
        pVar.f2380g = bVarArr;
        pVar.f2381h = this.f2337i.get();
        Fragment fragment = this.f2349u;
        if (fragment != null) {
            pVar.f2382i = fragment.mWho;
        }
        pVar.f2383j.addAll(this.f2338j.keySet());
        pVar.f2384k.addAll(this.f2338j.values());
        pVar.f2385l = new ArrayList<>(this.C);
        return pVar;
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return this.f2337i.getAndIncrement();
    }

    /* access modifiers changed from: package-private */
    public Fragment j0(String str) {
        return this.f2331c.i(str);
    }

    /* access modifiers changed from: package-private */
    public void j1() {
        synchronized (this.f2329a) {
            ArrayList<p> arrayList = this.L;
            boolean z4 = false;
            boolean z5 = arrayList != null && !arrayList.isEmpty();
            if (this.f2329a.size() == 1) {
                z4 = true;
            }
            if (z5 || z4) {
                this.f2346r.g().removeCallbacks(this.N);
                this.f2346r.g().post(this.N);
                q1();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: androidx.activity.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v25, resolved type: androidx.fragment.app.Fragment} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k(androidx.fragment.app.k<?> r3, androidx.fragment.app.g r4, androidx.fragment.app.Fragment r5) {
        /*
            r2 = this;
            androidx.fragment.app.k<?> r0 = r2.f2346r
            if (r0 != 0) goto L_0x0103
            r2.f2346r = r3
            r2.f2347s = r4
            r2.f2348t = r5
            if (r5 == 0) goto L_0x0015
            androidx.fragment.app.n$i r4 = new androidx.fragment.app.n$i
            r4.<init>(r5)
        L_0x0011:
            r2.h(r4)
            goto L_0x001d
        L_0x0015:
            boolean r4 = r3 instanceof androidx.fragment.app.r
            if (r4 == 0) goto L_0x001d
            r4 = r3
            androidx.fragment.app.r r4 = (androidx.fragment.app.r) r4
            goto L_0x0011
        L_0x001d:
            androidx.fragment.app.Fragment r4 = r2.f2348t
            if (r4 == 0) goto L_0x0024
            r2.q1()
        L_0x0024:
            boolean r4 = r3 instanceof androidx.activity.l
            if (r4 == 0) goto L_0x0039
            r4 = r3
            androidx.activity.l r4 = (androidx.activity.l) r4
            androidx.activity.OnBackPressedDispatcher r0 = r4.getOnBackPressedDispatcher()
            r2.f2335g = r0
            if (r5 == 0) goto L_0x0034
            r4 = r5
        L_0x0034:
            androidx.activity.j r1 = r2.f2336h
            r0.b(r4, r1)
        L_0x0039:
            if (r5 == 0) goto L_0x0044
            androidx.fragment.app.n r3 = r5.mFragmentManager
            androidx.fragment.app.q r3 = r3.n0(r5)
        L_0x0041:
            r2.M = r3
            goto L_0x005a
        L_0x0044:
            boolean r4 = r3 instanceof androidx.lifecycle.f0
            if (r4 == 0) goto L_0x0053
            androidx.lifecycle.f0 r3 = (androidx.lifecycle.f0) r3
            androidx.lifecycle.e0 r3 = r3.getViewModelStore()
            androidx.fragment.app.q r3 = androidx.fragment.app.q.j(r3)
            goto L_0x0041
        L_0x0053:
            androidx.fragment.app.q r3 = new androidx.fragment.app.q
            r4 = 0
            r3.<init>(r4)
            goto L_0x0041
        L_0x005a:
            androidx.fragment.app.q r3 = r2.M
            boolean r4 = r2.K0()
            r3.o(r4)
            androidx.fragment.app.v r3 = r2.f2331c
            androidx.fragment.app.q r4 = r2.M
            r3.x(r4)
            androidx.fragment.app.k<?> r3 = r2.f2346r
            boolean r4 = r3 instanceof androidx.activity.result.d
            if (r4 == 0) goto L_0x0102
            androidx.activity.result.d r3 = (androidx.activity.result.d) r3
            androidx.activity.result.ActivityResultRegistry r3 = r3.getActivityResultRegistry()
            if (r5 == 0) goto L_0x008c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r5.mWho
            r4.append(r5)
            java.lang.String r5 = ":"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            goto L_0x008e
        L_0x008c:
            java.lang.String r4 = ""
        L_0x008e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "FragmentManager:"
            r5.append(r0)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r0 = "StartActivityForResult"
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            c.f r0 = new c.f
            r0.<init>()
            androidx.fragment.app.n$j r1 = new androidx.fragment.app.n$j
            r1.<init>()
            androidx.activity.result.c r5 = r3.j(r5, r0, r1)
            r2.f2354z = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r0 = "StartIntentSenderForResult"
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            androidx.fragment.app.n$k r0 = new androidx.fragment.app.n$k
            r0.<init>()
            androidx.fragment.app.n$a r1 = new androidx.fragment.app.n$a
            r1.<init>()
            androidx.activity.result.c r5 = r3.j(r5, r0, r1)
            r2.A = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r4 = "RequestPermissions"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            c.e r5 = new c.e
            r5.<init>()
            androidx.fragment.app.n$b r0 = new androidx.fragment.app.n$b
            r0.<init>()
            androidx.activity.result.c r3 = r3.j(r4, r5, r0)
            r2.B = r3
        L_0x0102:
            return
        L_0x0103:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Already attached"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.n.k(androidx.fragment.app.k, androidx.fragment.app.g, androidx.fragment.app.Fragment):void");
    }

    /* access modifiers changed from: package-private */
    public void k1(Fragment fragment, boolean z4) {
        ViewGroup p02 = p0(fragment);
        if (p02 != null && (p02 instanceof h)) {
            ((h) p02).setDrawDisappearingViewsLast(!z4);
        }
    }

    /* access modifiers changed from: package-private */
    public void l(Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.f2331c.a(fragment);
                if (F0(2)) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                if (G0(fragment)) {
                    this.D = true;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void l1(Fragment fragment, f.b bVar) {
        if (!fragment.equals(g0(fragment.mWho)) || !(fragment.mHost == null || fragment.mFragmentManager == this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.mMaxState = bVar;
    }

    public w m() {
        return new a(this);
    }

    public int m0() {
        ArrayList<a> arrayList = this.f2332d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void m1(Fragment fragment) {
        if (fragment == null || (fragment.equals(g0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.f2349u;
            this.f2349u = fragment;
            M(fragment2);
            M(this.f2349u);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* access modifiers changed from: package-private */
    public boolean o() {
        boolean z4 = false;
        for (Fragment next : this.f2331c.l()) {
            if (next != null) {
                z4 = G0(next);
                continue;
            }
            if (z4) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public g o0() {
        return this.f2347s;
    }

    /* access modifiers changed from: package-private */
    public void o1(Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public j q0() {
        j jVar = this.f2350v;
        if (jVar != null) {
            return jVar;
        }
        Fragment fragment = this.f2348t;
        return fragment != null ? fragment.mFragmentManager.q0() : this.f2351w;
    }

    public final void r(String str) {
        this.f2338j.remove(str);
    }

    /* access modifiers changed from: package-private */
    public v r0() {
        return this.f2331c;
    }

    public List<Fragment> s0() {
        return this.f2331c.n();
    }

    /* access modifiers changed from: package-private */
    public k<?> t0() {
        return this.f2346r;
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f2348t;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            obj = this.f2348t;
        } else {
            k<?> kVar = this.f2346r;
            if (kVar != null) {
                sb.append(kVar.getClass().getSimpleName());
                sb.append("{");
                obj = this.f2346r;
            } else {
                sb.append("null");
                sb.append("}}");
                return sb.toString();
            }
        }
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
        sb.append("}");
        sb.append("}}");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void u(a aVar, boolean z4, boolean z5, boolean z6) {
        if (z4) {
            aVar.r(z6);
        } else {
            aVar.q();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z4));
        if (z5 && this.f2345q >= 1) {
            x.B(this.f2346r.f(), this.f2347s, arrayList, arrayList2, 0, 1, true, this.f2342n);
        }
        if (z6) {
            Q0(this.f2345q, true);
        }
        for (Fragment next : this.f2331c.l()) {
            if (next != null && next.mView != null && next.mIsNewlyAdded && aVar.u(next.mContainerId)) {
                float f5 = next.mPostponedAlpha;
                if (f5 > CropImageView.DEFAULT_ASPECT_RATIO) {
                    next.mView.setAlpha(f5);
                }
                if (z6) {
                    next.mPostponedAlpha = CropImageView.DEFAULT_ASPECT_RATIO;
                } else {
                    next.mPostponedAlpha = -1.0f;
                    next.mIsNewlyAdded = false;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public LayoutInflater.Factory2 u0() {
        return this.f2334f;
    }

    /* access modifiers changed from: package-private */
    public m v0() {
        return this.f2343o;
    }

    /* access modifiers changed from: package-private */
    public u w(Fragment fragment) {
        u m5 = this.f2331c.m(fragment.mWho);
        if (m5 != null) {
            return m5;
        }
        u uVar = new u(this.f2343o, this.f2331c, fragment);
        uVar.o(this.f2346r.f().getClassLoader());
        uVar.t(this.f2345q);
        return uVar;
    }

    /* access modifiers changed from: package-private */
    public Fragment w0() {
        return this.f2348t;
    }

    public Fragment x0() {
        return this.f2349u;
    }

    /* access modifiers changed from: package-private */
    public void y(Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (F0(2)) {
                    Log.v("FragmentManager", "remove from detach: " + fragment);
                }
                this.f2331c.s(fragment);
                if (G0(fragment)) {
                    this.D = true;
                }
                n1(fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public d0 y0() {
        d0 d0Var = this.f2352x;
        if (d0Var != null) {
            return d0Var;
        }
        Fragment fragment = this.f2348t;
        return fragment != null ? fragment.mFragmentManager.y0() : this.f2353y;
    }

    /* access modifiers changed from: package-private */
    public void z() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        T(4);
    }
}
