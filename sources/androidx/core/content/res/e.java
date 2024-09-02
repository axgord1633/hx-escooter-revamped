package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class e {

    static class a {
        static int a(TypedArray typedArray, int i5) {
            return typedArray.getType(i5);
        }
    }

    public interface b {
    }

    public static final class c implements b {

        /* renamed from: a  reason: collision with root package name */
        private final d[] f1656a;

        public c(d[] dVarArr) {
            this.f1656a = dVarArr;
        }

        public d[] a() {
            return this.f1656a;
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final String f1657a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1658b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f1659c;

        /* renamed from: d  reason: collision with root package name */
        private final String f1660d;

        /* renamed from: e  reason: collision with root package name */
        private final int f1661e;

        /* renamed from: f  reason: collision with root package name */
        private final int f1662f;

        public d(String str, int i5, boolean z4, String str2, int i6, int i7) {
            this.f1657a = str;
            this.f1658b = i5;
            this.f1659c = z4;
            this.f1660d = str2;
            this.f1661e = i6;
            this.f1662f = i7;
        }

        public String a() {
            return this.f1657a;
        }

        public int b() {
            return this.f1662f;
        }

        public int c() {
            return this.f1661e;
        }

        public String d() {
            return this.f1660d;
        }

        public int e() {
            return this.f1658b;
        }

        public boolean f() {
            return this.f1659c;
        }
    }

    /* renamed from: androidx.core.content.res.e$e  reason: collision with other inner class name */
    public static final class C0024e implements b {

        /* renamed from: a  reason: collision with root package name */
        private final androidx.core.provider.e f1663a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1664b;

        /* renamed from: c  reason: collision with root package name */
        private final int f1665c;

        /* renamed from: d  reason: collision with root package name */
        private final String f1666d;

        public C0024e(androidx.core.provider.e eVar, int i5, int i6, String str) {
            this.f1663a = eVar;
            this.f1665c = i5;
            this.f1664b = i6;
            this.f1666d = str;
        }

        public int a() {
            return this.f1665c;
        }

        public androidx.core.provider.e b() {
            return this.f1663a;
        }

        public String c() {
            return this.f1666d;
        }

        public int d() {
            return this.f1664b;
        }
    }

    private static int a(TypedArray typedArray, int i5) {
        return a.a(typedArray, i5);
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public static androidx.core.content.res.e.b b(org.xmlpull.v1.XmlPullParser r3, android.content.res.Resources r4) {
        /*
        L_0x0000:
            int r0 = r3.next()
            r1 = 2
            if (r0 == r1) goto L_0x000b
            r2 = 1
            if (r0 == r2) goto L_0x000b
            goto L_0x0000
        L_0x000b:
            if (r0 != r1) goto L_0x0012
            androidx.core.content.res.e$b r3 = d(r3, r4)
            return r3
        L_0x0012:
            org.xmlpull.v1.XmlPullParserException r3 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r4 = "No start tag found"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.e.b(org.xmlpull.v1.XmlPullParser, android.content.res.Resources):androidx.core.content.res.e$b");
    }

    public static List<List<byte[]>> c(Resources resources, int i5) {
        if (i5 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i5);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i6 = 0; i6 < obtainTypedArray.length(); i6++) {
                    int resourceId = obtainTypedArray.getResourceId(i6, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i5)));
            }
            obtainTypedArray.recycle();
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static b d(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, (String) null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static b e(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), n.c.f5972h);
        String string = obtainAttributes.getString(n.c.f5973i);
        String string2 = obtainAttributes.getString(n.c.f5977m);
        String string3 = obtainAttributes.getString(n.c.f5978n);
        int resourceId = obtainAttributes.getResourceId(n.c.f5974j, 0);
        int integer = obtainAttributes.getInteger(n.c.f5975k, 1);
        int integer2 = obtainAttributes.getInteger(n.c.f5976l, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION);
        String string4 = obtainAttributes.getString(n.c.f5979o);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(f(xmlPullParser, resources));
                    } else {
                        g(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new c((d[]) arrayList.toArray(new d[0]));
        }
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new C0024e(new androidx.core.provider.e(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
    }

    private static d f(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), n.c.f5980p);
        int i5 = n.c.f5989y;
        if (!obtainAttributes.hasValue(i5)) {
            i5 = n.c.f5982r;
        }
        int i6 = obtainAttributes.getInt(i5, 400);
        int i7 = n.c.f5987w;
        if (!obtainAttributes.hasValue(i7)) {
            i7 = n.c.f5983s;
        }
        boolean z4 = 1 == obtainAttributes.getInt(i7, 0);
        int i8 = n.c.f5990z;
        if (!obtainAttributes.hasValue(i8)) {
            i8 = n.c.f5984t;
        }
        int i9 = n.c.f5988x;
        if (!obtainAttributes.hasValue(i9)) {
            i9 = n.c.f5985u;
        }
        String string = obtainAttributes.getString(i9);
        int i10 = obtainAttributes.getInt(i8, 0);
        int i11 = n.c.f5986v;
        if (!obtainAttributes.hasValue(i11)) {
            i11 = n.c.f5981q;
        }
        int resourceId = obtainAttributes.getResourceId(i11, 0);
        String string2 = obtainAttributes.getString(i11);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new d(string2, i6, z4, string, i10, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) {
        int i5 = 1;
        while (i5 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i5++;
            } else if (next == 3) {
                i5--;
            }
        }
    }

    private static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }
}
