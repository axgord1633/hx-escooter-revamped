package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import d.g;
import java.util.ArrayList;

public class c implements j, AdapterView.OnItemClickListener {

    /* renamed from: e  reason: collision with root package name */
    Context f851e;

    /* renamed from: f  reason: collision with root package name */
    LayoutInflater f852f;

    /* renamed from: g  reason: collision with root package name */
    e f853g;

    /* renamed from: h  reason: collision with root package name */
    ExpandedMenuView f854h;

    /* renamed from: i  reason: collision with root package name */
    int f855i;

    /* renamed from: j  reason: collision with root package name */
    int f856j;

    /* renamed from: k  reason: collision with root package name */
    int f857k;

    /* renamed from: l  reason: collision with root package name */
    private j.a f858l;

    /* renamed from: m  reason: collision with root package name */
    a f859m;

    private class a extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        private int f860e = -1;

        public a() {
            a();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            g v5 = c.this.f853g.v();
            if (v5 != null) {
                ArrayList<g> z4 = c.this.f853g.z();
                int size = z4.size();
                for (int i5 = 0; i5 < size; i5++) {
                    if (z4.get(i5) == v5) {
                        this.f860e = i5;
                        return;
                    }
                }
            }
            this.f860e = -1;
        }

        /* renamed from: b */
        public g getItem(int i5) {
            ArrayList<g> z4 = c.this.f853g.z();
            int i6 = i5 + c.this.f855i;
            int i7 = this.f860e;
            if (i7 >= 0 && i6 >= i7) {
                i6++;
            }
            return z4.get(i6);
        }

        public int getCount() {
            int size = c.this.f853g.z().size() - c.this.f855i;
            return this.f860e < 0 ? size : size - 1;
        }

        public long getItemId(int i5) {
            return (long) i5;
        }

        public View getView(int i5, View view, ViewGroup viewGroup) {
            if (view == null) {
                c cVar = c.this;
                view = cVar.f852f.inflate(cVar.f857k, viewGroup, false);
            }
            ((k.a) view).d(getItem(i5), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public c(int i5, int i6) {
        this.f857k = i5;
        this.f856j = i6;
    }

    public c(Context context, int i5) {
        this(i5, 0);
        this.f851e = context;
        this.f852f = LayoutInflater.from(context);
    }

    public void a(e eVar, boolean z4) {
        j.a aVar = this.f858l;
        if (aVar != null) {
            aVar.a(eVar, z4);
        }
    }

    public ListAdapter b() {
        if (this.f859m == null) {
            this.f859m = new a();
        }
        return this.f859m;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(android.content.Context r3, androidx.appcompat.view.menu.e r4) {
        /*
            r2 = this;
            int r0 = r2.f856j
            if (r0 == 0) goto L_0x0014
            android.view.ContextThemeWrapper r0 = new android.view.ContextThemeWrapper
            int r1 = r2.f856j
            r0.<init>(r3, r1)
            r2.f851e = r0
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r0)
        L_0x0011:
            r2.f852f = r3
            goto L_0x0023
        L_0x0014:
            android.content.Context r0 = r2.f851e
            if (r0 == 0) goto L_0x0023
            r2.f851e = r3
            android.view.LayoutInflater r0 = r2.f852f
            if (r0 != 0) goto L_0x0023
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            goto L_0x0011
        L_0x0023:
            r2.f853g = r4
            androidx.appcompat.view.menu.c$a r3 = r2.f859m
            if (r3 == 0) goto L_0x002c
            r3.notifyDataSetChanged()
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.c.c(android.content.Context, androidx.appcompat.view.menu.e):void");
    }

    public boolean d(m mVar) {
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        new f(mVar).d((IBinder) null);
        j.a aVar = this.f858l;
        if (aVar == null) {
            return true;
        }
        aVar.b(mVar);
        return true;
    }

    public void e(boolean z4) {
        a aVar = this.f859m;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public k f(ViewGroup viewGroup) {
        if (this.f854h == null) {
            this.f854h = (ExpandedMenuView) this.f852f.inflate(g.f4070g, viewGroup, false);
            if (this.f859m == null) {
                this.f859m = new a();
            }
            this.f854h.setAdapter(this.f859m);
            this.f854h.setOnItemClickListener(this);
        }
        return this.f854h;
    }

    public boolean g() {
        return false;
    }

    public boolean h(e eVar, g gVar) {
        return false;
    }

    public boolean i(e eVar, g gVar) {
        return false;
    }

    public void j(j.a aVar) {
        this.f858l = aVar;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j5) {
        this.f853g.M(this.f859m.getItem(i5), this, 0);
    }
}
