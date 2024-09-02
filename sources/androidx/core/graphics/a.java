package androidx.core.graphics;

import android.graphics.Color;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<double[]> f1690a = new ThreadLocal<>();

    public static int a(double d5, double d6, double d7) {
        double d8 = (((3.2406d * d5) + (-1.5372d * d6)) + (-0.4986d * d7)) / 100.0d;
        double d9 = (((-0.9689d * d5) + (1.8758d * d6)) + (0.0415d * d7)) / 100.0d;
        double d10 = (((0.0557d * d5) + (-0.204d * d6)) + (1.057d * d7)) / 100.0d;
        return Color.rgb(e((int) Math.round((d8 > 0.0031308d ? (Math.pow(d8, 0.4166666666666667d) * 1.055d) - 0.055d : d8 * 12.92d) * 255.0d), 0, 255), e((int) Math.round((d9 > 0.0031308d ? (Math.pow(d9, 0.4166666666666667d) * 1.055d) - 0.055d : d9 * 12.92d) * 255.0d), 0, 255), e((int) Math.round((d10 > 0.0031308d ? (Math.pow(d10, 0.4166666666666667d) * 1.055d) - 0.055d : d10 * 12.92d) * 255.0d), 0, 255));
    }

    private static int b(int i5, int i6) {
        return 255 - (((255 - i6) * (255 - i5)) / 255);
    }

    public static int c(int i5, int i6) {
        int alpha = Color.alpha(i6);
        int alpha2 = Color.alpha(i5);
        int b5 = b(alpha2, alpha);
        return Color.argb(b5, d(Color.red(i5), alpha2, Color.red(i6), alpha, b5), d(Color.green(i5), alpha2, Color.green(i6), alpha, b5), d(Color.blue(i5), alpha2, Color.blue(i6), alpha, b5));
    }

    private static int d(int i5, int i6, int i7, int i8, int i9) {
        if (i9 == 0) {
            return 0;
        }
        return (((i5 * 255) * i6) + ((i7 * i8) * (255 - i6))) / (i9 * 255);
    }

    private static int e(int i5, int i6, int i7) {
        return i5 < i6 ? i6 : Math.min(i5, i7);
    }

    public static int f(int i5, int i6) {
        if (i6 >= 0 && i6 <= 255) {
            return (i5 & 16777215) | (i6 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
