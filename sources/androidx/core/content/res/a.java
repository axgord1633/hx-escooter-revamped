package androidx.core.content.res;

import com.yalantis.ucrop.view.CropImageView;

class a {

    /* renamed from: a  reason: collision with root package name */
    private final float f1639a;

    /* renamed from: b  reason: collision with root package name */
    private final float f1640b;

    /* renamed from: c  reason: collision with root package name */
    private final float f1641c;

    /* renamed from: d  reason: collision with root package name */
    private final float f1642d;

    /* renamed from: e  reason: collision with root package name */
    private final float f1643e;

    /* renamed from: f  reason: collision with root package name */
    private final float f1644f;

    /* renamed from: g  reason: collision with root package name */
    private final float f1645g;

    /* renamed from: h  reason: collision with root package name */
    private final float f1646h;

    /* renamed from: i  reason: collision with root package name */
    private final float f1647i;

    a(float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        this.f1639a = f5;
        this.f1640b = f6;
        this.f1641c = f7;
        this.f1642d = f8;
        this.f1643e = f9;
        this.f1644f = f10;
        this.f1645g = f11;
        this.f1646h = f12;
        this.f1647i = f13;
    }

    private static a b(float f5, float f6, float f7) {
        float f8 = 1000.0f;
        float f9 = 0.0f;
        a aVar = null;
        float f10 = 100.0f;
        float f11 = 1000.0f;
        while (Math.abs(f9 - f10) > 0.01f) {
            float f12 = ((f10 - f9) / 2.0f) + f9;
            int p5 = e(f12, f6, f5).p();
            float b5 = b.b(p5);
            float abs = Math.abs(f7 - b5);
            if (abs < 0.2f) {
                a c5 = c(p5);
                float a5 = c5.a(e(c5.k(), c5.i(), f5));
                if (a5 <= 1.0f) {
                    aVar = c5;
                    f8 = abs;
                    f11 = a5;
                }
            }
            if (f8 == CropImageView.DEFAULT_ASPECT_RATIO && f11 == CropImageView.DEFAULT_ASPECT_RATIO) {
                break;
            } else if (b5 < f7) {
                f9 = f12;
            } else {
                f10 = f12;
            }
        }
        return aVar;
    }

    static a c(int i5) {
        return d(i5, m.f1679k);
    }

