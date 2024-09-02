package m3;

import java.io.Serializable;
import kotlin.jvm.internal.g;

public final class k<T> implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final a f5898e = new a((g) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public static final class b implements Serializable {

        /* renamed from: e  reason: collision with root package name */
        public final Throwable f5899e;

        public b(Throwable th) {
            kotlin.jvm.internal.k.e(th, "exception");
            this.f5899e = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && kotlin.jvm.internal.k.a(this.f5899e, ((b) obj).f5899e);
        }

        public int hashCode() {
            return this.f5899e.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f5899e + ')';
        }
    }

    public static <T> Object a(Object obj) {
        return obj;
    }

    public static final Throwable b(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).f5899e;
        }
        return null;
    }

    public static final boolean c(Object obj) {
        return obj instanceof b;
    }

    public static final boolean d(Object obj) {
        return !(obj instanceof b);
    }
}
