package n3;

import com.yalantis.ucrop.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.k;
import v3.l;

class j extends i {
    public static final boolean h(byte[] bArr, byte b5) {
        k.e(bArr, "<this>");
        return n(bArr, b5) >= 0;
    }

    public static final <T> boolean i(T[] tArr, T t5) {
        k.e(tArr, "<this>");
        return o(tArr, t5) >= 0;
    }

    public static <T> List<T> j(T[] tArr) {
        k.e(tArr, "<this>");
        return (List) k(tArr, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C k(T[] tArr, C c5) {
        k.e(tArr, "<this>");
        k.e(c5, "destination");
        for (T t5 : tArr) {
            if (t5 != null) {
                c5.add(t5);
            }
        }
        return c5;
    }

    public static <T> T l(T[] tArr) {
        k.e(tArr, "<this>");
        if (!(tArr.length == 0)) {
            return tArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <T> int m(T[] tArr) {
        k.e(tArr, "<this>");
        return tArr.length - 1;
    }

    public static final int n(byte[] bArr, byte b5) {
        k.e(bArr, "<this>");
        int length = bArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (b5 == bArr[i5]) {
                return i5;
            }
        }
        return -1;
    }

    public static final <T> int o(T[] tArr, T t5) {
        k.e(tArr, "<this>");
        int i5 = 0;
        if (t5 == null) {
            int length = tArr.length;
            while (i5 < length) {
                if (tArr[i5] == null) {
                    return i5;
                }
                i5++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i5 < length2) {
            if (k.a(t5, tArr[i5])) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public static final <A extends Appendable> A p(byte[] bArr, A a5, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l<? super Byte, ? extends CharSequence> lVar) {
        k.e(bArr, "<this>");
        k.e(a5, "buffer");
        k.e(charSequence, "separator");
        k.e(charSequence2, "prefix");
        k.e(charSequence3, "postfix");
        k.e(charSequence4, "truncated");
        a5.append(charSequence2);
        int i6 = 0;
        for (byte b5 : bArr) {
            i6++;
            if (i6 > 1) {
                a5.append(charSequence);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            a5.append(lVar != null ? (CharSequence) lVar.invoke(Byte.valueOf(b5)) : String.valueOf(b5));
        }
        if (i5 >= 0 && i6 > i5) {
            a5.append(charSequence4);
        }
        a5.append(charSequence3);
        return a5;
    }

    public static final String q(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l<? super Byte, ? extends CharSequence> lVar) {
        k.e(bArr, "<this>");
        k.e(charSequence, "separator");
        k.e(charSequence2, "prefix");
        k.e(charSequence3, "postfix");
        k.e(charSequence4, "truncated");
        String sb = ((StringBuilder) p(bArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i5, charSequence4, lVar)).toString();
        k.d(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String r(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        int i7 = i6 & 2;
        CharSequence charSequence5 = BuildConfig.FLAVOR;
        CharSequence charSequence6 = i7 != 0 ? charSequence5 : charSequence2;
        if ((i6 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i6 & 8) != 0) {
            i5 = -1;
        }
        int i8 = i5;
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i6 & 32) != 0) {
            lVar = null;
        }
        return q(bArr, charSequence, charSequence6, charSequence5, i8, charSequence7, lVar);
    }

    public static final int s(byte[] bArr, byte b5) {
        k.e(bArr, "<this>");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                if (b5 == bArr[length]) {
                    return length;
                }
                if (i5 < 0) {
                    break;
                }
                length = i5;
            }
        }
        return -1;
    }

    public static char t(char[] cArr) {
        k.e(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return cArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static <T> T u(T[] tArr) {
        k.e(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static <T> List<T> v(T[] tArr) {
        k.e(tArr, "<this>");
        int length = tArr.length;
        return length != 0 ? length != 1 ? w(tArr) : m.b(tArr[0]) : n.d();
    }

    public static final <T> List<T> w(T[] tArr) {
        k.e(tArr, "<this>");
        return new ArrayList(n.c(tArr));
    }
}
