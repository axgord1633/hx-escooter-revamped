package p1;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.content.ContentResolver;
import android.content.Context;
import android.location.LocationManager;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import m2.q;
import p1.a;
import p1.n0;
import r1.b;
import r1.o;
import t1.c;
import t1.e1;
import t1.g1;
import t1.h1;
import t1.i1;
import t1.j1;
import t1.k0;
import t1.l1;
import t1.m0;
import t1.m1;
import t1.n1;
import t1.p0;
import t1.r0;
import v1.x;
import w1.d0;
import w1.e0;
import w1.g0;
import w1.h;
import w1.h0;
import w1.i;
import w1.i0;
import w1.j0;
import w1.k;
import w1.s;
import w1.t;
import w1.v;
import y1.b0;
import y1.c0;
import y1.f0;
import y1.j;
import y1.l;
import y1.m;
import y1.n;
import y1.p;
import y1.r;
import y1.u;
import y1.w;
import y1.y;
import y1.z;

public final class a0 {

    private static final class b implements a.C0098a {

        /* renamed from: a  reason: collision with root package name */
        private Context f6347a;

        private b() {
        }

        /* renamed from: b */
        public b a(Context context) {
            this.f6347a = (Context) g0.e.b(context);
            return this;
        }

        public a build() {
            g0.e.a(this.f6347a, Context.class);
            return new c(this.f6347a);
        }
    }

    private static final class c implements a {
        private h0.a<s1.b> A;
        private h0.a<b.a> B;
        private h0.a<o> C;
        private h0.a<k> D;
        private h0.a<w1.g> E;
        private h0.a<w1.a0> F;
        private h0.a<e0> G;
        private h0.a<w1.b> H;
        private h0.a<g0> I;
        private h0.a<i0> J;
        private h0.a<d0> K;
        private h0.a<t> L;
        private h0.a<v> M;
        private h0.a<s> N;
        private h0.a<i> O;
        /* access modifiers changed from: private */
        public h0.a<q> P;
        /* access modifiers changed from: private */
        public h0.a<ExecutorService> Q;
        private h0.a<a.b> R;
        private h0.a<w1.d> S;
        private h0.a<String[][]> T;
        /* access modifiers changed from: private */
        public h0.a<j> U;
        private h0.a<l0> V;
        private h0.a<g0> W;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final Context f6348a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final c f6349b;

        /* renamed from: c  reason: collision with root package name */
        private h0.a<Context> f6350c;

        /* renamed from: d  reason: collision with root package name */
        private h0.a<ContentResolver> f6351d;

        /* renamed from: e  reason: collision with root package name */
        private h0.a<LocationManager> f6352e;

        /* renamed from: f  reason: collision with root package name */
        private h0.a<l> f6353f;

        /* renamed from: g  reason: collision with root package name */
        private h0.a<n> f6354g;

        /* renamed from: h  reason: collision with root package name */
        private h0.a<Integer> f6355h;

        /* renamed from: i  reason: collision with root package name */
        private h0.a<Boolean> f6356i;

        /* renamed from: j  reason: collision with root package name */
        private h0.a<String[][]> f6357j;

        /* renamed from: k  reason: collision with root package name */
        private h0.a<p> f6358k;

        /* renamed from: l  reason: collision with root package name */
        private h0.a<Boolean> f6359l;

        /* renamed from: m  reason: collision with root package name */
        private h0.a<z> f6360m;

        /* renamed from: n  reason: collision with root package name */
        private h0.a<b0> f6361n;
        /* access modifiers changed from: private */

        /* renamed from: o  reason: collision with root package name */
        public h0.a<BluetoothManager> f6362o;

        /* renamed from: p  reason: collision with root package name */
        private h0.a<y1.c> f6363p;
        /* access modifiers changed from: private */

        /* renamed from: q  reason: collision with root package name */
        public h0.a<f0> f6364q;

        /* renamed from: r  reason: collision with root package name */
        private h0.a<ExecutorService> f6365r;
        /* access modifiers changed from: private */

        /* renamed from: s  reason: collision with root package name */
        public h0.a<q> f6366s;

        /* renamed from: t  reason: collision with root package name */
        private h0.a<x1.b> f6367t;
        /* access modifiers changed from: private */

        /* renamed from: u  reason: collision with root package name */
        public h0.a<x1.a> f6368u;
        /* access modifiers changed from: private */

        /* renamed from: v  reason: collision with root package name */
        public h0.a<e0> f6369v;

        /* renamed from: w  reason: collision with root package name */
        private h0.a<w> f6370w;

        /* renamed from: x  reason: collision with root package name */
        private h0.a<u> f6371x;

        /* renamed from: y  reason: collision with root package name */
        private h0.a<m2.k<Boolean>> f6372y;

        /* renamed from: z  reason: collision with root package name */
        private h0.a<r> f6373z;

