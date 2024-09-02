package androidx.fragment.app;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.os.e;
import androidx.core.view.h1;
import androidx.core.view.i0;
import androidx.core.view.k0;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class z {

    class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f2504e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ArrayList f2505f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ ArrayList f2506g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ ArrayList f2507h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ ArrayList f2508i;

        a(int i5, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f2504e = i5;
            this.f2505f = arrayList;
            this.f2506g = arrayList2;
            this.f2507h = arrayList3;
            this.f2508i = arrayList4;
        }

        public void run() {
            for (int i5 = 0; i5 < this.f2504e; i5++) {
                k0.Y((View) this.f2505f.get(i5), (String) this.f2506g.get(i5));
                k0.Y((View) this.f2507h.get(i5), (String) this.f2508i.get(i5));
            }
        }
    }

    class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f2510e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Map f2511f;

        b(ArrayList arrayList, Map map) {
            this.f2510e = arrayList;
            this.f2511f = map;
        }

        public void run() {
            int size = this.f2510e.size();
            for (int i5 = 0; i5 < size; i5++) {
                View view = (View) this.f2510e.get(i5);
                String v5 = k0.v(view);
                if (v5 != null) {
                    k0.Y(view, z.i(this.f2511f, v5));
                }
            }
        }
    }

    class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f2513e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Map f2514f;

        c(ArrayList arrayList, Map map) {
            this.f2513e = arrayList;
            this.f2514f = map;
        }

        public void run() {
            int size = this.f2513e.size();
            for (int i5 = 0; i5 < size; i5++) {
                View view = (View) this.f2513e.get(i5);
                k0.Y(view, (String) this.f2514f.get(k0.v(view)));
            }
        }
    }

    protected static void d(List<View> list, View view) {
        int size = list.size();
        if (!h(list, view, size)) {
            if (k0.v(view) != null) {
                list.add(view);
            }
            for (int i5 = size; i5 < list.size(); i5++) {
                View view2 = list.get(i5);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i6 = 0; i6 < childCount; i6++) {
                        View childAt = viewGroup.getChildAt(i6);
                        if (!h(list, childAt, size) && k0.v(childAt) != null) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    private static boolean h(List<View> list, View view, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            if (list.get(i6) == view) {
                return true;
            }
        }
        return false;
    }

    static String i(Map<String, String> map, String str) {
        for (Map.Entry next : map.entrySet()) {
            if (str.equals(next.getValue())) {
                return (String) next.getKey();
            }
        }
        return null;
    }

    protected static boolean l(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void A(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object B(Object obj);

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList<View> arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    /* access modifiers changed from: package-private */
    public void f(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            boolean z4 = view instanceof ViewGroup;
            ViewGroup viewGroup = view;
            if (z4) {
                ViewGroup viewGroup2 = (ViewGroup) view;
                boolean a5 = h1.a(viewGroup2);
                viewGroup = viewGroup2;
                if (!a5) {
                    int childCount = viewGroup2.getChildCount();
                    for (int i5 = 0; i5 < childCount; i5++) {
                        f(arrayList, viewGroup2.getChildAt(i5));
                    }
                    return;
                }
            }
            arrayList.add(viewGroup);
        }
    }

    public abstract Object g(Object obj);

    /* access modifiers changed from: package-private */
    public void j(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String v5 = k0.v(view);
            if (v5 != null) {
                map.put(v5, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    j(map, viewGroup.getChildAt(i5));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void k(View view, Rect rect) {
        if (k0.A(view)) {
            RectF rectF = new RectF();
            rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, (float) view.getWidth(), (float) view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset((float) view.getLeft(), (float) view.getTop());
            ViewParent parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
                view2.getMatrix().mapRect(rectF);
                rectF.offset((float) view2.getLeft(), (float) view2.getTop());
                parent = view2.getParent();
            }
            int[] iArr = new int[2];
            view.getRootView().getLocationOnScreen(iArr);
            rectF.offset((float) iArr[0], (float) iArr[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public abstract Object m(Object obj, Object obj2, Object obj3);

    public abstract Object n(Object obj, Object obj2, Object obj3);

    /* access modifiers changed from: package-private */
    public ArrayList<String> o(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = arrayList.get(i5);
            arrayList2.add(k0.v(view));
            k0.Y(view, (String) null);
        }
        return arrayList2;
    }

    public abstract void p(Object obj, View view);

    public abstract void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract void r(Object obj, View view, ArrayList<View> arrayList);

    /* access modifiers changed from: package-private */
    public void s(ViewGroup viewGroup, ArrayList<View> arrayList, Map<String, String> map) {
        i0.a(viewGroup, new c(arrayList, map));
    }

    public abstract void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void u(Object obj, Rect rect);

    public abstract void v(Object obj, View view);

    public void w(Fragment fragment, Object obj, e eVar, Runnable runnable) {
        runnable.run();
    }

    /* access modifiers changed from: package-private */
    public void x(View view, ArrayList<View> arrayList, Map<String, String> map) {
        i0.a(view, new b(arrayList, map));
    }

    /* access modifiers changed from: package-private */
    public void y(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = arrayList.get(i5);
            String v5 = k0.v(view2);
            arrayList4.add(v5);
            if (v5 != null) {
                k0.Y(view2, (String) null);
                String str = map.get(v5);
                int i6 = 0;
                while (true) {
                    if (i6 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i6))) {
                        k0.Y(arrayList2.get(i6), v5);
                        break;
                    } else {
                        i6++;
                    }
                }
            }
        }
        i0.a(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void z(Object obj, View view, ArrayList<View> arrayList);
}
