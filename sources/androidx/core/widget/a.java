package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.k0;
import com.yalantis.ucrop.view.CropImageView;

public abstract class a implements View.OnTouchListener {

    /* renamed from: v  reason: collision with root package name */
    private static final int f2023v = ViewConfiguration.getTapTimeout();

    /* renamed from: e  reason: collision with root package name */
    final C0033a f2024e = new C0033a();

    /* renamed from: f  reason: collision with root package name */
    private final Interpolator f2025f = new AccelerateInterpolator();

    /* renamed from: g  reason: collision with root package name */
    final View f2026g;

    /* renamed from: h  reason: collision with root package name */
    private Runnable f2027h;

    /* renamed from: i  reason: collision with root package name */
    private float[] f2028i = {CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO};

    /* renamed from: j  reason: collision with root package name */
    private float[] f2029j = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: k  reason: collision with root package name */
    private int f2030k;

    /* renamed from: l  reason: collision with root package name */
    private int f2031l;

    /* renamed from: m  reason: collision with root package name */
    private float[] f2032m = {CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO};

    /* renamed from: n  reason: collision with root package name */
    private float[] f2033n = {CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO};

    /* renamed from: o  reason: collision with root package name */
    private float[] f2034o = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: p  reason: collision with root package name */
    private boolean f2035p;

    /* renamed from: q  reason: collision with root package name */
    boolean f2036q;

    /* renamed from: r  reason: collision with root package name */
    boolean f2037r;

    /* renamed from: s  reason: collision with root package name */
    boolean f2038s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f2039t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f2040u;

    /* renamed from: androidx.core.widget.a$a  reason: collision with other inner class name */
    private static class C0033a {

        /* renamed from: a  reason: collision with root package name */
        private int f2041a;

        /* renamed from: b  reason: collision with root package name */
        private int f2042b;

        /* renamed from: c  reason: collision with root package name */
        private float f2043c;

        /* renamed from: d  reason: collision with root package name */
        private float f2044d;

        /* renamed from: e  reason: collision with root package name */
        private long f2045e = Long.MIN_VALUE;

        /* renamed from: f  reason: collision with root package name */
        private long f2046f = 0;

        /* renamed from: g  reason: collision with root package name */
        private int f2047g = 0;

        /* renamed from: h  reason: collision with root package name */
        private int f2048h = 0;

        /* renamed from: i  reason: collision with root package name */
        private long f2049i = -1;

        /* renamed from: j  reason: collision with root package name */
        private float f2050j;

        /* renamed from: k  reason: collision with root package name */
        private int f2051k;

        C0033a() {
        }

