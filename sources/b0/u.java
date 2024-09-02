package b0;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

class u implements v {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroupOverlay f2966a;

    u(ViewGroup viewGroup) {
        this.f2966a = viewGroup.getOverlay();
    }

    public void a(View view) {
        this.f2966a.add(view);
    }

    public void b(Drawable drawable) {
        this.f2966a.add(drawable);
    }

    public void c(View view) {
        this.f2966a.remove(view);
    }

    public void d(Drawable drawable) {
        this.f2966a.remove(drawable);
    }
}
