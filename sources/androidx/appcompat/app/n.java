package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.l1;
import androidx.appcompat.widget.n0;
import androidx.core.view.k0;
import com.yalantis.ucrop.R;
import h.k;
import java.util.ArrayList;

class n extends a {

    /* renamed from: a  reason: collision with root package name */
    n0 f716a;

    /* renamed from: b  reason: collision with root package name */
    boolean f717b;

    /* renamed from: c  reason: collision with root package name */
    Window.Callback f718c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f719d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f720e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<a.b> f721f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f722g = new a();

    /* renamed from: h  reason: collision with root package name */
    private final Toolbar.f f723h;

    class a implements Runnable {
        a() {
        }

        public void run() {
            n.this.y();
        }
    }

    class b implements Toolbar.f {
        b() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return n.this.f718c.onMenuItemSelected(0, menuItem);
        }
    }

    private final class c implements j.a {

        /* renamed from: e  reason: collision with root package name */
        private boolean f726e;

        c() {
        }

        public void a(androidx.appcompat.view.menu.e eVar, boolean z4) {
            if (!this.f726e) {
                this.f726e = true;
                n.this.f716a.h();
                Window.Callback callback = n.this.f718c;
                if (callback != null) {
                    callback.onPanelClosed(R.styleable.AppCompatTheme_textAppearanceSearchResultTitle, eVar);
                }
                this.f726e = false;
            }
        }

        public boolean b(androidx.appcompat.view.menu.e eVar) {
            Window.Callback callback = n.this.f718c;
            if (callback == null) {
                return false;
            }
            callback.onMenuOpened(R.styleable.AppCompatTheme_textAppearanceSearchResultTitle, eVar);
            return true;
        }
    }

    private final class d implements e.a {
        d() {
        }

        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            return false;
        }

        public void b(androidx.appcompat.view.menu.e eVar) {
            n nVar = n.this;
            if (nVar.f718c == null) {
                return;
            }
            if (nVar.f716a.b()) {
                n.this.f718c.onPanelClosed(R.styleable.AppCompatTheme_textAppearanceSearchResultTitle, eVar);
            } else if (n.this.f718c.onPreparePanel(0, (View) null, eVar)) {
                n.this.f718c.onMenuOpened(R.styleable.AppCompatTheme_textAppearanceSearchResultTitle, eVar);
            }
        }
    }

    private class e extends k {
        public e(Window.Callback callback) {
            super(callback);
        }

        public View onCreatePanelView(int i5) {
            return i5 == 0 ? new View(n.this.f716a.getContext()) : super.onCreatePanelView(i5);
        }

        public boolean onPreparePanel(int i5, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i5, view, menu);
            if (onPreparePanel) {
                n nVar = n.this;
                if (!nVar.f717b) {
                    nVar.f716a.c();
                    n.this.f717b = true;
                }
            }
            return onPreparePanel;
        }
    }

    n(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        b bVar = new b();
        this.f723h = bVar;
        this.f716a = new l1(toolbar, false);
        e eVar = new e(callback);
        this.f718c = eVar;
        this.f716a.setWindowCallback(eVar);
        toolbar.setOnMenuItemClickListener(bVar);
        this.f716a.setWindowTitle(charSequence);
    }

    private Menu w() {
        if (!this.f719d) {
            this.f716a.i(new c(), new d());
            this.f719d = true;
        }
        return this.f716a.q();
    }

    public boolean g() {
        return this.f716a.e();
    }

    public boolean h() {
        if (!this.f716a.n()) {
            return false;
        }
        this.f716a.collapseActionView();
        return true;
    }

    public void i(boolean z4) {
        if (z4 != this.f720e) {
            this.f720e = z4;
            int size = this.f721f.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.f721f.get(i5).onMenuVisibilityChanged(z4);
            }
        }
    }

    public int j() {
        return this.f716a.p();
    }

    public Context k() {
        return this.f716a.getContext();
    }

    public boolean l() {
        this.f716a.l().removeCallbacks(this.f722g);
        k0.J(this.f716a.l(), this.f722g);
        return true;
    }

    public void m(Configuration configuration) {
        super.m(configuration);
    }

    /* access modifiers changed from: package-private */
    public void n() {
        this.f716a.l().removeCallbacks(this.f722g);
    }

    public boolean o(int i5, KeyEvent keyEvent) {
        Menu w4 = w();
        if (w4 == null) {
            return false;
        }
        boolean z4 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z4 = false;
        }
        w4.setQwertyMode(z4);
        return w4.performShortcut(i5, keyEvent, 0);
    }

    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            q();
        }
        return true;
    }

    public boolean q() {
        return this.f716a.f();
    }

    public void r(boolean z4) {
    }

    public void s(boolean z4) {
        z(z4 ? 8 : 0, 8);
    }

    public void t(boolean z4) {
    }

    public void u(CharSequence charSequence) {
        this.f716a.setWindowTitle(charSequence);
    }

    public Window.Callback x() {
        return this.f718c;
    }

    /* access modifiers changed from: package-private */
    public void y() {
        Menu w4 = w();
        androidx.appcompat.view.menu.e eVar = w4 instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) w4 : null;
        if (eVar != null) {
            eVar.d0();
        }
        try {
            w4.clear();
            if (!this.f718c.onCreatePanelMenu(0, w4) || !this.f718c.onPreparePanel(0, (View) null, w4)) {
                w4.clear();
            }
        } finally {
            if (eVar != null) {
                eVar.c0();
            }
        }
    }

    public void z(int i5, int i6) {
        this.f716a.o((i5 & i6) | ((~i6) & this.f716a.p()));
    }
}
