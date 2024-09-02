package a0;

import android.os.Trace;

final class f {
    public static void a(String str, int i5) {
        Trace.beginAsyncSection(str, i5);
    }

    public static void b(String str, int i5) {
        Trace.endAsyncSection(str, i5);
    }
}
