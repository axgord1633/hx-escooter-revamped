package androidx.core.content.res;

import android.graphics.Color;
import androidx.core.graphics.a;

final class b {

    /* renamed from: a  reason: collision with root package name */
    static final float[][] f1648a = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    /* renamed from: b  reason: collision with root package name */
    static final float[][] f1649b = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    /* renamed from: c  reason: collision with root package name */
    static final float[] f1650c = {95.047f, 100.0f, 108.883f};

    /* renamed from: d  reason: collision with root package name */
    static final float[][] f1651d = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    static int a(float f5) {
        if (f5 < 1.0f) {
            return -16777216;
        }
        if (f5 > 99.0f) {
            return -1;
        }
        float f6 = (f5 + 16.0f) / 116.0f;
        float f7 = (f5 > 8.0f ? 1 : (f5 == 8.0f ? 0 : -1)) > 0 ? f6 * f6 * f6 : f5 / 903.2963f;
        float f8 = f6 * f6 * f6;
        boolean z4 = f8 > 0.008856452f;
        float f9 = z4 ? f8 : ((f6 * 116.0f) - 16.0f) / 903.2963f;
        if (!z4) {
            f8 = ((f6 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f1650c;
        return a.a((double) (f9 * fArr[0]), (double) (f7 * fArr[1]), (double) (f8 * fArr[2]));
    }

    static float b(int i5) {
        return c(g(i5));
    }

    static float c(float f5) {
        float f6 = f5 / 100.0f;
        return f6 <= 0.008856452f ? f6 * 903.2963f : (((float) Math.cbrt((double) f6)) * 116.0f) - 16.0f;
    }

    static float d(float f5, float f6, float f7) {
        return f5 + ((f6 - f5) * f7);
    }

    static float e(int i5) {
        float f5 = ((float) i5) / 255.0f;
        return (f5 <= 0.04045f ? f5 / 12.92f : (float) Math.pow((double) ((f5 + 0.055f) / 1.055f), 2.4000000953674316d)) * 100.0f;
    }

    static float[] f(int i5) {
        float e5 = e(Color.red(i5));
        float e6 = e(Color.green(i5));
        float e7 = e(Color.blue(i5));
        float[][] fArr = f1651d;
        float[] fArr2 = fArr[0];
        float f5 = (fArr2[0] * e5) + (fArr2[1] * e6) + (fArr2[2] * e7);
        float[] fArr3 = fArr[1];
        float f6 = (fArr3[0] * e5) + (fArr3[1] * e6) + (fArr3[2] * e7);
        float[] fArr4 = fArr[2];
        return new float[]{f5, f6, (e5 * fArr4[0]) + (e6 * fArr4[1]) + (e7 * fArr4[2])};
    }

    static float g(int i5) {
        float e5 = e(Color.red(i5));
        float e6 = e(Color.green(i5));
        float e7 = e(Color.blue(i5));
        float[] fArr = f1651d[1];
        return (e5 * fArr[0]) + (e6 * fArr[1]) + (e7 * fArr[2]);
    }

    static float h(float f5) {
        return (f5 > 8.0f ? (float) Math.pow((((double) f5) + 16.0d) / 116.0d, 3.0d) : f5 / 903.2963f) * 100.0f;
    }
}
