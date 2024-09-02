package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

public class l {
    public static boolean a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i5, boolean z4) {
        return !j(xmlPullParser, str) ? z4 : typedArray.getBoolean(i5, z4);
    }

    public static int b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i5, int i6) {
        return !j(xmlPullParser, str) ? i6 : typedArray.getColor(i5, i6);
    }

    public static ColorStateList c(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i5) {
        if (!j(xmlPullParser, str)) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i5, typedValue);
        int i6 = typedValue.type;
        if (i6 != 2) {
            return (i6 < 28 || i6 > 31) ? c.d(typedArray.getResources(), typedArray.getResourceId(i5, 0), theme) : d(typedValue);
        }
        throw new UnsupportedOperationException("Failed to resolve attribute at index " + i5 + ": " + typedValue);
    }

    private static ColorStateList d(TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static d e(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i5, int i6) {
        if (j(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i5, typedValue);
            int i7 = typedValue.type;
            if (i7 >= 28 && i7 <= 31) {
                return d.b(typedValue.data);
            }
            d g5 = d.g(typedArray.getResources(), typedArray.getResourceId(i5, 0), theme);
            if (g5 != null) {
                return g5;
            }
        }
        return d.b(i6);
    }

    public static float f(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i5, float f5) {
        return !j(xmlPullParser, str) ? f5 : typedArray.getFloat(i5, f5);
    }

    public static int g(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i5, int i6) {
        return !j(xmlPullParser, str) ? i6 : typedArray.getInt(i5, i6);
    }

    public static int h(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i5, int i6) {
        return !j(xmlPullParser, str) ? i6 : typedArray.getResourceId(i5, i6);
    }

    public static String i(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i5) {
        if (!j(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i5);
    }

    public static boolean j(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static TypedArray k(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static TypedValue l(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i5) {
        if (!j(xmlPullParser, str)) {
            return null;
        }
        return typedArray.peekValue(i5);
    }
}
