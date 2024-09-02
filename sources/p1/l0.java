package p1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import m2.k;
import m2.n;
import p1.a;
import p1.e0;
import p1.g0;
import r1.o;
import r2.f;
import w1.c0;
import w1.d0;
import w1.q;
import w1.s;
import x1.a;
import y1.c;
import y1.f0;
import y1.h0;
import y1.j;
import y1.p;
import y1.r;
import y1.w;
import z1.d;
import z1.g;

class l0 extends g0 {

    /* renamed from: a  reason: collision with root package name */
    final a f6470a;

    /* renamed from: b  reason: collision with root package name */
    private final h0 f6471b;

    /* renamed from: c  reason: collision with root package name */
    private final o f6472c;

    /* renamed from: d  reason: collision with root package name */
    final d0 f6473d;

    /* renamed from: e  reason: collision with root package name */
    final s f6474e;

    /* renamed from: f  reason: collision with root package name */
    final f<q, z1.f> f6475f;

    /* renamed from: g  reason: collision with root package name */
    private final a.b f6476g;

    /* renamed from: h  reason: collision with root package name */
    final m2.q f6477h;

    /* renamed from: i  reason: collision with root package name */
    final Map<Set<UUID>, k<Object>> f6478i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    private final c f6479j;

    /* renamed from: k  reason: collision with root package name */
    private final f0 f6480k;

    /* renamed from: l  reason: collision with root package name */
    private final k<e0.b> f6481l;

    /* renamed from: m  reason: collision with root package name */
    private final w f6482m;

    /* renamed from: n  reason: collision with root package name */
    private final f0.a<r> f6483n;

    /* renamed from: o  reason: collision with root package name */
    private final z1.a f6484o;

    /* renamed from: p  reason: collision with root package name */
    private final p f6485p;

    /* renamed from: q  reason: collision with root package name */
    private final j f6486q;

    l0(c cVar, f0 f0Var, x1.a aVar, k<e0.b> kVar, h0 h0Var, w wVar, f0.a<r> aVar2, o oVar, d0 d0Var, s sVar, f<q, z1.f> fVar, m2.q qVar, a.b bVar, z1.a aVar3, p pVar, j jVar) {
        this.f6470a = aVar;
        this.f6479j = cVar;
        this.f6480k = f0Var;
        this.f6481l = kVar;
        this.f6471b = h0Var;
        this.f6482m = wVar;
        this.f6483n = aVar2;
        this.f6472c = oVar;
        this.f6473d = d0Var;
        this.f6474e = sVar;
        this.f6475f = fVar;
        this.f6477h = qVar;
        this.f6476g = bVar;
        this.f6484o = aVar3;
        this.f6485p = pVar;
        this.f6486q = jVar;
    }

    private void l() {
        if (!this.f6480k.b()) {
            throw new UnsupportedOperationException("RxAndroidBle library needs a BluetoothAdapter to be available in the system to work. If this is a test on an emulator then you can use 'https://github.com/Polidea/RxAndroidBle/tree/master/mockrxandroidble'");
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean m(e0.b bVar) {
        return bVar != e0.b.f6447c;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void o(z1.f fVar) {
        if (r1.q.i()) {
            r1.q.k("%s", fVar);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ n p(g gVar, d[] dVarArr) {
        this.f6474e.a(gVar.h());
        c0 a5 = this.f6473d.a(gVar, dVarArr);
        return this.f6470a.a(a5.f7481a).K0(this.f6477h).j(a5.f7482b).Z(this.f6475f).z(new i0()).d0(k());
    }

    public p0 b(String str) {
        l();
        return this.f6472c.a(str);
    }

    public g0.a c() {
        return !this.f6480k.b() ? g0.a.BLUETOOTH_NOT_AVAILABLE : !this.f6482m.a() ? g0.a.LOCATION_PERMISSION_NOT_GRANTED : !this.f6480k.c() ? g0.a.BLUETOOTH_NOT_ENABLED : !this.f6482m.b() ? g0.a.LOCATION_SERVICES_NOT_ENABLED : g0.a.READY;
    }

    public k<g0.a> d() {
        return this.f6483n.get();
    }

    public k<z1.f> e(g gVar, d... dVarArr) {
        return k.o(new h0(this, gVar, dVarArr));
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        this.f6476g.a();
        super.finalize();
    }

    /* access modifiers changed from: package-private */
    public <T> k<T> k() {
        return this.f6481l.I(new j0()).K().d(new k0()).h();
    }
}
