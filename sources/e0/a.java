package e0;

import android.os.Build;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class a implements k {

    /* renamed from: c  reason: collision with root package name */
    private static final Set<a> f4448c = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    private final String f4449a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4450b;

    /* renamed from: e0.a$a  reason: collision with other inner class name */
    private static class C0073a {

        /* renamed from: a  reason: collision with root package name */
        static final Set<String> f4451a = new HashSet(Arrays.asList(q.d().a()));
    }

    public static final class b extends a {
        b(String str, String str2) {
            super(str, str2);
        }

        public boolean c() {
            return true;
        }
    }

    public static final class c extends a {
        c(String str, String str2) {
            super(str, str2);
        }

        public boolean c() {
            return Build.VERSION.SDK_INT >= 24;
        }
    }

    public static final class d extends a {
        d(String str, String str2) {
            super(str, str2);
        }

        public boolean c() {
            return false;
        }
    }

    public static final class e extends a {
        e(String str, String str2) {
            super(str, str2);
        }

        public boolean c() {
            return Build.VERSION.SDK_INT >= 26;
        }
    }

    public static final class f extends a {
        f(String str, String str2) {
            super(str, str2);
        }

        public boolean c() {
            return Build.VERSION.SDK_INT >= 27;
        }
    }

    public static final class g extends a {
        g(String str, String str2) {
            super(str, str2);
        }

        public boolean c() {
            return Build.VERSION.SDK_INT >= 28;
        }
    }

    public static final class h extends a {
        h(String str, String str2) {
            super(str, str2);
        }

        public boolean c() {
            return Build.VERSION.SDK_INT >= 29;
        }
    }

    a(String str, String str2) {
        this.f4449a = str;
        this.f4450b = str2;
        f4448c.add(this);
    }

    public static Set<a> e() {
        return Collections.unmodifiableSet(f4448c);
    }

    public String a() {
        return this.f4449a;
    }

    public boolean b() {
        return c() || d();
    }

    public abstract boolean c();

    public boolean d() {
        return t4.a.b(C0073a.f4451a, this.f4450b);
    }
}
