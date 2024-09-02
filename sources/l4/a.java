package l4;

import i4.s;
import i4.u;
import i4.x;
import i4.z;
import m4.g;

public final class a implements s {

    /* renamed from: a  reason: collision with root package name */
    public final u f5770a;

    public a(u uVar) {
        this.f5770a = uVar;
    }

    public z a(s.a aVar) {
        g gVar = (g) aVar;
        x e5 = gVar.e();
        g k5 = gVar.k();
        return gVar.j(e5, k5, k5.i(this.f5770a, aVar, !e5.f().equals("GET")), k5.d());
    }
}
