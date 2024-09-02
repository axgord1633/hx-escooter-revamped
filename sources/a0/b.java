package a0;

import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static long f2a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f3b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f4c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f5d;

    public static void a(String str, int i5) {
        try {
            if (f4c == null) {
                f.a(str, i5);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        b(str, i5);
    }

    private static void b(String str, int i5) {
        try {
            if (f4c == null) {
                f4c = Trace.class.getMethod("asyncTraceBegin", new Class[]{Long.TYPE, String.class, Integer.TYPE});
            }
            f4c.invoke((Object) null, new Object[]{Long.valueOf(f2a), str, Integer.valueOf(i5)});
        } catch (Exception e5) {
            g("asyncTraceBegin", e5);
        }
    }

    public static void c(String str) {
        c.a(str);
    }

    public static void d(String str, int i5) {
        try {
            if (f5d == null) {
                f.b(str, i5);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        e(str, i5);
    }

    private static void e(String str, int i5) {
        try {
            if (f5d == null) {
                f5d = Trace.class.getMethod("asyncTraceEnd", new Class[]{Long.TYPE, String.class, Integer.TYPE});
            }
            f5d.invoke((Object) null, new Object[]{Long.valueOf(f2a), str, Integer.valueOf(i5)});
        } catch (Exception e5) {
            g("asyncTraceEnd", e5);
        }
    }

    public static void f() {
        c.b();
    }

    private static void g(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static boolean h() {
        try {
            if (f3b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return i();
    }

    private static boolean i() {
        try {
            if (f3b == null) {
                f2a = Trace.class.getField("TRACE_TAG_APP").getLong((Object) null);
                f3b = Trace.class.getMethod("isTagEnabled", new Class[]{Long.TYPE});
            }
            return ((Boolean) f3b.invoke((Object) null, new Object[]{Long.valueOf(f2a)})).booleanValue();
        } catch (Exception e5) {
            g("isTagEnabled", e5);
            return false;
        }
    }
}
