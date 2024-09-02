package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.x0;
import androidx.appcompat.widget.z0;
import androidx.core.view.e;
import androidx.core.view.k0;
import d.g;
import java.util.ArrayList;
import java.util.List;

final class b extends h implements View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int F = g.f4068e;
    private boolean A;
    private j.a B;
    ViewTreeObserver C;
    private PopupWindow.OnDismissListener D;
    boolean E;

    /* renamed from: f  reason: collision with root package name */
    private final Context f820f;

    /* renamed from: g  reason: collision with root package name */
    private final int f821g;

    /* renamed from: h  reason: collision with root package name */
    private final int f822h;

    /* renamed from: i  reason: collision with root package name */
    private final int f823i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f824j;

    /* renamed from: k  reason: collision with root package name */
    final Handler f825k;

    /* renamed from: l  reason: collision with root package name */
    private final List<e> f826l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    final List<d> f827m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f828n = new a();

    /* renamed from: o  reason: collision with root package name */
    private final View.OnAttachStateChangeListener f829o = new C0016b();

    /* renamed from: p  reason: collision with root package name */
    private final x0 f830p = new c();

    /* renamed from: q  reason: collision with root package name */
    private int f831q = 0;

    /* renamed from: r  reason: collision with root package name */
    private int f832r = 0;

    /* renamed from: s  reason: collision with root package name */
    private View f833s;

    /* renamed from: t  reason: collision with root package name */
    View f834t;

    /* renamed from: u  reason: collision with root package name */
    private int f835u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f836v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f837w;

    /* renamed from: x  reason: collision with root package name */
    private int f838x;

    /* renamed from: y  reason: collision with root package name */
    private int f839y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f840z;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        public void onGlobalLayout() {
            if (b.this.b() && b.this.f827m.size() > 0 && !b.this.f827m.get(0).f848a.w()) {
                View view = b.this.f834t;
                if (view == null || !view.isShown()) {
                    b.this.dismiss();
                    return;
                }
                for (d dVar : b.this.f827m) {
                    dVar.f848a.show();
                }
            }
        }
    }

    /* renamed from: androidx.appcompat.view.menu.b$b  reason: collision with other inner class name */
    class C0016b implements View.OnAttachStateChangeListener {
        C0016b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = b.this.C;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    b.this.C = view.getViewTreeObserver();
                }
                b bVar = b.this;
                bVar.C.removeGlobalOnLayoutListener(bVar.f828n);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    class c implements x0 {

        class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ d f844e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ MenuItem f845f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ e f846g;

            a(d dVar, MenuItem menuItem, e eVar) {
                this.f844e = dVar;
                this.f845f = menuItem;
                this.f846g = eVar;
            }

            public void run() {
                d dVar = this.f844e;
                if (dVar != null) {
                    b.this.E = true;
                    dVar.f849b.e(false);
                    b.this.E = false;
                }
                if (this.f845f.isEnabled() && this.f845f.hasSubMenu()) {
                    this.f846g.L(this.f845f, 4);
                }
            }
        }

        c() {
        }

        public void a(e eVar, MenuItem menuItem) {
            d dVar = null;
            b.this.f825k.removeCallbacksAndMessages((Object) null);
            int size = b.this.f827m.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size) {
                    i5 = -1;
                    break;
                } else if (eVar == b.this.f827m.get(i5).f849b) {
                    break;
                } else {
                    i5++;
                }
            }
            if (i5 != -1) {
                int i6 = i5 + 1;
                if (i6 < b.this.f827m.size()) {
                    dVar = b.this.f827m.get(i6);
                }
                b.this.f825k.postAtTime(new a(dVar, menuItem, eVar), eVar, SystemClock.uptimeMillis() + 200);
            }
        }

        public void d(e eVar, MenuItem menuItem) {
            b.this.f825k.removeCallbacksAndMessages(eVar);
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        public final z0 f848a;

        /* renamed from: b  reason: collision with root package name */
        public final e f849b;

        /* renamed from: c  reason: collision with root package name */
        public final int f850c;

        public d(z0 z0Var, e eVar, int i5) {
            this.f848a = z0Var;
            this.f849b = eVar;
            this.f850c = i5;
        }

        public ListView a() {
            return this.f848a.f();
        }
    }

    public b(Context context, View view, int i5, int i6, boolean z4) {
        this.f820f = context;
        this.f833s = view;
        this.f822h = i5;
        this.f823i = i6;
        this.f824j = z4;
        this.f840z = false;
        this.f835u = C();
        Resources resources = context.getResources();
        this.f821g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.d.f4000d));
        this.f825k = new Handler();
    }

    private MenuItem A(e eVar, e eVar2) {
        int size = eVar.size();
        for (int i5 = 0; i5 < size; i5++) {
            MenuItem item = eVar.getItem(i5);
            if (item.hasSubMenu() && eVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View B(d dVar, e eVar) {
        int i5;
        d dVar2;
        int firstVisiblePosition;
        MenuItem A2 = A(dVar.f849b, eVar);
        if (A2 == null) {
            return null;
        }
        ListView a5 = dVar.a();
        ListAdapter adapter = a5.getAdapter();
        int i6 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i5 = headerViewListAdapter.getHeadersCount();
            dVar2 = (d) headerViewListAdapter.getWrappedAdapter();
        } else {
            dVar2 = (d) adapter;
            i5 = 0;
        }
        int count = dVar2.getCount();
        while (true) {
            if (i6 >= count) {
                i6 = -1;
                break;
            } else if (A2 == dVar2.getItem(i6)) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 != -1 && (firstVisiblePosition = (i6 + i5) - a5.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a5.getChildCount()) {
            return a5.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int C() {
        return k0.q(this.f833s) == 1 ? 0 : 1;
    }

    private int D(int i5) {
        List<d> list = this.f827m;
        ListView a5 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a5.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f834t.getWindowVisibleDisplayFrame(rect);
        return this.f835u == 1 ? (iArr[0] + a5.getWidth()) + i5 > rect.right ? 0 : 1 : iArr[0] - i5 < 0 ? 1 : 0;
    }

    private void E(e eVar) {
        View view;
        d dVar;
        int i5;
        int i6;
        int i7;
        LayoutInflater from = LayoutInflater.from(this.f820f);
        d dVar2 = new d(eVar, from, this.f824j, F);
        if (!b() && this.f840z) {
            dVar2.d(true);
        } else if (b()) {
            dVar2.d(h.w(eVar));
        }
        int n5 = h.n(dVar2, (ViewGroup) null, this.f820f, this.f821g);
        z0 y4 = y();
        y4.o(dVar2);
        y4.A(n5);
        y4.B(this.f832r);
        if (this.f827m.size() > 0) {
            List<d> list = this.f827m;
            dVar = list.get(list.size() - 1);
            view = B(dVar, eVar);
        } else {
            dVar = null;
            view = null;
        }
        if (view != null) {
            y4.P(false);
            y4.M((Object) null);
            int D2 = D(n5);
            boolean z4 = D2 == 1;
            this.f835u = D2;
            if (Build.VERSION.SDK_INT >= 26) {
                y4.y(view);
                i6 = 0;
                i5 = 0;
            } else {
                int[] iArr = new int[2];
                this.f833s.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.f832r & 7) == 5) {
                    iArr[0] = iArr[0] + this.f833s.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i5 = iArr2[0] - iArr[0];
                i6 = iArr2[1] - iArr[1];
            }
            if ((this.f832r & 5) != 5) {
                if (z4) {
                    n5 = view.getWidth();
                }
                i7 = i5 - n5;
                y4.k(i7);
                y4.H(true);
                y4.i(i6);
            } else if (!z4) {
                n5 = view.getWidth();
                i7 = i5 - n5;
                y4.k(i7);
                y4.H(true);
                y4.i(i6);
            }
            i7 = i5 + n5;
            y4.k(i7);
            y4.H(true);
            y4.i(i6);
        } else {
            if (this.f836v) {
                y4.k(this.f838x);
            }
            if (this.f837w) {
                y4.i(this.f839y);
            }
            y4.C(m());
        }
        this.f827m.add(new d(y4, eVar, this.f835u));
        y4.show();
        ListView f5 = y4.f();
        f5.setOnKeyListener(this);
        if (dVar == null && this.A && eVar.x() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(g.f4075l, f5, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(eVar.x());
            f5.addHeaderView(frameLayout, (Object) null, false);
            y4.show();
        }
    }

    private z0 y() {
        z0 z0Var = new z0(this.f820f, (AttributeSet) null, this.f822h, this.f823i);
        z0Var.O(this.f830p);
        z0Var.G(this);
        z0Var.F(this);
        z0Var.y(this.f833s);
        z0Var.B(this.f832r);
        z0Var.E(true);
        z0Var.D(2);
        return z0Var;
    }

    private int z(e eVar) {
        int size = this.f827m.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (eVar == this.f827m.get(i5).f849b) {
                return i5;
            }
        }
        return -1;
    }

    public void a(e eVar, boolean z4) {
        int z5 = z(eVar);
        if (z5 >= 0) {
            int i5 = z5 + 1;
            if (i5 < this.f827m.size()) {
                this.f827m.get(i5).f849b.e(false);
            }
            d remove = this.f827m.remove(z5);
            remove.f849b.O(this);
            if (this.E) {
                remove.f848a.N((Object) null);
                remove.f848a.z(0);
            }
            remove.f848a.dismiss();
            int size = this.f827m.size();
            this.f835u = size > 0 ? this.f827m.get(size - 1).f850c : C();
            if (size == 0) {
                dismiss();
                j.a aVar = this.B;
                if (aVar != null) {
                    aVar.a(eVar, true);
                }
                ViewTreeObserver viewTreeObserver = this.C;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.C.removeGlobalOnLayoutListener(this.f828n);
                    }
                    this.C = null;
                }
                this.f834t.removeOnAttachStateChangeListener(this.f829o);
                this.D.onDismiss();
            } else if (z4) {
                this.f827m.get(0).f849b.e(false);
            }
        }
    }

    public boolean b() {
        return this.f827m.size() > 0 && this.f827m.get(0).f848a.b();
    }

    public boolean d(m mVar) {
        for (d next : this.f827m) {
            if (mVar == next.f849b) {
                next.a().requestFocus();
                return true;
            }
        }
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        k(mVar);
        j.a aVar = this.B;
        if (aVar != null) {
            aVar.b(mVar);
        }
        return true;
    }

    public void dismiss() {
        int size = this.f827m.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.f827m.toArray(new d[size]);
            for (int i5 = size - 1; i5 >= 0; i5--) {
                d dVar = dVarArr[i5];
                if (dVar.f848a.b()) {
                    dVar.f848a.dismiss();
                }
            }
        }
    }

    public void e(boolean z4) {
        for (d a5 : this.f827m) {
            h.x(a5.a().getAdapter()).notifyDataSetChanged();
        }
    }

    public ListView f() {
        if (this.f827m.isEmpty()) {
            return null;
        }
        List<d> list = this.f827m;
        return list.get(list.size() - 1).a();
    }

    public boolean g() {
        return false;
    }

    public void j(j.a aVar) {
        this.B = aVar;
    }

    public void k(e eVar) {
        eVar.c(this, this.f820f);
        if (b()) {
            E(eVar);
        } else {
            this.f826l.add(eVar);
        }
    }

    /* access modifiers changed from: protected */
    public boolean l() {
        return false;
    }

    public void o(View view) {
        if (this.f833s != view) {
            this.f833s = view;
            this.f832r = e.a(this.f831q, k0.q(view));
        }
    }

    public void onDismiss() {
        d dVar;
        int size = this.f827m.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                dVar = null;
                break;
            }
            dVar = this.f827m.get(i5);
            if (!dVar.f848a.b()) {
                break;
            }
            i5++;
        }
        if (dVar != null) {
            dVar.f849b.e(false);
        }
    }

    public boolean onKey(View view, int i5, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i5 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void q(boolean z4) {
        this.f840z = z4;
    }

    public void r(int i5) {
        if (this.f831q != i5) {
            this.f831q = i5;
            this.f832r = e.a(i5, k0.q(this.f833s));
        }
    }

    public void s(int i5) {
        this.f836v = true;
        this.f838x = i5;
    }

    public void show() {
        if (!b()) {
            for (e E2 : this.f826l) {
                E(E2);
            }
            this.f826l.clear();
            View view = this.f833s;
            this.f834t = view;
            if (view != null) {
                boolean z4 = this.C == null;
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.C = viewTreeObserver;
                if (z4) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f828n);
                }
                this.f834t.addOnAttachStateChangeListener(this.f829o);
            }
        }
    }

    public void t(PopupWindow.OnDismissListener onDismissListener) {
        this.D = onDismissListener;
    }

    public void u(boolean z4) {
        this.A = z4;
    }

    public void v(int i5) {
        this.f837w = true;
        this.f839y = i5;
    }
}