        class a implements h0.a<b.a> {
            a() {
            }

            /* renamed from: a */
            public b.a get() {
                return new f(c.this.f6349b);
            }
        }

        private c(Context context) {
            this.f6349b = this;
            this.f6348a = context;
            m(context);
        }

        private void m(Context context) {
            g0.c a5 = g0.d.a(context);
            this.f6350c = a5;
            this.f6351d = i.a(a5);
            r a6 = r.a(this.f6350c);
            this.f6352e = a6;
            this.f6353f = m.a(this.f6351d, a6);
            this.f6354g = g0.b.b(y1.o.a(this.f6350c));
            this.f6355h = y.a(this.f6350c);
            this.f6356i = g0.b.b(q.a(this.f6350c));
            v a7 = v.a(j.a(), this.f6355h, this.f6356i);
            this.f6357j = a7;
            this.f6358k = g0.b.b(y1.q.a(this.f6354g, a7));
            this.f6359l = o.a(this.f6350c, j.a());
            this.f6360m = y1.a0.a(this.f6353f, this.f6358k, this.f6355h, j.a(), this.f6359l);
            this.f6361n = c0.a(this.f6353f, this.f6358k, this.f6359l, this.f6356i);
            f a8 = f.a(this.f6350c);
            this.f6362o = a8;
            this.f6363p = y1.d.a(a8);
            this.f6364q = y1.g0.a(b.a());
            h0.a<ExecutorService> b5 = g0.b.b(d.a());
            this.f6365r = b5;
            h0.a<q> b6 = g0.b.b(e.a(b5));
            this.f6366s = b6;
            x1.c a9 = x1.c.a(b6);
            this.f6367t = a9;
            this.f6368u = g0.b.b(a9);
            this.f6369v = f0.a(this.f6350c);
            t a10 = t.a(j.a(), y.a(), this.f6360m, this.f6361n);
            this.f6370w = a10;
            this.f6371x = y1.v.a(this.f6350c, a10);
            s a11 = s.a(j.a(), this.f6371x);
            this.f6372y = a11;
            this.f6373z = y1.s.a(this.f6364q, this.f6369v, a11, this.f6370w, g.a());
            this.A = g0.b.b(s1.c.a());
            a aVar = new a();
            this.B = aVar;
            this.C = g0.b.b(r1.p.a(this.A, aVar));
            this.D = g0.b.b(p.a(j.a(), w1.m.a(), w1.p.a()));
            this.E = g0.b.b(h.a(y1.i0.a(), this.D));
            w1.b0 a12 = w1.b0.a(g.a());
            this.F = a12;
            this.G = w1.f0.a(this.f6364q, this.E, a12);
            w1.c a13 = w1.c.a(j.a());
            this.H = a13;
            this.I = h0.a(this.f6364q, this.E, this.F, a13);
            this.J = j0.a(this.f6364q, this.E, this.F, this.H);
            this.K = g0.b.b(x.a(j.a(), this.G, this.I, this.J));
            w1.u a14 = w1.u.a(this.f6364q, this.f6370w);
            this.L = a14;
            this.M = w1.w.a(a14, g.a());
            this.N = w.a(j.a(), this.L, this.M);
            this.O = w1.j.a(this.C);
            this.P = g0.b.b(c.a());
            h0.a<ExecutorService> b7 = g0.b.b(h.a());
            this.Q = b7;
            this.R = n.a(this.f6365r, this.P, b7);
            this.S = w1.e.a(this.f6364q, this.H, this.E, this.O);
            u a15 = u.a(j.a(), this.f6355h);
            this.T = a15;
            this.U = g0.b.b(y1.k.a(this.f6354g, a15));
            m0 a16 = m0.a(this.f6363p, this.f6364q, this.f6368u, this.f6369v, y1.i0.a(), this.f6370w, this.f6373z, this.C, this.K, this.N, this.O, this.f6366s, this.R, this.S, this.f6358k, this.U);
            this.V = a16;
            this.W = g0.b.b(a16);
        }

        /* access modifiers changed from: private */
        public f0 n() {
            return new f0(a.c.a());
        }

        public g0 a() {
            return this.W.get();
        }
    }

    private static final class d implements c.a {

        /* renamed from: a  reason: collision with root package name */
        private final c f6375a;

        /* renamed from: b  reason: collision with root package name */
        private final g f6376b;

        /* renamed from: c  reason: collision with root package name */
        private Boolean f6377c;

        /* renamed from: d  reason: collision with root package name */
        private Boolean f6378d;

        /* renamed from: e  reason: collision with root package name */
        private r0 f6379e;

        private d(c cVar, g gVar) {
            this.f6375a = cVar;
            this.f6376b = gVar;
        }

