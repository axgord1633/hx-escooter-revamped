package androidx.appcompat.widget;

import android.content.res.Resources;
import android.widget.SpinnerAdapter;

public interface g1 extends SpinnerAdapter {
    Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(Resources.Theme theme);
}
