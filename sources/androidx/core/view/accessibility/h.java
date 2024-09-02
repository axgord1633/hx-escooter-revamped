package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityRecord;

public class h {

    static class a {
        static int a(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollX();
        }

        static int b(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollY();
        }

        static void c(AccessibilityRecord accessibilityRecord, int i5) {
            accessibilityRecord.setMaxScrollX(i5);
        }

        static void d(AccessibilityRecord accessibilityRecord, int i5) {
            accessibilityRecord.setMaxScrollY(i5);
        }
    }

    public static void a(AccessibilityRecord accessibilityRecord, int i5) {
        a.c(accessibilityRecord, i5);
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i5) {
        a.d(accessibilityRecord, i5);
    }
}
