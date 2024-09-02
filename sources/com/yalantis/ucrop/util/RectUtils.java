package com.yalantis.ucrop.util;

import android.graphics.RectF;

public class RectUtils {
    public static float[] getCenterFromRect(RectF rectF) {
        return new float[]{rectF.centerX(), rectF.centerY()};
    }

    public static float[] getCornersFromRect(RectF rectF) {
        float f5 = rectF.left;
        float f6 = rectF.top;
        float f7 = rectF.right;
        float f8 = rectF.bottom;
        return new float[]{f5, f6, f7, f6, f7, f8, f5, f8};
    }

    public static float[] getRectSidesFromCorners(float[] fArr) {
        return new float[]{(float) Math.sqrt(Math.pow((double) (fArr[0] - fArr[2]), 2.0d) + Math.pow((double) (fArr[1] - fArr[3]), 2.0d)), (float) Math.sqrt(Math.pow((double) (fArr[2] - fArr[4]), 2.0d) + Math.pow((double) (fArr[3] - fArr[5]), 2.0d))};
    }

    public static RectF trapToRect(float[] fArr) {
        RectF rectF = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        for (int i5 = 1; i5 < fArr.length; i5 += 2) {
            float round = ((float) Math.round(fArr[i5 - 1] * 10.0f)) / 10.0f;
            float round2 = ((float) Math.round(fArr[i5] * 10.0f)) / 10.0f;
            float f5 = rectF.left;
            if (round < f5) {
                f5 = round;
            }
            rectF.left = f5;
            float f6 = rectF.top;
            if (round2 < f6) {
                f6 = round2;
            }
            rectF.top = f6;
            float f7 = rectF.right;
            if (round <= f7) {
                round = f7;
            }
            rectF.right = round;
            float f8 = rectF.bottom;
            if (round2 <= f8) {
                round2 = f8;
            }
            rectF.bottom = round2;
        }
        rectF.sort();
        return rectF;
    }
}
