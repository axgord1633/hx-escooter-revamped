package h2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import kotlin.jvm.internal.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4836a;

    public a(Context context) {
        k.e(context, "context");
        this.f4836a = context;
    }

    private final Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        Bitmap createBitmap = (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) ? Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private final Drawable e() {
        Drawable drawable = this.f4836a.getApplicationContext().getDrawable(this.f4836a.getApplicationContext().getApplicationInfo().icon);
        k.b(drawable);
        return drawable;
    }

    public final boolean b() {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return e() instanceof AdaptiveIconDrawable;
    }

    public final byte[] c() {
        Drawable e5 = e();
        if (e5 instanceof AdaptiveIconDrawable) {
            Drawable background = ((AdaptiveIconDrawable) e5).getBackground();
            k.d(background, "d.background");
            Bitmap a5 = a(background);
            if (a5 != null) {
                return b.a(a5);
            }
            return null;
        }
        throw new Exception("Icon is not a Adaptive Icon");
    }

    public final byte[] d() {
        Drawable e5 = e();
        if (e5 instanceof AdaptiveIconDrawable) {
            Drawable foreground = ((AdaptiveIconDrawable) e5).getForeground();
            k.d(foreground, "d.foreground");
            Bitmap a5 = a(foreground);
            if (a5 != null) {
                return b.a(a5);
            }
            return null;
        }
        throw new Exception("Icon is not a Adaptive Icon");
    }

    public final byte[] f() {
        Drawable applicationIcon = this.f4836a.getPackageManager().getApplicationIcon(this.f4836a.getApplicationInfo());
        k.d(applicationIcon, "context.packageManager.g…(context.applicationInfo)");
        Bitmap a5 = a(applicationIcon);
        if (a5 != null) {
            return b.a(a5);
        }
        return null;
    }
}
