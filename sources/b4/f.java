package b4;

import com.yalantis.ucrop.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

class f extends e {

    static final class a extends l implements v3.l<String, String> {

        /* renamed from: e  reason: collision with root package name */
        public static final a f3059e = new a();

        a() {
            super(1);
        }

        /* renamed from: a */
        public final String invoke(String str) {
            k.e(str, "line");
            return str;
        }
    }

    static final class b extends l implements v3.l<String, String> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f3060e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.f3060e = str;
        }

        /* renamed from: a */
        public final String invoke(String str) {
            k.e(str, "line");
            return this.f3060e + str;
        }
    }

    private static final v3.l<String, String> b(String str) {
        return str.length() == 0 ? a.f3059e : new b(str);
    }

    private static final int c(String str) {
        int length = str.length();
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                i5 = -1;
                break;
            } else if (!a.c(str.charAt(i5))) {
                break;
            } else {
                i5++;
            }
        }
        return i5 == -1 ? str.length() : i5;
    }

    public static final String d(String str, String str2) {
        String invoke;
        k.e(str, "<this>");
        k.e(str2, "newIndent");
        List<String> I = n.I(str);
        ArrayList<String> arrayList = new ArrayList<>();
        for (T next : I) {
            if (!m.j((String) next)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(o.i(arrayList, 10));
        for (String c5 : arrayList) {
            arrayList2.add(Integer.valueOf(c(c5)));
        }
        Integer num = (Integer) v.q(arrayList2);
        int i5 = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * I.size());
        v3.l<String, String> b5 = b(str2);
        int e5 = n.e(I);
        ArrayList arrayList3 = new ArrayList();
        for (T next2 : I) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                n.h();
            }
            String str3 = (String) next2;
            if ((i5 == 0 || i5 == e5) && m.j(str3)) {
                str3 = null;
            } else {
                String b02 = p.b0(str3, intValue);
                if (!(b02 == null || (invoke = b5.invoke(b02)) == null)) {
                    str3 = invoke;
                }
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i5 = i6;
        }
        String sb = ((StringBuilder) v.n(arrayList3, new StringBuilder(length), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (v3.l) null, 124, (Object) null)).toString();
        k.d(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    public static String e(String str) {
        k.e(str, "<this>");
        return d(str, BuildConfig.FLAVOR);
    }
}
