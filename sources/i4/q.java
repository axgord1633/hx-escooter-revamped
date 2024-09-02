package i4;

import com.yalantis.ucrop.BuildConfig;
import j4.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f5136a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final List<String> f5137a = new ArrayList(20);

        public a a(String str, String str2) {
            q.a(str);
            q.b(str2, str);
            return c(str, str2);
        }

        /* access modifiers changed from: package-private */
        public a b(String str) {
            int indexOf = str.indexOf(":", 1);
            return indexOf != -1 ? c(str.substring(0, indexOf), str.substring(indexOf + 1)) : str.startsWith(":") ? c(BuildConfig.FLAVOR, str.substring(1)) : c(BuildConfig.FLAVOR, str);
        }

        /* access modifiers changed from: package-private */
        public a c(String str, String str2) {
            this.f5137a.add(str);
            this.f5137a.add(str2.trim());
            return this;
        }

        public q d() {
            return new q(this);
        }

        public a e(String str) {
            int i5 = 0;
            while (i5 < this.f5137a.size()) {
                if (str.equalsIgnoreCase(this.f5137a.get(i5))) {
                    this.f5137a.remove(i5);
                    this.f5137a.remove(i5);
                    i5 -= 2;
                }
                i5 += 2;
            }
            return this;
        }

        public a f(String str, String str2) {
            q.a(str);
            q.b(str2, str);
            e(str);
            c(str, str2);
            return this;
        }
    }

    q(a aVar) {
        List<String> list = aVar.f5137a;
        this.f5136a = (String[]) list.toArray(new String[list.size()]);
    }

    static void a(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (!str.isEmpty()) {
            int length = str.length();
            for (int i5 = 0; i5 < length; i5++) {
                char charAt = str.charAt(i5);
                if (charAt <= ' ' || charAt >= 127) {
                    throw new IllegalArgumentException(c.p("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i5), str));
                }
            }
        } else {
            throw new IllegalArgumentException("name is empty");
        }
    }

    static void b(String str, String str2) {
        if (str != null) {
            int length = str.length();
            int i5 = 0;
            while (i5 < length) {
                char charAt = str.charAt(i5);
                if ((charAt > 31 || charAt == 9) && charAt < 127) {
                    i5++;
                } else {
                    throw new IllegalArgumentException(c.p("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i5), str2, str));
                }
            }
            return;
        }
        throw new NullPointerException("value for name " + str2 + " == null");
    }

    private static String d(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    @Nullable
    public String c(String str) {
        return d(this.f5136a, str);
    }

    public String e(int i5) {
        return this.f5136a[i5 * 2];
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof q) && Arrays.equals(((q) obj).f5136a, this.f5136a);
    }

    public a f() {
        a aVar = new a();
        Collections.addAll(aVar.f5137a, this.f5136a);
        return aVar;
    }

    public int g() {
        return this.f5136a.length / 2;
    }

    public String h(int i5) {
        return this.f5136a[(i5 * 2) + 1];
    }

    public int hashCode() {
        return Arrays.hashCode(this.f5136a);
    }

    public List<String> i(String str) {
        int g5 = g();
        ArrayList arrayList = null;
        for (int i5 = 0; i5 < g5; i5++) {
            if (str.equalsIgnoreCase(e(i5))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(h(i5));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int g5 = g();
        for (int i5 = 0; i5 < g5; i5++) {
            sb.append(e(i5));
            sb.append(": ");
            sb.append(h(i5));
            sb.append("\n");
        }
        return sb.toString();
    }
}
