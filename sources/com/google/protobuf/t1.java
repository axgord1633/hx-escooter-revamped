package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class t1 {

    /* renamed from: a  reason: collision with root package name */
    private static final Unsafe f3668a = H();

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?> f3669b = d.b();

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f3670c = q(Long.TYPE);

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f3671d = q(Integer.TYPE);

    /* renamed from: e  reason: collision with root package name */
    private static final e f3672e = F();

    /* renamed from: f  reason: collision with root package name */
    private static final boolean f3673f = X();

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f3674g = W();

    /* renamed from: h  reason: collision with root package name */
    static final long f3675h;

    /* renamed from: i  reason: collision with root package name */
    private static final long f3676i;

    /* renamed from: j  reason: collision with root package name */
    private static final long f3677j;

    /* renamed from: k  reason: collision with root package name */
    private static final long f3678k;

    /* renamed from: l  reason: collision with root package name */
    private static final long f3679l;

    /* renamed from: m  reason: collision with root package name */
    private static final long f3680m;

    /* renamed from: n  reason: collision with root package name */
    private static final long f3681n;

    /* renamed from: o  reason: collision with root package name */
    private static final long f3682o;

    /* renamed from: p  reason: collision with root package name */
    private static final long f3683p;

    /* renamed from: q  reason: collision with root package name */
    private static final long f3684q;

    /* renamed from: r  reason: collision with root package name */
    private static final long f3685r;

    /* renamed from: s  reason: collision with root package name */
    private static final long f3686s;

    /* renamed from: t  reason: collision with root package name */
    private static final long f3687t;

    /* renamed from: u  reason: collision with root package name */
    private static final long f3688u = s(o());

    /* renamed from: v  reason: collision with root package name */
    private static final int f3689v;

    /* renamed from: w  reason: collision with root package name */
    static final boolean f3690w = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    static class a implements PrivilegedExceptionAction<Unsafe> {
        a() {
        }

        /* renamed from: a */
        public Unsafe run() {
            Class<Unsafe> cls = Unsafe.class;
            for (Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get((Object) null);
                if (cls.isInstance(obj)) {
                    return cls.cast(obj);
                }
            }
            return null;
        }
    }

    private static final class b extends e {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        public void c(long j5, byte[] bArr, long j6, long j7) {
            throw new UnsupportedOperationException();
        }

        public boolean d(Object obj, long j5) {
            return t1.f3690w ? t1.u(obj, j5) : t1.v(obj, j5);
        }

        public byte e(long j5) {
            throw new UnsupportedOperationException();
        }

        public byte f(Object obj, long j5) {
            return t1.f3690w ? t1.y(obj, j5) : t1.z(obj, j5);
        }

        public double g(Object obj, long j5) {
            return Double.longBitsToDouble(k(obj, j5));
        }

        public float h(Object obj, long j5) {
            return Float.intBitsToFloat(i(obj, j5));
        }

        public long j(long j5) {
            throw new UnsupportedOperationException();
        }

        public void n(Object obj, long j5, boolean z4) {
            if (t1.f3690w) {
                t1.M(obj, j5, z4);
            } else {
                t1.N(obj, j5, z4);
            }
        }

        public void o(Object obj, long j5, byte b5) {
            if (t1.f3690w) {
                t1.P(obj, j5, b5);
            } else {
                t1.Q(obj, j5, b5);
            }
        }

        public void p(Object obj, long j5, double d5) {
            s(obj, j5, Double.doubleToLongBits(d5));
        }

        public void q(Object obj, long j5, float f5) {
            r(obj, j5, Float.floatToIntBits(f5));
        }

        public boolean v() {
            return false;
        }
    }

    private static final class c extends e {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        public void c(long j5, byte[] bArr, long j6, long j7) {
            throw new UnsupportedOperationException();
        }

        public boolean d(Object obj, long j5) {
            return t1.f3690w ? t1.u(obj, j5) : t1.v(obj, j5);
        }

        public byte e(long j5) {
            throw new UnsupportedOperationException();
        }

        public byte f(Object obj, long j5) {
            return t1.f3690w ? t1.y(obj, j5) : t1.z(obj, j5);
        }

        public double g(Object obj, long j5) {
            return Double.longBitsToDouble(k(obj, j5));
        }

        public float h(Object obj, long j5) {
            return Float.intBitsToFloat(i(obj, j5));
        }

        public long j(long j5) {
            throw new UnsupportedOperationException();
        }

        public void n(Object obj, long j5, boolean z4) {
            if (t1.f3690w) {
                t1.M(obj, j5, z4);
            } else {
                t1.N(obj, j5, z4);
            }
        }

        public void o(Object obj, long j5, byte b5) {
            if (t1.f3690w) {
                t1.P(obj, j5, b5);
            } else {
                t1.Q(obj, j5, b5);
            }
        }

        public void p(Object obj, long j5, double d5) {
            s(obj, j5, Double.doubleToLongBits(d5));
        }

        public void q(Object obj, long j5, float f5) {
            r(obj, j5, Float.floatToIntBits(f5));
        }

        public boolean v() {
            return false;
        }
    }

    private static final class d extends e {
        d(Unsafe unsafe) {
            super(unsafe);
        }

        public void c(long j5, byte[] bArr, long j6, long j7) {
            this.f3691a.copyMemory((Object) null, j5, bArr, t1.f3675h + j6, j7);
        }

        public boolean d(Object obj, long j5) {
            return this.f3691a.getBoolean(obj, j5);
        }

        public byte e(long j5) {
            return this.f3691a.getByte(j5);
        }

        public byte f(Object obj, long j5) {
            return this.f3691a.getByte(obj, j5);
        }

        public double g(Object obj, long j5) {
            return this.f3691a.getDouble(obj, j5);
        }

        public float h(Object obj, long j5) {
            return this.f3691a.getFloat(obj, j5);
        }

        public long j(long j5) {
            return this.f3691a.getLong(j5);
        }

        public void n(Object obj, long j5, boolean z4) {
            this.f3691a.putBoolean(obj, j5, z4);
        }

        public void o(Object obj, long j5, byte b5) {
            this.f3691a.putByte(obj, j5, b5);
        }

        public void p(Object obj, long j5, double d5) {
            this.f3691a.putDouble(obj, j5, d5);
        }

        public void q(Object obj, long j5, float f5) {
            this.f3691a.putFloat(obj, j5, f5);
        }

        public boolean u() {
            Class<Object> cls = Object.class;
            if (!super.u()) {
                return false;
            }
            try {
                Class<?> cls2 = this.f3691a.getClass();
                Class cls3 = Long.TYPE;
                cls2.getMethod("getByte", new Class[]{cls, cls3});
                cls2.getMethod("putByte", new Class[]{cls, cls3, Byte.TYPE});
                cls2.getMethod("getBoolean", new Class[]{cls, cls3});
                cls2.getMethod("putBoolean", new Class[]{cls, cls3, Boolean.TYPE});
                cls2.getMethod("getFloat", new Class[]{cls, cls3});
                cls2.getMethod("putFloat", new Class[]{cls, cls3, Float.TYPE});
                cls2.getMethod("getDouble", new Class[]{cls, cls3});
                cls2.getMethod("putDouble", new Class[]{cls, cls3, Double.TYPE});
                return true;
            } catch (Throwable th) {
                t1.K(th);
                return false;
            }
        }

        public boolean v() {
            Class<Object> cls = Object.class;
            if (!super.v()) {
                return false;
            }
            try {
                Class<?> cls2 = this.f3691a.getClass();
                Class cls3 = Long.TYPE;
                cls2.getMethod("getByte", new Class[]{cls3});
                cls2.getMethod("putByte", new Class[]{cls3, Byte.TYPE});
                cls2.getMethod("getInt", new Class[]{cls3});
                cls2.getMethod("putInt", new Class[]{cls3, Integer.TYPE});
                cls2.getMethod("getLong", new Class[]{cls3});
                cls2.getMethod("putLong", new Class[]{cls3, cls3});
                cls2.getMethod("copyMemory", new Class[]{cls3, cls3, cls3});
                cls2.getMethod("copyMemory", new Class[]{cls, cls3, cls, cls3, cls3});
                return true;
            } catch (Throwable th) {
                t1.K(th);
                return false;
            }
        }
    }

    private static abstract class e {

        /* renamed from: a  reason: collision with root package name */
        Unsafe f3691a;

        e(Unsafe unsafe) {
            this.f3691a = unsafe;
        }

        public final int a(Class<?> cls) {
            return this.f3691a.arrayBaseOffset(cls);
        }

        public final int b(Class<?> cls) {
            return this.f3691a.arrayIndexScale(cls);
        }

        public abstract void c(long j5, byte[] bArr, long j6, long j7);

        public abstract boolean d(Object obj, long j5);

        public abstract byte e(long j5);

        public abstract byte f(Object obj, long j5);

        public abstract double g(Object obj, long j5);

        public abstract float h(Object obj, long j5);

        public final int i(Object obj, long j5) {
            return this.f3691a.getInt(obj, j5);
        }

        public abstract long j(long j5);

        public final long k(Object obj, long j5) {
            return this.f3691a.getLong(obj, j5);
        }

        public final Object l(Object obj, long j5) {
            return this.f3691a.getObject(obj, j5);
        }

        public final long m(Field field) {
            return this.f3691a.objectFieldOffset(field);
        }

        public abstract void n(Object obj, long j5, boolean z4);

        public abstract void o(Object obj, long j5, byte b5);

        public abstract void p(Object obj, long j5, double d5);

        public abstract void q(Object obj, long j5, float f5);

        public final void r(Object obj, long j5, int i5) {
            this.f3691a.putInt(obj, j5, i5);
        }

        public final void s(Object obj, long j5, long j6) {
            this.f3691a.putLong(obj, j5, j6);
        }

        public final void t(Object obj, long j5, Object obj2) {
            this.f3691a.putObject(obj, j5, obj2);
        }

        public boolean u() {
            Class<Object> cls = Object.class;
            Unsafe unsafe = this.f3691a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls2 = unsafe.getClass();
                cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
                cls2.getMethod("arrayBaseOffset", new Class[]{Class.class});
                cls2.getMethod("arrayIndexScale", new Class[]{Class.class});
                Class cls3 = Long.TYPE;
                cls2.getMethod("getInt", new Class[]{cls, cls3});
                cls2.getMethod("putInt", new Class[]{cls, cls3, Integer.TYPE});
                cls2.getMethod("getLong", new Class[]{cls, cls3});
                cls2.getMethod("putLong", new Class[]{cls, cls3, cls3});
                cls2.getMethod("getObject", new Class[]{cls, cls3});
                cls2.getMethod("putObject", new Class[]{cls, cls3, cls});
                return true;
            } catch (Throwable th) {
                t1.K(th);
                return false;
            }
        }

        public boolean v() {
            Unsafe unsafe = this.f3691a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", new Class[]{Field.class});
                cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
                return t1.o() != null;
            } catch (Throwable th) {
                t1.K(th);
                return false;
            }
        }
    }

    static {
        Class<Object[]> cls = Object[].class;
        Class<double[]> cls2 = double[].class;
        Class<float[]> cls3 = float[].class;
        Class<long[]> cls4 = long[].class;
        Class<int[]> cls5 = int[].class;
        Class<boolean[]> cls6 = boolean[].class;
        long m5 = (long) m(byte[].class);
        f3675h = m5;
        f3676i = (long) m(cls6);
        f3677j = (long) n(cls6);
        f3678k = (long) m(cls5);
        f3679l = (long) n(cls5);
        f3680m = (long) m(cls4);
        f3681n = (long) n(cls4);
        f3682o = (long) m(cls3);
        f3683p = (long) n(cls3);
        f3684q = (long) m(cls2);
        f3685r = (long) n(cls2);
        f3686s = (long) m(cls);
        f3687t = (long) n(cls);
        f3689v = (int) (7 & m5);
    }

    private t1() {
    }

    static double A(Object obj, long j5) {
        return f3672e.g(obj, j5);
    }

    static float B(Object obj, long j5) {
        return f3672e.h(obj, j5);
    }

    static int C(Object obj, long j5) {
        return f3672e.i(obj, j5);
    }

    static long D(long j5) {
        return f3672e.j(j5);
    }

    static long E(Object obj, long j5) {
        return f3672e.k(obj, j5);
    }

    private static e F() {
        Unsafe unsafe = f3668a;
        if (unsafe == null) {
            return null;
        }
        if (!d.c()) {
            return new d(unsafe);
        }
        if (f3670c) {
            return new c(unsafe);
        }
        if (f3671d) {
            return new b(unsafe);
        }
        return null;
    }

    static Object G(Object obj, long j5) {
        return f3672e.l(obj, j5);
    }

    static Unsafe H() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean I() {
        return f3674g;
    }

    static boolean J() {
        return f3673f;
    }

    /* access modifiers changed from: private */
    public static void K(Throwable th) {
        Logger logger = Logger.getLogger(t1.class.getName());
        Level level = Level.WARNING;
        logger.log(level, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    static void L(Object obj, long j5, boolean z4) {
        f3672e.n(obj, j5, z4);
    }

    /* access modifiers changed from: private */
    public static void M(Object obj, long j5, boolean z4) {
        P(obj, j5, z4 ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void N(Object obj, long j5, boolean z4) {
        Q(obj, j5, z4 ? (byte) 1 : 0);
    }

    static void O(byte[] bArr, long j5, byte b5) {
        f3672e.o(bArr, f3675h + j5, b5);
    }

    /* access modifiers changed from: private */
    public static void P(Object obj, long j5, byte b5) {
        long j6 = -4 & j5;
        int C = C(obj, j6);
        int i5 = ((~((int) j5)) & 3) << 3;
        T(obj, j6, ((255 & b5) << i5) | (C & (~(255 << i5))));
    }

    /* access modifiers changed from: private */
    public static void Q(Object obj, long j5, byte b5) {
        long j6 = -4 & j5;
        int i5 = (((int) j5) & 3) << 3;
        T(obj, j6, ((255 & b5) << i5) | (C(obj, j6) & (~(255 << i5))));
    }

    static void R(Object obj, long j5, double d5) {
        f3672e.p(obj, j5, d5);
    }

    static void S(Object obj, long j5, float f5) {
        f3672e.q(obj, j5, f5);
    }

    static void T(Object obj, long j5, int i5) {
        f3672e.r(obj, j5, i5);
    }

    static void U(Object obj, long j5, long j6) {
        f3672e.s(obj, j5, j6);
    }

    static void V(Object obj, long j5, Object obj2) {
        f3672e.t(obj, j5, obj2);
    }

    private static boolean W() {
        e eVar = f3672e;
        if (eVar == null) {
            return false;
        }
        return eVar.u();
    }

    private static boolean X() {
        e eVar = f3672e;
        if (eVar == null) {
            return false;
        }
        return eVar.v();
    }

    static long k(ByteBuffer byteBuffer) {
        return f3672e.k(byteBuffer, f3688u);
    }

    static <T> T l(Class<T> cls) {
        try {
            return f3668a.allocateInstance(cls);
        } catch (InstantiationException e5) {
            throw new IllegalStateException(e5);
        }
    }

    private static int m(Class<?> cls) {
        if (f3674g) {
            return f3672e.a(cls);
        }
        return -1;
    }

    private static int n(Class<?> cls) {
        if (f3674g) {
            return f3672e.b(cls);
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static Field o() {
        Field r5;
        if (d.c() && (r5 = r(Buffer.class, "effectiveDirectAddress")) != null) {
            return r5;
        }
        Field r6 = r(Buffer.class, "address");
        if (r6 == null || r6.getType() != Long.TYPE) {
            return null;
        }
        return r6;
    }

    static void p(long j5, byte[] bArr, long j6, long j7) {
        f3672e.c(j5, bArr, j6, j7);
    }

    static boolean q(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!d.c()) {
            return false;
        }
        try {
            Class<?> cls3 = f3669b;
            Class cls4 = Boolean.TYPE;
            cls3.getMethod("peekLong", new Class[]{cls, cls4});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, cls4});
            Class cls5 = Integer.TYPE;
            cls3.getMethod("pokeInt", new Class[]{cls, cls5, cls4});
            cls3.getMethod("peekInt", new Class[]{cls, cls4});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, cls5, cls5});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, cls5, cls5});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field r(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long s(Field field) {
        e eVar;
        if (field == null || (eVar = f3672e) == null) {
            return -1;
        }
        return eVar.m(field);
    }

    static boolean t(Object obj, long j5) {
        return f3672e.d(obj, j5);
    }

    /* access modifiers changed from: private */
    public static boolean u(Object obj, long j5) {
        return y(obj, j5) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean v(Object obj, long j5) {
        return z(obj, j5) != 0;
    }

    static byte w(long j5) {
        return f3672e.e(j5);
    }

    static byte x(byte[] bArr, long j5) {
        return f3672e.f(bArr, f3675h + j5);
    }

    /* access modifiers changed from: private */
    public static byte y(Object obj, long j5) {
        return (byte) ((C(obj, -4 & j5) >>> ((int) (((~j5) & 3) << 3))) & 255);
    }

    /* access modifiers changed from: private */
    public static byte z(Object obj, long j5) {
        return (byte) ((C(obj, -4 & j5) >>> ((int) ((j5 & 3) << 3))) & 255);
    }
}
