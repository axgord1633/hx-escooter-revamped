package androidx.core.graphics;

import android.graphics.Insets;
import android.graphics.Rect;

public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final b f1691e = new b(0, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final int f1692a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1693b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1694c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1695d;

    static class a {
        static Insets a(int i5, int i6, int i7, int i8) {
            return Insets.of(i5, i6, i7, i8);
        }
    }

    private b(int i5, int i6, int i7, int i8) {
        this.f1692a = i5;
        this.f1693b = i6;
        this.f1694c = i7;
        this.f1695d = i8;
    }

    public static b a(b bVar, b bVar2) {
        return b(Math.max(bVar.f1692a, bVar2.f1692a), Math.max(bVar.f1693b, bVar2.f1693b), Math.max(bVar.f1694c, bVar2.f1694c), Math.max(bVar.f1695d, bVar2.f1695d));
    }

    public static b b(int i5, int i6, int i7, int i8) {
        return (i5 == 0 && i6 == 0 && i7 == 0 && i8 == 0) ? f1691e : new b(i5, i6, i7, i8);
    }

    public static b c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static b d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return a.a(this.f1692a, this.f1693b, this.f1694c, this.f1695d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f1695d == bVar.f1695d && this.f1692a == bVar.f1692a && this.f1694c == bVar.f1694c && this.f1693b == bVar.f1693b;
    }

    public int hashCode() {
        return (((((this.f1692a * 31) + this.f1693b) * 31) + this.f1694c) * 31) + this.f1695d;
    }

    public String toString() {
        return "Insets{left=" + this.f1692a + ", top=" + this.f1693b + ", right=" + this.f1694c + ", bottom=" + this.f1695d + '}';
    }
}
