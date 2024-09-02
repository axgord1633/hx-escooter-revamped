package b0;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

class y implements z {

    /* renamed from: a  reason: collision with root package name */
    private final ViewOverlay f2968a;

    y(View view) {
        this.f2968a = view.getOverlay();
    }

    public void b(Drawable drawable) {
        this.f2968a.add(drawable);
    }

    public void d(Drawable drawable) {
        this.f2968a.remove(drawable);
    }
}
