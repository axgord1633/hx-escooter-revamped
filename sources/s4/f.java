package s4;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class f implements Serializable, Comparable<f> {

    /* renamed from: h  reason: collision with root package name */
    static final char[] f6760h = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: i  reason: collision with root package name */
    public static final f f6761i = r(new byte[0]);

    /* renamed from: e  reason: collision with root package name */
    final byte[] f6762e;

    /* renamed from: f  reason: collision with root package name */
    transient int f6763f;

    /* renamed from: g  reason: collision with root package name */
    transient String f6764g;

    f(byte[] bArr) {
        this.f6762e = bArr;
    }

    static int f(String str, int i5) {
        int length = str.length();
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            if (i7 == i5) {
                return i6;
            }
            int codePointAt = str.codePointAt(i6);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i7++;
            i6 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    public static f l(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i5 = 0; i5 < length; i5++) {
                int i6 = i5 * 2;
                bArr[i5] = (byte) ((m(str.charAt(i6)) << 4) + m(str.charAt(i6 + 1)));
            }
            return r(bArr);
        } else {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
    }

    private static int m(char c5) {
        if (c5 >= '0' && c5 <= '9') {
            return c5 - '0';
        }
        char c6 = 'a';
        if (c5 < 'a' || c5 > 'f') {
            c6 = 'A';
            if (c5 < 'A' || c5 > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: " + c5);
            }
        }
        return (c5 - c6) + 10;
    }

    private f n(String str) {
        try {
            return r(MessageDigest.getInstance(str).digest(this.f6762e));
        } catch (NoSuchAlgorithmException e5) {
            throw new AssertionError(e5);
        }
    }

    public static f o(String str) {
        if (str != null) {
            f fVar = new f(str.getBytes(u.f6804a));
            fVar.f6764g = str;
            return fVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public static f r(byte... bArr) {
        if (bArr != null) {
            return new f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public byte[] A() {
        return (byte[]) this.f6762e.clone();
    }

    public String B() {
        String str = this.f6764g;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f6762e, u.f6804a);
        this.f6764g = str2;
        return str2;
    }

    /* access modifiers changed from: package-private */
    public void C(c cVar) {
        byte[] bArr = this.f6762e;
        cVar.write(bArr, 0, bArr.length);
    }

    public String c() {
        return b.a(this.f6762e);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            int w4 = fVar.w();
            byte[] bArr = this.f6762e;
            if (w4 == bArr.length && fVar.t(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i5 = this.f6763f;
        if (i5 != 0) {
            return i5;
        }
        int hashCode = Arrays.hashCode(this.f6762e);
        this.f6763f = hashCode;
        return hashCode;
    }

    /* renamed from: i */
    public int compareTo(f fVar) {
        int w4 = w();
        int w5 = fVar.w();
        int min = Math.min(w4, w5);
        for (int i5 = 0; i5 < min; i5++) {
            byte p5 = p(i5) & 255;
            byte p6 = fVar.p(i5) & 255;
            if (p5 != p6) {
                return p5 < p6 ? -1 : 1;
            }
        }
        if (w4 == w5) {
            return 0;
        }
        return w4 < w5 ? -1 : 1;
    }

    public byte p(int i5) {
        return this.f6762e[i5];
    }

    public String q() {
        byte[] bArr = this.f6762e;
        char[] cArr = new char[(bArr.length * 2)];
        int i5 = 0;
        for (byte b5 : bArr) {
            int i6 = i5 + 1;
            char[] cArr2 = f6760h;
            cArr[i5] = cArr2[(b5 >> 4) & 15];
            i5 = i6 + 1;
            cArr[i6] = cArr2[b5 & 15];
        }
        return new String(cArr);
    }

    public boolean s(int i5, f fVar, int i6, int i7) {
        return fVar.t(i6, this.f6762e, i5, i7);
    }

    public boolean t(int i5, byte[] bArr, int i6, int i7) {
        if (i5 >= 0) {
            byte[] bArr2 = this.f6762e;
            return i5 <= bArr2.length - i7 && i6 >= 0 && i6 <= bArr.length - i7 && u.a(bArr2, i5, bArr, i6, i7);
        }
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2;
        if (this.f6762e.length == 0) {
            return "[size=0]";
        }
        String B = B();
        int f5 = f(B, 64);
        if (f5 == -1) {
            if (this.f6762e.length <= 64) {
                sb2 = new StringBuilder();
                sb2.append("[hex=");
                sb2.append(q());
                sb2.append("]");
            } else {
                sb2 = new StringBuilder();
                sb2.append("[size=");
                sb2.append(this.f6762e.length);
                sb2.append(" hex=");
                sb2.append(y(0, 64).q());
                sb2.append("…]");
            }
            return sb2.toString();
        }
        String replace = B.substring(0, f5).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (f5 < B.length()) {
            sb = new StringBuilder();
            sb.append("[size=");
            sb.append(this.f6762e.length);
            sb.append(" text=");
            sb.append(replace);
            sb.append("…]");
        } else {
            sb = new StringBuilder();
            sb.append("[text=");
            sb.append(replace);
            sb.append("]");
        }
        return sb.toString();
    }

    public f u() {
        return n("SHA-1");
    }

    public f v() {
        return n("SHA-256");
    }

    public int w() {
        return this.f6762e.length;
    }

    public final boolean x(f fVar) {
        return s(0, fVar, 0, fVar.w());
    }

    public f y(int i5, int i6) {
        if (i5 >= 0) {
            byte[] bArr = this.f6762e;
            if (i6 <= bArr.length) {
                int i7 = i6 - i5;
                if (i7 < 0) {
                    throw new IllegalArgumentException("endIndex < beginIndex");
                } else if (i5 == 0 && i6 == bArr.length) {
                    return this;
                } else {
                    byte[] bArr2 = new byte[i7];
                    System.arraycopy(bArr, i5, bArr2, 0, i7);
                    return new f(bArr2);
                }
            } else {
                throw new IllegalArgumentException("endIndex > length(" + this.f6762e.length + ")");
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0");
        }
    }

    public f z() {
        int i5 = 0;
        while (true) {
            byte[] bArr = this.f6762e;
            if (i5 >= bArr.length) {
                return this;
            }
            byte b5 = bArr[i5];
            if (b5 < 65 || b5 > 90) {
                i5++;
            } else {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i5] = (byte) (b5 + 32);
                for (int i6 = i5 + 1; i6 < bArr2.length; i6++) {
                    byte b6 = bArr2[i6];
                    if (b6 >= 65 && b6 <= 90) {
                        bArr2[i6] = (byte) (b6 + 32);
                    }
                }
                return new f(bArr2);
            }
        }
    }
}
