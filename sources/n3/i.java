package n3;

import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import kotlin.jvm.internal.k;

class i extends h {

    public static final class a extends b<Byte> implements RandomAccess {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ byte[] f6077f;

        a(byte[] bArr) {
            this.f6077f = bArr;
        }

        public int c() {
            return this.f6077f.length;
        }

        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof Byte)) {
                return false;
            }
            return e(((Number) obj).byteValue());
        }

        public boolean e(byte b5) {
            return j.h(this.f6077f, b5);
        }

        /* renamed from: f */
        public Byte get(int i5) {
            return Byte.valueOf(this.f6077f[i5]);
        }

        public int i(byte b5) {
            return j.n(this.f6077f, b5);
        }

        public final /* bridge */ int indexOf(Object obj) {
            if (!(obj instanceof Byte)) {
                return -1;
            }
            return i(((Number) obj).byteValue());
        }

        public boolean isEmpty() {
            return this.f6077f.length == 0;
        }

        public int l(byte b5) {
            return j.s(this.f6077f, b5);
        }

        public final /* bridge */ int lastIndexOf(Object obj) {
            if (!(obj instanceof Byte)) {
                return -1;
            }
            return l(((Number) obj).byteValue());
        }
    }

    public static List<Byte> b(byte[] bArr) {
        k.e(bArr, "<this>");
        return new a(bArr);
    }

    public static <T> List<T> c(T[] tArr) {
        k.e(tArr, "<this>");
        List<T> a5 = k.a(tArr);
        k.d(a5, "asList(this)");
        return a5;
    }

    public static final <T> T[] d(T[] tArr, T[] tArr2, int i5, int i6, int i7) {
        k.e(tArr, "<this>");
        k.e(tArr2, "destination");
        System.arraycopy(tArr, i6, tArr2, i5, i7 - i6);
        return tArr2;
    }

    public static /* synthetic */ Object[] e(Object[] objArr, Object[] objArr2, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i5 = 0;
        }
        if ((i8 & 4) != 0) {
            i6 = 0;
        }
        if ((i8 & 8) != 0) {
            i7 = objArr.length;
        }
        return d(objArr, objArr2, i5, i6, i7);
    }

    public static <T> void f(T[] tArr, T t5, int i5, int i6) {
        k.e(tArr, "<this>");
        Arrays.fill(tArr, i5, i6, t5);
    }

    public static /* synthetic */ void g(Object[] objArr, Object obj, int i5, int i6, int i7, Object obj2) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            i6 = objArr.length;
        }
        f(objArr, obj, i5, i6);
    }
}
