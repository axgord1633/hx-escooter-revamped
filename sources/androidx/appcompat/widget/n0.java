package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.core.view.k1;

public interface n0 {
    void a(Menu menu, j.a aVar);

    boolean b();

    void c();

    void collapseActionView();

    boolean d();

    boolean e();

    boolean f();

    boolean g();

    Context getContext();

    CharSequence getTitle();

    void h();

    void i(j.a aVar, e.a aVar2);

    void j(int i5);

    void k(d1 d1Var);

    ViewGroup l();

    void m(boolean z4);

    boolean n();

    void o(int i5);

    int p();

    Menu q();

    void r(int i5);

    int s();

    void setIcon(int i5);

    void setIcon(Drawable drawable);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    k1 t(int i5, long j5);

    void u();

    void v();

    void w(boolean z4);
}
