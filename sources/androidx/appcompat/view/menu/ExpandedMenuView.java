package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.k1;

public final class ExpandedMenuView extends ListView implements e.b, k, AdapterView.OnItemClickListener {

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f790g = {16842964, 16843049};

    /* renamed from: e  reason: collision with root package name */
    private e f791e;

    /* renamed from: f  reason: collision with root package name */
    private int f792f;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        k1 u5 = k1.u(context, attributeSet, f790g, i5, 0);
        if (u5.r(0)) {
            setBackgroundDrawable(u5.f(0));
        }
        if (u5.r(1)) {
            setDivider(u5.f(1));
        }
        u5.v();
    }

    public boolean a(g gVar) {
        return this.f791e.L(gVar, 0);
    }

    public void b(e eVar) {
        this.f791e = eVar;
    }

    public int getWindowAnimations() {
        return this.f792f;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int i5, long j5) {
        a((g) getAdapter().getItem(i5));
    }
}
