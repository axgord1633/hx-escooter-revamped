package b4;

import kotlin.jvm.internal.k;

class p extends o {
    public static final String b0(String str, int i5) {
        k.e(str, "<this>");
        if (i5 >= 0) {
            String substring = str.substring(f.c(i5, str.length()));
            k.d(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i5 + " is less than zero.").toString());
    }
}
