package i4;

import i4.q;
import java.io.Closeable;
import javax.annotation.Nullable;

public final class z implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    final x f5236e;

    /* renamed from: f  reason: collision with root package name */
    final v f5237f;

    /* renamed from: g  reason: collision with root package name */
    final int f5238g;

    /* renamed from: h  reason: collision with root package name */
    final String f5239h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    final p f5240i;

    /* renamed from: j  reason: collision with root package name */
    final q f5241j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    final a0 f5242k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    final z f5243l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    final z f5244m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    final z f5245n;

    /* renamed from: o  reason: collision with root package name */
    final long f5246o;

    /* renamed from: p  reason: collision with root package name */
    final long f5247p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    private volatile c f5248q;

    public static class a {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        x f5249a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        v f5250b;

        /* renamed from: c  reason: collision with root package name */
        int f5251c;

        /* renamed from: d  reason: collision with root package name */
        String f5252d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        p f5253e;

        /* renamed from: f  reason: collision with root package name */
        q.a f5254f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        a0 f5255g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        z f5256h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        z f5257i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        z f5258j;

        /* renamed from: k  reason: collision with root package name */
        long f5259k;

        /* renamed from: l  reason: collision with root package name */
        long f5260l;

        public a() {
            this.f5251c = -1;
            this.f5254f = new q.a();
        }

        a(z zVar) {
            this.f5251c = -1;
            this.f5249a = zVar.f5236e;
            this.f5250b = zVar.f5237f;
            this.f5251c = zVar.f5238g;
            this.f5252d = zVar.f5239h;
            this.f5253e = zVar.f5240i;
            this.f5254f = zVar.f5241j.f();
            this.f5255g = zVar.f5242k;
            this.f5256h = zVar.f5243l;
            this.f5257i = zVar.f5244m;
            this.f5258j = zVar.f5245n;
            this.f5259k = zVar.f5246o;
            this.f5260l = zVar.f5247p;
        }

        private void e(z zVar) {
            if (zVar.f5242k != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        private void f(String str, z zVar) {
            if (zVar.f5242k != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (zVar.f5243l != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (zVar.f5244m != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (zVar.f5245n != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public a a(String str, String str2) {
            this.f5254f.a(str, str2);
            return this;
        }

        public a b(@Nullable a0 a0Var) {
            this.f5255g = a0Var;
            return this;
        }

        public z c() {
            if (this.f5249a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f5250b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f5251c < 0) {
                throw new IllegalStateException("code < 0: " + this.f5251c);
            } else if (this.f5252d != null) {
                return new z(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }

        public a d(@Nullable z zVar) {
            if (zVar != null) {
                f("cacheResponse", zVar);
            }
            this.f5257i = zVar;
            return this;
        }

        public a g(int i5) {
            this.f5251c = i5;
            return this;
        }

        public a h(@Nullable p pVar) {
            this.f5253e = pVar;
            return this;
        }

        public a i(String str, String str2) {
            this.f5254f.f(str, str2);
            return this;
        }

        public a j(q qVar) {
            this.f5254f = qVar.f();
            return this;
        }

        public a k(String str) {
            this.f5252d = str;
            return this;
        }

        public a l(@Nullable z zVar) {
            if (zVar != null) {
                f("networkResponse", zVar);
            }
            this.f5256h = zVar;
            return this;
        }

        public a m(@Nullable z zVar) {
            if (zVar != null) {
                e(zVar);
            }
            this.f5258j = zVar;
            return this;
        }

        public a n(v vVar) {
            this.f5250b = vVar;
            return this;
        }

        public a o(long j5) {
            this.f5260l = j5;
            return this;
        }

        public a p(x xVar) {
            this.f5249a = xVar;
            return this;
        }

        public a q(long j5) {
            this.f5259k = j5;
            return this;
        }
    }

    z(a aVar) {
        this.f5236e = aVar.f5249a;
        this.f5237f = aVar.f5250b;
        this.f5238g = aVar.f5251c;
        this.f5239h = aVar.f5252d;
        this.f5240i = aVar.f5253e;
        this.f5241j = aVar.f5254f.d();
        this.f5242k = aVar.f5255g;
        this.f5243l = aVar.f5256h;
        this.f5244m = aVar.f5257i;
        this.f5245n = aVar.f5258j;
        this.f5246o = aVar.f5259k;
        this.f5247p = aVar.f5260l;
    }

    @Nullable
    public a0 b() {
        return this.f5242k;
    }

    public void close() {
        a0 a0Var = this.f5242k;
        if (a0Var != null) {
            a0Var.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public c d() {
        c cVar = this.f5248q;
        if (cVar != null) {
            return cVar;
        }
        c k5 = c.k(this.f5241j);
        this.f5248q = k5;
        return k5;
    }

    public int e() {
        return this.f5238g;
    }

    @Nullable
    public p f() {
        return this.f5240i;
    }

    @Nullable
    public String g(String str) {
        return h(str, (String) null);
    }

    @Nullable
    public String h(String str, @Nullable String str2) {
        String c5 = this.f5241j.c(str);
        return c5 != null ? c5 : str2;
    }

    public q j() {
        return this.f5241j;
    }

    public a l() {
        return new a(this);
    }

    @Nullable
    public z m() {
        return this.f5245n;
    }

    public long n() {
        return this.f5247p;
    }

    public x p() {
        return this.f5236e;
    }

    public long q() {
        return this.f5246o;
    }

    public String toString() {
        return "Response{protocol=" + this.f5237f + ", code=" + this.f5238g + ", message=" + this.f5239h + ", url=" + this.f5236e.h() + '}';
    }
}
