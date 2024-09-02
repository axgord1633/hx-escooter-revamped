package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.res.h;

public class k1 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1305a;

    /* renamed from: b  reason: collision with root package name */
    private final TypedArray f1306b;

    /* renamed from: c  reason: collision with root package name */
    private TypedValue f1307c;

    private k1(Context context, TypedArray typedArray) {
        this.f1305a = context;
        this.f1306b = typedArray;
    }

    public static k1 s(Context context, int i5, int[] iArr) {
        return new k1(context, context.obtainStyledAttributes(i5, iArr));
    }

    public static k1 t(Context context, AttributeSet attributeSet, int[] iArr) {
        return new k1(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static k1 u(Context context, AttributeSet attributeSet, int[] iArr, int i5, int i6) {
        return new k1(context, context.obtainStyledAttributes(attributeSet, iArr, i5, i6));
    }

    public boolean a(int i5, boolean z4) {
        return this.f1306b.getBoolean(i5, z4);
    }

    public int b(int i5, int i6) {
        return this.f1306b.getColor(i5, i6);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r0 = e.a.a(r2.f1305a, (r0 = r2.f1306b.getResourceId(r3, 0)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.content.res.ColorStateList c(int r3) {
        /*
            r2 = this;
            android.content.res.TypedArray r0 = r2.f1306b
            boolean r0 = r0.hasValue(r3)
            if (r0 == 0) goto L_0x001a
            android.content.res.TypedArray r0 = r2.f1306b
            r1 = 0
            int r0 = r0.getResourceId(r3, r1)
            if (r0 == 0) goto L_0x001a
            android.content.Context r1 = r2.f1305a
            android.content.res.ColorStateList r0 = e.a.a(r1, r0)
            if (r0 == 0) goto L_0x001a
            return r0
        L_0x001a:
            android.content.res.TypedArray r0 = r2.f1306b
            android.content.res.ColorStateList r3 = r0.getColorStateList(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.k1.c(int):android.content.res.ColorStateList");
    }

    public int d(int i5, int i6) {
        return this.f1306b.getDimensionPixelOffset(i5, i6);
    }

    public int e(int i5, int i6) {
        return this.f1306b.getDimensionPixelSize(i5, i6);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r2.f1306b.getResourceId(r3, 0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.drawable.Drawable f(int r3) {
        /*
            r2 = this;
            android.content.res.TypedArray r0 = r2.f1306b
            boolean r0 = r0.hasValue(r3)
            if (r0 == 0) goto L_0x0018
            android.content.res.TypedArray r0 = r2.f1306b
            r1 = 0
            int r0 = r0.getResourceId(r3, r1)
            if (r0 == 0) goto L_0x0018
            android.content.Context r3 = r2.f1305a
            android.graphics.drawable.Drawable r3 = e.a.b(r3, r0)
            return r3
        L_0x0018:
            android.content.res.TypedArray r0 = r2.f1306b
            android.graphics.drawable.Drawable r3 = r0.getDrawable(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.k1.f(int):android.graphics.drawable.Drawable");
    }

    public Drawable g(int i5) {
        int resourceId;
        if (!this.f1306b.hasValue(i5) || (resourceId = this.f1306b.getResourceId(i5, 0)) == 0) {
            return null;
        }
        return j.b().d(this.f1305a, resourceId, true);
    }

    public float h(int i5, float f5) {
        return this.f1306b.getFloat(i5, f5);
    }

    public Typeface i(int i5, int i6, h.b bVar) {
        int resourceId = this.f1306b.getResourceId(i5, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1307c == null) {
            this.f1307c = new TypedValue();
        }
        return h.b(this.f1305a, resourceId, this.f1307c, i6, bVar);
    }

    public int j(int i5, int i6) {
        return this.f1306b.getInt(i5, i6);
    }

    public int k(int i5, int i6) {
        return this.f1306b.getInteger(i5, i6);
    }

    public int l(int i5, int i6) {
        return this.f1306b.getLayoutDimension(i5, i6);
    }

    public int m(int i5, int i6) {
        return this.f1306b.getResourceId(i5, i6);
    }

    public String n(int i5) {
        return this.f1306b.getString(i5);
    }

    public CharSequence o(int i5) {
        return this.f1306b.getText(i5);
    }

    public CharSequence[] p(int i5) {
        return this.f1306b.getTextArray(i5);
    }

    public TypedArray q() {
        return this.f1306b;
    }

    public boolean r(int i5) {
        return this.f1306b.hasValue(i5);
    }

    public void v() {
        this.f1306b.recycle();
    }
}
