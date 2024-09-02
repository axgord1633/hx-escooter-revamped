package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import i.e;

abstract class h implements e, j, AdapterView.OnItemClickListener {

    /* renamed from: e  reason: collision with root package name */
    private Rect f925e;

    h() {
    }

    protected static int n(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i5) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i6 = 0;
        int i7 = 0;
        View view = null;
        for (int i8 = 0; i8 < count; i8++) {
            int itemViewType = listAdapter.getItemViewType(i8);
            if (itemViewType != i7) {
                view = null;
                i7 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i8, view, viewGroup);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i5) {
                return i5;
            }
            if (measuredWidth > i6) {
                i6 = measuredWidth;
            }
        }
        return i6;
    }

    protected static boolean w(e eVar) {
        int size = eVar.size();
        for (int i5 = 0; i5 < size; i5++) {
            MenuItem item = eVar.getItem(i5);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    protected static d x(ListAdapter listAdapter) {
        return listAdapter instanceof HeaderViewListAdapter ? (d) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (d) listAdapter;
    }

    public void c(Context context, e eVar) {
    }

    public boolean h(e eVar, g gVar) {
        return false;
    }

    public boolean i(e eVar, g gVar) {
        return false;
    }

    public abstract void k(e eVar);

    /* access modifiers changed from: protected */
    public boolean l() {
        return true;
    }

    public Rect m() {
        return this.f925e;
    }

    public abstract void o(View view);

    public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j5) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        x(listAdapter).f862e.M((MenuItem) listAdapter.getItem(i5), this, l() ? 0 : 4);
    }

    public void p(Rect rect) {
        this.f925e = rect;
    }

    public abstract void q(boolean z4);

    public abstract void r(int i5);

    public abstract void s(int i5);

    public abstract void t(PopupWindow.OnDismissListener onDismissListener);

    public abstract void u(boolean z4);

    public abstract void v(int i5);
}
