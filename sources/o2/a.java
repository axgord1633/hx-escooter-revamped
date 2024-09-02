package o2;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import m2.q;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final q f6142a = n2.a.d(new C0094a());

    /* renamed from: o2.a$a  reason: collision with other inner class name */
    static class C0094a implements Callable<q> {
        C0094a() {
        }

        /* renamed from: a */
        public q call() {
            return b.f6143a;
        }
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final q f6143a = new b(new Handler(Looper.getMainLooper()), false);
    }

    public static q a() {
        return n2.a.e(f6142a);
    }
}
