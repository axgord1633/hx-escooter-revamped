package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.content.res.l;
import androidx.core.graphics.c;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class g extends f {

    /* renamed from: o  reason: collision with root package name */
    static final PorterDuff.Mode f2741o = PorterDuff.Mode.SRC_IN;

    /* renamed from: f  reason: collision with root package name */
    private h f2742f;

    /* renamed from: g  reason: collision with root package name */
    private PorterDuffColorFilter f2743g;

    /* renamed from: h  reason: collision with root package name */
    private ColorFilter f2744h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2745i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f2746j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable.ConstantState f2747k;

    /* renamed from: l  reason: collision with root package name */
    private final float[] f2748l;

    /* renamed from: m  reason: collision with root package name */
    private final Matrix f2749m;

    /* renamed from: n  reason: collision with root package name */
    private final Rect f2750n;

    private static class b extends f {
        b() {
        }

        b(b bVar) {
            super(bVar);
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f2777b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f2776a = androidx.core.graphics.c.d(string2);
            }
            this.f2778c = l.g(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (l.j(xmlPullParser, "pathData")) {
                TypedArray k5 = l.k(resources, theme, attributeSet, a.f2716d);
                f(k5, xmlPullParser);
                k5.recycle();
            }
        }
    }

    private static class c extends f {

        /* renamed from: e  reason: collision with root package name */
        private int[] f2751e;

        /* renamed from: f  reason: collision with root package name */
        androidx.core.content.res.d f2752f;

        /* renamed from: g  reason: collision with root package name */
        float f2753g = CropImageView.DEFAULT_ASPECT_RATIO;

        /* renamed from: h  reason: collision with root package name */
        androidx.core.content.res.d f2754h;

        /* renamed from: i  reason: collision with root package name */
        float f2755i = 1.0f;

        /* renamed from: j  reason: collision with root package name */
        float f2756j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        float f2757k = CropImageView.DEFAULT_ASPECT_RATIO;

        /* renamed from: l  reason: collision with root package name */
        float f2758l = 1.0f;

        /* renamed from: m  reason: collision with root package name */
        float f2759m = CropImageView.DEFAULT_ASPECT_RATIO;

        /* renamed from: n  reason: collision with root package name */
        Paint.Cap f2760n = Paint.Cap.BUTT;

        /* renamed from: o  reason: collision with root package name */
        Paint.Join f2761o = Paint.Join.MITER;

        /* renamed from: p  reason: collision with root package name */
        float f2762p = 4.0f;

        c() {
        }

        c(c cVar) {
            super(cVar);
            this.f2751e = cVar.f2751e;
            this.f2752f = cVar.f2752f;
            this.f2753g = cVar.f2753g;
            this.f2755i = cVar.f2755i;
            this.f2754h = cVar.f2754h;
            this.f2778c = cVar.f2778c;
            this.f2756j = cVar.f2756j;
            this.f2757k = cVar.f2757k;
            this.f2758l = cVar.f2758l;
            this.f2759m = cVar.f2759m;
            this.f2760n = cVar.f2760n;
            this.f2761o = cVar.f2761o;
            this.f2762p = cVar.f2762p;
        }

        private Paint.Cap e(int i5, Paint.Cap cap) {
            return i5 != 0 ? i5 != 1 ? i5 != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        private Paint.Join f(int i5, Paint.Join join) {
            return i5 != 0 ? i5 != 1 ? i5 != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f2751e = null;
            if (l.j(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f2777b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f2776a = androidx.core.graphics.c.d(string2);
                }
                Resources.Theme theme2 = theme;
                this.f2754h = l.e(typedArray, xmlPullParser, theme2, "fillColor", 1, 0);
                this.f2756j = l.f(typedArray, xmlPullParser, "fillAlpha", 12, this.f2756j);
                this.f2760n = e(l.g(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f2760n);
                this.f2761o = f(l.g(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f2761o);
                this.f2762p = l.f(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f2762p);
                this.f2752f = l.e(typedArray, xmlPullParser, theme2, "strokeColor", 3, 0);
                this.f2755i = l.f(typedArray, xmlPullParser, "strokeAlpha", 11, this.f2755i);
                this.f2753g = l.f(typedArray, xmlPullParser, "strokeWidth", 4, this.f2753g);
                this.f2758l = l.f(typedArray, xmlPullParser, "trimPathEnd", 6, this.f2758l);
                this.f2759m = l.f(typedArray, xmlPullParser, "trimPathOffset", 7, this.f2759m);
                this.f2757k = l.f(typedArray, xmlPullParser, "trimPathStart", 5, this.f2757k);
                this.f2778c = l.g(typedArray, xmlPullParser, "fillType", 13, this.f2778c);
            }
        }

        public boolean a() {
            return this.f2754h.i() || this.f2752f.i();
        }

        public boolean b(int[] iArr) {
            return this.f2752f.j(iArr) | this.f2754h.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k5 = l.k(resources, theme, attributeSet, a.f2715c);
            h(k5, xmlPullParser, theme);
            k5.recycle();
        }

        /* access modifiers changed from: package-private */
        public float getFillAlpha() {
            return this.f2756j;
        }

        /* access modifiers changed from: package-private */
        public int getFillColor() {
            return this.f2754h.e();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeAlpha() {
            return this.f2755i;
        }

        /* access modifiers changed from: package-private */
        public int getStrokeColor() {
            return this.f2752f.e();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeWidth() {
            return this.f2753g;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathEnd() {
            return this.f2758l;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathOffset() {
            return this.f2759m;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathStart() {
            return this.f2757k;
        }

        /* access modifiers changed from: package-private */
        public void setFillAlpha(float f5) {
            this.f2756j = f5;
        }

        /* access modifiers changed from: package-private */
        public void setFillColor(int i5) {
            this.f2754h.k(i5);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeAlpha(float f5) {
            this.f2755i = f5;
        }

        /* access modifiers changed from: package-private */
        public void setStrokeColor(int i5) {
            this.f2752f.k(i5);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeWidth(float f5) {
            this.f2753g = f5;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathEnd(float f5) {
            this.f2758l = f5;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathOffset(float f5) {
            this.f2759m = f5;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathStart(float f5) {
            this.f2757k = f5;
        }
    }

    private static class d extends e {

        /* renamed from: a  reason: collision with root package name */
        final Matrix f2763a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<e> f2764b;

        /* renamed from: c  reason: collision with root package name */
        float f2765c;

        /* renamed from: d  reason: collision with root package name */
        private float f2766d;

        /* renamed from: e  reason: collision with root package name */
        private float f2767e;

        /* renamed from: f  reason: collision with root package name */
        private float f2768f;

        /* renamed from: g  reason: collision with root package name */
        private float f2769g;

        /* renamed from: h  reason: collision with root package name */
        private float f2770h;

        /* renamed from: i  reason: collision with root package name */
        private float f2771i;

        /* renamed from: j  reason: collision with root package name */
        final Matrix f2772j;

        /* renamed from: k  reason: collision with root package name */
        int f2773k;

        /* renamed from: l  reason: collision with root package name */
        private int[] f2774l;

        /* renamed from: m  reason: collision with root package name */
        private String f2775m;

        public d() {
            super();
            this.f2763a = new Matrix();
            this.f2764b = new ArrayList<>();
            this.f2765c = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f2766d = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f2767e = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f2768f = 1.0f;
            this.f2769g = 1.0f;
            this.f2770h = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f2771i = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f2772j = new Matrix();
            this.f2775m = null;
        }

        public d(d dVar, m.a<String, Object> aVar) {
            super();
            f fVar;
            this.f2763a = new Matrix();
            this.f2764b = new ArrayList<>();
            this.f2765c = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f2766d = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f2767e = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f2768f = 1.0f;
            this.f2769g = 1.0f;
            this.f2770h = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f2771i = CropImageView.DEFAULT_ASPECT_RATIO;
            Matrix matrix = new Matrix();
            this.f2772j = matrix;
            this.f2775m = null;
            this.f2765c = dVar.f2765c;
            this.f2766d = dVar.f2766d;
            this.f2767e = dVar.f2767e;
            this.f2768f = dVar.f2768f;
            this.f2769g = dVar.f2769g;
            this.f2770h = dVar.f2770h;
            this.f2771i = dVar.f2771i;
            this.f2774l = dVar.f2774l;
            String str = dVar.f2775m;
            this.f2775m = str;
            this.f2773k = dVar.f2773k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f2772j);
            ArrayList<e> arrayList = dVar.f2764b;
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                e eVar = arrayList.get(i5);
                if (eVar instanceof d) {
                    this.f2764b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        fVar = new c((c) eVar);
                    } else if (eVar instanceof b) {
                        fVar = new b((b) eVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f2764b.add(fVar);
                    String str2 = fVar.f2777b;
                    if (str2 != null) {
                        aVar.put(str2, fVar);
                    }
                }
            }
        }

        private void d() {
            this.f2772j.reset();
            this.f2772j.postTranslate(-this.f2766d, -this.f2767e);
            this.f2772j.postScale(this.f2768f, this.f2769g);
            this.f2772j.postRotate(this.f2765c, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
            this.f2772j.postTranslate(this.f2770h + this.f2766d, this.f2771i + this.f2767e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f2774l = null;
            this.f2765c = l.f(typedArray, xmlPullParser, "rotation", 5, this.f2765c);
            this.f2766d = typedArray.getFloat(1, this.f2766d);
            this.f2767e = typedArray.getFloat(2, this.f2767e);
            this.f2768f = l.f(typedArray, xmlPullParser, "scaleX", 3, this.f2768f);
            this.f2769g = l.f(typedArray, xmlPullParser, "scaleY", 4, this.f2769g);
            this.f2770h = l.f(typedArray, xmlPullParser, "translateX", 6, this.f2770h);
            this.f2771i = l.f(typedArray, xmlPullParser, "translateY", 7, this.f2771i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f2775m = string;
            }
            d();
        }

        public boolean a() {
            for (int i5 = 0; i5 < this.f2764b.size(); i5++) {
                if (this.f2764b.get(i5).a()) {
                    return true;
                }
            }
            return false;
        }

        public boolean b(int[] iArr) {
            boolean z4 = false;
            for (int i5 = 0; i5 < this.f2764b.size(); i5++) {
                z4 |= this.f2764b.get(i5).b(iArr);
            }
            return z4;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k5 = l.k(resources, theme, attributeSet, a.f2714b);
            e(k5, xmlPullParser);
            k5.recycle();
        }

        public String getGroupName() {
            return this.f2775m;
        }

        public Matrix getLocalMatrix() {
            return this.f2772j;
        }

        public float getPivotX() {
            return this.f2766d;
        }

        public float getPivotY() {
            return this.f2767e;
        }

        public float getRotation() {
            return this.f2765c;
        }

        public float getScaleX() {
            return this.f2768f;
        }

        public float getScaleY() {
            return this.f2769g;
        }

        public float getTranslateX() {
            return this.f2770h;
        }

        public float getTranslateY() {
            return this.f2771i;
        }

        public void setPivotX(float f5) {
            if (f5 != this.f2766d) {
                this.f2766d = f5;
                d();
            }
        }

        public void setPivotY(float f5) {
            if (f5 != this.f2767e) {
                this.f2767e = f5;
                d();
            }
        }

        public void setRotation(float f5) {
            if (f5 != this.f2765c) {
                this.f2765c = f5;
                d();
            }
        }

        public void setScaleX(float f5) {
            if (f5 != this.f2768f) {
                this.f2768f = f5;
                d();
            }
        }

        public void setScaleY(float f5) {
            if (f5 != this.f2769g) {
                this.f2769g = f5;
                d();
            }
        }

        public void setTranslateX(float f5) {
            if (f5 != this.f2770h) {
                this.f2770h = f5;
                d();
            }
        }

        public void setTranslateY(float f5) {
            if (f5 != this.f2771i) {
                this.f2771i = f5;
                d();
            }
        }
    }

    private static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    private static abstract class f extends e {

        /* renamed from: a  reason: collision with root package name */
        protected c.b[] f2776a = null;

        /* renamed from: b  reason: collision with root package name */
        String f2777b;

        /* renamed from: c  reason: collision with root package name */
        int f2778c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f2779d;

        public f() {
            super();
        }

        public f(f fVar) {
            super();
            this.f2777b = fVar.f2777b;
            this.f2779d = fVar.f2779d;
            this.f2776a = androidx.core.graphics.c.f(fVar.f2776a);
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            c.b[] bVarArr = this.f2776a;
            if (bVarArr != null) {
                c.b.e(bVarArr, path);
            }
        }

        public c.b[] getPathData() {
            return this.f2776a;
        }

        public String getPathName() {
            return this.f2777b;
        }

        public void setPathData(c.b[] bVarArr) {
            if (!androidx.core.graphics.c.b(this.f2776a, bVarArr)) {
                this.f2776a = androidx.core.graphics.c.f(bVarArr);
            } else {
                androidx.core.graphics.c.j(this.f2776a, bVarArr);
            }
        }
    }

    /* renamed from: androidx.vectordrawable.graphics.drawable.g$g  reason: collision with other inner class name */
    private static class C0049g {

        /* renamed from: q  reason: collision with root package name */
        private static final Matrix f2780q = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        private final Path f2781a;

        /* renamed from: b  reason: collision with root package name */
        private final Path f2782b;

        /* renamed from: c  reason: collision with root package name */
        private final Matrix f2783c;

        /* renamed from: d  reason: collision with root package name */
        Paint f2784d;

        /* renamed from: e  reason: collision with root package name */
        Paint f2785e;

        /* renamed from: f  reason: collision with root package name */
        private PathMeasure f2786f;

        /* renamed from: g  reason: collision with root package name */
        private int f2787g;

        /* renamed from: h  reason: collision with root package name */
        final d f2788h;

        /* renamed from: i  reason: collision with root package name */
        float f2789i;

        /* renamed from: j  reason: collision with root package name */
        float f2790j;

        /* renamed from: k  reason: collision with root package name */
        float f2791k;

        /* renamed from: l  reason: collision with root package name */
        float f2792l;

        /* renamed from: m  reason: collision with root package name */
        int f2793m;

        /* renamed from: n  reason: collision with root package name */
        String f2794n;

        /* renamed from: o  reason: collision with root package name */
        Boolean f2795o;

        /* renamed from: p  reason: collision with root package name */
        final m.a<String, Object> f2796p;

        public C0049g() {
            this.f2783c = new Matrix();
            this.f2789i = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f2790j = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f2791k = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f2792l = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f2793m = 255;
            this.f2794n = null;
            this.f2795o = null;
            this.f2796p = new m.a<>();
            this.f2788h = new d();
            this.f2781a = new Path();
            this.f2782b = new Path();
        }

        public C0049g(C0049g gVar) {
            this.f2783c = new Matrix();
            this.f2789i = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f2790j = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f2791k = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f2792l = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f2793m = 255;
            this.f2794n = null;
            this.f2795o = null;
            m.a<String, Object> aVar = new m.a<>();
            this.f2796p = aVar;
            this.f2788h = new d(gVar.f2788h, aVar);
            this.f2781a = new Path(gVar.f2781a);
            this.f2782b = new Path(gVar.f2782b);
            this.f2789i = gVar.f2789i;
            this.f2790j = gVar.f2790j;
            this.f2791k = gVar.f2791k;
            this.f2792l = gVar.f2792l;
            this.f2787g = gVar.f2787g;
            this.f2793m = gVar.f2793m;
            this.f2794n = gVar.f2794n;
            String str = gVar.f2794n;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f2795o = gVar.f2795o;
        }

        private static float a(float f5, float f6, float f7, float f8) {
            return (f5 * f8) - (f6 * f7);
        }

        private void c(d dVar, Matrix matrix, Canvas canvas, int i5, int i6, ColorFilter colorFilter) {
            dVar.f2763a.set(matrix);
            dVar.f2763a.preConcat(dVar.f2772j);
            canvas.save();
            for (int i7 = 0; i7 < dVar.f2764b.size(); i7++) {
                e eVar = dVar.f2764b.get(i7);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f2763a, canvas, i5, i6, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i5, i6, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(d dVar, f fVar, Canvas canvas, int i5, int i6, ColorFilter colorFilter) {
            float f5 = ((float) i5) / this.f2791k;
            float f6 = ((float) i6) / this.f2792l;
            float min = Math.min(f5, f6);
            Matrix matrix = dVar.f2763a;
            this.f2783c.set(matrix);
            this.f2783c.postScale(f5, f6);
            float e5 = e(matrix);
            if (e5 != CropImageView.DEFAULT_ASPECT_RATIO) {
                fVar.d(this.f2781a);
                Path path = this.f2781a;
                this.f2782b.reset();
                if (fVar.c()) {
                    this.f2782b.setFillType(fVar.f2778c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    this.f2782b.addPath(path, this.f2783c);
                    canvas.clipPath(this.f2782b);
                    return;
                }
                c cVar = (c) fVar;
                float f7 = cVar.f2757k;
                if (!(f7 == CropImageView.DEFAULT_ASPECT_RATIO && cVar.f2758l == 1.0f)) {
                    float f8 = cVar.f2759m;
                    float f9 = (f7 + f8) % 1.0f;
                    float f10 = (cVar.f2758l + f8) % 1.0f;
                    if (this.f2786f == null) {
                        this.f2786f = new PathMeasure();
                    }
                    this.f2786f.setPath(this.f2781a, false);
                    float length = this.f2786f.getLength();
                    float f11 = f9 * length;
                    float f12 = f10 * length;
                    path.reset();
                    if (f11 > f12) {
                        this.f2786f.getSegment(f11, length, path, true);
                        this.f2786f.getSegment(CropImageView.DEFAULT_ASPECT_RATIO, f12, path, true);
                    } else {
                        this.f2786f.getSegment(f11, f12, path, true);
                    }
                    path.rLineTo(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                }
                this.f2782b.addPath(path, this.f2783c);
                if (cVar.f2754h.l()) {
                    androidx.core.content.res.d dVar2 = cVar.f2754h;
                    if (this.f2785e == null) {
                        Paint paint = new Paint(1);
                        this.f2785e = paint;
                        paint.setStyle(Paint.Style.FILL);
                    }
                    Paint paint2 = this.f2785e;
                    if (dVar2.h()) {
                        Shader f13 = dVar2.f();
                        f13.setLocalMatrix(this.f2783c);
                        paint2.setShader(f13);
                        paint2.setAlpha(Math.round(cVar.f2756j * 255.0f));
                    } else {
                        paint2.setShader((Shader) null);
                        paint2.setAlpha(255);
                        paint2.setColor(g.a(dVar2.e(), cVar.f2756j));
                    }
                    paint2.setColorFilter(colorFilter);
                    this.f2782b.setFillType(cVar.f2778c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    canvas.drawPath(this.f2782b, paint2);
                }
                if (cVar.f2752f.l()) {
                    androidx.core.content.res.d dVar3 = cVar.f2752f;
                    if (this.f2784d == null) {
                        Paint paint3 = new Paint(1);
                        this.f2784d = paint3;
                        paint3.setStyle(Paint.Style.STROKE);
                    }
                    Paint paint4 = this.f2784d;
                    Paint.Join join = cVar.f2761o;
                    if (join != null) {
                        paint4.setStrokeJoin(join);
                    }
                    Paint.Cap cap = cVar.f2760n;
                    if (cap != null) {
                        paint4.setStrokeCap(cap);
                    }
                    paint4.setStrokeMiter(cVar.f2762p);
                    if (dVar3.h()) {
                        Shader f14 = dVar3.f();
                        f14.setLocalMatrix(this.f2783c);
                        paint4.setShader(f14);
                        paint4.setAlpha(Math.round(cVar.f2755i * 255.0f));
                    } else {
                        paint4.setShader((Shader) null);
                        paint4.setAlpha(255);
                        paint4.setColor(g.a(dVar3.e(), cVar.f2755i));
                    }
                    paint4.setColorFilter(colorFilter);
                    paint4.setStrokeWidth(cVar.f2753g * min * e5);
                    canvas.drawPath(this.f2782b, paint4);
                }
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO};
            matrix.mapVectors(fArr);
            float a5 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot((double) fArr[0], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
            return max > CropImageView.DEFAULT_ASPECT_RATIO ? Math.abs(a5) / max : CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public void b(Canvas canvas, int i5, int i6, ColorFilter colorFilter) {
            c(this.f2788h, f2780q, canvas, i5, i6, colorFilter);
        }

        public boolean f() {
            if (this.f2795o == null) {
                this.f2795o = Boolean.valueOf(this.f2788h.a());
            }
            return this.f2795o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f2788h.b(iArr);
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.f2793m;
        }

        public void setAlpha(float f5) {
            setRootAlpha((int) (f5 * 255.0f));
        }

        public void setRootAlpha(int i5) {
            this.f2793m = i5;
        }
    }

    private static class h extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f2797a;

        /* renamed from: b  reason: collision with root package name */
        C0049g f2798b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f2799c;

        /* renamed from: d  reason: collision with root package name */
        PorterDuff.Mode f2800d;

        /* renamed from: e  reason: collision with root package name */
        boolean f2801e;

        /* renamed from: f  reason: collision with root package name */
        Bitmap f2802f;

        /* renamed from: g  reason: collision with root package name */
        ColorStateList f2803g;

        /* renamed from: h  reason: collision with root package name */
        PorterDuff.Mode f2804h;

        /* renamed from: i  reason: collision with root package name */
        int f2805i;

        /* renamed from: j  reason: collision with root package name */
        boolean f2806j;

        /* renamed from: k  reason: collision with root package name */
        boolean f2807k;

        /* renamed from: l  reason: collision with root package name */
        Paint f2808l;

        public h() {
            this.f2799c = null;
            this.f2800d = g.f2741o;
            this.f2798b = new C0049g();
        }

        public h(h hVar) {
            this.f2799c = null;
            this.f2800d = g.f2741o;
            if (hVar != null) {
                this.f2797a = hVar.f2797a;
                C0049g gVar = new C0049g(hVar.f2798b);
                this.f2798b = gVar;
                if (hVar.f2798b.f2785e != null) {
                    gVar.f2785e = new Paint(hVar.f2798b.f2785e);
                }
                if (hVar.f2798b.f2784d != null) {
                    this.f2798b.f2784d = new Paint(hVar.f2798b.f2784d);
                }
                this.f2799c = hVar.f2799c;
                this.f2800d = hVar.f2800d;
                this.f2801e = hVar.f2801e;
            }
        }

        public boolean a(int i5, int i6) {
            return i5 == this.f2802f.getWidth() && i6 == this.f2802f.getHeight();
        }

        public boolean b() {
            return !this.f2807k && this.f2803g == this.f2799c && this.f2804h == this.f2800d && this.f2806j == this.f2801e && this.f2805i == this.f2798b.getRootAlpha();
        }

        public void c(int i5, int i6) {
            if (this.f2802f == null || !a(i5, i6)) {
                this.f2802f = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
                this.f2807k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f2802f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f2808l == null) {
                Paint paint = new Paint();
                this.f2808l = paint;
                paint.setFilterBitmap(true);
            }
            this.f2808l.setAlpha(this.f2798b.getRootAlpha());
            this.f2808l.setColorFilter(colorFilter);
            return this.f2808l;
        }

        public boolean f() {
            return this.f2798b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f2798b.f();
        }

        public int getChangingConfigurations() {
            return this.f2797a;
        }

        public boolean h(int[] iArr) {
            boolean g5 = this.f2798b.g(iArr);
            this.f2807k |= g5;
            return g5;
        }

        public void i() {
            this.f2803g = this.f2799c;
            this.f2804h = this.f2800d;
            this.f2805i = this.f2798b.getRootAlpha();
            this.f2806j = this.f2801e;
            this.f2807k = false;
        }

        public void j(int i5, int i6) {
            this.f2802f.eraseColor(0);
            this.f2798b.b(new Canvas(this.f2802f), i5, i6, (ColorFilter) null);
        }

        public Drawable newDrawable() {
            return new g(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new g(this);
        }
    }

    private static class i extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f2809a;

        public i(Drawable.ConstantState constantState) {
            this.f2809a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f2809a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f2809a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            g gVar = new g();
            gVar.f2740e = (VectorDrawable) this.f2809a.newDrawable();
            return gVar;
        }

        public Drawable newDrawable(Resources resources) {
            g gVar = new g();
            gVar.f2740e = (VectorDrawable) this.f2809a.newDrawable(resources);
            return gVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            g gVar = new g();
            gVar.f2740e = (VectorDrawable) this.f2809a.newDrawable(resources, theme);
            return gVar;
        }
    }

    g() {
        this.f2746j = true;
        this.f2748l = new float[9];
        this.f2749m = new Matrix();
        this.f2750n = new Rect();
        this.f2742f = new h();
    }

    g(h hVar) {
        this.f2746j = true;
        this.f2748l = new float[9];
        this.f2749m = new Matrix();
        this.f2750n = new Rect();
        this.f2742f = hVar;
        this.f2743g = j(this.f2743g, hVar.f2799c, hVar.f2800d);
    }

    static int a(int i5, float f5) {
        return (i5 & 16777215) | (((int) (((float) Color.alpha(i5)) * f5)) << 24);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038 A[Catch:{ IOException | XmlPullParserException -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d A[Catch:{ IOException | XmlPullParserException -> 0x0045 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.vectordrawable.graphics.drawable.g b(android.content.res.Resources r6, int r7, android.content.res.Resources.Theme r8) {
        /*
            java.lang.String r0 = "parser error"
            java.lang.String r1 = "VectorDrawableCompat"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0023
            androidx.vectordrawable.graphics.drawable.g r0 = new androidx.vectordrawable.graphics.drawable.g
            r0.<init>()
            android.graphics.drawable.Drawable r6 = androidx.core.content.res.h.a(r6, r7, r8)
            r0.f2740e = r6
            androidx.vectordrawable.graphics.drawable.g$i r6 = new androidx.vectordrawable.graphics.drawable.g$i
            android.graphics.drawable.Drawable r7 = r0.f2740e
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r6.<init>(r7)
            r0.f2747k = r6
            return r0
        L_0x0023:
            android.content.res.XmlResourceParser r7 = r6.getXml(r7)     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0045 }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0045 }
        L_0x002b:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0045 }
            r4 = 2
            if (r3 == r4) goto L_0x0036
            r5 = 1
            if (r3 == r5) goto L_0x0036
            goto L_0x002b
        L_0x0036:
            if (r3 != r4) goto L_0x003d
            androidx.vectordrawable.graphics.drawable.g r6 = c(r6, r7, r2, r8)     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0045 }
            return r6
        L_0x003d:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0045 }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0045 }
            throw r6     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0045 }
        L_0x0045:
            r6 = move-exception
            goto L_0x0048
        L_0x0047:
            r6 = move-exception
        L_0x0048:
            android.util.Log.e(r1, r0, r6)
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.g.b(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.vectordrawable.graphics.drawable.g");
    }

    public static g c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        g gVar = new g();
        gVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return gVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: androidx.vectordrawable.graphics.drawable.g$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: androidx.vectordrawable.graphics.drawable.g$c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: androidx.vectordrawable.graphics.drawable.g$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: androidx.vectordrawable.graphics.drawable.g$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: androidx.vectordrawable.graphics.drawable.g$b} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e(android.content.res.Resources r11, org.xmlpull.v1.XmlPullParser r12, android.util.AttributeSet r13, android.content.res.Resources.Theme r14) {
        /*
            r10 = this;
            androidx.vectordrawable.graphics.drawable.g$h r0 = r10.f2742f
            androidx.vectordrawable.graphics.drawable.g$g r1 = r0.f2798b
            java.util.ArrayDeque r2 = new java.util.ArrayDeque
            r2.<init>()
            androidx.vectordrawable.graphics.drawable.g$d r3 = r1.f2788h
            r2.push(r3)
            int r3 = r12.getEventType()
            int r4 = r12.getDepth()
            r5 = 1
            int r4 = r4 + r5
            r6 = r5
        L_0x0019:
            if (r3 == r5) goto L_0x00c4
            int r7 = r12.getDepth()
            r8 = 3
            if (r7 >= r4) goto L_0x0024
            if (r3 == r8) goto L_0x00c4
        L_0x0024:
            r7 = 2
            java.lang.String r9 = "group"
            if (r3 != r7) goto L_0x00af
            java.lang.String r3 = r12.getName()
            java.lang.Object r7 = r2.peek()
            androidx.vectordrawable.graphics.drawable.g$d r7 = (androidx.vectordrawable.graphics.drawable.g.d) r7
            java.lang.String r8 = "path"
            boolean r8 = r8.equals(r3)
            if (r8 == 0) goto L_0x0059
            androidx.vectordrawable.graphics.drawable.g$c r3 = new androidx.vectordrawable.graphics.drawable.g$c
            r3.<init>()
            r3.g(r11, r13, r14, r12)
            java.util.ArrayList<androidx.vectordrawable.graphics.drawable.g$e> r6 = r7.f2764b
            r6.add(r3)
            java.lang.String r6 = r3.getPathName()
            if (r6 == 0) goto L_0x0057
            m.a<java.lang.String, java.lang.Object> r6 = r1.f2796p
            java.lang.String r7 = r3.getPathName()
            r6.put(r7, r3)
        L_0x0057:
            r6 = 0
            goto L_0x007d
        L_0x0059:
            java.lang.String r8 = "clip-path"
            boolean r8 = r8.equals(r3)
            if (r8 == 0) goto L_0x0085
            androidx.vectordrawable.graphics.drawable.g$b r3 = new androidx.vectordrawable.graphics.drawable.g$b
            r3.<init>()
            r3.e(r11, r13, r14, r12)
            java.util.ArrayList<androidx.vectordrawable.graphics.drawable.g$e> r7 = r7.f2764b
            r7.add(r3)
            java.lang.String r7 = r3.getPathName()
            if (r7 == 0) goto L_0x007d
            m.a<java.lang.String, java.lang.Object> r7 = r1.f2796p
            java.lang.String r8 = r3.getPathName()
            r7.put(r8, r3)
        L_0x007d:
            int r7 = r0.f2797a
            int r3 = r3.f2779d
        L_0x0081:
            r3 = r3 | r7
            r0.f2797a = r3
            goto L_0x00be
        L_0x0085:
            boolean r3 = r9.equals(r3)
            if (r3 == 0) goto L_0x00be
            androidx.vectordrawable.graphics.drawable.g$d r3 = new androidx.vectordrawable.graphics.drawable.g$d
            r3.<init>()
            r3.c(r11, r13, r14, r12)
            java.util.ArrayList<androidx.vectordrawable.graphics.drawable.g$e> r7 = r7.f2764b
            r7.add(r3)
            r2.push(r3)
            java.lang.String r7 = r3.getGroupName()
            if (r7 == 0) goto L_0x00aa
            m.a<java.lang.String, java.lang.Object> r7 = r1.f2796p
            java.lang.String r8 = r3.getGroupName()
            r7.put(r8, r3)
        L_0x00aa:
            int r7 = r0.f2797a
            int r3 = r3.f2773k
            goto L_0x0081
        L_0x00af:
            if (r3 != r8) goto L_0x00be
            java.lang.String r3 = r12.getName()
            boolean r3 = r9.equals(r3)
            if (r3 == 0) goto L_0x00be
            r2.pop()
        L_0x00be:
            int r3 = r12.next()
            goto L_0x0019
        L_0x00c4:
            if (r6 != 0) goto L_0x00c7
            return
        L_0x00c7:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r12 = "no path defined"
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.g.e(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    private boolean f() {
        return isAutoMirrored() && androidx.core.graphics.drawable.a.e(this) == 1;
    }

    private static PorterDuff.Mode g(int i5, PorterDuff.Mode mode) {
        if (i5 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i5 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i5 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i5) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
        h hVar = this.f2742f;
        C0049g gVar = hVar.f2798b;
        hVar.f2800d = g(l.g(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList c5 = l.c(typedArray, xmlPullParser, theme, "tint", 1);
        if (c5 != null) {
            hVar.f2799c = c5;
        }
        hVar.f2801e = l.a(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f2801e);
        gVar.f2791k = l.f(typedArray, xmlPullParser, "viewportWidth", 7, gVar.f2791k);
        float f5 = l.f(typedArray, xmlPullParser, "viewportHeight", 8, gVar.f2792l);
        gVar.f2792l = f5;
        if (gVar.f2791k <= CropImageView.DEFAULT_ASPECT_RATIO) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (f5 > CropImageView.DEFAULT_ASPECT_RATIO) {
            gVar.f2789i = typedArray.getDimension(3, gVar.f2789i);
            float dimension = typedArray.getDimension(2, gVar.f2790j);
            gVar.f2790j = dimension;
            if (gVar.f2789i <= CropImageView.DEFAULT_ASPECT_RATIO) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension > CropImageView.DEFAULT_ASPECT_RATIO) {
                gVar.setAlpha(l.f(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    gVar.f2794n = string;
                    gVar.f2796p.put(string, gVar);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f2740e;
        if (drawable == null) {
            return false;
        }
        androidx.core.graphics.drawable.a.b(drawable);
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    /* access modifiers changed from: package-private */
    public Object d(String str) {
        return this.f2742f.f2798b.f2796p.get(str);
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f2750n);
        if (this.f2750n.width() > 0 && this.f2750n.height() > 0) {
            ColorFilter colorFilter = this.f2744h;
            if (colorFilter == null) {
                colorFilter = this.f2743g;
            }
            canvas.getMatrix(this.f2749m);
            this.f2749m.getValues(this.f2748l);
            float abs = Math.abs(this.f2748l[0]);
            float abs2 = Math.abs(this.f2748l[4]);
            float abs3 = Math.abs(this.f2748l[1]);
            float abs4 = Math.abs(this.f2748l[3]);
            if (!(abs3 == CropImageView.DEFAULT_ASPECT_RATIO && abs4 == CropImageView.DEFAULT_ASPECT_RATIO)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.f2750n.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.f2750n.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.f2750n;
                canvas.translate((float) rect.left, (float) rect.top);
                if (f()) {
                    canvas.translate((float) this.f2750n.width(), CropImageView.DEFAULT_ASPECT_RATIO);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f2750n.offsetTo(0, 0);
                this.f2742f.c(min, min2);
                if (!this.f2746j) {
                    this.f2742f.j(min, min2);
                } else if (!this.f2742f.b()) {
                    this.f2742f.j(min, min2);
                    this.f2742f.i();
                }
                this.f2742f.d(canvas, colorFilter, this.f2750n);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f2740e;
        return drawable != null ? androidx.core.graphics.drawable.a.c(drawable) : this.f2742f.f2798b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f2740e;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f2742f.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f2740e;
        return drawable != null ? androidx.core.graphics.drawable.a.d(drawable) : this.f2744h;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f2740e != null && Build.VERSION.SDK_INT >= 24) {
            return new i(this.f2740e.getConstantState());
        }
        this.f2742f.f2797a = getChangingConfigurations();
        return this.f2742f;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f2740e;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f2742f.f2798b.f2790j;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f2740e;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f2742f.f2798b.f2789i;
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    /* access modifiers changed from: package-private */
    public void h(boolean z4) {
        this.f2746j = z4;
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.f(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f2742f;
        hVar.f2798b = new C0049g();
        TypedArray k5 = l.k(resources, theme, attributeSet, a.f2713a);
        i(k5, xmlPullParser, theme);
        k5.recycle();
        hVar.f2797a = getChangingConfigurations();
        hVar.f2807k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.f2743g = j(this.f2743g, hVar.f2799c, hVar.f2800d);
    }

    public void invalidateSelf() {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f2740e;
        return drawable != null ? androidx.core.graphics.drawable.a.g(drawable) : this.f2742f.f2801e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        r0 = r1.f2742f.f2799c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        r0 = r1.f2742f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            android.graphics.drawable.Drawable r0 = r1.f2740e
            if (r0 == 0) goto L_0x0009
            boolean r0 = r0.isStateful()
            return r0
        L_0x0009:
            boolean r0 = super.isStateful()
            if (r0 != 0) goto L_0x0028
            androidx.vectordrawable.graphics.drawable.g$h r0 = r1.f2742f
            if (r0 == 0) goto L_0x0026
            boolean r0 = r0.g()
            if (r0 != 0) goto L_0x0028
            androidx.vectordrawable.graphics.drawable.g$h r0 = r1.f2742f
            android.content.res.ColorStateList r0 = r0.f2799c
            if (r0 == 0) goto L_0x0026
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r0 = 0
            goto L_0x0029
        L_0x0028:
            r0 = 1
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.g.isStateful():boolean");
    }

    /* access modifiers changed from: package-private */
    public PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f2745i && super.mutate() == this) {
            this.f2742f = new h(this.f2742f);
            this.f2745i = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z4 = false;
        h hVar = this.f2742f;
        ColorStateList colorStateList = hVar.f2799c;
        if (!(colorStateList == null || (mode = hVar.f2800d) == null)) {
            this.f2743g = j(this.f2743g, colorStateList, mode);
            invalidateSelf();
            z4 = true;
        }
        if (!hVar.g() || !hVar.h(iArr)) {
            return z4;
        }
        invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j5) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j5);
        } else {
            super.scheduleSelf(runnable, j5);
        }
    }

    public void setAlpha(int i5) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            drawable.setAlpha(i5);
        } else if (this.f2742f.f2798b.getRootAlpha() != i5) {
            this.f2742f.f2798b.setRootAlpha(i5);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z4) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.i(drawable, z4);
        } else {
            this.f2742f.f2801e = z4;
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i5) {
        super.setChangingConfigurations(i5);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i5, PorterDuff.Mode mode) {
        super.setColorFilter(i5, mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f2744h = colorFilter;
        invalidateSelf();
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z4) {
        super.setFilterBitmap(z4);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f5, float f6) {
        super.setHotspot(f5, f6);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i5, int i6, int i7, int i8) {
        super.setHotspotBounds(i5, i6, i7, i8);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i5) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.m(drawable, i5);
        } else {
            setTintList(ColorStateList.valueOf(i5));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, colorStateList);
            return;
        }
        h hVar = this.f2742f;
        if (hVar.f2799c != colorStateList) {
            hVar.f2799c = colorStateList;
            this.f2743g = j(this.f2743g, colorStateList, hVar.f2800d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, mode);
            return;
        }
        h hVar = this.f2742f;
        if (hVar.f2800d != mode) {
            hVar.f2800d = mode;
            this.f2743g = j(this.f2743g, hVar.f2799c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z4, boolean z5) {
        Drawable drawable = this.f2740e;
        return drawable != null ? drawable.setVisible(z4, z5) : super.setVisible(z4, z5);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
