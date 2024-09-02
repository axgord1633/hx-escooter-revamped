package r1;

import android.util.Log;
import com.yalantis.ucrop.BuildConfig;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p1.c0;
import u1.b;
import u1.c;

public class q {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f6704a = Pattern.compile("\\$\\d+$");

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<String> f6705b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    private static final c0.b f6706c;

    /* renamed from: d  reason: collision with root package name */
    private static u1.a f6707d;

    class a implements c0.b {
        a() {
        }

        public void a(int i5, String str, String str2) {
            Log.println(i5, str, str2);
        }
    }

    static {
        a aVar = new a();
        f6706c = aVar;
        f6707d = new u1.a(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, false, true, aVar);
    }

    private q() {
    }

    private static String a() {
        ThreadLocal<String> threadLocal = f6705b;
        String str = threadLocal.get();
        if (str != null) {
            threadLocal.remove();
            return str;
        }
        int i5 = 0;
        List asList = Arrays.asList(new String[]{q.class.getName(), b.class.getName(), c.class.getName()});
        Throwable th = new Throwable();
        StackTraceElement[] stackTrace = th.getStackTrace();
        while (i5 < stackTrace.length && asList.contains(stackTrace[i5].getClassName())) {
            i5++;
        }
        if (stackTrace.length > i5) {
            String className = stackTrace[i5].getClassName();
            Matcher matcher = f6704a.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll(BuildConfig.FLAVOR);
            }
            String replace = className.replace("Impl", BuildConfig.FLAVOR).replace("RxBle", BuildConfig.FLAVOR);
            int indexOf = replace.indexOf(36);
            String substring = indexOf <= 0 ? replace.substring(replace.lastIndexOf(46) + 1) : replace.substring(replace.lastIndexOf(46) + 1, indexOf);
            return "RxBle#" + substring;
        }
        throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?", th);
    }

    public static void b(String str, Object... objArr) {
        n(3, (Throwable) null, str, objArr);
    }

    public static void c(Throwable th, String str, Object... objArr) {
        n(3, th, str, objArr);
    }

    public static void d(String str, Object... objArr) {
        n(6, (Throwable) null, str, objArr);
    }

    public static void e(Throwable th, String str, Object... objArr) {
        n(6, th, str, objArr);
    }

    private static String f(String str, Object... objArr) {
        return objArr.length == 0 ? str : String.format(str, objArr);
    }

    public static int g() {
        return f6707d.f7094b;
    }

    public static boolean h() {
        return f6707d.f7096d;
    }

    public static boolean i() {
        return f6707d.f7097e;
    }

    public static int j() {
        return f6707d.f7095c;
    }

    public static void k(String str, Object... objArr) {
        n(4, (Throwable) null, str, objArr);
    }

    public static boolean l(int i5) {
        return f6707d.f7093a <= i5;
    }

    private static void m(int i5, String str, String str2) {
        if (str2.length() < 4000) {
            f6707d.f7098f.a(i5, str, str2);
            return;
        }
        for (String a5 : str2.split("\n")) {
            f6707d.f7098f.a(i5, str, a5);
        }
    }

    private static void n(int i5, Throwable th, String str, Object... objArr) {
        if (i5 >= f6707d.f7093a) {
            String f5 = f(str, objArr);
            if (f5 == null || f5.length() == 0) {
                if (th != null) {
                    f5 = Log.getStackTraceString(th);
                } else {
                    return;
                }
            } else if (th != null) {
                f5 = f5 + "\n" + Log.getStackTraceString(th);
            }
            m(i5, a(), f5);
        }
    }

    public static void o(c0 c0Var) {
        u1.a aVar = f6707d;
        u1.a a5 = aVar.a(c0Var);
        b("Received new options (%s) and merged with old setup: %s. New setup: %s", c0Var, aVar, a5);
        f6707d = a5;
    }

    public static void p(String str, Object... objArr) {
        n(2, (Throwable) null, str, objArr);
    }

    public static void q(String str, Object... objArr) {
        n(5, (Throwable) null, str, objArr);
    }

    public static void r(Throwable th, String str, Object... objArr) {
        n(5, th, str, objArr);
    }
}
