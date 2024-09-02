package h;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public abstract class b {

    /* renamed from: e  reason: collision with root package name */
    private Object f4771e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4772f;

    public interface a {
        boolean a(b bVar, MenuItem menuItem);

        boolean b(b bVar, Menu menu);

        boolean c(b bVar, Menu menu);

        void d(b bVar);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.f4771e;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.f4772f;
    }

    public abstract void k();

    public abstract boolean l();

    public abstract void m(View view);

    public abstract void n(int i5);

    public abstract void o(CharSequence charSequence);

    public void p(Object obj) {
        this.f4771e = obj;
    }

    public abstract void q(int i5);

    public abstract void r(CharSequence charSequence);

    public void s(boolean z4) {
        this.f4772f = z4;
    }
}
