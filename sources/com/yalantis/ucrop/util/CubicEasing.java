package com.yalantis.ucrop.util;

public final class CubicEasing {
    public static float easeIn(float f5, float f6, float f7, float f8) {
        float f9 = f5 / f8;
        return (f7 * f9 * f9 * f9) + f6;
    }

    public static float easeInOut(float f5, float f6, float f7, float f8) {
        float f9;
        float f10 = f5 / (f8 / 2.0f);
        float f11 = f7 / 2.0f;
        if (f10 < 1.0f) {
            f9 = f11 * f10 * f10 * f10;
        } else {
            float f12 = f10 - 2.0f;
            f9 = f11 * ((f12 * f12 * f12) + 2.0f);
        }
        return f9 + f6;
    }

    public static float easeOut(float f5, float f6, float f7, float f8) {
        float f9 = (f5 / f8) - 1.0f;
        return (f7 * ((f9 * f9 * f9) + 1.0f)) + f6;
    }
}
