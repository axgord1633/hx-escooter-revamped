package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.i0;
import androidx.core.view.k0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class x {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f2445a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b  reason: collision with root package name */
    static final z f2446b = new y();

    /* renamed from: c  reason: collision with root package name */
    static final z f2447c = w();

    class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ g f2448e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Fragment f2449f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ androidx.core.os.e f2450g;

        a(g gVar, Fragment fragment, androidx.core.os.e eVar) {
            this.f2448e = gVar;
            this.f2449f = fragment;
            this.f2450g = eVar;
        }

        public void run() {
            this.f2448e.a(this.f2449f, this.f2450g);
        }
    }

    class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f2451e;

        b(ArrayList arrayList) {
            this.f2451e = arrayList;
        }

        public void run() {
            x.A(this.f2451e, 4);
        }
    }

    class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ g f2452e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Fragment f2453f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ androidx.core.os.e f2454g;

        c(g gVar, Fragment fragment, androidx.core.os.e eVar) {
            this.f2452e = gVar;
            this.f2453f = fragment;
            this.f2454g = eVar;
        }

        public void run() {
            this.f2452e.a(this.f2453f, this.f2454g);
        }
    }

    class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f2455e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ z f2456f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ View f2457g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Fragment f2458h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ ArrayList f2459i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ ArrayList f2460j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ ArrayList f2461k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ Object f2462l;

        d(Object obj, z zVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f2455e = obj;
            this.f2456f = zVar;
            this.f2457g = view;
            this.f2458h = fragment;
            this.f2459i = arrayList;
            this.f2460j = arrayList2;
            this.f2461k = arrayList3;
            this.f2462l = obj2;
        }

        public void run() {
            Object obj = this.f2455e;
            if (obj != null) {
                this.f2456f.p(obj, this.f2457g);
                this.f2460j.addAll(x.k(this.f2456f, this.f2455e, this.f2458h, this.f2459i, this.f2457g));
            }
            if (this.f2461k != null) {
                if (this.f2462l != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f2457g);
                    this.f2456f.q(this.f2462l, this.f2461k, arrayList);
                }
                this.f2461k.clear();
                this.f2461k.add(this.f2457g);
            }
        }
    }

    class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Fragment f2463e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Fragment f2464f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ boolean f2465g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ m.a f2466h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ View f2467i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ z f2468j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ Rect f2469k;

        e(Fragment fragment, Fragment fragment2, boolean z4, m.a aVar, View view, z zVar, Rect rect) {
            this.f2463e = fragment;
            this.f2464f = fragment2;
            this.f2465g = z4;
            this.f2466h = aVar;
            this.f2467i = view;
            this.f2468j = zVar;
            this.f2469k = rect;
        }

        public void run() {
            x.f(this.f2463e, this.f2464f, this.f2465g, this.f2466h, false);
            View view = this.f2467i;
            if (view != null) {
                this.f2468j.k(view, this.f2469k);
            }
        }
    }

    class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ z f2470e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ m.a f2471f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Object f2472g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ h f2473h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ ArrayList f2474i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ View f2475j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ Fragment f2476k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ Fragment f2477l;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ boolean f2478m;

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ ArrayList f2479n;

        /* renamed from: o  reason: collision with root package name */
        final /* synthetic */ Object f2480o;

        /* renamed from: p  reason: collision with root package name */
        final /* synthetic */ Rect f2481p;

        f(z zVar, m.a aVar, Object obj, h hVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z4, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f2470e = zVar;
            this.f2471f = aVar;
            this.f2472g = obj;
            this.f2473h = hVar;
            this.f2474i = arrayList;
            this.f2475j = view;
            this.f2476k = fragment;
            this.f2477l = fragment2;
            this.f2478m = z4;
            this.f2479n = arrayList2;
            this.f2480o = obj2;
            this.f2481p = rect;
        }

        public void run() {
            m.a<String, View> h5 = x.h(this.f2470e, this.f2471f, this.f2472g, this.f2473h);
            if (h5 != null) {
                this.f2474i.addAll(h5.values());
                this.f2474i.add(this.f2475j);
            }
            x.f(this.f2476k, this.f2477l, this.f2478m, h5, false);
            Object obj = this.f2472g;
            if (obj != null) {
                this.f2470e.A(obj, this.f2479n, this.f2474i);
                View s5 = x.s(h5, this.f2473h, this.f2480o, this.f2478m);
                if (s5 != null) {
                    this.f2470e.k(s5, this.f2481p);
                }
            }
        }
    }

    interface g {
        void a(Fragment fragment, androidx.core.os.e eVar);

        void b(Fragment fragment, androidx.core.os.e eVar);
    }

    static class h {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f2482a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2483b;

        /* renamed from: c  reason: collision with root package name */
        public a f2484c;

        /* renamed from: d  reason: collision with root package name */
        public Fragment f2485d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2486e;

        /* renamed from: f  reason: collision with root package name */
        public a f2487f;

        h() {
        }
    }

    static void A(ArrayList<View> arrayList, int i5) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i5);
            }
        }
    }

    static void B(Context context, g gVar, ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i5, int i6, boolean z4, g gVar2) {
        ViewGroup viewGroup;
        SparseArray sparseArray = new SparseArray();
        for (int i7 = i5; i7 < i6; i7++) {
            a aVar = arrayList.get(i7);
            if (arrayList2.get(i7).booleanValue()) {
                e(aVar, sparseArray, z4);
            } else {
                c(aVar, sparseArray, z4);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(context);
            int size = sparseArray.size();
            for (int i8 = 0; i8 < size; i8++) {
                int keyAt = sparseArray.keyAt(i8);
                m.a<String, String> d5 = d(keyAt, arrayList, arrayList2, i5, i6);
                h hVar = (h) sparseArray.valueAt(i8);
                if (gVar.d() && (viewGroup = (ViewGroup) gVar.c(keyAt)) != null) {
                    if (z4) {
                        o(viewGroup, hVar, view, d5, gVar2);
                    } else {
                        n(viewGroup, hVar, view, d5, gVar2);
                    }
                }
            }
        }
    }

    private static void a(ArrayList<View> arrayList, m.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View m5 = aVar.m(size);
            if (collection.contains(k0.v(m5))) {
                arrayList.add(m5);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0039, code lost:
        if (r0.mAdded != false) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x006e, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0088, code lost:
        if (r0.mHidden == false) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x008a, code lost:
        r9 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00d7 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(androidx.fragment.app.a r8, androidx.fragment.app.w.a r9, android.util.SparseArray<androidx.fragment.app.x.h> r10, boolean r11, boolean r12) {
        /*
            androidx.fragment.app.Fragment r0 = r9.f2438b
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            int r1 = r0.mContainerId
            if (r1 != 0) goto L_0x000a
            return
        L_0x000a:
            if (r11 == 0) goto L_0x0013
            int[] r2 = f2445a
            int r9 = r9.f2437a
            r9 = r2[r9]
            goto L_0x0015
        L_0x0013:
            int r9 = r9.f2437a
        L_0x0015:
            r2 = 0
            r3 = 1
            if (r9 == r3) goto L_0x007d
            r4 = 3
            if (r9 == r4) goto L_0x0057
            r4 = 4
            if (r9 == r4) goto L_0x003f
            r4 = 5
            if (r9 == r4) goto L_0x002d
            r4 = 6
            if (r9 == r4) goto L_0x0057
            r4 = 7
            if (r9 == r4) goto L_0x007d
            r9 = r2
            r3 = r9
            r4 = r3
            goto L_0x0090
        L_0x002d:
            if (r12 == 0) goto L_0x003c
            boolean r9 = r0.mHiddenChanged
            if (r9 == 0) goto L_0x008c
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x008c
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x008c
            goto L_0x008a
        L_0x003c:
            boolean r9 = r0.mHidden
            goto L_0x008d
        L_0x003f:
            if (r12 == 0) goto L_0x004e
            boolean r9 = r0.mHiddenChanged
            if (r9 == 0) goto L_0x0070
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x0070
            boolean r9 = r0.mHidden
            if (r9 == 0) goto L_0x0070
        L_0x004d:
            goto L_0x006e
        L_0x004e:
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x0070
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x0070
            goto L_0x004d
        L_0x0057:
            boolean r9 = r0.mAdded
            if (r12 == 0) goto L_0x0072
            if (r9 != 0) goto L_0x0070
            android.view.View r9 = r0.mView
            if (r9 == 0) goto L_0x0070
            int r9 = r9.getVisibility()
            if (r9 != 0) goto L_0x0070
            float r9 = r0.mPostponedAlpha
            r4 = 0
            int r9 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r9 < 0) goto L_0x0070
        L_0x006e:
            r9 = r3
            goto L_0x0079
        L_0x0070:
            r9 = r2
            goto L_0x0079
        L_0x0072:
            if (r9 == 0) goto L_0x0070
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x0070
            goto L_0x006e
        L_0x0079:
            r4 = r9
            r9 = r3
            r3 = r2
            goto L_0x0090
        L_0x007d:
            if (r12 == 0) goto L_0x0082
            boolean r9 = r0.mIsNewlyAdded
            goto L_0x008d
        L_0x0082:
            boolean r9 = r0.mAdded
            if (r9 != 0) goto L_0x008c
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x008c
        L_0x008a:
            r9 = r3
            goto L_0x008d
        L_0x008c:
            r9 = r2
        L_0x008d:
            r4 = r2
            r2 = r9
            r9 = r4
        L_0x0090:
            java.lang.Object r5 = r10.get(r1)
            androidx.fragment.app.x$h r5 = (androidx.fragment.app.x.h) r5
            if (r2 == 0) goto L_0x00a2
            androidx.fragment.app.x$h r5 = p(r5, r10, r1)
            r5.f2482a = r0
            r5.f2483b = r11
            r5.f2484c = r8
        L_0x00a2:
            r2 = 0
            if (r12 != 0) goto L_0x00c3
            if (r3 == 0) goto L_0x00c3
            if (r5 == 0) goto L_0x00af
            androidx.fragment.app.Fragment r3 = r5.f2485d
            if (r3 != r0) goto L_0x00af
            r5.f2485d = r2
        L_0x00af:
            boolean r3 = r8.f2435r
            if (r3 != 0) goto L_0x00c3
            androidx.fragment.app.n r3 = r8.f2175t
            androidx.fragment.app.u r6 = r3.w(r0)
            androidx.fragment.app.v r7 = r3.r0()
            r7.p(r6)
            r3.R0(r0)
        L_0x00c3:
            if (r4 == 0) goto L_0x00d5
            if (r5 == 0) goto L_0x00cb
            androidx.fragment.app.Fragment r3 = r5.f2485d
            if (r3 != 0) goto L_0x00d5
        L_0x00cb:
            androidx.fragment.app.x$h r5 = p(r5, r10, r1)
            r5.f2485d = r0
            r5.f2486e = r11
            r5.f2487f = r8
        L_0x00d5:
            if (r12 != 0) goto L_0x00e1
            if (r9 == 0) goto L_0x00e1
            if (r5 == 0) goto L_0x00e1
            androidx.fragment.app.Fragment r8 = r5.f2482a
            if (r8 != r0) goto L_0x00e1
            r5.f2482a = r2
        L_0x00e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.x.b(androidx.fragment.app.a, androidx.fragment.app.w$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static void c(a aVar, SparseArray<h> sparseArray, boolean z4) {
        int size = aVar.f2420c.size();
        for (int i5 = 0; i5 < size; i5++) {
            b(aVar, aVar.f2420c.get(i5), sparseArray, false, z4);
        }
    }

    private static m.a<String, String> d(int i5, ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i6, int i7) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        m.a<String, String> aVar = new m.a<>();
        for (int i8 = i7 - 1; i8 >= i6; i8--) {
            a aVar2 = arrayList.get(i8);
            if (aVar2.u(i5)) {
                boolean booleanValue = arrayList2.get(i8).booleanValue();
                ArrayList<String> arrayList5 = aVar2.f2433p;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = aVar2.f2433p;
                        arrayList4 = aVar2.f2434q;
                    } else {
                        ArrayList<String> arrayList6 = aVar2.f2433p;
                        arrayList3 = aVar2.f2434q;
                        arrayList4 = arrayList6;
                    }
                    for (int i9 = 0; i9 < size; i9++) {
                        String str = arrayList4.get(i9);
                        String str2 = arrayList3.get(i9);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public static void e(a aVar, SparseArray<h> sparseArray, boolean z4) {
        if (aVar.f2175t.o0().d()) {
            for (int size = aVar.f2420c.size() - 1; size >= 0; size--) {
                b(aVar, aVar.f2420c.get(size), sparseArray, true, z4);
            }
        }
    }

    static void f(Fragment fragment, Fragment fragment2, boolean z4, m.a<String, View> aVar, boolean z5) {
        if (z4) {
            fragment2.getEnterTransitionCallback();
        } else {
            fragment.getEnterTransitionCallback();
        }
    }

    private static boolean g(z zVar, List<Object> list) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (!zVar.e(list.get(i5))) {
                return false;
            }
        }
        return true;
    }

    static m.a<String, View> h(z zVar, m.a<String, String> aVar, Object obj, h hVar) {
        ArrayList<String> arrayList;
        Fragment fragment = hVar.f2482a;
        View view = fragment.getView();
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        m.a<String, View> aVar2 = new m.a<>();
        zVar.j(aVar2, view);
        a aVar3 = hVar.f2484c;
        if (hVar.f2483b) {
            fragment.getExitTransitionCallback();
            arrayList = aVar3.f2433p;
        } else {
            fragment.getEnterTransitionCallback();
            arrayList = aVar3.f2434q;
        }
        if (arrayList != null) {
            aVar2.o(arrayList);
            aVar2.o(aVar.values());
        }
        x(aVar, aVar2);
        return aVar2;
    }

    private static m.a<String, View> i(z zVar, m.a<String, String> aVar, Object obj, h hVar) {
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = hVar.f2485d;
        m.a<String, View> aVar2 = new m.a<>();
        zVar.j(aVar2, fragment.requireView());
        a aVar3 = hVar.f2487f;
        if (hVar.f2486e) {
            fragment.getEnterTransitionCallback();
            arrayList = aVar3.f2434q;
        } else {
            fragment.getExitTransitionCallback();
            arrayList = aVar3.f2433p;
        }
        if (arrayList != null) {
            aVar2.o(arrayList);
        }
        aVar.o(aVar2.keySet());
        return aVar2;
    }

    private static z j(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        z zVar = f2446b;
        if (zVar != null && g(zVar, arrayList)) {
            return zVar;
        }
        z zVar2 = f2447c;
        if (zVar2 != null && g(zVar2, arrayList)) {
            return zVar2;
        }
        if (zVar == null && zVar2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    static ArrayList<View> k(z zVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            zVar.f(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        zVar.b(obj, arrayList2);
        return arrayList2;
    }

    private static Object l(z zVar, ViewGroup viewGroup, View view, m.a<String, String> aVar, h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        m.a<String, String> aVar2;
        Object obj3;
        Object obj4;
        Rect rect;
        z zVar2 = zVar;
        h hVar2 = hVar;
        ArrayList<View> arrayList3 = arrayList;
        Object obj5 = obj;
        Fragment fragment = hVar2.f2482a;
        Fragment fragment2 = hVar2.f2485d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z4 = hVar2.f2483b;
        if (aVar.isEmpty()) {
            aVar2 = aVar;
            obj3 = null;
        } else {
            obj3 = t(zVar2, fragment, fragment2, z4);
            aVar2 = aVar;
        }
        m.a<String, View> i5 = i(zVar2, aVar2, obj3, hVar2);
        if (aVar.isEmpty()) {
            obj4 = null;
        } else {
            arrayList3.addAll(i5.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        f(fragment, fragment2, z4, i5, true);
        if (obj4 != null) {
            rect = new Rect();
            zVar2.z(obj4, view, arrayList3);
            z(zVar, obj4, obj2, i5, hVar2.f2486e, hVar2.f2487f);
            if (obj5 != null) {
                zVar2.u(obj5, rect);
            }
        } else {
            rect = null;
        }
        f fVar = r0;
        f fVar2 = new f(zVar, aVar, obj4, hVar, arrayList2, view, fragment, fragment2, z4, arrayList, obj, rect);
        i0.a(viewGroup, fVar);
        return obj4;
    }

    private static Object m(z zVar, ViewGroup viewGroup, View view, m.a<String, String> aVar, h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        Rect rect;
        View view2;
        z zVar2 = zVar;
        View view3 = view;
        m.a<String, String> aVar2 = aVar;
        h hVar2 = hVar;
        ArrayList<View> arrayList3 = arrayList;
        ArrayList<View> arrayList4 = arrayList2;
        Object obj4 = obj;
        Fragment fragment = hVar2.f2482a;
        Fragment fragment2 = hVar2.f2485d;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z4 = hVar2.f2483b;
        Object t5 = aVar.isEmpty() ? null : t(zVar, fragment, fragment2, z4);
        m.a<String, View> i5 = i(zVar, aVar2, t5, hVar2);
        m.a<String, View> h5 = h(zVar, aVar2, t5, hVar2);
        if (aVar.isEmpty()) {
            if (i5 != null) {
                i5.clear();
            }
            if (h5 != null) {
                h5.clear();
            }
            obj3 = null;
        } else {
            a(arrayList3, i5, aVar.keySet());
            a(arrayList4, h5, aVar.values());
            obj3 = t5;
        }
        if (obj4 == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z4, i5, true);
        if (obj3 != null) {
            arrayList4.add(view3);
            zVar.z(obj3, view3, arrayList3);
            z(zVar, obj3, obj2, i5, hVar2.f2486e, hVar2.f2487f);
            Rect rect2 = new Rect();
            View s5 = s(h5, hVar2, obj4, z4);
            if (s5 != null) {
                zVar.u(obj4, rect2);
            }
            rect = rect2;
            view2 = s5;
        } else {
            view2 = null;
            rect = null;
        }
        i0.a(viewGroup, new e(fragment, fragment2, z4, h5, view2, zVar, rect));
        return obj3;
    }

    private static void n(ViewGroup viewGroup, h hVar, View view, m.a<String, String> aVar, g gVar) {
        Object obj;
        ViewGroup viewGroup2 = viewGroup;
        h hVar2 = hVar;
        View view2 = view;
        m.a<String, String> aVar2 = aVar;
        g gVar2 = gVar;
        Fragment fragment = hVar2.f2482a;
        Fragment fragment2 = hVar2.f2485d;
        z j5 = j(fragment2, fragment);
        if (j5 != null) {
            boolean z4 = hVar2.f2483b;
            boolean z5 = hVar2.f2486e;
            Object q5 = q(j5, fragment, z4);
            Object r5 = r(j5, fragment2, z5);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = arrayList;
            Object obj2 = r5;
            z zVar = j5;
            Object l5 = l(j5, viewGroup, view, aVar, hVar, arrayList, arrayList2, q5, obj2);
            Object obj3 = q5;
            if (obj3 == null && l5 == null) {
                obj = obj2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = obj2;
            }
            ArrayList arrayList4 = arrayList3;
            ArrayList<View> k5 = k(zVar, obj, fragment2, arrayList4, view2);
            if (k5 == null || k5.isEmpty()) {
                obj = null;
            }
            Object obj4 = obj;
            zVar.a(obj3, view2);
            Object u5 = u(zVar, obj3, obj4, l5, fragment, hVar2.f2483b);
            if (!(fragment2 == null || k5 == null || (k5.size() <= 0 && arrayList4.size() <= 0))) {
                androidx.core.os.e eVar = new androidx.core.os.e();
                gVar2.b(fragment2, eVar);
                zVar.w(fragment2, u5, eVar, new c(gVar2, fragment2, eVar));
            }
            if (u5 != null) {
                ArrayList arrayList5 = new ArrayList();
                z zVar2 = zVar;
                zVar2.t(u5, obj3, arrayList5, obj4, k5, l5, arrayList2);
                y(zVar2, viewGroup, fragment, view, arrayList2, obj3, arrayList5, obj4, k5);
                ViewGroup viewGroup3 = viewGroup;
                z zVar3 = zVar;
                ArrayList arrayList6 = arrayList2;
                zVar3.x(viewGroup3, arrayList6, aVar2);
                zVar3.c(viewGroup3, u5);
                zVar3.s(viewGroup3, arrayList6, aVar2);
            }
        }
    }

    private static void o(ViewGroup viewGroup, h hVar, View view, m.a<String, String> aVar, g gVar) {
        Object obj;
        h hVar2 = hVar;
        View view2 = view;
        g gVar2 = gVar;
        Fragment fragment = hVar2.f2482a;
        Fragment fragment2 = hVar2.f2485d;
        z j5 = j(fragment2, fragment);
        if (j5 != null) {
            boolean z4 = hVar2.f2483b;
            boolean z5 = hVar2.f2486e;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object q5 = q(j5, fragment, z4);
            Object r5 = r(j5, fragment2, z5);
            ArrayList arrayList3 = arrayList2;
            Object m5 = m(j5, viewGroup, view, aVar, hVar, arrayList2, arrayList, q5, r5);
            Object obj2 = q5;
            if (obj2 == null && m5 == null) {
                obj = r5;
                if (obj == null) {
                    return;
                }
            } else {
                obj = r5;
            }
            ArrayList<View> k5 = k(j5, obj, fragment2, arrayList3, view2);
            ArrayList<View> k6 = k(j5, obj2, fragment, arrayList, view2);
            A(k6, 4);
            Fragment fragment3 = fragment;
            ArrayList<View> arrayList4 = k5;
            Object u5 = u(j5, obj2, obj, m5, fragment3, z4);
            if (!(fragment2 == null || arrayList4 == null || (arrayList4.size() <= 0 && arrayList3.size() <= 0))) {
                androidx.core.os.e eVar = new androidx.core.os.e();
                g gVar3 = gVar;
                gVar3.b(fragment2, eVar);
                j5.w(fragment2, u5, eVar, new a(gVar3, fragment2, eVar));
            }
            if (u5 != null) {
                v(j5, obj, fragment2, arrayList4);
                ArrayList<String> o5 = j5.o(arrayList);
                z zVar = j5;
                zVar.t(u5, obj2, k6, obj, arrayList4, m5, arrayList);
                ViewGroup viewGroup2 = viewGroup;
                j5.c(viewGroup2, u5);
                zVar.y(viewGroup2, arrayList3, arrayList, o5, aVar);
                A(k6, 0);
                j5.A(m5, arrayList3, arrayList);
            }
        }
    }

    private static h p(h hVar, SparseArray<h> sparseArray, int i5) {
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h();
        sparseArray.put(i5, hVar2);
        return hVar2;
    }

    private static Object q(z zVar, Fragment fragment, boolean z4) {
        if (fragment == null) {
            return null;
        }
        return zVar.g(z4 ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    private static Object r(z zVar, Fragment fragment, boolean z4) {
        if (fragment == null) {
            return null;
        }
        return zVar.g(z4 ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    static View s(m.a<String, View> aVar, h hVar, Object obj, boolean z4) {
        ArrayList<String> arrayList;
        a aVar2 = hVar.f2484c;
        if (obj == null || aVar == null || (arrayList = aVar2.f2433p) == null || arrayList.isEmpty()) {
            return null;
        }
        return aVar.get((z4 ? aVar2.f2433p : aVar2.f2434q).get(0));
    }

    private static Object t(z zVar, Fragment fragment, Fragment fragment2, boolean z4) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return zVar.B(zVar.g(z4 ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition()));
    }

    private static Object u(z zVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z4) {
        return (obj == null || obj2 == null || fragment == null) ? true : z4 ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap() ? zVar.n(obj2, obj, obj3) : zVar.m(obj2, obj, obj3);
    }

    private static void v(z zVar, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            zVar.r(obj, fragment.getView(), arrayList);
            i0.a(fragment.mContainer, new b(arrayList));
        }
    }

    private static z w() {
        try {
            return b0.e.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static void x(m.a<String, String> aVar, m.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.m(size))) {
                aVar.k(size);
            }
        }
    }

    private static void y(z zVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        ViewGroup viewGroup2 = viewGroup;
        i0.a(viewGroup, new d(obj, zVar, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }

    private static void z(z zVar, Object obj, Object obj2, m.a<String, View> aVar, boolean z4, a aVar2) {
        ArrayList<String> arrayList = aVar2.f2433p;
        if (arrayList != null && !arrayList.isEmpty()) {
            View view = aVar.get((z4 ? aVar2.f2434q : aVar2.f2433p).get(0));
            zVar.v(obj, view);
            if (obj2 != null) {
                zVar.v(obj2, view);
            }
        }
    }
}
