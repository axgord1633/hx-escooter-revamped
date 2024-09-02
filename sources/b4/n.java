package b4;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import m3.j;
import n3.a0;
import v3.p;
import y3.c;

class n extends m {

    static final class a extends l implements p<CharSequence, Integer, j<? extends Integer, ? extends Integer>> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ List<String> f3061e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f3062f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(List<String> list, boolean z4) {
            super(2);
            this.f3061e = list;
            this.f3062f = z4;
        }

        public final j<Integer, Integer> a(CharSequence charSequence, int i5) {
            k.e(charSequence, "$this$$receiver");
            j p5 = n.s(charSequence, this.f3061e, i5, this.f3062f, false);
            if (p5 != null) {
                return m3.n.a(p5.e(), Integer.valueOf(((String) p5.f()).length()));
            }
            return null;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((CharSequence) obj, ((Number) obj2).intValue());
        }
    }

    static final class b extends l implements v3.l<c, String> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ CharSequence f3063e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(CharSequence charSequence) {
            super(1);
            this.f3063e = charSequence;
        }

        /* renamed from: a */
        public final String invoke(c cVar) {
            k.e(cVar, "it");
            return n.P(this.f3063e, cVar);
        }
    }

    public static /* synthetic */ int A(CharSequence charSequence, String str, int i5, boolean z4, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        if ((i6 & 4) != 0) {
            z4 = false;
        }
        return w(charSequence, str, i5, z4);
    }

    public static final int B(CharSequence charSequence, char[] cArr, int i5, boolean z4) {
        boolean z5;
        k.e(charSequence, "<this>");
        k.e(cArr, "chars");
        if (z4 || cArr.length != 1 || !(charSequence instanceof String)) {
            a0 i6 = new c(f.a(i5, 0), u(charSequence)).iterator();
            while (i6.hasNext()) {
                int nextInt = i6.nextInt();
                char charAt = charSequence.charAt(nextInt);
                int length = cArr.length;
                int i7 = 0;
                while (true) {
                    if (i7 >= length) {
                        z5 = false;
                        continue;
                        break;
                    } else if (b.d(cArr[i7], charAt, z4)) {
                        z5 = true;
                        continue;
                        break;
                    } else {
                        i7++;
                    }
                }
                if (z5) {
                    return nextInt;
                }
            }
            return -1;
        }
        return ((String) charSequence).indexOf(j.t(cArr), i5);
    }

    public static final int C(CharSequence charSequence, char c5, int i5, boolean z4) {
        k.e(charSequence, "<this>");
        if (!z4 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c5, i5);
        }
        return G(charSequence, new char[]{c5}, i5, z4);
    }

    public static final int D(CharSequence charSequence, String str, int i5, boolean z4) {
        k.e(charSequence, "<this>");
        k.e(str, "string");
        return (z4 || !(charSequence instanceof String)) ? x(charSequence, str, i5, 0, z4, true) : ((String) charSequence).lastIndexOf(str, i5);
    }

    public static /* synthetic */ int E(CharSequence charSequence, char c5, int i5, boolean z4, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = u(charSequence);
        }
        if ((i6 & 4) != 0) {
            z4 = false;
        }
        return C(charSequence, c5, i5, z4);
    }

    public static /* synthetic */ int F(CharSequence charSequence, String str, int i5, boolean z4, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = u(charSequence);
        }
        if ((i6 & 4) != 0) {
            z4 = false;
        }
        return D(charSequence, str, i5, z4);
    }

    public static final int G(CharSequence charSequence, char[] cArr, int i5, boolean z4) {
        k.e(charSequence, "<this>");
        k.e(cArr, "chars");
        if (z4 || cArr.length != 1 || !(charSequence instanceof String)) {
            for (int c5 = f.c(i5, u(charSequence)); -1 < c5; c5--) {
                char charAt = charSequence.charAt(c5);
                int length = cArr.length;
                boolean z5 = false;
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        break;
                    } else if (b.d(cArr[i6], charAt, z4)) {
                        z5 = true;
                        break;
                    } else {
                        i6++;
                    }
                }
                if (z5) {
                    return c5;
                }
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(j.t(cArr), i5);
    }

    public static final a4.b<String> H(CharSequence charSequence) {
        k.e(charSequence, "<this>");
        return O(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, (Object) null);
    }

    public static final List<String> I(CharSequence charSequence) {
        k.e(charSequence, "<this>");
        return h.e(H(charSequence));
    }

    private static final a4.b<c> J(CharSequence charSequence, String[] strArr, int i5, boolean z4, int i6) {
        M(i6);
        return new c(charSequence, i5, i6, new a(i.c(strArr), z4));
    }

    static /* synthetic */ a4.b K(CharSequence charSequence, String[] strArr, int i5, boolean z4, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            z4 = false;
        }
        if ((i7 & 8) != 0) {
            i6 = 0;
        }
        return J(charSequence, strArr, i5, z4, i6);
    }

    public static final boolean L(CharSequence charSequence, int i5, CharSequence charSequence2, int i6, int i7, boolean z4) {
        k.e(charSequence, "<this>");
        k.e(charSequence2, "other");
        if (i6 < 0 || i5 < 0 || i5 > charSequence.length() - i7 || i6 > charSequence2.length() - i7) {
            return false;
        }
        for (int i8 = 0; i8 < i7; i8++) {
            if (!b.d(charSequence.charAt(i5 + i8), charSequence2.charAt(i6 + i8), z4)) {
                return false;
            }
        }
        return true;
    }

    public static final void M(int i5) {
        if (!(i5 >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i5).toString());
        }
    }

    public static final a4.b<String> N(CharSequence charSequence, String[] strArr, boolean z4, int i5) {
        k.e(charSequence, "<this>");
        k.e(strArr, "delimiters");
        return h.c(K(charSequence, strArr, 0, z4, i5, 2, (Object) null), new b(charSequence));
    }

    public static /* synthetic */ a4.b O(CharSequence charSequence, String[] strArr, boolean z4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z4 = false;
        }
        if ((i6 & 4) != 0) {
            i5 = 0;
        }
        return N(charSequence, strArr, z4, i5);
    }

    public static final String P(CharSequence charSequence, c cVar) {
        k.e(charSequence, "<this>");
        k.e(cVar, "range");
        return charSequence.subSequence(cVar.o().intValue(), cVar.n().intValue() + 1).toString();
    }

    public static final String Q(String str, char c5, String str2) {
        k.e(str, "<this>");
        k.e(str2, "missingDelimiterValue");
        int z4 = z(str, c5, 0, false, 6, (Object) null);
        if (z4 == -1) {
            return str2;
        }
        String substring = str.substring(z4 + 1, str.length());
        k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String R(String str, String str2, String str3) {
        k.e(str, "<this>");
        k.e(str2, "delimiter");
        k.e(str3, "missingDelimiterValue");
        int A = A(str, str2, 0, false, 6, (Object) null);
        if (A == -1) {
            return str3;
        }
        String substring = str.substring(A + str2.length(), str.length());
        k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String S(String str, char c5, String str2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str2 = str;
        }
        return Q(str, c5, str2);
    }

    public static /* synthetic */ String T(String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str3 = str;
        }
        return R(str, str2, str3);
    }

    public static final String U(String str, char c5, String str2) {
        k.e(str, "<this>");
        k.e(str2, "missingDelimiterValue");
        int E = E(str, c5, 0, false, 6, (Object) null);
        if (E == -1) {
            return str2;
        }
        String substring = str.substring(E + 1, str.length());
        k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String V(String str, char c5, String str2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str2 = str;
        }
        return U(str, c5, str2);
    }

    public static final String W(String str, char c5, String str2) {
        k.e(str, "<this>");
        k.e(str2, "missingDelimiterValue");
        int z4 = z(str, c5, 0, false, 6, (Object) null);
        if (z4 == -1) {
            return str2;
        }
        String substring = str.substring(0, z4);
        k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String X(String str, String str2, String str3) {
        k.e(str, "<this>");
        k.e(str2, "delimiter");
        k.e(str3, "missingDelimiterValue");
        int A = A(str, str2, 0, false, 6, (Object) null);
        if (A == -1) {
            return str3;
        }
        String substring = str.substring(0, A);
        k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String Y(String str, char c5, String str2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str2 = str;
        }
        return W(str, c5, str2);
    }

    public static /* synthetic */ String Z(String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str3 = str;
        }
        return X(str, str2, str3);
    }

    public static CharSequence a0(CharSequence charSequence) {
        k.e(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i5 = 0;
        boolean z4 = false;
        while (i5 <= length) {
            boolean c5 = a.c(charSequence.charAt(!z4 ? i5 : length));
            if (!z4) {
                if (!c5) {
                    z4 = true;
                } else {
                    i5++;
                }
            } else if (!c5) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i5, length + 1);
    }

    public static final boolean q(CharSequence charSequence, CharSequence charSequence2, boolean z4) {
        k.e(charSequence, "<this>");
        k.e(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (A(charSequence, (String) charSequence2, 0, z4, 2, (Object) null) >= 0) {
                return true;
            }
        } else {
            if (y(charSequence, charSequence2, 0, charSequence.length(), z4, false, 16, (Object) null) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean r(CharSequence charSequence, CharSequence charSequence2, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z4 = false;
        }
        return q(charSequence, charSequence2, z4);
    }

    /* access modifiers changed from: private */
    public static final j<Integer, String> s(CharSequence charSequence, Collection<String> collection, int i5, boolean z4, boolean z5) {
        int i6;
        T t5;
        String str;
        T t6;
        if (z4 || collection.size() != 1) {
            y3.a cVar = !z5 ? new c(f.a(i5, 0), charSequence.length()) : f.f(f.c(i5, u(charSequence)), 0);
            if (charSequence instanceof String) {
                i6 = cVar.c();
                int e5 = cVar.e();
                int f5 = cVar.f();
                if ((f5 > 0 && i6 <= e5) || (f5 < 0 && e5 <= i6)) {
                    while (true) {
                        Iterator<T> it = collection.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                t6 = null;
                                break;
                            }
                            t6 = it.next();
                            String str2 = (String) t6;
                            if (m.k(str2, 0, (String) charSequence, i6, str2.length(), z4)) {
                                break;
                            }
                        }
                        str = (String) t6;
                        if (str == null) {
                            if (i6 == e5) {
                                break;
                            }
                            i6 += f5;
                        } else {
                            break;
                        }
                    }
                }
                return null;
            }
            int c5 = cVar.c();
            int e6 = cVar.e();
            int f6 = cVar.f();
            if ((f6 > 0 && c5 <= e6) || (f6 < 0 && e6 <= c5)) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            t5 = null;
                            break;
                        }
                        t5 = it2.next();
                        String str3 = (String) t5;
                        if (L(str3, 0, charSequence, i6, str3.length(), z4)) {
                            break;
                        }
                    }
                    str = (String) t5;
                    if (str == null) {
                        if (i6 == e6) {
                            break;
                        }
                        c5 = i6 + f6;
                    } else {
                        break;
                    }
                }
            }
            return null;
            return m3.n.a(Integer.valueOf(i6), str);
        }
        String str4 = (String) v.r(collection);
        CharSequence charSequence2 = charSequence;
        String str5 = str4;
        int i7 = i5;
        int A = !z5 ? A(charSequence2, str5, i7, false, 4, (Object) null) : F(charSequence2, str5, i7, false, 4, (Object) null);
        if (A < 0) {
            return null;
        }
        return m3.n.a(Integer.valueOf(A), str4);
    }

    public static final c t(CharSequence charSequence) {
        k.e(charSequence, "<this>");
        return new c(0, charSequence.length() - 1);
    }

    public static final int u(CharSequence charSequence) {
        k.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int v(CharSequence charSequence, char c5, int i5, boolean z4) {
        k.e(charSequence, "<this>");
        if (!z4 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c5, i5);
        }
        return B(charSequence, new char[]{c5}, i5, z4);
    }

    public static final int w(CharSequence charSequence, String str, int i5, boolean z4) {
        k.e(charSequence, "<this>");
        k.e(str, "string");
        if (!z4 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i5);
        }
        return y(charSequence, str, i5, charSequence.length(), z4, false, 16, (Object) null);
    }

    private static final int x(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, boolean z4, boolean z5) {
        y3.a cVar = !z5 ? new c(f.a(i5, 0), f.c(i6, charSequence.length())) : f.f(f.c(i5, u(charSequence)), f.a(i6, 0));
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int c5 = cVar.c();
            int e5 = cVar.e();
            int f5 = cVar.f();
            if ((f5 <= 0 || c5 > e5) && (f5 >= 0 || e5 > c5)) {
                return -1;
            }
            while (true) {
                if (L(charSequence2, 0, charSequence, c5, charSequence2.length(), z4)) {
                    return c5;
                }
                if (c5 == e5) {
                    return -1;
                }
                c5 += f5;
            }
        } else {
            int c6 = cVar.c();
            int e6 = cVar.e();
            int f6 = cVar.f();
            if ((f6 <= 0 || c6 > e6) && (f6 >= 0 || e6 > c6)) {
                return -1;
            }
            while (true) {
                if (m.k((String) charSequence2, 0, (String) charSequence, c6, charSequence2.length(), z4)) {
                    return c6;
                }
                if (c6 == e6) {
                    return -1;
                }
                c6 += f6;
            }
        }
    }

    static /* synthetic */ int y(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, boolean z4, boolean z5, int i7, Object obj) {
        if ((i7 & 16) != 0) {
            z5 = false;
        }
        return x(charSequence, charSequence2, i5, i6, z4, z5);
    }

    public static /* synthetic */ int z(CharSequence charSequence, char c5, int i5, boolean z4, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        if ((i6 & 4) != 0) {
            z4 = false;
        }
        return v(charSequence, c5, i5, z4);
    }
}
