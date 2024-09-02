package v0;

import u0.a;
import u0.a.d;
import w0.o;

public final class b<O extends a.d> {

    /* renamed from: a  reason: collision with root package name */
    private final int f7108a;

    /* renamed from: b  reason: collision with root package name */
    private final a f7109b;

    /* renamed from: c  reason: collision with root package name */
    private final a.d f7110c;

    /* renamed from: d  reason: collision with root package name */
    private final String f7111d;

    private b(a aVar, a.d dVar, String str) {
        this.f7109b = aVar;
        this.f7110c = dVar;
        this.f7111d = str;
        this.f7108a = o.b(aVar, dVar, str);
    }

    public static <O extends a.d> b<O> a(a<O> aVar, O o5, String str) {
        return new b<>(aVar, o5, str);
    }

    public final String b() {
        return this.f7109b.b();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return o.a(this.f7109b, bVar.f7109b) && o.a(this.f7110c, bVar.f7110c) && o.a(this.f7111d, bVar.f7111d);
    }

    public final int hashCode() {
        return this.f7108a;
    }
}