        private float e(long j5) {
            long j6 = this.f2045e;
            if (j5 < j6) {
                return CropImageView.DEFAULT_ASPECT_RATIO;
            }
            long j7 = this.f2049i;
            if (j7 < 0 || j5 < j7) {
                return a.e(((float) (j5 - j6)) / ((float) this.f2041a), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f) * 0.5f;
            }
            float f5 = this.f2050j;
            return (1.0f - f5) + (f5 * a.e(((float) (j5 - j7)) / ((float) this.f2051k), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
        }

        private float g(float f5) {
            return (-4.0f * f5 * f5) + (f5 * 4.0f);
        }

        public void a() {
            if (this.f2046f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float g5 = g(e(currentAnimationTimeMillis));
                this.f2046f = currentAnimationTimeMillis;
                float f5 = ((float) (currentAnimationTimeMillis - this.f2046f)) * g5;
                this.f2047g = (int) (this.f2043c * f5);
                this.f2048h = (int) (f5 * this.f2044d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int b() {
            return this.f2047g;
        }

        public int c() {
            return this.f2048h;
        }

        public int d() {
            float f5 = this.f2043c;
            return (int) (f5 / Math.abs(f5));
        }

        public int f() {
            float f5 = this.f2044d;
            return (int) (f5 / Math.abs(f5));
        }

        public boolean h() {
            return this.f2049i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f2049i + ((long) this.f2051k);
        }

        public void i() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f2051k = a.f((int) (currentAnimationTimeMillis - this.f2045e), 0, this.f2042b);
            this.f2050j = e(currentAnimationTimeMillis);
            this.f2049i = currentAnimationTimeMillis;
        }

        public void j(int i5) {
            this.f2042b = i5;
        }

        public void k(int i5) {
            this.f2041a = i5;
        }

        public void l(float f5, float f6) {
            this.f2043c = f5;
            this.f2044d = f6;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f2045e = currentAnimationTimeMillis;
            this.f2049i = -1;
            this.f2046f = currentAnimationTimeMillis;
            this.f2050j = 0.5f;
            this.f2047g = 0;
            this.f2048h = 0;
        }
    }

    private class b implements Runnable {
        b() {
        }

        public void run() {
            a aVar = a.this;
            if (aVar.f2038s) {
                if (aVar.f2036q) {
                    aVar.f2036q = false;
                    aVar.f2024e.m();
                }
                C0033a aVar2 = a.this.f2024e;
                if (aVar2.h() || !a.this.u()) {
                    a.this.f2038s = false;
                    return;
                }
                a aVar3 = a.this;
                if (aVar3.f2037r) {
                    aVar3.f2037r = false;
                    aVar3.c();
                }
                aVar2.a();
                a.this.j(aVar2.b(), aVar2.c());
                k0.J(a.this.f2026g, this);
            }
        }
    }

    public a(View view) {
        this.f2026g = view;
        float f5 = Resources.getSystem().getDisplayMetrics().density;
        float f6 = (float) ((int) ((1575.0f * f5) + 0.5f));
        o(f6, f6);
        float f7 = (float) ((int) ((f5 * 315.0f) + 0.5f));
        p(f7, f7);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f2023v);
        r(CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION);
        q(CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION);
    }

    private float d(int i5, float f5, float f6, float f7) {
        float h5 = h(this.f2028i[i5], f6, this.f2029j[i5], f5);
        int i6 = (h5 > CropImageView.DEFAULT_ASPECT_RATIO ? 1 : (h5 == CropImageView.DEFAULT_ASPECT_RATIO ? 0 : -1));
        if (i6 == 0) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        float f8 = this.f2032m[i5];
        float f9 = this.f2033n[i5];
        float f10 = this.f2034o[i5];
        float f11 = f8 * f7;
        return i6 > 0 ? e(h5 * f11, f9, f10) : -e((-h5) * f11, f9, f10);
    }

    static float e(float f5, float f6, float f7) {
        return f5 > f7 ? f7 : f5 < f6 ? f6 : f5;
    }

    static int f(int i5, int i6, int i7) {
        return i5 > i7 ? i7 : i5 < i6 ? i6 : i5;
    }

    private float g(float f5, float f6) {
        if (f6 == CropImageView.DEFAULT_ASPECT_RATIO) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        int i5 = this.f2030k;
        if (i5 == 0 || i5 == 1) {
            if (f5 < f6) {
                if (f5 >= CropImageView.DEFAULT_ASPECT_RATIO) {
                    return 1.0f - (f5 / f6);
                }
                if (!this.f2038s || i5 != 1) {
                    return CropImageView.DEFAULT_ASPECT_RATIO;
                }
                return 1.0f;
            }
        } else if (i5 == 2 && f5 < CropImageView.DEFAULT_ASPECT_RATIO) {
            return f5 / (-f6);
        }
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    private float h(float f5, float f6, float f7, float f8) {
        float f9;
        float e5 = e(f5 * f6, CropImageView.DEFAULT_ASPECT_RATIO, f7);
        float g5 = g(f6 - f8, e5) - g(f8, e5);
        if (g5 < CropImageView.DEFAULT_ASPECT_RATIO) {
            f9 = -this.f2025f.getInterpolation(-g5);
        } else if (g5 <= CropImageView.DEFAULT_ASPECT_RATIO) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        } else {
            f9 = this.f2025f.getInterpolation(g5);
        }
        return e(f9, -1.0f, 1.0f);
    }

    private void i() {
        if (this.f2036q) {
            this.f2038s = false;
        } else {
            this.f2024e.i();
        }
    }

    private void v() {
        int i5;
        if (this.f2027h == null) {
            this.f2027h = new b();
        }
        this.f2038s = true;
        this.f2036q = true;
        if (this.f2035p || (i5 = this.f2031l) <= 0) {
            this.f2027h.run();
        } else {
            k0.K(this.f2026g, this.f2027h, (long) i5);
        }
        this.f2035p = true;
    }

    public abstract boolean a(int i5);

    public abstract boolean b(int i5);

    /* access modifiers changed from: package-private */
    public void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 0);
        this.f2026g.onTouchEvent(obtain);
        obtain.recycle();
    }

    public abstract void j(int i5, int i6);

    public a k(int i5) {
        this.f2031l = i5;
        return this;
    }

    public a l(int i5) {
        this.f2030k = i5;
        return this;
    }

    public a m(boolean z4) {
        if (this.f2039t && !z4) {
            i();
        }
        this.f2039t = z4;
        return this;
    }

    public a n(float f5, float f6) {
        float[] fArr = this.f2029j;
        fArr[0] = f5;
        fArr[1] = f6;
        return this;
    }

    public a o(float f5, float f6) {
        float[] fArr = this.f2034o;
        fArr[0] = f5 / 1000.0f;
        fArr[1] = f6 / 1000.0f;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x0058;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f2039t
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x001e
            r6 = 3
            if (r0 == r6) goto L_0x0016
            goto L_0x0058
        L_0x0016:
            r5.i()
            goto L_0x0058
        L_0x001a:
            r5.f2037r = r2
            r5.f2035p = r1
        L_0x001e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f2026g
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f2026g
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            androidx.core.widget.a$a r7 = r5.f2024e
            r7.l(r0, r6)
            boolean r6 = r5.f2038s
            if (r6 != 0) goto L_0x0058
            boolean r6 = r5.u()
            if (r6 == 0) goto L_0x0058
            r5.v()
        L_0x0058:
            boolean r6 = r5.f2040u
            if (r6 == 0) goto L_0x0061
            boolean r6 = r5.f2038s
            if (r6 == 0) goto L_0x0061
            r1 = r2
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public a p(float f5, float f6) {
        float[] fArr = this.f2033n;
        fArr[0] = f5 / 1000.0f;
        fArr[1] = f6 / 1000.0f;
        return this;
    }

    public a q(int i5) {
        this.f2024e.j(i5);
        return this;
    }

    public a r(int i5) {
        this.f2024e.k(i5);
        return this;
    }

    public a s(float f5, float f6) {
        float[] fArr = this.f2028i;
        fArr[0] = f5;
        fArr[1] = f6;
        return this;
    }

    public a t(float f5, float f6) {
        float[] fArr = this.f2032m;
        fArr[0] = f5 / 1000.0f;
        fArr[1] = f6 / 1000.0f;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean u() {
        C0033a aVar = this.f2024e;
        int f5 = aVar.f();
        int d5 = aVar.d();
        return (f5 != 0 && b(f5)) || (d5 != 0 && a(d5));
    }
}