        public t1.c build() {
            Class<Boolean> cls = Boolean.class;
            g0.e.a(this.f6377c, cls);
            g0.e.a(this.f6378d, cls);
            g0.e.a(this.f6379e, r0.class);
            return new e(this.f6375a, this.f6376b, this.f6377c, this.f6378d, this.f6379e);
        }

        /* renamed from: d */
        public d a(boolean z4) {
            this.f6377c = (Boolean) g0.e.b(Boolean.valueOf(z4));
            return this;
        }

        /* renamed from: e */
        public d c(r0 r0Var) {
            this.f6379e = (r0) g0.e.b(r0Var);
            return this;
        }

        /* renamed from: f */
        public d b(boolean z4) {
            this.f6378d = (Boolean) g0.e.b(Boolean.valueOf(z4));
            return this;
        }
    }

    private static final class e implements t1.c {
        private h0.a<t1.b0> A;
        private h0.a<v1.g> B;
        private h0.a C;

        /* renamed from: a  reason: collision with root package name */
        private final Boolean f6380a;

        /* renamed from: b  reason: collision with root package name */
        private final c f6381b;

        /* renamed from: c  reason: collision with root package name */
        private final g f6382c;

        /* renamed from: d  reason: collision with root package name */
        private final e f6383d;

        /* renamed from: e  reason: collision with root package name */
        private h0.a<t1.a> f6384e;

        /* renamed from: f  reason: collision with root package name */
        private h0.a f6385f;

        /* renamed from: g  reason: collision with root package name */
        private h0.a<i1> f6386g;

        /* renamed from: h  reason: collision with root package name */
        private h0.a<x1.e> f6387h;

        /* renamed from: i  reason: collision with root package name */
        private h0.a<BluetoothGatt> f6388i;

        /* renamed from: j  reason: collision with root package name */
        private h0.a<u1.c> f6389j;

        /* renamed from: k  reason: collision with root package name */
        private h0.a<r0> f6390k;

        /* renamed from: l  reason: collision with root package name */
        private h0.a<x> f6391l;

        /* renamed from: m  reason: collision with root package name */
        private h0.a<v1.n> f6392m;

        /* renamed from: n  reason: collision with root package name */
        private h0.a<v1.l> f6393n;

        /* renamed from: o  reason: collision with root package name */
        private h0.a f6394o;

        /* renamed from: p  reason: collision with root package name */
        private h0.a f6395p;

        /* renamed from: q  reason: collision with root package name */
        private h0.a f6396q;

        /* renamed from: r  reason: collision with root package name */
        private h0.a f6397r;

        /* renamed from: s  reason: collision with root package name */
        private h0.a<g1> f6398s;

        /* renamed from: t  reason: collision with root package name */
        private h0.a f6399t;

        /* renamed from: u  reason: collision with root package name */
        private h0.a<t1.j0> f6400u;

        /* renamed from: v  reason: collision with root package name */
        private h0.a<Boolean> f6401v;

        /* renamed from: w  reason: collision with root package name */
        private h0.a<t1.e0> f6402w;

        /* renamed from: x  reason: collision with root package name */
        private h0.a<t1.h0> f6403x;

        /* renamed from: y  reason: collision with root package name */
        private h0.a<m1> f6404y;

        /* renamed from: z  reason: collision with root package name */
        private h0.a<t1.d0> f6405z;

        private e(c cVar, g gVar, Boolean bool, Boolean bool2, r0 r0Var) {
            this.f6383d = this;
            this.f6381b = cVar;
            this.f6382c = gVar;
            this.f6380a = bool;
            f(bool, bool2, r0Var);
        }

        private y1.b e() {
            return new y1.b(this.f6381b.f6348a);
        }

