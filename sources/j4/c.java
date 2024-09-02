package j4;

import i4.a0;
import i4.q;
import i4.r;
import i4.t;
import i4.y;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import s4.f;
import s4.s;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f5475a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f5476b = new String[0];

    /* renamed from: c  reason: collision with root package name */
    public static final a0 f5477c;

    /* renamed from: d  reason: collision with root package name */
    public static final y f5478d;

    /* renamed from: e  reason: collision with root package name */
    private static final f f5479e = f.l("efbbbf");

    /* renamed from: f  reason: collision with root package name */
    private static final f f5480f = f.l("feff");

    /* renamed from: g  reason: collision with root package name */
    private static final f f5481g = f.l("fffe");

    /* renamed from: h  reason: collision with root package name */
    private static final f f5482h = f.l("0000ffff");

    /* renamed from: i  reason: collision with root package name */
    private static final f f5483i = f.l("ffff0000");

    /* renamed from: j  reason: collision with root package name */
    public static final Charset f5484j = Charset.forName("UTF-8");

    /* renamed from: k  reason: collision with root package name */
    public static final Charset f5485k = Charset.forName("ISO-8859-1");

    /* renamed from: l  reason: collision with root package name */
    private static final Charset f5486l = Charset.forName("UTF-16BE");

    /* renamed from: m  reason: collision with root package name */
    private static final Charset f5487m = Charset.forName("UTF-16LE");

    /* renamed from: n  reason: collision with root package name */
    private static final Charset f5488n = Charset.forName("UTF-32BE");

    /* renamed from: o  reason: collision with root package name */
    private static final Charset f5489o = Charset.forName("UTF-32LE");

    /* renamed from: p  reason: collision with root package name */
    public static final TimeZone f5490p = TimeZone.getTimeZone("GMT");

    /* renamed from: q  reason: collision with root package name */
    public static final Comparator<String> f5491q = new a();

    /* renamed from: r  reason: collision with root package name */
    private static final Method f5492r;

    /* renamed from: s  reason: collision with root package name */
    private static final Pattern f5493s = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    class a implements Comparator<String> {
        a() {
        }

        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    class b implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f5494e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f5495f;

        b(String str, boolean z4) {
            this.f5494e = str;
            this.f5495f = z4;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f5494e);
            thread.setDaemon(this.f5495f);
            return thread;
        }
    }

    static {
        byte[] bArr = new byte[0];
        f5475a = bArr;
        Method method = null;
        f5477c = a0.e((t) null, bArr);
        f5478d = y.c((t) null, bArr);
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});
        } catch (Exception unused) {
        }
        f5492r = method;
    }

    public static X509TrustManager A() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e5) {
            throw b("No System TLS", e5);
        }
    }

    public static boolean B(s sVar, int i5, TimeUnit timeUnit) {
        long nanoTime = System.nanoTime();
        long c5 = sVar.c().e() ? sVar.c().c() - nanoTime : Long.MAX_VALUE;
        sVar.c().d(Math.min(c5, timeUnit.toNanos((long) i5)) + nanoTime);
        try {
            s4.c cVar = new s4.c();
            while (sVar.K(cVar, 8192) != -1) {
                cVar.b();
            }
            int i6 = (c5 > Long.MAX_VALUE ? 1 : (c5 == Long.MAX_VALUE ? 0 : -1));
            s4.t c6 = sVar.c();
            if (i6 == 0) {
                c6.a();
            } else {
                c6.d(nanoTime + c5);
            }
            return true;
        } catch (InterruptedIOException unused) {
            int i7 = (c5 > Long.MAX_VALUE ? 1 : (c5 == Long.MAX_VALUE ? 0 : -1));
            s4.t c7 = sVar.c();
            if (i7 == 0) {
                c7.a();
            } else {
                c7.d(nanoTime + c5);
            }
            return false;
        } catch (Throwable th) {
            int i8 = (c5 > Long.MAX_VALUE ? 1 : (c5 == Long.MAX_VALUE ? 0 : -1));
            s4.t c8 = sVar.c();
            if (i8 == 0) {
                c8.a();
            } else {
                c8.d(nanoTime + c5);
            }
            throw th;
        }
    }

    public static int C(String str, int i5, int i6) {
        while (i5 < i6) {
            char charAt = str.charAt(i5);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i5;
            }
            i5++;
        }
        return i6;
    }

    public static int D(String str, int i5, int i6) {
        for (int i7 = i6 - 1; i7 >= i5; i7--) {
            char charAt = str.charAt(i7);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i7 + 1;
            }
        }
        return i5;
    }

    public static ThreadFactory E(String str, boolean z4) {
        return new b(str, z4);
    }

    public static q F(List<o4.c> list) {
        q.a aVar = new q.a();
        for (o4.c next : list) {
            a.f5473a.b(aVar, next.f6181a.B(), next.f6182b.B());
        }
        return aVar.d();
    }

    public static String G(String str, int i5, int i6) {
        int C = C(str, i5, i6);
        return str.substring(C, D(str, C, i6));
    }

    public static boolean H(String str) {
        return f5493s.matcher(str).matches();
    }

    public static void a(Throwable th, Throwable th2) {
        Method method = f5492r;
        if (method != null) {
            try {
                method.invoke(th, new Object[]{th2});
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    public static AssertionError b(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    public static String c(String str) {
        if (str.contains(":")) {
            InetAddress k5 = (!str.startsWith("[") || !str.endsWith("]")) ? k(str, 0, str.length()) : k(str, 1, str.length() - 1);
            if (k5 == null) {
                return null;
            }
            byte[] address = k5.getAddress();
            if (address.length == 16) {
                return w(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (!lowerCase.isEmpty() && !h(lowerCase)) {
                return lowerCase;
            }
            return null;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static void d(long j5, long j6, long j7) {
        if ((j6 | j7) < 0 || j6 > j5 || j5 - j6 < j7) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void e(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e5) {
                throw e5;
            } catch (Exception unused) {
            }
        }
    }

    public static void f(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e5) {
                if (!y(e5)) {
                    throw e5;
                }
            } catch (RuntimeException e6) {
                if (!"bio == null".equals(e6.getMessage())) {
                    throw e6;
                }
            } catch (Exception unused) {
            }
        }
    }

    public static String[] g(String[] strArr, String str) {
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        return strArr2;
    }

    private static boolean h(String str) {
        for (int i5 = 0; i5 < str.length(); i5++) {
            char charAt = str.charAt(i5);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int i(char c5) {
        if (c5 >= '0' && c5 <= '9') {
            return c5 - '0';
        }
        char c6 = 'a';
        if (c5 < 'a' || c5 > 'f') {
            c6 = 'A';
            if (c5 < 'A' || c5 > 'F') {
                return -1;
            }
        }
        return (c5 - c6) + 10;
    }

    private static boolean j(String str, int i5, int i6, byte[] bArr, int i7) {
        int i8 = i7;
        while (i5 < i6) {
            if (i8 == bArr.length) {
                return false;
            }
            if (i8 != i7) {
                if (str.charAt(i5) != '.') {
                    return false;
                }
                i5++;
            }
            int i9 = i5;
            int i10 = 0;
            while (i9 < i6) {
                char charAt = str.charAt(i9);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if ((i10 == 0 && i5 != i9) || (i10 = ((i10 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i9++;
                }
            }
            if (i9 - i5 == 0) {
                return false;
            }
            bArr[i8] = (byte) i10;
            i8++;
            i5 = i9;
        }
        return i8 == i7 + 4;
    }

    @Nullable
    private static InetAddress k(String str, int i5, int i6) {
        byte[] bArr = new byte[16];
        int i7 = -1;
        int i8 = -1;
        int i9 = 0;
        while (true) {
            if (i5 >= i6) {
                break;
            } else if (i9 == 16) {
                return null;
            } else {
                int i10 = i5 + 2;
                if (i10 > i6 || !str.regionMatches(i5, "::", 0, 2)) {
                    if (i9 != 0) {
                        if (str.regionMatches(i5, ":", 0, 1)) {
                            i5++;
                        } else if (!str.regionMatches(i5, ".", 0, 1) || !j(str, i8, i6, bArr, i9 - 2)) {
                            return null;
                        } else {
                            i9 += 2;
                        }
                    }
                    i8 = i5;
                } else if (i7 != -1) {
                    return null;
                } else {
                    i9 += 2;
                    i7 = i9;
                    if (i10 == i6) {
                        break;
                    }
                    i8 = i10;
                }
                int i11 = 0;
                i5 = i8;
                while (i5 < i6) {
                    int i12 = i(str.charAt(i5));
                    if (i12 == -1) {
                        break;
                    }
                    i11 = (i11 << 4) + i12;
                    i5++;
                }
                int i13 = i5 - i8;
                if (i13 == 0 || i13 > 4) {
                    return null;
                }
                int i14 = i9 + 1;
                bArr[i9] = (byte) ((i11 >>> 8) & 255);
                i9 = i14 + 1;
                bArr[i14] = (byte) (i11 & 255);
            }
        }
        if (i9 != 16) {
            if (i7 == -1) {
                return null;
            }
            int i15 = i9 - i7;
            System.arraycopy(bArr, i7, bArr, 16 - i15, i15);
            Arrays.fill(bArr, i7, (16 - i9) + i7, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    public static int l(String str, int i5, int i6, char c5) {
        while (i5 < i6) {
            if (str.charAt(i5) == c5) {
                return i5;
            }
            i5++;
        }
        return i6;
    }

    public static int m(String str, int i5, int i6, String str2) {
        while (i5 < i6) {
            if (str2.indexOf(str.charAt(i5)) != -1) {
                return i5;
            }
            i5++;
        }
        return i6;
    }

    public static boolean n(s sVar, int i5, TimeUnit timeUnit) {
        try {
            return B(sVar, i5, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean o(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static String p(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String q(r rVar, boolean z4) {
        String str;
        if (rVar.l().contains(":")) {
            str = "[" + rVar.l() + "]";
        } else {
            str = rVar.l();
        }
        if (!z4 && rVar.w() == r.d(rVar.B())) {
            return str;
        }
        return str + ":" + rVar.w();
    }

    public static <T> List<T> r(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> s(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static <K, V> Map<K, V> t(Map<K, V> map) {
        return map.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static int u(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (comparator.compare(strArr[i5], str) == 0) {
                return i5;
            }
        }
        return -1;
    }

    public static int v(String str) {
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            char charAt = str.charAt(i5);
            if (charAt <= 31 || charAt >= 127) {
                return i5;
            }
        }
        return -1;
    }

    private static String w(byte[] bArr) {
        int i5 = 0;
        int i6 = -1;
        int i7 = 0;
        int i8 = 0;
        while (i7 < bArr.length) {
            int i9 = i7;
            while (i9 < 16 && bArr[i9] == 0 && bArr[i9 + 1] == 0) {
                i9 += 2;
            }
            int i10 = i9 - i7;
            if (i10 > i8 && i10 >= 4) {
                i6 = i7;
                i8 = i10;
            }
            i7 = i9 + 2;
        }
        s4.c cVar = new s4.c();
        while (i5 < bArr.length) {
            if (i5 == i6) {
                cVar.writeByte(58);
                i5 += i8;
                if (i5 == 16) {
                    cVar.writeByte(58);
                }
            } else {
                if (i5 > 0) {
                    cVar.writeByte(58);
                }
                cVar.i((long) (((bArr[i5] & 255) << 8) | (bArr[i5 + 1] & 255)));
                i5 += 2;
            }
        }
        return cVar.q();
    }

    public static String[] x(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i5]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i5++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean y(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean z(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0)) {
            for (String str : strArr) {
                for (String compare : strArr2) {
                    if (comparator.compare(str, compare) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
