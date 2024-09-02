package kotlinx.coroutines.internal;

import c4.n0;
import c4.v1;
import com.yalantis.ucrop.BuildConfig;
import m3.d;
import o3.g;

final class u extends v1 implements n0 {

    /* renamed from: g  reason: collision with root package name */
    private final Throwable f5634g;

    /* renamed from: h  reason: collision with root package name */
    private final String f5635h;

    public u(Throwable th, String str) {
        this.f5634g = th;
        this.f5635h = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0023, code lost:
        if (r1 == null) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Void S() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.f5634g
            if (r0 == 0) goto L_0x0036
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.f5635h
            if (r1 == 0) goto L_0x0025
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 != 0) goto L_0x0027
        L_0x0025:
            java.lang.String r1 = ""
        L_0x0027:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.f5634g
            r1.<init>(r0, r2)
            throw r1
        L_0x0036:
            kotlinx.coroutines.internal.t.d()
            m3.d r0 = new m3.d
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.u.S():java.lang.Void");
    }

    public boolean N(g gVar) {
        S();
        throw new d();
    }

    public v1 P() {
        return this;
    }

    /* renamed from: R */
    public Void M(g gVar, Runnable runnable) {
        S();
        throw new d();
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.f5634g != null) {
            str = ", cause=" + this.f5634g;
        } else {
            str = BuildConfig.FLAVOR;
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }
}
