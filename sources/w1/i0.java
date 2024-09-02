package w1;

import m2.o;
import r1.q;
import v1.r;
import y1.d0;
import y1.f0;
import z1.d;
import z1.g;

public class i0 implements d0 {

    /* renamed from: a  reason: collision with root package name */
    private final f0 f7515a;

    /* renamed from: b  reason: collision with root package name */
    private final g f7516b;

    /* renamed from: c  reason: collision with root package name */
    private final a0 f7517c;

    /* renamed from: d  reason: collision with root package name */
    private final b f7518d;

    i0(f0 f0Var, g gVar, a0 a0Var, b bVar) {
        this.f7515a = f0Var;
        this.f7516b = gVar;
        this.f7517c = a0Var;
        this.f7518d = bVar;
    }

    private static boolean b(d[] dVarArr) {
        boolean z4 = true;
        for (d b5 : dVarArr) {
            z4 &= b5.b();
        }
        return !z4;
    }

    public c0 a(g gVar, d... dVarArr) {
        boolean b5 = b(dVarArr);
        boolean z4 = gVar.b() != 1;
        o<q, q> a5 = d0.a();
        if (z4 && !b5) {
            q.b("ScanSettings.callbackType != CALLBACK_TYPE_ALL_MATCHES but no (or only empty) filters are specified. Falling back to callbackType emulation.", new Object[0]);
            a5 = this.f7517c.a(gVar.b());
            gVar = gVar.a(1);
        }
        return new c0(new r(this.f7515a, this.f7516b, this.f7518d, gVar, new f(new r[0]), dVarArr), a5);
    }
}
