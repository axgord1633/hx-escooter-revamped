package h;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import h.b;
import i.c;
import i.d;
import java.util.ArrayList;
import m.g;

public class f extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    final Context f4785a;

    /* renamed from: b  reason: collision with root package name */
    final b f4786b;

    public static class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final ActionMode.Callback f4787a;

        /* renamed from: b  reason: collision with root package name */
        final Context f4788b;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<f> f4789c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        final g<Menu, Menu> f4790d = new g<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f4788b = context;
            this.f4787a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = this.f4790d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            d dVar = new d(this.f4788b, (o.a) menu);
            this.f4790d.put(menu, dVar);
            return dVar;
        }

        public boolean a(b bVar, MenuItem menuItem) {
            return this.f4787a.onActionItemClicked(e(bVar), new c(this.f4788b, (o.b) menuItem));
        }

        public boolean b(b bVar, Menu menu) {
            return this.f4787a.onCreateActionMode(e(bVar), f(menu));
        }

        public boolean c(b bVar, Menu menu) {
            return this.f4787a.onPrepareActionMode(e(bVar), f(menu));
        }

        public void d(b bVar) {
            this.f4787a.onDestroyActionMode(e(bVar));
        }

        public ActionMode e(b bVar) {
            int size = this.f4789c.size();
            for (int i5 = 0; i5 < size; i5++) {
                f fVar = this.f4789c.get(i5);
                if (fVar != null && fVar.f4786b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f4788b, bVar);
            this.f4789c.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.f4785a = context;
        this.f4786b = bVar;
    }

    public void finish() {
        this.f4786b.c();
    }

    public View getCustomView() {
        return this.f4786b.d();
    }

    public Menu getMenu() {
        return new d(this.f4785a, (o.a) this.f4786b.e());
    }

    public MenuInflater getMenuInflater() {
        return this.f4786b.f();
    }

    public CharSequence getSubtitle() {
        return this.f4786b.g();
    }

    public Object getTag() {
        return this.f4786b.h();
    }

    public CharSequence getTitle() {
        return this.f4786b.i();
    }

    public boolean getTitleOptionalHint() {
        return this.f4786b.j();
    }

    public void invalidate() {
        this.f4786b.k();
    }

    public boolean isTitleOptional() {
        return this.f4786b.l();
    }

    public void setCustomView(View view) {
        this.f4786b.m(view);
    }

    public void setSubtitle(int i5) {
        this.f4786b.n(i5);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f4786b.o(charSequence);
    }

    public void setTag(Object obj) {
        this.f4786b.p(obj);
    }

    public void setTitle(int i5) {
        this.f4786b.q(i5);
    }

    public void setTitle(CharSequence charSequence) {
        this.f4786b.r(charSequence);
    }

    public void setTitleOptionalHint(boolean z4) {
        this.f4786b.s(z4);
    }
}
