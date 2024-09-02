package b0;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.e;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.z;
import b0.l;
import java.util.ArrayList;
import java.util.List;

public class e extends z {

    class a extends l.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Rect f2870a;

        a(Rect rect) {
            this.f2870a = rect;
        }
    }

    class b implements l.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f2872a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f2873b;

        b(View view, ArrayList arrayList) {
            this.f2872a = view;
            this.f2873b = arrayList;
        }

        public void a(l lVar) {
            lVar.Q(this);
            lVar.a(this);
        }

        public void b(l lVar) {
            lVar.Q(this);
            this.f2872a.setVisibility(8);
            int size = this.f2873b.size();
            for (int i5 = 0; i5 < size; i5++) {
                ((View) this.f2873b.get(i5)).setVisibility(0);
            }
        }

        public void c(l lVar) {
        }

        public void d(l lVar) {
        }

        public void e(l lVar) {
        }
    }

    class c extends m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f2875a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f2876b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f2877c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f2878d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f2879e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ArrayList f2880f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f2875a = obj;
            this.f2876b = arrayList;
            this.f2877c = obj2;
            this.f2878d = arrayList2;
            this.f2879e = obj3;
            this.f2880f = arrayList3;
        }

        public void a(l lVar) {
            Object obj = this.f2875a;
            if (obj != null) {
                e.this.q(obj, this.f2876b, (ArrayList<View>) null);
            }
            Object obj2 = this.f2877c;
            if (obj2 != null) {
                e.this.q(obj2, this.f2878d, (ArrayList<View>) null);
            }
            Object obj3 = this.f2879e;
            if (obj3 != null) {
                e.this.q(obj3, this.f2880f, (ArrayList<View>) null);
            }
        }

        public void b(l lVar) {
            lVar.Q(this);
        }
    }

    class d implements e.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f2882a;

        d(l lVar) {
            this.f2882a = lVar;
        }

        public void onCancel() {
            this.f2882a.g();
        }
    }

    /* renamed from: b0.e$e  reason: collision with other inner class name */
    class C0051e implements l.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f2884a;

        C0051e(Runnable runnable) {
            this.f2884a = runnable;
        }

        public void a(l lVar) {
        }

        public void b(l lVar) {
            this.f2884a.run();
        }

        public void c(l lVar) {
        }

        public void d(l lVar) {
        }

        public void e(l lVar) {
        }
    }

    class f extends l.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Rect f2886a;

        f(Rect rect) {
            this.f2886a = rect;
        }
    }

    private static boolean C(l lVar) {
        return !z.l(lVar.A()) || !z.l(lVar.B()) || !z.l(lVar.C());
    }

    public void A(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        p pVar = (p) obj;
        if (pVar != null) {
            pVar.D().clear();
            pVar.D().addAll(arrayList2);
            q(pVar, arrayList, arrayList2);
        }
    }

    public Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        p pVar = new p();
        pVar.f0((l) obj);
        return pVar;
    }

    public void a(Object obj, View view) {
        if (obj != null) {
            ((l) obj).b(view);
        }
    }

    public void b(Object obj, ArrayList<View> arrayList) {
        l lVar = (l) obj;
        if (lVar != null) {
            int i5 = 0;
            if (lVar instanceof p) {
                p pVar = (p) lVar;
                int i02 = pVar.i0();
                while (i5 < i02) {
                    b(pVar.h0(i5), arrayList);
                    i5++;
                }
            } else if (!C(lVar) && z.l(lVar.D())) {
                int size = arrayList.size();
                while (i5 < size) {
                    lVar.b(arrayList.get(i5));
                    i5++;
                }
            }
        }
    }

    public void c(ViewGroup viewGroup, Object obj) {
        n.a(viewGroup, (l) obj);
    }

    public boolean e(Object obj) {
        return obj instanceof l;
    }

    public Object g(Object obj) {
        if (obj != null) {
            return ((l) obj).clone();
        }
        return null;
    }

    public Object m(Object obj, Object obj2, Object obj3) {
        l lVar = (l) obj;
        l lVar2 = (l) obj2;
        l lVar3 = (l) obj3;
        if (lVar != null && lVar2 != null) {
            lVar = new p().f0(lVar).f0(lVar2).n0(1);
        } else if (lVar == null) {
            lVar = lVar2 != null ? lVar2 : null;
        }
        if (lVar3 == null) {
            return lVar;
        }
        p pVar = new p();
        if (lVar != null) {
            pVar.f0(lVar);
        }
        pVar.f0(lVar3);
        return pVar;
    }

    public Object n(Object obj, Object obj2, Object obj3) {
        p pVar = new p();
        if (obj != null) {
            pVar.f0((l) obj);
        }
        if (obj2 != null) {
            pVar.f0((l) obj2);
        }
        if (obj3 != null) {
            pVar.f0((l) obj3);
        }
        return pVar;
    }

    public void p(Object obj, View view) {
        if (obj != null) {
            ((l) obj).R(view);
        }
    }

    public void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        l lVar = (l) obj;
        int i5 = 0;
        if (lVar instanceof p) {
            p pVar = (p) lVar;
            int i02 = pVar.i0();
            while (i5 < i02) {
                q(pVar.h0(i5), arrayList, arrayList2);
                i5++;
            }
        } else if (!C(lVar)) {
            List<View> D = lVar.D();
            if (D.size() == arrayList.size() && D.containsAll(arrayList)) {
                int size = arrayList2 == null ? 0 : arrayList2.size();
                while (i5 < size) {
                    lVar.b(arrayList2.get(i5));
                    i5++;
                }
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    lVar.R(arrayList.get(size2));
                }
            }
        }
    }

    public void r(Object obj, View view, ArrayList<View> arrayList) {
        ((l) obj).a(new b(view, arrayList));
    }

    public void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((l) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((l) obj).W(new f(rect));
        }
    }

    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((l) obj).W(new a(rect));
        }
    }

    public void w(Fragment fragment, Object obj, androidx.core.os.e eVar, Runnable runnable) {
        l lVar = (l) obj;
        eVar.c(new d(lVar));
        lVar.a(new C0051e(runnable));
    }

    public void z(Object obj, View view, ArrayList<View> arrayList) {
        p pVar = (p) obj;
        List<View> D = pVar.D();
        D.clear();
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            z.d(D, arrayList.get(i5));
        }
        D.add(view);
        arrayList.add(view);
        b(pVar, arrayList);
    }
}
