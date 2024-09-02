package androidx.profileinstaller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Map;
import java.util.TreeMap;

class o {

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f2675a = {112, 114, 111, 0};

    /* renamed from: b  reason: collision with root package name */
    static final byte[] f2676b = {112, 114, 109, 0};

    private static void A(InputStream inputStream) {
        f.h(inputStream);
        int j5 = f.j(inputStream);
        if (j5 != 6 && j5 != 7) {
            while (j5 > 0) {
                f.j(inputStream);
                for (int j6 = f.j(inputStream); j6 > 0; j6--) {
                    f.h(inputStream);
                }
                j5--;
            }
        }
    }

    static boolean B(OutputStream outputStream, byte[] bArr, e[] eVarArr) {
        if (Arrays.equals(bArr, q.f2687a)) {
            N(outputStream, eVarArr);
            return true;
        } else if (Arrays.equals(bArr, q.f2688b)) {
            M(outputStream, eVarArr);
            return true;
        } else if (Arrays.equals(bArr, q.f2690d)) {
            K(outputStream, eVarArr);
            return true;
        } else if (Arrays.equals(bArr, q.f2689c)) {
            L(outputStream, eVarArr);
            return true;
        } else if (!Arrays.equals(bArr, q.f2691e)) {
            return false;
        } else {
            J(outputStream, eVarArr);
            return true;
        }
    }

    private static void C(OutputStream outputStream, e eVar) {
        int i5 = 0;
        for (int valueOf : eVar.f2656h) {
            Integer valueOf2 = Integer.valueOf(valueOf);
            f.p(outputStream, valueOf2.intValue() - i5);
            i5 = valueOf2.intValue();
        }
    }

