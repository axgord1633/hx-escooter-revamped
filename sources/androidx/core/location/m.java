package androidx.core.location;

import android.location.LocationRequest;
import android.os.Build;
import androidx.core.util.d;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    final int f1753a;

    /* renamed from: b  reason: collision with root package name */
    final long f1754b;

    /* renamed from: c  reason: collision with root package name */
    final long f1755c;

    /* renamed from: d  reason: collision with root package name */
    final long f1756d;

    /* renamed from: e  reason: collision with root package name */
    final int f1757e;

    /* renamed from: f  reason: collision with root package name */
    final float f1758f;

    /* renamed from: g  reason: collision with root package name */
    final long f1759g;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static Class<?> f1760a;

        /* renamed from: b  reason: collision with root package name */
        private static Method f1761b;

        /* renamed from: c  reason: collision with root package name */
        private static Method f1762c;

        /* renamed from: d  reason: collision with root package name */
        private static Method f1763d;

        /* renamed from: e  reason: collision with root package name */
        private static Method f1764e;

        /* renamed from: f  reason: collision with root package name */
        private static Method f1765f;

        public static Object a(m mVar, String str) {
            try {
                if (f1760a == null) {
                    f1760a = Class.forName("android.location.LocationRequest");
                }
                if (f1761b == null) {
                    Method declaredMethod = f1760a.getDeclaredMethod("createFromDeprecatedProvider", new Class[]{String.class, Long.TYPE, Float.TYPE, Boolean.TYPE});
                    f1761b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                Object invoke = f1761b.invoke((Object) null, new Object[]{str, Long.valueOf(mVar.b()), Float.valueOf(mVar.e()), Boolean.FALSE});
                if (invoke == null) {
                    return null;
                }
                if (f1762c == null) {
                    Method declaredMethod2 = f1760a.getDeclaredMethod("setQuality", new Class[]{Integer.TYPE});
                    f1762c = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
                f1762c.invoke(invoke, new Object[]{Integer.valueOf(mVar.g())});
                if (f1763d == null) {
                    Method declaredMethod3 = f1760a.getDeclaredMethod("setFastestInterval", new Class[]{Long.TYPE});
                    f1763d = declaredMethod3;
                    declaredMethod3.setAccessible(true);
                }
                f1763d.invoke(invoke, new Object[]{Long.valueOf(mVar.f())});
                if (mVar.d() < Integer.MAX_VALUE) {
                    if (f1764e == null) {
                        Method declaredMethod4 = f1760a.getDeclaredMethod("setNumUpdates", new Class[]{Integer.TYPE});
                        f1764e = declaredMethod4;
                        declaredMethod4.setAccessible(true);
                    }
                    f1764e.invoke(invoke, new Object[]{Integer.valueOf(mVar.d())});
                }
                if (mVar.a() < Long.MAX_VALUE) {
                    if (f1765f == null) {
                        Method declaredMethod5 = f1760a.getDeclaredMethod("setExpireIn", new Class[]{Long.TYPE});
                        f1765f = declaredMethod5;
                        declaredMethod5.setAccessible(true);
                    }
                    f1765f.invoke(invoke, new Object[]{Long.valueOf(mVar.a())});
                }
                return invoke;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }
    }

    private static class b {
        public static LocationRequest a(m mVar) {
            return new LocationRequest.Builder(mVar.b()).setQuality(mVar.g()).setMinUpdateIntervalMillis(mVar.f()).setDurationMillis(mVar.a()).setMaxUpdates(mVar.d()).setMinUpdateDistanceMeters(mVar.e()).setMaxUpdateDelayMillis(mVar.c()).build();
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private long f1766a;

        /* renamed from: b  reason: collision with root package name */
        private int f1767b = R.styleable.AppCompatTheme_textAppearanceLargePopupMenu;

        /* renamed from: c  reason: collision with root package name */
        private long f1768c = Long.MAX_VALUE;

        /* renamed from: d  reason: collision with root package name */
        private int f1769d = Integer.MAX_VALUE;

        /* renamed from: e  reason: collision with root package name */
        private long f1770e = -1;

        /* renamed from: f  reason: collision with root package name */
        private float f1771f = CropImageView.DEFAULT_ASPECT_RATIO;

        /* renamed from: g  reason: collision with root package name */
        private long f1772g = 0;

        public c(long j5) {
            b(j5);
        }

        public m a() {
            d.j((this.f1766a == Long.MAX_VALUE && this.f1770e == -1) ? false : true, "passive location requests must have an explicit minimum update interval");
            long j5 = this.f1766a;
            return new m(j5, this.f1767b, this.f1768c, this.f1769d, Math.min(this.f1770e, j5), this.f1771f, this.f1772g);
        }

        public c b(long j5) {
            this.f1766a = d.e(j5, 0, Long.MAX_VALUE, "intervalMillis");
            return this;
        }

        public c c(float f5) {
            this.f1771f = f5;
            this.f1771f = d.c(f5, CropImageView.DEFAULT_ASPECT_RATIO, Float.MAX_VALUE, "minUpdateDistanceMeters");
            return this;
        }

        public c d(int i5) {
            d.a(i5 == 104 || i5 == 102 || i5 == 100, "quality must be a defined QUALITY constant, not %d", Integer.valueOf(i5));
            this.f1767b = i5;
            return this;
        }
    }

    m(long j5, int i5, long j6, int i6, long j7, float f5, long j8) {
        this.f1754b = j5;
        this.f1753a = i5;
        this.f1755c = j7;
        this.f1756d = j6;
        this.f1757e = i6;
        this.f1758f = f5;
        this.f1759g = j8;
    }

    public long a() {
        return this.f1756d;
    }

    public long b() {
        return this.f1754b;
    }

    public long c() {
        return this.f1759g;
    }

    public int d() {
        return this.f1757e;
    }

    public float e() {
        return this.f1758f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f1753a == mVar.f1753a && this.f1754b == mVar.f1754b && this.f1755c == mVar.f1755c && this.f1756d == mVar.f1756d && this.f1757e == mVar.f1757e && Float.compare(mVar.f1758f, this.f1758f) == 0 && this.f1759g == mVar.f1759g;
    }

    public long f() {
        long j5 = this.f1755c;
        return j5 == -1 ? this.f1754b : j5;
    }

    public int g() {
        return this.f1753a;
    }

    public LocationRequest h() {
        return b.a(this);
    }

    public int hashCode() {
        long j5 = this.f1754b;
        long j6 = this.f1755c;
        return (((this.f1753a * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)));
    }

    public LocationRequest i(String str) {
        return Build.VERSION.SDK_INT >= 31 ? h() : (LocationRequest) a.a(this, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Request["
            r0.append(r1)
            long r1 = r5.f1754b
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0037
            java.lang.String r1 = "@"
            r0.append(r1)
            long r1 = r5.f1754b
            androidx.core.util.f.b(r1, r0)
            int r1 = r5.f1753a
            r2 = 100
            if (r1 == r2) goto L_0x0034
            r2 = 102(0x66, float:1.43E-43)
            if (r1 == r2) goto L_0x0031
            r2 = 104(0x68, float:1.46E-43)
            if (r1 == r2) goto L_0x002e
            goto L_0x003c
        L_0x002e:
            java.lang.String r1 = " LOW_POWER"
            goto L_0x0039
        L_0x0031:
            java.lang.String r1 = " BALANCED"
            goto L_0x0039
        L_0x0034:
            java.lang.String r1 = " HIGH_ACCURACY"
            goto L_0x0039
        L_0x0037:
            java.lang.String r1 = "PASSIVE"
        L_0x0039:
            r0.append(r1)
        L_0x003c:
            long r1 = r5.f1756d
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x004c
            java.lang.String r1 = ", duration="
            r0.append(r1)
            long r1 = r5.f1756d
            androidx.core.util.f.b(r1, r0)
        L_0x004c:
            int r1 = r5.f1757e
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 == r2) goto L_0x005d
            java.lang.String r1 = ", maxUpdates="
            r0.append(r1)
            int r1 = r5.f1757e
            r0.append(r1)
        L_0x005d:
            long r1 = r5.f1755c
            r3 = -1
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x0075
            long r3 = r5.f1754b
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x0075
            java.lang.String r1 = ", minUpdateInterval="
            r0.append(r1)
            long r1 = r5.f1755c
            androidx.core.util.f.b(r1, r0)
        L_0x0075:
            float r1 = r5.f1758f
            double r1 = (double) r1
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0088
            java.lang.String r1 = ", minUpdateDistance="
            r0.append(r1)
            float r1 = r5.f1758f
            r0.append(r1)
        L_0x0088:
            long r1 = r5.f1759g
            r3 = 2
            long r1 = r1 / r3
            long r3 = r5.f1754b
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x009d
            java.lang.String r1 = ", maxUpdateDelay="
            r0.append(r1)
            long r1 = r5.f1759g
            androidx.core.util.f.b(r1, r0)
        L_0x009d:
            r1 = 93
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.location.m.toString():java.lang.String");
    }
}
