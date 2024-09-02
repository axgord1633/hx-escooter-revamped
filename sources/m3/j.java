package m3;

import java.io.Serializable;
import kotlin.jvm.internal.k;

public final class j<A, B> implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    private final A f5896e;

    /* renamed from: f  reason: collision with root package name */
    private final B f5897f;

    public j(A a5, B b5) {
        this.f5896e = a5;
        this.f5897f = b5;
    }

    public static /* synthetic */ j d(j jVar, A a5, B b5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            a5 = jVar.f5896e;
        }
        if ((i5 & 2) != 0) {
            b5 = jVar.f5897f;
        }
        return jVar.c(a5, b5);
    }

    public final A a() {
        return this.f5896e;
    }

    public final B b() {
        return this.f5897f;
    }

    public final j<A, B> c(A a5, B b5) {
        return new j<>(a5, b5);
    }

    public final A e() {
        return this.f5896e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return k.a(this.f5896e, jVar.f5896e) && k.a(this.f5897f, jVar.f5897f);
    }

    public final B f() {
        return this.f5897f;
    }

    public int hashCode() {
        A a5 = this.f5896e;
        int i5 = 0;
        int hashCode = (a5 == null ? 0 : a5.hashCode()) * 31;
        B b5 = this.f5897f;
        if (b5 != null) {
            i5 = b5.hashCode();
        }
        return hashCode + i5;
    }

    public String toString() {
        return '(' + this.f5896e + ", " + this.f5897f + ')';
    }
}
