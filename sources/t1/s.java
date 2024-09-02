package t1;

import android.bluetooth.BluetoothGatt;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import m2.k;
import m2.n;
import m2.q;
import p1.n0;
import p1.z;
import t1.c;
import x1.a;

public class s implements n {

    /* renamed from: a  reason: collision with root package name */
    private final a f6985a;

    /* renamed from: b  reason: collision with root package name */
    final c.a f6986b;

    /* renamed from: c  reason: collision with root package name */
    final q f6987c;

    public s(a aVar, c.a aVar2, q qVar) {
        this.f6985a = aVar;
        this.f6986b = aVar2;
        this.f6987c = qVar;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void f(Set set, p2.c cVar) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((m) it.next()).c();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void g(Set set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((m) it.next()).b();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ n h(z zVar) {
        c build = this.f6986b.a(zVar.f6543a).b(zVar.f6544b).c(zVar.f6545c).build();
        Set<m> a5 = build.a();
        return j(build).d0(i(build)).s(e(build)).A(new p(a5)).v(new q(a5)).w0(this.f6987c).K0(this.f6987c);
    }

    static k<n0> i(c cVar) {
        return cVar.d().l();
    }

    static k<n0> j(c cVar) {
        Objects.requireNonNull(cVar);
        return k.T(new r(cVar));
    }

    public k<n0> a(z zVar) {
        return k.o(new o(this, zVar));
    }

    /* access modifiers changed from: package-private */
    public k<BluetoothGatt> e(c cVar) {
        return this.f6985a.a(cVar.c());
    }
}
