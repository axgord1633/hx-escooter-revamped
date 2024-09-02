package i;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import o.b;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final int f4840a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4841b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4842c;

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f4843d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f4844e;

    /* renamed from: f  reason: collision with root package name */
    private Intent f4845f;

    /* renamed from: g  reason: collision with root package name */
    private char f4846g;

    /* renamed from: h  reason: collision with root package name */
    private int f4847h = 4096;

    /* renamed from: i  reason: collision with root package name */
    private char f4848i;

    /* renamed from: j  reason: collision with root package name */
    private int f4849j = 4096;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f4850k;

    /* renamed from: l  reason: collision with root package name */
    private Context f4851l;

    /* renamed from: m  reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f4852m;

    /* renamed from: n  reason: collision with root package name */
    private CharSequence f4853n;

    /* renamed from: o  reason: collision with root package name */
    private CharSequence f4854o;

    /* renamed from: p  reason: collision with root package name */
    private ColorStateList f4855p = null;

    /* renamed from: q  reason: collision with root package name */
    private PorterDuff.Mode f4856q = null;

    /* renamed from: r  reason: collision with root package name */
    private boolean f4857r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f4858s = false;

    /* renamed from: t  reason: collision with root package name */
    private int f4859t = 16;

    public a(Context context, int i5, int i6, int i7, int i8, CharSequence charSequence) {
        this.f4851l = context;
        this.f4840a = i6;
        this.f4841b = i5;
        this.f4842c = i8;
        this.f4843d = charSequence;
    }

    private void c() {
        Drawable drawable = this.f4850k;
        if (drawable == null) {
            return;
        }
        if (this.f4857r || this.f4858s) {
            Drawable p5 = androidx.core.graphics.drawable.a.p(drawable);
            this.f4850k = p5;
            Drawable mutate = p5.mutate();
            this.f4850k = mutate;
            if (this.f4857r) {
                androidx.core.graphics.drawable.a.n(mutate, this.f4855p);
            }
            if (this.f4858s) {
                androidx.core.graphics.drawable.a.o(this.f4850k, this.f4856q);
            }
        }
    }

    public b a(androidx.core.view.b bVar) {
        throw new UnsupportedOperationException();
    }

    public androidx.core.view.b b() {
        return null;
    }

    public boolean collapseActionView() {
        return false;
    }

    /* renamed from: d */
    public b setActionView(int i5) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: e */
    public b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public boolean expandActionView() {
        return false;
    }

    /* renamed from: f */
    public b setShowAsActionFlags(int i5) {
        setShowAsAction(i5);
        return this;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public int getAlphabeticModifiers() {
        return this.f4849j;
    }

    public char getAlphabeticShortcut() {
        return this.f4848i;
    }

    public CharSequence getContentDescription() {
        return this.f4853n;
    }

    public int getGroupId() {
        return this.f4841b;
    }

    public Drawable getIcon() {
        return this.f4850k;
    }

    public ColorStateList getIconTintList() {
        return this.f4855p;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f4856q;
    }

    public Intent getIntent() {
        return this.f4845f;
    }

    public int getItemId() {
        return this.f4840a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public int getNumericModifiers() {
        return this.f4847h;
    }

    public char getNumericShortcut() {
        return this.f4846g;
    }

    public int getOrder() {
        return this.f4842c;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f4843d;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f4844e;
        return charSequence != null ? charSequence : this.f4843d;
    }

    public CharSequence getTooltipText() {
        return this.f4854o;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f4859t & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f4859t & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f4859t & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f4859t & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c5) {
        this.f4848i = Character.toLowerCase(c5);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c5, int i5) {
        this.f4848i = Character.toLowerCase(c5);
        this.f4849j = KeyEvent.normalizeMetaState(i5);
        return this;
    }

    public MenuItem setCheckable(boolean z4) {
        this.f4859t = z4 | (this.f4859t & true) ? 1 : 0;
        return this;
    }

    public MenuItem setChecked(boolean z4) {
        this.f4859t = (z4 ? 2 : 0) | (this.f4859t & -3);
        return this;
    }

    public b setContentDescription(CharSequence charSequence) {
        this.f4853n = charSequence;
        return this;
    }

    public MenuItem setEnabled(boolean z4) {
        this.f4859t = (z4 ? 16 : 0) | (this.f4859t & -17);
        return this;
    }

    public MenuItem setIcon(int i5) {
        this.f4850k = androidx.core.content.a.c(this.f4851l, i5);
        c();
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f4850k = drawable;
        c();
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f4855p = colorStateList;
        this.f4857r = true;
        c();
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f4856q = mode;
        this.f4858s = true;
        c();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f4845f = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c5) {
        this.f4846g = c5;
        return this;
    }

    public MenuItem setNumericShortcut(char c5, int i5) {
        this.f4846g = c5;
        this.f4847h = KeyEvent.normalizeMetaState(i5);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f4852m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c5, char c6) {
        this.f4846g = c5;
        this.f4848i = Character.toLowerCase(c6);
        return this;
    }

    public MenuItem setShortcut(char c5, char c6, int i5, int i6) {
        this.f4846g = c5;
        this.f4847h = KeyEvent.normalizeMetaState(i5);
        this.f4848i = Character.toLowerCase(c6);
        this.f4849j = KeyEvent.normalizeMetaState(i6);
        return this;
    }

    public void setShowAsAction(int i5) {
    }

    public MenuItem setTitle(int i5) {
        this.f4843d = this.f4851l.getResources().getString(i5);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f4843d = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f4844e = charSequence;
        return this;
    }

    public b setTooltipText(CharSequence charSequence) {
        this.f4854o = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z4) {
        int i5 = 8;
        int i6 = this.f4859t & 8;
        if (z4) {
            i5 = 0;
        }
        this.f4859t = i6 | i5;
        return this;
    }
}
