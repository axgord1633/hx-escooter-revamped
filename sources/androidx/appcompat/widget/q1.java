package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

public class q1 extends Resources {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1383b = false;

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f1384a;

    public q1(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1384a = new WeakReference<>(context);
    }

    public static boolean a() {
        return f1383b;
    }

    public static void b(boolean z4) {
        f1383b = z4;
    }

    public static boolean c() {
        boolean a5 = a();
        return false;
    }

    /* access modifiers changed from: package-private */
    public final Drawable d(int i5) {
        return super.getDrawable(i5);
    }

    public Drawable getDrawable(int i5) {
        Context context = this.f1384a.get();
        return context != null ? a1.h().t(context, this, i5) : super.getDrawable(i5);
    }
}
