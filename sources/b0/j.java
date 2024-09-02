package b0;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

class j implements TypeEvaluator<Rect> {

    /* renamed from: a  reason: collision with root package name */
    private Rect f2893a;

    j() {
    }

    /* renamed from: a */
    public Rect evaluate(float f5, Rect rect, Rect rect2) {
        int i5 = rect.left;
        int i6 = i5 + ((int) (((float) (rect2.left - i5)) * f5));
        int i7 = rect.top;
        int i8 = i7 + ((int) (((float) (rect2.top - i7)) * f5));
        int i9 = rect.right;
        int i10 = i9 + ((int) (((float) (rect2.right - i9)) * f5));
        int i11 = rect.bottom;
        int i12 = i11 + ((int) (((float) (rect2.bottom - i11)) * f5));
        Rect rect3 = this.f2893a;
        if (rect3 == null) {
            return new Rect(i6, i8, i10, i12);
        }
        rect3.set(i6, i8, i10, i12);
        return this.f2893a;
    }
}
