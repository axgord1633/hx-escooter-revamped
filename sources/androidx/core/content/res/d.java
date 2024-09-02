package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Shader;
import android.util.Log;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Shader f1653a;

    /* renamed from: b  reason: collision with root package name */
    private final ColorStateList f1654b;

    /* renamed from: c  reason: collision with root package name */
    private int f1655c;

    private d(Shader shader, ColorStateList colorStateList, int i5) {
        this.f1653a = shader;
        this.f1654b = colorStateList;
        this.f1655c = i5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.core.content.res.d a(android.content.res.Resources r4, int r5, android.content.res.Resources.Theme r6) {
        /*
            android.content.res.XmlResourceParser r5 = r4.getXml(r5)
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r5)
        L_0x0008:
            int r1 = r5.next()
            r2 = 2
            if (r1 == r2) goto L_0x0013
            r3 = 1
            if (r1 == r3) goto L_0x0013
            goto L_0x0008
        L_0x0013:
            if (r1 != r2) goto L_0x005c
            java.lang.String r1 = r5.getName()
            r1.hashCode()
            java.lang.String r2 = "gradient"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x0053
            java.lang.String r2 = "selector"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0035
            android.content.res.ColorStateList r4 = androidx.core.content.res.c.b(r4, r5, r0, r6)
            androidx.core.content.res.d r4 = c(r4)
            return r4
        L_0x0035:
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r5 = r5.getPositionDescription()
            r6.append(r5)
            java.lang.String r5 = ": unsupported complex color tag "
            r6.append(r5)
            r6.append(r1)
            java.lang.String r5 = r6.toString()
            r4.<init>(r5)
            throw r4
        L_0x0053:
            android.graphics.Shader r4 = androidx.core.content.res.f.b(r4, r5, r0, r6)
            androidx.core.content.res.d r4 = d(r4)
            return r4
        L_0x005c:
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r5 = "No start tag found"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.d.a(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.core.content.res.d");
    }

    static d b(int i5) {
        return new d((Shader) null, (ColorStateList) null, i5);
    }

    static d c(ColorStateList colorStateList) {
        return new d((Shader) null, colorStateList, colorStateList.getDefaultColor());
    }

    static d d(Shader shader) {
        return new d(shader, (ColorStateList) null, 0);
    }

    public static d g(Resources resources, int i5, Resources.Theme theme) {
        try {
            return a(resources, i5, theme);
        } catch (Exception e5) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e5);
            return null;
        }
    }

    public int e() {
        return this.f1655c;
    }

    public Shader f() {
        return this.f1653a;
    }

    public boolean h() {
        return this.f1653a != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f1654b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean i() {
        /*
            r1 = this;
            android.graphics.Shader r0 = r1.f1653a
            if (r0 != 0) goto L_0x0010
            android.content.res.ColorStateList r0 = r1.f1654b
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.d.i():boolean");
    }

    public boolean j(int[] iArr) {
        if (i()) {
            ColorStateList colorStateList = this.f1654b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f1655c) {
                this.f1655c = colorForState;
                return true;
            }
        }
        return false;
    }

    public void k(int i5) {
        this.f1655c = i5;
    }

    public boolean l() {
        return h() || this.f1655c != 0;
    }
}
