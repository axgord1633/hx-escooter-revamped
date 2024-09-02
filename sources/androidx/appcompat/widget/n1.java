package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;

public class n1 {
    public static void a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            o1.f(view, charSequence);
        }
    }
}
