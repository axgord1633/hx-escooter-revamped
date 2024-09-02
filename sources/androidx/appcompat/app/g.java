package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.m0;
import androidx.appcompat.widget.r1;
import androidx.core.content.res.h;
import androidx.core.view.f;
import androidx.core.view.f0;
import androidx.core.view.k0;
import androidx.core.view.k1;
import androidx.core.view.l1;
import androidx.core.view.m1;
import androidx.core.view.o1;
import androidx.lifecycle.f;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import h.b;
import h.f;
import java.util.List;

class g extends f implements e.a, LayoutInflater.Factory2 {

    /* renamed from: f0  reason: collision with root package name */
    private static final m.g<String, Integer> f626f0 = new m.g<>();

    /* renamed from: g0  reason: collision with root package name */
    private static final boolean f627g0 = false;

    /* renamed from: h0  reason: collision with root package name */
    private static final int[] f628h0 = {16842836};

    /* renamed from: i0  reason: collision with root package name */
    private static final boolean f629i0 = (!"robolectric".equals(Build.FINGERPRINT));

    /* renamed from: j0  reason: collision with root package name */
    private static final boolean f630j0 = true;
    private TextView A;
    private View B;
    private boolean C;
    private boolean D;
    boolean E;
    boolean F;
    boolean G;
    boolean H;
    boolean I;
    private boolean J;
    private s[] K;
    private s L;
    private boolean M;
    private boolean N;
    private boolean O;
    private boolean P;
    boolean Q;
    private int R;
    private int S;
    private boolean T;
    private boolean U;
    private o V;
    private o W;
    boolean X;
    int Y;
    private final Runnable Z;

    /* renamed from: a0  reason: collision with root package name */
    private boolean f631a0;

    /* renamed from: b0  reason: collision with root package name */
    private Rect f632b0;

    /* renamed from: c0  reason: collision with root package name */
    private Rect f633c0;

    /* renamed from: d0  reason: collision with root package name */
    private k f634d0;

    /* renamed from: e0  reason: collision with root package name */
    private l f635e0;

    /* renamed from: h  reason: collision with root package name */
    final Object f636h;

    /* renamed from: i  reason: collision with root package name */
    final Context f637i;

    /* renamed from: j  reason: collision with root package name */
    Window f638j;

    /* renamed from: k  reason: collision with root package name */
    private m f639k;

    /* renamed from: l  reason: collision with root package name */
    final e f640l;

    /* renamed from: m  reason: collision with root package name */
    a f641m;

    /* renamed from: n  reason: collision with root package name */
    MenuInflater f642n;

    /* renamed from: o  reason: collision with root package name */
    private CharSequence f643o;

    /* renamed from: p  reason: collision with root package name */
    private m0 f644p;

    /* renamed from: q  reason: collision with root package name */
    private C0015g f645q;

    /* renamed from: r  reason: collision with root package name */
    private t f646r;

    /* renamed from: s  reason: collision with root package name */
    h.b f647s;

    /* renamed from: t  reason: collision with root package name */
    ActionBarContextView f648t;

    /* renamed from: u  reason: collision with root package name */
    PopupWindow f649u;

    /* renamed from: v  reason: collision with root package name */
    Runnable f650v;

    /* renamed from: w  reason: collision with root package name */
    k1 f651w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f652x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f653y;

    /* renamed from: z  reason: collision with root package name */
    ViewGroup f654z;

    class a implements Runnable {
        a() {
        }

        public void run() {
            g gVar = g.this;
            if ((gVar.Y & 1) != 0) {
                gVar.Y(0);
            }
            g gVar2 = g.this;
            if ((gVar2.Y & 4096) != 0) {
                gVar2.Y(R.styleable.AppCompatTheme_textAppearanceSearchResultTitle);
            }
            g gVar3 = g.this;
            gVar3.X = false;
            gVar3.Y = 0;
        }
    }

    class b implements f0 {
        b() {
        }

        public o1 a(View view, o1 o1Var) {
            int k5 = o1Var.k();
            int O0 = g.this.O0(o1Var, (Rect) null);
            if (k5 != O0) {
                o1Var = o1Var.p(o1Var.i(), O0, o1Var.j(), o1Var.h());
            }
            return k0.F(view, o1Var);
        }
    }

    class c implements ContentFrameLayout.a {
        c() {
        }

        public void a() {
        }

        public void onDetachedFromWindow() {
            g.this.W();
        }
    }

    class d implements Runnable {

        class a extends m1 {
            a() {
            }

            public void b(View view) {
                g.this.f648t.setAlpha(1.0f);
                g.this.f651w.h((l1) null);
                g.this.f651w = null;
            }

            public void c(View view) {
                g.this.f648t.setVisibility(0);
            }
        }

        d() {
        }

        public void run() {
            g gVar = g.this;
            gVar.f649u.showAtLocation(gVar.f648t, 55, 0, 0);
            g.this.Z();
            if (g.this.H0()) {
                g.this.f648t.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
                g gVar2 = g.this;
                gVar2.f651w = k0.c(gVar2.f648t).b(1.0f);
                g.this.f651w.h(new a());
                return;
            }
            g.this.f648t.setAlpha(1.0f);
            g.this.f648t.setVisibility(0);
        }
    }

    class e extends m1 {
        e() {
        }

        public void b(View view) {
            g.this.f648t.setAlpha(1.0f);
            g.this.f651w.h((l1) null);
            g.this.f651w = null;
        }

        public void c(View view) {
            g.this.f648t.setVisibility(0);
            g.this.f648t.sendAccessibilityEvent(32);
            if (g.this.f648t.getParent() instanceof View) {
                k0.L((View) g.this.f648t.getParent());
            }
        }
    }

    private class f implements b {
        f() {
        }
    }

    /* renamed from: androidx.appcompat.app.g$g  reason: collision with other inner class name */
    private final class C0015g implements j.a {
        C0015g() {
        }

        public void a(androidx.appcompat.view.menu.e eVar, boolean z4) {
            g.this.P(eVar);
        }

        public boolean b(androidx.appcompat.view.menu.e eVar) {
            Window.Callback j02 = g.this.j0();
            if (j02 == null) {
                return true;
            }
            j02.onMenuOpened(R.styleable.AppCompatTheme_textAppearanceSearchResultTitle, eVar);
            return true;
        }
    }

    class h implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private b.a f663a;

        class a extends m1 {
            a() {
            }

            public void b(View view) {
                g.this.f648t.setVisibility(8);
                g gVar = g.this;
                PopupWindow popupWindow = gVar.f649u;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (gVar.f648t.getParent() instanceof View) {
                    k0.L((View) g.this.f648t.getParent());
                }
                g.this.f648t.k();
                g.this.f651w.h((l1) null);
                g gVar2 = g.this;
                gVar2.f651w = null;
                k0.L(gVar2.f654z);
            }
        }

        public h(b.a aVar) {
            this.f663a = aVar;
        }

        public boolean a(h.b bVar, MenuItem menuItem) {
            return this.f663a.a(bVar, menuItem);
        }

        public boolean b(h.b bVar, Menu menu) {
            return this.f663a.b(bVar, menu);
        }

        public boolean c(h.b bVar, Menu menu) {
            k0.L(g.this.f654z);
            return this.f663a.c(bVar, menu);
        }

