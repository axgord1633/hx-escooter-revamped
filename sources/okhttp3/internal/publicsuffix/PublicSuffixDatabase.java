package okhttp3.internal.publicsuffix;

import j4.c;
import java.io.InputStream;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import s4.e;
import s4.j;
import s4.l;

public final class PublicSuffixDatabase {

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f6336e = {42};

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f6337f = new String[0];

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f6338g = {"*"};

    /* renamed from: h  reason: collision with root package name */
    private static final PublicSuffixDatabase f6339h = new PublicSuffixDatabase();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f6340a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private final CountDownLatch f6341b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    private byte[] f6342c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f6343d;

    private static String a(byte[] bArr, byte[][] bArr2, int i5) {
        int i6;
        boolean z4;
        byte b5;
        int i7;
        byte[] bArr3 = bArr;
        byte[][] bArr4 = bArr2;
        int length = bArr3.length;
        int i8 = 0;
        while (i8 < length) {
            int i9 = (i8 + length) / 2;
            while (i9 > -1 && bArr3[i9] != 10) {
                i9--;
            }
            int i10 = i9 + 1;
            int i11 = 1;
            while (true) {
                i6 = i10 + i11;
                if (bArr3[i6] == 10) {
                    break;
                }
                i11++;
            }
            int i12 = i6 - i10;
            int i13 = i5;
            boolean z5 = false;
            int i14 = 0;
            int i15 = 0;
            while (true) {
                if (z5) {
                    b5 = 46;
                    z4 = false;
                } else {
                    z4 = z5;
                    b5 = bArr4[i13][i14] & 255;
                }
                i7 = b5 - (bArr3[i10 + i15] & 255);
                if (i7 == 0) {
                    i15++;
                    i14++;
                    if (i15 == i12) {
                        break;
                    } else if (bArr4[i13].length != i14) {
                        z5 = z4;
                    } else if (i13 == bArr4.length - 1) {
                        break;
                    } else {
                        i13++;
                        i14 = -1;
                        z5 = true;
                    }
                } else {
                    break;
                }
            }
            if (i7 >= 0) {
                if (i7 <= 0) {
                    int i16 = i12 - i15;
                    int length2 = bArr4[i13].length - i14;
                    while (true) {
                        i13++;
                        if (i13 >= bArr4.length) {
                            break;
                        }
                        length2 += bArr4[i13].length;
                    }
                    if (length2 >= i16) {
                        if (length2 <= i16) {
                            return new String(bArr3, i10, i12, c.f5484j);
                        }
                    }
                }
                i8 = i6 + 1;
            }
            length = i10 - 1;
        }
        return null;
    }

    private String[] b(String[] strArr) {
        String str;
        String str2;
        String str3;
        int i5 = 0;
        if (this.f6340a.get() || !this.f6340a.compareAndSet(false, true)) {
            try {
                this.f6341b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            f();
        }
        synchronized (this) {
            if (this.f6342c == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i6 = 0; i6 < strArr.length; i6++) {
            bArr[i6] = strArr[i6].getBytes(c.f5484j);
        }
        int i7 = 0;
        while (true) {
            str = null;
            if (i7 >= length) {
                str2 = null;
                break;
            }
            str2 = a(this.f6342c, bArr, i7);
            if (str2 != null) {
                break;
            }
            i7++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            int i8 = 0;
            while (true) {
                if (i8 >= bArr2.length - 1) {
                    break;
                }
                bArr2[i8] = f6336e;
                str3 = a(this.f6342c, bArr2, i8);
                if (str3 != null) {
                    break;
                }
                i8++;
            }
        }
        str3 = null;
        if (str3 != null) {
            while (true) {
                if (i5 >= length - 1) {
                    break;
                }
                String a5 = a(this.f6343d, bArr, i5);
                if (a5 != null) {
                    str = a5;
                    break;
                }
                i5++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        } else if (str2 == null && str3 == null) {
            return f6338g;
        } else {
            String[] split = str2 != null ? str2.split("\\.") : f6337f;
            String[] split2 = str3 != null ? str3.split("\\.") : f6337f;
            return split.length > split2.length ? split : split2;
        }
    }

    public static PublicSuffixDatabase c() {
        return f6339h;
    }

    private void e() {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream != null) {
            e b5 = l.b(new j(l.g(resourceAsStream)));
            try {
                byte[] bArr = new byte[b5.readInt()];
                b5.readFully(bArr);
                byte[] bArr2 = new byte[b5.readInt()];
                b5.readFully(bArr2);
                synchronized (this) {
                    this.f6342c = bArr;
                    this.f6343d = bArr2;
                }
                this.f6341b.countDown();
            } finally {
                c.e(b5);
            }
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f() {
        /*
            r5 = this;
            r0 = 0
        L_0x0001:
            r5.e()     // Catch:{ InterruptedIOException -> 0x0025, IOException -> 0x0010 }
            if (r0 == 0) goto L_0x000d
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x000d:
            return
        L_0x000e:
            r1 = move-exception
            goto L_0x002a
        L_0x0010:
            r1 = move-exception
            p4.i r2 = p4.i.l()     // Catch:{ all -> 0x000e }
            r3 = 5
            java.lang.String r4 = "Failed to read public suffix list"
            r2.s(r3, r4, r1)     // Catch:{ all -> 0x000e }
            if (r0 == 0) goto L_0x0024
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0024:
            return
        L_0x0025:
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x000e }
            r0 = 1
            goto L_0x0001
        L_0x002a:
            if (r0 == 0) goto L_0x0033
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0033:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.f():void");
    }

    public String d(String str) {
        if (str != null) {
            String[] split = IDN.toUnicode(str).split("\\.");
            String[] b5 = b(split);
            if (split.length == b5.length && b5[0].charAt(0) != '!') {
                return null;
            }
            char charAt = b5[0].charAt(0);
            int length = split.length;
            int length2 = b5.length;
            if (charAt != '!') {
                length2++;
            }
            StringBuilder sb = new StringBuilder();
            String[] split2 = str.split("\\.");
            for (int i5 = length - length2; i5 < split2.length; i5++) {
                sb.append(split2[i5]);
                sb.append('.');
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        throw new NullPointerException("domain == null");
    }
}
