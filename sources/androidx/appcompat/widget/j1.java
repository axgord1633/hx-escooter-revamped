package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

class j1 extends b1 {

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f1300b;

    public j1(Context context, Resources resources) {
        super(resources);
        this.f1300b = new WeakReference<>(context);
    }

    public Drawable getDrawable(int i5) {
        Drawable drawable = super.getDrawable(i5);
        Context context = this.f1300b.get();
        if (!(drawable == null || context == null)) {
            a1.h().x(context, i5, drawable);
        }
        return drawable;
    }
}
