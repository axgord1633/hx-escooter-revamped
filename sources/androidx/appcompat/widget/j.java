package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.widget.a1;
import d.c;
import d.d;
import d.e;

public final class j {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final PorterDuff.Mode f1291b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    private static j f1292c;

    /* renamed from: a  reason: collision with root package name */
    private a1 f1293a;

    class a implements a1.f {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f1294a = {e.R, e.P, e.f4012a};

        /* renamed from: b  reason: collision with root package name */
        private final int[] f1295b = {e.f4026o, e.B, e.f4031t, e.f4027p, e.f4028q, e.f4030s, e.f4029r};

        /* renamed from: c  reason: collision with root package name */
        private final int[] f1296c = {e.O, e.Q, e.f4022k, e.K, e.L, e.M, e.N};

        /* renamed from: d  reason: collision with root package name */
        private final int[] f1297d = {e.f4034w, e.f4020i, e.f4033v};

        /* renamed from: e  reason: collision with root package name */
        private final int[] f1298e = {e.J, e.S};

        /* renamed from: f  reason: collision with root package name */
        private final int[] f1299f = {e.f4014c, e.f4018g, e.f4015d, e.f4019h};

        a() {
        }

        private boolean f(int[] iArr, int i5) {
            for (int i6 : iArr) {
                if (i6 == i5) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList g(Context context) {
            return h(context, 0);
        }

        private ColorStateList h(Context context, int i5) {
            int c5 = f1.c(context, d.a.f3983v);
            int b5 = f1.b(context, d.a.f3981t);
            return new ColorStateList(new int[][]{f1.f1228b, f1.f1231e, f1.f1229c, f1.f1235i}, new int[]{b5, androidx.core.graphics.a.c(c5, i5), androidx.core.graphics.a.c(c5, i5), i5});
        }

        private ColorStateList i(Context context) {
            return h(context, f1.c(context, d.a.f3980s));
        }

        private ColorStateList j(Context context) {
            return h(context, f1.c(context, d.a.f3981t));
        }

        private ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            int i5 = d.a.f3985x;
            ColorStateList e5 = f1.e(context, i5);
            if (e5 == null || !e5.isStateful()) {
                iArr[0] = f1.f1228b;
                iArr2[0] = f1.b(context, i5);
                iArr[1] = f1.f1232f;
                iArr2[1] = f1.c(context, d.a.f3982u);
                iArr[2] = f1.f1235i;
                iArr2[2] = f1.c(context, i5);
            } else {
                int[] iArr3 = f1.f1228b;
                iArr[0] = iArr3;
                iArr2[0] = e5.getColorForState(iArr3, 0);
                iArr[1] = f1.f1232f;
                iArr2[1] = f1.c(context, d.a.f3982u);
                iArr[2] = f1.f1235i;
                iArr2[2] = e5.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        private LayerDrawable l(a1 a1Var, Context context, int i5) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i5);
            Drawable j5 = a1Var.j(context, e.F);
            Drawable j6 = a1Var.j(context, e.G);
            if ((j5 instanceof BitmapDrawable) && j5.getIntrinsicWidth() == dimensionPixelSize && j5.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable2 = (BitmapDrawable) j5;
                bitmapDrawable = new BitmapDrawable(bitmapDrawable2.getBitmap());
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                j5.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                j5.draw(canvas);
                bitmapDrawable2 = new BitmapDrawable(createBitmap);
                bitmapDrawable = new BitmapDrawable(createBitmap);
            }
            bitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
            if ((j6 instanceof BitmapDrawable) && j6.getIntrinsicWidth() == dimensionPixelSize && j6.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) j6;
            } else {
                Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap2);
                j6.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                j6.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(createBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable2, bitmapDrawable3, bitmapDrawable});
            layerDrawable.setId(0, 16908288);
            layerDrawable.setId(1, 16908303);
            layerDrawable.setId(2, 16908301);
            return layerDrawable;
        }

