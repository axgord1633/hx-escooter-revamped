package b0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.core.view.k0;
import com.yalantis.ucrop.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m.g;

public abstract class l implements Cloneable {
    private static final int[] J = {2, 1, 3, 4};
    private static final g K = new a();
    private static ThreadLocal<m.a<Animator, d>> L = new ThreadLocal<>();
    ArrayList<Animator> A = new ArrayList<>();
    private int B = 0;
    private boolean C = false;
    private boolean D = false;
    private ArrayList<f> E = null;
    private ArrayList<Animator> F = new ArrayList<>();
    private e G;
    private m.a<String, String> H;
    private g I = K;

    /* renamed from: e  reason: collision with root package name */
    private String f2897e = getClass().getName();

    /* renamed from: f  reason: collision with root package name */
    private long f2898f = -1;

    /* renamed from: g  reason: collision with root package name */
    long f2899g = -1;

    /* renamed from: h  reason: collision with root package name */
    private TimeInterpolator f2900h = null;

    /* renamed from: i  reason: collision with root package name */
    ArrayList<Integer> f2901i = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    ArrayList<View> f2902j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<String> f2903k = null;

    /* renamed from: l  reason: collision with root package name */
    private ArrayList<Class<?>> f2904l = null;

    /* renamed from: m  reason: collision with root package name */
    private ArrayList<Integer> f2905m = null;

    /* renamed from: n  reason: collision with root package name */
    private ArrayList<View> f2906n = null;

    /* renamed from: o  reason: collision with root package name */
    private ArrayList<Class<?>> f2907o = null;

    /* renamed from: p  reason: collision with root package name */
    private ArrayList<String> f2908p = null;

    /* renamed from: q  reason: collision with root package name */
    private ArrayList<Integer> f2909q = null;

    /* renamed from: r  reason: collision with root package name */
    private ArrayList<View> f2910r = null;

    /* renamed from: s  reason: collision with root package name */
    private ArrayList<Class<?>> f2911s = null;

    /* renamed from: t  reason: collision with root package name */
    private t f2912t = new t();

    /* renamed from: u  reason: collision with root package name */
    private t f2913u = new t();

    /* renamed from: v  reason: collision with root package name */
    p f2914v = null;

    /* renamed from: w  reason: collision with root package name */
    private int[] f2915w = J;

    /* renamed from: x  reason: collision with root package name */
    private ArrayList<s> f2916x;

    /* renamed from: y  reason: collision with root package name */
    private ArrayList<s> f2917y;

    /* renamed from: z  reason: collision with root package name */
    boolean f2918z = false;

    class a extends g {
        a() {
        }

        public Path a(float f5, float f6, float f7, float f8) {
            Path path = new Path();
            path.moveTo(f5, f6);
            path.lineTo(f7, f8);
            return path;
        }
    }

    class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m.a f2919a;

        b(m.a aVar) {
            this.f2919a = aVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f2919a.remove(animator);
            l.this.A.remove(animator);
        }

