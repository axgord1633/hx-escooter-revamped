package t1;

import g0.c;

public final class e implements c<Integer> {

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final e f6868a = new e();
    }

    public static e a() {
        return a.f6868a;
    }

    public static int b() {
        return d.a();
    }

    /* renamed from: c */
    public Integer get() {
        return Integer.valueOf(b());
    }
}
