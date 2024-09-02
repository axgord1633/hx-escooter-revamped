package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import d.a;

public class w extends SeekBar {

    /* renamed from: e  reason: collision with root package name */
    private final x f1420e;

    public w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.H);
    }

    public w(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        f1.a(this, getContext());
        x xVar = new x(this);
        this.f1420e = xVar;
        xVar.c(attributeSet, i5);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f1420e.h();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f1420e.i();
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f1420e.g(canvas);
    }
}
