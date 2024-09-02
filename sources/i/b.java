package i;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import m.g;
import o.c;

abstract class b {

    /* renamed from: a  reason: collision with root package name */
    final Context f4860a;

    /* renamed from: b  reason: collision with root package name */
    private g<o.b, MenuItem> f4861b;

    /* renamed from: c  reason: collision with root package name */
    private g<c, SubMenu> f4862c;

    b(Context context) {
        this.f4860a = context;
    }

    /* access modifiers changed from: package-private */
    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof o.b)) {
            return menuItem;
        }
        o.b bVar = (o.b) menuItem;
        if (this.f4861b == null) {
            this.f4861b = new g<>();
        }
        MenuItem menuItem2 = this.f4861b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        c cVar = new c(this.f4860a, bVar);
        this.f4861b.put(bVar, cVar);
        return cVar;
    }

    /* access modifiers changed from: package-private */
    public final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof c)) {
            return subMenu;
        }
        c cVar = (c) subMenu;
        if (this.f4862c == null) {
            this.f4862c = new g<>();
        }
        SubMenu subMenu2 = this.f4862c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        f fVar = new f(this.f4860a, cVar);
        this.f4862c.put(cVar, fVar);
        return fVar;
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        g<o.b, MenuItem> gVar = this.f4861b;
        if (gVar != null) {
            gVar.clear();
        }
        g<c, SubMenu> gVar2 = this.f4862c;
        if (gVar2 != null) {
            gVar2.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final void f(int i5) {
        if (this.f4861b != null) {
            int i6 = 0;
            while (i6 < this.f4861b.size()) {
                if (this.f4861b.i(i6).getGroupId() == i5) {
                    this.f4861b.k(i6);
                    i6--;
                }
                i6++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void g(int i5) {
        if (this.f4861b != null) {
            for (int i6 = 0; i6 < this.f4861b.size(); i6++) {
                if (this.f4861b.i(i6).getItemId() == i5) {
                    this.f4861b.k(i6);
                    return;
                }
            }
        }
    }
}
