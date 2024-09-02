package com.yalantis.ucrop.util;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

public class SelectedStateListDrawable extends StateListDrawable {
    private int mSelectionColor;

    public SelectedStateListDrawable(Drawable drawable, int i5) {
        this.mSelectionColor = i5;
        addState(new int[]{16842913}, drawable);
        addState(new int[0], drawable);
    }

    public boolean isStateful() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean z4 = false;
        for (int i5 : iArr) {
            if (i5 == 16842913) {
                z4 = true;
            }
        }
        if (z4) {
            super.setColorFilter(this.mSelectionColor, PorterDuff.Mode.SRC_ATOP);
        } else {
            super.clearColorFilter();
        }
        return super.onStateChange(iArr);
    }
}
