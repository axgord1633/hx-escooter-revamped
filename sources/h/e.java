package h;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContextView;
import h.b;
import java.lang.ref.WeakReference;

public class e extends b implements e.a {

    /* renamed from: g  reason: collision with root package name */
    private Context f4778g;

    /* renamed from: h  reason: collision with root package name */
    private ActionBarContextView f4779h;

    /* renamed from: i  reason: collision with root package name */
    private b.a f4780i;

    /* renamed from: j  reason: collision with root package name */
    private WeakReference<View> f4781j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4782k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f4783l;

    /* renamed from: m  reason: collision with root package name */
    private androidx.appcompat.view.menu.e f4784m;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z4) {
        this.f4778g = context;
        this.f4779h = actionBarContextView;
        this.f4780i = aVar;
        androidx.appcompat.view.menu.e S = new androidx.appcompat.view.menu.e(actionBarContextView.getContext()).S(1);
        this.f4784m = S;
        S.R(this);
        this.f4783l = z4;
    }

    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        return this.f4780i.a(this, menuItem);
    }

    public void b(androidx.appcompat.view.menu.e eVar) {
        k();
        this.f4779h.l();
    }

    public void c() {
        if (!this.f4782k) {
            this.f4782k = true;
            this.f4779h.sendAccessibilityEvent(32);
            this.f4780i.d(this);
        }
    }

    public View d() {
        WeakReference<View> weakReference = this.f4781j;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Menu e() {
        return this.f4784m;
    }

    public MenuInflater f() {
        return new g(this.f4779h.getContext());
    }

    public CharSequence g() {
        return this.f4779h.getSubtitle();
    }

    public CharSequence i() {
        return this.f4779h.getTitle();
    }

    public void k() {
        this.f4780i.c(this, this.f4784m);
    }

    public boolean l() {
        return this.f4779h.j();
    }

    public void m(View view) {
        this.f4779h.setCustomView(view);
        this.f4781j = view != null ? new WeakReference<>(view) : null;
    }

    public void n(int i5) {
        o(this.f4778g.getString(i5));
    }

    public void o(CharSequence charSequence) {
        this.f4779h.setSubtitle(charSequence);
    }

    public void q(int i5) {
        r(this.f4778g.getString(i5));
    }

    public void r(CharSequence charSequence) {
        this.f4779h.setTitle(charSequence);
    }

    public void s(boolean z4) {
        super.s(z4);
        this.f4779h.setTitleOptional(z4);
    }
}
