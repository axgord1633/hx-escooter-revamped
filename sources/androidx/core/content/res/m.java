package androidx.core.content.res;

import com.yalantis.ucrop.view.CropImageView;

final class m {

    /* renamed from: k  reason: collision with root package name */
    static final m f1679k = k(b.f1650c, (float) ((((double) b.h(50.0f)) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);

    /* renamed from: a  reason: collision with root package name */
    private final float f1680a;

    /* renamed from: b  reason: collision with root package name */
    private final float f1681b;

    /* renamed from: c  reason: collision with root package name */
    private final float f1682c;

    /* renamed from: d  reason: collision with root package name */
    private final float f1683d;

    /* renamed from: e  reason: collision with root package name */
    private final float f1684e;

    /* renamed from: f  reason: collision with root package name */
    private final float f1685f;

    /* renamed from: g  reason: collision with root package name */
    private final float[] f1686g;

    /* renamed from: h  reason: collision with root package name */
    private final float f1687h;

    /* renamed from: i  reason: collision with root package name */
    private final float f1688i;

    /* renamed from: j  reason: collision with root package name */
    private final float f1689j;

    private m(float f5, float f6, float f7, float f8, float f9, float f10, float[] fArr, float f11, float f12, float f13) {
        this.f1685f = f5;
        this.f1680a = f6;
        this.f1681b = f7;
        this.f1682c = f8;
        this.f1683d = f9;
        this.f1684e = f10;
        this.f1686g = fArr;
        this.f1687h = f11;
        this.f1688i = f12;
        this.f1689j = f13;
    }

    static m k(float[] fArr, float f5, float f6, float f7, boolean z4) {
        float f8 = f5;
        float[][] fArr2 = b.f1648a;
        float f9 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f10 = fArr[1];
        float f11 = fArr[2];
        float f12 = (fArr3[0] * f9) + (fArr3[1] * f10) + (fArr3[2] * f11);
        float[] fArr4 = fArr2[1];
        float f13 = (fArr4[0] * f9) + (fArr4[1] * f10) + (fArr4[2] * f11);
        float[] fArr5 = fArr2[2];
        float f14 = (f9 * fArr5[0]) + (f10 * fArr5[1]) + (f11 * fArr5[2]);
        float f15 = (f7 / 10.0f) + 0.8f;
        float d5 = ((double) f15) >= 0.9d ? b.d(0.59f, 0.69f, (f15 - 0.9f) * 10.0f) : b.d(0.525f, 0.59f, (f15 - 0.8f) * 10.0f);
        float exp = z4 ? 1.0f : (1.0f - (((float) Math.exp((double) (((-f8) - 42.0f) / 92.0f))) * 0.2777778f)) * f15;
        double d6 = (double) exp;
        if (d6 > 1.0d) {
            exp = 1.0f;
        } else if (d6 < 0.0d) {
            exp = CropImageView.DEFAULT_ASPECT_RATIO;
        }
        float[] fArr6 = {(((100.0f / f12) * exp) + 1.0f) - exp, (((100.0f / f13) * exp) + 1.0f) - exp, (((100.0f / f14) * exp) + 1.0f) - exp};
        float f16 = 1.0f / ((5.0f * f8) + 1.0f);
        float f17 = f16 * f16 * f16 * f16;
        float f18 = 1.0f - f17;
        float cbrt = (f17 * f8) + (0.1f * f18 * f18 * ((float) Math.cbrt(((double) f8) * 5.0d)));
        float h5 = b.h(f6) / fArr[1];
        double d7 = (double) h5;
        float sqrt = ((float) Math.sqrt(d7)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d7, 0.2d));
        float pow2 = (float) Math.pow(((double) ((fArr6[2] * cbrt) * f14)) / 100.0d, 0.42d);
        float[] fArr7 = {(float) Math.pow(((double) ((fArr6[0] * cbrt) * f12)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[1] * cbrt) * f13)) / 100.0d, 0.42d), pow2};
        float f19 = fArr7[0];
        float f20 = (f19 * 400.0f) / (f19 + 27.13f);
        float f21 = fArr7[1];
        return new m(h5, ((f20 * 2.0f) + ((f21 * 400.0f) / (f21 + 27.13f)) + (((400.0f * pow2) / (pow2 + 27.13f)) * 0.05f)) * pow, pow, pow, d5, f15, fArr6, cbrt, (float) Math.pow((double) cbrt, 0.25d), sqrt);
    }

    /* access modifiers changed from: package-private */
    public float a() {
        return this.f1680a;
    }

    /* access modifiers changed from: package-private */
    public float b() {
        return this.f1683d;
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.f1687h;
    }

    /* access modifiers changed from: package-private */
    public float d() {
        return this.f1688i;
    }

    /* access modifiers changed from: package-private */
    public float e() {
        return this.f1685f;
    }

    /* access modifiers changed from: package-private */
    public float f() {
        return this.f1681b;
    }

    /* access modifiers changed from: package-private */
    public float g() {
        return this.f1684e;
    }

    /* access modifiers changed from: package-private */
    public float h() {
        return this.f1682c;
    }

    /* access modifiers changed from: package-private */
    public float[] i() {
        return this.f1686g;
    }

    /* access modifiers changed from: package-private */
    public float j() {
        return this.f1689j;
    }
}
