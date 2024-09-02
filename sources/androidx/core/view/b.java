package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1887a;

    /* renamed from: b  reason: collision with root package name */
    private a f1888b;

    /* renamed from: c  reason: collision with root package name */
    private C0031b f1889c;

    public interface a {
    }

    /* renamed from: androidx.core.view.b$b  reason: collision with other inner class name */
    public interface C0031b {
        void onActionProviderVisibilityChanged(boolean z4);
    }

    public b(Context context) {
        this.f1887a = context;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(MenuItem menuItem) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public void f(SubMenu subMenu) {
    }

    public boolean g() {
        return false;
    }

    public void h() {
        this.f1889c = null;
        this.f1888b = null;
    }

    public void i(a aVar) {
        this.f1888b = aVar;
    }

    public void j(C0031b bVar) {
        if (!(this.f1889c == null || bVar == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f1889c = bVar;
    }
}
