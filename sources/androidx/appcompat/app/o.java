package androidx.appcompat.app;

class o {

    /* renamed from: d  reason: collision with root package name */
    private static o f730d;

    /* renamed from: a  reason: collision with root package name */
    public long f731a;

    /* renamed from: b  reason: collision with root package name */
    public long f732b;

    /* renamed from: c  reason: collision with root package name */
    public int f733c;

    o() {
    }

    static o b() {
        if (f730d == null) {
            f730d = new o();
        }
        return f730d;
    }

    public void a(long j5, double d5, double d6) {
        float f5 = ((float) (j5 - 946728000000L)) / 8.64E7f;
        float f6 = (0.01720197f * f5) + 6.24006f;
        double d7 = (double) f6;
        double sin = (Math.sin(d7) * 0.03341960161924362d) + d7 + (Math.sin((double) (2.0f * f6)) * 3.4906598739326E-4d) + (Math.sin((double) (f6 * 3.0f)) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double d8 = (-d6) / 360.0d;
        double round = ((double) (((float) Math.round(((double) (f5 - 9.0E-4f)) - d8)) + 9.0E-4f)) + d8 + (Math.sin(d7) * 0.0053d) + (Math.sin(2.0d * sin) * -0.0069d);
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d9 = 0.01745329238474369d * d5;
        double sin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d9) * Math.sin(asin))) / (Math.cos(d9) * Math.cos(asin));
        if (sin2 >= 1.0d) {
            this.f733c = 1;
        } else if (sin2 <= -1.0d) {
            this.f733c = 0;
        } else {
            double acos = (double) ((float) (Math.acos(sin2) / 6.283185307179586d));
            this.f731a = Math.round((round + acos) * 8.64E7d) + 946728000000L;
            long round2 = Math.round((round - acos) * 8.64E7d) + 946728000000L;
            this.f732b = round2;
            if (round2 >= j5 || this.f731a <= j5) {
                this.f733c = 1;
                return;
            } else {
                this.f733c = 0;
                return;
            }
        }
        this.f731a = -1;
        this.f732b = -1;
    }
}
