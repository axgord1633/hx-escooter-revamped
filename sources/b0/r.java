package b0;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.yalantis.ucrop.view.CropImageView;

class r {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f2956a = true;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f2957b = true;

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f2958c;

    static {
        int i5 = Build.VERSION.SDK_INT;
        boolean z4 = true;
        if (i5 < 28) {
            z4 = false;
        }
        f2958c = z4;
    }

    static View a(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        a0.i(view, matrix);
        a0.j(viewGroup, matrix);
        RectF rectF = new RectF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, (float) view.getWidth(), (float) view.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.left);
        int round2 = Math.round(rectF.top);
        int round3 = Math.round(rectF.right);
        int round4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap b5 = b(view, matrix, rectF, viewGroup);
        if (b5 != null) {
            imageView.setImageBitmap(b5);
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
        imageView.layout(round, round2, round3, round4);
        return imageView;
    }

    private static Bitmap b(View view, Matrix matrix, RectF rectF, ViewGroup viewGroup) {
        boolean z4;
        boolean z5;
        int i5;
        ViewGroup viewGroup2;
        if (f2956a) {
            z5 = !view.isAttachedToWindow();
            z4 = viewGroup == null ? false : viewGroup.isAttachedToWindow();
        } else {
            z5 = false;
            z4 = false;
        }
        boolean z6 = f2957b;
        Bitmap bitmap = null;
        if (!z6 || !z5) {
            i5 = 0;
            viewGroup2 = null;
        } else if (!z4) {
            return null;
        } else {
            viewGroup2 = (ViewGroup) view.getParent();
            i5 = viewGroup2.indexOfChild(view);
            viewGroup.getOverlay().add(view);
        }
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        if (round > 0 && round2 > 0) {
            float min = Math.min(1.0f, 1048576.0f / ((float) (round * round2)));
            int round3 = Math.round(((float) round) * min);
            int round4 = Math.round(((float) round2) * min);
            matrix.postTranslate(-rectF.left, -rectF.top);
            matrix.postScale(min, min);
            if (f2958c) {
                Picture picture = new Picture();
                Canvas beginRecording = picture.beginRecording(round3, round4);
                beginRecording.concat(matrix);
                view.draw(beginRecording);
                picture.endRecording();
                bitmap = Bitmap.createBitmap(picture);
            } else {
                bitmap = Bitmap.createBitmap(round3, round4, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                canvas.concat(matrix);
                view.draw(canvas);
            }
        }
        if (z6 && z5) {
            viewGroup.getOverlay().remove(view);
            viewGroup2.addView(view, i5);
        }
        return bitmap;
    }

    static Animator c(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{animator, animator2});
        return animatorSet;
    }
}
