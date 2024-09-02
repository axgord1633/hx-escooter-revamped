package r1;

import h0.a;
import java.util.Map;
import p1.p0;
import r1.b;

public class o {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, b> f6700a;

    /* renamed from: b  reason: collision with root package name */
    private final a<b.a> f6701b;

    public o(s1.b bVar, a<b.a> aVar) {
        this.f6700a = bVar;
        this.f6701b = aVar;
    }

    public p0 a(String str) {
        b bVar = this.f6700a.get(str);
        if (bVar != null) {
            return bVar.a();
        }
        synchronized (this.f6700a) {
            b bVar2 = this.f6700a.get(str);
            if (bVar2 != null) {
                p0 a5 = bVar2.a();
                return a5;
            }
            b build = this.f6701b.get().a(str).build();
            p0 a6 = build.a();
            this.f6700a.put(str, build);
            return a6;
        }
    }
}