        private void m(Drawable drawable, int i5, PorterDuff.Mode mode) {
            if (o0.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = j.f1291b;
            }
            drawable.setColorFilter(j.e(i5, mode));
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0061 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.j.f1291b
                int[] r1 = r6.f1294a
                boolean r1 = r6.f(r1, r8)
                r2 = 16842801(0x1010031, float:2.3693695E-38)
                r3 = -1
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L_0x0017
                int r2 = d.a.f3984w
            L_0x0014:
                r8 = r3
            L_0x0015:
                r1 = r5
                goto L_0x0044
            L_0x0017:
                int[] r1 = r6.f1296c
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L_0x0022
                int r2 = d.a.f3982u
                goto L_0x0014
            L_0x0022:
                int[] r1 = r6.f1297d
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L_0x002d
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                goto L_0x0014
            L_0x002d:
                int r1 = d.e.f4032u
                if (r8 != r1) goto L_0x003c
                r2 = 16842800(0x1010030, float:2.3693693E-38)
                r8 = 1109603123(0x42233333, float:40.8)
                int r8 = java.lang.Math.round(r8)
                goto L_0x0015
            L_0x003c:
                int r1 = d.e.f4023l
                if (r8 != r1) goto L_0x0041
                goto L_0x0014
            L_0x0041:
                r8 = r3
                r1 = r4
                r2 = r1
            L_0x0044:
                if (r1 == 0) goto L_0x0061
                boolean r1 = androidx.appcompat.widget.o0.a(r9)
                if (r1 == 0) goto L_0x0050
                android.graphics.drawable.Drawable r9 = r9.mutate()
            L_0x0050:
                int r7 = androidx.appcompat.widget.f1.c(r7, r2)
                android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.j.e(r7, r0)
                r9.setColorFilter(r7)
                if (r8 == r3) goto L_0x0060
                r9.setAlpha(r8)
            L_0x0060:
                return r5
            L_0x0061:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.j.a.a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        public PorterDuff.Mode b(int i5) {
            if (i5 == e.H) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        public Drawable c(a1 a1Var, Context context, int i5) {
            int i6;
            if (i5 == e.f4021j) {
                return new LayerDrawable(new Drawable[]{a1Var.j(context, e.f4020i), a1Var.j(context, e.f4022k)});
            }
            if (i5 == e.f4036y) {
                i6 = d.f4005i;
            } else if (i5 == e.f4035x) {
                i6 = d.f4006j;
            } else if (i5 != e.f4037z) {
                return null;
            } else {
                i6 = d.f4007k;
            }
            return l(a1Var, context, i6);
        }

        public ColorStateList d(Context context, int i5) {
            if (i5 == e.f4024m) {
                return e.a.a(context, c.f3993e);
            }
            if (i5 == e.I) {
                return e.a.a(context, c.f3996h);
            }
            if (i5 == e.H) {
                return k(context);
            }
            if (i5 == e.f4017f) {
                return j(context);
            }
            if (i5 == e.f4013b) {
                return g(context);
            }
            if (i5 == e.f4016e) {
                return i(context);
            }
            if (i5 == e.D || i5 == e.E) {
                return e.a.a(context, c.f3995g);
            }
            if (f(this.f1295b, i5)) {
                return f1.e(context, d.a.f3984w);
            }
            if (f(this.f1298e, i5)) {
                return e.a.a(context, c.f3992d);
            }
            if (f(this.f1299f, i5)) {
                return e.a.a(context, c.f3991c);
            }
            if (i5 == e.A) {
                return e.a.a(context, c.f3994f);
            }
            return null;
        }

        public boolean e(Context context, int i5, Drawable drawable) {
            Drawable findDrawableByLayerId;
            int c5;
            if (i5 == e.C) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId2 = layerDrawable.findDrawableByLayerId(16908288);
                int i6 = d.a.f3984w;
                m(findDrawableByLayerId2, f1.c(context, i6), j.f1291b);
                m(layerDrawable.findDrawableByLayerId(16908303), f1.c(context, i6), j.f1291b);
                findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908301);
                c5 = f1.c(context, d.a.f3982u);
            } else if (i5 != e.f4036y && i5 != e.f4035x && i5 != e.f4037z) {
                return false;
            } else {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                m(layerDrawable2.findDrawableByLayerId(16908288), f1.b(context, d.a.f3984w), j.f1291b);
                Drawable findDrawableByLayerId3 = layerDrawable2.findDrawableByLayerId(16908303);
                int i7 = d.a.f3982u;
                m(findDrawableByLayerId3, f1.c(context, i7), j.f1291b);
                findDrawableByLayerId = layerDrawable2.findDrawableByLayerId(16908301);
                c5 = f1.c(context, i7);
            }
            m(findDrawableByLayerId, c5, j.f1291b);
            return true;
        }
    }

    public static synchronized j b() {
        j jVar;
        synchronized (j.class) {
            if (f1292c == null) {
                h();
            }
            jVar = f1292c;
        }
        return jVar;
    }

    public static synchronized PorterDuffColorFilter e(int i5, PorterDuff.Mode mode) {
        PorterDuffColorFilter l5;
        synchronized (j.class) {
            l5 = a1.l(i5, mode);
        }
        return l5;
    }

    public static synchronized void h() {
        synchronized (j.class) {
            if (f1292c == null) {
                j jVar = new j();
                f1292c = jVar;
                jVar.f1293a = a1.h();
                f1292c.f1293a.u(new a());
            }
        }
    }

    static void i(Drawable drawable, i1 i1Var, int[] iArr) {
        a1.w(drawable, i1Var, iArr);
    }

    public synchronized Drawable c(Context context, int i5) {
        return this.f1293a.j(context, i5);
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable d(Context context, int i5, boolean z4) {
        return this.f1293a.k(context, i5, z4);
    }

    /* access modifiers changed from: package-private */
    public synchronized ColorStateList f(Context context, int i5) {
        return this.f1293a.m(context, i5);
    }

    public synchronized void g(Context context) {
        this.f1293a.s(context);
    }
}
