package s;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import s.b;

public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: e  reason: collision with root package name */
    protected boolean f6717e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f6718f;

    /* renamed from: g  reason: collision with root package name */
    protected Cursor f6719g;

    /* renamed from: h  reason: collision with root package name */
    protected Context f6720h;

    /* renamed from: i  reason: collision with root package name */
    protected int f6721i;

    /* renamed from: j  reason: collision with root package name */
    protected C0107a f6722j;

    /* renamed from: k  reason: collision with root package name */
    protected DataSetObserver f6723k;

    /* renamed from: l  reason: collision with root package name */
    protected b f6724l;

    /* renamed from: s.a$a  reason: collision with other inner class name */
    private class C0107a extends ContentObserver {
        C0107a() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z4) {
            a.this.h();
        }
    }

    private class b extends DataSetObserver {
        b() {
        }

        public void onChanged() {
            a aVar = a.this;
            aVar.f6717e = true;
            aVar.notifyDataSetChanged();
        }

        public void onInvalidated() {
            a aVar = a.this;
            aVar.f6717e = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z4) {
        e(context, cursor, z4 ? 1 : 2);
    }

    public void a(Cursor cursor) {
        Cursor i5 = i(cursor);
        if (i5 != null) {
            i5.close();
        }
    }

    public Cursor b() {
        return this.f6719g;
    }

    public abstract CharSequence convertToString(Cursor cursor);

    public abstract void d(View view, Context context, Cursor cursor);

    /* access modifiers changed from: package-private */
    public void e(Context context, Cursor cursor, int i5) {
        b bVar;
        boolean z4 = false;
        if ((i5 & 1) == 1) {
            i5 |= 2;
            this.f6718f = true;
        } else {
            this.f6718f = false;
        }
        if (cursor != null) {
            z4 = true;
        }
        this.f6719g = cursor;
        this.f6717e = z4;
        this.f6720h = context;
        this.f6721i = z4 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i5 & 2) == 2) {
            this.f6722j = new C0107a();
            bVar = new b();
        } else {
            bVar = null;
            this.f6722j = null;
        }
        this.f6723k = bVar;
        if (z4) {
            C0107a aVar = this.f6722j;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f6723k;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View f(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    public int getCount() {
        Cursor cursor;
        if (!this.f6717e || (cursor = this.f6719g) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public View getDropDownView(int i5, View view, ViewGroup viewGroup) {
        if (!this.f6717e) {
            return null;
        }
        this.f6719g.moveToPosition(i5);
        if (view == null) {
            view = f(this.f6720h, this.f6719g, viewGroup);
        }
        d(view, this.f6720h, this.f6719g);
        return view;
    }

    public Filter getFilter() {
        if (this.f6724l == null) {
            this.f6724l = new b(this);
        }
        return this.f6724l;
    }

    public Object getItem(int i5) {
        Cursor cursor;
        if (!this.f6717e || (cursor = this.f6719g) == null) {
            return null;
        }
        cursor.moveToPosition(i5);
        return this.f6719g;
    }

    public long getItemId(int i5) {
        Cursor cursor;
        if (!this.f6717e || (cursor = this.f6719g) == null || !cursor.moveToPosition(i5)) {
            return 0;
        }
        return this.f6719g.getLong(this.f6721i);
    }

    public View getView(int i5, View view, ViewGroup viewGroup) {
        if (!this.f6717e) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f6719g.moveToPosition(i5)) {
            if (view == null) {
                view = g(this.f6720h, this.f6719g, viewGroup);
            }
            d(view, this.f6720h, this.f6719g);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i5);
        }
    }

    /* access modifiers changed from: protected */
    public void h() {
        Cursor cursor;
        if (this.f6718f && (cursor = this.f6719g) != null && !cursor.isClosed()) {
            this.f6717e = this.f6719g.requery();
        }
    }

    public Cursor i(Cursor cursor) {
        Cursor cursor2 = this.f6719g;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0107a aVar = this.f6722j;
            if (aVar != null) {
                cursor2.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f6723k;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f6719g = cursor;
        if (cursor != null) {
            C0107a aVar2 = this.f6722j;
            if (aVar2 != null) {
                cursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.f6723k;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f6721i = cursor.getColumnIndexOrThrow("_id");
            this.f6717e = true;
            notifyDataSetChanged();
        } else {
            this.f6721i = -1;
            this.f6717e = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