        public void d(h.b bVar) {
            this.f663a.d(bVar);
            g gVar = g.this;
            if (gVar.f649u != null) {
                gVar.f638j.getDecorView().removeCallbacks(g.this.f650v);
            }
            g gVar2 = g.this;
            if (gVar2.f648t != null) {
                gVar2.Z();
                g gVar3 = g.this;
                gVar3.f651w = k0.c(gVar3.f648t).b(CropImageView.DEFAULT_ASPECT_RATIO);
                g.this.f651w.h(new a());
            }
            g gVar4 = g.this;
            e eVar = gVar4.f640l;
            if (eVar != null) {
                eVar.onSupportActionModeFinished(gVar4.f647s);
            }
            g gVar5 = g.this;
            gVar5.f647s = null;
            k0.L(gVar5.f654z);
        }
    }

    static class i {
        static Context a(Context context, Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }

        static void b(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i5 = configuration.densityDpi;
            int i6 = configuration2.densityDpi;
            if (i5 != i6) {
                configuration3.densityDpi = i6;
            }
        }
    }

    static class j {
        static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }
    }

    static class k {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList a5 = configuration.getLocales();
            LocaleList a6 = configuration2.getLocales();
            if (!a5.equals(a6)) {
                configuration3.setLocales(a6);
                configuration3.locale = configuration2.locale;
            }
        }
    }

    static class l {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i5 = configuration.colorMode & 3;
            int i6 = configuration2.colorMode;
            if (i5 != (i6 & 3)) {
                configuration3.colorMode |= i6 & 3;
            }
            int i7 = configuration.colorMode & 12;
            int i8 = configuration2.colorMode;
            if (i7 != (i8 & 12)) {
                configuration3.colorMode |= i8 & 12;
            }
        }
    }

    class m extends h.k {
        m(Window.Callback callback) {
            super(callback);
        }

        /* access modifiers changed from: package-private */
        public final ActionMode b(ActionMode.Callback callback) {
            f.a aVar = new f.a(g.this.f637i, callback);
            h.b I = g.this.I(aVar);
            if (I != null) {
                return aVar.e(I);
            }
            return null;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return g.this.X(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || g.this.v0(keyEvent.getKeyCode(), keyEvent);
        }

        public void onContentChanged() {
        }

        public boolean onCreatePanelMenu(int i5, Menu menu) {
            if (i5 != 0 || (menu instanceof androidx.appcompat.view.menu.e)) {
                return super.onCreatePanelMenu(i5, menu);
            }
            return false;
        }

        public boolean onMenuOpened(int i5, Menu menu) {
            super.onMenuOpened(i5, menu);
            g.this.y0(i5);
            return true;
        }

        public void onPanelClosed(int i5, Menu menu) {
            super.onPanelClosed(i5, menu);
            g.this.z0(i5);
        }

        public boolean onPreparePanel(int i5, View view, Menu menu) {
            androidx.appcompat.view.menu.e eVar = menu instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menu : null;
            if (i5 == 0 && eVar == null) {
                return false;
            }
            if (eVar != null) {
                eVar.a0(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i5, view, menu);
            if (eVar != null) {
                eVar.a0(false);
            }
            return onPreparePanel;
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i5) {
            androidx.appcompat.view.menu.e eVar;
            s h02 = g.this.h0(0, true);
            if (h02 == null || (eVar = h02.f684j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i5);
            } else {
                super.onProvideKeyboardShortcuts(list, eVar, i5);
            }
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i5) {
            return (!g.this.q0() || i5 != 0) ? super.onWindowStartingActionMode(callback, i5) : b(callback);
        }
    }

    private class n extends o {

        /* renamed from: c  reason: collision with root package name */
        private final PowerManager f667c;

        n(Context context) {
            super();
            this.f667c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        /* access modifiers changed from: package-private */
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        public int c() {
            return j.a(this.f667c) ? 2 : 1;
        }

        public void d() {
            g.this.J();
        }
    }

    abstract class o {

        /* renamed from: a  reason: collision with root package name */
        private BroadcastReceiver f669a;

        class a extends BroadcastReceiver {
            a() {
            }

            public void onReceive(Context context, Intent intent) {
                o.this.d();
            }
        }

        o() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            BroadcastReceiver broadcastReceiver = this.f669a;
            if (broadcastReceiver != null) {
                try {
                    g.this.f637i.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f669a = null;
            }
        }

        /* access modifiers changed from: package-private */
        public abstract IntentFilter b();

        /* access modifiers changed from: package-private */
        public abstract int c();

        /* access modifiers changed from: package-private */
        public abstract void d();

        /* access modifiers changed from: package-private */
        public void e() {
            a();
            IntentFilter b5 = b();
            if (b5 != null && b5.countActions() != 0) {
                if (this.f669a == null) {
                    this.f669a = new a();
                }
                g.this.f637i.registerReceiver(this.f669a, b5);
            }
        }
    }

    private class p extends o {

        /* renamed from: c  reason: collision with root package name */
        private final p f672c;

        p(p pVar) {
            super();
            this.f672c = pVar;
        }

        /* access modifiers changed from: package-private */
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        public int c() {
            return this.f672c.d() ? 2 : 1;
        }

        public void d() {
            g.this.J();
        }
    }

    private static class q {
        static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    private class r extends ContentFrameLayout {
        public r(Context context) {
            super(context);
        }

        private boolean b(int i5, int i6) {
            return i5 < -5 || i6 < -5 || i5 > getWidth() + 5 || i6 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return g.this.X(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !b((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            g.this.R(0);
            return true;
        }

        public void setBackgroundResource(int i5) {
            setBackgroundDrawable(e.a.b(getContext(), i5));
        }
    }

    protected static final class s {

        /* renamed from: a  reason: collision with root package name */
        int f675a;

        /* renamed from: b  reason: collision with root package name */
        int f676b;

        /* renamed from: c  reason: collision with root package name */
        int f677c;

        /* renamed from: d  reason: collision with root package name */
        int f678d;

        /* renamed from: e  reason: collision with root package name */
        int f679e;

        /* renamed from: f  reason: collision with root package name */
        int f680f;

        /* renamed from: g  reason: collision with root package name */
        ViewGroup f681g;

        /* renamed from: h  reason: collision with root package name */
        View f682h;

        /* renamed from: i  reason: collision with root package name */
        View f683i;

        /* renamed from: j  reason: collision with root package name */
        androidx.appcompat.view.menu.e f684j;

        /* renamed from: k  reason: collision with root package name */
        androidx.appcompat.view.menu.c f685k;

        /* renamed from: l  reason: collision with root package name */
        Context f686l;

        /* renamed from: m  reason: collision with root package name */
        boolean f687m;

        /* renamed from: n  reason: collision with root package name */
        boolean f688n;

        /* renamed from: o  reason: collision with root package name */
        boolean f689o;

        /* renamed from: p  reason: collision with root package name */
        public boolean f690p;

        /* renamed from: q  reason: collision with root package name */
        boolean f691q = false;

        /* renamed from: r  reason: collision with root package name */
        boolean f692r;

        /* renamed from: s  reason: collision with root package name */
        Bundle f693s;

        s(int i5) {
            this.f675a = i5;
        }

        /* access modifiers changed from: package-private */
        public androidx.appcompat.view.menu.k a(j.a aVar) {
            if (this.f684j == null) {
                return null;
            }
            if (this.f685k == null) {
                androidx.appcompat.view.menu.c cVar = new androidx.appcompat.view.menu.c(this.f686l, d.g.f4073j);
                this.f685k = cVar;
                cVar.j(aVar);
                this.f684j.b(this.f685k);
            }
            return this.f685k.f(this.f681g);
        }

        public boolean b() {
            if (this.f682h == null) {
                return false;
            }
            if (this.f683i != null) {
                return true;
            }
            return this.f685k.b().getCount() > 0;
        }

        /* access modifiers changed from: package-private */
        public void c(androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.c cVar;
            androidx.appcompat.view.menu.e eVar2 = this.f684j;
            if (eVar != eVar2) {
                if (eVar2 != null) {
                    eVar2.O(this.f685k);
                }
                this.f684j = eVar;
                if (eVar != null && (cVar = this.f685k) != null) {
                    eVar.b(cVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(d.a.f3962a, typedValue, true);
            int i5 = typedValue.resourceId;
            if (i5 != 0) {
                newTheme.applyStyle(i5, true);
            }
            newTheme.resolveAttribute(d.a.D, typedValue, true);
            int i6 = typedValue.resourceId;
            if (i6 == 0) {
                i6 = d.i.f4097b;
            }
            newTheme.applyStyle(i6, true);
            h.d dVar = new h.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.f686l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(d.j.f4226z0);
            this.f676b = obtainStyledAttributes.getResourceId(d.j.C0, 0);
            this.f680f = obtainStyledAttributes.getResourceId(d.j.B0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    private final class t implements j.a {
        t() {
        }

        public void a(androidx.appcompat.view.menu.e eVar, boolean z4) {
            androidx.appcompat.view.menu.e D = eVar.D();
            boolean z5 = D != eVar;
            g gVar = g.this;
            if (z5) {
                eVar = D;
            }
            s c02 = gVar.c0(eVar);
            if (c02 == null) {
                return;
            }
            if (z5) {
                g.this.O(c02.f675a, c02, D);
                g.this.S(c02, true);
                return;
            }
            g.this.S(c02, z4);
        }

        public boolean b(androidx.appcompat.view.menu.e eVar) {
            Window.Callback j02;
            if (eVar != eVar.D()) {
                return true;
            }
            g gVar = g.this;
            if (!gVar.E || (j02 = gVar.j0()) == null || g.this.Q) {
                return true;
            }
            j02.onMenuOpened(R.styleable.AppCompatTheme_textAppearanceSearchResultTitle, eVar);
            return true;
        }
    }

    g(Activity activity, e eVar) {
        this(activity, (Window) null, eVar, activity);
    }

    g(Dialog dialog, e eVar) {
        this(dialog.getContext(), dialog.getWindow(), eVar, dialog);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
        r3 = f626f0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private g(android.content.Context r3, android.view.Window r4, androidx.appcompat.app.e r5, java.lang.Object r6) {
        /*
            r2 = this;
            r2.<init>()
            r0 = 0
            r2.f651w = r0
            r0 = 1
            r2.f652x = r0
            r0 = -100
            r2.R = r0
            androidx.appcompat.app.g$a r1 = new androidx.appcompat.app.g$a
            r1.<init>()
            r2.Z = r1
            r2.f637i = r3
            r2.f640l = r5
            r2.f636h = r6
            int r3 = r2.R
            if (r3 != r0) goto L_0x0032
            boolean r3 = r6 instanceof android.app.Dialog
            if (r3 == 0) goto L_0x0032
            androidx.appcompat.app.d r3 = r2.L0()
            if (r3 == 0) goto L_0x0032
            androidx.appcompat.app.f r3 = r3.getDelegate()
            int r3 = r3.l()
            r2.R = r3
        L_0x0032:
            int r3 = r2.R
            if (r3 != r0) goto L_0x0059
            m.g<java.lang.String, java.lang.Integer> r3 = f626f0
            java.lang.Class r5 = r6.getClass()
            java.lang.String r5 = r5.getName()
            java.lang.Object r5 = r3.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 == 0) goto L_0x0059
            int r5 = r5.intValue()
            r2.R = r5
            java.lang.Class r5 = r6.getClass()
            java.lang.String r5 = r5.getName()
            r3.remove(r5)
        L_0x0059:
            if (r4 == 0) goto L_0x005e
            r2.M(r4)
        L_0x005e:
            androidx.appcompat.widget.j.h()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.g.<init>(android.content.Context, android.view.Window, androidx.appcompat.app.e, java.lang.Object):void");
    }

    private void B0(s sVar, KeyEvent keyEvent) {
        int i5;
        ViewGroup.LayoutParams layoutParams;
        if (!sVar.f689o && !this.Q) {
            if (sVar.f675a == 0) {
                if ((this.f637i.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback j02 = j0();
            if (j02 == null || j02.onMenuOpened(sVar.f675a, sVar.f684j)) {
                WindowManager windowManager = (WindowManager) this.f637i.getSystemService("window");
                if (windowManager != null && E0(sVar, keyEvent)) {
                    ViewGroup viewGroup = sVar.f681g;
                    if (viewGroup == null || sVar.f691q) {
                        if (viewGroup == null) {
                            if (!m0(sVar) || sVar.f681g == null) {
                                return;
                            }
                        } else if (sVar.f691q && viewGroup.getChildCount() > 0) {
                            sVar.f681g.removeAllViews();
                        }
                        if (!l0(sVar) || !sVar.b()) {
                            sVar.f691q = true;
                            return;
                        }
                        ViewGroup.LayoutParams layoutParams2 = sVar.f682h.getLayoutParams();
                        if (layoutParams2 == null) {
                            layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                        }
                        sVar.f681g.setBackgroundResource(sVar.f676b);
                        ViewParent parent = sVar.f682h.getParent();
                        if (parent instanceof ViewGroup) {
                            ((ViewGroup) parent).removeView(sVar.f682h);
                        }
                        sVar.f681g.addView(sVar.f682h, layoutParams2);
                        if (!sVar.f682h.hasFocus()) {
                            sVar.f682h.requestFocus();
                        }
                    } else {
                        View view = sVar.f683i;
                        if (!(view == null || (layoutParams = view.getLayoutParams()) == null || layoutParams.width != -1)) {
                            i5 = -1;
                            sVar.f688n = false;
                            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i5, -2, sVar.f678d, sVar.f679e, 1002, 8519680, -3);
                            layoutParams3.gravity = sVar.f677c;
                            layoutParams3.windowAnimations = sVar.f680f;
                            windowManager.addView(sVar.f681g, layoutParams3);
                            sVar.f689o = true;
                            return;
                        }
                    }
                    i5 = -2;
                    sVar.f688n = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i5, -2, sVar.f678d, sVar.f679e, 1002, 8519680, -3);
                    layoutParams32.gravity = sVar.f677c;
                    layoutParams32.windowAnimations = sVar.f680f;
                    windowManager.addView(sVar.f681g, layoutParams32);
                    sVar.f689o = true;
                    return;
                }
                return;
            }
            S(sVar, true);
        }
    }

    private boolean D0(s sVar, int i5, KeyEvent keyEvent, int i6) {
        androidx.appcompat.view.menu.e eVar;
        boolean z4 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((sVar.f687m || E0(sVar, keyEvent)) && (eVar = sVar.f684j) != null) {
            z4 = eVar.performShortcut(i5, keyEvent, i6);
        }
        if (z4 && (i6 & 1) == 0 && this.f644p == null) {
            S(sVar, true);
        }
        return z4;
    }

    private boolean E0(s sVar, KeyEvent keyEvent) {
        m0 m0Var;
        m0 m0Var2;
        m0 m0Var3;
        if (this.Q) {
            return false;
        }
        if (sVar.f687m) {
            return true;
        }
        s sVar2 = this.L;
        if (!(sVar2 == null || sVar2 == sVar)) {
            S(sVar2, false);
        }
        Window.Callback j02 = j0();
        if (j02 != null) {
            sVar.f683i = j02.onCreatePanelView(sVar.f675a);
        }
        int i5 = sVar.f675a;
        boolean z4 = i5 == 0 || i5 == 108;
        if (z4 && (m0Var3 = this.f644p) != null) {
            m0Var3.c();
        }
        if (sVar.f683i == null && (!z4 || !(C0() instanceof n))) {
            androidx.appcompat.view.menu.e eVar = sVar.f684j;
            if (eVar == null || sVar.f692r) {
                if (eVar == null && (!n0(sVar) || sVar.f684j == null)) {
                    return false;
                }
                if (z4 && this.f644p != null) {
                    if (this.f645q == null) {
                        this.f645q = new C0015g();
                    }
                    this.f644p.a(sVar.f684j, this.f645q);
                }
                sVar.f684j.d0();
                if (!j02.onCreatePanelMenu(sVar.f675a, sVar.f684j)) {
                    sVar.c((androidx.appcompat.view.menu.e) null);
                    if (z4 && (m0Var2 = this.f644p) != null) {
                        m0Var2.a((Menu) null, this.f645q);
                    }
                    return false;
                }
                sVar.f692r = false;
            }
            sVar.f684j.d0();
            Bundle bundle = sVar.f693s;
            if (bundle != null) {
                sVar.f684j.P(bundle);
                sVar.f693s = null;
            }
            if (!j02.onPreparePanel(0, sVar.f683i, sVar.f684j)) {
                if (z4 && (m0Var = this.f644p) != null) {
                    m0Var.a((Menu) null, this.f645q);
                }
                sVar.f684j.c0();
                return false;
            }
            boolean z5 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            sVar.f690p = z5;
            sVar.f684j.setQwertyMode(z5);
            sVar.f684j.c0();
        }
        sVar.f687m = true;
        sVar.f688n = false;
        this.L = sVar;
        return true;
    }

    private void F0(boolean z4) {
        m0 m0Var = this.f644p;
        if (m0Var == null || !m0Var.g() || (ViewConfiguration.get(this.f637i).hasPermanentMenuKey() && !this.f644p.d())) {
            s h02 = h0(0, true);
            h02.f691q = true;
            S(h02, false);
            B0(h02, (KeyEvent) null);
            return;
        }
        Window.Callback j02 = j0();
        if (this.f644p.b() && z4) {
            this.f644p.e();
            if (!this.Q) {
                j02.onPanelClosed(R.styleable.AppCompatTheme_textAppearanceSearchResultTitle, h0(0, true).f684j);
            }
        } else if (j02 != null && !this.Q) {
            if (this.X && (this.Y & 1) != 0) {
                this.f638j.getDecorView().removeCallbacks(this.Z);
                this.Z.run();
            }
            s h03 = h0(0, true);
            androidx.appcompat.view.menu.e eVar = h03.f684j;
            if (eVar != null && !h03.f692r && j02.onPreparePanel(0, h03.f683i, eVar)) {
                j02.onMenuOpened(R.styleable.AppCompatTheme_textAppearanceSearchResultTitle, h03.f684j);
                this.f644p.f();
            }
        }
    }

    private int G0(int i5) {
        if (i5 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return R.styleable.AppCompatTheme_textAppearanceSearchResultTitle;
        } else if (i5 != 9) {
            return i5;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return R.styleable.AppCompatTheme_textAppearanceSmallPopupMenu;
        }
    }

    private boolean I0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f638j.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || k0.A((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private boolean K(boolean z4) {
        if (this.Q) {
            return false;
        }
        int N2 = N();
        boolean M0 = M0(r0(this.f637i, N2), z4);
        if (N2 == 0) {
            g0(this.f637i).e();
        } else {
            o oVar = this.V;
            if (oVar != null) {
                oVar.a();
            }
        }
        if (N2 == 3) {
            f0(this.f637i).e();
        } else {
            o oVar2 = this.W;
            if (oVar2 != null) {
                oVar2.a();
            }
        }
        return M0;
    }

    private void K0() {
        if (this.f653y) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void L() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f654z.findViewById(16908290);
        View decorView = this.f638j.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f637i.obtainStyledAttributes(d.j.f4226z0);
        obtainStyledAttributes.getValue(d.j.L0, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(d.j.M0, contentFrameLayout.getMinWidthMinor());
        int i5 = d.j.J0;
        if (obtainStyledAttributes.hasValue(i5)) {
            obtainStyledAttributes.getValue(i5, contentFrameLayout.getFixedWidthMajor());
        }
        int i6 = d.j.K0;
        if (obtainStyledAttributes.hasValue(i6)) {
            obtainStyledAttributes.getValue(i6, contentFrameLayout.getFixedWidthMinor());
        }
        int i7 = d.j.H0;
        if (obtainStyledAttributes.hasValue(i7)) {
            obtainStyledAttributes.getValue(i7, contentFrameLayout.getFixedHeightMajor());
        }
        int i8 = d.j.I0;
        if (obtainStyledAttributes.hasValue(i8)) {
            obtainStyledAttributes.getValue(i8, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private d L0() {
        Context context = this.f637i;
        while (context != null) {
            if (!(context instanceof d)) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                return (d) context;
            }
        }
        return null;
    }

    private void M(Window window) {
        if (this.f638j == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof m)) {
                m mVar = new m(callback);
                this.f639k = mVar;
                window.setCallback(mVar);
                androidx.appcompat.widget.k1 t5 = androidx.appcompat.widget.k1.t(this.f637i, (AttributeSet) null, f628h0);
                Drawable g5 = t5.g(0);
                if (g5 != null) {
                    window.setBackgroundDrawable(g5);
                }
                t5.v();
                this.f638j = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean M0(int r7, boolean r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.f637i
            r1 = 0
            android.content.res.Configuration r0 = r6.T(r0, r7, r1)
            boolean r2 = r6.p0()
            android.content.Context r3 = r6.f637i
            android.content.res.Resources r3 = r3.getResources()
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.uiMode
            r3 = r3 & 48
            int r0 = r0.uiMode
            r0 = r0 & 48
            r4 = 1
            if (r3 == r0) goto L_0x0047
            if (r8 == 0) goto L_0x0047
            if (r2 != 0) goto L_0x0047
            boolean r8 = r6.N
            if (r8 == 0) goto L_0x0047
            boolean r8 = f629i0
            if (r8 != 0) goto L_0x0030
            boolean r8 = r6.O
            if (r8 == 0) goto L_0x0047
        L_0x0030:
            java.lang.Object r8 = r6.f636h
            boolean r5 = r8 instanceof android.app.Activity
            if (r5 == 0) goto L_0x0047
            android.app.Activity r8 = (android.app.Activity) r8
            boolean r8 = r8.isChild()
            if (r8 != 0) goto L_0x0047
            java.lang.Object r8 = r6.f636h
            android.app.Activity r8 = (android.app.Activity) r8
            androidx.core.app.b.n(r8)
            r8 = r4
            goto L_0x0048
        L_0x0047:
            r8 = 0
        L_0x0048:
            if (r8 != 0) goto L_0x0050
            if (r3 == r0) goto L_0x0050
            r6.N0(r0, r2, r1)
            goto L_0x0051
        L_0x0050:
            r4 = r8
        L_0x0051:
            if (r4 == 0) goto L_0x005e
            java.lang.Object r8 = r6.f636h
            boolean r0 = r8 instanceof androidx.appcompat.app.d
            if (r0 == 0) goto L_0x005e
            androidx.appcompat.app.d r8 = (androidx.appcompat.app.d) r8
            r8.onNightModeChanged(r7)
        L_0x005e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.g.M0(int, boolean):boolean");
    }

    private int N() {
        int i5 = this.R;
        return i5 != -100 ? i5 : f.j();
    }

    private void N0(int i5, boolean z4, Configuration configuration) {
        Resources resources = this.f637i.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i5 | (resources.getConfiguration().uiMode & -49);
        resources.updateConfiguration(configuration2, (DisplayMetrics) null);
        if (Build.VERSION.SDK_INT < 26) {
            m.a(resources);
        }
        int i6 = this.S;
        if (i6 != 0) {
            this.f637i.setTheme(i6);
            this.f637i.getTheme().applyStyle(this.S, true);
        }
        if (z4) {
            Object obj = this.f636h;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof androidx.lifecycle.j) {
                    if (!((androidx.lifecycle.j) activity).getLifecycle().b().f(f.b.STARTED)) {
                        return;
                    }
                } else if (!this.P) {
                    return;
                }
                activity.onConfigurationChanged(configuration2);
            }
        }
    }

    private void P0(View view) {
        int i5;
        Context context;
        if ((k0.w(view) & 8192) != 0) {
            context = this.f637i;
            i5 = d.c.f3990b;
        } else {
            context = this.f637i;
            i5 = d.c.f3989a;
        }
        view.setBackgroundColor(androidx.core.content.a.b(context, i5));
    }

    private void Q() {
        o oVar = this.V;
        if (oVar != null) {
            oVar.a();
        }
        o oVar2 = this.W;
        if (oVar2 != null) {
            oVar2.a();
        }
    }

    private Configuration T(Context context, int i5, Configuration configuration) {
        int i6 = i5 != 1 ? i5 != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = CropImageView.DEFAULT_ASPECT_RATIO;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i6 | (configuration2.uiMode & -49);
        return configuration2;
    }

    private ViewGroup U() {
        ViewGroup viewGroup;
        TypedArray obtainStyledAttributes = this.f637i.obtainStyledAttributes(d.j.f4226z0);
        int i5 = d.j.E0;
        if (obtainStyledAttributes.hasValue(i5)) {
            if (obtainStyledAttributes.getBoolean(d.j.N0, false)) {
                A(1);
            } else if (obtainStyledAttributes.getBoolean(i5, false)) {
                A(R.styleable.AppCompatTheme_textAppearanceSearchResultTitle);
            }
            if (obtainStyledAttributes.getBoolean(d.j.F0, false)) {
                A(R.styleable.AppCompatTheme_textAppearanceSmallPopupMenu);
            }
            if (obtainStyledAttributes.getBoolean(d.j.G0, false)) {
                A(10);
            }
            this.H = obtainStyledAttributes.getBoolean(d.j.A0, false);
            obtainStyledAttributes.recycle();
            b0();
            this.f638j.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f637i);
            if (this.I) {
                viewGroup = (ViewGroup) from.inflate(this.G ? d.g.f4078o : d.g.f4077n, (ViewGroup) null);
            } else if (this.H) {
                viewGroup = (ViewGroup) from.inflate(d.g.f4069f, (ViewGroup) null);
                this.F = false;
                this.E = false;
            } else if (this.E) {
                TypedValue typedValue = new TypedValue();
                this.f637i.getTheme().resolveAttribute(d.a.f3967f, typedValue, true);
                viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new h.d(this.f637i, typedValue.resourceId) : this.f637i).inflate(d.g.f4079p, (ViewGroup) null);
                m0 m0Var = (m0) viewGroup.findViewById(d.f.f4053p);
                this.f644p = m0Var;
                m0Var.setWindowCallback(j0());
                if (this.F) {
                    this.f644p.k(R.styleable.AppCompatTheme_textAppearanceSmallPopupMenu);
                }
                if (this.C) {
                    this.f644p.k(2);
                }
                if (this.D) {
                    this.f644p.k(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                k0.W(viewGroup, new b());
                if (this.f644p == null) {
                    this.A = (TextView) viewGroup.findViewById(d.f.M);
                }
                r1.c(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(d.f.f4039b);
                ViewGroup viewGroup2 = (ViewGroup) this.f638j.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground((Drawable) null);
                    }
                }
                this.f638j.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new c());
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.E + ", windowActionBarOverlay: " + this.F + ", android:windowIsFloating: " + this.H + ", windowActionModeOverlay: " + this.G + ", windowNoTitle: " + this.I + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void a0() {
        if (!this.f653y) {
            this.f654z = U();
            CharSequence i02 = i0();
            if (!TextUtils.isEmpty(i02)) {
                m0 m0Var = this.f644p;
                if (m0Var != null) {
                    m0Var.setWindowTitle(i02);
                } else if (C0() != null) {
                    C0().u(i02);
                } else {
                    TextView textView = this.A;
                    if (textView != null) {
                        textView.setText(i02);
                    }
                }
            }
            L();
            A0(this.f654z);
            this.f653y = true;
            s h02 = h0(0, false);
            if (this.Q) {
                return;
            }
            if (h02 == null || h02.f684j == null) {
                o0(R.styleable.AppCompatTheme_textAppearanceSearchResultTitle);
            }
        }
    }

    private void b0() {
        if (this.f638j == null) {
            Object obj = this.f636h;
            if (obj instanceof Activity) {
                M(((Activity) obj).getWindow());
            }
        }
        if (this.f638j == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private static Configuration d0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = CropImageView.DEFAULT_ASPECT_RATIO;
        if (!(configuration2 == null || configuration.diff(configuration2) == 0)) {
            float f5 = configuration.fontScale;
            float f6 = configuration2.fontScale;
            if (f5 != f6) {
                configuration3.fontScale = f6;
            }
            int i5 = configuration.mcc;
            int i6 = configuration2.mcc;
            if (i5 != i6) {
                configuration3.mcc = i6;
            }
            int i7 = configuration.mnc;
            int i8 = configuration2.mnc;
            if (i7 != i8) {
                configuration3.mnc = i8;
            }
            int i9 = Build.VERSION.SDK_INT;
            if (i9 >= 24) {
                k.a(configuration, configuration2, configuration3);
            } else if (!androidx.core.util.c.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i10 = configuration.touchscreen;
            int i11 = configuration2.touchscreen;
            if (i10 != i11) {
                configuration3.touchscreen = i11;
            }
            int i12 = configuration.keyboard;
            int i13 = configuration2.keyboard;
            if (i12 != i13) {
                configuration3.keyboard = i13;
            }
            int i14 = configuration.keyboardHidden;
            int i15 = configuration2.keyboardHidden;
            if (i14 != i15) {
                configuration3.keyboardHidden = i15;
            }
            int i16 = configuration.navigation;
            int i17 = configuration2.navigation;
            if (i16 != i17) {
                configuration3.navigation = i17;
            }
            int i18 = configuration.navigationHidden;
            int i19 = configuration2.navigationHidden;
            if (i18 != i19) {
                configuration3.navigationHidden = i19;
            }
            int i20 = configuration.orientation;
            int i21 = configuration2.orientation;
            if (i20 != i21) {
                configuration3.orientation = i21;
            }
            int i22 = configuration.screenLayout & 15;
            int i23 = configuration2.screenLayout;
            if (i22 != (i23 & 15)) {
                configuration3.screenLayout |= i23 & 15;
            }
            int i24 = configuration.screenLayout & 192;
            int i25 = configuration2.screenLayout;
            if (i24 != (i25 & 192)) {
                configuration3.screenLayout |= i25 & 192;
            }
            int i26 = configuration.screenLayout & 48;
            int i27 = configuration2.screenLayout;
            if (i26 != (i27 & 48)) {
                configuration3.screenLayout |= i27 & 48;
            }
            int i28 = configuration.screenLayout & 768;
            int i29 = configuration2.screenLayout;
            if (i28 != (i29 & 768)) {
                configuration3.screenLayout |= i29 & 768;
            }
            if (i9 >= 26) {
                l.a(configuration, configuration2, configuration3);
            }
            int i30 = configuration.uiMode & 15;
            int i31 = configuration2.uiMode;
            if (i30 != (i31 & 15)) {
                configuration3.uiMode |= i31 & 15;
            }
            int i32 = configuration.uiMode & 48;
            int i33 = configuration2.uiMode;
            if (i32 != (i33 & 48)) {
                configuration3.uiMode |= i33 & 48;
            }
            int i34 = configuration.screenWidthDp;
            int i35 = configuration2.screenWidthDp;
            if (i34 != i35) {
                configuration3.screenWidthDp = i35;
            }
            int i36 = configuration.screenHeightDp;
            int i37 = configuration2.screenHeightDp;
            if (i36 != i37) {
                configuration3.screenHeightDp = i37;
            }
            int i38 = configuration.smallestScreenWidthDp;
            int i39 = configuration2.smallestScreenWidthDp;
            if (i38 != i39) {
                configuration3.smallestScreenWidthDp = i39;
            }
            i.b(configuration, configuration2, configuration3);
        }
        return configuration3;
    }

    private o f0(Context context) {
        if (this.W == null) {
            this.W = new n(context);
        }
        return this.W;
    }

    private o g0(Context context) {
        if (this.V == null) {
            this.V = new p(p.a(context));
        }
        return this.V;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void k0() {
        /*
            r3 = this;
            r3.a0()
            boolean r0 = r3.E
            if (r0 == 0) goto L_0x0037
            androidx.appcompat.app.a r0 = r3.f641m
            if (r0 == 0) goto L_0x000c
            goto L_0x0037
        L_0x000c:
            java.lang.Object r0 = r3.f636h
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0020
            androidx.appcompat.app.q r0 = new androidx.appcompat.app.q
            java.lang.Object r1 = r3.f636h
            android.app.Activity r1 = (android.app.Activity) r1
            boolean r2 = r3.F
            r0.<init>(r1, r2)
        L_0x001d:
            r3.f641m = r0
            goto L_0x002e
        L_0x0020:
            boolean r0 = r0 instanceof android.app.Dialog
            if (r0 == 0) goto L_0x002e
            androidx.appcompat.app.q r0 = new androidx.appcompat.app.q
            java.lang.Object r1 = r3.f636h
            android.app.Dialog r1 = (android.app.Dialog) r1
            r0.<init>(r1)
            goto L_0x001d
        L_0x002e:
            androidx.appcompat.app.a r0 = r3.f641m
            if (r0 == 0) goto L_0x0037
            boolean r1 = r3.f631a0
            r0.r(r1)
        L_0x0037:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.g.k0():void");
    }

    private boolean l0(s sVar) {
        View view = sVar.f683i;
        if (view != null) {
            sVar.f682h = view;
            return true;
        } else if (sVar.f684j == null) {
            return false;
        } else {
            if (this.f646r == null) {
                this.f646r = new t();
            }
            View view2 = (View) sVar.a(this.f646r);
            sVar.f682h = view2;
            return view2 != null;
        }
    }

    private boolean m0(s sVar) {
        sVar.d(e0());
        sVar.f681g = new r(sVar.f686l);
        sVar.f677c = 81;
        return true;
    }

    private boolean n0(s sVar) {
        Context context = this.f637i;
        int i5 = sVar.f675a;
        if ((i5 == 0 || i5 == 108) && this.f644p != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(d.a.f3967f, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(d.a.f3968g, typedValue, true);
            } else {
                theme.resolveAttribute(d.a.f3968g, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                h.d dVar = new h.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
        eVar.R(this);
        sVar.c(eVar);
        return true;
    }

    private void o0(int i5) {
        this.Y = (1 << i5) | this.Y;
        if (!this.X) {
            k0.J(this.f638j.getDecorView(), this.Z);
            this.X = true;
        }
    }

    private boolean p0() {
        if (!this.U && (this.f636h instanceof Activity)) {
            PackageManager packageManager = this.f637i.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                int i5 = Build.VERSION.SDK_INT;
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f637i, this.f636h.getClass()), i5 >= 29 ? 269221888 : i5 >= 24 ? 786432 : 0);
                this.T = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e5) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e5);
                this.T = false;
            }
        }
        this.U = true;
        return this.T;
    }

    private boolean u0(int i5, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        s h02 = h0(i5, true);
        if (!h02.f689o) {
            return E0(h02, keyEvent);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean x0(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            h.b r0 = r4.f647s
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 1
            androidx.appcompat.app.g$s r2 = r4.h0(r5, r0)
            if (r5 != 0) goto L_0x0043
            androidx.appcompat.widget.m0 r5 = r4.f644p
            if (r5 == 0) goto L_0x0043
            boolean r5 = r5.g()
            if (r5 == 0) goto L_0x0043
            android.content.Context r5 = r4.f637i
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            boolean r5 = r5.hasPermanentMenuKey()
            if (r5 != 0) goto L_0x0043
            androidx.appcompat.widget.m0 r5 = r4.f644p
            boolean r5 = r5.b()
            if (r5 != 0) goto L_0x003c
            boolean r5 = r4.Q
            if (r5 != 0) goto L_0x0062
            boolean r5 = r4.E0(r2, r6)
            if (r5 == 0) goto L_0x0062
            androidx.appcompat.widget.m0 r5 = r4.f644p
            boolean r0 = r5.f()
            goto L_0x0068
        L_0x003c:
            androidx.appcompat.widget.m0 r5 = r4.f644p
            boolean r0 = r5.e()
            goto L_0x0068
        L_0x0043:
            boolean r5 = r2.f689o
            if (r5 != 0) goto L_0x0064
            boolean r3 = r2.f688n
            if (r3 == 0) goto L_0x004c
            goto L_0x0064
        L_0x004c:
            boolean r5 = r2.f687m
            if (r5 == 0) goto L_0x0062
            boolean r5 = r2.f692r
            if (r5 == 0) goto L_0x005b
            r2.f687m = r1
            boolean r5 = r4.E0(r2, r6)
            goto L_0x005c
        L_0x005b:
            r5 = r0
        L_0x005c:
            if (r5 == 0) goto L_0x0062
            r4.B0(r2, r6)
            goto L_0x0068
        L_0x0062:
            r0 = r1
            goto L_0x0068
        L_0x0064:
            r4.S(r2, r0)
            r0 = r5
        L_0x0068:
            if (r0 == 0) goto L_0x0085
            android.content.Context r5 = r4.f637i
            android.content.Context r5 = r5.getApplicationContext()
            java.lang.String r6 = "audio"
            java.lang.Object r5 = r5.getSystemService(r6)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L_0x007e
            r5.playSoundEffect(r1)
            goto L_0x0085
        L_0x007e:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r6 = "Couldn't get audio manager"
            android.util.Log.w(r5, r6)
        L_0x0085:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.g.x0(int, android.view.KeyEvent):boolean");
    }

    public boolean A(int i5) {
        int G0 = G0(i5);
        if (this.I && G0 == 108) {
            return false;
        }
        if (this.E && G0 == 1) {
            this.E = false;
        }
        if (G0 == 1) {
            K0();
            this.I = true;
            return true;
        } else if (G0 == 2) {
            K0();
            this.C = true;
            return true;
        } else if (G0 == 5) {
            K0();
            this.D = true;
            return true;
        } else if (G0 == 10) {
            K0();
            this.G = true;
            return true;
        } else if (G0 == 108) {
            K0();
            this.E = true;
            return true;
        } else if (G0 != 109) {
            return this.f638j.requestFeature(G0);
        } else {
            K0();
            this.F = true;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void A0(ViewGroup viewGroup) {
    }

    public void C(int i5) {
        a0();
        ViewGroup viewGroup = (ViewGroup) this.f654z.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f637i).inflate(i5, viewGroup);
        this.f639k.a().onContentChanged();
    }

    /* access modifiers changed from: package-private */
    public final a C0() {
        return this.f641m;
    }

    public void D(View view) {
        a0();
        ViewGroup viewGroup = (ViewGroup) this.f654z.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f639k.a().onContentChanged();
    }

    public void E(View view, ViewGroup.LayoutParams layoutParams) {
        a0();
        ViewGroup viewGroup = (ViewGroup) this.f654z.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f639k.a().onContentChanged();
    }

    public void F(Toolbar toolbar) {
        Window window;
        Window.Callback callback;
        if (this.f636h instanceof Activity) {
            a n5 = n();
            if (!(n5 instanceof q)) {
                this.f642n = null;
                if (n5 != null) {
                    n5.n();
                }
                if (toolbar != null) {
                    n nVar = new n(toolbar, i0(), this.f639k);
                    this.f641m = nVar;
                    window = this.f638j;
                    callback = nVar.x();
                } else {
                    this.f641m = null;
                    window = this.f638j;
                    callback = this.f639k;
                }
                window.setCallback(callback);
                p();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    public void G(int i5) {
        this.S = i5;
    }

    public final void H(CharSequence charSequence) {
        this.f643o = charSequence;
        m0 m0Var = this.f644p;
        if (m0Var != null) {
            m0Var.setWindowTitle(charSequence);
        } else if (C0() != null) {
            C0().u(charSequence);
        } else {
            TextView textView = this.A;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f654z;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean H0() {
        /*
            r1 = this;
            boolean r0 = r1.f653y
            if (r0 == 0) goto L_0x0010
            android.view.ViewGroup r0 = r1.f654z
            if (r0 == 0) goto L_0x0010
            boolean r0 = androidx.core.view.k0.B(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.g.H0():boolean");
    }

    public h.b I(b.a aVar) {
        e eVar;
        if (aVar != null) {
            h.b bVar = this.f647s;
            if (bVar != null) {
                bVar.c();
            }
            h hVar = new h(aVar);
            a n5 = n();
            if (n5 != null) {
                h.b v5 = n5.v(hVar);
                this.f647s = v5;
                if (!(v5 == null || (eVar = this.f640l) == null)) {
                    eVar.onSupportActionModeStarted(v5);
                }
            }
            if (this.f647s == null) {
                this.f647s = J0(hVar);
            }
            return this.f647s;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public boolean J() {
        return K(true);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public h.b J0(h.b.a r8) {
        /*
            r7 = this;
            r7.Z()
            h.b r0 = r7.f647s
            if (r0 == 0) goto L_0x000a
            r0.c()
        L_0x000a:
            boolean r0 = r8 instanceof androidx.appcompat.app.g.h
            if (r0 != 0) goto L_0x0014
            androidx.appcompat.app.g$h r0 = new androidx.appcompat.app.g$h
            r0.<init>(r8)
            r8 = r0
        L_0x0014:
            androidx.appcompat.app.e r0 = r7.f640l
            r1 = 0
            if (r0 == 0) goto L_0x0022
            boolean r2 = r7.Q
            if (r2 != 0) goto L_0x0022
            h.b r0 = r0.onWindowStartingSupportActionMode(r8)     // Catch:{ AbstractMethodError -> 0x0022 }
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            if (r0 == 0) goto L_0x0029
            r7.f647s = r0
            goto L_0x0162
        L_0x0029:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f648t
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x00d4
            boolean r0 = r7.H
            if (r0 == 0) goto L_0x00b5
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.Context r4 = r7.f637i
            android.content.res.Resources$Theme r4 = r4.getTheme()
            int r5 = d.a.f3967f
            r4.resolveAttribute(r5, r0, r3)
            int r5 = r0.resourceId
            if (r5 == 0) goto L_0x0068
            android.content.Context r5 = r7.f637i
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Resources$Theme r5 = r5.newTheme()
            r5.setTo(r4)
            int r4 = r0.resourceId
            r5.applyStyle(r4, r3)
            h.d r4 = new h.d
            android.content.Context r6 = r7.f637i
            r4.<init>((android.content.Context) r6, (int) r2)
            android.content.res.Resources$Theme r6 = r4.getTheme()
            r6.setTo(r5)
            goto L_0x006a
        L_0x0068:
            android.content.Context r4 = r7.f637i
        L_0x006a:
            androidx.appcompat.widget.ActionBarContextView r5 = new androidx.appcompat.widget.ActionBarContextView
            r5.<init>(r4)
            r7.f648t = r5
            android.widget.PopupWindow r5 = new android.widget.PopupWindow
            int r6 = d.a.f3970i
            r5.<init>(r4, r1, r6)
            r7.f649u = r5
            r6 = 2
            androidx.core.widget.j.b(r5, r6)
            android.widget.PopupWindow r5 = r7.f649u
            androidx.appcompat.widget.ActionBarContextView r6 = r7.f648t
            r5.setContentView(r6)
            android.widget.PopupWindow r5 = r7.f649u
            r6 = -1
            r5.setWidth(r6)
            android.content.res.Resources$Theme r5 = r4.getTheme()
            int r6 = d.a.f3963b
            r5.resolveAttribute(r6, r0, r3)
            int r0 = r0.data
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r4)
            androidx.appcompat.widget.ActionBarContextView r4 = r7.f648t
            r4.setContentHeight(r0)
            android.widget.PopupWindow r0 = r7.f649u
            r4 = -2
            r0.setHeight(r4)
            androidx.appcompat.app.g$d r0 = new androidx.appcompat.app.g$d
            r0.<init>()
            r7.f650v = r0
            goto L_0x00d4
        L_0x00b5:
            android.view.ViewGroup r0 = r7.f654z
            int r4 = d.f.f4045h
            android.view.View r0 = r0.findViewById(r4)
            androidx.appcompat.widget.ViewStubCompat r0 = (androidx.appcompat.widget.ViewStubCompat) r0
            if (r0 == 0) goto L_0x00d4
            android.content.Context r4 = r7.e0()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r0.setLayoutInflater(r4)
            android.view.View r0 = r0.a()
            androidx.appcompat.widget.ActionBarContextView r0 = (androidx.appcompat.widget.ActionBarContextView) r0
            r7.f648t = r0
        L_0x00d4:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f648t
            if (r0 == 0) goto L_0x0162
            r7.Z()
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f648t
            r0.k()
            h.e r0 = new h.e
            androidx.appcompat.widget.ActionBarContextView r4 = r7.f648t
            android.content.Context r4 = r4.getContext()
            androidx.appcompat.widget.ActionBarContextView r5 = r7.f648t
            android.widget.PopupWindow r6 = r7.f649u
            if (r6 != 0) goto L_0x00ef
            goto L_0x00f0
        L_0x00ef:
            r3 = r2
        L_0x00f0:
            r0.<init>(r4, r5, r8, r3)
            android.view.Menu r3 = r0.e()
            boolean r8 = r8.b(r0, r3)
            if (r8 == 0) goto L_0x0160
            r0.k()
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f648t
            r8.h(r0)
            r7.f647s = r0
            boolean r8 = r7.H0()
            r0 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x012a
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f648t
            r1 = 0
            r8.setAlpha(r1)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f648t
            androidx.core.view.k1 r8 = androidx.core.view.k0.c(r8)
            androidx.core.view.k1 r8 = r8.b(r0)
            r7.f651w = r8
            androidx.appcompat.app.g$e r0 = new androidx.appcompat.app.g$e
            r0.<init>()
            r8.h(r0)
            goto L_0x0150
        L_0x012a:
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f648t
            r8.setAlpha(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f648t
            r8.setVisibility(r2)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f648t
            r0 = 32
            r8.sendAccessibilityEvent(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f648t
            android.view.ViewParent r8 = r8.getParent()
            boolean r8 = r8 instanceof android.view.View
            if (r8 == 0) goto L_0x0150
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f648t
            android.view.ViewParent r8 = r8.getParent()
            android.view.View r8 = (android.view.View) r8
            androidx.core.view.k0.L(r8)
        L_0x0150:
            android.widget.PopupWindow r8 = r7.f649u
            if (r8 == 0) goto L_0x0162
            android.view.Window r8 = r7.f638j
            android.view.View r8 = r8.getDecorView()
            java.lang.Runnable r0 = r7.f650v
            r8.post(r0)
            goto L_0x0162
        L_0x0160:
            r7.f647s = r1
        L_0x0162:
            h.b r8 = r7.f647s
            if (r8 == 0) goto L_0x016d
            androidx.appcompat.app.e r0 = r7.f640l
            if (r0 == 0) goto L_0x016d
            r0.onSupportActionModeStarted(r8)
        L_0x016d:
            h.b r8 = r7.f647s
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.g.J0(h.b$a):h.b");
    }

    /* access modifiers changed from: package-private */
    public void O(int i5, s sVar, Menu menu) {
        if (menu == null) {
            if (sVar == null && i5 >= 0) {
                s[] sVarArr = this.K;
                if (i5 < sVarArr.length) {
                    sVar = sVarArr[i5];
                }
            }
            if (sVar != null) {
                menu = sVar.f684j;
            }
        }
        if ((sVar == null || sVar.f689o) && !this.Q) {
            this.f639k.a().onPanelClosed(i5, menu);
        }
    }

    /* access modifiers changed from: package-private */
    public final int O0(o1 o1Var, Rect rect) {
        boolean z4;
        boolean z5;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i5;
        int i6 = 0;
        int k5 = o1Var != null ? o1Var.k() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.f648t;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z4 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f648t.getLayoutParams();
            boolean z6 = true;
            if (this.f648t.isShown()) {
                if (this.f632b0 == null) {
                    this.f632b0 = new Rect();
                    this.f633c0 = new Rect();
                }
                Rect rect2 = this.f632b0;
                Rect rect3 = this.f633c0;
                if (o1Var == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(o1Var.i(), o1Var.k(), o1Var.j(), o1Var.h());
                }
                r1.a(this.f654z, rect2, rect3);
                int i7 = rect2.top;
                int i8 = rect2.left;
                int i9 = rect2.right;
                o1 t5 = k0.t(this.f654z);
                int i10 = t5 == null ? 0 : t5.i();
                int j5 = t5 == null ? 0 : t5.j();
                if (marginLayoutParams2.topMargin == i7 && marginLayoutParams2.leftMargin == i8 && marginLayoutParams2.rightMargin == i9) {
                    z5 = false;
                } else {
                    marginLayoutParams2.topMargin = i7;
                    marginLayoutParams2.leftMargin = i8;
                    marginLayoutParams2.rightMargin = i9;
                    z5 = true;
                }
                if (i7 <= 0 || this.B != null) {
                    View view = this.B;
                    if (!(view == null || ((marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()).height == (i5 = marginLayoutParams2.topMargin) && marginLayoutParams.leftMargin == i10 && marginLayoutParams.rightMargin == j5))) {
                        marginLayoutParams.height = i5;
                        marginLayoutParams.leftMargin = i10;
                        marginLayoutParams.rightMargin = j5;
                        this.B.setLayoutParams(marginLayoutParams);
                    }
                } else {
                    View view2 = new View(this.f637i);
                    this.B = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams2.topMargin, 51);
                    layoutParams.leftMargin = i10;
                    layoutParams.rightMargin = j5;
                    this.f654z.addView(this.B, -1, layoutParams);
                }
                View view3 = this.B;
                if (view3 == null) {
                    z6 = false;
                }
                if (z6 && view3.getVisibility() != 0) {
                    P0(this.B);
                }
                if (!this.G && z6) {
                    k5 = 0;
                }
                z4 = z6;
                z6 = z5;
            } else if (marginLayoutParams2.topMargin != 0) {
                marginLayoutParams2.topMargin = 0;
                z4 = false;
            } else {
                z4 = false;
                z6 = false;
            }
            if (z6) {
                this.f648t.setLayoutParams(marginLayoutParams2);
            }
        }
        View view4 = this.B;
        if (view4 != null) {
            if (!z4) {
                i6 = 8;
            }
            view4.setVisibility(i6);
        }
        return k5;
    }

    /* access modifiers changed from: package-private */
    public void P(androidx.appcompat.view.menu.e eVar) {
        if (!this.J) {
            this.J = true;
            this.f644p.l();
            Window.Callback j02 = j0();
            if (j02 != null && !this.Q) {
                j02.onPanelClosed(R.styleable.AppCompatTheme_textAppearanceSearchResultTitle, eVar);
            }
            this.J = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void R(int i5) {
        S(h0(i5, true), true);
    }

    /* access modifiers changed from: package-private */
    public void S(s sVar, boolean z4) {
        ViewGroup viewGroup;
        m0 m0Var;
        if (!z4 || sVar.f675a != 0 || (m0Var = this.f644p) == null || !m0Var.b()) {
            WindowManager windowManager = (WindowManager) this.f637i.getSystemService("window");
            if (!(windowManager == null || !sVar.f689o || (viewGroup = sVar.f681g) == null)) {
                windowManager.removeView(viewGroup);
                if (z4) {
                    O(sVar.f675a, sVar, (Menu) null);
                }
            }
            sVar.f687m = false;
            sVar.f688n = false;
            sVar.f689o = false;
            sVar.f682h = null;
            sVar.f691q = true;
            if (this.L == sVar) {
                this.L = null;
                return;
            }
            return;
        }
        P(sVar.f684j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0079, code lost:
        if (((org.xmlpull.v1.XmlPullParser) r15).getDepth() > 1) goto L_0x0083;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View V(android.view.View r12, java.lang.String r13, android.content.Context r14, android.util.AttributeSet r15) {
        /*
            r11 = this;
            androidx.appcompat.app.k r0 = r11.f634d0
            r1 = 0
            if (r0 != 0) goto L_0x0054
            android.content.Context r0 = r11.f637i
            int[] r2 = d.j.f4226z0
            android.content.res.TypedArray r0 = r0.obtainStyledAttributes(r2)
            int r2 = d.j.D0
            java.lang.String r0 = r0.getString(r2)
            if (r0 != 0) goto L_0x001d
            androidx.appcompat.app.k r0 = new androidx.appcompat.app.k
            r0.<init>()
        L_0x001a:
            r11.f634d0 = r0
            goto L_0x0054
        L_0x001d:
            java.lang.Class r2 = java.lang.Class.forName(r0)     // Catch:{ all -> 0x0032 }
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ all -> 0x0032 }
            java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r3)     // Catch:{ all -> 0x0032 }
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x0032 }
            java.lang.Object r2 = r2.newInstance(r3)     // Catch:{ all -> 0x0032 }
            androidx.appcompat.app.k r2 = (androidx.appcompat.app.k) r2     // Catch:{ all -> 0x0032 }
            r11.f634d0 = r2     // Catch:{ all -> 0x0032 }
            goto L_0x0054
        L_0x0032:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Failed to instantiate custom view inflater "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = ". Falling back to default."
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.String r3 = "AppCompatDelegate"
            android.util.Log.i(r3, r0, r2)
            androidx.appcompat.app.k r0 = new androidx.appcompat.app.k
            r0.<init>()
            goto L_0x001a
        L_0x0054:
            boolean r8 = f627g0
            r0 = 1
            if (r8 == 0) goto L_0x0084
            androidx.appcompat.app.l r2 = r11.f635e0
            if (r2 != 0) goto L_0x0064
            androidx.appcompat.app.l r2 = new androidx.appcompat.app.l
            r2.<init>()
            r11.f635e0 = r2
        L_0x0064:
            androidx.appcompat.app.l r2 = r11.f635e0
            boolean r2 = r2.a(r15)
            if (r2 == 0) goto L_0x006e
            r7 = r0
            goto L_0x0085
        L_0x006e:
            boolean r2 = r15 instanceof org.xmlpull.v1.XmlPullParser
            if (r2 == 0) goto L_0x007c
            r2 = r15
            org.xmlpull.v1.XmlPullParser r2 = (org.xmlpull.v1.XmlPullParser) r2
            int r2 = r2.getDepth()
            if (r2 <= r0) goto L_0x0084
            goto L_0x0083
        L_0x007c:
            r0 = r12
            android.view.ViewParent r0 = (android.view.ViewParent) r0
            boolean r0 = r11.I0(r0)
        L_0x0083:
            r1 = r0
        L_0x0084:
            r7 = r1
        L_0x0085:
            androidx.appcompat.app.k r2 = r11.f634d0
            r9 = 1
            boolean r10 = androidx.appcompat.widget.q1.c()
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            android.view.View r12 = r2.q(r3, r4, r5, r6, r7, r8, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.g.V(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    /* access modifiers changed from: package-private */
    public void W() {
        androidx.appcompat.view.menu.e eVar;
        m0 m0Var = this.f644p;
        if (m0Var != null) {
            m0Var.l();
        }
        if (this.f649u != null) {
            this.f638j.getDecorView().removeCallbacks(this.f650v);
            if (this.f649u.isShowing()) {
                try {
                    this.f649u.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f649u = null;
        }
        Z();
        s h02 = h0(0, false);
        if (h02 != null && (eVar = h02.f684j) != null) {
            eVar.close();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean X(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f636h;
        boolean z4 = true;
        if (((obj instanceof f.a) || (obj instanceof j)) && (decorView = this.f638j.getDecorView()) != null && androidx.core.view.f.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f639k.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z4 = false;
        }
        return z4 ? t0(keyCode, keyEvent) : w0(keyCode, keyEvent);
    }

    /* access modifiers changed from: package-private */
    public void Y(int i5) {
        s h02;
        s h03 = h0(i5, true);
        if (h03.f684j != null) {
            Bundle bundle = new Bundle();
            h03.f684j.Q(bundle);
            if (bundle.size() > 0) {
                h03.f693s = bundle;
            }
            h03.f684j.d0();
            h03.f684j.clear();
        }
        h03.f692r = true;
        h03.f691q = true;
        if ((i5 == 108 || i5 == 0) && this.f644p != null && (h02 = h0(0, false)) != null) {
            h02.f687m = false;
            E0(h02, (KeyEvent) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void Z() {
        k1 k1Var = this.f651w;
        if (k1Var != null) {
            k1Var.c();
        }
    }

    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        s c02;
        Window.Callback j02 = j0();
        if (j02 == null || this.Q || (c02 = c0(eVar.D())) == null) {
            return false;
        }
        return j02.onMenuItemSelected(c02.f675a, menuItem);
    }

    public void b(androidx.appcompat.view.menu.e eVar) {
        F0(true);
    }

    /* access modifiers changed from: package-private */
    public s c0(Menu menu) {
        s[] sVarArr = this.K;
        int length = sVarArr != null ? sVarArr.length : 0;
        for (int i5 = 0; i5 < length; i5++) {
            s sVar = sVarArr[i5];
            if (sVar != null && sVar.f684j == menu) {
                return sVar;
            }
        }
        return null;
    }

    public void d(View view, ViewGroup.LayoutParams layoutParams) {
        a0();
        ((ViewGroup) this.f654z.findViewById(16908290)).addView(view, layoutParams);
        this.f639k.a().onContentChanged();
    }

    /* access modifiers changed from: package-private */
    public final Context e0() {
        a n5 = n();
        Context k5 = n5 != null ? n5.k() : null;
        return k5 == null ? this.f637i : k5;
    }

    public Context f(Context context) {
        boolean z4 = true;
        this.N = true;
        int r02 = r0(context, N());
        Configuration configuration = null;
        if (f630j0 && (context instanceof ContextThemeWrapper)) {
            try {
                q.a((ContextThemeWrapper) context, T(context, r02, (Configuration) null));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof h.d) {
            try {
                ((h.d) context).a(T(context, r02, (Configuration) null));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f629i0) {
            return super.f(context);
        }
        Configuration configuration2 = new Configuration();
        configuration2.uiMode = -1;
        configuration2.fontScale = CropImageView.DEFAULT_ASPECT_RATIO;
        Configuration configuration3 = i.a(context, configuration2).getResources().getConfiguration();
        Configuration configuration4 = context.getResources().getConfiguration();
        configuration3.uiMode = configuration4.uiMode;
        if (!configuration3.equals(configuration4)) {
            configuration = d0(configuration3, configuration4);
        }
        Configuration T2 = T(context, r02, configuration);
        h.d dVar = new h.d(context, d.i.f4098c);
        dVar.a(T2);
        boolean z5 = false;
        try {
            if (context.getTheme() == null) {
                z4 = false;
            }
            z5 = z4;
        } catch (NullPointerException unused3) {
        }
        if (z5) {
            h.c.a(dVar.getTheme());
        }
        return super.f(dVar);
    }

    /* access modifiers changed from: protected */
    public s h0(int i5, boolean z4) {
        s[] sVarArr = this.K;
        if (sVarArr == null || sVarArr.length <= i5) {
            s[] sVarArr2 = new s[(i5 + 1)];
            if (sVarArr != null) {
                System.arraycopy(sVarArr, 0, sVarArr2, 0, sVarArr.length);
            }
            this.K = sVarArr2;
            sVarArr = sVarArr2;
        }
        s sVar = sVarArr[i5];
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(i5);
        sVarArr[i5] = sVar2;
        return sVar2;
    }

    public <T extends View> T i(int i5) {
        a0();
        return this.f638j.findViewById(i5);
    }

    /* access modifiers changed from: package-private */
    public final CharSequence i0() {
        Object obj = this.f636h;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f643o;
    }

    /* access modifiers changed from: package-private */
    public final Window.Callback j0() {
        return this.f638j.getCallback();
    }

    public final b k() {
        return new f();
    }

    public int l() {
        return this.R;
    }

    public MenuInflater m() {
        if (this.f642n == null) {
            k0();
            a aVar = this.f641m;
            this.f642n = new h.g(aVar != null ? aVar.k() : this.f637i);
        }
        return this.f642n;
    }

    public a n() {
        k0();
        return this.f641m;
    }

    public void o() {
        LayoutInflater from = LayoutInflater.from(this.f637i);
        if (from.getFactory() == null) {
            androidx.core.view.g.a(from, this);
        } else if (!(from.getFactory2() instanceof g)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return V(view, str, context, attributeSet);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    public void p() {
        a n5 = n();
        if (n5 == null || !n5.l()) {
            o0(0);
        }
    }

    public void q(Configuration configuration) {
        a n5;
        if (this.E && this.f653y && (n5 = n()) != null) {
            n5.m(configuration);
        }
        androidx.appcompat.widget.j.b().g(this.f637i);
        K(false);
    }

    public boolean q0() {
        return this.f652x;
    }

    public void r(Bundle bundle) {
        this.N = true;
        K(false);
        b0();
        Object obj = this.f636h;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = androidx.core.app.j.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                a C0 = C0();
                if (C0 == null) {
                    this.f631a0 = true;
                } else {
                    C0.r(true);
                }
            }
            f.c(this);
        }
        this.O = true;
    }

    /* access modifiers changed from: package-private */
    public int r0(Context context, int i5) {
        o g02;
        if (i5 == -100) {
            return -1;
        }
        if (i5 != -1) {
            if (i5 != 0) {
                if (!(i5 == 1 || i5 == 2)) {
                    if (i5 == 3) {
                        g02 = f0(context);
                    } else {
                        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                    }
                }
            } else if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                return -1;
            } else {
                g02 = g0(context);
            }
            return g02.c();
        }
        return i5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void s() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f636h
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0009
            androidx.appcompat.app.f.y(r3)
        L_0x0009:
            boolean r0 = r3.X
            if (r0 == 0) goto L_0x0018
            android.view.Window r0 = r3.f638j
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.Z
            r0.removeCallbacks(r1)
        L_0x0018:
            r0 = 0
            r3.P = r0
            r0 = 1
            r3.Q = r0
            int r0 = r3.R
            r1 = -100
            if (r0 == r1) goto L_0x0048
            java.lang.Object r0 = r3.f636h
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0048
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L_0x0048
            m.g<java.lang.String, java.lang.Integer> r0 = f626f0
            java.lang.Object r1 = r3.f636h
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.R
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L_0x0057
        L_0x0048:
            m.g<java.lang.String, java.lang.Integer> r0 = f626f0
            java.lang.Object r1 = r3.f636h
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L_0x0057:
            androidx.appcompat.app.a r0 = r3.f641m
            if (r0 == 0) goto L_0x005e
            r0.n()
        L_0x005e:
            r3.Q()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.g.s():void");
    }

    /* access modifiers changed from: package-private */
    public boolean s0() {
        h.b bVar = this.f647s;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        a n5 = n();
        return n5 != null && n5.h();
    }

    public void t(Bundle bundle) {
        a0();
    }

    /* access modifiers changed from: package-private */
    public boolean t0(int i5, KeyEvent keyEvent) {
        boolean z4 = true;
        if (i5 == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z4 = false;
            }
            this.M = z4;
        } else if (i5 == 82) {
            u0(0, keyEvent);
            return true;
        }
        return false;
    }

    public void u() {
        a n5 = n();
        if (n5 != null) {
            n5.t(true);
        }
    }

    public void v(Bundle bundle) {
    }

    /* access modifiers changed from: package-private */
    public boolean v0(int i5, KeyEvent keyEvent) {
        a n5 = n();
        if (n5 != null && n5.o(i5, keyEvent)) {
            return true;
        }
        s sVar = this.L;
        if (sVar == null || !D0(sVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.L == null) {
                s h02 = h0(0, true);
                E0(h02, keyEvent);
                boolean D0 = D0(h02, keyEvent.getKeyCode(), keyEvent, 1);
                h02.f687m = false;
                if (D0) {
                    return true;
                }
            }
            return false;
        }
        s sVar2 = this.L;
        if (sVar2 != null) {
            sVar2.f688n = true;
        }
        return true;
    }

    public void w() {
        this.P = true;
        J();
    }

    /* access modifiers changed from: package-private */
    public boolean w0(int i5, KeyEvent keyEvent) {
        if (i5 == 4) {
            boolean z4 = this.M;
            this.M = false;
            s h02 = h0(0, false);
            if (h02 != null && h02.f689o) {
                if (!z4) {
                    S(h02, true);
                }
                return true;
            } else if (s0()) {
                return true;
            }
        } else if (i5 == 82) {
            x0(0, keyEvent);
            return true;
        }
        return false;
    }

    public void x() {
        this.P = false;
        a n5 = n();
        if (n5 != null) {
            n5.t(false);
        }
    }

    /* access modifiers changed from: package-private */
    public void y0(int i5) {
        a n5;
        if (i5 == 108 && (n5 = n()) != null) {
            n5.i(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void z0(int i5) {
        if (i5 == 108) {
            a n5 = n();
            if (n5 != null) {
                n5.i(false);
            }
        } else if (i5 == 0) {
            s h02 = h0(i5, true);
            if (h02.f689o) {
                S(h02, false);
            }
        }
    }
}