    static a d(int i5, m mVar) {
        float[] f5 = b.f(i5);
        float[][] fArr = b.f1648a;
        float f6 = f5[0];
        float[] fArr2 = fArr[0];
        float f7 = f5[1];
        float f8 = f5[2];
        float f9 = (fArr2[0] * f6) + (fArr2[1] * f7) + (fArr2[2] * f8);
        float[] fArr3 = fArr[1];
        float f10 = (fArr3[0] * f6) + (fArr3[1] * f7) + (fArr3[2] * f8);
        float[] fArr4 = fArr[2];
        float f11 = (f6 * fArr4[0]) + (f7 * fArr4[1]) + (f8 * fArr4[2]);
        float f12 = mVar.i()[0] * f9;
        float f13 = mVar.i()[1] * f10;
        float f14 = mVar.i()[2] * f11;
        float pow = (float) Math.pow(((double) (mVar.c() * Math.abs(f12))) / 100.0d, 0.42d);
        float pow2 = (float) Math.pow(((double) (mVar.c() * Math.abs(f13))) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow(((double) (mVar.c() * Math.abs(f14))) / 100.0d, 0.42d);
        float signum = ((Math.signum(f12) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f13) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f14) * 400.0f) * pow3) / (pow3 + 27.13f);
        double d5 = (double) signum3;
        float f15 = ((float) (((((double) signum) * 11.0d) + (((double) signum2) * -12.0d)) + d5)) / 11.0f;
        float f16 = ((float) (((double) (signum + signum2)) - (d5 * 2.0d))) / 9.0f;
        float f17 = signum2 * 20.0f;
        float f18 = (((signum * 20.0f) + f17) + (21.0f * signum3)) / 20.0f;
        float f19 = (((signum * 40.0f) + f17) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2((double) f16, (double) f15)) * 180.0f) / 3.1415927f;
        if (atan2 < CropImageView.DEFAULT_ASPECT_RATIO) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f20 = atan2;
        float f21 = (3.1415927f * f20) / 180.0f;
        float pow4 = ((float) Math.pow((double) ((f19 * mVar.f()) / mVar.a()), (double) (mVar.b() * mVar.j()))) * 100.0f;
        float d6 = mVar.d() * (4.0f / mVar.b()) * ((float) Math.sqrt((double) (pow4 / 100.0f))) * (mVar.a() + 4.0f);
        float pow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, (double) mVar.e()), 0.73d)) * ((float) Math.pow((double) ((((((((float) (Math.cos(((((double) (((double) f20) < 20.14d ? 360.0f + f20 : f20)) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * mVar.g()) * mVar.h()) * ((float) Math.sqrt((double) ((f15 * f15) + (f16 * f16))))) / (f18 + 0.305f)), 0.9d));
        float sqrt = pow5 * ((float) Math.sqrt(((double) pow4) / 100.0d));
        float d7 = sqrt * mVar.d();
        float sqrt2 = ((float) Math.sqrt((double) ((pow5 * mVar.b()) / (mVar.a() + 4.0f)))) * 50.0f;
        float f22 = (1.7f * pow4) / ((0.007f * pow4) + 1.0f);
        float log = ((float) Math.log((double) ((0.0228f * d7) + 1.0f))) * 43.85965f;
        double d8 = (double) f21;
        return new a(f20, sqrt, pow4, d6, d7, sqrt2, f22, log * ((float) Math.cos(d8)), log * ((float) Math.sin(d8)));
    }

    private static a e(float f5, float f6, float f7) {
        return f(f5, f6, f7, m.f1679k);
    }

    private static a f(float f5, float f6, float f7, m mVar) {
        float f8 = f5;
        double d5 = ((double) f8) / 100.0d;
        float b5 = (4.0f / mVar.b()) * ((float) Math.sqrt(d5)) * (mVar.a() + 4.0f) * mVar.d();
        float d6 = f6 * mVar.d();
        float sqrt = ((float) Math.sqrt((double) (((f6 / ((float) Math.sqrt(d5))) * mVar.b()) / (mVar.a() + 4.0f)))) * 50.0f;
        float f9 = (1.7f * f8) / ((0.007f * f8) + 1.0f);
        float log = ((float) Math.log((((double) d6) * 0.0228d) + 1.0d)) * 43.85965f;
        double d7 = (double) ((3.1415927f * f7) / 180.0f);
        return new a(f7, f6, f8, b5, d6, sqrt, f9, log * ((float) Math.cos(d7)), log * ((float) Math.sin(d7)));
    }

    static int m(float f5, float f6, float f7) {
        return n(f5, f6, f7, m.f1679k);
    }

    static int n(float f5, float f6, float f7, m mVar) {
        if (((double) f6) < 1.0d || ((double) Math.round(f7)) <= 0.0d || ((double) Math.round(f7)) >= 100.0d) {
            return b.a(f7);
        }
        float min = f5 < CropImageView.DEFAULT_ASPECT_RATIO ? 0.0f : Math.min(360.0f, f5);
        a aVar = null;
        boolean z4 = true;
        float f8 = 0.0f;
        float f9 = f6;
        while (Math.abs(f8 - f6) >= 0.4f) {
            a b5 = b(min, f9, f7);
            if (z4) {
                if (b5 != null) {
                    return b5.o(mVar);
                }
                z4 = false;
            } else if (b5 == null) {
                f6 = f9;
            } else {
                f8 = f9;
                aVar = b5;
            }
            f9 = ((f6 - f8) / 2.0f) + f8;
        }
        return aVar == null ? b.a(f7) : aVar.o(mVar);
    }

    /* access modifiers changed from: package-private */
    public float a(a aVar) {
        float l5 = l() - aVar.l();
        float g5 = g() - aVar.g();
        float h5 = h() - aVar.h();
        return (float) (Math.pow(Math.sqrt((double) ((l5 * l5) + (g5 * g5) + (h5 * h5))), 0.63d) * 1.41d);
    }

    /* access modifiers changed from: package-private */
    public float g() {
        return this.f1646h;
    }

    /* access modifiers changed from: package-private */
    public float h() {
        return this.f1647i;
    }

    /* access modifiers changed from: package-private */
    public float i() {
        return this.f1640b;
    }

    /* access modifiers changed from: package-private */
    public float j() {
        return this.f1639a;
    }

    /* access modifiers changed from: package-private */
    public float k() {
        return this.f1641c;
    }

    /* access modifiers changed from: package-private */
    public float l() {
        return this.f1645g;
    }

    /* access modifiers changed from: package-private */
    public int o(m mVar) {
        float pow = (float) Math.pow(((double) ((((double) i()) == 0.0d || ((double) k()) == 0.0d) ? CropImageView.DEFAULT_ASPECT_RATIO : i() / ((float) Math.sqrt(((double) k()) / 100.0d)))) / Math.pow(1.64d - Math.pow(0.29d, (double) mVar.e()), 0.73d), 1.1111111111111112d);
        double j5 = (double) ((j() * 3.1415927f) / 180.0f);
        float a5 = mVar.a() * ((float) Math.pow(((double) k()) / 100.0d, (1.0d / ((double) mVar.b())) / ((double) mVar.j())));
        float cos = ((float) (Math.cos(2.0d + j5) + 3.8d)) * 0.25f * 3846.1538f * mVar.g() * mVar.h();
        float f5 = a5 / mVar.f();
        float sin = (float) Math.sin(j5);
        float cos2 = (float) Math.cos(j5);
        float f6 = (((0.305f + f5) * 23.0f) * pow) / (((cos * 23.0f) + ((11.0f * pow) * cos2)) + ((pow * 108.0f) * sin));
        float f7 = cos2 * f6;
        float f8 = f6 * sin;
        float f9 = f5 * 460.0f;
        float f10 = (((451.0f * f7) + f9) + (288.0f * f8)) / 1403.0f;
        float f11 = ((f9 - (891.0f * f7)) - (261.0f * f8)) / 1403.0f;
        float f12 = ((f9 - (f7 * 220.0f)) - (f8 * 6300.0f)) / 1403.0f;
        float signum = Math.signum(f10) * (100.0f / mVar.c()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f10)) * 27.13d) / (400.0d - ((double) Math.abs(f10))))), 2.380952380952381d));
        float signum2 = Math.signum(f11) * (100.0f / mVar.c()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f11)) * 27.13d) / (400.0d - ((double) Math.abs(f11))))), 2.380952380952381d));
        float signum3 = Math.signum(f12) * (100.0f / mVar.c()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f12)) * 27.13d) / (400.0d - ((double) Math.abs(f12))))), 2.380952380952381d));
        float f13 = signum / mVar.i()[0];
        float f14 = signum2 / mVar.i()[1];
        float f15 = signum3 / mVar.i()[2];
        float[][] fArr = b.f1649b;
        float[] fArr2 = fArr[0];
        float f16 = (fArr2[0] * f13) + (fArr2[1] * f14) + (fArr2[2] * f15);
        float[] fArr3 = fArr[1];
        float[] fArr4 = fArr[2];
        return androidx.core.graphics.a.a((double) f16, (double) ((fArr3[0] * f13) + (fArr3[1] * f14) + (fArr3[2] * f15)), (double) ((f13 * fArr4[0]) + (f14 * fArr4[1]) + (f15 * fArr4[2])));
    }

    /* access modifiers changed from: package-private */
    public int p() {
        return o(m.f1679k);
    }
}
