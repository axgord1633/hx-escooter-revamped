package b4;

import y3.c;

class a {
    public static final int a(int i5) {
        if (new c(2, 36).m(i5)) {
            return i5;
        }
        throw new IllegalArgumentException("radix " + i5 + " was not in valid range " + new c(2, 36));
    }

    public static final int b(char c5, int i5) {
        return Character.digit(c5, i5);
    }

    public static final boolean c(char c5) {
        return Character.isWhitespace(c5) || Character.isSpaceChar(c5);
    }
}
