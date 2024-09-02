package o3;

import com.yalantis.ucrop.BuildConfig;
import java.io.Serializable;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import o3.g;
import v3.p;

public final class c implements g, Serializable {

    /* renamed from: e  reason: collision with root package name */
    private final g f6155e;

    /* renamed from: f  reason: collision with root package name */
    private final g.b f6156f;

    static final class a extends l implements p<String, g.b, String> {

        /* renamed from: e  reason: collision with root package name */
        public static final a f6157e = new a();

        a() {
            super(2);
        }

        /* renamed from: a */
        public final String invoke(String str, g.b bVar) {
            k.e(str, "acc");
            k.e(bVar, "element");
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    public c(g gVar, g.b bVar) {
        k.e(gVar, "left");
        k.e(bVar, "element");
        this.f6155e = gVar;
        this.f6156f = bVar;
    }

    private final boolean a(g.b bVar) {
        return k.a(d(bVar.getKey()), bVar);
    }

    private final boolean c(c cVar) {
        while (a(cVar.f6156f)) {
            g gVar = cVar.f6155e;
            if (gVar instanceof c) {
                cVar = (c) gVar;
            } else {
                k.c(gVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return a((g.b) gVar);
            }
        }
        return false;
    }

    private final int f() {
        int i5 = 2;
        c cVar = this;
        while (true) {
            g gVar = cVar.f6155e;
            cVar = gVar instanceof c ? (c) gVar : null;
            if (cVar == null) {
                return i5;
            }
            i5++;
        }
    }

    public <E extends g.b> E d(g.c<E> cVar) {
        k.e(cVar, "key");
        c cVar2 = this;
        while (true) {
            E d5 = cVar2.f6156f.d(cVar);
            if (d5 != null) {
                return d5;
            }
            g gVar = cVar2.f6155e;
            if (!(gVar instanceof c)) {
                return gVar.d(cVar);
            }
            cVar2 = (c) gVar;
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.f() != f() || !cVar.c(this)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public g h(g.c<?> cVar) {
        k.e(cVar, "key");
        if (this.f6156f.d(cVar) != null) {
            return this.f6155e;
        }
        g h5 = this.f6155e.h(cVar);
        return h5 == this.f6155e ? this : h5 == h.f6161e ? this.f6156f : new c(h5, this.f6156f);
    }

    public int hashCode() {
        return this.f6155e.hashCode() + this.f6156f.hashCode();
    }

    public g n(g gVar) {
        return g.a.a(this, gVar);
    }

    public <R> R q(R r5, p<? super R, ? super g.b, ? extends R> pVar) {
        k.e(pVar, "operation");
        return pVar.invoke(this.f6155e.q(r5, pVar), this.f6156f);
    }

    public String toString() {
        return '[' + ((String) q(BuildConfig.FLAVOR, a.f6157e)) + ']';
    }
}
