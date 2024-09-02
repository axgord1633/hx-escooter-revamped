package s;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class c extends a {

    /* renamed from: m  reason: collision with root package name */
    private int f6728m;

    /* renamed from: n  reason: collision with root package name */
    private int f6729n;

    /* renamed from: o  reason: collision with root package name */
    private LayoutInflater f6730o;

    @Deprecated
    public c(Context context, int i5, Cursor cursor, boolean z4) {
        super(context, cursor, z4);
        this.f6729n = i5;
        this.f6728m = i5;
        this.f6730o = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View f(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f6730o.inflate(this.f6729n, viewGroup, false);
    }

    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f6730o.inflate(this.f6728m, viewGroup, false);
    }
}
