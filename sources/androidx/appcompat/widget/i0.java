package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.core.view.k0;
import com.yalantis.ucrop.view.CropImageView;
import d.j;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

class i0 {

    /* renamed from: l  reason: collision with root package name */
    private static final RectF f1273l = new RectF();

    /* renamed from: m  reason: collision with root package name */
    private static ConcurrentHashMap<String, Method> f1274m = new ConcurrentHashMap<>();

    /* renamed from: n  reason: collision with root package name */
    private static ConcurrentHashMap<String, Field> f1275n = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private int f1276a = 0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1277b = false;

    /* renamed from: c  reason: collision with root package name */
    private float f1278c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    private float f1279d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    private float f1280e = -1.0f;

    /* renamed from: f  reason: collision with root package name */
    private int[] f1281f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    private boolean f1282g = false;

    /* renamed from: h  reason: collision with root package name */
    private TextPaint f1283h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f1284i;

    /* renamed from: j  reason: collision with root package name */
    private final Context f1285j;

    /* renamed from: k  reason: collision with root package name */
    private final c f1286k;

    private static class a extends c {
        a() {
        }

        /* access modifiers changed from: package-private */
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) i0.n(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    private static class b extends a {
        b() {
        }

        /* access modifiers changed from: package-private */
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        /* access modifiers changed from: package-private */
        public boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    private static class c {
        c() {
        }

        /* access modifiers changed from: package-private */
        public void a(StaticLayout.Builder builder, TextView textView) {
            throw null;
        }

        /* access modifiers changed from: package-private */
        public boolean b(TextView textView) {
            return ((Boolean) i0.n(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    i0(TextView textView) {
        this.f1284i = textView;
        this.f1285j = textView.getContext();
        this.f1286k = Build.VERSION.SDK_INT >= 29 ? new b() : new a();
    }

    private void A(float f5, float f6, float f7) {
        if (f5 <= CropImageView.DEFAULT_ASPECT_RATIO) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f5 + "px) is less or equal to (0px)");
        } else if (f6 <= f5) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f6 + "px) is less or equal to minimum auto-size text size (" + f5 + "px)");
        } else if (f7 > CropImageView.DEFAULT_ASPECT_RATIO) {
            this.f1276a = 1;
            this.f1279d = f5;
            this.f1280e = f6;
            this.f1278c = f7;
            this.f1282g = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f7 + "px) is less or equal to (0px)");
        }
    }

    private int[] b(int[] iArr) {
        if (r0 == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i5 : iArr) {
            if (i5 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i5)) < 0) {
                arrayList.add(Integer.valueOf(i5));
            }
        }
        if (r0 == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i6 = 0; i6 < size; i6++) {
            iArr2[i6] = ((Integer) arrayList.get(i6)).intValue();
        }
        return iArr2;
    }

    private void c() {
        this.f1276a = 0;
        this.f1279d = -1.0f;
        this.f1280e = -1.0f;
        this.f1278c = -1.0f;
        this.f1281f = new int[0];
        this.f1277b = false;
    }

    private StaticLayout e(CharSequence charSequence, Layout.Alignment alignment, int i5, int i6) {
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f1283h, i5);
        StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(this.f1284i.getLineSpacingExtra(), this.f1284i.getLineSpacingMultiplier()).setIncludePad(this.f1284i.getIncludeFontPadding()).setBreakStrategy(this.f1284i.getBreakStrategy()).setHyphenationFrequency(this.f1284i.getHyphenationFrequency());
        if (i6 == -1) {
            i6 = Integer.MAX_VALUE;
        }
        hyphenationFrequency.setMaxLines(i6);
        try {
            this.f1286k.a(obtain, this.f1284i);
        } catch (ClassCastException unused) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return obtain.build();
    }

    private int f(RectF rectF) {
        int length = this.f1281f.length;
        if (length != 0) {
            int i5 = 0;
            int i6 = 1;
            int i7 = length - 1;
            while (true) {
                int i8 = i6;
                int i9 = i5;
                i5 = i8;
                while (i5 <= i7) {
                    int i10 = (i5 + i7) / 2;
                    if (y(this.f1281f[i10], rectF)) {
                        i6 = i10 + 1;
                    } else {
                        i9 = i10 - 1;
                        i7 = i9;
                    }
                }
                return this.f1281f[i9];
            }
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    private static Method l(String str) {
        try {
            Method method = f1274m.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                f1274m.put(str, method);
            }
            return method;
        } catch (Exception e5) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e5);
            return null;
        }
    }

    static <T> T n(Object obj, String str, T t5) {
        try {
            return l(str).invoke(obj, new Object[0]);
        } catch (Exception e5) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e5);
            return t5;
        }
    }

    private void t(float f5) {
        if (f5 != this.f1284i.getPaint().getTextSize()) {
            this.f1284i.getPaint().setTextSize(f5);
            boolean isInLayout = this.f1284i.isInLayout();
            if (this.f1284i.getLayout() != null) {
                this.f1277b = false;
                try {
                    Method l5 = l("nullLayouts");
                    if (l5 != null) {
                        l5.invoke(this.f1284i, new Object[0]);
                    }
                } catch (Exception e5) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e5);
                }
                if (!isInLayout) {
                    this.f1284i.requestLayout();
                } else {
                    this.f1284i.forceLayout();
                }
                this.f1284i.invalidate();
            }
        }
    }

    private boolean v() {
        if (!z() || this.f1276a != 1) {
            this.f1277b = false;
        } else {
            if (!this.f1282g || this.f1281f.length == 0) {
                int floor = ((int) Math.floor((double) ((this.f1280e - this.f1279d) / this.f1278c))) + 1;
                int[] iArr = new int[floor];
                for (int i5 = 0; i5 < floor; i5++) {
                    iArr[i5] = Math.round(this.f1279d + (((float) i5) * this.f1278c));
                }
                this.f1281f = b(iArr);
            }
            this.f1277b = true;
        }
        return this.f1277b;
    }

    private void w(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i5 = 0; i5 < length; i5++) {
                iArr[i5] = typedArray.getDimensionPixelSize(i5, -1);
            }
            this.f1281f = b(iArr);
            x();
        }
    }

    private boolean x() {
        int[] iArr = this.f1281f;
        int length = iArr.length;
        boolean z4 = length > 0;
        this.f1282g = z4;
        if (z4) {
            this.f1276a = 1;
            this.f1279d = (float) iArr[0];
            this.f1280e = (float) iArr[length - 1];
            this.f1278c = -1.0f;
        }
        return z4;
    }

    private boolean y(int i5, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f1284i.getText();
        TransformationMethod transformationMethod = this.f1284i.getTransformationMethod();
        if (!(transformationMethod == null || (transformation = transformationMethod.getTransformation(text, this.f1284i)) == null)) {
            text = transformation;
        }
        int maxLines = this.f1284i.getMaxLines();
        m(i5);
        StaticLayout d5 = d(text, (Layout.Alignment) n(this.f1284i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (d5.getLineCount() <= maxLines && d5.getLineEnd(d5.getLineCount() - 1) == text.length())) && ((float) d5.getHeight()) <= rectF.bottom;
    }

    private boolean z() {
        return !(this.f1284i instanceof k);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (o()) {
            if (this.f1277b) {
                if (this.f1284i.getMeasuredHeight() > 0 && this.f1284i.getMeasuredWidth() > 0) {
                    int measuredWidth = this.f1286k.b(this.f1284i) ? 1048576 : (this.f1284i.getMeasuredWidth() - this.f1284i.getTotalPaddingLeft()) - this.f1284i.getTotalPaddingRight();
                    int height = (this.f1284i.getHeight() - this.f1284i.getCompoundPaddingBottom()) - this.f1284i.getCompoundPaddingTop();
                    if (measuredWidth > 0 && height > 0) {
                        RectF rectF = f1273l;
                        synchronized (rectF) {
                            rectF.setEmpty();
                            rectF.right = (float) measuredWidth;
                            rectF.bottom = (float) height;
                            float f5 = (float) f(rectF);
                            if (f5 != this.f1284i.getTextSize()) {
                                u(0, f5);
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f1277b = true;
        }
    }

    /* access modifiers changed from: package-private */
    public StaticLayout d(CharSequence charSequence, Layout.Alignment alignment, int i5, int i6) {
        return e(charSequence, alignment, i5, i6);
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return Math.round(this.f1280e);
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return Math.round(this.f1279d);
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return Math.round(this.f1278c);
    }

    /* access modifiers changed from: package-private */
    public int[] j() {
        return this.f1281f;
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return this.f1276a;
    }

    /* access modifiers changed from: package-private */
    public void m(int i5) {
        TextPaint textPaint = this.f1283h;
        if (textPaint == null) {
            this.f1283h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f1283h.set(this.f1284i.getPaint());
        this.f1283h.setTextSize((float) i5);
    }

    /* access modifiers changed from: package-private */
    public boolean o() {
        return z() && this.f1276a != 0;
    }

    /* access modifiers changed from: package-private */
    public void p(AttributeSet attributeSet, int i5) {
        int resourceId;
        Context context = this.f1285j;
        int[] iArr = j.f4141i0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i5, 0);
        TextView textView = this.f1284i;
        k0.M(textView, textView.getContext(), iArr, attributeSet, obtainStyledAttributes, i5, 0);
        int i6 = j.f4166n0;
        if (obtainStyledAttributes.hasValue(i6)) {
            this.f1276a = obtainStyledAttributes.getInt(i6, 0);
        }
        int i7 = j.f4161m0;
        float dimension = obtainStyledAttributes.hasValue(i7) ? obtainStyledAttributes.getDimension(i7, -1.0f) : -1.0f;
        int i8 = j.f4151k0;
        float dimension2 = obtainStyledAttributes.hasValue(i8) ? obtainStyledAttributes.getDimension(i8, -1.0f) : -1.0f;
        int i9 = j.f4146j0;
        float dimension3 = obtainStyledAttributes.hasValue(i9) ? obtainStyledAttributes.getDimension(i9, -1.0f) : -1.0f;
        int i10 = j.f4156l0;
        if (obtainStyledAttributes.hasValue(i10) && (resourceId = obtainStyledAttributes.getResourceId(i10, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            w(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!z()) {
            this.f1276a = 0;
        } else if (this.f1276a == 1) {
            if (!this.f1282g) {
                DisplayMetrics displayMetrics = this.f1285j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                A(dimension2, dimension3, dimension);
            }
            v();
        }
    }

    /* access modifiers changed from: package-private */
    public void q(int i5, int i6, int i7, int i8) {
        if (z()) {
            DisplayMetrics displayMetrics = this.f1285j.getResources().getDisplayMetrics();
            A(TypedValue.applyDimension(i8, (float) i5, displayMetrics), TypedValue.applyDimension(i8, (float) i6, displayMetrics), TypedValue.applyDimension(i8, (float) i7, displayMetrics));
            if (v()) {
                a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void r(int[] iArr, int i5) {
        if (z()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i5 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f1285j.getResources().getDisplayMetrics();
                    for (int i6 = 0; i6 < length; i6++) {
                        iArr2[i6] = Math.round(TypedValue.applyDimension(i5, (float) iArr[i6], displayMetrics));
                    }
                }
                this.f1281f = b(iArr2);
                if (!x()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f1282g = false;
            }
            if (v()) {
                a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void s(int i5) {
        if (!z()) {
            return;
        }
        if (i5 == 0) {
            c();
        } else if (i5 == 1) {
            DisplayMetrics displayMetrics = this.f1285j.getResources().getDisplayMetrics();
            A(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (v()) {
                a();
            }
        } else {
            throw new IllegalArgumentException("Unknown auto-size text type: " + i5);
        }
    }

    /* access modifiers changed from: package-private */
    public void u(int i5, float f5) {
        Context context = this.f1285j;
        t(TypedValue.applyDimension(i5, f5, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }
}
