package io.flutter.util;

import a0.b;

public final class TraceSection {
    public static void begin(String str) {
        b.c(cropSectionName(str));
    }

    public static void beginAsyncSection(String str, int i5) {
        b.a(cropSectionName(str), i5);
    }

    private static String cropSectionName(String str) {
        if (str.length() < 124) {
            return str;
        }
        return str.substring(0, 124) + "...";
    }

    public static void end() {
        b.f();
    }

    public static void endAsyncSection(String str, int i5) {
        b.d(cropSectionName(str), i5);
    }
}
