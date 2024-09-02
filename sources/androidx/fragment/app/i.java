package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.core.util.d;
import androidx.lifecycle.f0;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private final k<?> f2316a;

    private i(k<?> kVar) {
        this.f2316a = kVar;
    }

    public static i b(k<?> kVar) {
        return new i((k) d.i(kVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        k<?> kVar = this.f2316a;
        kVar.f2322i.k(kVar, kVar, fragment);
    }

    public void c() {
        this.f2316a.f2322i.z();
    }

    public void d(Configuration configuration) {
        this.f2316a.f2322i.B(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f2316a.f2322i.C(menuItem);
    }

    public void f() {
        this.f2316a.f2322i.D();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f2316a.f2322i.E(menu, menuInflater);
    }

    public void h() {
        this.f2316a.f2322i.F();
    }

    public void i() {
        this.f2316a.f2322i.H();
    }

    public void j(boolean z4) {
        this.f2316a.f2322i.I(z4);
    }

    public boolean k(MenuItem menuItem) {
        return this.f2316a.f2322i.K(menuItem);
    }

    public void l(Menu menu) {
        this.f2316a.f2322i.L(menu);
    }

    public void m() {
        this.f2316a.f2322i.N();
    }

    public void n(boolean z4) {
        this.f2316a.f2322i.O(z4);
    }

    public boolean o(Menu menu) {
        return this.f2316a.f2322i.P(menu);
    }

    public void p() {
        this.f2316a.f2322i.R();
    }

    public void q() {
        this.f2316a.f2322i.S();
    }

    public void r() {
        this.f2316a.f2322i.U();
    }

    public boolean s() {
        return this.f2316a.f2322i.b0(true);
    }

    public n t() {
        return this.f2316a.f2322i;
    }

    public void u() {
        this.f2316a.f2322i.T0();
    }

    public View v(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f2316a.f2322i.u0().onCreateView(view, str, context, attributeSet);
    }

    public void w(Parcelable parcelable) {
        k<?> kVar = this.f2316a;
        if (kVar instanceof f0) {
            kVar.f2322i.g1(parcelable);
            return;
        }
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    public Parcelable x() {
        return this.f2316a.f2322i.i1();
    }
}