        public void onAnimationStart(Animator animator) {
            l.this.A.add(animator);
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        public void onAnimationEnd(Animator animator) {
            l.this.q();
            animator.removeListener(this);
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        View f2922a;

        /* renamed from: b  reason: collision with root package name */
        String f2923b;

        /* renamed from: c  reason: collision with root package name */
        s f2924c;

        /* renamed from: d  reason: collision with root package name */
        p0 f2925d;

        /* renamed from: e  reason: collision with root package name */
        l f2926e;

        d(View view, String str, l lVar, p0 p0Var, s sVar) {
            this.f2922a = view;
            this.f2923b = str;
            this.f2924c = sVar;
            this.f2925d = p0Var;
            this.f2926e = lVar;
        }
    }

    public static abstract class e {
    }

    public interface f {
        void a(l lVar);

        void b(l lVar);

        void c(l lVar);

        void d(l lVar);

        void e(l lVar);
    }

    private static boolean I(s sVar, s sVar2, String str) {
        Object obj = sVar.f2959a.get(str);
        Object obj2 = sVar2.f2959a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    private void J(m.a<View, s> aVar, m.a<View, s> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i5 = 0; i5 < size; i5++) {
            View valueAt = sparseArray.valueAt(i5);
            if (valueAt != null && H(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i5))) != null && H(view)) {
                s sVar = aVar.get(valueAt);
                s sVar2 = aVar2.get(view);
                if (!(sVar == null || sVar2 == null)) {
                    this.f2916x.add(sVar);
                    this.f2917y.add(sVar2);
                    aVar.remove(valueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void K(m.a<View, s> aVar, m.a<View, s> aVar2) {
        s remove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View i5 = aVar.i(size);
            if (i5 != null && H(i5) && (remove = aVar2.remove(i5)) != null && H(remove.f2960b)) {
                this.f2916x.add(aVar.k(size));
                this.f2917y.add(remove);
            }
        }
    }

    private void L(m.a<View, s> aVar, m.a<View, s> aVar2, m.d<View> dVar, m.d<View> dVar2) {
        View f5;
        int l5 = dVar.l();
        for (int i5 = 0; i5 < l5; i5++) {
            View m5 = dVar.m(i5);
            if (m5 != null && H(m5) && (f5 = dVar2.f(dVar.i(i5))) != null && H(f5)) {
                s sVar = aVar.get(m5);
                s sVar2 = aVar2.get(f5);
                if (!(sVar == null || sVar2 == null)) {
                    this.f2916x.add(sVar);
                    this.f2917y.add(sVar2);
                    aVar.remove(m5);
                    aVar2.remove(f5);
                }
            }
        }
    }

    private void M(m.a<View, s> aVar, m.a<View, s> aVar2, m.a<String, View> aVar3, m.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i5 = 0; i5 < size; i5++) {
            View m5 = aVar3.m(i5);
            if (m5 != null && H(m5) && (view = aVar4.get(aVar3.i(i5))) != null && H(view)) {
                s sVar = aVar.get(m5);
                s sVar2 = aVar2.get(view);
                if (!(sVar == null || sVar2 == null)) {
                    this.f2916x.add(sVar);
                    this.f2917y.add(sVar2);
                    aVar.remove(m5);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void N(t tVar, t tVar2) {
        m.a aVar = new m.a((g) tVar.f2962a);
        m.a aVar2 = new m.a((g) tVar2.f2962a);
        int i5 = 0;
        while (true) {
            int[] iArr = this.f2915w;
            if (i5 < iArr.length) {
                int i6 = iArr[i5];
                if (i6 == 1) {
                    K(aVar, aVar2);
                } else if (i6 == 2) {
                    M(aVar, aVar2, tVar.f2965d, tVar2.f2965d);
                } else if (i6 == 3) {
                    J(aVar, aVar2, tVar.f2963b, tVar2.f2963b);
                } else if (i6 == 4) {
                    L(aVar, aVar2, tVar.f2964c, tVar2.f2964c);
                }
                i5++;
            } else {
                c(aVar, aVar2);
                return;
            }
        }
    }

    private void T(Animator animator, m.a<Animator, d> aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            f(animator);
        }
    }

    private void c(m.a<View, s> aVar, m.a<View, s> aVar2) {
        for (int i5 = 0; i5 < aVar.size(); i5++) {
            s m5 = aVar.m(i5);
            if (H(m5.f2960b)) {
                this.f2916x.add(m5);
                this.f2917y.add((Object) null);
            }
        }
        for (int i6 = 0; i6 < aVar2.size(); i6++) {
            s m6 = aVar2.m(i6);
            if (H(m6.f2960b)) {
                this.f2917y.add(m6);
                this.f2916x.add((Object) null);
            }
        }
    }

    private static void d(t tVar, View view, s sVar) {
        tVar.f2962a.put(view, sVar);
        int id = view.getId();
        if (id >= 0) {
            if (tVar.f2963b.indexOfKey(id) >= 0) {
                tVar.f2963b.put(id, (Object) null);
            } else {
                tVar.f2963b.put(id, view);
            }
        }
        String v5 = k0.v(view);
        if (v5 != null) {
            if (tVar.f2965d.containsKey(v5)) {
                tVar.f2965d.put(v5, null);
            } else {
                tVar.f2965d.put(v5, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (tVar.f2964c.h(itemIdAtPosition) >= 0) {
                    View f5 = tVar.f2964c.f(itemIdAtPosition);
                    if (f5 != null) {
                        k0.U(f5, false);
                        tVar.f2964c.j(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                k0.U(view, true);
                tVar.f2964c.j(itemIdAtPosition, view);
            }
        }
    }

    private void i(View view, boolean z4) {
        if (view != null) {
            int id = view.getId();
            ArrayList<Integer> arrayList = this.f2905m;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
                ArrayList<View> arrayList2 = this.f2906n;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class<?>> arrayList3 = this.f2907o;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        int i5 = 0;
                        while (i5 < size) {
                            if (!this.f2907o.get(i5).isInstance(view)) {
                                i5++;
                            } else {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        s sVar = new s(view);
                        if (z4) {
                            k(sVar);
                        } else {
                            h(sVar);
                        }
                        sVar.f2961c.add(this);
                        j(sVar);
                        d(z4 ? this.f2912t : this.f2913u, view, sVar);
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.f2909q;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                            ArrayList<View> arrayList5 = this.f2910r;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class<?>> arrayList6 = this.f2911s;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    int i6 = 0;
                                    while (i6 < size2) {
                                        if (!this.f2911s.get(i6).isInstance(view)) {
                                            i6++;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i7 = 0; i7 < viewGroup.getChildCount(); i7++) {
                                    i(viewGroup.getChildAt(i7), z4);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static m.a<Animator, d> y() {
        m.a<Animator, d> aVar = L.get();
        if (aVar != null) {
            return aVar;
        }
        m.a<Animator, d> aVar2 = new m.a<>();
        L.set(aVar2);
        return aVar2;
    }

    public List<Integer> A() {
        return this.f2901i;
    }

    public List<String> B() {
        return this.f2903k;
    }

    public List<Class<?>> C() {
        return this.f2904l;
    }

    public List<View> D() {
        return this.f2902j;
    }

    public String[] E() {
        return null;
    }

    public s F(View view, boolean z4) {
        p pVar = this.f2914v;
        if (pVar != null) {
            return pVar.F(view, z4);
        }
        return (z4 ? this.f2912t : this.f2913u).f2962a.get(view);
    }

    public boolean G(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return false;
        }
        String[] E2 = E();
        if (E2 != null) {
            int length = E2.length;
            int i5 = 0;
            while (i5 < length) {
                if (!I(sVar, sVar2, E2[i5])) {
                    i5++;
                }
            }
            return false;
        }
        for (String I2 : sVar.f2959a.keySet()) {
            if (I(sVar, sVar2, I2)) {
            }
        }
        return false;
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean H(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.f2905m;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.f2906n;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.f2907o;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (this.f2907o.get(i5).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f2908p != null && k0.v(view) != null && this.f2908p.contains(k0.v(view))) {
            return false;
        }
        if ((this.f2901i.size() == 0 && this.f2902j.size() == 0 && (((arrayList = this.f2904l) == null || arrayList.isEmpty()) && ((arrayList2 = this.f2903k) == null || arrayList2.isEmpty()))) || this.f2901i.contains(Integer.valueOf(id)) || this.f2902j.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.f2903k;
        if (arrayList6 != null && arrayList6.contains(k0.v(view))) {
            return true;
        }
        if (this.f2904l != null) {
            for (int i6 = 0; i6 < this.f2904l.size(); i6++) {
                if (this.f2904l.get(i6).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void O(View view) {
        if (!this.D) {
            for (int size = this.A.size() - 1; size >= 0; size--) {
                a.b(this.A.get(size));
            }
            ArrayList<f> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.E.clone();
                int size2 = arrayList2.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    ((f) arrayList2.get(i5)).d(this);
                }
            }
            this.C = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void P(ViewGroup viewGroup) {
        d dVar;
        this.f2916x = new ArrayList<>();
        this.f2917y = new ArrayList<>();
        N(this.f2912t, this.f2913u);
        m.a<Animator, d> y4 = y();
        int size = y4.size();
        p0 d5 = a0.d(viewGroup);
        for (int i5 = size - 1; i5 >= 0; i5--) {
            Animator i6 = y4.i(i5);
            if (!(i6 == null || (dVar = y4.get(i6)) == null || dVar.f2922a == null || !d5.equals(dVar.f2925d))) {
                s sVar = dVar.f2924c;
                View view = dVar.f2922a;
                s F2 = F(view, true);
                s u5 = u(view, true);
                if (F2 == null && u5 == null) {
                    u5 = this.f2913u.f2962a.get(view);
                }
                if (!(F2 == null && u5 == null) && dVar.f2926e.G(sVar, u5)) {
                    if (i6.isRunning() || i6.isStarted()) {
                        i6.cancel();
                    } else {
                        y4.remove(i6);
                    }
                }
            }
        }
        p(viewGroup, this.f2912t, this.f2913u, this.f2916x, this.f2917y);
        U();
    }

    public l Q(f fVar) {
        ArrayList<f> arrayList = this.E;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fVar);
        if (this.E.size() == 0) {
            this.E = null;
        }
        return this;
    }

    public l R(View view) {
        this.f2902j.remove(view);
        return this;
    }

    public void S(View view) {
        if (this.C) {
            if (!this.D) {
                for (int size = this.A.size() - 1; size >= 0; size--) {
                    a.c(this.A.get(size));
                }
                ArrayList<f> arrayList = this.E;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.E.clone();
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        ((f) arrayList2.get(i5)).c(this);
                    }
                }
            }
            this.C = false;
        }
    }

    /* access modifiers changed from: protected */
    public void U() {
        b0();
        m.a<Animator, d> y4 = y();
        Iterator<Animator> it = this.F.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (y4.containsKey(next)) {
                b0();
                T(next, y4);
            }
        }
        this.F.clear();
        q();
    }

    public l V(long j5) {
        this.f2899g = j5;
        return this;
    }

    public void W(e eVar) {
        this.G = eVar;
    }

    public l X(TimeInterpolator timeInterpolator) {
        this.f2900h = timeInterpolator;
        return this;
    }

    public void Y(g gVar) {
        if (gVar == null) {
            gVar = K;
        }
        this.I = gVar;
    }

    public void Z(o oVar) {
    }

    public l a(f fVar) {
        if (this.E == null) {
            this.E = new ArrayList<>();
        }
        this.E.add(fVar);
        return this;
    }

    public l a0(long j5) {
        this.f2898f = j5;
        return this;
    }

    public l b(View view) {
        this.f2902j.add(view);
        return this;
    }

    /* access modifiers changed from: protected */
    public void b0() {
        if (this.B == 0) {
            ArrayList<f> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.E.clone();
                int size = arrayList2.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ((f) arrayList2.get(i5)).a(this);
                }
            }
            this.D = false;
        }
        this.B++;
    }

    /* access modifiers changed from: package-private */
    public String c0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f2899g != -1) {
            str2 = str2 + "dur(" + this.f2899g + ") ";
        }
        if (this.f2898f != -1) {
            str2 = str2 + "dly(" + this.f2898f + ") ";
        }
        if (this.f2900h != null) {
            str2 = str2 + "interp(" + this.f2900h + ") ";
        }
        if (this.f2901i.size() <= 0 && this.f2902j.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f2901i.size() > 0) {
            for (int i5 = 0; i5 < this.f2901i.size(); i5++) {
                if (i5 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f2901i.get(i5);
            }
        }
        if (this.f2902j.size() > 0) {
            for (int i6 = 0; i6 < this.f2902j.size(); i6++) {
                if (i6 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f2902j.get(i6);
            }
        }
        return str3 + ")";
    }

    /* access modifiers changed from: protected */
    public void f(Animator animator) {
        if (animator == null) {
            q();
            return;
        }
        if (r() >= 0) {
            animator.setDuration(r());
        }
        if (z() >= 0) {
            animator.setStartDelay(z() + animator.getStartDelay());
        }
        if (t() != null) {
            animator.setInterpolator(t());
        }
        animator.addListener(new c());
        animator.start();
    }

    /* access modifiers changed from: protected */
    public void g() {
        for (int size = this.A.size() - 1; size >= 0; size--) {
            this.A.get(size).cancel();
        }
        ArrayList<f> arrayList = this.E;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.E.clone();
            int size2 = arrayList2.size();
            for (int i5 = 0; i5 < size2; i5++) {
                ((f) arrayList2.get(i5)).e(this);
            }
        }
    }

    public abstract void h(s sVar);

    /* access modifiers changed from: package-private */
    public void j(s sVar) {
    }

    public abstract void k(s sVar);

    /* access modifiers changed from: package-private */
    public void l(ViewGroup viewGroup, boolean z4) {
        m.a<String, String> aVar;
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        m(z4);
        if ((this.f2901i.size() > 0 || this.f2902j.size() > 0) && (((arrayList = this.f2903k) == null || arrayList.isEmpty()) && ((arrayList2 = this.f2904l) == null || arrayList2.isEmpty()))) {
            for (int i5 = 0; i5 < this.f2901i.size(); i5++) {
                View findViewById = viewGroup.findViewById(this.f2901i.get(i5).intValue());
                if (findViewById != null) {
                    s sVar = new s(findViewById);
                    if (z4) {
                        k(sVar);
                    } else {
                        h(sVar);
                    }
                    sVar.f2961c.add(this);
                    j(sVar);
                    d(z4 ? this.f2912t : this.f2913u, findViewById, sVar);
                }
            }
            for (int i6 = 0; i6 < this.f2902j.size(); i6++) {
                View view = this.f2902j.get(i6);
                s sVar2 = new s(view);
                if (z4) {
                    k(sVar2);
                } else {
                    h(sVar2);
                }
                sVar2.f2961c.add(this);
                j(sVar2);
                d(z4 ? this.f2912t : this.f2913u, view, sVar2);
            }
        } else {
            i(viewGroup, z4);
        }
        if (!z4 && (aVar = this.H) != null) {
            int size = aVar.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i7 = 0; i7 < size; i7++) {
                arrayList3.add(this.f2912t.f2965d.remove(this.H.i(i7)));
            }
            for (int i8 = 0; i8 < size; i8++) {
                View view2 = (View) arrayList3.get(i8);
                if (view2 != null) {
                    this.f2912t.f2965d.put(this.H.m(i8), view2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void m(boolean z4) {
        t tVar;
        if (z4) {
            this.f2912t.f2962a.clear();
            this.f2912t.f2963b.clear();
            tVar = this.f2912t;
        } else {
            this.f2913u.f2962a.clear();
            this.f2913u.f2963b.clear();
            tVar = this.f2913u;
        }
        tVar.f2964c.b();
    }

    /* renamed from: n */
    public l clone() {
        try {
            l lVar = (l) super.clone();
            lVar.F = new ArrayList<>();
            lVar.f2912t = new t();
            lVar.f2913u = new t();
            lVar.f2916x = null;
            lVar.f2917y = null;
            return lVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator o(ViewGroup viewGroup, s sVar, s sVar2) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void p(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        int i5;
        Animator animator;
        s sVar;
        View view;
        s sVar2;
        Animator animator2;
        m.a<Animator, d> y4 = y();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            s sVar3 = arrayList.get(i6);
            s sVar4 = arrayList2.get(i6);
            if (sVar3 != null && !sVar3.f2961c.contains(this)) {
                sVar3 = null;
            }
            if (sVar4 != null && !sVar4.f2961c.contains(this)) {
                sVar4 = null;
            }
            if (!(sVar3 == null && sVar4 == null)) {
                if (sVar3 == null || sVar4 == null || G(sVar3, sVar4)) {
                    Animator o5 = o(viewGroup, sVar3, sVar4);
                    if (o5 != null) {
                        if (sVar4 != null) {
                            View view2 = sVar4.f2960b;
                            String[] E2 = E();
                            if (E2 != null && E2.length > 0) {
                                sVar2 = new s(view2);
                                s sVar5 = tVar2.f2962a.get(view2);
                                if (sVar5 != null) {
                                    int i7 = 0;
                                    while (i7 < E2.length) {
                                        Map<String, Object> map = sVar2.f2959a;
                                        Animator animator3 = o5;
                                        String str = E2[i7];
                                        map.put(str, sVar5.f2959a.get(str));
                                        i7++;
                                        o5 = animator3;
                                        E2 = E2;
                                    }
                                }
                                Animator animator4 = o5;
                                int size2 = y4.size();
                                int i8 = 0;
                                while (true) {
                                    if (i8 >= size2) {
                                        animator2 = animator4;
                                        break;
                                    }
                                    d dVar = y4.get(y4.i(i8));
                                    if (dVar.f2924c != null && dVar.f2922a == view2 && dVar.f2923b.equals(v()) && dVar.f2924c.equals(sVar2)) {
                                        animator2 = null;
                                        break;
                                    }
                                    i8++;
                                }
                            } else {
                                t tVar3 = tVar2;
                                animator2 = o5;
                                sVar2 = null;
                            }
                            view = view2;
                            animator = animator2;
                            sVar = sVar2;
                        } else {
                            t tVar4 = tVar2;
                            view = sVar3.f2960b;
                            animator = o5;
                            sVar = null;
                        }
                        if (animator != null) {
                            i5 = size;
                            d dVar2 = r0;
                            d dVar3 = new d(view, v(), this, a0.d(viewGroup), sVar);
                            y4.put(animator, dVar2);
                            this.F.add(animator);
                            i6++;
                            size = i5;
                        }
                        i5 = size;
                        i6++;
                        size = i5;
                    }
                    t tVar5 = tVar2;
                    i5 = size;
                    i6++;
                    size = i5;
                }
            }
            ViewGroup viewGroup2 = viewGroup;
            t tVar52 = tVar2;
            i5 = size;
            i6++;
            size = i5;
        }
        if (sparseIntArray.size() != 0) {
            for (int i9 = 0; i9 < sparseIntArray.size(); i9++) {
                Animator animator5 = this.F.get(sparseIntArray.keyAt(i9));
                animator5.setStartDelay((((long) sparseIntArray.valueAt(i9)) - Long.MAX_VALUE) + animator5.getStartDelay());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void q() {
        int i5 = this.B - 1;
        this.B = i5;
        if (i5 == 0) {
            ArrayList<f> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.E.clone();
                int size = arrayList2.size();
                for (int i6 = 0; i6 < size; i6++) {
                    ((f) arrayList2.get(i6)).b(this);
                }
            }
            for (int i7 = 0; i7 < this.f2912t.f2964c.l(); i7++) {
                View m5 = this.f2912t.f2964c.m(i7);
                if (m5 != null) {
                    k0.U(m5, false);
                }
            }
            for (int i8 = 0; i8 < this.f2913u.f2964c.l(); i8++) {
                View m6 = this.f2913u.f2964c.m(i8);
                if (m6 != null) {
                    k0.U(m6, false);
                }
            }
            this.D = true;
        }
    }

    public long r() {
        return this.f2899g;
    }

    public e s() {
        return this.G;
    }

    public TimeInterpolator t() {
        return this.f2900h;
    }

    public String toString() {
        return c0(BuildConfig.FLAVOR);
    }

    /* access modifiers changed from: package-private */
    public s u(View view, boolean z4) {
        p pVar = this.f2914v;
        if (pVar != null) {
            return pVar.u(view, z4);
        }
        ArrayList<s> arrayList = z4 ? this.f2916x : this.f2917y;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i5 = -1;
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                break;
            }
            s sVar = arrayList.get(i6);
            if (sVar == null) {
                return null;
            }
            if (sVar.f2960b == view) {
                i5 = i6;
                break;
            }
            i6++;
        }
        if (i5 < 0) {
            return null;
        }
        return (z4 ? this.f2917y : this.f2916x).get(i5);
    }

    public String v() {
        return this.f2897e;
    }

    public g w() {
        return this.I;
    }

    public o x() {
        return null;
    }

    public long z() {
        return this.f2898f;
    }
}
