package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.k;
import androidx.core.view.b;
import com.yalantis.ucrop.BuildConfig;
import d.h;
import o.b;

public final class g implements b {
    private View A;
    private androidx.core.view.b B;
    private MenuItem.OnActionExpandListener C;
    private boolean D = false;
    private ContextMenu.ContextMenuInfo E;

    /* renamed from: a  reason: collision with root package name */
    private final int f898a;

    /* renamed from: b  reason: collision with root package name */
    private final int f899b;

    /* renamed from: c  reason: collision with root package name */
    private final int f900c;

    /* renamed from: d  reason: collision with root package name */
    private final int f901d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f902e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f903f;

    /* renamed from: g  reason: collision with root package name */
    private Intent f904g;

    /* renamed from: h  reason: collision with root package name */
    private char f905h;

    /* renamed from: i  reason: collision with root package name */
    private int f906i = 4096;

    /* renamed from: j  reason: collision with root package name */
    private char f907j;

    /* renamed from: k  reason: collision with root package name */
    private int f908k = 4096;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f909l;

    /* renamed from: m  reason: collision with root package name */
    private int f910m = 0;

    /* renamed from: n  reason: collision with root package name */
    e f911n;

    /* renamed from: o  reason: collision with root package name */
    private m f912o;

    /* renamed from: p  reason: collision with root package name */
    private Runnable f913p;

    /* renamed from: q  reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f914q;

    /* renamed from: r  reason: collision with root package name */
    private CharSequence f915r;

    /* renamed from: s  reason: collision with root package name */
    private CharSequence f916s;

    /* renamed from: t  reason: collision with root package name */
    private ColorStateList f917t = null;

    /* renamed from: u  reason: collision with root package name */
    private PorterDuff.Mode f918u = null;

    /* renamed from: v  reason: collision with root package name */
    private boolean f919v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f920w = false;

    /* renamed from: x  reason: collision with root package name */
    private boolean f921x = false;

    /* renamed from: y  reason: collision with root package name */
    private int f922y = 16;

    /* renamed from: z  reason: collision with root package name */
    private int f923z;

    class a implements b.C0031b {
        a() {
        }

        public void onActionProviderVisibilityChanged(boolean z4) {
            g gVar = g.this;
            gVar.f911n.J(gVar);
        }
    }

    g(e eVar, int i5, int i6, int i7, int i8, CharSequence charSequence, int i9) {
        this.f911n = eVar;
        this.f898a = i6;
        this.f899b = i5;
        this.f900c = i7;
        this.f901d = i8;
        this.f902e = charSequence;
        this.f923z = i9;
    }

    private static void d(StringBuilder sb, int i5, int i6, String str) {
        if ((i5 & i6) == i6) {
            sb.append(str);
        }
    }

    private Drawable e(Drawable drawable) {
        if (drawable != null && this.f921x && (this.f919v || this.f920w)) {
            drawable = androidx.core.graphics.drawable.a.p(drawable).mutate();
            if (this.f919v) {
                androidx.core.graphics.drawable.a.n(drawable, this.f917t);
            }
            if (this.f920w) {
                androidx.core.graphics.drawable.a.o(drawable, this.f918u);
            }
            this.f921x = false;
        }
        return drawable;
    }

    /* access modifiers changed from: package-private */
    public boolean A() {
        return this.f911n.H() && g() != 0;
    }

    public boolean B() {
        return (this.f923z & 4) == 4;
    }

    public o.b a(androidx.core.view.b bVar) {
        androidx.core.view.b bVar2 = this.B;
        if (bVar2 != null) {
            bVar2.h();
        }
        this.A = null;
        this.B = bVar;
        this.f911n.K(true);
        androidx.core.view.b bVar3 = this.B;
        if (bVar3 != null) {
            bVar3.j(new a());
        }
        return this;
    }

    public androidx.core.view.b b() {
        return this.B;
    }

    public void c() {
        this.f911n.I(this);
    }

