package w0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class o {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List f7420a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final Object f7421b;

        /* synthetic */ a(Object obj, r0 r0Var) {
            p.g(obj);
            this.f7421b = obj;
        }

        public a a(String str, Object obj) {
            List list = this.f7420a;
            p.g(str);
            String valueOf = String.valueOf(obj);
            list.add(str + "=" + valueOf);
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f7421b.getClass().getSimpleName());
            sb.append('{');
            int size = this.f7420a.size();
            for (int i5 = 0; i5 < size; i5++) {
                sb.append((String) this.f7420a.get(i5));
                if (i5 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a c(Object obj) {
        return new a(obj, (r0) null);
    }
}
