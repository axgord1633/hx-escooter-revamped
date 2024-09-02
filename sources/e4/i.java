package e4;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public final class i<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final b f4535a = new b((g) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final c f4536b = new c();

    public static final class a extends c {

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f4537a;

        public a(Throwable th) {
            this.f4537a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && k.a(this.f4537a, ((a) obj).f4537a);
        }

        public int hashCode() {
            Throwable th = this.f4537a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Closed(" + this.f4537a + ')';
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }

        public final <E> Object a(Throwable th) {
            return i.b(new a(th));
        }

        public final <E> Object b() {
            return i.b(i.f4536b);
        }

        public final <E> Object c(E e5) {
            return i.b(e5);
        }
    }

    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    public static <T> Object b(Object obj) {
        return obj;
    }
}