    public boolean collapseActionView() {
        if ((this.f923z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f911n.f(this);
        }
        return false;
    }

    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f911n.k(this);
        }
        return false;
    }

    public int f() {
        return this.f901d;
    }

    /* access modifiers changed from: package-private */
    public char g() {
        return this.f911n.G() ? this.f907j : this.f905h;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        androidx.core.view.b bVar = this.B;
        if (bVar == null) {
            return null;
        }
        View d5 = bVar.d(this);
        this.A = d5;
        return d5;
    }

    public int getAlphabeticModifiers() {
        return this.f908k;
    }

    public char getAlphabeticShortcut() {
        return this.f907j;
    }

    public CharSequence getContentDescription() {
        return this.f915r;
    }

    public int getGroupId() {
        return this.f899b;
    }

    public Drawable getIcon() {
        Drawable drawable = this.f909l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f910m == 0) {
            return null;
        }
        Drawable b5 = e.a.b(this.f911n.u(), this.f910m);
        this.f910m = 0;
        this.f909l = b5;
        return e(b5);
    }

    public ColorStateList getIconTintList() {
        return this.f917t;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f918u;
    }

    public Intent getIntent() {
        return this.f904g;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f898a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    public int getNumericModifiers() {
        return this.f906i;
    }

    public char getNumericShortcut() {
        return this.f905h;
    }

    public int getOrder() {
        return this.f900c;
    }

    public SubMenu getSubMenu() {
        return this.f912o;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f902e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f903f;
        return charSequence != null ? charSequence : this.f902e;
    }

    public CharSequence getTooltipText() {
        return this.f916s;
    }

    /* access modifiers changed from: package-private */
    public String h() {
        int i5;
        char g5 = g();
        if (g5 == 0) {
            return BuildConfig.FLAVOR;
        }
        Resources resources = this.f911n.u().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f911n.u()).hasPermanentMenuKey()) {
            sb.append(resources.getString(h.f4094k));
        }
        int i6 = this.f911n.G() ? this.f908k : this.f906i;
        d(sb, i6, 65536, resources.getString(h.f4090g));
        d(sb, i6, 4096, resources.getString(h.f4086c));
        d(sb, i6, 2, resources.getString(h.f4085b));
        d(sb, i6, 1, resources.getString(h.f4091h));
        d(sb, i6, 4, resources.getString(h.f4093j));
        d(sb, i6, 8, resources.getString(h.f4089f));
        if (g5 == 8) {
            i5 = h.f4087d;
        } else if (g5 == 10) {
            i5 = h.f4088e;
        } else if (g5 != ' ') {
            sb.append(g5);
            return sb.toString();
        } else {
            i5 = h.f4092i;
        }
        sb.append(resources.getString(i5));
        return sb.toString();
    }

    public boolean hasSubMenu() {
        return this.f912o != null;
    }

    /* access modifiers changed from: package-private */
    public CharSequence i(k.a aVar) {
        return (aVar == null || !aVar.a()) ? getTitle() : getTitleCondensed();
    }

    public boolean isActionViewExpanded() {
        return this.D;
    }

    public boolean isCheckable() {
        return (this.f922y & 1) == 1;
    }

    public boolean isChecked() {
        return (this.f922y & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.f922y & 16) != 0;
    }

    public boolean isVisible() {
        androidx.core.view.b bVar = this.B;
        return (bVar == null || !bVar.g()) ? (this.f922y & 8) == 0 : (this.f922y & 8) == 0 && this.B.b();
    }

    public boolean j() {
        androidx.core.view.b bVar;
        if ((this.f923z & 8) == 0) {
            return false;
        }
        if (this.A == null && (bVar = this.B) != null) {
            this.A = bVar.d(this);
        }
        return this.A != null;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f914q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        e eVar = this.f911n;
        if (eVar.h(eVar, this)) {
            return true;
        }
        Runnable runnable = this.f913p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f904g != null) {
            try {
                this.f911n.u().startActivity(this.f904g);
                return true;
            } catch (ActivityNotFoundException e5) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e5);
            }
        }
        androidx.core.view.b bVar = this.B;
        return bVar != null && bVar.e();
    }

    public boolean l() {
        return (this.f922y & 32) == 32;
    }

    public boolean m() {
        return (this.f922y & 4) != 0;
    }

    public boolean n() {
        return (this.f923z & 1) == 1;
    }

    public boolean o() {
        return (this.f923z & 2) == 2;
    }

    /* renamed from: p */
    public o.b setActionView(int i5) {
        Context u5 = this.f911n.u();
        setActionView(LayoutInflater.from(u5).inflate(i5, new LinearLayout(u5), false));
        return this;
    }

    /* renamed from: q */
    public o.b setActionView(View view) {
        int i5;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i5 = this.f898a) > 0) {
            view.setId(i5);
        }
        this.f911n.I(this);
        return this;
    }

    public void r(boolean z4) {
        this.D = z4;
        this.f911n.K(false);
    }

    /* access modifiers changed from: package-private */
    public void s(boolean z4) {
        int i5 = this.f922y;
        int i6 = (z4 ? 2 : 0) | (i5 & -3);
        this.f922y = i6;
        if (i5 != i6) {
            this.f911n.K(false);
        }
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public MenuItem setAlphabeticShortcut(char c5) {
        if (this.f907j == c5) {
            return this;
        }
        this.f907j = Character.toLowerCase(c5);
        this.f911n.K(false);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c5, int i5) {
        if (this.f907j == c5 && this.f908k == i5) {
            return this;
        }
        this.f907j = Character.toLowerCase(c5);
        this.f908k = KeyEvent.normalizeMetaState(i5);
        this.f911n.K(false);
        return this;
    }

    public MenuItem setCheckable(boolean z4) {
        int i5 = this.f922y;
        boolean z5 = z4 | (i5 & true);
        this.f922y = z5 ? 1 : 0;
        if (i5 != z5) {
            this.f911n.K(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z4) {
        if ((this.f922y & 4) != 0) {
            this.f911n.T(this);
        } else {
            s(z4);
        }
        return this;
    }

    public o.b setContentDescription(CharSequence charSequence) {
        this.f915r = charSequence;
        this.f911n.K(false);
        return this;
    }

    public MenuItem setEnabled(boolean z4) {
        this.f922y = z4 ? this.f922y | 16 : this.f922y & -17;
        this.f911n.K(false);
        return this;
    }

    public MenuItem setIcon(int i5) {
        this.f909l = null;
        this.f910m = i5;
        this.f921x = true;
        this.f911n.K(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f910m = 0;
        this.f909l = drawable;
        this.f921x = true;
        this.f911n.K(false);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f917t = colorStateList;
        this.f919v = true;
        this.f921x = true;
        this.f911n.K(false);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f918u = mode;
        this.f920w = true;
        this.f921x = true;
        this.f911n.K(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f904g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c5) {
        if (this.f905h == c5) {
            return this;
        }
        this.f905h = c5;
        this.f911n.K(false);
        return this;
    }

    public MenuItem setNumericShortcut(char c5, int i5) {
        if (this.f905h == c5 && this.f906i == i5) {
            return this;
        }
        this.f905h = c5;
        this.f906i = KeyEvent.normalizeMetaState(i5);
        this.f911n.K(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f914q = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c5, char c6) {
        this.f905h = c5;
        this.f907j = Character.toLowerCase(c6);
        this.f911n.K(false);
        return this;
    }

    public MenuItem setShortcut(char c5, char c6, int i5, int i6) {
        this.f905h = c5;
        this.f906i = KeyEvent.normalizeMetaState(i5);
        this.f907j = Character.toLowerCase(c6);
        this.f908k = KeyEvent.normalizeMetaState(i6);
        this.f911n.K(false);
        return this;
    }

    public void setShowAsAction(int i5) {
        int i6 = i5 & 3;
        if (i6 == 0 || i6 == 1 || i6 == 2) {
            this.f923z = i5;
            this.f911n.I(this);
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    public MenuItem setTitle(int i5) {
        return setTitle((CharSequence) this.f911n.u().getString(i5));
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f902e = charSequence;
        this.f911n.K(false);
        m mVar = this.f912o;
        if (mVar != null) {
            mVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f903f = charSequence;
        this.f911n.K(false);
        return this;
    }

    public o.b setTooltipText(CharSequence charSequence) {
        this.f916s = charSequence;
        this.f911n.K(false);
        return this;
    }

    public MenuItem setVisible(boolean z4) {
        if (y(z4)) {
            this.f911n.J(this);
        }
        return this;
    }

    public void t(boolean z4) {
        this.f922y = (z4 ? 4 : 0) | (this.f922y & -5);
    }

    public String toString() {
        CharSequence charSequence = this.f902e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z4) {
        this.f922y = z4 ? this.f922y | 32 : this.f922y & -33;
    }

    /* access modifiers changed from: package-private */
    public void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    /* renamed from: w */
    public o.b setShowAsActionFlags(int i5) {
        setShowAsAction(i5);
        return this;
    }

    public void x(m mVar) {
        this.f912o = mVar;
        mVar.setHeaderTitle(getTitle());
    }

    /* access modifiers changed from: package-private */
    public boolean y(boolean z4) {
        int i5 = this.f922y;
        int i6 = (z4 ? 0 : 8) | (i5 & -9);
        this.f922y = i6;
        return i5 != i6;
    }

    public boolean z() {
        return this.f911n.A();
    }
}
