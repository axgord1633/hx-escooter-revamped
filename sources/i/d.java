package i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import o.a;

public class d extends b implements Menu {

    /* renamed from: d  reason: collision with root package name */
    private final a f4874d;

    public d(Context context, a aVar) {
        super(context);
        if (aVar != null) {
            this.f4874d = aVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public MenuItem add(int i5) {
        return c(this.f4874d.add(i5));
    }

    public MenuItem add(int i5, int i6, int i7, int i8) {
        return c(this.f4874d.add(i5, i6, i7, i8));
    }

    public MenuItem add(int i5, int i6, int i7, CharSequence charSequence) {
        return c(this.f4874d.add(i5, i6, i7, charSequence));
    }

    public MenuItem add(CharSequence charSequence) {
        return c(this.f4874d.add(charSequence));
    }

    public int addIntentOptions(int i5, int i6, int i7, ComponentName componentName, Intent[] intentArr, Intent intent, int i8, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr;
        MenuItem[] menuItemArr3 = menuItemArr2 != null ? new MenuItem[menuItemArr2.length] : null;
        int addIntentOptions = this.f4874d.addIntentOptions(i5, i6, i7, componentName, intentArr, intent, i8, menuItemArr3);
        if (menuItemArr3 != null) {
            int length = menuItemArr3.length;
            for (int i9 = 0; i9 < length; i9++) {
                menuItemArr2[i9] = c(menuItemArr3[i9]);
            }
        }
        return addIntentOptions;
    }

    public SubMenu addSubMenu(int i5) {
        return d(this.f4874d.addSubMenu(i5));
    }

    public SubMenu addSubMenu(int i5, int i6, int i7, int i8) {
        return d(this.f4874d.addSubMenu(i5, i6, i7, i8));
    }

    public SubMenu addSubMenu(int i5, int i6, int i7, CharSequence charSequence) {
        return d(this.f4874d.addSubMenu(i5, i6, i7, charSequence));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return d(this.f4874d.addSubMenu(charSequence));
    }

    public void clear() {
        e();
        this.f4874d.clear();
    }

    public void close() {
        this.f4874d.close();
    }

    public MenuItem findItem(int i5) {
        return c(this.f4874d.findItem(i5));
    }

    public MenuItem getItem(int i5) {
        return c(this.f4874d.getItem(i5));
    }

    public boolean hasVisibleItems() {
        return this.f4874d.hasVisibleItems();
    }

    public boolean isShortcutKey(int i5, KeyEvent keyEvent) {
        return this.f4874d.isShortcutKey(i5, keyEvent);
    }

    public boolean performIdentifierAction(int i5, int i6) {
        return this.f4874d.performIdentifierAction(i5, i6);
    }

    public boolean performShortcut(int i5, KeyEvent keyEvent, int i6) {
        return this.f4874d.performShortcut(i5, keyEvent, i6);
    }

    public void removeGroup(int i5) {
        f(i5);
        this.f4874d.removeGroup(i5);
    }

    public void removeItem(int i5) {
        g(i5);
        this.f4874d.removeItem(i5);
    }

    public void setGroupCheckable(int i5, boolean z4, boolean z5) {
        this.f4874d.setGroupCheckable(i5, z4, z5);
    }

    public void setGroupEnabled(int i5, boolean z4) {
        this.f4874d.setGroupEnabled(i5, z4);
    }

    public void setGroupVisible(int i5, boolean z4) {
        this.f4874d.setGroupVisible(i5, z4);
    }

    public void setQwertyMode(boolean z4) {
        this.f4874d.setQwertyMode(z4);
    }

    public int size() {
        return this.f4874d.size();
    }
}
