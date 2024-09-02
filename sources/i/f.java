package i;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import o.c;

class f extends d implements SubMenu {

    /* renamed from: e  reason: collision with root package name */
    private final c f4875e;

    f(Context context, c cVar) {
        super(context, cVar);
        this.f4875e = cVar;
    }

    public void clearHeader() {
        this.f4875e.clearHeader();
    }

    public MenuItem getItem() {
        return c(this.f4875e.getItem());
    }

    public SubMenu setHeaderIcon(int i5) {
        this.f4875e.setHeaderIcon(i5);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f4875e.setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int i5) {
        this.f4875e.setHeaderTitle(i5);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f4875e.setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        this.f4875e.setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int i5) {
        this.f4875e.setIcon(i5);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f4875e.setIcon(drawable);
        return this;
    }
}
