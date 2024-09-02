package q1;

import a2.a;
import u1.b;

public class e extends f {

    /* renamed from: e  reason: collision with root package name */
    public final String f6630e;

    /* renamed from: f  reason: collision with root package name */
    public final int f6631f;

    public e(String str, int i5) {
        super(b(str, i5));
        this.f6630e = str;
        this.f6631f = i5;
    }

    public e(Throwable th, String str, int i5) {
        super(b(str, i5), th);
        this.f6630e = str;
        this.f6631f = i5;
    }

    public static e a(String str) {
        return new e(new a(), str, -1);
    }

    private static String b(String str, int i5) {
        String a5 = a.a(i5);
        return "Disconnected from " + b.d(str) + " with status " + i5 + " (" + a5 + ")";
    }
}
