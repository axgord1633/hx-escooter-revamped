package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

public abstract class a implements j {

    /* renamed from: e  reason: collision with root package name */
    protected Context f810e;

    /* renamed from: f  reason: collision with root package name */
    protected Context f811f;

    /* renamed from: g  reason: collision with root package name */
    protected e f812g;

    /* renamed from: h  reason: collision with root package name */
    protected LayoutInflater f813h;

    /* renamed from: i  reason: collision with root package name */
    protected LayoutInflater f814i;

    /* renamed from: j  reason: collision with root package name */
    private j.a f815j;

    /* renamed from: k  reason: collision with root package name */
    private int f816k;

    /* renamed from: l  reason: collision with root package name */
    private int f817l;

    /* renamed from: m  reason: collision with root package name */
    protected k f818m;

    /* renamed from: n  reason: collision with root package name */
    private int f819n;

    public a(Context context, int i5, int i6) {
        this.f810e = context;
        this.f813h = LayoutInflater.from(context);
        this.f816k = i5;
        this.f817l = i6;
    }

    public void a(e eVar, boolean z4) {
        j.a aVar = this.f815j;
        if (aVar != null) {
            aVar.a(eVar, z4);
        }
    }

    /* access modifiers changed from: protected */
    public void b(View view, int i5) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f818m).addView(view, i5);
    }

    public void c(Context context, e eVar) {
        this.f811f = context;
        this.f814i = LayoutInflater.from(context);
        this.f812g = eVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d(androidx.appcompat.view.menu.m r2) {
        /*
            r1 = this;
            androidx.appcompat.view.menu.j$a r0 = r1.f815j
            if (r0 == 0) goto L_0x000e
            if (r2 == 0) goto L_0x0007
            goto L_0x0009
        L_0x0007:
            androidx.appcompat.view.menu.e r2 = r1.f812g
        L_0x0009:
            boolean r2 = r0.b(r2)
            return r2
        L_0x000e:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.a.d(androidx.appcompat.view.menu.m):boolean");
    }

    public void e(boolean z4) {
        ViewGroup viewGroup = (ViewGroup) this.f818m;
        if (viewGroup != null) {
            e eVar = this.f812g;
            int i5 = 0;
            if (eVar != null) {
                eVar.r();
                ArrayList<g> E = this.f812g.E();
                int size = E.size();
                int i6 = 0;
                for (int i7 = 0; i7 < size; i7++) {
                    g gVar = E.get(i7);
                    if (q(i6, gVar)) {
                        View childAt = viewGroup.getChildAt(i6);
                        g itemData = childAt instanceof k.a ? ((k.a) childAt).getItemData() : null;
                        View n5 = n(gVar, childAt, viewGroup);
                        if (gVar != itemData) {
                            n5.setPressed(false);
                            n5.jumpDrawablesToCurrentState();
                        }
                        if (n5 != childAt) {
                            b(n5, i6);
                        }
                        i6++;
                    }
                }
                i5 = i6;
            }
            while (i5 < viewGroup.getChildCount()) {
                if (!l(viewGroup, i5)) {
                    i5++;
                }
            }
        }
    }

    public abstract void f(g gVar, k.a aVar);

    public boolean h(e eVar, g gVar) {
        return false;
    }

    public boolean i(e eVar, g gVar) {
        return false;
    }

    public void j(j.a aVar) {
        this.f815j = aVar;
    }

    public k.a k(ViewGroup viewGroup) {
        return (k.a) this.f813h.inflate(this.f817l, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public boolean l(ViewGroup viewGroup, int i5) {
        viewGroup.removeViewAt(i5);
        return true;
    }

    public j.a m() {
        return this.f815j;
    }

    public View n(g gVar, View view, ViewGroup viewGroup) {
        k.a k5 = view instanceof k.a ? (k.a) view : k(viewGroup);
        f(gVar, k5);
        return (View) k5;
    }

    public k o(ViewGroup viewGroup) {
        if (this.f818m == null) {
            k kVar = (k) this.f813h.inflate(this.f816k, viewGroup, false);
            this.f818m = kVar;
            kVar.b(this.f812g);
            e(true);
        }
        return this.f818m;
    }

    public void p(int i5) {
        this.f819n = i5;
    }

    public abstract boolean q(int i5, g gVar);
}
