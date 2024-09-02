package i4;

import j4.c;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

public final class j {

    /* renamed from: e  reason: collision with root package name */
    private static final g[] f5094e;

    /* renamed from: f  reason: collision with root package name */
    private static final g[] f5095f;

    /* renamed from: g  reason: collision with root package name */
    public static final j f5096g;

    /* renamed from: h  reason: collision with root package name */
    public static final j f5097h;

    /* renamed from: i  reason: collision with root package name */
    public static final j f5098i;

    /* renamed from: j  reason: collision with root package name */
    public static final j f5099j = new a(false).a();

    /* renamed from: a  reason: collision with root package name */
    final boolean f5100a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f5101b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    final String[] f5102c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    final String[] f5103d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f5104a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        String[] f5105b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        String[] f5106c;

        /* renamed from: d  reason: collision with root package name */
        boolean f5107d;

        public a(j jVar) {
            this.f5104a = jVar.f5100a;
            this.f5105b = jVar.f5102c;
            this.f5106c = jVar.f5103d;
            this.f5107d = jVar.f5101b;
        }

        a(boolean z4) {
            this.f5104a = z4;
        }

        public j a() {
            return new j(this);
        }

        public a b(g... gVarArr) {
            if (this.f5104a) {
                String[] strArr = new String[gVarArr.length];
                for (int i5 = 0; i5 < gVarArr.length; i5++) {
                    strArr[i5] = gVarArr[i5].f5085a;
                }
                return c(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a c(String... strArr) {
            if (!this.f5104a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.f5105b = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        public a d(boolean z4) {
            if (this.f5104a) {
                this.f5107d = z4;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public a e(c0... c0VarArr) {
            if (this.f5104a) {
                String[] strArr = new String[c0VarArr.length];
                for (int i5 = 0; i5 < c0VarArr.length; i5++) {
                    strArr[i5] = c0VarArr[i5].f5007e;
                }
                return f(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a f(String... strArr) {
            if (!this.f5104a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.f5106c = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }
    }

    static {
        g gVar = g.f5056n1;
        g gVar2 = g.f5059o1;
        g gVar3 = g.f5062p1;
        g gVar4 = g.f5065q1;
        g gVar5 = g.f5068r1;
        g gVar6 = g.Z0;
        g gVar7 = g.f5026d1;
        g gVar8 = g.f5017a1;
        g gVar9 = g.f5029e1;
        g gVar10 = g.f5047k1;
        g gVar11 = g.f5044j1;
        g[] gVarArr = {gVar, gVar2, gVar3, gVar4, gVar5, gVar6, gVar7, gVar8, gVar9, gVar10, gVar11};
        f5094e = gVarArr;
        g[] gVarArr2 = {gVar, gVar2, gVar3, gVar4, gVar5, gVar6, gVar7, gVar8, gVar9, gVar10, gVar11, g.K0, g.L0, g.f5040i0, g.f5043j0, g.G, g.K, g.f5045k};
        f5095f = gVarArr2;
        a b5 = new a(true).b(gVarArr);
        c0 c0Var = c0.TLS_1_3;
        c0 c0Var2 = c0.TLS_1_2;
        f5096g = b5.e(c0Var, c0Var2).d(true).a();
        a b6 = new a(true).b(gVarArr2);
        c0 c0Var3 = c0.TLS_1_0;
        f5097h = b6.e(c0Var, c0Var2, c0.TLS_1_1, c0Var3).d(true).a();
        f5098i = new a(true).b(gVarArr2).e(c0Var3).d(true).a();
    }

    j(a aVar) {
        this.f5100a = aVar.f5104a;
        this.f5102c = aVar.f5105b;
        this.f5103d = aVar.f5106c;
        this.f5101b = aVar.f5107d;
    }

    private j e(SSLSocket sSLSocket, boolean z4) {
        String[] x4 = this.f5102c != null ? c.x(g.f5018b, sSLSocket.getEnabledCipherSuites(), this.f5102c) : sSLSocket.getEnabledCipherSuites();
        String[] x5 = this.f5103d != null ? c.x(c.f5491q, sSLSocket.getEnabledProtocols(), this.f5103d) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int u5 = c.u(g.f5018b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z4 && u5 != -1) {
            x4 = c.g(x4, supportedCipherSuites[u5]);
        }
        return new a(this).c(x4).f(x5).a();
    }

    /* access modifiers changed from: package-private */
    public void a(SSLSocket sSLSocket, boolean z4) {
        j e5 = e(sSLSocket, z4);
        String[] strArr = e5.f5103d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = e5.f5102c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    @Nullable
    public List<g> b() {
        String[] strArr = this.f5102c;
        if (strArr != null) {
            return g.b(strArr);
        }
        return null;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (!this.f5100a) {
            return false;
        }
        String[] strArr = this.f5103d;
        if (strArr != null && !c.z(c.f5491q, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f5102c;
        return strArr2 == null || c.z(g.f5018b, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public boolean d() {
        return this.f5100a;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        j jVar = (j) obj;
        boolean z4 = this.f5100a;
        if (z4 != jVar.f5100a) {
            return false;
        }
        return !z4 || (Arrays.equals(this.f5102c, jVar.f5102c) && Arrays.equals(this.f5103d, jVar.f5103d) && this.f5101b == jVar.f5101b);
    }

    public boolean f() {
        return this.f5101b;
    }

    @Nullable
    public List<c0> g() {
        String[] strArr = this.f5103d;
        if (strArr != null) {
            return c0.f(strArr);
        }
        return null;
    }

    public int hashCode() {
        if (this.f5100a) {
            return ((((527 + Arrays.hashCode(this.f5102c)) * 31) + Arrays.hashCode(this.f5103d)) * 31) + (this.f5101b ^ true ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f5100a) {
            return "ConnectionSpec()";
        }
        String str = "[all enabled]";
        String obj = this.f5102c != null ? b().toString() : str;
        if (this.f5103d != null) {
            str = g().toString();
        }
        return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + str + ", supportsTlsExtensions=" + this.f5101b + ")";
    }
}
