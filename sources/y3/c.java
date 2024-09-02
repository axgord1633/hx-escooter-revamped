package y3;

import kotlin.jvm.internal.g;

public final class c extends a {

    /* renamed from: i  reason: collision with root package name */
    public static final a f7832i = new a((g) null);
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final c f7833j = new c(1, 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final c a() {
            return c.f7833j;
        }
    }

    public c(int i5, int i6) {
        super(i5, i6, 1);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (!(c() == cVar.c() && e() == cVar.e())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (c() * 31) + e();
    }

    public boolean isEmpty() {
        return c() > e();
    }

    public boolean m(int i5) {
        return c() <= i5 && i5 <= e();
    }

    public Integer n() {
        return Integer.valueOf(e());
    }

    public Integer o() {
        return Integer.valueOf(c());
    }

    public String toString() {
        return c() + ".." + e();
    }
}
