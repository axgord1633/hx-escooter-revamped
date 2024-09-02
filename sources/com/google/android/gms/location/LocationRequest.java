package com.google.android.gms.location;

import a1.f;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.WorkSource;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import g1.b0;
import g1.j0;
import i1.q;
import i1.r;
import i1.t;
import org.checkerframework.dataflow.qual.Pure;
import w0.o;
import w0.p;
import x0.c;

public final class LocationRequest extends x0.a implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new b();

    /* renamed from: e  reason: collision with root package name */
    private int f3431e;

    /* renamed from: f  reason: collision with root package name */
    private long f3432f;

    /* renamed from: g  reason: collision with root package name */
    private long f3433g;

    /* renamed from: h  reason: collision with root package name */
    private long f3434h;

    /* renamed from: i  reason: collision with root package name */
    private long f3435i;

    /* renamed from: j  reason: collision with root package name */
    private int f3436j;

    /* renamed from: k  reason: collision with root package name */
    private float f3437k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f3438l;

    /* renamed from: m  reason: collision with root package name */
    private long f3439m;

    /* renamed from: n  reason: collision with root package name */
    private final int f3440n;

    /* renamed from: o  reason: collision with root package name */
    private final int f3441o;

    /* renamed from: p  reason: collision with root package name */
    private final String f3442p;

    /* renamed from: q  reason: collision with root package name */
    private final boolean f3443q;

    /* renamed from: r  reason: collision with root package name */
    private final WorkSource f3444r;

    /* renamed from: s  reason: collision with root package name */
    private final b0 f3445s;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private int f3446a;

        /* renamed from: b  reason: collision with root package name */
        private long f3447b;

        /* renamed from: c  reason: collision with root package name */
        private long f3448c;

        /* renamed from: d  reason: collision with root package name */
        private long f3449d;

        /* renamed from: e  reason: collision with root package name */
        private long f3450e;

        /* renamed from: f  reason: collision with root package name */
        private int f3451f;

        /* renamed from: g  reason: collision with root package name */
        private float f3452g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f3453h;

        /* renamed from: i  reason: collision with root package name */
        private long f3454i;

        /* renamed from: j  reason: collision with root package name */
        private int f3455j;

        /* renamed from: k  reason: collision with root package name */
        private int f3456k;

        /* renamed from: l  reason: collision with root package name */
        private String f3457l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f3458m;

        /* renamed from: n  reason: collision with root package name */
        private WorkSource f3459n;

        /* renamed from: o  reason: collision with root package name */
        private b0 f3460o;

        public a(long j5) {
            p.b(j5 >= 0, "intervalMillis must be greater than or equal to 0");
            this.f3447b = j5;
            this.f3446a = R.styleable.AppCompatTheme_textAppearanceLargePopupMenu;
            this.f3448c = -1;
            this.f3449d = 0;
            this.f3450e = Long.MAX_VALUE;
            this.f3451f = Integer.MAX_VALUE;
            this.f3452g = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f3453h = true;
            this.f3454i = -1;
            this.f3455j = 0;
            this.f3456k = 0;
            this.f3457l = null;
            this.f3458m = false;
            this.f3459n = null;
            this.f3460o = null;
        }

        public a(LocationRequest locationRequest) {
            this.f3446a = locationRequest.j();
            this.f3447b = locationRequest.d();
            this.f3448c = locationRequest.i();
            this.f3449d = locationRequest.f();
            this.f3450e = locationRequest.b();
            this.f3451f = locationRequest.g();
            this.f3452g = locationRequest.h();
            this.f3453h = locationRequest.m();
            this.f3454i = locationRequest.e();
            this.f3455j = locationRequest.c();
            this.f3456k = locationRequest.r();
            this.f3457l = locationRequest.u();
            this.f3458m = locationRequest.v();
            this.f3459n = locationRequest.s();
            this.f3460o = locationRequest.t();
        }

        public LocationRequest a() {
            int i5 = this.f3446a;
            long j5 = this.f3447b;
            long j6 = this.f3448c;
            if (j6 == -1) {
                j6 = j5;
            } else if (i5 != 105) {
                j6 = Math.min(j6, j5);
            }
            long max = Math.max(this.f3449d, this.f3447b);
            long j7 = this.f3450e;
            int i6 = this.f3451f;
            float f5 = this.f3452g;
            boolean z4 = this.f3453h;
            long j8 = this.f3454i;
            long j9 = j8 == -1 ? this.f3447b : j8;
            int i7 = this.f3455j;
            int i8 = this.f3456k;
            String str = this.f3457l;
            boolean z5 = this.f3458m;
            WorkSource workSource = r7;
            WorkSource workSource2 = new WorkSource(this.f3459n);
            return new LocationRequest(i5, j5, j6, max, Long.MAX_VALUE, j7, i6, f5, z4, j9, i7, i8, str, z5, workSource, this.f3460o);
        }

        public a b(int i5) {
            t.a(i5);
            this.f3455j = i5;
            return this;
        }

        public a c(long j5) {
            p.b(j5 >= 0, "intervalMillis must be greater than or equal to 0");
            this.f3447b = j5;
            return this;
        }

        public a d(long j5) {
            boolean z4 = true;
            if (j5 != -1 && j5 < 0) {
                z4 = false;
            }
            p.b(z4, "maxUpdateAgeMillis must be greater than or equal to 0, or IMPLICIT_MAX_UPDATE_AGE");
            this.f3454i = j5;
            return this;
        }

        public a e(float f5) {
            p.b(f5 >= CropImageView.DEFAULT_ASPECT_RATIO, "minUpdateDistanceMeters must be greater than or equal to 0");
            this.f3452g = f5;
            return this;
        }

        public a f(long j5) {
            boolean z4 = true;
            if (j5 != -1 && j5 < 0) {
                z4 = false;
            }
            p.b(z4, "minUpdateIntervalMillis must be greater than or equal to 0, or IMPLICIT_MIN_UPDATE_INTERVAL");
            this.f3448c = j5;
            return this;
        }

        public a g(int i5) {
            q.a(i5);
            this.f3446a = i5;
            return this;
        }

        public a h(boolean z4) {
            this.f3453h = z4;
            return this;
        }

        public final a i(boolean z4) {
            this.f3458m = z4;
            return this;
        }

        @Deprecated
        public final a j(String str) {
            if (Build.VERSION.SDK_INT < 30) {
                this.f3457l = str;
            }
            return this;
        }

        public final a k(int i5) {
            boolean z4;
            int i6 = 2;
            if (i5 == 0 || i5 == 1) {
                i6 = i5;
            } else if (i5 == 2) {
                i5 = 2;
            } else {
                i6 = i5;
                z4 = false;
                p.c(z4, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", Integer.valueOf(i5));
                this.f3456k = i6;
                return this;
            }
            z4 = true;
            p.c(z4, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", Integer.valueOf(i5));
            this.f3456k = i6;
            return this;
        }

        public final a l(WorkSource workSource) {
            this.f3459n = workSource;
            return this;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LocationRequest() {
        /*
            r23 = this;
            r0 = r23
            android.os.WorkSource r1 = new android.os.WorkSource
            r21 = r1
            r1.<init>()
            r1 = 102(0x66, float:1.43E-43)
            r2 = 3600000(0x36ee80, double:1.7786363E-317)
            r4 = 600000(0x927c0, double:2.964394E-318)
            r6 = 0
            r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r12 = 2147483647(0x7fffffff, float:NaN)
            r13 = 0
            r14 = 1
            r15 = 3600000(0x36ee80, double:1.7786363E-317)
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r22 = 0
            r0.<init>(r1, r2, r4, r6, r8, r10, r12, r13, r14, r15, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.LocationRequest.<init>():void");
    }

    LocationRequest(int i5, long j5, long j6, long j7, long j8, long j9, int i6, float f5, boolean z4, long j10, int i7, int i8, String str, boolean z5, WorkSource workSource, b0 b0Var) {
        this.f3431e = i5;
        long j11 = j5;
        this.f3432f = j11;
        this.f3433g = j6;
        this.f3434h = j7;
        this.f3435i = j8 == Long.MAX_VALUE ? j9 : Math.min(Math.max(1, j8 - SystemClock.elapsedRealtime()), j9);
        this.f3436j = i6;
        this.f3437k = f5;
        this.f3438l = z4;
        this.f3439m = j10 != -1 ? j10 : j11;
        this.f3440n = i7;
        this.f3441o = i8;
        this.f3442p = str;
        this.f3443q = z5;
        this.f3444r = workSource;
        this.f3445s = b0Var;
    }

    @Deprecated
    public static LocationRequest a() {
        WorkSource workSource = r1;
        WorkSource workSource2 = new WorkSource();
        return new LocationRequest(R.styleable.AppCompatTheme_textAppearanceLargePopupMenu, 3600000, 600000, 0, Long.MAX_VALUE, Long.MAX_VALUE, Integer.MAX_VALUE, CropImageView.DEFAULT_ASPECT_RATIO, true, 3600000, 0, 0, (String) null, false, workSource, (b0) null);
    }

    private static String w(long j5) {
        return j5 == Long.MAX_VALUE ? "∞" : j0.a(j5);
    }

    @Pure
    public long b() {
        return this.f3435i;
    }

    @Pure
    public int c() {
        return this.f3440n;
    }

    @Pure
    public long d() {
        return this.f3432f;
    }

    @Pure
    public long e() {
        return this.f3439m;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            return this.f3431e == locationRequest.f3431e && (l() || this.f3432f == locationRequest.f3432f) && this.f3433g == locationRequest.f3433g && k() == locationRequest.k() && ((!k() || this.f3434h == locationRequest.f3434h) && this.f3435i == locationRequest.f3435i && this.f3436j == locationRequest.f3436j && this.f3437k == locationRequest.f3437k && this.f3438l == locationRequest.f3438l && this.f3440n == locationRequest.f3440n && this.f3441o == locationRequest.f3441o && this.f3443q == locationRequest.f3443q && this.f3444r.equals(locationRequest.f3444r) && o.a(this.f3442p, locationRequest.f3442p) && o.a(this.f3445s, locationRequest.f3445s));
        }
    }

    @Pure
    public long f() {
        return this.f3434h;
    }

    @Pure
    public int g() {
        return this.f3436j;
    }

    @Pure
    public float h() {
        return this.f3437k;
    }

    public int hashCode() {
        return o.b(Integer.valueOf(this.f3431e), Long.valueOf(this.f3432f), Long.valueOf(this.f3433g), this.f3444r);
    }

    @Pure
    public long i() {
        return this.f3433g;
    }

    @Pure
    public int j() {
        return this.f3431e;
    }

    @Pure
    public boolean k() {
        long j5 = this.f3434h;
        return j5 > 0 && (j5 >> 1) >= this.f3432f;
    }

    @Pure
    public boolean l() {
        return this.f3431e == 105;
    }

    public boolean m() {
        return this.f3438l;
    }

    @Deprecated
    public LocationRequest n(long j5) {
        p.c(j5 >= 0, "illegal fastest interval: %d", Long.valueOf(j5));
        this.f3433g = j5;
        return this;
    }

    @Deprecated
    public LocationRequest o(long j5) {
        p.b(j5 >= 0, "intervalMillis must be greater than or equal to 0");
        long j6 = this.f3433g;
        long j7 = this.f3432f;
        if (j6 == j7 / 6) {
            this.f3433g = j5 / 6;
        }
        if (this.f3439m == j7) {
            this.f3439m = j5;
        }
        this.f3432f = j5;
        return this;
    }

    @Deprecated
    public LocationRequest p(int i5) {
        q.a(i5);
        this.f3431e = i5;
        return this;
    }

    @Deprecated
    public LocationRequest q(float f5) {
        if (f5 >= CropImageView.DEFAULT_ASPECT_RATIO) {
            this.f3437k = f5;
            return this;
        }
        throw new IllegalArgumentException("invalid displacement: " + f5);
    }

    @Pure
    public final int r() {
        return this.f3441o;
    }

    @Pure
    public final WorkSource s() {
        return this.f3444r;
    }

    @Pure
    public final b0 t() {
        return this.f3445s;
    }

    public String toString() {
        long j5;
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        if (!l()) {
            sb.append("@");
            if (k()) {
                j0.b(this.f3432f, sb);
                sb.append("/");
                j5 = this.f3434h;
            } else {
                j5 = this.f3432f;
            }
            j0.b(j5, sb);
            sb.append(" ");
        }
        sb.append(q.b(this.f3431e));
        if (l() || this.f3433g != this.f3432f) {
            sb.append(", minUpdateInterval=");
            sb.append(w(this.f3433g));
        }
        if (((double) this.f3437k) > 0.0d) {
            sb.append(", minUpdateDistance=");
            sb.append(this.f3437k);
        }
        boolean l5 = l();
        long j6 = this.f3439m;
        if (!l5 ? j6 != this.f3432f : j6 != Long.MAX_VALUE) {
            sb.append(", maxUpdateAge=");
            sb.append(w(this.f3439m));
        }
        if (this.f3435i != Long.MAX_VALUE) {
            sb.append(", duration=");
            j0.b(this.f3435i, sb);
        }
        if (this.f3436j != Integer.MAX_VALUE) {
            sb.append(", maxUpdates=");
            sb.append(this.f3436j);
        }
        if (this.f3441o != 0) {
            sb.append(", ");
            sb.append(r.a(this.f3441o));
        }
        if (this.f3440n != 0) {
            sb.append(", ");
            sb.append(t.b(this.f3440n));
        }
        if (this.f3438l) {
            sb.append(", waitForAccurateLocation");
        }
        if (this.f3443q) {
            sb.append(", bypass");
        }
        if (this.f3442p != null) {
            sb.append(", moduleId=");
            sb.append(this.f3442p);
        }
        if (!f.b(this.f3444r)) {
            sb.append(", ");
            sb.append(this.f3444r);
        }
        if (this.f3445s != null) {
            sb.append(", impersonation=");
            sb.append(this.f3445s);
        }
        sb.append(']');
        return sb.toString();
    }

    @Deprecated
    @Pure
    public final String u() {
        return this.f3442p;
    }

    @Pure
    public final boolean v() {
        return this.f3443q;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.g(parcel, 1, j());
        c.i(parcel, 2, d());
        c.i(parcel, 3, i());
        c.g(parcel, 6, g());
        c.e(parcel, 7, h());
        c.i(parcel, 8, f());
        c.c(parcel, 9, m());
        c.i(parcel, 10, b());
        c.i(parcel, 11, e());
        c.g(parcel, 12, c());
        c.g(parcel, 13, this.f3441o);
        c.k(parcel, 14, this.f3442p, false);
        c.c(parcel, 15, this.f3443q);
        c.j(parcel, 16, this.f3444r, i5, false);
        c.j(parcel, 17, this.f3445s, i5, false);
        c.b(parcel, a5);
    }
}
