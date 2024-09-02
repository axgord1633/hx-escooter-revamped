package w;

import androidx.lifecycle.a0;
import kotlin.jvm.internal.k;
import v3.l;

public final class f<T extends a0> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<T> f7287a;

    /* renamed from: b  reason: collision with root package name */
    private final l<a, T> f7288b;

    public f(Class<T> cls, l<? super a, ? extends T> lVar) {
        k.e(cls, "clazz");
        k.e(lVar, "initializer");
        this.f7287a = cls;
        this.f7288b = lVar;
    }

    public final Class<T> a() {
        return this.f7287a;
    }

    public final l<a, T> b() {
        return this.f7288b;
    }
}
