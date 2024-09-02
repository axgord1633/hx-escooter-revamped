package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

public final class b0 {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f3469a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    static final Charset f3470b = Charset.forName("ISO-8859-1");

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f3471c;

    /* renamed from: d  reason: collision with root package name */
    public static final ByteBuffer f3472d;

    /* renamed from: e  reason: collision with root package name */
    public static final j f3473e;

    public interface a extends i<Boolean> {
        a a(int i5);
    }

    public interface b extends i<Double> {
        b a(int i5);
    }

    public interface c {
        int a();
    }

    public interface d<T extends c> {
        T a(int i5);
    }

    public interface e {
        boolean a(int i5);
    }

    public interface f extends i<Float> {
        f a(int i5);
    }

    public interface g extends i<Integer> {
        g a(int i5);
    }

    public interface h extends i<Long> {
        h a(int i5);
    }

    public interface i<E> extends List<E>, RandomAccess {
        i<E> a(int i5);

        void b();

        boolean k();
    }

    static {
        byte[] bArr = new byte[0];
        f3471c = bArr;
        f3472d = ByteBuffer.wrap(bArr);
        f3473e = j.j(bArr);
    }

    static <T> T a(T t5) {
        t5.getClass();
        return t5;
    }

    static <T> T b(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }

    public static int c(boolean z4) {
        return z4 ? 1231 : 1237;
    }

    public static int d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    static int e(byte[] bArr, int i5, int i6) {
        int i7 = i(i6, bArr, i5, i6);
        if (i7 == 0) {
            return 1;
        }
        return i7;
    }

    public static int f(long j5) {
        return (int) (j5 ^ (j5 >>> 32));
    }

    public static boolean g(byte[] bArr) {
        return u1.s(bArr);
    }

    static Object h(Object obj, Object obj2) {
        return ((s0) obj).toBuilder().mergeFrom((s0) obj2).buildPartial();
    }

    static int i(int i5, byte[] bArr, int i6, int i7) {
        for (int i8 = i6; i8 < i6 + i7; i8++) {
            i5 = (i5 * 31) + bArr[i8];
        }
        return i5;
    }

    public static String j(byte[] bArr) {
        return new String(bArr, f3469a);
    }
}
