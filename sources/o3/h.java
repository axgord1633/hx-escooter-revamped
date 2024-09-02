package o3;

import java.io.Serializable;
import kotlin.jvm.internal.k;
import o3.g;
import v3.p;

public final class h implements g, Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final h f6161e = new h();

    private h() {
    }

    public <E extends g.b> E d(g.c<E> cVar) {
        k.e(cVar, "key");
        return null;
    }

    public g h(g.c<?> cVar) {
        k.e(cVar, "key");
        return this;
    }

    public int hashCode() {
        return 0;
    }

    public g n(g gVar) {
        k.e(gVar, "context");
        return gVar;
    }

    public <R> R q(R r5, p<? super R, ? super g.b, ? extends R> pVar) {
        k.e(pVar, "operation");
        return r5;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
