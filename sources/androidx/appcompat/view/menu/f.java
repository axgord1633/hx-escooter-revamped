package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.c;
import androidx.appcompat.view.menu.j;
import d.g;

class f implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, j.a {

    /* renamed from: e  reason: collision with root package name */
    private e f894e;

    /* renamed from: f  reason: collision with root package name */
    private c f895f;

    /* renamed from: g  reason: collision with root package name */
    c f896g;

    /* renamed from: h  reason: collision with root package name */
    private j.a f897h;

    public f(e eVar) {
        this.f894e = eVar;
    }

    public void a(e eVar, boolean z4) {
        if (z4 || eVar == this.f894e) {
            c();
        }
        j.a aVar = this.f897h;
        if (aVar != null) {
            aVar.a(eVar, z4);
        }
    }

    public boolean b(e eVar) {
        j.a aVar = this.f897h;
        if (aVar != null) {
            return aVar.b(eVar);
        }
        return false;
    }

    public void c() {
        c cVar = this.f895f;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    public void d(IBinder iBinder) {
        e eVar = this.f894e;
        c.a aVar = new c.a(eVar.u());
        c cVar = new c(aVar.b(), g.f4073j);
        this.f896g = cVar;
        cVar.j(this);
        this.f894e.b(this.f896g);
        aVar.c(this.f896g.b(), this);
        View y4 = eVar.y();
        if (y4 != null) {
            aVar.d(y4);
        } else {
            aVar.e(eVar.w()).h(eVar.x());
        }
        aVar.f(this);
        c a5 = aVar.a();
        this.f895f = a5;
        a5.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f895f.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f895f.show();
    }

    public void onClick(DialogInterface dialogInterface, int i5) {
        this.f894e.L((g) this.f896g.b().getItem(i5), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f896g.a(this.f894e, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i5, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i5 == 82 || i5 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f895f.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f895f.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f894e.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f894e.performShortcut(i5, keyEvent, 0);
    }
}
