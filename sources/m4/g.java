package m4;

import i4.d;
import i4.h;
import i4.o;
import i4.s;
import i4.x;
import i4.z;
import java.util.List;
import l4.c;

public final class g implements s.a {

    /* renamed from: a  reason: collision with root package name */
    private final List<s> f5913a;

    /* renamed from: b  reason: collision with root package name */
    private final l4.g f5914b;

    /* renamed from: c  reason: collision with root package name */
    private final c f5915c;

    /* renamed from: d  reason: collision with root package name */
    private final c f5916d;

    /* renamed from: e  reason: collision with root package name */
    private final int f5917e;

    /* renamed from: f  reason: collision with root package name */
    private final x f5918f;

    /* renamed from: g  reason: collision with root package name */
    private final d f5919g;

    /* renamed from: h  reason: collision with root package name */
    private final o f5920h;

    /* renamed from: i  reason: collision with root package name */
    private final int f5921i;

    /* renamed from: j  reason: collision with root package name */
    private final int f5922j;

    /* renamed from: k  reason: collision with root package name */
    private final int f5923k;

    /* renamed from: l  reason: collision with root package name */
    private int f5924l;

    public g(List<s> list, l4.g gVar, c cVar, c cVar2, int i5, x xVar, d dVar, o oVar, int i6, int i7, int i8) {
        this.f5913a = list;
        this.f5916d = cVar2;
        this.f5914b = gVar;
        this.f5915c = cVar;
        this.f5917e = i5;
        this.f5918f = xVar;
        this.f5919g = dVar;
        this.f5920h = oVar;
        this.f5921i = i6;
        this.f5922j = i7;
        this.f5923k = i8;
    }

    public int a() {
        return this.f5921i;
    }

    public z b(x xVar) {
        return j(xVar, this.f5914b, this.f5915c, this.f5916d);
    }

    public int c() {
        return this.f5922j;
    }

    public int d() {
        return this.f5923k;
    }

    public x e() {
        return this.f5918f;
    }

    public d f() {
        return this.f5919g;
    }

    public h g() {
        return this.f5916d;
    }

    public o h() {
        return this.f5920h;
    }

    public c i() {
        return this.f5915c;
    }

    public z j(x xVar, l4.g gVar, c cVar, c cVar2) {
        if (this.f5917e < this.f5913a.size()) {
            this.f5924l++;
            if (this.f5915c != null && !this.f5916d.s(xVar.h())) {
                throw new IllegalStateException("network interceptor " + this.f5913a.get(this.f5917e - 1) + " must retain the same host and port");
            } else if (this.f5915c == null || this.f5924l <= 1) {
                g gVar2 = new g(this.f5913a, gVar, cVar, cVar2, this.f5917e + 1, xVar, this.f5919g, this.f5920h, this.f5921i, this.f5922j, this.f5923k);
                s sVar = this.f5913a.get(this.f5917e);
                z a5 = sVar.a(gVar2);
                if (cVar != null && this.f5917e + 1 < this.f5913a.size() && gVar2.f5924l != 1) {
                    throw new IllegalStateException("network interceptor " + sVar + " must call proceed() exactly once");
                } else if (a5 == null) {
                    throw new NullPointerException("interceptor " + sVar + " returned null");
                } else if (a5.b() != null) {
                    return a5;
                } else {
                    throw new IllegalStateException("interceptor " + sVar + " returned a response with no body");
                }
            } else {
                throw new IllegalStateException("network interceptor " + this.f5913a.get(this.f5917e - 1) + " must call proceed() exactly once");
            }
        } else {
            throw new AssertionError();
        }
    }

    public l4.g k() {
        return this.f5914b;
    }
}
