package s;

import android.database.Cursor;
import android.widget.Filter;

class b extends Filter {

    /* renamed from: a  reason: collision with root package name */
    a f6727a;

    interface a {
        void a(Cursor cursor);

        Cursor b();

        Cursor c(CharSequence charSequence);

        CharSequence convertToString(Cursor cursor);
    }

    b(a aVar) {
        this.f6727a = aVar;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f6727a.convertToString((Cursor) obj);
    }

    /* access modifiers changed from: protected */
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor c5 = this.f6727a.c(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (c5 != null) {
            filterResults.count = c5.getCount();
        } else {
            filterResults.count = 0;
            c5 = null;
        }
        filterResults.values = c5;
        return filterResults;
    }

    /* access modifiers changed from: protected */
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor b5 = this.f6727a.b();
        Object obj = filterResults.values;
        if (obj != null && obj != b5) {
            this.f6727a.a((Cursor) obj);
        }
    }
}
