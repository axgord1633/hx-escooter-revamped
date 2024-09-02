package i4;

import i4.q;
import j4.c;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import m4.f;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    final r f5222a;

    /* renamed from: b  reason: collision with root package name */
    final String f5223b;

    /* renamed from: c  reason: collision with root package name */
    final q f5224c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    final y f5225d;

    /* renamed from: e  reason: collision with root package name */
    final Map<Class<?>, Object> f5226e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private volatile c f5227f;

    public static class a {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        r f5228a;

        /* renamed from: b  reason: collision with root package name */
        String f5229b;

        /* renamed from: c  reason: collision with root package name */
        q.a f5230c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        y f5231d;

        /* renamed from: e  reason: collision with root package name */
        Map<Class<?>, Object> f5232e;

        public a() {
            this.f5232e = Collections.emptyMap();
            this.f5229b = "GET";
            this.f5230c = new q.a();
        }

        a(x xVar) {
            this.f5232e = Collections.emptyMap();
            this.f5228a = xVar.f5222a;
            this.f5229b = xVar.f5223b;
            this.f5231d = xVar.f5225d;
            this.f5232e = xVar.f5226e.isEmpty() ? Collections.emptyMap() : new LinkedHashMap<>(xVar.f5226e);
            this.f5230c = xVar.f5224c.f();
        }

        public x a() {
            if (this.f5228a != null) {
                return new x(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a b(String str, String str2) {
            this.f5230c.f(str, str2);
            return this;
        }

        public a c(q qVar) {
            this.f5230c = qVar.f();
            return this;
        }

        public a d(String str, @Nullable y yVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (yVar != null && !f.b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (yVar != null || !f.e(str)) {
                this.f5229b = str;
                this.f5231d = yVar;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        public a e(String str) {
            this.f5230c.e(str);
            return this;
        }

        public a f(r rVar) {
            if (rVar != null) {
                this.f5228a = rVar;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public a g(String str) {
            StringBuilder sb;
            int i5;
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    sb = new StringBuilder();
                    sb.append("http:");
                    i5 = 3;
                } else {
                    if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                        sb = new StringBuilder();
                        sb.append("https:");
                        i5 = 4;
                    }
                    return f(r.k(str));
                }
                sb.append(str.substring(i5));
                str = sb.toString();
                return f(r.k(str));
            }
            throw new NullPointerException("url == null");
        }
    }

    x(a aVar) {
        this.f5222a = aVar.f5228a;
        this.f5223b = aVar.f5229b;
        this.f5224c = aVar.f5230c.d();
        this.f5225d = aVar.f5231d;
        this.f5226e = c.t(aVar.f5232e);
    }

    @Nullable
    public y a() {
        return this.f5225d;
    }

    public c b() {
        c cVar = this.f5227f;
        if (cVar != null) {
            return cVar;
        }
        c k5 = c.k(this.f5224c);
        this.f5227f = k5;
        return k5;
    }

    @Nullable
    public String c(String str) {
        return this.f5224c.c(str);
    }

    public q d() {
        return this.f5224c;
    }

    public boolean e() {
        return this.f5222a.m();
    }

    public String f() {
        return this.f5223b;
    }

    public a g() {
        return new a(this);
    }

    public r h() {
        return this.f5222a;
    }

    public String toString() {
        return "Request{method=" + this.f5223b + ", url=" + this.f5222a + ", tags=" + this.f5226e + '}';
    }
}
