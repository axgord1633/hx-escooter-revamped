package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import d.a;

public class t extends RatingBar {

    /* renamed from: e  reason: collision with root package name */
    private final r f1418e;

    public t(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.F);
    }

    public t(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        f1.a(this, getContext());
        r rVar = new r(this);
        this.f1418e = rVar;
        rVar.c(attributeSet, i5);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        Bitmap b5 = this.f1418e.b();
        if (b5 != null) {
            setMeasuredDimension(View.resolveSizeAndState(b5.getWidth() * getNumStars(), i5, 0), getMeasuredHeight());
        }
    }
}
