package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

class b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final ActionBarContainer f1149a;

    public b(ActionBarContainer actionBarContainer) {
        this.f1149a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f1149a;
        if (actionBarContainer.f969l) {
            Drawable drawable = actionBarContainer.f968k;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f966i;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f1149a;
        Drawable drawable3 = actionBarContainer2.f967j;
        if (drawable3 != null && actionBarContainer2.f970m) {
            drawable3.draw(canvas);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void getOutline(Outline outline) {
        Drawable drawable;
        ActionBarContainer actionBarContainer = this.f1149a;
        if (actionBarContainer.f969l) {
            drawable = actionBarContainer.f968k;
            if (drawable == null) {
                return;
            }
        } else {
            drawable = actionBarContainer.f966i;
            if (drawable == null) {
                return;
            }
        }
        drawable.getOutline(outline);
    }

    public void setAlpha(int i5) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
