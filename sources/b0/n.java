package b0;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.k0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private static l f2929a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static ThreadLocal<WeakReference<m.a<ViewGroup, ArrayList<l>>>> f2930b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    static ArrayList<ViewGroup> f2931c = new ArrayList<>();

    private static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: e  reason: collision with root package name */
        l f2932e;

        /* renamed from: f  reason: collision with root package name */
        ViewGroup f2933f;

        /* renamed from: b0.n$a$a  reason: collision with other inner class name */
        class C0052a extends m {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ m.a f2934a;

            C0052a(m.a aVar) {
                this.f2934a = aVar;
            }

            public void b(l lVar) {
                ((ArrayList) this.f2934a.get(a.this.f2933f)).remove(lVar);
                lVar.Q(this);
            }
        }

        a(l lVar, ViewGroup viewGroup) {
            this.f2932e = lVar;
            this.f2933f = viewGroup;
        }

        private void a() {
            this.f2933f.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f2933f.removeOnAttachStateChangeListener(this);
        }

        public boolean onPreDraw() {
            a();
            if (!n.f2931c.remove(this.f2933f)) {
                return true;
            }
            m.a<ViewGroup, ArrayList<l>> b5 = n.b();
            ArrayList arrayList = b5.get(this.f2933f);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                b5.put(this.f2933f, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f2932e);
            this.f2932e.a(new C0052a(b5));
            this.f2932e.l(this.f2933f, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((l) it.next()).S(this.f2933f);
                }
            }
            this.f2932e.P(this.f2933f);
            return true;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            a();
            n.f2931c.remove(this.f2933f);
            ArrayList arrayList = n.b().get(this.f2933f);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((l) it.next()).S(this.f2933f);
                }
            }
            this.f2932e.m(true);
        }
    }

    public static void a(ViewGroup viewGroup, l lVar) {
        if (!f2931c.contains(viewGroup) && k0.B(viewGroup)) {
            f2931c.add(viewGroup);
            if (lVar == null) {
                lVar = f2929a;
            }
            l n5 = lVar.clone();
            d(viewGroup, n5);
            k.c(viewGroup, (k) null);
            c(viewGroup, n5);
        }
    }

    static m.a<ViewGroup, ArrayList<l>> b() {
        m.a<ViewGroup, ArrayList<l>> aVar;
        WeakReference weakReference = f2930b.get();
        if (weakReference != null && (aVar = (m.a) weakReference.get()) != null) {
            return aVar;
        }
        m.a<ViewGroup, ArrayList<l>> aVar2 = new m.a<>();
        f2930b.set(new WeakReference(aVar2));
        return aVar2;
    }

    private static void c(ViewGroup viewGroup, l lVar) {
        if (lVar != null && viewGroup != null) {
            a aVar = new a(lVar, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    private static void d(ViewGroup viewGroup, l lVar) {
        ArrayList arrayList = b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((l) it.next()).O(viewGroup);
            }
        }
        if (lVar != null) {
            lVar.l(viewGroup, true);
        }
        k b5 = k.b(viewGroup);
        if (b5 != null) {
            b5.a();
        }
    }
}
