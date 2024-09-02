package i;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.b;
import java.lang.reflect.Method;

public class c extends b implements MenuItem {

    /* renamed from: d  reason: collision with root package name */
    private final o.b f4863d;

    /* renamed from: e  reason: collision with root package name */
    private Method f4864e;

    private class a extends androidx.core.view.b {

        /* renamed from: d  reason: collision with root package name */
        final ActionProvider f4865d;

        a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f4865d = actionProvider;
        }

        public boolean a() {
            return this.f4865d.hasSubMenu();
        }

        public View c() {
            return this.f4865d.onCreateActionView();
        }

        public boolean e() {
            return this.f4865d.onPerformDefaultAction();
        }

        public void f(SubMenu subMenu) {
            this.f4865d.onPrepareSubMenu(c.this.d(subMenu));
        }
    }

    private class b extends a implements ActionProvider.VisibilityListener {

        /* renamed from: f  reason: collision with root package name */
        private b.C0031b f4867f;

        b(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public boolean b() {
            return this.f4865d.isVisible();
        }

        public View d(MenuItem menuItem) {
            return this.f4865d.onCreateActionView(menuItem);
        }

        public boolean g() {
            return this.f4865d.overridesItemVisibility();
        }

        public void j(b.C0031b bVar) {
            this.f4867f = bVar;
            this.f4865d.setVisibilityListener(bVar != null ? this : null);
        }

        public void onActionProviderVisibilityChanged(boolean z4) {
            b.C0031b bVar = this.f4867f;
            if (bVar != null) {
                bVar.onActionProviderVisibilityChanged(z4);
            }
        }
    }

    /* renamed from: i.c$c  reason: collision with other inner class name */
    static class C0081c extends FrameLayout implements h.c {

        /* renamed from: e  reason: collision with root package name */
        final CollapsibleActionView f4869e;

        C0081c(View view) {
            super(view.getContext());
            this.f4869e = (CollapsibleActionView) view;
            addView(view);
        }

        /* access modifiers changed from: package-private */
        public View a() {
            return (View) this.f4869e;
        }

        public void onActionViewCollapsed() {
            this.f4869e.onActionViewCollapsed();
        }

        public void onActionViewExpanded() {
            this.f4869e.onActionViewExpanded();
        }
    }

    private class d implements MenuItem.OnActionExpandListener {

        /* renamed from: a  reason: collision with root package name */
        private final MenuItem.OnActionExpandListener f4870a;

        d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f4870a = onActionExpandListener;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f4870a.onMenuItemActionCollapse(c.this.c(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f4870a.onMenuItemActionExpand(c.this.c(menuItem));
        }
    }

    private class e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        private final MenuItem.OnMenuItemClickListener f4872a;

        e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f4872a = onMenuItemClickListener;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f4872a.onMenuItemClick(c.this.c(menuItem));
        }
    }

    public c(Context context, o.b bVar) {
        super(context);
        if (bVar != null) {
            this.f4863d = bVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public boolean collapseActionView() {
        return this.f4863d.collapseActionView();
    }

    public boolean expandActionView() {
        return this.f4863d.expandActionView();
    }

    public ActionProvider getActionProvider() {
        androidx.core.view.b b5 = this.f4863d.b();
        if (b5 instanceof a) {
            return ((a) b5).f4865d;
        }
        return null;
    }

    public View getActionView() {
        View actionView = this.f4863d.getActionView();
        return actionView instanceof C0081c ? ((C0081c) actionView).a() : actionView;
    }

    public int getAlphabeticModifiers() {
        return this.f4863d.getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return this.f4863d.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.f4863d.getContentDescription();
    }

    public int getGroupId() {
        return this.f4863d.getGroupId();
    }

    public Drawable getIcon() {
        return this.f4863d.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.f4863d.getIconTintList();
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f4863d.getIconTintMode();
    }

    public Intent getIntent() {
        return this.f4863d.getIntent();
    }

    public int getItemId() {
        return this.f4863d.getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f4863d.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.f4863d.getNumericModifiers();
    }

    public char getNumericShortcut() {
        return this.f4863d.getNumericShortcut();
    }

    public int getOrder() {
        return this.f4863d.getOrder();
    }

    public SubMenu getSubMenu() {
        return d(this.f4863d.getSubMenu());
    }

    public CharSequence getTitle() {
        return this.f4863d.getTitle();
    }

    public CharSequence getTitleCondensed() {
        return this.f4863d.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.f4863d.getTooltipText();
    }

    public void h(boolean z4) {
        try {
            if (this.f4864e == null) {
                this.f4864e = this.f4863d.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f4864e.invoke(this.f4863d, new Object[]{Boolean.valueOf(z4)});
        } catch (Exception e5) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e5);
        }
    }

    public boolean hasSubMenu() {
        return this.f4863d.hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return this.f4863d.isActionViewExpanded();
    }

    public boolean isCheckable() {
        return this.f4863d.isCheckable();
    }

    public boolean isChecked() {
        return this.f4863d.isChecked();
    }

    public boolean isEnabled() {
        return this.f4863d.isEnabled();
    }

    public boolean isVisible() {
        return this.f4863d.isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        b bVar = new b(this.f4860a, actionProvider);
        o.b bVar2 = this.f4863d;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.a(bVar);
        return this;
    }

    public MenuItem setActionView(int i5) {
        this.f4863d.setActionView(i5);
        View actionView = this.f4863d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f4863d.setActionView((View) new C0081c(actionView));
        }
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0081c(view);
        }
        this.f4863d.setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c5) {
        this.f4863d.setAlphabeticShortcut(c5);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c5, int i5) {
        this.f4863d.setAlphabeticShortcut(c5, i5);
        return this;
    }

    public MenuItem setCheckable(boolean z4) {
        this.f4863d.setCheckable(z4);
        return this;
    }

    public MenuItem setChecked(boolean z4) {
        this.f4863d.setChecked(z4);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f4863d.setContentDescription(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean z4) {
        this.f4863d.setEnabled(z4);
        return this;
    }

    public MenuItem setIcon(int i5) {
        this.f4863d.setIcon(i5);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f4863d.setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f4863d.setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f4863d.setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f4863d.setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c5) {
        this.f4863d.setNumericShortcut(c5);
        return this;
    }

    public MenuItem setNumericShortcut(char c5, int i5) {
        this.f4863d.setNumericShortcut(c5, i5);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f4863d.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f4863d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c5, char c6) {
        this.f4863d.setShortcut(c5, c6);
        return this;
    }

    public MenuItem setShortcut(char c5, char c6, int i5, int i6) {
        this.f4863d.setShortcut(c5, c6, i5, i6);
        return this;
    }

    public void setShowAsAction(int i5) {
        this.f4863d.setShowAsAction(i5);
    }

    public MenuItem setShowAsActionFlags(int i5) {
        this.f4863d.setShowAsActionFlags(i5);
        return this;
    }

    public MenuItem setTitle(int i5) {
        this.f4863d.setTitle(i5);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f4863d.setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f4863d.setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f4863d.setTooltipText(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z4) {
        return this.f4863d.setVisible(z4);
    }
}
