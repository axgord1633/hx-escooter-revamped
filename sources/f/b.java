package f;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;

class b extends Drawable implements Drawable.Callback {

    /* renamed from: e  reason: collision with root package name */
    private d f4554e;

    /* renamed from: f  reason: collision with root package name */
    private Rect f4555f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f4556g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f4557h;

    /* renamed from: i  reason: collision with root package name */
    private int f4558i = 255;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4559j;

    /* renamed from: k  reason: collision with root package name */
    private int f4560k = -1;

    /* renamed from: l  reason: collision with root package name */
    private boolean f4561l;

    /* renamed from: m  reason: collision with root package name */
    private Runnable f4562m;

    /* renamed from: n  reason: collision with root package name */
    private long f4563n;

    /* renamed from: o  reason: collision with root package name */
    private long f4564o;

    /* renamed from: p  reason: collision with root package name */
    private c f4565p;

    class a implements Runnable {
        a() {
        }

        public void run() {
            b.this.a(true);
            b.this.invalidateSelf();
        }
    }

    /* renamed from: f.b$b  reason: collision with other inner class name */
    private static class C0077b {
        public static boolean a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void b(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources c(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    static class c implements Drawable.Callback {

        /* renamed from: e  reason: collision with root package name */
        private Drawable.Callback f4567e;

        c() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f4567e;
            this.f4567e = null;
            return callback;
        }

        public c b(Drawable.Callback callback) {
            this.f4567e = callback;
            return this;
        }

        public void invalidateDrawable(Drawable drawable) {
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
            Drawable.Callback callback = this.f4567e;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j5);
            }
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f4567e;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    static abstract class d extends Drawable.ConstantState {
        int A = 0;
        int B = 0;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        PorterDuff.Mode G;
        boolean H;
        boolean I;

        /* renamed from: a  reason: collision with root package name */
        final b f4568a;

        /* renamed from: b  reason: collision with root package name */
        Resources f4569b;

        /* renamed from: c  reason: collision with root package name */
        int f4570c;

        /* renamed from: d  reason: collision with root package name */
        int f4571d;

        /* renamed from: e  reason: collision with root package name */
        int f4572e;

        /* renamed from: f  reason: collision with root package name */
        SparseArray<Drawable.ConstantState> f4573f;

        /* renamed from: g  reason: collision with root package name */
        Drawable[] f4574g;

        /* renamed from: h  reason: collision with root package name */
        int f4575h;

        /* renamed from: i  reason: collision with root package name */
        boolean f4576i = false;

        /* renamed from: j  reason: collision with root package name */
        boolean f4577j;

        /* renamed from: k  reason: collision with root package name */
        Rect f4578k;

        /* renamed from: l  reason: collision with root package name */
        boolean f4579l = false;

        /* renamed from: m  reason: collision with root package name */
        boolean f4580m;

        /* renamed from: n  reason: collision with root package name */
        int f4581n;

        /* renamed from: o  reason: collision with root package name */
        int f4582o;

        /* renamed from: p  reason: collision with root package name */
        int f4583p;

        /* renamed from: q  reason: collision with root package name */
        int f4584q;

        /* renamed from: r  reason: collision with root package name */
        boolean f4585r;

        /* renamed from: s  reason: collision with root package name */
        int f4586s;

        /* renamed from: t  reason: collision with root package name */
        boolean f4587t;

        /* renamed from: u  reason: collision with root package name */
        boolean f4588u;

        /* renamed from: v  reason: collision with root package name */
        boolean f4589v;

        /* renamed from: w  reason: collision with root package name */
        boolean f4590w;

        /* renamed from: x  reason: collision with root package name */
        boolean f4591x = true;

        /* renamed from: y  reason: collision with root package name */
        boolean f4592y;

        /* renamed from: z  reason: collision with root package name */
        int f4593z;

        d(d dVar, b bVar, Resources resources) {
            this.f4568a = bVar;
            Rect rect = null;
            this.f4569b = resources != null ? resources : dVar != null ? dVar.f4569b : null;
            int f5 = b.f(resources, dVar != null ? dVar.f4570c : 0);
            this.f4570c = f5;
            if (dVar != null) {
                this.f4571d = dVar.f4571d;
                this.f4572e = dVar.f4572e;
                this.f4589v = true;
                this.f4590w = true;
                this.f4576i = dVar.f4576i;
                this.f4579l = dVar.f4579l;
                this.f4591x = dVar.f4591x;
                this.f4592y = dVar.f4592y;
                this.f4593z = dVar.f4593z;
                this.A = dVar.A;
                this.B = dVar.B;
                this.C = dVar.C;
                this.D = dVar.D;
                this.E = dVar.E;
                this.F = dVar.F;
                this.G = dVar.G;
                this.H = dVar.H;
                this.I = dVar.I;
                if (dVar.f4570c == f5) {
                    if (dVar.f4577j) {
                        this.f4578k = dVar.f4578k != null ? new Rect(dVar.f4578k) : rect;
                        this.f4577j = true;
                    }
                    if (dVar.f4580m) {
                        this.f4581n = dVar.f4581n;
                        this.f4582o = dVar.f4582o;
                        this.f4583p = dVar.f4583p;
                        this.f4584q = dVar.f4584q;
                        this.f4580m = true;
                    }
                }
                if (dVar.f4585r) {
                    this.f4586s = dVar.f4586s;
                    this.f4585r = true;
                }
                if (dVar.f4587t) {
                    this.f4588u = dVar.f4588u;
                    this.f4587t = true;
                }
                Drawable[] drawableArr = dVar.f4574g;
                this.f4574g = new Drawable[drawableArr.length];
                this.f4575h = dVar.f4575h;
                SparseArray<Drawable.ConstantState> sparseArray = dVar.f4573f;
                this.f4573f = sparseArray != null ? sparseArray.clone() : new SparseArray<>(this.f4575h);
                int i5 = this.f4575h;
                for (int i6 = 0; i6 < i5; i6++) {
                    Drawable drawable = drawableArr[i6];
                    if (drawable != null) {
                        Drawable.ConstantState constantState = drawable.getConstantState();
                        if (constantState != null) {
                            this.f4573f.put(i6, constantState);
                        } else {
                            this.f4574g[i6] = drawableArr[i6];
                        }
                    }
                }
                return;
            }
            this.f4574g = new Drawable[10];
            this.f4575h = 0;
        }

        private void e() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f4573f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i5 = 0; i5 < size; i5++) {
                    this.f4574g[this.f4573f.keyAt(i5)] = s(this.f4573f.valueAt(i5).newDrawable(this.f4569b));
                }
                this.f4573f = null;
            }
        }

