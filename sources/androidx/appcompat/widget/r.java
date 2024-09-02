package androidx.appcompat.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.graphics.drawable.h;

class r {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f1385c = {16843067, 16843068};

    /* renamed from: a  reason: collision with root package name */
    private final ProgressBar f1386a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f1387b;

    r(ProgressBar progressBar) {
        this.f1386a = progressBar;
    }

    private Shape a() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, (RectF) null, (float[]) null);
    }

    private Drawable d(Drawable drawable, boolean z4) {
        if (drawable instanceof h) {
            h hVar = (h) drawable;
            Drawable b5 = hVar.b();
            if (b5 != null) {
                hVar.a(d(b5, z4));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i5 = 0; i5 < numberOfLayers; i5++) {
                int id = layerDrawable.getId(i5);
                drawableArr[i5] = d(layerDrawable.getDrawable(i5), id == 16908301 || id == 16908303);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i6 = 0; i6 < numberOfLayers; i6++) {
                layerDrawable2.setId(i6, layerDrawable.getId(i6));
            }
            return layerDrawable2;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f1387b == null) {
                this.f1387b = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(a());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z4 ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        return drawable;
    }

    private Drawable e(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i5 = 0; i5 < numberOfFrames; i5++) {
            Drawable d5 = d(animationDrawable.getFrame(i5), true);
            d5.setLevel(10000);
            animationDrawable2.addFrame(d5, animationDrawable.getDuration(i5));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    /* access modifiers changed from: package-private */
    public Bitmap b() {
        return this.f1387b;
    }

    /* access modifiers changed from: package-private */
    public void c(AttributeSet attributeSet, int i5) {
        k1 u5 = k1.u(this.f1386a.getContext(), attributeSet, f1385c, i5, 0);
        Drawable g5 = u5.g(0);
        if (g5 != null) {
            this.f1386a.setIndeterminateDrawable(e(g5));
        }
        Drawable g6 = u5.g(1);
        if (g6 != null) {
            this.f1386a.setProgressDrawable(d(g6, false));
        }
        u5.v();
    }
}