    private static r D(e[] eVarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f.p(byteArrayOutputStream, eVarArr.length);
            int i5 = 2;
            for (e eVar : eVarArr) {
                f.q(byteArrayOutputStream, eVar.f2651c);
                f.q(byteArrayOutputStream, eVar.f2652d);
                f.q(byteArrayOutputStream, (long) eVar.f2655g);
                String j5 = j(eVar.f2649a, eVar.f2650b, q.f2687a);
                int k5 = f.k(j5);
                f.p(byteArrayOutputStream, k5);
                i5 = i5 + 4 + 4 + 4 + 2 + (k5 * 1);
                f.n(byteArrayOutputStream, j5);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i5 == byteArray.length) {
                r rVar = new r(g.DEX_FILES, i5, byteArray, false);
                byteArrayOutputStream.close();
                return rVar;
            }
            throw f.c("Expected size " + i5 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    static void E(OutputStream outputStream, byte[] bArr) {
        outputStream.write(f2675a);
        outputStream.write(bArr);
    }

    private static void F(OutputStream outputStream, e eVar) {
        I(outputStream, eVar);
        C(outputStream, eVar);
        H(outputStream, eVar);
    }

    private static void G(OutputStream outputStream, e eVar, String str) {
        f.p(outputStream, f.k(str));
        f.p(outputStream, eVar.f2653e);
        f.q(outputStream, (long) eVar.f2654f);
        f.q(outputStream, eVar.f2651c);
        f.q(outputStream, (long) eVar.f2655g);
        f.n(outputStream, str);
    }

    private static void H(OutputStream outputStream, e eVar) {
        byte[] bArr = new byte[k(eVar.f2655g)];
        for (Map.Entry next : eVar.f2657i.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            int intValue2 = ((Integer) next.getValue()).intValue();
            if ((intValue2 & 2) != 0) {
                z(bArr, 2, intValue, eVar);
            }
            if ((intValue2 & 4) != 0) {
                z(bArr, 4, intValue, eVar);
            }
        }
        outputStream.write(bArr);
    }

    private static void I(OutputStream outputStream, e eVar) {
        int i5 = 0;
        for (Map.Entry next : eVar.f2657i.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            if ((((Integer) next.getValue()).intValue() & 1) != 0) {
                f.p(outputStream, intValue - i5);
                f.p(outputStream, 0);
                i5 = intValue;
            }
        }
    }

    private static void J(OutputStream outputStream, e[] eVarArr) {
        f.p(outputStream, eVarArr.length);
        for (e eVar : eVarArr) {
            String j5 = j(eVar.f2649a, eVar.f2650b, q.f2691e);
            f.p(outputStream, f.k(j5));
            f.p(outputStream, eVar.f2657i.size());
            f.p(outputStream, eVar.f2656h.length);
            f.q(outputStream, eVar.f2651c);
            f.n(outputStream, j5);
            for (Integer intValue : eVar.f2657i.keySet()) {
                f.p(outputStream, intValue.intValue());
            }
            for (int p5 : eVar.f2656h) {
                f.p(outputStream, p5);
            }
        }
    }

    private static void K(OutputStream outputStream, e[] eVarArr) {
        f.r(outputStream, eVarArr.length);
        for (e eVar : eVarArr) {
            String j5 = j(eVar.f2649a, eVar.f2650b, q.f2690d);
            f.p(outputStream, f.k(j5));
            f.p(outputStream, eVar.f2656h.length);
            f.q(outputStream, (long) (eVar.f2657i.size() * 4));
            f.q(outputStream, eVar.f2651c);
            f.n(outputStream, j5);
            for (Integer intValue : eVar.f2657i.keySet()) {
                f.p(outputStream, intValue.intValue());
                f.p(outputStream, 0);
            }
            for (int p5 : eVar.f2656h) {
                f.p(outputStream, p5);
            }
        }
    }

    private static void L(OutputStream outputStream, e[] eVarArr) {
        byte[] b5 = b(eVarArr, q.f2689c);
        f.r(outputStream, eVarArr.length);
        f.m(outputStream, b5);
    }

    private static void M(OutputStream outputStream, e[] eVarArr) {
        byte[] b5 = b(eVarArr, q.f2688b);
        f.r(outputStream, eVarArr.length);
        f.m(outputStream, b5);
    }

    private static void N(OutputStream outputStream, e[] eVarArr) {
        O(outputStream, eVarArr);
    }

    private static void O(OutputStream outputStream, e[] eVarArr) {
        int i5;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(D(eVarArr));
        arrayList.add(c(eVarArr));
        arrayList.add(d(eVarArr));
        long length = ((long) q.f2687a.length) + ((long) f2675a.length) + 4 + ((long) (arrayList.size() * 16));
        f.q(outputStream, (long) arrayList.size());
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            r rVar = (r) arrayList.get(i6);
            f.q(outputStream, rVar.f2694a.f());
            f.q(outputStream, length);
            if (rVar.f2697d) {
                byte[] bArr = rVar.f2696c;
                byte[] b5 = f.b(bArr);
                arrayList2.add(b5);
                f.q(outputStream, (long) b5.length);
                f.q(outputStream, (long) bArr.length);
                i5 = b5.length;
            } else {
                arrayList2.add(rVar.f2696c);
                f.q(outputStream, (long) rVar.f2696c.length);
                f.q(outputStream, 0);
                i5 = rVar.f2696c.length;
            }
            length += (long) i5;
        }
        for (int i7 = 0; i7 < arrayList2.size(); i7++) {
            outputStream.write((byte[]) arrayList2.get(i7));
        }
    }

    private static int a(e eVar) {
        int i5 = 0;
        for (Map.Entry<Integer, Integer> value : eVar.f2657i.entrySet()) {
            i5 |= ((Integer) value.getValue()).intValue();
        }
        return i5;
    }

    private static byte[] b(e[] eVarArr, byte[] bArr) {
        int i5 = 0;
        int i6 = 0;
        for (e eVar : eVarArr) {
            i6 += f.k(j(eVar.f2649a, eVar.f2650b, bArr)) + 16 + (eVar.f2653e * 2) + eVar.f2654f + k(eVar.f2655g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i6);
        if (Arrays.equals(bArr, q.f2689c)) {
            int length = eVarArr.length;
            while (i5 < length) {
                e eVar2 = eVarArr[i5];
                G(byteArrayOutputStream, eVar2, j(eVar2.f2649a, eVar2.f2650b, bArr));
                F(byteArrayOutputStream, eVar2);
                i5++;
            }
        } else {
            for (e eVar3 : eVarArr) {
                G(byteArrayOutputStream, eVar3, j(eVar3.f2649a, eVar3.f2650b, bArr));
            }
            int length2 = eVarArr.length;
            while (i5 < length2) {
                F(byteArrayOutputStream, eVarArr[i5]);
                i5++;
            }
        }
        if (byteArrayOutputStream.size() == i6) {
            return byteArrayOutputStream.toByteArray();
        }
        throw f.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + i6);
    }

    private static r c(e[] eVarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i5 = 0;
        int i6 = 0;
        while (i5 < eVarArr.length) {
            try {
                e eVar = eVarArr[i5];
                f.p(byteArrayOutputStream, i5);
                f.p(byteArrayOutputStream, eVar.f2653e);
                i6 = i6 + 2 + 2 + (eVar.f2653e * 2);
                C(byteArrayOutputStream, eVar);
                i5++;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i6 == byteArray.length) {
            r rVar = new r(g.CLASSES, i6, byteArray, true);
            byteArrayOutputStream.close();
            return rVar;
        }
        throw f.c("Expected size " + i6 + ", does not match actual size " + byteArray.length);
        throw th;
    }

    private static r d(e[] eVarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i5 = 0;
        int i6 = 0;
        while (i5 < eVarArr.length) {
            try {
                e eVar = eVarArr[i5];
                int a5 = a(eVar);
                byte[] e5 = e(eVar);
                byte[] f5 = f(eVar);
                f.p(byteArrayOutputStream, i5);
                int length = e5.length + 2 + f5.length;
                f.q(byteArrayOutputStream, (long) length);
                f.p(byteArrayOutputStream, a5);
                byteArrayOutputStream.write(e5);
                byteArrayOutputStream.write(f5);
                i6 = i6 + 2 + 4 + length;
                i5++;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i6 == byteArray.length) {
            r rVar = new r(g.METHODS, i6, byteArray, true);
            byteArrayOutputStream.close();
            return rVar;
        }
        throw f.c("Expected size " + i6 + ", does not match actual size " + byteArray.length);
        throw th;
    }

    private static byte[] e(e eVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            H(byteArrayOutputStream, eVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private static byte[] f(e eVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            I(byteArrayOutputStream, eVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private static String g(String str, String str2) {
        return "!".equals(str2) ? str.replace(":", "!") : ":".equals(str2) ? str.replace("!", ":") : str;
    }

    private static String h(String str) {
        int indexOf = str.indexOf("!");
        if (indexOf < 0) {
            indexOf = str.indexOf(":");
        }
        return indexOf > 0 ? str.substring(indexOf + 1) : str;
    }

    private static e i(e[] eVarArr, String str) {
        if (eVarArr.length <= 0) {
            return null;
        }
        String h5 = h(str);
        for (int i5 = 0; i5 < eVarArr.length; i5++) {
            if (eVarArr[i5].f2650b.equals(h5)) {
                return eVarArr[i5];
            }
        }
        return null;
    }

    private static String j(String str, String str2, byte[] bArr) {
        String a5 = q.a(bArr);
        if (str.length() <= 0) {
            return g(str2, a5);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            return g(str2, a5);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + q.a(bArr) + str2;
    }

    private static int k(int i5) {
        return y(i5 * 2) / 8;
    }

    private static int l(int i5, int i6, int i7) {
        if (i5 == 1) {
            throw f.c("HOT methods are not stored in the bitmap");
        } else if (i5 == 2) {
            return i6;
        } else {
            if (i5 == 4) {
                return i6 + i7;
            }
            throw f.c("Unexpected flag: " + i5);
        }
    }

    private static int[] m(InputStream inputStream, int i5) {
        int[] iArr = new int[i5];
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 += f.h(inputStream);
            iArr[i7] = i6;
        }
        return iArr;
    }

    private static int n(BitSet bitSet, int i5, int i6) {
        int i7 = 2;
        if (!bitSet.get(l(2, i5, i6))) {
            i7 = 0;
        }
        return bitSet.get(l(4, i5, i6)) ? i7 | 4 : i7;
    }

    static byte[] o(InputStream inputStream, byte[] bArr) {
        if (Arrays.equals(bArr, f.d(inputStream, bArr.length))) {
            return f.d(inputStream, q.f2688b.length);
        }
        throw f.c("Invalid magic");
    }

    private static void p(InputStream inputStream, e eVar) {
        int available = inputStream.available() - eVar.f2654f;
        int i5 = 0;
        while (inputStream.available() > available) {
            i5 += f.h(inputStream);
            eVar.f2657i.put(Integer.valueOf(i5), 1);
            for (int h5 = f.h(inputStream); h5 > 0; h5--) {
                A(inputStream);
            }
        }
        if (inputStream.available() != available) {
            throw f.c("Read too much data during profile line parse");
        }
    }

    static e[] q(InputStream inputStream, byte[] bArr, byte[] bArr2, e[] eVarArr) {
        if (Arrays.equals(bArr, q.f2692f)) {
            if (!Arrays.equals(q.f2687a, bArr2)) {
                return r(inputStream, bArr, eVarArr);
            }
            throw f.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        } else if (Arrays.equals(bArr, q.f2693g)) {
            return t(inputStream, bArr2, eVarArr);
        } else {
            throw f.c("Unsupported meta version");
        }
    }

    static e[] r(InputStream inputStream, byte[] bArr, e[] eVarArr) {
        if (Arrays.equals(bArr, q.f2692f)) {
            int j5 = f.j(inputStream);
            byte[] e5 = f.e(inputStream, (int) f.i(inputStream), (int) f.i(inputStream));
            if (inputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e5);
                try {
                    e[] s5 = s(byteArrayInputStream, j5, eVarArr);
                    byteArrayInputStream.close();
                    return s5;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } else {
                throw f.c("Content found after the end of file");
            }
        } else {
            throw f.c("Unsupported meta version");
        }
        throw th;
    }

    private static e[] s(InputStream inputStream, int i5, e[] eVarArr) {
        int i6 = 0;
        if (inputStream.available() == 0) {
            return new e[0];
        }
        if (i5 == eVarArr.length) {
            String[] strArr = new String[i5];
            int[] iArr = new int[i5];
            for (int i7 = 0; i7 < i5; i7++) {
                int h5 = f.h(inputStream);
                iArr[i7] = f.h(inputStream);
                strArr[i7] = f.f(inputStream, h5);
            }
            while (i6 < i5) {
                e eVar = eVarArr[i6];
                if (eVar.f2650b.equals(strArr[i6])) {
                    int i8 = iArr[i6];
                    eVar.f2653e = i8;
                    eVar.f2656h = m(inputStream, i8);
                    i6++;
                } else {
                    throw f.c("Order of dexfiles in metadata did not match baseline");
                }
            }
            return eVarArr;
        }
        throw f.c("Mismatched number of dex files found in metadata");
    }

    static e[] t(InputStream inputStream, byte[] bArr, e[] eVarArr) {
        int h5 = f.h(inputStream);
        byte[] e5 = f.e(inputStream, (int) f.i(inputStream), (int) f.i(inputStream));
        if (inputStream.read() <= 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e5);
            try {
                e[] u5 = u(byteArrayInputStream, bArr, h5, eVarArr);
                byteArrayInputStream.close();
                return u5;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            throw f.c("Content found after the end of file");
        }
        throw th;
    }

    private static e[] u(InputStream inputStream, byte[] bArr, int i5, e[] eVarArr) {
        int i6 = 0;
        if (inputStream.available() == 0) {
            return new e[0];
        }
        if (i5 == eVarArr.length) {
            while (i6 < i5) {
                f.h(inputStream);
                String f5 = f.f(inputStream, f.h(inputStream));
                long i7 = f.i(inputStream);
                int h5 = f.h(inputStream);
                e i8 = i(eVarArr, f5);
                if (i8 != null) {
                    i8.f2652d = i7;
                    int[] m5 = m(inputStream, h5);
                    if (Arrays.equals(bArr, q.f2691e)) {
                        i8.f2653e = h5;
                        i8.f2656h = m5;
                    }
                    i6++;
                } else {
                    throw f.c("Missing profile key: " + f5);
                }
            }
            return eVarArr;
        }
        throw f.c("Mismatched number of dex files found in metadata");
    }

    private static void v(InputStream inputStream, e eVar) {
        BitSet valueOf = BitSet.valueOf(f.d(inputStream, f.a(eVar.f2655g * 2)));
        int i5 = 0;
        while (true) {
            int i6 = eVar.f2655g;
            if (i5 < i6) {
                int n5 = n(valueOf, i5, i6);
                if (n5 != 0) {
                    Integer num = eVar.f2657i.get(Integer.valueOf(i5));
                    if (num == null) {
                        num = 0;
                    }
                    eVar.f2657i.put(Integer.valueOf(i5), Integer.valueOf(n5 | num.intValue()));
                }
                i5++;
            } else {
                return;
            }
        }
    }

    static e[] w(InputStream inputStream, byte[] bArr, String str) {
        if (Arrays.equals(bArr, q.f2688b)) {
            int j5 = f.j(inputStream);
            byte[] e5 = f.e(inputStream, (int) f.i(inputStream), (int) f.i(inputStream));
            if (inputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e5);
                try {
                    e[] x4 = x(byteArrayInputStream, str, j5);
                    byteArrayInputStream.close();
                    return x4;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } else {
                throw f.c("Content found after the end of file");
            }
        } else {
            throw f.c("Unsupported version");
        }
        throw th;
    }

    private static e[] x(InputStream inputStream, String str, int i5) {
        InputStream inputStream2 = inputStream;
        int i6 = i5;
        if (inputStream.available() == 0) {
            return new e[0];
        }
        e[] eVarArr = new e[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            int h5 = f.h(inputStream);
            int h6 = f.h(inputStream);
            long i8 = f.i(inputStream);
            String str2 = str;
            eVarArr[i7] = new e(str2, f.f(inputStream2, h5), f.i(inputStream), 0, h6, (int) i8, (int) f.i(inputStream), new int[h6], new TreeMap());
        }
        for (int i9 = 0; i9 < i6; i9++) {
            e eVar = eVarArr[i9];
            p(inputStream2, eVar);
            eVar.f2656h = m(inputStream2, eVar.f2653e);
            v(inputStream2, eVar);
        }
        return eVarArr;
    }

    private static int y(int i5) {
        return ((i5 + 8) - 1) & -8;
    }

    private static void z(byte[] bArr, int i5, int i6, e eVar) {
        int l5 = l(i5, i6, eVar.f2655g);
        int i7 = l5 / 8;
        bArr[i7] = (byte) ((1 << (l5 % 8)) | bArr[i7]);
    }
}