        private Drawable s(Drawable drawable) {
            androidx.core.graphics.drawable.a.l(drawable, this.f4593z);
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f4568a);
            return mutate;
        }

        public final int a(Drawable drawable) {
            int i5 = this.f4575h;
            if (i5 >= this.f4574g.length) {
                o(i5, i5 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f4568a);
            this.f4574g[i5] = drawable;
            this.f4575h++;
            this.f4572e = drawable.getChangingConfigurations() | this.f4572e;
            p();
            this.f4578k = null;
            this.f4577j = false;
            this.f4580m = false;
            this.f4589v = false;
            return i5;
        }

        /* access modifiers changed from: package-private */
        public final void b(Resources.Theme theme) {
            if (theme != null) {
                e();
                int i5 = this.f4575h;
                Drawable[] drawableArr = this.f4574g;
                for (int i6 = 0; i6 < i5; i6++) {
                    Drawable drawable = drawableArr[i6];
                    if (drawable != null && androidx.core.graphics.drawable.a.b(drawable)) {
                        androidx.core.graphics.drawable.a.a(drawableArr[i6], theme);
                        this.f4572e |= drawableArr[i6].getChangingConfigurations();
                    }
                }
                y(C0077b.c(theme));
            }
        }

        public boolean c() {
            if (this.f4589v) {
                return this.f4590w;
            }
            e();
            this.f4589v = true;
            int i5 = this.f4575h;
            Drawable[] drawableArr = this.f4574g;
            for (int i6 = 0; i6 < i5; i6++) {
                if (drawableArr[i6].getConstantState() == null) {
                    this.f4590w = false;
                    return false;
                }
            }
            this.f4590w = true;
            return true;
        }

        public boolean canApplyTheme() {
            int i5 = this.f4575h;
            Drawable[] drawableArr = this.f4574g;
            for (int i6 = 0; i6 < i5; i6++) {
                Drawable drawable = drawableArr[i6];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f4573f.get(i6);
                    if (constantState != null && C0077b.a(constantState)) {
                        return true;
                    }
                } else if (androidx.core.graphics.drawable.a.b(drawable)) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public void d() {
            this.f4580m = true;
            e();
            int i5 = this.f4575h;
            Drawable[] drawableArr = this.f4574g;
            this.f4582o = -1;
            this.f4581n = -1;
            this.f4584q = 0;
            this.f4583p = 0;
            for (int i6 = 0; i6 < i5; i6++) {
                Drawable drawable = drawableArr[i6];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f4581n) {
                    this.f4581n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f4582o) {
                    this.f4582o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f4583p) {
                    this.f4583p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f4584q) {
                    this.f4584q = minimumHeight;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final int f() {
            return this.f4574g.length;
        }

        public final Drawable g(int i5) {
            int indexOfKey;
            Drawable drawable = this.f4574g[i5];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f4573f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i5)) < 0) {
                return null;
            }
            Drawable s5 = s(this.f4573f.valueAt(indexOfKey).newDrawable(this.f4569b));
            this.f4574g[i5] = s5;
            this.f4573f.removeAt(indexOfKey);
            if (this.f4573f.size() == 0) {
                this.f4573f = null;
            }
            return s5;
        }

        public int getChangingConfigurations() {
            return this.f4571d | this.f4572e;
        }

        public final int h() {
            return this.f4575h;
        }

        public final int i() {
            if (!this.f4580m) {
                d();
            }
            return this.f4582o;
        }

        public final int j() {
            if (!this.f4580m) {
                d();
            }
            return this.f4584q;
        }

        public final int k() {
            if (!this.f4580m) {
                d();
            }
            return this.f4583p;
        }

        public final Rect l() {
            Rect rect = null;
            if (this.f4576i) {
                return null;
            }
            Rect rect2 = this.f4578k;
            if (rect2 != null || this.f4577j) {
                return rect2;
            }
            e();
            Rect rect3 = new Rect();
            int i5 = this.f4575h;
            Drawable[] drawableArr = this.f4574g;
            for (int i6 = 0; i6 < i5; i6++) {
                if (drawableArr[i6].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i7 = rect3.left;
                    if (i7 > rect.left) {
                        rect.left = i7;
                    }
                    int i8 = rect3.top;
                    if (i8 > rect.top) {
                        rect.top = i8;
                    }
                    int i9 = rect3.right;
                    if (i9 > rect.right) {
                        rect.right = i9;
                    }
                    int i10 = rect3.bottom;
                    if (i10 > rect.bottom) {
                        rect.bottom = i10;
                    }
                }
            }
            this.f4577j = true;
            this.f4578k = rect;
            return rect;
        }

        public final int m() {
            if (!this.f4580m) {
                d();
            }
            return this.f4581n;
        }

        public final int n() {
            if (this.f4585r) {
                return this.f4586s;
            }
            e();
            int i5 = this.f4575h;
            Drawable[] drawableArr = this.f4574g;
            int opacity = i5 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i6 = 1; i6 < i5; i6++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i6].getOpacity());
            }
            this.f4586s = opacity;
            this.f4585r = true;
            return opacity;
        }

        public void o(int i5, int i6) {
            Drawable[] drawableArr = new Drawable[i6];
            Drawable[] drawableArr2 = this.f4574g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i5);
            }
            this.f4574g = drawableArr;
        }

        /* access modifiers changed from: package-private */
        public void p() {
            this.f4585r = false;
            this.f4587t = false;
        }

        public final boolean q() {
            return this.f4579l;
        }

        /* access modifiers changed from: package-private */
        public abstract void r();

        public final void t(boolean z4) {
            this.f4579l = z4;
        }

        public final void u(int i5) {
            this.A = i5;
        }

        public final void v(int i5) {
            this.B = i5;
        }

        /* access modifiers changed from: package-private */
        public final boolean w(int i5, int i6) {
            int i7 = this.f4575h;
            Drawable[] drawableArr = this.f4574g;
            boolean z4 = false;
            for (int i8 = 0; i8 < i7; i8++) {
                Drawable drawable = drawableArr[i8];
                if (drawable != null) {
                    boolean l5 = androidx.core.graphics.drawable.a.l(drawable, i5);
                    if (i8 == i6) {
                        z4 = l5;
                    }
                }
            }
            this.f4593z = i5;
            return z4;
        }

        public final void x(boolean z4) {
            this.f4576i = z4;
        }

        /* access modifiers changed from: package-private */
        public final void y(Resources resources) {
            if (resources != null) {
                this.f4569b = resources;
                int f5 = b.f(resources, this.f4570c);
                int i5 = this.f4570c;
                this.f4570c = f5;
                if (i5 != f5) {
                    this.f4580m = false;
                    this.f4577j = false;
                }
            }
        }
    }

    b() {
    }

    private void d(Drawable drawable) {
        if (this.f4565p == null) {
            this.f4565p = new c();
        }
        drawable.setCallback(this.f4565p.b(drawable.getCallback()));
        try {
            if (this.f4554e.A <= 0 && this.f4559j) {
                drawable.setAlpha(this.f4558i);
            }
            d dVar = this.f4554e;
            if (dVar.E) {
                drawable.setColorFilter(dVar.D);
            } else {
                if (dVar.H) {
                    androidx.core.graphics.drawable.a.n(drawable, dVar.F);
                }
                d dVar2 = this.f4554e;
                if (dVar2.I) {
                    androidx.core.graphics.drawable.a.o(drawable, dVar2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f4554e.f4591x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            androidx.core.graphics.drawable.a.l(drawable, androidx.core.graphics.drawable.a.e(this));
            androidx.core.graphics.drawable.a.i(drawable, this.f4554e.C);
            Rect rect = this.f4555f;
            if (rect != null) {
                androidx.core.graphics.drawable.a.k(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f4565p.a());
        }
    }

    private boolean e() {
        return isAutoMirrored() && androidx.core.graphics.drawable.a.e(this) == 1;
    }

    static int f(Resources resources, int i5) {
        if (resources != null) {
            i5 = resources.getDisplayMetrics().densityDpi;
        }
        if (i5 == 0) {
            return 160;
        }
        return i5;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0062 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f4559j = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f4556g
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L_0x0034
            long r9 = r13.f4563n
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L_0x0036
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L_0x0020
            int r9 = r13.f4558i
            r3.setAlpha(r9)
            goto L_0x0034
        L_0x0020:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r9 = (int) r9
            f.b$d r10 = r13.f4554e
            int r10 = r10.A
            int r9 = r9 / r10
            int r9 = 255 - r9
            int r10 = r13.f4558i
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = r0
            goto L_0x0037
        L_0x0034:
            r13.f4563n = r7
        L_0x0036:
            r3 = r6
        L_0x0037:
            android.graphics.drawable.Drawable r9 = r13.f4557h
            if (r9 == 0) goto L_0x005d
            long r10 = r13.f4564o
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L_0x005f
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L_0x004c
            r9.setVisible(r6, r6)
            r0 = 0
            r13.f4557h = r0
            goto L_0x005d
        L_0x004c:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            f.b$d r4 = r13.f4554e
            int r4 = r4.B
            int r3 = r3 / r4
            int r4 = r13.f4558i
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L_0x0060
        L_0x005d:
            r13.f4564o = r7
        L_0x005f:
            r0 = r3
        L_0x0060:
            if (r14 == 0) goto L_0x006c
            if (r0 == 0) goto L_0x006c
            java.lang.Runnable r14 = r13.f4562m
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L_0x006c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f.b.a(boolean):void");
    }

    public void applyTheme(Resources.Theme theme) {
        this.f4554e.b(theme);
    }

    /* access modifiers changed from: package-private */
    public d b() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f4560k;
    }

    public boolean canApplyTheme() {
        return this.f4554e.canApplyTheme();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f4556g;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f4557h;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean g(int r10) {
        /*
            r9 = this;
            int r0 = r9.f4560k
            r1 = 0
            if (r10 != r0) goto L_0x0006
            return r1
        L_0x0006:
            long r2 = android.os.SystemClock.uptimeMillis()
            f.b$d r0 = r9.f4554e
            int r0 = r0.B
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L_0x002e
            android.graphics.drawable.Drawable r0 = r9.f4557h
            if (r0 == 0) goto L_0x001a
            r0.setVisible(r1, r1)
        L_0x001a:
            android.graphics.drawable.Drawable r0 = r9.f4556g
            if (r0 == 0) goto L_0x0029
            r9.f4557h = r0
            f.b$d r0 = r9.f4554e
            int r0 = r0.B
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.f4564o = r0
            goto L_0x0035
        L_0x0029:
            r9.f4557h = r4
            r9.f4564o = r5
            goto L_0x0035
        L_0x002e:
            android.graphics.drawable.Drawable r0 = r9.f4556g
            if (r0 == 0) goto L_0x0035
            r0.setVisible(r1, r1)
        L_0x0035:
            if (r10 < 0) goto L_0x0055
            f.b$d r0 = r9.f4554e
            int r1 = r0.f4575h
            if (r10 >= r1) goto L_0x0055
            android.graphics.drawable.Drawable r0 = r0.g(r10)
            r9.f4556g = r0
            r9.f4560k = r10
            if (r0 == 0) goto L_0x005a
            f.b$d r10 = r9.f4554e
            int r10 = r10.A
            if (r10 <= 0) goto L_0x0051
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f4563n = r2
        L_0x0051:
            r9.d(r0)
            goto L_0x005a
        L_0x0055:
            r9.f4556g = r4
            r10 = -1
            r9.f4560k = r10
        L_0x005a:
            long r0 = r9.f4563n
            int r10 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            r0 = 1
            if (r10 != 0) goto L_0x0067
            long r1 = r9.f4564o
            int r10 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r10 == 0) goto L_0x0079
        L_0x0067:
            java.lang.Runnable r10 = r9.f4562m
            if (r10 != 0) goto L_0x0073
            f.b$a r10 = new f.b$a
            r10.<init>()
            r9.f4562m = r10
            goto L_0x0076
        L_0x0073:
            r9.unscheduleSelf(r10)
        L_0x0076:
            r9.a(r0)
        L_0x0079:
            r9.invalidateSelf()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f.b.g(int):boolean");
    }

    public int getAlpha() {
        return this.f4558i;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f4554e.getChangingConfigurations();
    }

    public final Drawable.ConstantState getConstantState() {
        if (!this.f4554e.c()) {
            return null;
        }
        this.f4554e.f4571d = getChangingConfigurations();
        return this.f4554e;
    }

    public Drawable getCurrent() {
        return this.f4556g;
    }

    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f4555f;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    public int getIntrinsicHeight() {
        if (this.f4554e.q()) {
            return this.f4554e.i();
        }
        Drawable drawable = this.f4556g;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    public int getIntrinsicWidth() {
        if (this.f4554e.q()) {
            return this.f4554e.m();
        }
        Drawable drawable = this.f4556g;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    public int getMinimumHeight() {
        if (this.f4554e.q()) {
            return this.f4554e.j();
        }
        Drawable drawable = this.f4556g;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public int getMinimumWidth() {
        if (this.f4554e.q()) {
            return this.f4554e.k();
        }
        Drawable drawable = this.f4556g;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    public int getOpacity() {
        Drawable drawable = this.f4556g;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f4554e.n();
    }

    public void getOutline(Outline outline) {
        Drawable drawable = this.f4556g;
        if (drawable != null) {
            C0077b.b(drawable, outline);
        }
    }

    public boolean getPadding(Rect rect) {
        boolean z4;
        Rect l5 = this.f4554e.l();
        if (l5 != null) {
            rect.set(l5);
            z4 = (l5.right | ((l5.left | l5.top) | l5.bottom)) != 0;
        } else {
            Drawable drawable = this.f4556g;
            z4 = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (e()) {
            int i5 = rect.left;
            rect.left = rect.right;
            rect.right = i5;
        }
        return z4;
    }

    /* access modifiers changed from: package-private */
    public void h(d dVar) {
        this.f4554e = dVar;
        int i5 = this.f4560k;
        if (i5 >= 0) {
            Drawable g5 = dVar.g(i5);
            this.f4556g = g5;
            if (g5 != null) {
                d(g5);
            }
        }
        this.f4557h = null;
    }

    /* access modifiers changed from: package-private */
    public final void i(Resources resources) {
        this.f4554e.y(resources);
    }

    public void invalidateDrawable(Drawable drawable) {
        d dVar = this.f4554e;
        if (dVar != null) {
            dVar.p();
        }
        if (drawable == this.f4556g && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public boolean isAutoMirrored() {
        return this.f4554e.C;
    }

    public void jumpToCurrentState() {
        boolean z4;
        Drawable drawable = this.f4557h;
        boolean z5 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f4557h = null;
            z4 = true;
        } else {
            z4 = false;
        }
        Drawable drawable2 = this.f4556g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f4559j) {
                this.f4556g.setAlpha(this.f4558i);
            }
        }
        if (this.f4564o != 0) {
            this.f4564o = 0;
            z4 = true;
        }
        if (this.f4563n != 0) {
            this.f4563n = 0;
        } else {
            z5 = z4;
        }
        if (z5) {
            invalidateSelf();
        }
    }

    public Drawable mutate() {
        if (!this.f4561l && super.mutate() == this) {
            d b5 = b();
            b5.r();
            h(b5);
            this.f4561l = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f4557h;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f4556g;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i5) {
        return this.f4554e.w(i5, c());
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i5) {
        Drawable drawable = this.f4557h;
        if (drawable != null) {
            return drawable.setLevel(i5);
        }
        Drawable drawable2 = this.f4556g;
        if (drawable2 != null) {
            return drawable2.setLevel(i5);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f4557h;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f4556g;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        if (drawable == this.f4556g && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j5);
        }
    }

    public void setAlpha(int i5) {
        if (!this.f4559j || this.f4558i != i5) {
            this.f4559j = true;
            this.f4558i = i5;
            Drawable drawable = this.f4556g;
            if (drawable == null) {
                return;
            }
            if (this.f4563n == 0) {
                drawable.setAlpha(i5);
            } else {
                a(false);
            }
        }
    }

    public void setAutoMirrored(boolean z4) {
        d dVar = this.f4554e;
        if (dVar.C != z4) {
            dVar.C = z4;
            Drawable drawable = this.f4556g;
            if (drawable != null) {
                androidx.core.graphics.drawable.a.i(drawable, z4);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        d dVar = this.f4554e;
        dVar.E = true;
        if (dVar.D != colorFilter) {
            dVar.D = colorFilter;
            Drawable drawable = this.f4556g;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setDither(boolean z4) {
        d dVar = this.f4554e;
        if (dVar.f4591x != z4) {
            dVar.f4591x = z4;
            Drawable drawable = this.f4556g;
            if (drawable != null) {
                drawable.setDither(z4);
            }
        }
    }

    public void setHotspot(float f5, float f6) {
        Drawable drawable = this.f4556g;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j(drawable, f5, f6);
        }
    }

    public void setHotspotBounds(int i5, int i6, int i7, int i8) {
        Rect rect = this.f4555f;
        if (rect == null) {
            this.f4555f = new Rect(i5, i6, i7, i8);
        } else {
            rect.set(i5, i6, i7, i8);
        }
        Drawable drawable = this.f4556g;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.k(drawable, i5, i6, i7, i8);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        d dVar = this.f4554e;
        dVar.H = true;
        if (dVar.F != colorStateList) {
            dVar.F = colorStateList;
            androidx.core.graphics.drawable.a.n(this.f4556g, colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        d dVar = this.f4554e;
        dVar.I = true;
        if (dVar.G != mode) {
            dVar.G = mode;
            androidx.core.graphics.drawable.a.o(this.f4556g, mode);
        }
    }

    public boolean setVisible(boolean z4, boolean z5) {
        boolean visible = super.setVisible(z4, z5);
        Drawable drawable = this.f4557h;
        if (drawable != null) {
            drawable.setVisible(z4, z5);
        }
        Drawable drawable2 = this.f4556g;
        if (drawable2 != null) {
            drawable2.setVisible(z4, z5);
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.f4556g && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }
}
