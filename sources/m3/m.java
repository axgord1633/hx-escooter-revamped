package m3;

import java.io.Serializable;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import v3.a;

final class m<T> implements e<T>, Serializable {

    /* renamed from: e  reason: collision with root package name */
    private a<? extends T> f5900e;

    /* renamed from: f  reason: collision with root package name */
    private volatile Object f5901f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f5902g;

    public m(a<? extends T> aVar, Object obj) {
        k.e(aVar, "initializer");
        this.f5900e = aVar;
        this.f5901f = o.f5903a;
        this.f5902g = obj == null ? this : obj;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(a aVar, Object obj, int i5, g gVar) {
        this(aVar, (i5 & 2) != 0 ? null : obj);
    }

    public T getValue() {
        T t5;
        T t6 = this.f5901f;
        T t7 = o.f5903a;
        if (t6 != t7) {
            return t6;
        }
        synchronized (this.f5902g) {
            t5 = this.f5901f;
            if (t5 == t7) {
                a aVar = this.f5900e;
                k.b(aVar);
                t5 = aVar.invoke();
                this.f5901f = t5;
                this.f5900e = null;
            }
        }
        return t5;
    }

    public boolean isInitialized() {
        return this.f5901f != o.f5903a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
