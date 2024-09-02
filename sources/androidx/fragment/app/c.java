package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.os.e;
import androidx.core.view.i0;
import androidx.core.view.k0;
import androidx.fragment.app.c0;
import androidx.fragment.app.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class c extends c0 {

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2198a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.fragment.app.c0$e$c[] r0 = androidx.fragment.app.c0.e.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2198a = r0
                androidx.fragment.app.c0$e$c r1 = androidx.fragment.app.c0.e.c.GONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2198a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.fragment.app.c0$e$c r1 = androidx.fragment.app.c0.e.c.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2198a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.fragment.app.c0$e$c r1 = androidx.fragment.app.c0.e.c.REMOVED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f2198a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.fragment.app.c0$e$c r1 = androidx.fragment.app.c0.e.c.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.c.a.<clinit>():void");
        }
    }

    class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ List f2199e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ c0.e f2200f;

        b(List list, c0.e eVar) {
            this.f2199e = list;
            this.f2200f = eVar;
        }

        public void run() {
            if (this.f2199e.contains(this.f2200f)) {
                this.f2199e.remove(this.f2200f);
                c.this.s(this.f2200f);
            }
        }
    }

    /* renamed from: androidx.fragment.app.c$c  reason: collision with other inner class name */
    class C0036c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2202a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f2203b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f2204c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c0.e f2205d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ k f2206e;

        C0036c(ViewGroup viewGroup, View view, boolean z4, c0.e eVar, k kVar) {
            this.f2202a = viewGroup;
            this.f2203b = view;
            this.f2204c = z4;
            this.f2205d = eVar;
            this.f2206e = kVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f2202a.endViewTransition(this.f2203b);
            if (this.f2204c) {
                this.f2205d.e().c(this.f2203b);
            }
            this.f2206e.a();
        }
    }

    class d implements e.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Animator f2208a;

        d(Animator animator) {
            this.f2208a = animator;
        }

        public void onCancel() {
            this.f2208a.end();
        }
    }

    class e implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2210a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f2211b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k f2212c;

        class a implements Runnable {
            a() {
            }

            public void run() {
                e eVar = e.this;
                eVar.f2210a.endViewTransition(eVar.f2211b);
                e.this.f2212c.a();
            }
        }

        e(ViewGroup viewGroup, View view, k kVar) {
            this.f2210a = viewGroup;
            this.f2211b = view;
            this.f2212c = kVar;
        }

        public void onAnimationEnd(Animation animation) {
            this.f2210a.post(new a());
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    class f implements e.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f2215a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2216b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k f2217c;

        f(View view, ViewGroup viewGroup, k kVar) {
            this.f2215a = view;
            this.f2216b = viewGroup;
            this.f2217c = kVar;
        }

        public void onCancel() {
            this.f2215a.clearAnimation();
            this.f2216b.endViewTransition(this.f2215a);
            this.f2217c.a();
        }
    }

    class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c0.e f2219e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ c0.e f2220f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ boolean f2221g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ m.a f2222h;

        g(c0.e eVar, c0.e eVar2, boolean z4, m.a aVar) {
            this.f2219e = eVar;
            this.f2220f = eVar2;
            this.f2221g = z4;
            this.f2222h = aVar;
        }

        public void run() {
            x.f(this.f2219e.f(), this.f2220f.f(), this.f2221g, this.f2222h, false);
        }
    }

    class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ z f2224e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ View f2225f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Rect f2226g;

        h(z zVar, View view, Rect rect) {
            this.f2224e = zVar;
            this.f2225f = view;
            this.f2226g = rect;
        }

        public void run() {
            this.f2224e.k(this.f2225f, this.f2226g);
        }
    }

    class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f2228e;

        i(ArrayList arrayList) {
            this.f2228e = arrayList;
        }

        public void run() {
            x.A(this.f2228e, 4);
        }
    }

    class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ m f2230e;

        j(m mVar) {
            this.f2230e = mVar;
        }

        public void run() {
            this.f2230e.a();
        }
    }

    private static class k extends l {

        /* renamed from: c  reason: collision with root package name */
        private boolean f2232c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2233d = false;

        /* renamed from: e  reason: collision with root package name */
        private f.d f2234e;

        k(c0.e eVar, androidx.core.os.e eVar2, boolean z4) {
            super(eVar, eVar2);
            this.f2232c = z4;
        }

        /* access modifiers changed from: package-private */
        public f.d e(Context context) {
            if (this.f2233d) {
                return this.f2234e;
            }
            f.d c5 = f.c(context, b().f(), b().e() == c0.e.c.VISIBLE, this.f2232c);
            this.f2234e = c5;
            this.f2233d = true;
            return c5;
        }
    }

    private static class l {

        /* renamed from: a  reason: collision with root package name */
        private final c0.e f2235a;

        /* renamed from: b  reason: collision with root package name */
        private final androidx.core.os.e f2236b;

        l(c0.e eVar, androidx.core.os.e eVar2) {
            this.f2235a = eVar;
            this.f2236b = eVar2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f2235a.d(this.f2236b);
        }

        /* access modifiers changed from: package-private */
        public c0.e b() {
            return this.f2235a;
        }

        /* access modifiers changed from: package-private */
        public androidx.core.os.e c() {
            return this.f2236b;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0014, code lost:
            r2 = androidx.fragment.app.c0.e.c.VISIBLE;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean d() {
            /*
                r3 = this;
                androidx.fragment.app.c0$e r0 = r3.f2235a
                androidx.fragment.app.Fragment r0 = r0.f()
                android.view.View r0 = r0.mView
                androidx.fragment.app.c0$e$c r0 = androidx.fragment.app.c0.e.c.i(r0)
                androidx.fragment.app.c0$e r1 = r3.f2235a
                androidx.fragment.app.c0$e$c r1 = r1.e()
                if (r0 == r1) goto L_0x001d
                androidx.fragment.app.c0$e$c r2 = androidx.fragment.app.c0.e.c.VISIBLE
                if (r0 == r2) goto L_0x001b
                if (r1 == r2) goto L_0x001b
                goto L_0x001d
            L_0x001b:
                r0 = 0
                goto L_0x001e
            L_0x001d:
                r0 = 1
            L_0x001e:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.c.l.d():boolean");
        }
    }

    private static class m extends l {

        /* renamed from: c  reason: collision with root package name */
        private final Object f2237c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f2238d;

        /* renamed from: e  reason: collision with root package name */
        private final Object f2239e;

        m(c0.e eVar, androidx.core.os.e eVar2, boolean z4, boolean z5) {
            super(eVar, eVar2);
            boolean z6;
            Object obj;
            if (eVar.e() == c0.e.c.VISIBLE) {
                Fragment f5 = eVar.f();
                this.f2237c = z4 ? f5.getReenterTransition() : f5.getEnterTransition();
                Fragment f6 = eVar.f();
                z6 = z4 ? f6.getAllowReturnTransitionOverlap() : f6.getAllowEnterTransitionOverlap();
            } else {
                Fragment f7 = eVar.f();
                this.f2237c = z4 ? f7.getReturnTransition() : f7.getExitTransition();
                z6 = true;
            }
            this.f2238d = z6;
            if (z5) {
                Fragment f8 = eVar.f();
                obj = z4 ? f8.getSharedElementReturnTransition() : f8.getSharedElementEnterTransition();
            } else {
                obj = null;
            }
            this.f2239e = obj;
        }

        private z f(Object obj) {
            if (obj == null) {
                return null;
            }
            z zVar = x.f2446b;
            if (zVar != null && zVar.e(obj)) {
                return zVar;
            }
            z zVar2 = x.f2447c;
            if (zVar2 != null && zVar2.e(obj)) {
                return zVar2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        /* access modifiers changed from: package-private */
        public z e() {
            z f5 = f(this.f2237c);
            z f6 = f(this.f2239e);
            if (f5 == null || f6 == null || f5 == f6) {
                return f5 != null ? f5 : f6;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.f2237c + " which uses a different Transition  type than its shared element transition " + this.f2239e);
        }

        public Object g() {
            return this.f2239e;
        }

        /* access modifiers changed from: package-private */
        public Object h() {
            return this.f2237c;
        }

        public boolean i() {
            return this.f2239e != null;
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            return this.f2238d;
        }
    }

    c(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void w(List<k> list, List<c0.e> list2, boolean z4, Map<c0.e, Boolean> map) {
        StringBuilder sb;
        String str;
        f.d e5;
        ViewGroup m5 = m();
        Context context = m5.getContext();
        ArrayList arrayList = new ArrayList();
        boolean z5 = false;
        for (k next : list) {
            if (!next.d() && (e5 = next.e(context)) != null) {
                Animator animator = e5.f2306b;
                if (animator == null) {
                    arrayList.add(next);
                } else {
                    c0.e b5 = next.b();
                    Fragment f5 = b5.f();
                    if (Boolean.TRUE.equals(map.get(b5))) {
                        if (n.F0(2)) {
                            Log.v("FragmentManager", "Ignoring Animator set on " + f5 + " as this Fragment was involved in a Transition.");
                        }
                        next.a();
                    } else {
                        boolean z6 = b5.e() == c0.e.c.GONE;
                        List<c0.e> list3 = list2;
                        if (z6) {
                            list3.remove(b5);
                        }
                        View view = f5.mView;
                        m5.startViewTransition(view);
                        C0036c cVar = r0;
                        C0036c cVar2 = new C0036c(m5, view, z6, b5, next);
                        animator.addListener(cVar);
                        animator.setTarget(view);
                        animator.start();
                        next.c().c(new d(animator));
                        z5 = true;
                    }
                }
            } else {
                next.a();
            }
            Map<c0.e, Boolean> map2 = map;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            c0.e b6 = kVar.b();
            Fragment f6 = b6.f();
            if (z4) {
                if (n.F0(2)) {
                    sb = new StringBuilder();
                    sb.append("Ignoring Animation set on ");
                    sb.append(f6);
                    str = " as Animations cannot run alongside Transitions.";
                }
                kVar.a();
            } else if (z5) {
                if (n.F0(2)) {
                    sb = new StringBuilder();
                    sb.append("Ignoring Animation set on ");
                    sb.append(f6);
                    str = " as Animations cannot run alongside Animators.";
                }
                kVar.a();
            } else {
                View view2 = f6.mView;
                Animation animation = (Animation) androidx.core.util.d.h(((f.d) androidx.core.util.d.h(kVar.e(context))).f2305a);
                if (b6.e() != c0.e.c.REMOVED) {
                    view2.startAnimation(animation);
                    kVar.a();
                } else {
                    m5.startViewTransition(view2);
                    f.e eVar = new f.e(animation, m5, view2);
                    eVar.setAnimationListener(new e(m5, view2, kVar));
                    view2.startAnimation(eVar);
                }
                kVar.c().c(new f(view2, m5, kVar));
            }
            sb.append(str);
            Log.v("FragmentManager", sb.toString());
            kVar.a();
        }
    }

    private Map<c0.e, Boolean> x(List<m> list, List<c0.e> list2, boolean z4, c0.e eVar, c0.e eVar2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        View view;
        View view2;
        c0.e eVar3;
        Object obj;
        c0.e eVar4;
        Object obj2;
        Object obj3;
        m.a aVar;
        c0.e eVar5;
        z zVar;
        View view3;
        Rect rect;
        ArrayList arrayList3;
        ArrayList arrayList4;
        c0.e eVar6;
        boolean z5 = z4;
        c0.e eVar7 = eVar;
        c0.e eVar8 = eVar2;
        HashMap hashMap = new HashMap();
        z zVar2 = null;
        for (m next : list) {
            if (!next.d()) {
                z e5 = next.e();
                if (zVar2 == null) {
                    zVar2 = e5;
                } else if (!(e5 == null || zVar2 == e5)) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + next.b().f() + " returned Transition " + next.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (zVar2 == null) {
            for (m next2 : list) {
                hashMap.put(next2.b(), Boolean.FALSE);
                next2.a();
            }
            return hashMap;
        }
        View view4 = new View(m().getContext());
        Rect rect2 = new Rect();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        m.a aVar2 = new m.a();
        Object obj4 = null;
        View view5 = null;
        boolean z6 = false;
        for (m next3 : list) {
            if (!next3.i() || eVar7 == null || eVar8 == null) {
                aVar = aVar2;
                arrayList4 = arrayList6;
                eVar6 = eVar7;
                arrayList3 = arrayList5;
                rect = rect2;
                view3 = view4;
                zVar = zVar2;
                eVar5 = eVar8;
                view5 = view5;
            } else {
                Object B = zVar2.B(zVar2.g(next3.g()));
                ArrayList<String> sharedElementSourceNames = eVar2.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = eVar.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = eVar.f().getSharedElementTargetNames();
                Object obj5 = B;
                View view6 = view5;
                int i5 = 0;
                while (i5 < sharedElementTargetNames.size()) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i5));
                    ArrayList<String> arrayList7 = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i5));
                    }
                    i5++;
                    sharedElementTargetNames = arrayList7;
                }
                ArrayList<String> sharedElementTargetNames2 = eVar2.f().getSharedElementTargetNames();
                Fragment f5 = eVar.f();
                if (!z5) {
                    f5.getExitTransitionCallback();
                    eVar2.f().getEnterTransitionCallback();
                } else {
                    f5.getEnterTransitionCallback();
                    eVar2.f().getExitTransitionCallback();
                }
                int i6 = 0;
                for (int size = sharedElementSourceNames.size(); i6 < size; size = size) {
                    aVar2.put(sharedElementSourceNames.get(i6), sharedElementTargetNames2.get(i6));
                    i6++;
                }
                m.a aVar3 = new m.a();
                u(aVar3, eVar.f().mView);
                aVar3.o(sharedElementSourceNames);
                aVar2.o(aVar3.keySet());
                m.a aVar4 = new m.a();
                u(aVar4, eVar2.f().mView);
                aVar4.o(sharedElementTargetNames2);
                aVar4.o(aVar2.values());
                x.x(aVar2, aVar4);
                v(aVar3, aVar2.keySet());
                v(aVar4, aVar2.values());
                if (aVar2.isEmpty()) {
                    arrayList5.clear();
                    arrayList6.clear();
                    aVar = aVar2;
                    arrayList4 = arrayList6;
                    eVar6 = eVar7;
                    arrayList3 = arrayList5;
                    rect = rect2;
                    view3 = view4;
                    zVar = zVar2;
                    view5 = view6;
                    obj4 = null;
                    eVar5 = eVar8;
                } else {
                    x.f(eVar2.f(), eVar.f(), z5, aVar3, true);
                    ArrayList<String> arrayList8 = sharedElementSourceNames;
                    g gVar = r0;
                    ViewGroup m5 = m();
                    Object obj6 = obj5;
                    m.a aVar5 = aVar4;
                    View view7 = view6;
                    m.a aVar6 = aVar3;
                    aVar = aVar2;
                    ArrayList arrayList9 = arrayList6;
                    g gVar2 = new g(eVar2, eVar, z4, aVar5);
                    i0.a(m5, gVar2);
                    for (View t5 : aVar6.values()) {
                        t(arrayList5, t5);
                    }
                    if (!arrayList8.isEmpty()) {
                        View view8 = (View) aVar6.get(arrayList8.get(0));
                        zVar2.v(obj6, view8);
                        view5 = view8;
                    } else {
                        view5 = view7;
                    }
                    for (View t6 : aVar5.values()) {
                        t(arrayList9, t6);
                    }
                    arrayList4 = arrayList9;
                    if (!sharedElementTargetNames2.isEmpty()) {
                        View view9 = (View) aVar5.get(sharedElementTargetNames2.get(0));
                        if (view9 != null) {
                            i0.a(m(), new h(zVar2, view9, rect2));
                            z6 = true;
                        }
                    }
                    zVar2.z(obj6, view4, arrayList5);
                    arrayList3 = arrayList5;
                    rect = rect2;
                    view3 = view4;
                    zVar = zVar2;
                    zVar2.t(obj6, (Object) null, (ArrayList<View>) null, (Object) null, (ArrayList<View>) null, obj6, arrayList4);
                    Boolean bool = Boolean.TRUE;
                    eVar6 = eVar;
                    hashMap.put(eVar6, bool);
                    eVar5 = eVar2;
                    hashMap.put(eVar5, bool);
                    obj4 = obj6;
                }
            }
            eVar7 = eVar6;
            arrayList5 = arrayList3;
            rect2 = rect;
            view4 = view3;
            eVar8 = eVar5;
            aVar2 = aVar;
            z5 = z4;
            arrayList6 = arrayList4;
            zVar2 = zVar;
        }
        View view10 = view5;
        m.a aVar7 = aVar2;
        ArrayList arrayList10 = arrayList6;
        c0.e eVar9 = eVar7;
        ArrayList arrayList11 = arrayList5;
        Rect rect3 = rect2;
        View view11 = view4;
        z zVar3 = zVar2;
        boolean z7 = false;
        c0.e eVar10 = eVar8;
        ArrayList arrayList12 = new ArrayList();
        Object obj7 = null;
        Object obj8 = null;
        for (m next4 : list) {
            if (next4.d()) {
                hashMap.put(next4.b(), Boolean.FALSE);
                next4.a();
            } else {
                Object g5 = zVar3.g(next4.h());
                c0.e b5 = next4.b();
                boolean z8 = (obj4 == null || !(b5 == eVar9 || b5 == eVar10)) ? z7 : true;
                if (g5 == null) {
                    if (!z8) {
                        hashMap.put(b5, Boolean.FALSE);
                        next4.a();
                    }
                    List<c0.e> list3 = list2;
                    arrayList = arrayList10;
                    arrayList2 = arrayList11;
                    view = view11;
                    obj = obj7;
                    eVar3 = eVar10;
                    view2 = view10;
                } else {
                    ArrayList arrayList13 = new ArrayList();
                    Object obj9 = obj7;
                    t(arrayList13, b5.f().mView);
                    if (z8) {
                        if (b5 == eVar9) {
                            arrayList13.removeAll(arrayList11);
                        } else {
                            arrayList13.removeAll(arrayList10);
                        }
                    }
                    if (arrayList13.isEmpty()) {
                        zVar3.a(g5, view11);
                        arrayList = arrayList10;
                        arrayList2 = arrayList11;
                        view = view11;
                        eVar4 = b5;
                        obj3 = obj8;
                        eVar3 = eVar10;
                        List<c0.e> list4 = list2;
                        obj2 = obj9;
                    } else {
                        zVar3.b(g5, arrayList13);
                        view = view11;
                        obj2 = obj9;
                        c0.e eVar11 = b5;
                        arrayList2 = arrayList11;
                        obj3 = obj8;
                        arrayList = arrayList10;
                        eVar3 = eVar10;
                        zVar3.t(g5, g5, arrayList13, (Object) null, (ArrayList<View>) null, (Object) null, (ArrayList<View>) null);
                        if (eVar11.e() == c0.e.c.GONE) {
                            eVar4 = eVar11;
                            list2.remove(eVar4);
                            zVar3.r(g5, eVar4.f().mView, arrayList13);
                            i0.a(m(), new i(arrayList13));
                        } else {
                            List<c0.e> list5 = list2;
                            eVar4 = eVar11;
                        }
                    }
                    if (eVar4.e() == c0.e.c.VISIBLE) {
                        arrayList12.addAll(arrayList13);
                        if (z6) {
                            zVar3.u(g5, rect3);
                        }
                        view2 = view10;
                    } else {
                        view2 = view10;
                        zVar3.v(g5, view2);
                    }
                    hashMap.put(eVar4, Boolean.TRUE);
                    if (next4.j()) {
                        obj8 = zVar3.n(obj3, g5, (Object) null);
                        obj = obj2;
                    } else {
                        obj = zVar3.n(obj2, g5, (Object) null);
                        obj8 = obj3;
                    }
                }
                obj7 = obj;
                eVar10 = eVar3;
                view10 = view2;
                view11 = view;
                arrayList11 = arrayList2;
                arrayList10 = arrayList;
                z7 = false;
            }
        }
        ArrayList arrayList14 = arrayList10;
        ArrayList arrayList15 = arrayList11;
        c0.e eVar12 = eVar10;
        Object m6 = zVar3.m(obj8, obj7, obj4);
        for (m next5 : list) {
            if (!next5.d()) {
                Object h5 = next5.h();
                c0.e b6 = next5.b();
                boolean z9 = obj4 != null && (b6 == eVar9 || b6 == eVar12);
                if (h5 != null || z9) {
                    if (!k0.B(m())) {
                        if (n.F0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Container " + m() + " has not been laid out. Completing operation " + b6);
                        }
                        next5.a();
                    } else {
                        zVar3.w(next5.b().f(), m6, next5.c(), new j(next5));
                    }
                }
            }
        }
        if (!k0.B(m())) {
            return hashMap;
        }
        x.A(arrayList12, 4);
        ArrayList arrayList16 = arrayList14;
        ArrayList<String> o5 = zVar3.o(arrayList16);
        zVar3.c(m(), m6);
        zVar3.y(m(), arrayList15, arrayList16, o5, aVar7);
        x.A(arrayList12, 0);
        zVar3.A(obj4, arrayList15, arrayList16);
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public void f(List<c0.e> list, boolean z4) {
        c0.e eVar = null;
        c0.e eVar2 = null;
        for (c0.e next : list) {
            c0.e.c i5 = c0.e.c.i(next.f().mView);
            int i6 = a.f2198a[next.e().ordinal()];
            if (i6 == 1 || i6 == 2 || i6 == 3) {
                if (i5 == c0.e.c.VISIBLE && eVar == null) {
                    eVar = next;
                }
            } else if (i6 == 4 && i5 != c0.e.c.VISIBLE) {
                eVar2 = next;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<c0.e> arrayList3 = new ArrayList<>(list);
        for (c0.e next2 : list) {
            androidx.core.os.e eVar3 = new androidx.core.os.e();
            next2.j(eVar3);
            arrayList.add(new k(next2, eVar3, z4));
            androidx.core.os.e eVar4 = new androidx.core.os.e();
            next2.j(eVar4);
            boolean z5 = false;
            if (z4) {
                if (next2 != eVar) {
                    arrayList2.add(new m(next2, eVar4, z4, z5));
                    next2.a(new b(arrayList3, next2));
                }
            } else if (next2 != eVar2) {
                arrayList2.add(new m(next2, eVar4, z4, z5));
                next2.a(new b(arrayList3, next2));
            }
            z5 = true;
            arrayList2.add(new m(next2, eVar4, z4, z5));
            next2.a(new b(arrayList3, next2));
        }
        Map<c0.e, Boolean> x4 = x(arrayList2, arrayList3, z4, eVar, eVar2);
        w(arrayList, arrayList3, x4.containsValue(Boolean.TRUE), x4);
        for (c0.e s5 : arrayList3) {
            s(s5);
        }
        arrayList3.clear();
    }

    /* access modifiers changed from: package-private */
    public void s(c0.e eVar) {
        eVar.e().c(eVar.f().mView);
    }

    /* access modifiers changed from: package-private */
    public void t(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            if (!arrayList.contains(view) && k0.v(view) != null) {
                arrayList.add(view);
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = viewGroup.getChildAt(i5);
                if (childAt.getVisibility() == 0) {
                    t(arrayList, childAt);
                }
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    /* access modifiers changed from: package-private */
    public void u(Map<String, View> map, View view) {
        String v5 = k0.v(view);
        if (v5 != null) {
            map.put(v5, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = viewGroup.getChildAt(i5);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void v(m.a<String, View> aVar, Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = aVar.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(k0.v((View) it.next().getValue()))) {
                it.remove();
            }
        }
    }
}
