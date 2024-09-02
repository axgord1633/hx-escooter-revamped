package g3;

import java.io.Serializable;
import m2.p;
import p2.c;

public enum h {
    COMPLETE;

    static final class a implements Serializable {

        /* renamed from: e  reason: collision with root package name */
        final c f4750e;

        a(c cVar) {
            this.f4750e = cVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.f4750e + "]";
        }
    }

    static final class b implements Serializable {

        /* renamed from: e  reason: collision with root package name */
        final Throwable f4751e;

        b(Throwable th) {
            this.f4751e = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return t2.b.c(this.f4751e, ((b) obj).f4751e);
            }
            return false;
        }

        public int hashCode() {
            return this.f4751e.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f4751e + "]";
        }
    }

    public static <T> boolean c(Object obj, p<? super T> pVar) {
        if (obj == COMPLETE) {
            pVar.a();
            return true;
        } else if (obj instanceof b) {
            pVar.onError(((b) obj).f4751e);
            return true;
        } else {
            pVar.d(obj);
            return false;
        }
    }

    public static <T> boolean f(Object obj, p<? super T> pVar) {
        if (obj == COMPLETE) {
            pVar.a();
            return true;
        } else if (obj instanceof b) {
            pVar.onError(((b) obj).f4751e);
            return true;
        } else if (obj instanceof a) {
            pVar.c(((a) obj).f4750e);
            return false;
        } else {
            pVar.d(obj);
            return false;
        }
    }

    public static Object i() {
        return COMPLETE;
    }

    public static Object l(c cVar) {
        return new a(cVar);
    }

    public static Object m(Throwable th) {
        return new b(th);
    }

    public static <T> T n(Object obj) {
        return obj;
    }

    public static boolean o(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean p(Object obj) {
        return obj instanceof b;
    }

    public static <T> Object q(T t5) {
        return t5;
    }

    public String toString() {
        return "NotificationLite.Complete";
    }
}
