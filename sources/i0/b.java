package i0;

import java.util.Map;
import kotlin.jvm.internal.k;
import m3.n;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private final c f4880a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4881b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4882c;

    /* renamed from: d  reason: collision with root package name */
    private final String f4883d;

    public b(c cVar, String str, String str2, String str3) {
        k.e(cVar, "mapType");
        k.e(str, "mapName");
        k.e(str2, "packageName");
        k.e(str3, "urlPrefix");
        this.f4880a = cVar;
        this.f4881b = str;
        this.f4882c = str2;
        this.f4883d = str3;
    }

    public final c a() {
        return this.f4880a;
    }

    public final String b() {
        return this.f4882c;
    }

    public final Map<String, String> c() {
        return e0.e(n.a("mapType", this.f4880a.name()), n.a("mapName", this.f4881b), n.a("packageName", this.f4882c), n.a("urlPrefix", this.f4883d));
    }
}
