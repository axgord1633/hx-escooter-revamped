package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import n.c;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class f {

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final int[] f1667a;

        /* renamed from: b  reason: collision with root package name */
        final float[] f1668b;

        a(int i5, int i6) {
            this.f1667a = new int[]{i5, i6};
            this.f1668b = new float[]{CropImageView.DEFAULT_ASPECT_RATIO, 1.0f};
        }

        a(int i5, int i6, int i7) {
            this.f1667a = new int[]{i5, i6, i7};
            this.f1668b = new float[]{CropImageView.DEFAULT_ASPECT_RATIO, 0.5f, 1.0f};
        }

        a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.f1667a = new int[size];
            this.f1668b = new float[size];
            for (int i5 = 0; i5 < size; i5++) {
                this.f1667a[i5] = list.get(i5).intValue();
                this.f1668b[i5] = list2.get(i5).floatValue();
            }
        }
    }

    private static a a(a aVar, int i5, int i6, boolean z4, int i7) {
        a aVar2;
        if (aVar != null) {
            return aVar;
        }
        if (z4) {
            return aVar2;
        }
        aVar2 = new a(i5, i6);
        return aVar2;
    }

    static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String name = xmlPullParser.getName();
        if (name.equals("gradient")) {
            Resources.Theme theme2 = theme;
            TypedArray k5 = l.k(resources, theme2, attributeSet, c.A);
            float f5 = l.f(k5, xmlPullParser2, "startX", c.J, CropImageView.DEFAULT_ASPECT_RATIO);
            float f6 = l.f(k5, xmlPullParser2, "startY", c.K, CropImageView.DEFAULT_ASPECT_RATIO);
            float f7 = l.f(k5, xmlPullParser2, "endX", c.L, CropImageView.DEFAULT_ASPECT_RATIO);
            float f8 = l.f(k5, xmlPullParser2, "endY", c.M, CropImageView.DEFAULT_ASPECT_RATIO);
            float f9 = l.f(k5, xmlPullParser2, "centerX", c.E, CropImageView.DEFAULT_ASPECT_RATIO);
            float f10 = l.f(k5, xmlPullParser2, "centerY", c.F, CropImageView.DEFAULT_ASPECT_RATIO);
            int g5 = l.g(k5, xmlPullParser2, "type", c.D, 0);
            int b5 = l.b(k5, xmlPullParser2, "startColor", c.B, 0);
            boolean j5 = l.j(xmlPullParser2, "centerColor");
            int b6 = l.b(k5, xmlPullParser2, "centerColor", c.I, 0);
            int b7 = l.b(k5, xmlPullParser2, "endColor", c.C, 0);
            int g6 = l.g(k5, xmlPullParser2, "tileMode", c.H, 0);
            float f11 = f9;
            float f12 = l.f(k5, xmlPullParser2, "gradientRadius", c.G, CropImageView.DEFAULT_ASPECT_RATIO);
            k5.recycle();
            a a5 = a(c(resources, xmlPullParser, attributeSet, theme), b5, b7, j5, b6);
            if (g5 == 1) {
                float f13 = f11;
                if (f12 > CropImageView.DEFAULT_ASPECT_RATIO) {
                    int[] iArr = a5.f1667a;
                    return new RadialGradient(f13, f10, f12, iArr, a5.f1668b, d(g6));
                }
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            } else if (g5 != 2) {
                return new LinearGradient(f5, f6, f7, f8, a5.f1667a, a5.f1668b, d(g6));
            } else {
                return new SweepGradient(f11, f10, a5.f1667a, a5.f1668b);
            }
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0080, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.core.content.res.f.a c(android.content.res.Resources r9, org.xmlpull.v1.XmlPullParser r10, android.util.AttributeSet r11, android.content.res.Resources.Theme r12) {
        /*
            int r0 = r10.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L_0x0012:
            int r3 = r10.next()
            if (r3 == r1) goto L_0x0081
            int r5 = r10.getDepth()
            if (r5 >= r0) goto L_0x0021
            r6 = 3
            if (r3 == r6) goto L_0x0081
        L_0x0021:
            r6 = 2
            if (r3 == r6) goto L_0x0025
            goto L_0x0012
        L_0x0025:
            if (r5 > r0) goto L_0x0012
            java.lang.String r3 = r10.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0034
            goto L_0x0012
        L_0x0034:
            int[] r3 = n.c.N
            android.content.res.TypedArray r3 = androidx.core.content.res.l.k(r9, r12, r11, r3)
            int r5 = n.c.O
            boolean r6 = r3.hasValue(r5)
            int r7 = n.c.P
            boolean r8 = r3.hasValue(r7)
            if (r6 == 0) goto L_0x0066
            if (r8 == 0) goto L_0x0066
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            r6 = 0
            float r6 = r3.getFloat(r7, r6)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L_0x0012
        L_0x0066:
            org.xmlpull.v1.XmlPullParserException r9 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r10 = r10.getPositionDescription()
            r11.append(r10)
            java.lang.String r10 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.<init>(r10)
            throw r9
        L_0x0081:
            int r9 = r4.size()
            if (r9 <= 0) goto L_0x008d
            androidx.core.content.res.f$a r9 = new androidx.core.content.res.f$a
            r9.<init>((java.util.List<java.lang.Integer>) r4, (java.util.List<java.lang.Float>) r2)
            return r9
        L_0x008d:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.f.c(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):androidx.core.content.res.f$a");
    }

    private static Shader.TileMode d(int i5) {
        return i5 != 1 ? i5 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR : Shader.TileMode.REPEAT;
    }
}
