package o;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;
import android.view.View;

public interface b extends MenuItem {
    b a(androidx.core.view.b bVar);

    androidx.core.view.b b();

    boolean collapseActionView();

    boolean expandActionView();

    View getActionView();

    int getAlphabeticModifiers();

    CharSequence getContentDescription();

    ColorStateList getIconTintList();

    PorterDuff.Mode getIconTintMode();

    int getNumericModifiers();

    CharSequence getTooltipText();

    boolean isActionViewExpanded();

    MenuItem setActionView(int i5);

    MenuItem setActionView(View view);

    MenuItem setAlphabeticShortcut(char c5, int i5);

    b setContentDescription(CharSequence charSequence);

    MenuItem setIconTintList(ColorStateList colorStateList);

    MenuItem setIconTintMode(PorterDuff.Mode mode);

    MenuItem setNumericShortcut(char c5, int i5);

    MenuItem setShortcut(char c5, char c6, int i5, int i6);

    void setShowAsAction(int i5);

    MenuItem setShowAsActionFlags(int i5);

    b setTooltipText(CharSequence charSequence);
}