        private void f(Boolean bool, Boolean bool2, r0 r0Var) {
            this.f6384e = g0.b.b(t1.b.a());
            this.f6385f = g0.b.b(t1.a0.a(this.f6382c.f6411d, this.f6381b.f6364q, this.f6381b.f6369v));
            this.f6386g = g0.b.b(j1.a(this.f6381b.P, this.f6384e, this.f6385f, r0.a()));
            this.f6387h = g0.b.b(x1.f.a(this.f6382c.f6411d, this.f6385f, this.f6381b.Q, this.f6381b.f6366s));
            this.f6388i = t1.g.a(this.f6384e);
            this.f6389j = u1.d.a(t1.h.a());
            this.f6390k = g0.d.a(r0Var);
            t1.j a5 = t1.j.a(g.a(), this.f6390k);
            this.f6391l = a5;
            this.f6392m = v1.o.a(this.f6386g, this.f6388i, a5);
            v1.m a6 = v1.m.a(this.f6386g, this.f6388i, this.f6389j, this.f6391l, this.f6381b.f6366s, g.a(), this.f6392m);
            this.f6393n = a6;
            this.f6394o = g0.b.b(l1.a(this.f6387h, this.f6388i, a6));
            this.f6395p = g0.b.b(t1.v.a(this.f6387h, this.f6393n));
            this.f6396q = g0.b.b(e1.a(m.a(), l.a(), k.a(), this.f6388i, this.f6386g, this.f6395p));
            this.f6397r = g0.b.b(p0.a(this.f6386g, t1.f.a()));
            g0.a aVar = new g0.a();
            this.f6398s = aVar;
            h0.a b5 = g0.b.b(m0.a(aVar, t1.e.a()));
            this.f6399t = b5;
            this.f6400u = k0.a(this.f6387h, b5, this.f6398s, this.f6393n);
            this.f6401v = g0.d.a(bool2);
            t1.f0 a7 = t1.f0.a(t1.h.a());
            this.f6402w = a7;
            this.f6403x = t1.i0.a(a7);
            n1 a8 = n1.a(this.f6402w);
            this.f6404y = a8;
            t1.i a9 = t1.i.a(this.f6401v, this.f6403x, a8);
            this.f6405z = a9;
            this.A = t1.c0.a(a9);
            g0.a.a(this.f6398s, g0.b.b(h1.a(this.f6387h, this.f6386g, this.f6388i, this.f6394o, this.f6396q, this.f6397r, this.f6395p, this.f6393n, this.f6400u, this.f6381b.f6366s, this.A)));
            this.B = v1.h.a(this.f6386g, this.f6384e, this.f6382c.f6411d, this.f6381b.f6362o, this.f6381b.f6366s, this.f6382c.f6418k, this.f6382c.f6417j);
            this.C = g0.b.b(t1.x.a(this.f6381b.f6368u, this.B));
        }

        public Set<t1.m> a() {
            return g0.f.c(3).a((t1.m) this.f6397r.get()).a((t1.m) this.C.get()).a(this.f6387h.get()).b();
        }

        public n0 b() {
            return this.f6398s.get();
        }

        public v1.c c() {
            return v1.d.a(this.f6382c.i(), e(), this.f6386g.get(), this.f6384e.get(), this.f6382c.k(), this.f6380a.booleanValue(), (t1.l) this.f6382c.f6417j.get());
        }

        public i1 d() {
            return this.f6386g.get();
        }
    }

    private static final class f implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private final c f6406a;

        /* renamed from: b  reason: collision with root package name */
        private String f6407b;

        private f(c cVar) {
            this.f6406a = cVar;
        }

        /* renamed from: b */
        public f a(String str) {
            this.f6407b = (String) g0.e.b(str);
            return this;
        }

        public r1.b build() {
            g0.e.a(this.f6407b, String.class);
            return new g(this.f6406a, this.f6407b);
        }
    }

    private static final class g implements r1.b {

        /* renamed from: a  reason: collision with root package name */
        private final String f6408a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final c f6409b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final g f6410c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public h0.a<String> f6411d;

        /* renamed from: e  reason: collision with root package name */
        private h0.a<BluetoothDevice> f6412e;

        /* renamed from: f  reason: collision with root package name */
        private h0.a<c.a> f6413f;

        /* renamed from: g  reason: collision with root package name */
        private h0.a<t1.s> f6414g;

        /* renamed from: h  reason: collision with root package name */
        private h0.a<o1.b<n0.a>> f6415h;

        /* renamed from: i  reason: collision with root package name */
        private h0.a f6416i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public h0.a<t1.l> f6417j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public h0.a<x> f6418k;

        class a implements h0.a<c.a> {
            a() {
            }

            /* renamed from: a */
            public c.a get() {
                return new d(g.this.f6409b, g.this.f6410c);
            }
        }

        private g(c cVar, String str) {
            this.f6410c = this;
            this.f6409b = cVar;
            this.f6408a = str;
            j(str);
        }

        /* access modifiers changed from: private */
        public BluetoothDevice i() {
            return r1.d.c(this.f6408a, this.f6409b.n());
        }

        private void j(String str) {
            g0.c a5 = g0.d.a(str);
            this.f6411d = a5;
            this.f6412e = r1.d.a(a5, this.f6409b.f6364q);
            this.f6413f = new a();
            this.f6414g = t1.t.a(this.f6409b.f6368u, this.f6413f, this.f6409b.P);
            h0.a<o1.b<n0.a>> b5 = g0.b.b(r1.f.a());
            this.f6415h = b5;
            this.f6416i = g0.b.b(r1.n.a(this.f6412e, this.f6414g, b5, this.f6409b.U));
            this.f6417j = g0.b.b(r1.e.a(this.f6415h));
            this.f6418k = r1.h.a(g.a());
        }

        /* access modifiers changed from: private */
        public x k() {
            return r1.g.a(g.c());
        }

        public p0 a() {
            return (p0) this.f6416i.get();
        }
    }

    public static a.C0098a a() {
        return new b();
    }
}
