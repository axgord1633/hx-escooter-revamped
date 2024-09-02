package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

public class d extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    e f862e;

    /* renamed from: f  reason: collision with root package name */
    private int f863f = -1;

    /* renamed from: g  reason: collision with root package name */
    private boolean f864g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f865h;

    /* renamed from: i  reason: collision with root package name */
    private final LayoutInflater f866i;

    /* renamed from: j  reason: collision with root package name */
    private final int f867j;

    public d(e eVar, LayoutInflater layoutInflater, boolean z4, int i5) {
        this.f865h = z4;
        this.f866i = layoutInflater;
        this.f862e = eVar;
        this.f867j = i5;
        a();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        g v5 = this.f862e.v();
        if (v5 != null) {
            ArrayList<g> z4 = this.f862e.z();
            int size = z4.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (z4.get(i5) == v5) {
                    this.f863f = i5;
                    return;
                }
            }
        }
        this.f863f = -1;
    }

    public e b() {
        return this.f862e;
    }

    /* renamed from: c */
    public g getItem(int i5) {
        ArrayList<g> z4 = this.f865h ? this.f862e.z() : this.f862e.E();
        int i6 = this.f863f;
        if (i6 >= 0 && i5 >= i6) {
            i5++;
        }
        return z4.get(i5);
    }

    public void d(boolean z4) {
        this.f864g = z4;
    }

    public int getCount() {
        ArrayList<g> z4 = this.f865h ? this.f862e.z() : this.f862e.E();
        int i5 = this.f863f;
        int size = z4.size();
        return i5 < 0 ? size : size - 1;
    }

    public long getItemId(int i5) {
        return (long) i5;
    }

    public View getView(int i5, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f866i.inflate(this.f867j, viewGroup, false);
        }
        int groupId = getItem(i5).getGroupId();
        int i6 = i5 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f862e.F() && groupId != (i6 >= 0 ? getItem(i6).getGroupId() : groupId));
        k.a aVar = (k.a) view;
        if (this.f864g) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.d(getItem(i5), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
